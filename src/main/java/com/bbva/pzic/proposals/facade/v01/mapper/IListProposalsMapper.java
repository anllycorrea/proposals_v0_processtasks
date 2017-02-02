package com.bbva.pzic.proposals.facade.v01.mapper;

import com.bbva.pzic.proposals.business.dto.DTOInputListProposals;

/**
 * Created on 06/12/2016.
 *
 * @author Entelgy
 */
public interface IListProposalsMapper {

    /**
     * Creates a new {@Link DTOInputListProposals} instance and initializes it with the provided parameters.
     *
     * @param customerId
     * @param documentType
     * @param documentNumber
     * @param productClassification
     * @param paginationKey
     * @param pageSize
     * @return the created object
     */
    DTOInputListProposals mapInput(String customerId, String documentType, String documentNumber, String productClassification,
                                   String paginationKey, Long pageSize);

}
