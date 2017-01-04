package com.bbva.pzic.proposals.facade.v01;

import javax.ws.rs.core.Response;

/**
 * @author Entelgy
 */
public interface ISrvProposalsV01 {

    String DOCUMENT_TYPE = "documentType";
    String DOCUMENT_NUMBER = "documentNumber";
    String PRODUCT_CLASSIFICATION = "productClassification";
    String PAGINATION_KEY = "paginationKey";
    String PAGE_SIZE = "pageSize";

    /**
     * Method for retrieving the list of proposals related to a specific person.
     *
     * @param documentType          Filters the proposals by document type.
     * @param documentNumber        Filters the proposals by document number.
     * @param productClassification Filters the proposals list by financial product classification.
     * @param paginationKey         Key to obtain a single page
     * @param pageSize              Number of elements per page
     * @return a list of proposals
     */
    Response listProposals(String documentType, String documentNumber, String productClassification,
                           String paginationKey, Long pageSize);

}