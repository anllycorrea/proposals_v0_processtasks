package com.bbva.pzic.proposals.facade.v01.mapper;

import com.bbva.pzic.proposals.business.dto.DTOInputListProposals;
import com.bbva.pzic.proposals.canonic.ProposalData;

/**
 * Created on 06/12/2016.
 *
 * @author Entelgy
 */
public interface IListProposalsMapper {

    /**
     * Creates a new {@link DTOInputListProposals} instance and initializes it with the provided parameters.
     *
     * @param customerId            filters the proposals by unique customer identifier
     * @param documentType          filters the proposals by document type
     * @param documentNumber        filters the proposals by document number
     * @param productClassification filters the proposals list by financial product classification
     * @param paginationKey         key to obtain a single page
     * @param pageSize              number of elements per page
     * @return the created object
     */
    DTOInputListProposals mapInput(String customerId, String documentType, String documentNumber, String productClassification,
                                   String paginationKey, Long pageSize);

    /**
     * Create a {@link com.bbva.pzic.proposals.canonic.ProposalData} with enums
     *
     * @param proposalData data
     * @return list updated
     */
    ProposalData mapOut(ProposalData proposalData);
}
