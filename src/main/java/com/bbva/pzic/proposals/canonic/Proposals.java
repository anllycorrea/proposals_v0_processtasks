package com.bbva.pzic.proposals.canonic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.List;

/**
 * @author Entelgy
 */
@XmlRootElement(name = "Proposals", namespace = "urn:com:bbva:pzic:proposals:canonic")
@XmlType(name = "Proposals", namespace = "urn:com:bbva:pzic:proposals:canonic")
@XmlAccessorType(XmlAccessType.FIELD)
public class Proposals implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Proposal Data List
     */
    private List<Proposal> data;

    public List<Proposal> getData() {
        return data;
    }

    public void setData(List<Proposal> data) {
        this.data = data;
    }
}