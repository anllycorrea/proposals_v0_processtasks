package com.bbva.pzic.proposals.dao;

import com.bbva.pzic.proposals.business.dto.DTOIntProposals;
import com.bbva.pzic.proposals.business.dto.DTOIntSimulatedProposal;
import com.bbva.pzic.proposals.business.dto.InputListProposals;
import com.bbva.pzic.proposals.canonic.SimulatedProposalsData;

/**
 * Created on 28/12/2017.
 *
 * @author Entelgy
 */
public interface IProposalsDAOV0 {

    DTOIntProposals listProposals(InputListProposals listProposals);

    SimulatedProposalsData simulateProposals(DTOIntSimulatedProposal simulatedProposal);
}
