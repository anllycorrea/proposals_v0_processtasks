package com.bbva.pzic.proposals.facade.v0.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * @author Entelgy
 */
@XmlRootElement(name = "validateAccess", namespace = "urn:com:bbva:pzic:proposals:facade:v0:dto")
@XmlType(name = "validateAccess", namespace = "urn:com:bbva:pzic:proposals:facade:v0:dto")
@XmlAccessorType(XmlAccessType.FIELD)
public class ValidateAccess implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Data of the participant that will be evaluated.
     */
    private ParticipantProposal participant;
    /**
     * Commercial product identification.
     */
    private ProductProposal product;

    public ParticipantProposal getParticipant() {
        return participant;
    }

    public void setParticipant(ParticipantProposal participant) {
        this.participant = participant;
    }

    public ProductProposal getProduct() {
        return product;
    }

    public void setProduct(ProductProposal product) {
        this.product = product;
    }
}
