package com.bbva.pzic.proposals.business.dto;


import javax.validation.Valid;

/**
 * @author Entelgy
 */
public class DTOIntProduct {

    private String productId;
    private String bin;
    @Valid
    private DTOIntProductConfiguration productConfiguration;
    @Valid
    private DTOIntProductType productType;
    @Valid
    private DTOIntProductClassification productClassification;
    private String description;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getBin() {
        return bin;
    }

    public void setBin(String bin) {
        this.bin = bin;
    }

    public DTOIntProductConfiguration getProductConfiguration() {
        return productConfiguration;
    }

    public void setProductConfiguration(
            DTOIntProductConfiguration productConfiguration) {
        this.productConfiguration = productConfiguration;
    }

    public DTOIntProductType getProductType() {
        return productType;
    }

    public void setProductType(DTOIntProductType productType) {
        this.productType = productType;
    }

    public DTOIntProductClassification getProductClassification() {
        return productClassification;
    }

    public void setProductClassification(
            DTOIntProductClassification productClassification) {
        this.productClassification = productClassification;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}