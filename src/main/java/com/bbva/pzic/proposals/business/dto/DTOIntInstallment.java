package com.bbva.pzic.proposals.business.dto;



/**
 * Created on 28/12/2017.
 * 
 * @author Entelgy
 */
public class DTOIntInstallment {

	private String installmentType;
	private DTOIntPrincipal principal;

	public String getInstallmentType() {
		return installmentType;
	}

	public void setInstallmentType(String installmentType) {
		this.installmentType = installmentType;
	}

	public DTOIntPrincipal getPrincipal() {
		return principal;
	}

	public void setPrincipal(DTOIntPrincipal principal) {
		this.principal = principal;
	}
}