package com.bbva.pzic.proposals.business.dto;


import javax.validation.Valid;

/**
 * Created on 12/04/2017.
 *
 * @author Entelgy
 */
public class DTOIntInstalment {

    private String id;
    @Valid
    private DTOIntPrincipal principal;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DTOIntPrincipal getPrincipal() {
        return principal;
    }

    public void setPrincipal(DTOIntPrincipal principal) {
        this.principal = principal;
    }
}