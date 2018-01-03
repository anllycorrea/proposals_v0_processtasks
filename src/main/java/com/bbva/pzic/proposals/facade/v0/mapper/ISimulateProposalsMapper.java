package com.bbva.pzic.proposals.facade.v0.mapper;

import com.bbva.pzic.proposals.business.dto.DTOIntSimulatedProposal;
import com.bbva.pzic.proposals.canonic.SimulatedProposal;

/**
 * Created on 28/12/2017.
 *
 * @author Entelgy
 */
public interface ISimulateProposalsMapper {

    DTOIntSimulatedProposal mapIn(SimulatedProposal simulatedProposal);
}