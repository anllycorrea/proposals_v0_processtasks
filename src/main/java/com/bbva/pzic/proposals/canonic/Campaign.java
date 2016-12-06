package com.bbva.pzic.proposals.canonic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * @author Entelgy
 */
@XmlRootElement(name = "Campaign", namespace = "urn:com:bbva:pzic:proposals:canonic")
@XmlType(name = "Campaign", namespace = "urn:com:bbva:pzic:proposals:canonic")
@XmlAccessorType(XmlAccessType.FIELD)
public class Campaign implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Campaign code.
     */
    private String code;
    /**
     * Campaign name.
     */
    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}