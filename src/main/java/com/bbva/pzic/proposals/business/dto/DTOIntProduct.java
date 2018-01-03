package com.bbva.pzic.proposals.business.dto;


/**
 * Created on 28/12/2017.
 *
 * @author Entelgy
 */
public class DTOIntProduct {

    private DTOIntProductClassification productClassification;
    private String bin;
    private DTOIntTitle title;
    private String riskGroup;
    private DTOIntProductType productType;
    private DTOIntProductConfiguration productConfiguration;

    public DTOIntProductClassification getProductClassification() {
        return productClassification;
    }

    public void setProductClassification(
            DTOIntProductClassification productClassification) {
        this.productClassification = productClassification;
    }

    public String getBin() {
        return bin;
    }

    public void setBin(String bin) {
        this.bin = bin;
    }

    public DTOIntTitle getTitle() {
        return title;
    }

    public void setTitle(DTOIntTitle title) {
        this.title = title;
    }

    public String getRiskGroup() {
        return riskGroup;
    }

    public void setRiskGroup(String riskGroup) {
        this.riskGroup = riskGroup;
    }

    public DTOIntProductType getProductType() {
        return productType;
    }

    public void setProductType(DTOIntProductType productType) {
        this.productType = productType;
    }

    public DTOIntProductConfiguration getProductConfiguration() {
        return productConfiguration;
    }

    public void setProductConfiguration(
            DTOIntProductConfiguration productConfiguration) {
        this.productConfiguration = productConfiguration;
    }
}