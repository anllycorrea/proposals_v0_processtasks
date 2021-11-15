package com.bbva.pzic.proposals.v0.processtasks.dao.impl;

import com.bbva.pzic.proposals.v0.processtasks.business.dto.InputListProcessTasksProposals;
import com.bbva.pzic.proposals.v0.processtasks.dao.IProposalsDAOV0Processtasks;
import com.bbva.pzic.proposals.v0.processtasks.dao.apx.ApxListProcessTasksProposals;
import com.bbva.pzic.proposals.v0.processtasks.facade.dto.ProcessTasks;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProposalsDAOV0Processtasks implements IProposalsDAOV0Processtasks {
    private static final Log LOG = LogFactory.getLog(ProposalsDAOV0Processtasks.class);

    @Autowired
    private ApxListProcessTasksProposals apxListProcessTasksProposals;

    @Override
    public ProcessTasks listProcessTasksProposals(final InputListProcessTasksProposals input) {
        LOG.info("... Invoking method ProposalsDAOV0Processtasks.listProcessTasksProposals APX ...");

        return apxListProcessTasksProposals.perform(input);
    }
}
