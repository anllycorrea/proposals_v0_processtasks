package com.bbva.pzic.proposals.facade.v0;

import java.lang.String;
import com.bbva.pzic.proposals.canonic.Proposals;

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
	Proposals listProposals(String participantIdentityDocumentDocumentTypeId,
			String participantIdentityDocumentDocumentNumber, String customerId);
}