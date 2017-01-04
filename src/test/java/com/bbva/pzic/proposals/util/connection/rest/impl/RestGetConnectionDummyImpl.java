package com.bbva.pzic.proposals.util.connection.rest.impl;

import com.bbva.pzic.proposals.canonic.Proposal;
import com.bbva.pzic.proposals.util.connection.rest.RestGetConnection;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 27/06/2016.
 *
 * @author Entelgy
 */
@Repository
public class RestGetConnectionDummyImpl extends RestGetConnection<Proposal> {

    public Proposal invoke(final String urlPropertyValue) {
        return connect(urlPropertyValue, null);
    }

    public Proposal invokeWithPathParams(final String urlPropertyValue) {
        Map<String, String> pathParams = new HashMap<String, String>();
        pathParams.put("key1", "value1");
        pathParams.put("key2", "value2");

        return connect(urlPropertyValue, pathParams, null);
    }

    public Proposal invokeWithQueryParams(final String urlPropertyValue) {
        HashMap<String, String> queryParams = new HashMap<String, String>();
        queryParams.put("key1", "value1");
        queryParams.put("key2", "value2");

        return connect(urlPropertyValue, null, queryParams);
    }
}