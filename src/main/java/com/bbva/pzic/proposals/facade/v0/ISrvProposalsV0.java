package com.bbva.pzic.proposals.facade.v0;

import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponse;
import com.bbva.pzic.proposals.canonic.ExternalFinancingProposal;
import com.bbva.pzic.proposals.canonic.ExternalFinancingProposalData;
import com.bbva.pzic.proposals.canonic.Proposal;
import com.bbva.pzic.proposals.canonic.SimulatedProposal;
import com.bbva.pzic.proposals.facade.v0.dto.ValidateAccess;

import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created on 28/12/2017.
 *
 * @author Entelgy
 */
public interface ISrvProposalsV0 {

    String THIRD_PARTY_PROVIDER_ID = "thirdPartyProvider.id";
    String EXTERNAL_PRODUCT_CATEGORY_TYPE_ID = "externalProduct.category.categoryType.id";
    String HOLDER_IDENTITY_DOCUMENTS_DOCUMENT_TYPE_ID = "holder.identityDocuments.documentType.id";
    String HOLDER_IDENTITY_DOCUMENTS_DOCUMENT_NUMBER = "holder.identityDocuments.documentNumber";
    String FROM_REQUEST_DATE = "fromRequestDate";
    String TO_REQUEST_DATE = "toRequestDate";

    /**
     * Service for retrieving the list of proposals related to a specific person.
     *
     * @param documentTypeId filters the proposals by document type.
     * @param documentNumber filters the proposals by document number.
     * @param customerId     filters the proposals by unique customer identifier.
     * @return {@link List<Proposal>}
     */
    ServiceResponse<List<Proposal>> listProposals(String documentTypeId,
                                                  String documentNumber, String customerId);

    /**
     * Service for simulating a set of proposals.
     *
     * @param simulatedProposal payload
     * @return {@link List<SimulatedProposal>}
     */
    ServiceResponse<List<SimulatedProposal>> simulateProposals(SimulatedProposal simulatedProposal);

    /**
     * Method for creating an external financing proposal.
     *
     * @param thirdPartyProviderUserId Third party provider user id
     * @param payload                  Entity payload
     * @return status of the response
     */
    ExternalFinancingProposal createExternalFinancingProposal(String thirdPartyProviderUserId, ExternalFinancingProposal payload);

    /**
     * Method for consulting external financing proposals.
     *
     * @param thirdPartyProviderId                  Filters the external financing proposals's by third party provider identifier
     * @param externalproductCategoryTypeId         Filters the external product proposals's by category type identifier
     * @param holderIdentityDocumentsDocumentTypeId Filters the external financing proposals's by document type
     * @param holderIdentityDocumentsDocumentNumber Filters the external financing proposals's by document number
     * @param fromRequestDate                       Filters for the external financing proposals's which request date is later than this one (ISO-8601 date format)
     * @param toRequestDate                         Filters for the external financing proposals's which request date is earlier than this one (ISO-8601 date format)
     * @param paginationKey                         Key to obtain a single page
     * @param pageSize                              Number of elements per page
     * @return a list of external financing proposals
     */
    ExternalFinancingProposalData listExternalFinancingProposals(String thirdPartyProviderId, String externalproductCategoryTypeId,
                                                                 String holderIdentityDocumentsDocumentTypeId, String holderIdentityDocumentsDocumentNumber,
                                                                 String fromRequestDate, String toRequestDate, String paginationKey, Long pageSize);

    /**
     * Method for updating the attributes of an external financing proposal.
     *
     * @param externalFinancingProposalId Identifier of the external financing proposal
     * @param payload                     Entity payload
     * @return status of the response
     */
    Response modifyExternalFinancingProposal(String externalFinancingProposalId, ExternalFinancingProposal payload);

    /**
     * Validation of access to channels not sessioned for customers and
     * non-customers.
     *
     * @param validateAccess payload
     * @return {@link ServiceResponse<ValidateAccess>}
     */
    ServiceResponse<ValidateAccess> createQuestionnairesValidateAccess(ValidateAccess validateAccess);
}
