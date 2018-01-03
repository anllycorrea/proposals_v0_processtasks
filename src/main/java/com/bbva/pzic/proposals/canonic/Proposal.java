package com.bbva.pzic.proposals.canonic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created on 10/05/2017.
 *
 * @author Entelgy
 */
@XmlRootElement(name = "Proposal", namespace = "urn:com:bbva:pzic:proposals:canonic")
@XmlType(name = "Proposal", namespace = "urn:com:bbva:pzic:proposals:canonic")
@XmlAccessorType(XmlAccessType.FIELD)
public class Proposal implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Proposal identifier.
     */
    private String id;
    /**
     * Customer Identifier.
     */
    private String customerId;
    /**
     * Proposal internal code. Code to identify the internal sub-product type
     * associated to the proposal.
     */
    private String internalCode;
    /**
     * Procurement flow.
     */
    private ProcurementFlow procurementFlow;
    /**
     * Indicators related to the Proposal.
     */
    private List<Indicator> indicators;
    /**
     * Campaign of the Proposal.
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
     * List of rates related to the product.
     */
    private List<Rate> rates;
    /**
     * List of ranges related to the proposal product.
     */
    private List<Range> ranges;
    /**
     * List of calculated Instalments.
     */
    private List<Instalment> instalments;
    /**
     * List of limits related to the product proposal.
     */
    private List<Limit> limits;

    /**
     * Is the amount granted by the bank to the proposal’s owner. This amount is
     * calculated based on a financial analysis of the person made by the bank.
     */
    private GrantedAmount grantedAmount;
    /**
     * Approximated installment payment that the person would pay, in a certain
     * period of time, in case accepts the proposal.
     */
    private InstallmentPayment installmentPayment;
    /**
     * Risk type of the Proposal.
     */
    /**
     * Interest annual rate of the proposal.
     */
    private BigDecimal interestAnnualRate;

    /**
     * Interest rate related to the product. This must be the ADJUSTED interest
     * rate.
     */
    private BigDecimal interestRate;

    private RiskType riskType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
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

    public List<Rate> getRates() {
        return rates;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }

    public List<Range> getRanges() {
        return ranges;
    }

    public void setRanges(List<Range> ranges) {
        this.ranges = ranges;
    }

    public List<Instalment> getInstalments() {
        return instalments;
    }

    public void setInstalments(List<Instalment> instalments) {
        this.instalments = instalments;
    }

    public List<Limit> getLimits() {
        return limits;
    }

    public void setLimits(List<Limit> limits) {
        this.limits = limits;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public RiskType getRiskType() {
        return riskType;
    }

    public void setRiskType(RiskType riskType) {
        this.riskType = riskType;
    }

    public GrantedAmount getGrantedAmount() {
        return grantedAmount;
    }

    public void setGrantedAmount(GrantedAmount grantedAmount) {
        this.grantedAmount = grantedAmount;
    }

    public InstallmentPayment getInstallmentPayment() {
        return installmentPayment;
    }

    public void setInstallmentPayment(InstallmentPayment installmentPayment) {
        this.installmentPayment = installmentPayment;
    }

    public BigDecimal getInterestAnnualRate() {
        return interestAnnualRate;
    }

    public void setInterestAnnualRate(BigDecimal interestAnnualRate) {
        this.interestAnnualRate = interestAnnualRate;
    }
}