package com.bbva.pzic.proposals.dao.tx;

import com.bbva.pzic.proposals.business.dto.DTOIntSimulatedProposal;
import com.bbva.pzic.proposals.canonic.SimulatedProposalsData;
import com.bbva.pzic.proposals.dao.model.simulateproposals.SimulatedProposalRequest;
import com.bbva.pzic.proposals.dao.model.simulateproposals.SimulatedProposalsResponse;
import com.bbva.pzic.proposals.dao.tx.mapper.IRestSimulateProposalsMapper;
import com.bbva.pzic.proposals.util.connection.rest.RestPostConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created on 28/12/2017.
 *
 * @author Entelgy
 */
@Component
public class RestSimulateProposals extends RestPostConnection<SimulatedProposalRequest, SimulatedProposalsResponse> {

    private static final String POST_SIMULATE_PROPOSALS_URL_PROPOSALS = "servicing.url.proposals.simulateProposals";

    @Autowired
    private IRestSimulateProposalsMapper mapper;

    public SimulatedProposalsData invoke(DTOIntSimulatedProposal dtoIn) {
        return mapper.mapOut(connect(POST_SIMULATE_PROPOSALS_URL_PROPOSALS, mapper.mapIn(dtoIn)));
    }
}