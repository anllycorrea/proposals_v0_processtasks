package com.bbva.pzic.proposals.canonic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * Created on 10/05/2017.
 *
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
     * The bank identification number associated to the product, it\'s a general
     * identifier that is used by different bank departments. It only applies to
     * CARDS.
     */
    private String bin;
    /**
     * Title of the product.
     */
    private Title title;
    /**
     * Product Configuration, related to the risk groups.
     */
    private ProductConfiguration productConfiguration;
    /**
     * Product type.
     */
    private ProductType productType;
    /**
     * Product Classification.
     */
    private ProductClassification productClassification;

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

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
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
}