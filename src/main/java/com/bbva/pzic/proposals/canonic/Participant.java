package com.bbva.pzic.proposals.canonic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * @author Entelgy
 */
@XmlRootElement(name = "Participant", namespace = "urn:com:bbva:pzic:proposals:canonic")
@XmlType(name = "Participant", namespace = "urn:com:bbva:pzic:proposals:canonic")
@XmlAccessorType(XmlAccessType.FIELD)
public class Participant implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Participant identifier.
     */
    private String participantId;

    public String getParticipantId() {
        return participantId;
    }

    public void setParticipantId(String participantId) {
        this.participantId = participantId;
    }
}