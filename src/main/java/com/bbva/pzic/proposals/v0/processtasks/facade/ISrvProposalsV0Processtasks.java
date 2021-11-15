package com.bbva.pzic.proposals.v0.processtasks.facade;

import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponse;
import com.bbva.pzic.proposals.v0.processtasks.facade.dto.ProcessTasks;

public interface ISrvProposalsV0Processtasks {

    ServiceResponse<ProcessTasks> listProcessTasksProposals(String businessProcessId, String taskId);
}
