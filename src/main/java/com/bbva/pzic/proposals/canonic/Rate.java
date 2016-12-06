package com.bbva.pzic.proposals.canonic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Entelgy
 */
@XmlRootElement(name = "Rate", namespace = "urn:com:bbva:pzic:proposals:canonic")
@XmlType(name = "Rate", namespace = "urn:com:bbva:pzic:proposals:canonic")
@XmlAccessorType(XmlAccessType.FIELD)
public class Rate implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Rate type identifier.
     */
    private String rateId;
    /**
     * Interest rate value.
     */
    private BigDecimal value;

    public String getRateId() {
        return rateId;
    }

    public void setRateId(String rateId) {
        this.rateId = rateId;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}