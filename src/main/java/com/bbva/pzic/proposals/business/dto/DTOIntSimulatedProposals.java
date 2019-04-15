package com.bbva.pzic.proposals.business.dto;

import com.bbva.pzic.proposals.canonic.SimulatedProposal;

import java.util.List;

/**
 * Created on 15/04/2019.
 *
 * @author Entelgy
 */
public class DTOIntSimulatedProposals {

    private List<SimulatedProposal> data;

    public List<SimulatedProposal> getData() {
        return data;
    }

    public void setData(List<SimulatedProposal> data) {
        this.data = data;
    }
}
