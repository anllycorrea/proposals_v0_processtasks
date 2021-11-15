package com.bbva.pzic.proposals.v0.processtasks.dao;

import com.bbva.pzic.proposals.v0.processtasks.business.dto.InputListProcessTasksProposals;
import com.bbva.pzic.proposals.v0.processtasks.facade.dto.ProcessTasks;

public interface IProposalsDAOV0Processtasks {

    ProcessTasks listProcessTasksProposals(InputListProcessTasksProposals input);
}
