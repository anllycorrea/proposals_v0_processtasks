package com.bbva.pzic.proposals.v0.processtasks.dao.apx.mapper.impl;

import com.bbva.pzic.proposals.v0.processtasks.business.dto.InputListProcessTasksProposals;
import com.bbva.pzic.proposals.v0.processtasks.dao.apx.mapper.IApxListProcessTasksProposalsMappers;
import com.bbva.pzic.proposals.v0.processtasks.dao.model.ppcutge1_1.PeticionTransaccionPpcutge1_1;
import com.bbva.pzic.proposals.v0.processtasks.dao.model.ppcutge1_1.RespuestaTransaccionPpcutge1_1;
import com.bbva.pzic.proposals.v0.processtasks.facade.dto.ProcessTasks;
import com.bbva.pzic.proposals.v0.processtasks.facade.dto.Status;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class ApxListProcessTasksProposalsMappers implements IApxListProcessTasksProposalsMappers {

    private static final Log LOG = LogFactory.getLog(ApxListProcessTasksProposalsMappers.class);

    @Override
    public PeticionTransaccionPpcutge1_1 mapIn(final InputListProcessTasksProposals input) {
        LOG.info("... called method ApxListProcessTasksProposalsMapper.mapIn ...");
        PeticionTransaccionPpcutge1_1 dtoIn = new PeticionTransaccionPpcutge1_1();
        dtoIn.setBusinessprocessid(input.getBusinessProcessId());
        dtoIn.setTaskid(input.getTaskId());
        return dtoIn;
    }


    @Override
    public ProcessTasks mapOut(final RespuestaTransaccionPpcutge1_1 respuesta) {

        LOG.info("...called method ApxListProcessTasksProposalsMapper.mapOut...");

        if(respuesta == null){
            return null;
        }

        ProcessTasks dtoOut = new ProcessTasks();
        dtoOut.setBusinessProcessId(respuesta.getCampo_1_businessprocessid());
        dtoOut.setTaskId(respuesta.getCampo_2_taskid());
        dtoOut.setStatus(mapOutStatus(respuesta.getStatus()));

        return dtoOut;
    }

    private Status mapOutStatus(com.bbva.pzic.proposals.v0.processtasks.dao.model.ppcutge1_1.Status status) {

        Status dtoOut = new Status();
        dtoOut.setId(status.getId());
        dtoOut.setDescription(status.getDescription());
        return dtoOut;
    }


}
