package com.bbva.pzic.proposals.dao.rest;

import com.bbva.pzic.proposals.business.dto.DTOIntSimulatedProposal;
import com.bbva.pzic.proposals.business.dto.DTOIntSimulatedProposals;
import com.bbva.pzic.proposals.dao.model.simulateproposals.SimulatedProposalRequest;
import com.bbva.pzic.proposals.dao.model.simulateproposals.SimulatedProposalsResponse;
import com.bbva.pzic.proposals.dao.rest.mapper.IRestSimulateProposalsMapper;
import com.bbva.pzic.proposals.util.connection.rest.RestPostConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created on 28/12/2017.
 *
 * @author Entelgy
 */
@Component
public class RestSimulateProposals extends RestPostConnection<SimulatedProposalRequest, SimulatedProposalsResponse> {

    private static final String POST_SIMULATE_PROPOSALS_URL_PROPOSALS = "servicing.url.proposals.simulateProposals";
    private static final String POST_SIMULATE_PROPOSALS_PROXY_PROPOSALS = "servicing.proxy.proposals.simulateProposals";

    @Autowired
    private IRestSimulateProposalsMapper mapper;

    @PostConstruct
    public void init() {
        useProxy = configurationManager.getBooleanProperty(POST_SIMULATE_PROPOSALS_PROXY_PROPOSALS, false);
    }

    public DTOIntSimulatedProposals invoke(final DTOIntSimulatedProposal dtoIn) {
        return mapper.mapOut(connect(POST_SIMULATE_PROPOSALS_URL_PROPOSALS, mapper.mapIn(dtoIn)));
    }

    @Override
    protected void evaluateResponse(final SimulatedProposalsResponse response, final int statusCode) {
        evaluateMessagesResponse(response.getMessages(), "SMCPE1720158", statusCode);
    }
}