package com.bbva.pzic.proposals.canonic;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.List;

/**
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
     * Person who has the proposal.
     */
    @Valid
    private Participant participant;
    /**
     * Hiring type.
     */
    @Valid
    private HiringType hiringType;
    /**
     * Indicators related to the Proposal.
     */
    @Valid
    private List<Indicator> indicators;
    /**
     * Campaign of the Proposal.
     */
    @Valid
    private Campaign campaign;
    /**
     * Term of the product related to the proposal.
     */
    @Valid
    private Term term;
    /**
     * Product related to the proposal.
     */
    @Valid
    private Product product;
    /**
     * List of rates related to the product.
     */
    @Valid
    private List<Rate> rates;
    /**
     * List of ranges related to the proposal product.
     */
    @Valid
    private List<Range> ranges;
    /**
     * List of calculated Instalments.
     */
    @Valid
    private List<Instalment> instalments;
    /**
     * List of limits related to the product proposal.
     */
    @Valid
    private List<Limit> limits;
    /**
     * Risk type of the Proposal.
     */
    @Valid
    private RiskType riskType;

    /**
     * Procurement flow.
     */
    private ProcurementFlow procurementFlow;

    /**
     * Customer Identifier.
     */
    private String customerId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    public HiringType getHiringType() {
        return hiringType;
    }

    public void setHiringType(HiringType hiringType) {
        this.hiringType = hiringType;
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

    public RiskType getRiskType() {
        return riskType;
    }

    public void setRiskType(RiskType riskType) {
        this.riskType = riskType;
    }

    public ProcurementFlow getProcurementFlow() {
        return procurementFlow;
    }

    public void setProcurementFlow(ProcurementFlow procurementFlow) {
        this.procurementFlow = procurementFlow;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}