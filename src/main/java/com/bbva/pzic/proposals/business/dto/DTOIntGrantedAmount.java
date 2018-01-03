package com.bbva.pzic.proposals.business.dto;


import java.math.BigDecimal;

/**
 * Created on 28/12/2017.
 *
 * @author Entelgy
 */
public class DTOIntGrantedAmount {

    private DTOIntGrantedAmountType grantedAmountType;
    private BigDecimal value;
    private String currency;

    public DTOIntGrantedAmountType getGrantedAmountType() {
        return grantedAmountType;
    }

    public void setGrantedAmountType(DTOIntGrantedAmountType grantedAmountType) {
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