package com.bbva.pzic.proposals.util.connection.rest;

import com.bbva.jee.arq.spring.core.rest.RestConnectorResponse;
import com.bbva.pzic.proposals.dao.model.simulateproposals.Oferta;
import com.bbva.pzic.proposals.util.connection.RestSimulateConnectionProcessor;

import java.util.List;

/**
 * Created on 22/06/2016.
 *
 * @author Entelgy
 */
public abstract class RestPostConnection<P> extends RestSimulateConnectionProcessor {

    public List<Oferta> connect(final String urlPropertyValue, final P entityPayload) {
        String url = getProperty(urlPropertyValue);
        String payload = buildPayload(entityPayload);

        RestConnectorResponse rcr = restConnector.doPost(url, null, buildOptionalHeaders(), payload, useProxy);

        List<Oferta> response = buildResponse(rcr, 1);

        evaluateResponse(response, rcr.getStatusCode());

        return response;
    }

    protected abstract void evaluateResponse(List<Oferta> response, int statusCode);
}
