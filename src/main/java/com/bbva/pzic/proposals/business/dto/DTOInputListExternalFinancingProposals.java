package com.bbva.pzic.proposals.business.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created on 13/04/2017.
 *
 * @author Entelgy
 */
public class DTOInputListExternalFinancingProposals {
    @NotNull(groups = ValidationGroup.ListExternalFinancingProposals.class)
    @Size(max = 4, groups = ValidationGroup.ListExternalFinancingProposals.class)
    private String thirdPartyProviderId;

    @NotNull(groups = ValidationGroup.ListExternalFinancingProposals.class)
    @Size(max = 2, groups = ValidationGroup.ListExternalFinancingProposals.class)
    private String externalproductCategoryTypeId;

    @NotNull(groups = ValidationGroup.ListExternalFinancingProposals.class)
    private String holderIdentityDocumentsDocumentTypeId;

    @NotNull(groups = ValidationGroup.ListExternalFinancingProposals.class)
    @Size(max = 10, groups = ValidationGroup.ListExternalFinancingProposals.class)
    private String holderIdentityDocumentsDocumentNumber;

    @NotNull(groups = ValidationGroup.ListExternalFinancingProposals.class)
    @Size(max = 10, groups = ValidationGroup.ListExternalFinancingProposals.class)
    private String fromRequestDate;

    @NotNull(groups = ValidationGroup.ListExternalFinancingProposals.class)
    @Size(max = 10, groups = ValidationGroup.ListExternalFinancingProposals.class)
    private String toRequestDate;

    @Size(max = 18, groups = ValidationGroup.ListExternalFinancingProposals.class)
    private String paginationKey;
    @Digits(integer = 2, fraction = 0, groups = ValidationGroup.ListExternalFinancingProposals.class)
    private Long pageSize;

    public String getThirdPartyProviderId() {
        return thirdPartyProviderId;
    }

    public void setThirdPartyProviderId(String thirdPartyProviderId) {
        this.thirdPartyProviderId = thirdPartyProviderId;
    }

    public String getExternalproductCategoryTypeId() {
        return externalproductCategoryTypeId;
    }

    public void setExternalproductCategoryTypeId(String externalproductCategoryTypeId) {
        this.externalproductCategoryTypeId = externalproductCategoryTypeId;
    }

    public String getHolderIdentityDocumentsDocumentTypeId() {
        return holderIdentityDocumentsDocumentTypeId;
    }

    public void setHolderIdentityDocumentsDocumentTypeId(String holderIdentityDocumentsDocumentTypeId) {
        this.holderIdentityDocumentsDocumentTypeId = holderIdentityDocumentsDocumentTypeId;
    }

    public String getHolderIdentityDocumentsDocumentNumber() {
        return holderIdentityDocumentsDocumentNumber;
    }

    public void setHolderIdentityDocumentsDocumentNumber(String holderIdentityDocumentsDocumentNumber) {
        this.holderIdentityDocumentsDocumentNumber = holderIdentityDocumentsDocumentNumber;
    }

    public String getFromRequestDate() {
        return fromRequestDate;
    }

    public void setFromRequestDate(String fromRequestDate) {
        this.fromRequestDate = fromRequestDate;
    }

    public String getToRequestDate() {
        return toRequestDate;
    }

    public void setToRequestDate(String toRequestDate) {
        this.toRequestDate = toRequestDate;
    }

    public String getPaginationKey() {
        return paginationKey;
    }

    public void setPaginationKey(String paginationKey) {
        this.paginationKey = paginationKey;
    }

    public Long getPageSize() {
        return pageSize;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }
}
