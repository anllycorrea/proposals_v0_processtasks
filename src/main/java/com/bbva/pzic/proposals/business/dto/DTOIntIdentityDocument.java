package com.bbva.pzic.proposals.business.dto;


/**
 * Created on 28/12/2017.
 *
 * @author Entelgy
 */
public class DTOIntIdentityDocument {

    private DTOIntDocumentType documentType;
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