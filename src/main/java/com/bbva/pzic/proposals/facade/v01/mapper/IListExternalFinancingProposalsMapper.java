package com.bbva.pzic.proposals.facade.v01.mapper;

import com.bbva.pzic.proposals.business.dto.DTOInputListExternalFinancingProposals;
import com.bbva.pzic.proposals.business.dto.DTOOutExternalFinancingProposalData;
import com.bbva.pzic.proposals.canonic.ExternalFinancingProposalData;

/**
 * Created on 12/04/2017.
 *
 * @author Entelgy
 */
public interface IListExternalFinancingProposalsMapper {

    /**
     * Mepeo de entrada, los datos obtenidos por la  URL pasados a un DTO la cual tiene
     * anotaciones de validacion
     *
     * @param thirdPartyProviderId                  Filters the external financing proposals's by third party provider identifier
     * @param holderIdentityDocumentsDocumentTypeId Filters the external financing proposals's by document type
     * @param holderIdentityDocumentsDocumentNumber Filters the external financing proposals's by document number
     * @param fromRequestDate                       Filters for the external financing proposals's which request date is later than this one (ISO-8601 date format)
     * @param toRequestDate                         Filters for the external financing proposals's which request date is earlier than this one (ISO-8601 date format)
     * @param paginationKey                         Key to obtain a single page
     * @param pageSize                              Number of elements per page
     * @return {@link DTOInputListExternalFinancingProposals}
     */
    DTOInputListExternalFinancingProposals mapIn(String thirdPartyProviderId, String holderIdentityDocumentsDocumentTypeId,
                                                 String holderIdentityDocumentsDocumentNumber, String fromRequestDate, String toRequestDate,
                                                 String paginationKey, Long pageSize);

    /**
     * Mapeo de salida de un DTO a un objeto canonic la cual se expondra al usuario
     *
     * @param dto DTO con los datos de salida
     * @return {@link ExternalFinancingProposalData}
     */
    ExternalFinancingProposalData mapOut(DTOOutExternalFinancingProposalData dto);
}