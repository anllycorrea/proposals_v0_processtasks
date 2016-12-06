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
public class RestGetConnection<S> extends RestConnectionProcessor {

    private static final Log LOG = LogFactory.getLog(RestGetConnection.class);

    public S connect(final String urlPropertyValue, final HashMap<String, String> params) {
        return connect(urlPropertyValue, null, params);
    }

    public S connect(final String urlPropertyValue, final Map<String, String> pathParams, final HashMap<String, String> params) {
        String url = getProperty(urlPropertyValue);
        if (pathParams != null) {
            url = replacePathParamToUrl(url, pathParams);
        }

        if (params != null) {
            LOG.info("Request query params: " + Arrays.toString(params.entrySet().toArray()));
        }

        RestConnectorResponse rcr = restConnector.doGet(url, params, null, backend, false);

        return evaluateResponse(rcr, 0);
    }
}
