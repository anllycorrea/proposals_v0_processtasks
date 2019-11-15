package com.bbva.pzic.proposals.business.dto;

import javax.validation.constraints.NotNull;

/**
 * Created on 15/11/2019.
 * 
 * @author Entelgy
 */
public class DTOIntSubproductProposal {

	@NotNull(groups = ValidationGroup.CreateQuestionnairesValidateAccess.class)
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}