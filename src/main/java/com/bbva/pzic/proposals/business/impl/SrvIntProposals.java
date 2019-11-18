package com.bbva.pzic.proposals.business.impl;

import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.pzic.proposals.business.ISrvIntProposals;
import com.bbva.pzic.proposals.business.dto.*;
import com.bbva.pzic.proposals.canonic.ExternalFinancingProposal;
import com.bbva.pzic.proposals.canonic.Proposal;
import com.bbva.pzic.proposals.dao.IProposalsDAO;
import com.bbva.pzic.proposals.facade.v0.dto.ValidateAccess;
import com.bbva.pzic.proposals.util.Errors;
import com.bbva.pzic.routine.validator.Validator;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 28/12/2017.
 *
 * @author Entelgy
 */
@Service
public class SrvIntProposals implements ISrvIntProposals {

    private static final Log LOG = LogFactory.getLog(SrvIntProposals.class);
    @Autowired
    private IProposalsDAO proposalsDAO;
    @Autowired
    private Validator validator;

    @Override
    public List<Proposal> listProposals(final InputListProposals inputListProposals) {
        LOG.info("... Invoking method SrvIntProposals.listProposals ...");
        LOG.info("... Validating listProposals input parameter ...");
        validator.validate(inputListProposals, ValidationGroup.ListProposalsV0.class);

        if (inputListProposals.getCustomerId() == null &&
                (inputListProposals.getDocumentTypeId() == null && inputListProposals.getDocumentNumber() == null)) {
            throw new BusinessServiceException(Errors.MANDATORY_PARAMETERS_MISSING);
        } else if (inputListProposals.getCustomerId() == null && (inputListProposals.getDocumentTypeId() == null
                || inputListProposals.getDocumentNumber() == null)) {
            throw new BusinessServiceException(Errors.PARAMETERS_MISSING);
        }
        return proposalsDAO.listProposals(inputListProposals);
    }

    @Override
    public DTOIntSimulatedProposals simulateProposals(final DTOIntSimulatedProposal simulatedProposal) {
        LOG.info("... Invoking method SrvIntProposals.simulateProposals ...");
        LOG.info("... Validating simulateProposals input parameter ...");
        validator.validate(simulatedProposal, ValidationGroup.SimulateProposals.class);
        return proposalsDAO.simulateProposals(simulatedProposal);
    }

    /**
     * @see ISrvIntProposals#createExternalFinancingProposal(com.bbva.pzic.proposals.business.dto.DTOIntExternalFinancingProposal)
     */
    @Override
    public ExternalFinancingProposal createExternalFinancingProposal(final DTOIntExternalFinancingProposal dtoIn) {
        LOG.info("... called method SrvIntProposals.createExternalFinancingProposal ...");
        validator.validate(dtoIn, ValidationGroup.CreateExternalFinancingProposal.class);
        return proposalsDAO.createExternalFinancingProposal(dtoIn);
    }

    /**
     * @see ISrvIntProposals#listExternalFinancingProposals(com.bbva.pzic.proposals.business.dto.DTOInputListExternalFinancingProposals)
     */
    @Override
    public DTOOutExternalFinancingProposalData listExternalFinancingProposals(final DTOInputListExternalFinancingProposals dtoIn) {
        LOG.info("... called method SrvIntProposals.listExternalFinancingProposals ...");
        validator.validate(dtoIn, ValidationGroup.ListExternalFinancingProposals.class);
        return proposalsDAO.listExternalFinancingProposals(dtoIn);
    }

    /**
     * @see ISrvIntProposals#modifyExternalFinancingProposal(com.bbva.pzic.proposals.business.dto.DTOInputModifyExternalFinancingProposal)
     */
    @Override
    public void modifyExternalFinancingProposal(final DTOInputModifyExternalFinancingProposal dtoIn) {
        LOG.info("... called method SrvIntProposals.createExternalFinancingProposal ...");
        validator.validate(dtoIn, ValidationGroup.ModifyExternalFinancingProposal.class);
        proposalsDAO.modifyExternalFinancingProposal(dtoIn);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ValidateAccess createQuestionnairesValidateAccess(final DTOIntValidateAccess dtoInt) {
        LOG.info("... Invoking method SrvIntProposals.createQuestionnairesValidateAccess ...");
        LOG.info("... Validating createQuestionnairesValidateAccess input parameter ...");
        validator.validate(dtoInt, ValidationGroup.CreateQuestionnairesValidateAccess.class);

        if (CollectionUtils.isNotEmpty(dtoInt.getParticipant().getContacts())) {
            for (DTOIntContact contact : dtoInt.getParticipant().getContacts()) {
                if ("EMAIL".equals(contact.getContactDetailType())) {
                    validator.validate(contact, ValidationGroup.CreateQuestionnairesValidateAccessEmail.class);

                } else if ("MOBILE".equals(contact.getContactDetailType())) {
                    validator.validate(contact, ValidationGroup.CreateQuestionnairesValidateAccessMobile.class);

                } else {
                    LOG.warn(String.format("Unrecognized type %s", contact.getContactDetailType()));
                }
            }
        }

        return proposalsDAO.createQuestionnairesValidateAccess(dtoInt);
    }
}
