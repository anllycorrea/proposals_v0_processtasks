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
@XmlRootElement(name = "Branch", namespace = "urn:com:bbva:pzic:proposals:canonic")
@XmlType(name = "Branch", namespace = "urn:com:bbva:pzic:proposals:canonic")
@XmlAccessorType(XmlAccessType.FIELD)
public class Branch implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Identifier of the office of the bank where the external financing
     * proposal was registered.
     */
    private String id;
    /**
     * Description of the office of the bank where the external financing
     * proposal was registered.
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