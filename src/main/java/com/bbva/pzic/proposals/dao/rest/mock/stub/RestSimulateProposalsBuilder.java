package com.bbva.pzic.proposals.dao.rest.mock.stub;

import com.bbva.pzic.proposals.dao.model.simulateproposals.SimulatedProposalsResponse;
import com.bbva.pzic.proposals.util.helper.ObjectMapperHelper;

import java.io.IOException;

/**
 * Created on 29/12/2017.
 *
 * @author Entelgy
 */
public class RestSimulateProposalsBuilder {

    private ObjectMapperHelper mapper = ObjectMapperHelper.getInstance();

    public SimulatedProposalsResponse buildSimulatedProposalsResponse() throws IOException {
        return mapper.readValue(Thread.currentThread().getContextClassLoader().getResourceAsStream(
                "com/bbva/pzic/proposals/dao/mock/simulatedProposalsResponse.json"), SimulatedProposalsResponse.class);
    }

    public SimulatedProposalsResponse buildMessages() throws IOException {
        return mapper.readValue(Thread.currentThread().getContextClassLoader().getResourceAsStream(
                "com/bbva/pzic/proposals/dao/mock/response_error_messages.json"), SimulatedProposalsResponse.class);
    }
}
