package com.bbva.pzic.proposals.v0.processtasks.dao.apx.mapper;

import com.bbva.pzic.proposals.v0.processtasks.business.dto.InputListProcessTasksProposals;
import com.bbva.pzic.proposals.v0.processtasks.dao.model.ppcutge1_1.PeticionTransaccionPpcutge1_1;
import com.bbva.pzic.proposals.v0.processtasks.dao.model.ppcutge1_1.RespuestaTransaccionPpcutge1_1;
import com.bbva.pzic.proposals.v0.processtasks.facade.dto.ProcessTasks;

public interface IApxListProcessTasksProposalsMappers {
    PeticionTransaccionPpcutge1_1 mapIn(InputListProcessTasksProposals input);
    ProcessTasks mapOut(RespuestaTransaccionPpcutge1_1 respuesta);
}
