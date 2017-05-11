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
@XmlRootElement(name = "InitialFee", namespace = "urn:com:bbva:pzic:proposals:canonic")
@XmlType(name = "InitialFee", namespace = "urn:com:bbva:pzic:proposals:canonic")
@XmlAccessorType(XmlAccessType.FIELD)
public class InitialFee implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Initial fee amount.
     */
    private BigDecimal amount;
    /**
     * String based on ISO-4217 for specifying the currency related to the
     * initial fee amount.
     */
    private String currency;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}