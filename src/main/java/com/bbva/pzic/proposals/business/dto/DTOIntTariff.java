package com.bbva.pzic.proposals.business.dto;


import javax.validation.constraints.NotNull;

/**
 * Created on 12/04/2017.
 *
 * @author Entelgy
 */
public class DTOIntTariff {

    @NotNull(groups = ValidationGroup.CreateExternalFinancingProposal.class)
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}