package com.bbva.pzic.proposals.business.dto;


import javax.validation.Valid;
import java.util.List;

/**
 * Created on 12/04/2017.
 *
 * @author Entelgy
 */
public class DTOIntProposal {

    private String id;
    private String customerId;
    @Valid
    private DTOIntProcurementFlow procurementFlow;
    @Valid
    private List<DTOIntIndicator> indicators;
    @Valid
    private DTOIntCampaign campaign;
    @Valid
    private DTOIntTerm term;
    @Valid
    private DTOIntProduct product;
    @Valid
    private List<DTOIntRate> rates;
    @Valid
    private List<DTOIntRange> ranges;
    @Valid
    private List<DTOIntInstalment> instalments;
    @Valid
    private List<DTOIntLimit> limits;
    @Valid
    private DTOIntRiskType riskType;

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

    public List<DTOIntRate> getRates() {
        return rates;
    }

    public void setRates(List<DTOIntRate> rates) {
        this.rates = rates;
    }

    public List<DTOIntRange> getRanges() {
        return ranges;
    }

    public void setRanges(List<DTOIntRange> ranges) {
        this.ranges = ranges;
    }

    public List<DTOIntInstalment> getInstalments() {
        return instalments;
    }

    public void setInstalments(List<DTOIntInstalment> instalments) {
        this.instalments = instalments;
    }

    public List<DTOIntLimit> getLimits() {
        return limits;
    }

    public void setLimits(List<DTOIntLimit> limits) {
        this.limits = limits;
    }

    public DTOIntRiskType getRiskType() {
        return riskType;
    }

    public void setRiskType(DTOIntRiskType riskType) {
        this.riskType = riskType;
    }
}