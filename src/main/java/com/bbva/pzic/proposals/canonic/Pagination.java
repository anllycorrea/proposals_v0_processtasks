package com.bbva.pzic.proposals.canonic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created on 10/05/2017.
 *
 * @author Entelgy
 */
@XmlRootElement(name = "Pagination", namespace = "urn:com:bbva:pzic:proposals:canonic")
@XmlType(name = "Pagination", namespace = "urn:com:bbva:pzic:proposals:canonic")
@XmlAccessorType(XmlAccessType.FIELD)
public class Pagination implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Pagination links. These links provide relative URIs to reach different
     * useful pages, such as first, last, next or previous pages.
     */
    private Links links;
    /**
     * Current page number. This attribue value is 0 when referring to the first
     * page.
     */
    private BigDecimal page;
    /**
     * Total number of pages for the provided pagination and filtering
     * parameters.
     */
    private BigDecimal totalPages;
    /**
     * Total number of items to the requested list, taking into account possible
     * filtering criteria if specified.
     */
    private BigDecimal totalElements;
    /**
     * Number of items per page. This attribute value matches pageSize query
     * parameter if provided. Otherwise, this attribute may provide the default
     * page size.
     */
    private BigDecimal pageSize;

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
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

    public BigDecimal getPageSize() {
        return pageSize;
    }

    public void setPageSize(BigDecimal pageSize) {
        this.pageSize = pageSize;
    }
}