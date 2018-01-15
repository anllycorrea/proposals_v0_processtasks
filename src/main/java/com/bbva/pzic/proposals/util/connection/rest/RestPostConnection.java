package com.bbva.pzic.proposals.util.connection.rest;

import com.bbva.jee.arq.spring.core.rest.RestConnectorResponse;
import com.bbva.pzic.proposals.dao.model.simulateproposals.Oferta;
import com.bbva.pzic.proposals.util.connection.RestSimulateConnectionProcessor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;

/**
 * Created on 22/06/2016.
 *
 * @author Entelgy
 */
public class RestPostConnection<P> extends RestSimulateConnectionProcessor {

    public List<Oferta> connect(final String urlPropertyValue, final P entityPayload) {
        String url = getProperty(urlPropertyValue);
        String payload = buildPayload(entityPayload);

        RestConnectorResponse rcr = restConnector.doPost(url, null, buildOptionalHeaders(), payload, backend, useProxy);

        return evaluateResponse(rcr);
    }
}
