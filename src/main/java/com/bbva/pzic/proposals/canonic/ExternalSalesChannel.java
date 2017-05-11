package com.bbva.pzic.proposals.canonic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * Created on 10/05/2017.
 *
 * @author Entelgy
 */
@XmlRootElement(name = "ExternalSalesChannel", namespace = "urn:com:bbva:pzic:proposals:canonic")
@XmlType(name = "ExternalSalesChannel", namespace = "urn:com:bbva:pzic:proposals:canonic")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExternalSalesChannel implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * External sales channel identifier.
     */
    private String id;
    /**
     * External sales channel description.
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