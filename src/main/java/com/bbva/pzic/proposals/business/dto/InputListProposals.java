package com.bbva.pzic.proposals.business.dto;


import javax.validation.constraints.Size;

/**
 * Created on 28/12/2017.
 *
 * @author Entelgy
 */
public class InputListProposals {

    @Size(max = 1, groups = ValidationGroup.ListProposalsV0.class)

    private String documentTypeId;
    @Size(max = 11, groups = ValidationGroup.ListProposalsV0.class)
    private String documentNumber;
    @Size(max = 8, groups = ValidationGroup.ListProposalsV0.class)
    private String customerId;

    public String getDocumentTypeId() {
        return documentTypeId;
    }

    public void setDocumentTypeId(String documentTypeId) {
        this.documentTypeId = documentTypeId;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}