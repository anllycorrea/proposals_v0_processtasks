package com.bbva.pzic.proposals.util.connection;

import com.bbva.jee.arq.spring.core.rest.IProxyRestConnector;
import com.bbva.jee.arq.spring.core.rest.RestConnectorFactory;
import com.bbva.jee.arq.spring.core.rest.RestConnectorResponse;
import com.bbva.jee.arq.spring.core.rest.RestConnectorType;
import com.bbva.jee.arq.spring.core.servicing.configuration.ConfigurationManager;
import com.bbva.jee.arq.spring.core.servicing.context.BackendContext;
import com.bbva.jee.arq.spring.core.servicing.context.ServiceInvocationContext;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.jee.arq.spring.core.servicing.gce.xml.instance.ErrorSeverity;
import com.bbva.jee.arq.spring.core.servicing.gce.xml.instance.Message;
import com.bbva.pzic.proposals.dao.model.simulateproposals.Oferta;
import com.bbva.pzic.proposals.util.Errors;
import com.bbva.pzic.proposals.util.helper.ObjectMapperHelper;
import com.fasterxml.jackson.core.type.TypeReference;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created on 14/06/2016.
 *
 * @author Entelgy
 */
public class RestSimulateConnectionProcessor {

    private static final Log LOG = LogFactory.getLog(RestSimulateConnectionProcessor.class);

    private static final String BACKEND_ID_PROPERTY = "servicing.connector.rest.backend.id";

    @Autowired
    private RestConnectorFactory restConnectorFactory;
    protected IProxyRestConnector restConnector;
    protected boolean useProxy;
    @Autowired
    protected ConfigurationManager configurationManager;
    @Autowired
    private ServiceInvocationContext serviceInvocationContext;

    private ObjectMapperHelper mapper = ObjectMapperHelper.getInstance();

    @PostConstruct
    private void init() {
        String backend = getProperty(BACKEND_ID_PROPERTY);
        restConnector = (IProxyRestConnector) restConnectorFactory.getRestConnector(RestConnectorType.BASIC, backend);
    }

    protected String getProperty(final String property) {
        String value = configurationManager.getProperty(property);
        LOG.debug(String.format("[Rest Connector] Loaded property '%s = %s'", property, value));
        return value;
    }

    protected String buildPayload(final Object entityPayload) {
        try {
            String payload = mapper.writeValueAsString(entityPayload);
            LOG.debug("[Rest Connector] Payload=" + payload);
            return payload;
        } catch (IOException e) {
            LOG.error(String.format("Error converting JSON: %s", e.getMessage()), e);
            throw new BusinessServiceException(Errors.TECHNICAL_ERROR, e);
        }
    }

    protected HashMap<String, String> buildOptionalHeaders() {
        String callingChannel = serviceInvocationContext.getProperty(BackendContext.CALLING_CHANNEL);

        if (callingChannel == null) {
            LOG.info("No se han podido capturar el valor CALLING_CHANNEL");
            return null;
        }
        HashMap<String, String> optionalHeaders = new HashMap<>();
        LOG.info(String.format("Se ha capturado el CALLING_CHANNEL '%s'", callingChannel));
        optionalHeaders.put("callingChannel", callingChannel);
        return optionalHeaders;
    }

    protected <S> List<Oferta> buildResponse(final RestConnectorResponse rcr, final int actualTypeArgumentIndex) {
        if (rcr == null) {
            LOG.error("com.bbva.jee.arq.spring.core.rest.RestConnectorResponse is null for SocketTimeoutException");
            throw new BusinessServiceException(Errors.TECHNICAL_ERROR);
        }
        try {
            if (rcr.getResponseBody() == null) {
                return null;
            }
            return mapper.readValue(rcr.getResponseBody(), new TypeReference<List<Oferta>>() {
            });
        } catch (IOException e) {
            LOG.error(String.format("Error converting JSON: %s", e.getMessage()));
            throw new BusinessServiceException(Errors.TECHNICAL_ERROR, e);
        }
    }

    protected void evaluateMessagesResponse(final List<Message> messages, final String smcRegistryId, final int statusCode) {
        Message firstMessage = null;
        if (CollectionUtils.isNotEmpty(messages)) {
            firstMessage = messages.get(0);
        }

        if (statusCode / 100 == 4 || statusCode / 100 == 5) {
            generateServiceException(firstMessage, smcRegistryId);
        } else if (statusCode / 100 == 2 &&
                firstMessage != null && ErrorSeverity.WARNING.equals(firstMessage.getType())) {
            serviceInvocationContext.setWarning(firstMessage.getCode(), firstMessage.getMessage());
        }
    }

    private void generateServiceException(final Message message, final String smcRegistryId) {
        if (StringUtils.isEmpty(smcRegistryId)) {
            LOG.error("smcRegistryId is not defined");
            throw new BusinessServiceException(Errors.TECHNICAL_ERROR);
        }
        if (message == null || StringUtils.isEmpty(message.getCode())) {
            LOG.error("backendErrorCode is not defined");
            throw new BusinessServiceException(Errors.TECHNICAL_ERROR);
        }

        String errorAlias = getProperty(String.format("servicing.smc.configuration.%s.backend.error.code.%s", smcRegistryId, message.getCode()));
        if (errorAlias == null) {
            BusinessServiceException businessServiceException = new BusinessServiceException(Errors.FUNCTIONAL_ERROR);
            if (message.getCode() != null) {
                businessServiceException.setErrorCode(message.getCode());
            }
            if (message.getMessage() != null) {
                businessServiceException.setErrorMessage(message.getMessage());
            }
            throw businessServiceException;
        } else {
            throw new BusinessServiceException(errorAlias);
        }
    }


    protected String replacePathParamToUrl(final String url, final Map<String, String> pathParams) {
        String helpUrl = url;
        for (Map.Entry<String, String> entry : pathParams.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            helpUrl = helpUrl.replace("{".concat(key).concat("}"), value);
        }
        return helpUrl;
    }
}
