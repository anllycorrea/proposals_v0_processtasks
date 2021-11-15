package com.bbva.pzic.proposals.v0.processtasks.facade.mapper;

import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponse;
import com.bbva.pzic.proposals.v0.processtasks.business.dto.InputListProcessTasksProposals;
import com.bbva.pzic.proposals.v0.processtasks.facade.dto.ProcessTasks;

import java.util.List;

public interface IListProcessTasksProposalsMapper {
    InputListProcessTasksProposals mapIn(String businessProcessId, String taskId);
    ServiceResponse<ProcessTasks> mapOut(ProcessTasks processTasks);
}
