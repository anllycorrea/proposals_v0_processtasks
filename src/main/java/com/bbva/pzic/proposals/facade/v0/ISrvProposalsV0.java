package com.bbva.pzic.proposals.facade.v0;

import com.bbva.pzic.proposals.canonic.Proposals;
import com.bbva.pzic.proposals.canonic.SimulatedProposal;
import com.bbva.pzic.proposals.canonic.SimulatedProposalsData;

/**
 * Created on 28/12/2017.
 * 
 * @author Entelgy
 */
public interface ISrvProposalsV0 {

	/**
	 * Service for retrieving the list of proposals related to a specific
	 * person.
	 * 
	 * @param participantIdentityDocumentDocumentTypeId
	 * @param participantIdentityDocumentDocumentNumber
	 * @param customerId
	 * @return {@link Proposals}
	 */
	Proposals listProposals(String documentTypeId,
			String documentNumber, String customerId);

	/**
	 * Service for simulating a set of proposals.
	 *
	 * @param simulatedProposal
	 *            payload
	 * @return {@link SimulatedProposalsData}
	 */
	SimulatedProposalsData simulateProposals(SimulatedProposal simulatedProposal);
}