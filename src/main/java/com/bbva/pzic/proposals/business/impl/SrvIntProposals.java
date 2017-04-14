package com.bbva.pzic.proposals.business.impl;

import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.pzic.proposals.business.ISrvIntProposals;
import com.bbva.pzic.proposals.business.dto.*;
import com.bbva.pzic.proposals.canonic.ExternalFinancingProposal;
import com.bbva.pzic.proposals.canonic.ProposalData;
import com.bbva.pzic.proposals.dao.IListProposalsDAO;
import com.bbva.pzic.proposals.dao.IProposalsDAO;
import com.bbva.pzic.proposals.util.Errors;
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
    private IProposalsDAO proposalsDAO;

    @Autowired
    private Validator validator;

    /**
     * @see ISrvIntProposals#listProposals(DTOInputListProposals)
     */
    @Override
    public ProposalData listProposals(DTOInputListProposals queryFilter) {
        LOG.info("... called method SrvIntProposals.listproposals ...");
        if (queryFilter.getCustomerId() == null
                && (queryFilter.getDocumentType() == null || queryFilter.getDocumentNumber() == null)) {
            throw new BusinessServiceException(Errors.PARAMETERS_MISSING);
        }
        validator.validate(queryFilter);

        return listProposalsDAO.listProposals(queryFilter);
    }

    /**
     * @see ISrvIntProposals#listExternalFinancingProposals(com.bbva.pzic.proposals.business.dto.DTOInputListExternalFinancingProposals)
     */
    @Override
    public DTOOutExternalFinancingProposalData listExternalFinancingProposals(DTOInputListExternalFinancingProposals dtoIn) {
        LOG.info("... called method SrvIntProposals.listExternalFinancingProposals ...");
        validator.validate(dtoIn, ValidationGroup.ListExternalFinancingProposals.class);
        return proposalsDAO.listExternalFinancingProposals(dtoIn);
    }

    @Override
    public ExternalFinancingProposal createExternalFinancingProposal(DTOIntExternalFinancingProposal dtoIn) {
        LOG.info("... called method SrvIntProposals.createExternalFinancingProposal ...");
        validator.validate(dtoIn, ValidationGroup.CreateExternalFinancingProposal.class);
        return proposalsDAO.createExternalFinancingProposal(dtoIn);
    }
}
