package com.bbva.pzic.proposals.business.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created on 16/04/2017.
 *
 * @author Entelgy
 */
public class DTOInputModifyExternalFinancingProposal {

    @Size(max = 18, groups = ValidationGroup.ModifyExternalFinancingProposal.class)
    private String externalFinancingProposalId;

    @Valid
    @NotNull(groups = ValidationGroup.ModifyExternalFinancingProposal.class)
    private DTOIntExternalFinancingProposal externalFinancingProposal;

    public String getExternalFinancingProposalId() {
        return externalFinancingProposalId;
    }

    public void setExternalFinancingProposalId(String externalFinancingProposalId) {
        this.externalFinancingProposalId = externalFinancingProposalId;
    }

    public DTOIntExternalFinancingProposal getExternalFinancingProposal() {
        return externalFinancingProposal;
    }

    public void setExternalFinancingProposal(DTOIntExternalFinancingProposal externalFinancingProposal) {
        this.externalFinancingProposal = externalFinancingProposal;
    }
}
