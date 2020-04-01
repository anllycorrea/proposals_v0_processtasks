package com.bbva.pzic.proposals.dao.impl;

import com.bbva.pzic.proposals.business.dto.*;
import com.bbva.pzic.proposals.canonic.ExternalFinancingProposal;
import com.bbva.pzic.proposals.canonic.Proposal;
import com.bbva.pzic.proposals.dao.IProposalsDAO;
import com.bbva.pzic.proposals.dao.apx.ApxCreateQuestionnairesValidateAccess;
import com.bbva.pzic.proposals.dao.rest.RestSimulateProposals;
import com.bbva.pzic.proposals.dao.tx.TxCreateExternalFinancingProposal;
import com.bbva.pzic.proposals.dao.tx.TxListExternalFinancingProposals;
import com.bbva.pzic.proposals.dao.tx.TxListProposalsV0;
import com.bbva.pzic.proposals.dao.tx.TxModifyExternalFinancingProposal;
import com.bbva.pzic.proposals.facade.v0.dto.ValidateAccess;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created on 28/12/2017.
 *
 * @author Entelgy
 */
@Repository
public class ProposalsDAO implements IProposalsDAO {

    private static final Log LOG = LogFactory.getLog(ProposalsDAO.class);

    @Autowired
    private TxListProposalsV0 txListProposalsV0;

    @Autowired
    private RestSimulateProposals restSimulateProposals;

    @Autowired
    private TxCreateExternalFinancingProposal txCreateExternalFinancingProposal;

    @Autowired
    private TxListExternalFinancingProposals txListExternalFinancingProposals;

    @Autowired
    private TxModifyExternalFinancingProposal txModifyExternalFinancingProposal;

    @Autowired
    private ApxCreateQuestionnairesValidateAccess apxCreateQuestionnairesValidateAccess;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Proposal> listProposals(final InputListProposals listProposals) {
        LOG.info("... Invoking method ProposalsDAO.listProposals ...");
        return txListProposalsV0.perform(listProposals);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DTOIntSimulatedProposals simulateProposals(final DTOIntSimulatedProposal simulatedProposal) {
        LOG.info("... Invoking method ProposalsDAO.simulateProposals ...");
        return restSimulateProposals.invoke(simulatedProposal);
    }

    /**
     * @see IProposalsDAO#createExternalFinancingProposal(com.bbva.pzic.proposals.business.dto.DTOIntExternalFinancingProposal)
     */
    @Override
    public ExternalFinancingProposal createExternalFinancingProposal(final DTOIntExternalFinancingProposal dtoIn) {
        LOG.info("... Invoking method ProposalsDAO.createExternalFinancingProposal ...");
        return txCreateExternalFinancingProposal.perform(dtoIn);
    }

    /**
     * @see IProposalsDAO#listExternalFinancingProposals(com.bbva.pzic.proposals.business.dto.DTOInputListExternalFinancingProposals)
     */
    @Override
    public DTOOutExternalFinancingProposalData listExternalFinancingProposals(final DTOInputListExternalFinancingProposals dtoIn) {
        LOG.info("... Invoking method ProposalsDAO.listExternalFinancingProposals ...");
        return txListExternalFinancingProposals.perform(dtoIn);
    }

    /**
     * @see IProposalsDAO#modifyExternalFinancingProposal(com.bbva.pzic.proposals.business.dto.DTOInputModifyExternalFinancingProposal)
     */
    @Override
    public void modifyExternalFinancingProposal(final DTOInputModifyExternalFinancingProposal dtoIn) {
        LOG.info("... Invoking method ProposalsDAO.modifyExternalFinancingProposal ...");
        txModifyExternalFinancingProposal.perform(dtoIn);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ValidateAccess createQuestionnairesValidateAccess(final DTOIntValidateAccess dtoInt) {
        LOG.info("... Invoking method ProposalsDAO.createQuestionnairesValidateAccess ...");
        return apxCreateQuestionnairesValidateAccess.invoke(dtoInt);
    }
}
