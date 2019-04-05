package com.bbva.pzic.proposals.util.connection;

import com.bbva.jee.arq.spring.core.rest.IProxyRestConnector;
import com.bbva.jee.arq.spring.core.rest.RestConnectorFactory;
import com.bbva.jee.arq.spring.core.rest.RestConnectorResponse;
import com.bbva.jee.arq.spring.core.rest.RestConnectorType;
import com.bbva.jee.arq.spring.core.servicing.configuration.ConfigurationManager;
import com.bbva.jee.arq.spring.core.servicing.context.BackendContext;
import com.bbva.jee.arq.spring.core.servicing.context.ServiceInvocationContext;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.pzic.proposals.util.Errors;
import com.bbva.pzic.proposals.util.helper.ObjectMapperHelper;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * Created on 14/06/2016.
 *
 * @author Entelgy
 */
public class RestConnectionProcessor {

    private static final Log LOG = LogFactory.getLog(RestConnectionProcessor.class);

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
        LOG.info(String.format("Initializing Proxy Rest Connector for %s with backend %s", getClass(), backend));
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

    protected <S> S evaluateResponse(final RestConnectorResponse rcr, final int actualTypeArgumentIndex) {
        if (rcr == null) {
            LOG.error("com.bbva.jee.arq.spring.core.rest.RestConnectorResponse is null for SocketTimeoutException");
            throw new BusinessServiceException(Errors.TECHNICAL_ERROR);
        }

        if (rcr.getStatusCode() >= HttpStatus.SC_OK && rcr.getStatusCode() <= HttpStatus.SC_MULTI_STATUS) {
            try {
                final ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
                final Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                @SuppressWarnings("unchecked") final Class<S> valueType = (Class<S>) actualTypeArguments[actualTypeArgumentIndex];
                if (rcr.getResponseBody() == null) {
                    try {
                        return valueType.newInstance();
                    } catch (InstantiationException | IllegalAccessException e) {
                        throw new BusinessServiceException(Errors.TECHNICAL_ERROR, e);
                    }
                }
                return mapper.readValue(rcr.getResponseBody(), valueType);
            } catch (IOException e) {
                LOG.error(String.format("Error converting JSON: %s", e.getMessage()));
                throw new BusinessServiceException(Errors.TECHNICAL_ERROR, e);
            }
        } else {
            throw restConnectorResponseToError(rcr.getHeaders());
        }
    }

    private BusinessServiceException restConnectorResponseToError(final Map<String, String> responseHeaders) {
        String errorCode = responseHeaders.get("errorCode");
        String errorMessage = responseHeaders.get("errorMessage");

        if (errorCode == null || errorMessage == null) {
            LOG.error("Can't create an exception with null errorCode or errorMessage");
            throw new BusinessServiceException(Errors.TECHNICAL_ERROR);
        }

        LOG.info(String.format("Creating exception with errorMessage: '%s'", errorMessage));

        BusinessServiceException businessServiceException = new BusinessServiceException(Errors.FUNCTIONAL_ERROR);
        businessServiceException.setErrorMessage(errorCode);
        businessServiceException.setErrorMessage(errorMessage);
        return businessServiceException;
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
