package com.bbva.pzic.proposals.canonic;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * @author Entelgy
 */
@XmlRootElement(name = "Product", namespace = "urn:com:bbva:pzic:proposals:canonic")
@XmlType(name = "Product", namespace = "urn:com:bbva:pzic:proposals:canonic")
@XmlAccessorType(XmlAccessType.FIELD)
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Product identifier.
     */
    private String productId;
    /**
     * The bank identification number, only applies to Cards.
     */
    private String bin;
    /**
     * Product Configuration, related to the risk groups.
     */
    @Valid
    private ProductConfiguration productConfiguration;
    /**
     * Product type.
     */
    @Valid
    private ProductType productType;
    /**
     * Product Classification.
     */
    @Valid
    private ProductClassification productClassification;
    /**
     * Product description.
     */
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

    public ProductConfiguration getProductConfiguration() {
        return productConfiguration;
    }

    public void setProductConfiguration(
            ProductConfiguration productConfiguration) {
        this.productConfiguration = productConfiguration;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public ProductClassification getProductClassification() {
        return productClassification;
    }

    public void setProductClassification(
            ProductClassification productClassification) {
        this.productClassification = productClassification;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}