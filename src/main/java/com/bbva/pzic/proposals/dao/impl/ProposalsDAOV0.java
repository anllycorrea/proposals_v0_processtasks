package com.bbva.pzic.proposals.dao.impl;

import com.bbva.pzic.proposals.business.dto.*;
import com.bbva.pzic.proposals.canonic.ExternalFinancingProposal;
import com.bbva.pzic.proposals.canonic.Proposal;
import com.bbva.pzic.proposals.canonic.SimulatedProposalsData;
import com.bbva.pzic.proposals.dao.IProposalsDAOV0;
import com.bbva.pzic.proposals.dao.tx.*;
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
public class ProposalsDAOV0 implements IProposalsDAOV0 {

    private static final Log LOG = LogFactory.getLog(ProposalsDAOV0.class);

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

    @Override
    public List<Proposal> listProposals(final InputListProposals listProposals) {
        LOG.info("... Invoking method ProposalsDAO.listProposals ...");
        return txListProposalsV0.invoke(listProposals);
    }

    @Override
    public SimulatedProposalsData simulateProposals(final DTOIntSimulatedProposal simulatedProposal) {
        LOG.info("... Invoking method ProposalsDAO.simulateProposals ...");
        return restSimulateProposals.invoke(simulatedProposal);
    }

    /**
     * @see IProposalsDAOV0#createExternalFinancingProposal(com.bbva.pzic.proposals.business.dto.DTOIntExternalFinancingProposal)
     */
    @Override
    public ExternalFinancingProposal createExternalFinancingProposal(final DTOIntExternalFinancingProposal dtoIn) {
        return txCreateExternalFinancingProposal.invoke(dtoIn);
    }

    /**
     * @see IProposalsDAOV0#listExternalFinancingProposals(com.bbva.pzic.proposals.business.dto.DTOInputListExternalFinancingProposals)
     */
    @Override
    public DTOOutExternalFinancingProposalData listExternalFinancingProposals(final DTOInputListExternalFinancingProposals dtoIn) {
        return txListExternalFinancingProposals.invoke(dtoIn);
    }

    /**
     * @see IProposalsDAOV0#modifyExternalFinancingProposal(com.bbva.pzic.proposals.business.dto.DTOInputModifyExternalFinancingProposal)
     */
    @Override
    public void modifyExternalFinancingProposal(final DTOInputModifyExternalFinancingProposal dtoIn) {
        txModifyExternalFinancingProposal.invoke(dtoIn);
    }
}