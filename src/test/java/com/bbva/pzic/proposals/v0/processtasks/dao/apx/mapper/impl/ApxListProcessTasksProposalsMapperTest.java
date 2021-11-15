package com.bbva.pzic.proposals.v0.processtasks.dao.apx.mapper.impl;

import com.bbva.pzic.proposals.v0.processtasks.EntityMock;
import com.bbva.pzic.proposals.v0.processtasks.business.dto.InputListProcessTasksProposals;
import com.bbva.pzic.proposals.v0.processtasks.dao.apx.mapper.IApxListProcessTasksProposalsMappers;
import com.bbva.pzic.proposals.v0.processtasks.dao.model.ppcutge1_1.PeticionTransaccionPpcutge1_1;
import com.bbva.pzic.proposals.v0.processtasks.dao.model.ppcutge1_1.RespuestaTransaccionPpcutge1_1;
import com.bbva.pzic.proposals.v0.processtasks.facade.dto.ProcessTasks;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class ApxListProcessTasksProposalsMapperTest {
    private IApxListProcessTasksProposalsMappers mapper;

    @Before
    public void setUp(){
        mapper = new ApxListProcessTasksProposalsMappers();
    }

    @Test
    public void mapInFullTest() throws IOException {

        InputListProcessTasksProposals input = EntityMock.getInstance().getInputlistProcessTasksProposals();

        PeticionTransaccionPpcutge1_1 result = mapper.mapIn(input);

        assertNotNull(result);
        assertNotNull(result.getBusinessprocessid());
        assertNotNull(result.getTaskid());

        assertEquals(input.getBusinessProcessId(),result.getBusinessprocessid());
        assertEquals(input.getTaskId(),result.getTaskid());
    }

    @Test
    public void mapInEmptyTest(){

        PeticionTransaccionPpcutge1_1 result = mapper.mapIn(new InputListProcessTasksProposals());

        assertNotNull(result);
        assertNull(result.getBusinessprocessid());
        assertNull(result.getTaskid());
    }

    @Test
    public void mapOutFullTest() throws IOException{

        RespuestaTransaccionPpcutge1_1 input = EntityMock.getInstance().getRespuestaTraccionPpcutge1_1();
        ProcessTasks result = mapper.mapOut(input);

        assertNotNull(result);
        assertNotNull(result.getBusinessProcessId());
        assertNotNull(result.getTaskId());
        assertNotNull(result.getStatus().getId());
        assertNotNull(result.getStatus().getDescription());

        assertEquals(input.getCampo_1_businessprocessid(), result.getBusinessProcessId());
        assertEquals(input.getCampo_2_taskid(), result.getTaskId());
        assertEquals(input.getStatus().getId(), result.getStatus().getId());
        assertEquals(input.getStatus().getDescription(),result.getStatus().getDescription());

    }

    @Test
    public void mapOutEmptyTest(){
        ProcessTasks result = mapper.mapOut(null);
        assertNull(result);
    }
}
