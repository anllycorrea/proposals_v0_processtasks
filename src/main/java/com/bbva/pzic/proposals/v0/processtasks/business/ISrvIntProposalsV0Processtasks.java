package com.bbva.pzic.proposals.v0.processtasks.business;

import com.bbva.pzic.proposals.v0.processtasks.business.dto.InputListProcessTasksProposals;
import com.bbva.pzic.proposals.v0.processtasks.facade.dto.ProcessTasks;

public interface ISrvIntProposalsV0Processtasks {

    ProcessTasks listProcessTasksProposals (InputListProcessTasksProposals input);
}
