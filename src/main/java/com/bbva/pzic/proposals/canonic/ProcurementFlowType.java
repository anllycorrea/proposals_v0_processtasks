package com.bbva.pzic.proposals.canonic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * @author Entelgy
 */
@XmlRootElement(name = "procurementFlowType", namespace = "urn:com:bbva:pzic:proposals:canonic")
@XmlType(name = "procurementFlowType", namespace = "urn:com:bbva:pzic:proposals:canonic")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProcurementFlowType implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Procurement flow type identifier.
     */
    private String id;
    /**
     * Procurement flow type description.
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