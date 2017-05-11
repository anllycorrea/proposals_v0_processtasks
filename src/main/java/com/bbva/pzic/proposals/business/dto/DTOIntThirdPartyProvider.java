package com.bbva.pzic.proposals.business.dto;


import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created on 12/04/2017.
 *
 * @author Entelgy
 */
public class DTOIntThirdPartyProvider {

    @NotNull(groups = ValidationGroup.CreateExternalFinancingProposal.class)
    @Size(max = 4, groups = ValidationGroup.CreateExternalFinancingProposal.class)
    private String id;
    private String userId;
    @Valid
    private DTOIntExternalSalesChannel externalSalesChannel;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public DTOIntExternalSalesChannel getExternalSalesChannel() {
        return externalSalesChannel;
    }

    public void setExternalSalesChannel(
            DTOIntExternalSalesChannel externalSalesChannel) {
        this.externalSalesChannel = externalSalesChannel;
    }
}