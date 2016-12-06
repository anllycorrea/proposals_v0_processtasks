package com.bbva.pzic.proposals.business.dto;


import javax.validation.Valid;

/**
 * @author Entelgy
 */
public class DTOIntInstalment {

    private String instalmentId;
    @Valid
    private DTOIntPrincipal principal;

    public String getInstalmentId() {
        return instalmentId;
    }

    public void setInstalmentId(String instalmentId) {
        this.instalmentId = instalmentId;
    }

    public DTOIntPrincipal getPrincipal() {
        return principal;
    }

    public void setPrincipal(DTOIntPrincipal principal) {
        this.principal = principal;
    }
}