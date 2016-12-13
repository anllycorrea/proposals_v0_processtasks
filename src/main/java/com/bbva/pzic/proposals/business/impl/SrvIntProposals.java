package com.bbva.pzic.proposals.business.impl;

import com.bbva.pzic.proposals.business.ISrvIntProposals;
import com.bbva.pzic.proposals.business.dto.DTOInputListProposals;
import com.bbva.pzic.proposals.canonic.Indicator;
import com.bbva.pzic.proposals.canonic.Proposal;
import com.bbva.pzic.proposals.canonic.ProposalData;
import com.bbva.pzic.proposals.dao.IListProposalsDAO;
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

        private final static String DOCUMENT_TYPE_FIELD_PROPERTY = "documentType.id";
        private final static String PRODUCT_CLASSIFICATION_FIELD_PROPERTY = "product.productClassification.id";
        private final static String TERM_ID_FIELD_PROPERTY = "term.termId";
        private final static String PRODUCT_TYPE_ID_FIELD_PROPERTY = "product.productType.id";
        private final static String RISK_TYPE_ID_FIELD_PROPERTY = "riskType.id";

        private void convertInput(DTOInputListProposals dtoInputListProposals) {
            dtoInputListProposals.setDocumentType(propertyReader.getInputEnumPropertyValue(DOCUMENT_TYPE_FIELD_PROPERTY, dtoInputListProposals.getDocumentType()));
            if (dtoInputListProposals.getProductClassification() != null) {
                dtoInputListProposals.setProductClassification(
                        propertyReader.getInputEnumPropertyValue(PRODUCT_CLASSIFICATION_FIELD_PROPERTY, dtoInputListProposals.getProductClassification()));
            }
        }

        private void convertOutput(ProposalData proposalData) {
            if (proposalData != null && proposalData.getData() != null) {
                for (final Proposal proposal : proposalData.getData()) {
                    if (proposal != null) {
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
                        if (proposal.getTerm() != null && proposal.getTerm().getTermId() != null) {
                            proposal.getTerm().setTermId(
                                    propertyReader.getOutputEnumPropertyValue(TERM_ID_FIELD_PROPERTY,
                                            proposal.getTerm().getTermId()));
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

}
