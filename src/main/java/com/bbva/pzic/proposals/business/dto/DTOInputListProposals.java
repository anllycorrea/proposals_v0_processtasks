package com.bbva.pzic.proposals.business.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

/**
 * Created on 12/12/2016.
 *
 * @author Entelgy
 */
public class DTOInputListProposals {

    @Size(max = 8)
    private String customerId;
    private String documentType;
    @Size(max = 11)
    private String documentNumber;
    private String productClassificationId;
    @Size(max = 18)
    private String paginationKey;
    @Digits(integer = 3, fraction = 0)
    private Long pageSize;

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getProductClassificationId() {
        return productClassificationId;
    }

    public void setProductClassificationId(String productClassificationId) {
        this.productClassificationId = productClassificationId;
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