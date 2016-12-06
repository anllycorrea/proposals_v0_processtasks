package com.bbva.pzic.proposals.business.dto;


import javax.validation.Valid;
import java.util.List;

/**
 * @author Entelgy
 */
public class DTOIntLimit {

    private String limitId;
    private String name;
    @Valid
    private List<DTOIntAmountLimit> amountLimits;

    public String getLimitId() {
        return limitId;
    }

    public void setLimitId(String limitId) {
        this.limitId = limitId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DTOIntAmountLimit> getAmountLimits() {
        return amountLimits;
    }

    public void setAmountLimits(List<DTOIntAmountLimit> amountLimits) {
        this.amountLimits = amountLimits;
    }
}