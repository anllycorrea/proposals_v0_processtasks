package com.bbva.pzic.proposals.business.dto;


import java.math.BigDecimal;

/**
 * @author Entelgy
 */
public class DTOIntRate {

    private String rateId;
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