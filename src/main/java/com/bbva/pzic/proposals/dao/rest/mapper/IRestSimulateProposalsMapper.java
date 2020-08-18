package com.bbva.pzic.proposals.dao.rest.mapper;

import com.bbva.pzic.proposals.business.dto.DTOIntSimulatedProposal;
import com.bbva.pzic.proposals.business.dto.DTOIntSimulatedProposals;
import com.bbva.pzic.proposals.dao.model.simulateproposals.Oferta;
import com.bbva.pzic.proposals.dao.model.simulateproposals.SimulatedProposalRequest;

import java.util.List;

/**
 * Created on 28/12/2017.
 *
 * @author Entelgy
 */
public interface IRestSimulateProposalsMapper {

    SimulatedProposalRequest mapIn(DTOIntSimulatedProposal dtoIn);

    DTOIntSimulatedProposals mapOut(List<Oferta> response);
}