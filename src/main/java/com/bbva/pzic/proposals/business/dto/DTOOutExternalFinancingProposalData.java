package com.bbva.pzic.proposals.business.dto;

import com.bbva.pzic.proposals.canonic.ExternalFinancingProposal;

import java.util.List;

/**
 * Created on 13/04/2017.
 *
 * @author Entelgy
 */
public class DTOOutExternalFinancingProposalData {
    private List<ExternalFinancingProposal> data;
    private DTOIntPagination pagination;

    public List<ExternalFinancingProposal> getData() {
        return data;
    }

    public void setData(List<ExternalFinancingProposal> data) {
        this.data = data;
    }

    public DTOIntPagination getPagination() {
        return pagination;
    }

    public void setPagination(DTOIntPagination pagination) {
        this.pagination = pagination;
    }
}
