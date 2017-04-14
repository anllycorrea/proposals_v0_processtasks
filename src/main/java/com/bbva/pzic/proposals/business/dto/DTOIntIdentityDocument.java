package com.bbva.pzic.proposals.business.dto;


import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created on 12/04/2017.
 *
 * @author Entelgy
 */
public class DTOIntIdentityDocument {

    @NotNull(groups = ValidationGroup.CreateExternalFinancingProposal.class)
    @Valid
    private DTOIntDocumentType documentType;
    @NotNull(groups = ValidationGroup.CreateExternalFinancingProposal.class)
    private String documentNumber;

    public DTOIntDocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DTOIntDocumentType documentType) {
        this.documentType = documentType;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }
}