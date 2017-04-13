package com.bbva.pzic.proposals.business.dto;


import javax.validation.constraints.NotNull;
import javax.validation.Valid;

/**
 * Created on 12/04/2017.
 * 
 * @author Entelgy
 */
public class DTOIntOperation {

	@NotNull(groups = ValidationGroup.CreateExternalFinancingProposal.class)
	private String id;
	@Valid
	private DTOIntOperationType operationType;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public DTOIntOperationType getOperationType() {
		return operationType;
	}

	public void setOperationType(DTOIntOperationType operationType) {
		this.operationType = operationType;
	}
}