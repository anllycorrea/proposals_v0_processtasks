package com.bbva.pzic.proposals.business.dto;


import java.math.BigDecimal;

/**
 * @author Entelgy
 */
public class DTOIntRange {

    private String rangeId;
    private BigDecimal value;

    public String getRangeId() {
        return rangeId;
    }

    public void setRangeId(String rangeId) {
        this.rangeId = rangeId;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}