package com.bbva.pzic.proposals.facade.v01;

import com.bbva.pzic.proposals.canonic.ExternalFinancingProposal;

import javax.ws.rs.core.Response;

/**
 * @author Entelgy
 */
public interface ISrvProposalsV01 {

    String CUSTOMER_ID = "customerId";
    String DOCUMENT_TYPE = "documentType";
    String DOCUMENT_NUMBER = "documentNumber";
    String PRODUCT_CLASSIFICATION_ID = "product.productClassification.id";
    String PAGINATION_KEY = "paginationKey";
    String PAGE_SIZE = "pageSize";

    /**
     * Method for retrieving the list of proposals related to a specific person.
     *
     * @param customerId            Filters the proposals by customer id.
     * @param documentType          Filters the proposals by document type.
     * @param documentNumber        Filters the proposals by document number.
     * @param productClassification Filters the proposals list by financial product classification.
     * @param paginationKey         Key to obtain a single page
     * @param pageSize              Number of elements per page
     * @return a list of proposals
     */
    Response listProposals(String customerId, String documentType, String documentNumber, String productClassification,
                           String paginationKey, Long pageSize);

    /**
     * Method for consulting external financing proposals.
     *
     * @param thirdPartyProviderId                  Filters the external financing proposals's by third party provider identifier
     * @param holderIdentityDocumentsDocumentTypeId Filters the external financing proposals's by document type
     * @param holderIdentityDocumentsDocumentNumber Filters the external financing proposals's by document number
     * @param fromRequestDate                       Filters for the external financing proposals's which request date is later than this one (ISO-8601 date format)
     * @param toRequestDate                         Filters for the external financing proposals's which request date is earlier than this one (ISO-8601 date format)
     * @param paginationKey                         Key to obtain a single page
     * @param pageSize                              Number of elements per page
     * @return a list of external financing proposals
     */
    Response listExternalFinancingProposals(String thirdPartyProviderId,
                                            String holderIdentityDocumentsDocumentTypeId, String holderIdentityDocumentsDocumentNumber,
                                            String fromRequestDate, String toRequestDate, String paginationKey, Long pageSize);

    /**
     * Method for creating an external financing proposal.
     *
     * @param payload Entity payload
     * @return status of the response
     */
    Response createExternalFinancingProposal(ExternalFinancingProposal payload);

    /**
     * Method for updating the attributes of an external financing proposal.
     *
     * @param externalFinancingProposalId Identifier of the external financing proposal
     * @param payload                     Entity payload
     * @return status of the response
     */
    Response modifyExternalFinancingProposal(String externalFinancingProposalId, ExternalFinancingProposal payload);

}