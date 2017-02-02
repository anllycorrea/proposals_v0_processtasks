package com.bbva.pzic.proposals.facade.v01.mapper.impl;

import com.bbva.pzic.proposals.business.dto.DTOInputListProposals;
import com.bbva.pzic.proposals.facade.v01.mapper.IListProposalsMapper;
import org.springframework.stereotype.Component;

/**
 * Created on 06/12/2016.
 *
 * @author Entelgy
 */
@Component
public class ListProposalsMapper implements IListProposalsMapper {

    /**
     * @see IListProposalsMapper#mapInput(String, String, String, String, String, Long)
     */
    @Override
    public DTOInputListProposals mapInput(String customerId, String documentType, String documentNumber, String productClassification, String paginationKey, Long pageSize) {
        final DTOInputListProposals dtoInputListProposals = new DTOInputListProposals();
        dtoInputListProposals.setCustomerId(customerId);
        dtoInputListProposals.setDocumentType(documentType);
        dtoInputListProposals.setDocumentNumber(documentNumber);
        dtoInputListProposals.setProductClassificationId(productClassification);
        dtoInputListProposals.setPaginationKey(paginationKey);
        dtoInputListProposals.setPageSize(pageSize);
        return dtoInputListProposals;
    }

}
