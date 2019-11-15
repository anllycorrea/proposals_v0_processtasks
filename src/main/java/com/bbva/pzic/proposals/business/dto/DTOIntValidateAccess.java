package com.bbva.pzic.proposals.business.dto;

import javax.validation.constraints.NotNull;
import javax.validation.Valid;

/**
 * Created on 15/11/2019.
 * 
 * @author Entelgy
 */
public class DTOIntValidateAccess {

	@NotNull(groups = ValidationGroup.CreateQuestionnairesValidateAccess.class)
	@Valid
	private DTOIntParticipantProposal participant;
	@Valid
	private DTOIntProductProposal product;

	public DTOIntParticipantProposal getParticipant() {
		return participant;
	}

	public void setParticipant(DTOIntParticipantProposal participant) {
		this.participant = participant;
	}

	public DTOIntProductProposal getProduct() {
		return product;
	}

	public void setProduct(DTOIntProductProposal product) {
		this.product = product;
	}
}