package com.bbva.pzic.proposals.business.dto;


import javax.validation.constraints.NotNull;

/**
 * Created on 12/04/2017.
 * 
 * @author Entelgy
 */
public class DTOIntDocumentType {

	@NotNull(groups = ValidationGroup.CreateExternalFinancingProposal.class)
	private String id;
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}