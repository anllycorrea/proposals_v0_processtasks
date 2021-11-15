package com.bbva.pzic.proposals.v0.processtasks.facade.mapper.impl;

import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponse;
import com.bbva.pzic.proposals.v0.processtasks.business.dto.InputListProcessTasksProposals;
import com.bbva.pzic.proposals.v0.processtasks.facade.dto.ProcessTasks;
import com.bbva.pzic.proposals.v0.processtasks.facade.mapper.IListProcessTasksProposalsMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class ListProcessTasksProposalsMapper implements IListProcessTasksProposalsMapper {

    private static final Log LOG = LogFactory.getLog(ListProcessTasksProposalsMapper.class);

    @Override
    public InputListProcessTasksProposals mapIn(final String businessProcessId, final String taskId) {

        LOG.info("... called method ListProcessTasksProposalsMapper.mapIn ...");

        InputListProcessTasksProposals dtoIn = new InputListProcessTasksProposals();
        dtoIn.setBusinessProcessId(businessProcessId);
        dtoIn.setTaskId(taskId);
        return dtoIn;
    }

    @Override
    public ServiceResponse<ProcessTasks> mapOut(final ProcessTasks processTasks) {
        LOG.info("... called method ListProcessTasksProposalsMapper.mapOut ...");
        if (processTasks == null){
            return null;
        }
        return ServiceResponse.data(processTasks).build();
    }
}
