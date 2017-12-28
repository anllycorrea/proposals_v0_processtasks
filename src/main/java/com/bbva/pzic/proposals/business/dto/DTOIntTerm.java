package com.bbva.pzic.proposals.business.dto;


import java.math.BigDecimal;

/**
 * Created on 28/12/2017.
 * 
 * @author Entelgy
 */
public class DTOIntTerm {

	private String frequency;
	private BigDecimal value;

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}
}