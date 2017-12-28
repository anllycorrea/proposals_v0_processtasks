package com.bbva.pzic.proposals.business.dto;


import java.util.List;

/**
 * Created on 28/12/2017.
 * 
 * @author Entelgy
 */
public class DTOIntSimulatedProposal {

	private DTOIntParticipant participant;
	private List<DTOIntProduct> products;
	private DTOIntProposal proposal;
	private String internalCode;
	private DTOIntProcurementFlow procurementFlow;
	private List<DTOIntIndicator> indicators;
	private DTOIntCampaign campaign;
	private DTOIntTerm term;
	private DTOIntProduct product;
	private List<DTOIntInterestRate> interestRates;
	private List<DTOIntRange> ranges;
	private List<DTOIntInstallment> installments;
	private List<DTOIntGrantedAmount> grantedAmounts;

	public DTOIntParticipant getParticipant() {
		return participant;
	}

	public void setParticipant(DTOIntParticipant participant) {
		this.participant = participant;
	}

	public List<DTOIntProduct> getProducts() {
		return products;
	}

	public void setProducts(List<DTOIntProduct> products) {
		this.products = products;
	}

	public DTOIntProposal getProposal() {
		return proposal;
	}

	public void setProposal(DTOIntProposal proposal) {
		this.proposal = proposal;
	}

	public String getInternalCode() {
		return internalCode;
	}

	public void setInternalCode(String internalCode) {
		this.internalCode = internalCode;
	}

	public DTOIntProcurementFlow getProcurementFlow() {
		return procurementFlow;
	}

	public void setProcurementFlow(DTOIntProcurementFlow procurementFlow) {
		this.procurementFlow = procurementFlow;
	}

	public List<DTOIntIndicator> getIndicators() {
		return indicators;
	}

	public void setIndicators(List<DTOIntIndicator> indicators) {
		this.indicators = indicators;
	}

	public DTOIntCampaign getCampaign() {
		return campaign;
	}

	public void setCampaign(DTOIntCampaign campaign) {
		this.campaign = campaign;
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

	public List<DTOIntInterestRate> getInterestRates() {
		return interestRates;
	}

	public void setInterestRates(List<DTOIntInterestRate> interestRates) {
		this.interestRates = interestRates;
	}

	public List<DTOIntRange> getRanges() {
		return ranges;
	}

	public void setRanges(List<DTOIntRange> ranges) {
		this.ranges = ranges;
	}

	public List<DTOIntInstallment> getInstallments() {
		return installments;
	}

	public void setInstallments(List<DTOIntInstallment> installments) {
		this.installments = installments;
	}

	public List<DTOIntGrantedAmount> getGrantedAmounts() {
		return grantedAmounts;
	}

	public void setGrantedAmounts(List<DTOIntGrantedAmount> grantedAmounts) {
		this.grantedAmounts = grantedAmounts;
	}
}