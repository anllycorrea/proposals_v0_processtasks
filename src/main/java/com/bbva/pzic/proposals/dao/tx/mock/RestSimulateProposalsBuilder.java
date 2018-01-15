package com.bbva.pzic.proposals.dao.tx.mock;

import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.pzic.proposals.dao.model.simulateproposals.Oferta;
import com.bbva.pzic.proposals.util.Errors;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

/**
 * Created on 29/12/2017.
 *
 * @author Entelgy
 */
public class RestSimulateProposalsBuilder {

    private ObjectMapper mapper = new ObjectMapper();

    public List<Oferta> buildSimulatedProposalsResponse() {
        try {
            return mapper.readValue(Thread.currentThread().getContextClassLoader().getResourceAsStream(
                    "com/bbva/pzic/proposals/dao/mock/simulatedProposalsResponse.json"),
                    new TypeReference<List<Oferta>>() {
                    });
        } catch (IOException e) {
            throw new BusinessServiceException(Errors.TECHNICAL_ERROR, e);
        }
    }
}
