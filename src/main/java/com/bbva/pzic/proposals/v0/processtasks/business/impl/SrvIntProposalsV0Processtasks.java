package com.bbva.pzic.proposals.v0.processtasks.business.impl;

import com.bbva.pzic.proposals.v0.processtasks.business.ISrvIntProposalsV0Processtasks;
import com.bbva.pzic.proposals.v0.processtasks.business.dto.InputListProcessTasksProposals;
import com.bbva.pzic.proposals.v0.processtasks.dao.IProposalsDAOV0Processtasks;
import com.bbva.pzic.proposals.v0.processtasks.facade.dto.ProcessTasks;
import com.bbva.pzic.proposals.v0.processtasks.util.ValidationGroup;
import com.bbva.pzic.routine.validator.Validator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SrvIntProposalsV0Processtasks implements ISrvIntProposalsV0Processtasks {


    private static final Log LOG = LogFactory.getLog(SrvIntProposalsV0Processtasks.class);

    @Autowired
    private Validator validator;

    @Autowired
    private IProposalsDAOV0Processtasks proposalsDAOV0Proposals;


    @Override
    public ProcessTasks listProcessTasksProposals(final InputListProcessTasksProposals input) {
        LOG.info("... Invoking method SrvIntProposalsV0Processtasks.listProcessTasksProposals APX ...");
        LOG.info("... Validating listProcessTasksProposals input parameter...");
        validator.validate(input, ValidationGroup.ListProcessTasksProposals.class);
        return proposalsDAOV0Proposals.listProcessTasksProposals(input);
    }
}
