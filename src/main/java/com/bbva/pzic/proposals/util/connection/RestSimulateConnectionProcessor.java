package com.bbva.pzic.proposals.util.connection;

import com.bbva.jee.arq.spring.core.rest.RestConnectorResponse;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.pzic.proposals.dao.model.simulateproposals.Oferta;
import com.bbva.pzic.proposals.util.Errors;
import com.fasterxml.jackson.core.type.TypeReference;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created on 12/05/2020.
 *
 * @author Entelgy.
 */
public class RestSimulateConnectionProcessor extends RestConnectionProcessor {

    private static final Log LOG = LogFactory.getLog(RestSimulateConnectionProcessor.class);

    protected <S> List<Oferta> buildResponse(final RestConnectorResponse rcr) {
        if (rcr == null) {
            LOG.error("com.bbva.jee.arq.spring.core.rest.RestConnectorResponse is null for SocketTimeoutException");
            throw new BusinessServiceException(Errors.TECHNICAL_ERROR);
        }

        if (rcr.getStatusCode() >= HttpStatus.SC_OK && rcr.getStatusCode() <= HttpStatus.SC_MULTI_STATUS) {
            try {
                String response = rcr.getResponseBody();
                if (response == null) {
                    return null;
                }
                return mapperHelper.readValue(response, new TypeReference<List<Oferta>>() {
                });
            } catch (IOException e) {
                LOG.error(String.format("Error converting JSON: %s", e.getMessage()));
                throw new BusinessServiceException(Errors.TECHNICAL_ERROR, e);
            }
        } else {
            throw restConnectorResponseToError(rcr.getHeaders());
        }
    }
}