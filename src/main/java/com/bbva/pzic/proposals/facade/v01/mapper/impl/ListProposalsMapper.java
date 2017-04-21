package com.bbva.pzic.proposals.facade.v01.mapper.impl;

import com.bbva.pzic.proposals.business.dto.DTOInputListProposals;
import com.bbva.pzic.proposals.canonic.Proposal;
import com.bbva.pzic.proposals.canonic.ProposalData;
import com.bbva.pzic.proposals.facade.v01.mapper.IListProposalsMapper;
import com.bbva.pzic.proposals.util.mappers.EnumMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created on 06/12/2016.
 *
 * @author Entelgy
 */
@Component
public class ListProposalsMapper implements IListProposalsMapper {

    @Autowired
    private EnumMapper enumMapper;

    private EnumeratorConverter enumeratorConverter;

    public ListProposalsMapper() {
        enumeratorConverter = new EnumeratorConverter();
    }

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

        enumeratorConverter.convertInput(dtoInputListProposals);

        return dtoInputListProposals;
    }

    public ProposalData mapOut(ProposalData proposalData) {
        if (proposalData.getData() != null) {
            enumeratorConverter.convertOutput(proposalData);
        }
        return proposalData;
    }

    private class EnumeratorConverter {

        private static final String DOCUMENT_TYPE_FIELD_PROPERTY = "documentType.id";
        private static final String PRODUCT_CLASSIFICATION_FIELD_PROPERTY = "product.productClassification.id";
        private static final String TERM_ID_FIELD_PROPERTY = "conditions.period.id";
        private static final String PRODUCT_TYPE_ID_FIELD_PROPERTY = "product.productType.id";
        private static final String RISK_TYPE_ID_FIELD_PROPERTY = "proposals.riskType.id";
        private static final String PROCUREMENT_FLOW_ID_ID_FIELD_PROPERTY = "proposals.procurementFlow.id";

        private void convertInput(final DTOInputListProposals dtoInputListProposals) {
            dtoInputListProposals.setDocumentType(enumMapper.getBackendValue(DOCUMENT_TYPE_FIELD_PROPERTY, dtoInputListProposals.getDocumentType()));
            dtoInputListProposals.setProductClassificationId(
                    enumMapper.getBackendValue(PRODUCT_CLASSIFICATION_FIELD_PROPERTY, dtoInputListProposals.getProductClassificationId()));
        }

        private void convertOutput(final ProposalData proposalData) {
            for (final Proposal proposal : proposalData.getData()) {
                if (proposal.getProduct() != null) {
                    if (proposal.getProduct().getProductClassification() != null) {
                        proposal.getProduct().getProductClassification().setId(
                                enumMapper.getEnumValue(PRODUCT_CLASSIFICATION_FIELD_PROPERTY,
                                        proposal.getProduct().getProductClassification().getId()));
                    }
                    if (proposal.getProduct().getProductType() != null) {
                        proposal.getProduct().getProductType().setId(
                                enumMapper.getEnumValue(PRODUCT_TYPE_ID_FIELD_PROPERTY,
                                        proposal.getProduct().getProductType().getId()));
                    }
                }
                if (proposal.getProcurementFlow() != null) {
                    proposal.getProcurementFlow().setId(
                            enumMapper.getEnumValue(PROCUREMENT_FLOW_ID_ID_FIELD_PROPERTY,
                                    proposal.getProcurementFlow().getId()));
                }
                if (proposal.getTerm() != null) {
                    proposal.getTerm().setId(
                            enumMapper.getEnumValue(TERM_ID_FIELD_PROPERTY,
                                    proposal.getTerm().getId()));
                }
                if (proposal.getRiskType() != null) {
                    proposal.getRiskType().setId(
                            enumMapper.getEnumValue(RISK_TYPE_ID_FIELD_PROPERTY,
                                    proposal.getRiskType().getId()));
                }
            }
        }
    }
}
