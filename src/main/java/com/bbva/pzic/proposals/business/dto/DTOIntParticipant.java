package com.bbva.pzic.proposals.business.dto;


/**
 * Created on 28/12/2017.
 *
 * @author Entelgy
 */
public class DTOIntParticipant {

    private String id;
    private DTOIntIdentityDocument identityDocument;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DTOIntIdentityDocument getIdentityDocument() {
        return identityDocument;
    }

    public void setIdentityDocument(DTOIntIdentityDocument identityDocument) {
        this.identityDocument = identityDocument;
    }
}