package com.bbva.pzic.proposals.dao.impl;

import com.bbva.pzic.proposals.business.dto.DTOIntProposals;
import com.bbva.pzic.proposals.business.dto.DTOIntSimulatedProposal;
import com.bbva.pzic.proposals.business.dto.InputListProposals;
import com.bbva.pzic.proposals.canonic.SimulatedProposalsData;
import com.bbva.pzic.proposals.dao.IProposalsDAOV0;
import com.bbva.pzic.proposals.dao.tx.TxListProposalsV0;
import com.bbva.pzic.proposals.dao.tx.TxSimulateProposals;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created on 28/12/2017.
 *
 * @author Entelgy
 */
@Repository
public class ProposalsDAOV0 implements IProposalsDAOV0 {
    private static final Log LOG = LogFactory.getLog(ProposalsDAO.class);

    @Autowired
    private TxListProposalsV0 txListProposalsV0;

    @Autowired
    private TxSimulateProposals txSimulateProposals;

    @Override
    public DTOIntProposals listProposals(final InputListProposals listProposals) {
        LOG.info("... Invoking method ProposalsDAO.listProposals ...");
        return null;
    }

    @Override
    public SimulatedProposalsData simulateProposals(final DTOIntSimulatedProposal simulatedProposal) {
        LOG.info("... Invoking method ProposalsDAO.simulateProposals ...");
        return null;//txSimulateProposals.invoke(simulatedProposal);
    }
}