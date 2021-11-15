package com.bbva.pzic.proposals.v0.processtasks.facade.dto;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;

@XmlRootElement(name = "status", namespace = "urn:com:bbva:pzic:proposals:v0:processtasks:facade:dto")
@XmlType(name = "status", namespace = "urn:com:bbva:pzic:proposals:v0:processtasks:facade:dto")
@XmlAccessorType(XmlAccessType.FIELD)
public class Status implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;
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
