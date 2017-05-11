package com.bbva.pzic.proposals.business.dto;


import javax.validation.Valid;
import javax.validation.constraints.Size;

/**
 * Created on 12/04/2017.
 *
 * @author Entelgy
 */
public class DTOIntExternalProduct {

    @Size(max = 15, groups = ValidationGroup.CreateExternalFinancingProposal.class)
    private String id;
    @Valid
    private DTOIntCommercialValue commercialValue;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DTOIntCommercialValue getCommercialValue() {
        return commercialValue;
    }

    public void setCommercialValue(DTOIntCommercialValue commercialValue) {
        this.commercialValue = commercialValue;
    }
}