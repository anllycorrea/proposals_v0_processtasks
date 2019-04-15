package com.bbva.pzic.proposals.business.dto;


import java.util.List;

/**
 * Created on 28/12/2017.
 *
 * @author Entelgy
 */
public class DTOIntSimulatedProposal {

    private DTOIntParticipant participant;
    private List<DTOIntProduct> products;
    private DTOIntProposal proposal;

    public DTOIntParticipant getParticipant() {
        return participant;
    }

    public void setParticipant(DTOIntParticipant participant) {
        this.participant = participant;
    }

    public List<DTOIntProduct> getProducts() {
        return products;
    }

    public void setProducts(List<DTOIntProduct> products) {
        this.products = products;
    }

    public DTOIntProposal getProposal() {
        return proposal;
    }

    public void setProposal(DTOIntProposal proposal) {
        this.proposal = proposal;
    }
}