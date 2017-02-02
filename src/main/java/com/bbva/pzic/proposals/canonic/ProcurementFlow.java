package com.bbva.pzic.proposals.canonic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * Created on 26/01/2017.
 *
 * @author Entelgy
 */
@XmlRootElement(name = "ProcurementFlow", namespace = "urn:com:bbva:pzic:proposals:canonic")
@XmlType(name = "ProcurementFlow", namespace = "urn:com:bbva:pzic:proposals:canonic")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProcurementFlow implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Procurement Flow identifier.
     */
    private String id;
    /**
     * Procurement Flow description.
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
