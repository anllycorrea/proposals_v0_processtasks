package com.bbva.pzic.proposals.util.connection;

import com.bbva.jee.arq.spring.core.rest.RestConnector;
import com.bbva.jee.arq.spring.core.rest.RestConnectorResponse;
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
    protected ServiceInvocationContext serviceInvocationContext;

    @Autowired
    protected RestConnector restConnector;

    protected String backend;

    @Autowired
    private ConfigurationManager configurationManager;

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

    protected <S> S evaluateResponse(final RestConnectorResponse rcr, final int actualTypeArgumentIndex) {
        if (rcr == null) {
            LOG.error("com.bbva.jee.arq.spring.core.rest.RestConnectorResponse is null for SocketTimeoutException");
            throw new BusinessServiceException(Errors.TECHNICAL_ERROR);
        }

        if (rcr.getStatusCode() >= HttpStatus.SC_OK && rcr.getStatusCode() <= HttpStatus.SC_MULTI_STATUS) {
            try {
                final ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
                final Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                @SuppressWarnings("unchecked")
                final Class<S> valueType = (Class<S>) actualTypeArguments[actualTypeArgumentIndex];
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
        String errorMessage = responseHeaders.get("errorMessage");

        if (errorMessage == null) {
            LOG.error("Can't create an exception with null errorMessage");
            throw new BusinessServiceException(Errors.TECHNICAL_ERROR);
        }

        LOG.info(String.format("Creating exception with errorMessage: '%s'", errorMessage));

        BusinessServiceException businessServiceException = new BusinessServiceException(Errors.FUNCTIONAL_ERROR);
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
