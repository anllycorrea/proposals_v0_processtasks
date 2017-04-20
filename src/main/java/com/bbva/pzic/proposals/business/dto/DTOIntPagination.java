package com.bbva.pzic.proposals.business.dto;

/**
 * Created on 12/04/2017.
 *
 * @author Entelgy
 */
public class DTOIntPagination {

    private String paginationKey;
    private Long pageSize;

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