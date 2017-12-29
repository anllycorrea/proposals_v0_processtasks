package com.bbva.pzic.proposals.facade.v0.mapper;

import com.bbva.pzic.proposals.business.dto.DTOIntProposals;
import com.bbva.pzic.proposals.business.dto.InputListProposals;
import com.bbva.pzic.proposals.canonic.Proposals;

/**
 * Created on 28/12/2017.
 * 
 * @author Entelgy
 */
public interface IListProposalsMapperV0 {

	InputListProposals mapIn(String participantIdentityDocumentDocumentTypeId,
							 String participantIdentityDocumentDocumentNumber, String customerId);

	Proposals mapOut(DTOIntProposals dtoIntProposals);
}