package com.bbva.pzic.proposals.business.dto;


import java.math.BigDecimal;

/**
 * Created on 28/12/2017.
 * 
 * @author Entelgy
 */
public class DTOIntProposal {

	private String id;
	private DTOIntTerm term;
	private DTOIntProduct product;
	private DTOIntGrantedAmount grantedAmount;
	private DTOIntInstallmentPayment installmentPayment;
	private BigDecimal interestAnnualRate;
	private BigDecimal interestRate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public DTOIntTerm getTerm() {
		return term;
	}

	public void setTerm(DTOIntTerm term) {
		this.term = term;
	}

	public DTOIntProduct getProduct() {
		return product;
	}

	public void setProduct(DTOIntProduct product) {
		this.product = product;
	}

	public DTOIntGrantedAmount getGrantedAmount() {
		return grantedAmount;
	}

	public void setGrantedAmount(DTOIntGrantedAmount grantedAmount) {
		this.grantedAmount = grantedAmount;
	}

	public DTOIntInstallmentPayment getInstallmentPayment() {
		return installmentPayment;
	}

	public void setInstallmentPayment(
			DTOIntInstallmentPayment installmentPayment) {
		this.installmentPayment = installmentPayment;
	}

	public BigDecimal getInterestAnnualRate() {
		return interestAnnualRate;
	}

	public void setInterestAnnualRate(BigDecimal interestAnnualRate) {
		this.interestAnnualRate = interestAnnualRate;
	}

	public BigDecimal getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(BigDecimal interestRate) {
		this.interestRate = interestRate;
	}
}