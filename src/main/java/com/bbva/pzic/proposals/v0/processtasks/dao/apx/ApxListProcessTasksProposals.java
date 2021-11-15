package com.bbva.pzic.proposals.v0.processtasks.dao.apx;

import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.pzic.proposals.v0.processtasks.business.dto.InputListProcessTasksProposals;
import com.bbva.pzic.proposals.v0.processtasks.dao.apx.mapper.IApxListProcessTasksProposalsMappers;
import com.bbva.pzic.proposals.v0.processtasks.dao.model.ppcutge1_1.PeticionTransaccionPpcutge1_1;
import com.bbva.pzic.proposals.v0.processtasks.dao.model.ppcutge1_1.RespuestaTransaccionPpcutge1_1;
import com.bbva.pzic.proposals.v0.processtasks.facade.dto.ProcessTasks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApxListProcessTasksProposals {

    @Autowired
    private IApxListProcessTasksProposalsMappers mapper;

    @Autowired
    private InvocadorTransaccion<PeticionTransaccionPpcutge1_1, RespuestaTransaccionPpcutge1_1> transaccion;

    public ProcessTasks perform(final InputListProcessTasksProposals input){
        PeticionTransaccionPpcutge1_1 request = mapper.mapIn(input);
        RespuestaTransaccionPpcutge1_1 response = transaccion.invocar(request);

        return mapper.mapOut(response);
    }
}
