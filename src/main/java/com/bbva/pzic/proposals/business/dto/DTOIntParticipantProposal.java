package com.bbva.pzic.proposals.business.dto;

import javax.validation.constraints.NotNull;
import javax.validation.Valid;

/**
 * Created on 15/11/2019.
 * 
 * @author Entelgy
 */
public class DTOIntParticipantProposal {

	@NotNull(groups = ValidationGroup.CreateQuestionnairesValidateAccess.class)
	private String id;
	@Valid
	private DTOIntIdentityDocument identityDocument;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public DTOIntIdentityDocument getIdentityDocument() {
		return identityDocument;
	}

	public void setIdentityDocument(DTOIntIdentityDocument identityDocument) {
		this.identityDocument = identityDocument;
	}
}