package com.bbva.pzic.proposals.canonic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * @author Entelgy
 */
@XmlRootElement(name = "HiringType", namespace = "urn:com:bbva:pzic:proposals:canonic")
@XmlType(name = "HiringType", namespace = "urn:com:bbva:pzic:proposals:canonic")
@XmlAccessorType(XmlAccessType.FIELD)
public class HiringType implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Hiring type identifier.
     */
    private String id;
    /**
     * Hiring type description.
     */
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}