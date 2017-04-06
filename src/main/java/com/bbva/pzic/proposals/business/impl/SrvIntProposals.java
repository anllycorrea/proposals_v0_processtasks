package com.bbva.pzic.proposals.business.impl;

import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.pzic.proposals.business.ISrvIntProposals;
import com.bbva.pzic.proposals.business.dto.DTOInputListProposals;
import com.bbva.pzic.proposals.canonic.Proposal;
import com.bbva.pzic.proposals.canonic.ProposalData;
import com.bbva.pzic.proposals.dao.IListProposalsDAO;
import com.bbva.pzic.proposals.util.Errors;
import com.bbva.pzic.proposals.util.PropertyReader;
import com.bbva.pzic.proposals.util.validation.Validator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created on 06/12/2016.
 *
 * @author Entelgy
 */
@Component
public class SrvIntProposals implements ISrvIntProposals {

    private static final Log LOG = LogFactory.getLog(SrvIntProposals.class);

    @Autowired
    private IListProposalsDAO listProposalsDAO;

    @Autowired
    private Validator validator;

    @Autowired
    private PropertyReader propertyReader;

    /**
     * @see ISrvIntProposals#listProposals(DTOInputListProposals)
     */
    @Override
    public ProposalData listProposals(DTOInputListProposals queryFilter) {
        LOG.info("... called method SrvIntProposals.listProposals ...");
        LOG.info("... validating listProposals input parameters ...");
        if (queryFilter.getCustomerId() == null
                && (queryFilter.getDocumentType() == null || queryFilter.getDocumentNumber() == null)) {
            throw new BusinessServiceException(Errors.PARAMETERS_MISSING);
        }
        validator.validate(queryFilter);
        final EnumeratorConverter enumeratorConverter = new EnumeratorConverter();
        LOG.info("... converting listProposals input enumerators ...");
        enumeratorConverter.convertInput(queryFilter);
        final ProposalData proposalData = listProposalsDAO.listProposals(queryFilter);
        LOG.info("... converting listProposals output enumerators ...");
        enumeratorConverter.convertOutput(proposalData);
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
            dtoInputListProposals.setDocumentType(propertyReader.getInputEnumPropertyValue(DOCUMENT_TYPE_FIELD_PROPERTY, dtoInputListProposals.getDocumentType()));
            if (dtoInputListProposals.getProductClassificationId() != null) {
                dtoInputListProposals.setProductClassificationId(
                        propertyReader.getInputEnumPropertyValue(PRODUCT_CLASSIFICATION_FIELD_PROPERTY, dtoInputListProposals.getProductClassificationId()));
            }
        }

        private void convertOutput(final ProposalData proposalData) {
            if (proposalData.getData() != null) {
                for (final Proposal proposal : proposalData.getData()) {
                    if (proposal.getProduct() != null) {
                        if (proposal.getProduct().getProductClassification() != null
                                && proposal.getProduct().getProductClassification().getId() != null) {
                            proposal.getProduct().getProductClassification().setId(
                                    propertyReader.getOutputEnumPropertyValue(PRODUCT_CLASSIFICATION_FIELD_PROPERTY,
                                            proposal.getProduct().getProductClassification().getId()));
                        }
                        if (proposal.getProduct().getProductType() != null
                                && proposal.getProduct().getProductType().getId() != null) {
                            proposal.getProduct().getProductType().setId(
                                    propertyReader.getOutputEnumPropertyValue(PRODUCT_TYPE_ID_FIELD_PROPERTY,
                                            proposal.getProduct().getProductType().getId()));
                        }
                    }
                    if (proposal.getProcurementFlow() != null
                            && proposal.getProcurementFlow().getName() != null) {
                        proposal.getProcurementFlow().setId(
                                propertyReader.getOutputEnumPropertyValue(PROCUREMENT_FLOW_ID_ID_FIELD_PROPERTY,
                                        proposal.getProcurementFlow().getId()));
                    }
                    if (proposal.getTerm() != null && proposal.getTerm().getId() != null) {
                        proposal.getTerm().setId(
                                propertyReader.getOutputEnumPropertyValue(TERM_ID_FIELD_PROPERTY,
                                        proposal.getTerm().getId()));
                    }
                    if (proposal.getRiskType() != null && proposal.getRiskType().getId() != null) {
                        proposal.getRiskType().setId(
                                propertyReader.getOutputEnumPropertyValue(RISK_TYPE_ID_FIELD_PROPERTY,
                                        proposal.getRiskType().getId()));
                    }
                }
            }
        }
    }
}
