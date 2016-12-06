package com.bbva.pzic.proposals.canonic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * @author Entelgy
 */
@XmlRootElement(name = "ProductConfiguration", namespace = "urn:com:bbva:pzic:proposals:canonic")
@XmlType(name = "ProductConfiguration", namespace = "urn:com:bbva:pzic:proposals:canonic")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductConfiguration implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Product configuration identifier.
     */
    private String id;
    /**
     * Product configuration description.
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