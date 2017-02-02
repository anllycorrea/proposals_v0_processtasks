package com.bbva.pzic.proposals.canonic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * @author Entelgy
 */
@XmlRootElement(name = "Indicator", namespace = "urn:com:bbva:pzic:proposals:canonic")
@XmlType(name = "Indicator", namespace = "urn:com:bbva:pzic:proposals:canonic")
@XmlAccessorType(XmlAccessType.FIELD)
public class Indicator implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Identifier associated to the behavior indicator.
     */
    private String id;
    /**
     * Localized description of the behavior indicator.
     */
    private String name;
    /**
     * Indicates whether the indicator is enabled.
     */
    private Boolean isActive;

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

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}