package com.bbva.pzic.proposals.business.dto;


import java.math.BigDecimal;

/**
 * @author Entelgy
 */
public class DTOIntTerm {

    private String termId;
    private BigDecimal value;

    public String getTermId() {
        return termId;
    }

    public void setTermId(String termId) {
        this.termId = termId;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}