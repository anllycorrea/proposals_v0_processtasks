package com.bbva.pzic.proposals.util.connection;

import com.bbva.jee.arq.spring.core.rest.RestConnector;
import com.bbva.jee.arq.spring.core.rest.RestConnectorResponse;
import com.bbva.jee.arq.spring.core.servicing.configuration.ConfigurationManager;
import com.bbva.jee.arq.spring.core.servicing.context.BackendContext;
import com.bbva.jee.arq.spring.core.servicing.context.ServiceInvocationContext;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.pzic.proposals.dao.model.simulateproposals.Oferta;
import com.bbva.pzic.proposals.util.Errors;
import com.bbva.pzic.proposals.util.helper.ObjectMapperHelper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
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
    protected RestConnector restConnector;
    protected String backend;
    protected boolean useProxy;
    @Autowired
    protected ConfigurationManager configurationManager;
    @Autowired
    private ServiceInvocationContext serviceInvocationContext;
    @Autowired
    private ObjectMapperHelper mapper;

    @PostConstruct
    private void init() {
        backend = configurationManager.getProperty(BACKEND_ID_PROPERTY);
    }

    protected String getProperty(final String property) {
        return configurationManager.getProperty(property);
    }

    protected String buildPayload(final Object entityPayload) {
        try {
            String payload = mapper.writeValueAsString(entityPayload);
            LOG.info("Payload generado: " + payload);
            return payload;
        } catch (JsonProcessingException e) {
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

    protected <S> List<Oferta> evaluateResponse(final RestConnectorResponse rcr, final int actualTypeArgumentIndex) {
        if (rcr == null) {
            LOG.error("com.bbva.jee.arq.spring.core.rest.RestConnectorResponse is null for SocketTimeoutException");
            throw new BusinessServiceException(Errors.TECHNICAL_ERROR);
        }

        if (rcr.getStatusCode() >= HttpStatus.SC_OK && rcr.getStatusCode() <= HttpStatus.SC_MULTI_STATUS) {
            try {
                final ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
                final Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                @SuppressWarnings("unchecked")
                final S valueType = (S) actualTypeArguments[actualTypeArgumentIndex];
                if (rcr.getResponseBody() == null) {
                    return null;
                }
                String response = rcr.getResponseBody();
                return mapper.readValues(response, new TypeReference<List<Oferta>>() {
                });
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
