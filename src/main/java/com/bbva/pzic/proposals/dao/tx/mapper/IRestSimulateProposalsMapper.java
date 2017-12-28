package com.bbva.pzic.proposals.dao.tx.mapper;

import com.bbva.pzic.proposals.business.dto.DTOIntSimulatedProposal;
import com.bbva.pzic.proposals.canonic.SimulatedProposalsData;
import com.bbva.pzic.proposals.dao.model.simulateproposals.SimulatedProposalRequest;
import com.bbva.pzic.proposals.dao.model.simulateproposals.SimulatedProposalsResponse;

/**
 * Created on 28/12/2017.
 *
 * @author Entelgy
 */
public interface IRestSimulateProposalsMapper {

    SimulatedProposalRequest mapIn(DTOIntSimulatedProposal dtoIn);

    SimulatedProposalsData mapOut(SimulatedProposalsResponse response);
}