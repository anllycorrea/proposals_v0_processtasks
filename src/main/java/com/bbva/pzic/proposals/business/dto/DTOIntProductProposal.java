package com.bbva.pzic.proposals.business.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created on 15/11/2019.
 *
 * @author Entelgy
 */
public class DTOIntProductProposal {

    @NotNull(groups = ValidationGroup.CreateQuestionnairesValidateAccess.class)
    private String id;
    @Valid
    private DTOIntSubproductProposal subproduct;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DTOIntSubproductProposal getSubproduct() {
        return subproduct;
    }

    public void setSubproduct(DTOIntSubproductProposal subproduct) {
        this.subproduct = subproduct;
    }
}
