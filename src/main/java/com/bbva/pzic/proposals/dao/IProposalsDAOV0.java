package com.bbva.pzic.proposals.dao;

import com.bbva.pzic.proposals.business.dto.DTOIntSimulatedProposal;
import com.bbva.pzic.proposals.business.dto.InputListProposals;
import com.bbva.pzic.proposals.canonic.Proposal;
import com.bbva.pzic.proposals.canonic.SimulatedProposalsData;

import java.util.List;

/**
 * Created on 28/12/2017.
 *
 * @author Entelgy
 */
public interface IProposalsDAOV0 {

    List<Proposal> listProposals(InputListProposals listProposals);

    SimulatedProposalsData simulateProposals(DTOIntSimulatedProposal simulatedProposal);
}
