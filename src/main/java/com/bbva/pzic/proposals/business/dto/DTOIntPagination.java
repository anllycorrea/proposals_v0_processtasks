package com.bbva.pzic.proposals.business.dto;


import javax.validation.Valid;
import java.math.BigDecimal;

/**
 * Created on 12/04/2017.
 * 
 * @author Entelgy
 */
public class DTOIntPagination {

	@Valid
	private DTOIntLinks links;
	private BigDecimal page;
	private BigDecimal totalPages;
	private BigDecimal totalElements;
	private Long pageSize;
	private String paginationKey;

	public DTOIntLinks getLinks() {
		return links;
	}

	public void setLinks(DTOIntLinks links) {
		this.links = links;
	}

	public BigDecimal getPage() {
		return page;
	}

	public void setPage(BigDecimal page) {
		this.page = page;
	}

	public BigDecimal getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(BigDecimal totalPages) {
		this.totalPages = totalPages;
	}

	public BigDecimal getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(BigDecimal totalElements) {
		this.totalElements = totalElements;
	}

	public Long getPageSize() {
		return pageSize;
	}

	public void setPageSize(Long pageSize) {
		this.pageSize = pageSize;
	}

	public String getPaginationKey() {
		return paginationKey;
	}

	public void setPaginationKey(String paginationKey) {
		this.paginationKey = paginationKey;
	}
}