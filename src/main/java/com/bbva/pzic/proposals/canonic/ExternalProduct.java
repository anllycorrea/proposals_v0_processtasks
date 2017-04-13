package com.bbva.pzic.proposals.canonic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * Created on 12/04/2017.
 *
 * @author Entelgy
 */
@XmlRootElement(name = "ExternalProduct", namespace = "urn:com:bbva:pzic:proposals:canonic")
@XmlType(name = "ExternalProduct", namespace = "urn:com:bbva:pzic:proposals:canonic")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExternalProduct implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Identifier of the external product financed.
     */
    private String id;
    /**
     * Commercial value of the external product financed.
     */
    private CommercialValueAmount commercialValueAmount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CommercialValueAmount getCommercialValueAmount() {
        return commercialValueAmount;
    }

    public void setCommercialValueAmount(
            CommercialValueAmount commercialValueAmount) {
        this.commercialValueAmount = commercialValueAmount;
    }
}