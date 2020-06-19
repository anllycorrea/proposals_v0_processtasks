package com.bbva.pzic.proposals.facade.v0.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * Created on 19/06/2020.
 *
 * @author Entelgy.
 */
@XmlRootElement(name = "dictumReason", namespace = "urn:com:bbva:pzic:proposals:facade:v0:dto")
@XmlType(name = "dictumReason", namespace = "urn:com:bbva:pzic:proposals:facade:v0:dto")
@XmlAccessorType(XmlAccessType.FIELD)
public class DictumReason implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Identifier of the reason of dictum.
     */
    private String id;
    /**
     * Description of the reason of dictum.
     */
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
