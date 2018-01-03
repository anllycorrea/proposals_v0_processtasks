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
@XmlRootElement(name = "grantedAmount", namespace = "urn:com:bbva:pzic:proposals:canonic")
@XmlType(name = "grantedAmount", namespace = "urn:com:bbva:pzic:proposals:canonic")
@XmlAccessorType(XmlAccessType.FIELD)
public class GrantedAmount implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Granted amount type.
     */
    private GrantedAmountType grantedAmountType;
    /**
     * Granted amount value.
     */
    private BigDecimal value;
    /**
     * String based on ISO-4217 for specifying the currency related to the
     * Granted amount by the proposal.
     */
    private String currency;

    public GrantedAmountType getGrantedAmountType() {
        return grantedAmountType;
    }

    public void setGrantedAmountType(GrantedAmountType grantedAmountType) {
        this.grantedAmountType = grantedAmountType;
    }

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