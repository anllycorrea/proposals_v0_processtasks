package com.bbva.pzic.proposals.facade.v0.dto;

import com.bbva.pzic.proposals.canonic.IdentityDocument;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * @author Entelgy
 */
@XmlRootElement(name = "participantProposal", namespace = "urn:com:bbva:pzic:proposals:facade:v0:dto")
@XmlType(name = "participantProposal", namespace = "urn:com:bbva:pzic:proposals:facade:v0:dto")
@XmlAccessorType(XmlAccessType.FIELD)
public class ParticipantProposal implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Identifier of the participant.
     */
    private String id;
    /**
     * Identity document information related to the person.
     */
    private IdentityDocument identityDocument;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public IdentityDocument getIdentityDocument() {
        return identityDocument;
    }

    public void setIdentityDocument(IdentityDocument identityDocument) {
        this.identityDocument = identityDocument;
    }
}
