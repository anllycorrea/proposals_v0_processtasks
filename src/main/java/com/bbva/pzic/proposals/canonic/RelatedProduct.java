package com.bbva.pzic.proposals.canonic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created on 10/05/2017.
 *
 * @author Entelgy
 */
@XmlRootElement(name = "RelatedProduct", namespace = "urn:com:bbva:pzic:proposals:canonic")
@XmlType(name = "RelatedProduct", namespace = "urn:com:bbva:pzic:proposals:canonic")
@XmlAccessorType(XmlAccessType.FIELD)
public class RelatedProduct implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Related product rate.
     */
    private BigDecimal percentage;
    /**
     * Related product type.
     */
    private RelatedProductType relatedProductType;

    public BigDecimal getPercentage() {
        return percentage;
    }

    public void setPercentage(BigDecimal percentage) {
        this.percentage = percentage;
    }

    public RelatedProductType getRelatedProductType() {
        return relatedProductType;
    }

    public void setRelatedProductType(RelatedProductType relatedProductType) {
        this.relatedProductType = relatedProductType;
    }
}