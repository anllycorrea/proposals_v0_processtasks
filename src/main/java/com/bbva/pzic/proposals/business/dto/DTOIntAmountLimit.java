package com.bbva.pzic.proposals.business.dto;


import java.math.BigDecimal;

/**
 * @author Entelgy
 */
public class DTOIntAmountLimit {

    private BigDecimal amount;
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