package com.bbva.pzic.proposals.business.dto;


import javax.validation.constraints.NotNull;

/**
 * Created on 28/12/2017.
 *
 * @author Entelgy
 */
public class DTOIntDocumentType {

    @NotNull(groups = ValidationGroup.CreateQuestionnairesValidateAccess.class)
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
