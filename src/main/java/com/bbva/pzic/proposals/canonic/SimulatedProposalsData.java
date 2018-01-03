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
@XmlRootElement(name = "simulatedProposalsData", namespace = "urn:com:bbva:pzic:proposals:canonic")
@XmlType(name = "simulatedProposalsData", namespace = "urn:com:bbva:pzic:proposals:canonic")
@XmlAccessorType(XmlAccessType.FIELD)
public class SimulatedProposalsData implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * SimulatedProposals Data
     */
    private List<SimulatedProposal> data;

    public List<SimulatedProposal> getData() {
        return data;
    }

    public void setData(List<SimulatedProposal> data) {
        this.data = data;
    }
}