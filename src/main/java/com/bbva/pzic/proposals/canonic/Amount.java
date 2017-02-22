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
@XmlRootElement(name = "Amount", namespace = "urn:com:bbva:pzic:proposals:canonic")
@XmlType(name = "Amount", namespace = "urn:com:bbva:pzic:proposals:canonic")
@XmlAccessorType(XmlAccessType.FIELD)
public class Amount implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Monetary amount related to the limit.
     */
    private BigDecimal value;
    /**
     * String based on ISO-4217 for specifying the currency related to the amount limit.
     */
    private String currency;

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}