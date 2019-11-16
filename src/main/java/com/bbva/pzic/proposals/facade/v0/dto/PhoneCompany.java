package com.bbva.pzic.proposals.facade.v0.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * @author Entelgy
 */
@XmlRootElement(name = "phoneCompany", namespace = "urn:com:bbva:pzic:proposals:facade:v0:dto")
@XmlType(name = "phoneCompany", namespace = "urn:com:bbva:pzic:proposals:facade:v0:dto")
@XmlAccessorType(XmlAccessType.FIELD)
public class PhoneCompany implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Cellphone company identifier.
     */
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
