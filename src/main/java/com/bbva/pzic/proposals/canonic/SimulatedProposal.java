package com.bbva.pzic.proposals.canonic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.List;

/**
 * @author Entelgy
 */
@XmlRootElement(name = "simulatedProposal", namespace = "urn:com:bbva:pzic:proposals:canonic")
@XmlType(name = "simulatedProposal", namespace = "urn:com:bbva:pzic:proposals:canonic")
@XmlAccessorType(XmlAccessType.FIELD)
public class SimulatedProposal implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * Is the owner of the proposal.
	 */
	private Participant participant;
	/**
	 * Product associated to the proposal.
	 */
	private List<Product> products;
	/**
	 * Simulated proposal that was selected by the user before execute the
	 * current simulation.
	 */
	private Proposal proposal;
	/**
	 * Proposal internal code. Code to identify the internal sub-product type
	 * associated to the proposal.
	 */
	private String internalCode;
	/**
	 * Procurement flow. The natural flow of the proposal is to end in a
	 * contracted product for the person, this natural flow, also called
	 * procurement flow, has some particularities which make that we have more
	 * than flow to hire a product.
	 */
	private ProcurementFlow procurementFlow;
	/**
	 * Indicators related to the Proposal. These indicators serve to know if is
	 * necessary to validate some information of the proposal\'s owner.
	 */
	private List<Indicator> indicators;
	/**
	 * Campaign of the proposal.
	 */
	private Campaign campaign;
	/**
	 * Term of the product related to the proposal.
	 */
	private Term term;
	/**
	 * Product related to the proposal.
	 */
	private Product product;
	/**
	 * List of interest rates related to the proposal.
	 */
	private List<InterestRate> interestRates;
	/**
	 * List of ranges of offered amounts for the proposal.
	 */
	private List<Range> ranges;
	/**
	 * List of the calculated installment amounts.
	 */
	private List<Installment> installments;
	/**
	 * List of of the granted amounts that belong to the proposal.
	 */
	private List<GrantedAmount> grantedAmounts;

	public Participant getParticipant() {
		return participant;
	}

	public void setParticipant(Participant participant) {
		this.participant = participant;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Proposal getProposal() {
		return proposal;
	}

	public void setProposal(Proposal proposal) {
		this.proposal = proposal;
	}

	public String getInternalCode() {
		return internalCode;
	}

	public void setInternalCode(String internalCode) {
		this.internalCode = internalCode;
	}

	public ProcurementFlow getProcurementFlow() {
		return procurementFlow;
	}

	public void setProcurementFlow(ProcurementFlow procurementFlow) {
		this.procurementFlow = procurementFlow;
	}

	public List<Indicator> getIndicators() {
		return indicators;
	}

	public void setIndicators(List<Indicator> indicators) {
		this.indicators = indicators;
	}

	public Campaign getCampaign() {
		return campaign;
	}

	public void setCampaign(Campaign campaign) {
		this.campaign = campaign;
	}

	public Term getTerm() {
		return term;
	}

	public void setTerm(Term term) {
		this.term = term;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<InterestRate> getInterestRates() {
		return interestRates;
	}

	public void setInterestRates(List<InterestRate> interestRates) {
		this.interestRates = interestRates;
	}

	public List<Range> getRanges() {
		return ranges;
	}

	public void setRanges(List<Range> ranges) {
		this.ranges = ranges;
	}

	public List<Installment> getInstallments() {
		return installments;
	}

	public void setInstallments(List<Installment> installments) {
		this.installments = installments;
	}

	public List<GrantedAmount> getGrantedAmounts() {
		return grantedAmounts;
	}

	public void setGrantedAmounts(List<GrantedAmount> grantedAmounts) {
		this.grantedAmounts = grantedAmounts;
	}
}