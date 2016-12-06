package com.bbva.pzic.proposals.business.dto;


/**
 * @author Entelgy
 */
public class DTOIntIndicator {

    private String indicatorId;
    private String name;
    private Boolean isActive;

    public String getIndicatorId() {
        return indicatorId;
    }

    public void setIndicatorId(String indicatorId) {
        this.indicatorId = indicatorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}