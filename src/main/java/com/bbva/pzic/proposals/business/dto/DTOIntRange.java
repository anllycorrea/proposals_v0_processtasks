package com.bbva.pzic.proposals.business.dto;


import java.math.BigDecimal;

/**
 * Created on 28/12/2017.
 *
 * @author Entelgy
 */
public class DTOIntRange {

    private String id;
    private BigDecimal value;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}