package com.bbva.pzic.proposals.business.dto;


import java.math.BigDecimal;

/**
 * Created on 28/12/2017.
 *
 * @author Entelgy
 */
public class DTOIntInstallmentPayment {

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