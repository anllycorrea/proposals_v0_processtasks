package com.bbva.pzic.proposals.facade.v0.mapper;

import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponse;
import com.bbva.pzic.proposals.business.dto.DTOIntSimulatedProposal;
import com.bbva.pzic.proposals.business.dto.DTOIntSimulatedProposals;
import com.bbva.pzic.proposals.canonic.SimulatedProposal;

import java.util.List;

/**
 * Created on 28/12/2017.
 *
 * @author Entelgy
 */
public interface ISimulateProposalsMapper {

    DTOIntSimulatedProposal mapIn(SimulatedProposal simulatedProposal);

    ServiceResponse<List<SimulatedProposal>> mapOut(DTOIntSimulatedProposals dtoIntSimulateProposals);
}