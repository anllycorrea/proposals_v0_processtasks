package com.bbva.pzic.proposals.dao.impl;

import com.bbva.pzic.proposals.business.dto.DTOIntSimulatedProposal;
import com.bbva.pzic.proposals.business.dto.InputListProposals;
import com.bbva.pzic.proposals.canonic.Proposal;
import com.bbva.pzic.proposals.canonic.SimulatedProposalsData;
import com.bbva.pzic.proposals.dao.IProposalsDAOV0;
import com.bbva.pzic.proposals.dao.tx.RestSimulateProposals;
import com.bbva.pzic.proposals.dao.tx.TxListProposalsV0;
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
}