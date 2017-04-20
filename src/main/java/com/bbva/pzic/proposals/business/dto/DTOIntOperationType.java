package com.bbva.pzic.proposals.business.dto;


import javax.validation.constraints.Size;

/**
 * Created on 12/04/2017.
 *
 * @author Entelgy
 */
public class DTOIntOperationType {

    @Size(max = 5, groups = ValidationGroup.CreateExternalFinancingProposal.class)
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}