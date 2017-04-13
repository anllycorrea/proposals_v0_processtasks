package com.bbva.pzic.proposals.business.dto;


import java.math.BigDecimal;
import javax.validation.constraints.NotNull;

/**
 * Created on 12/04/2017.
 * 
 * @author Entelgy
 */
public class DTOIntInitialAmount {

	@NotNull(groups = ValidationGroup.CreateExternalFinancingProposal.class)
	private BigDecimal amount;
	@NotNull(groups = ValidationGroup.CreateExternalFinancingProposal.class)
	private String currency;

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
}