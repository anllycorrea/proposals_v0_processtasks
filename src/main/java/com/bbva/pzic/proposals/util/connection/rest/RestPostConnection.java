package com.bbva.pzic.proposals.util.connection.rest;

import com.bbva.jee.arq.spring.core.rest.RestConnectorResponse;
import com.bbva.pzic.proposals.util.connection.RestConnectionProcessor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created on 22/06/2016.
 *
 * @author Entelgy
 */
public class RestPostConnection<P, S> extends RestConnectionProcessor {

    private static final Log LOG = LogFactory.getLog(RestPostConnection.class);

    public S connect(final String urlPropertyValue, final P entityPayload) {
        return connect(urlPropertyValue, null, null, entityPayload);
    }

    public S connect(final String urlPropertyValue, final Map<String, String> pathParams, final P entityPayload) {
        return connect(urlPropertyValue, pathParams, null, entityPayload);
    }

    public S connect(final String urlPropertyValue, final Map<String, String> pathParams, final HashMap<String, String> params, final P entityPayload) {
        String url = getProperty(urlPropertyValue);
        String payload = buildPayload(entityPayload);

        if (pathParams != null) {
            url = replacePathParamToUrl(url, pathParams);
        }

        if (params != null) {
            LOG.info("Request query params: " + Arrays.toString(params.entrySet().toArray()));
        }

        RestConnectorResponse rcr = restConnector.doPost(url, params, buildOptionalHeaders(), payload, backend, false);

        return evaluateResponse(rcr, 1);
    }
}
