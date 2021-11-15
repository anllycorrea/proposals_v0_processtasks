package com.bbva.pzic.proposals.v0.processtasks.facade.mapper.impl;

import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponse;
import com.bbva.pzic.proposals.v0.processtasks.business.dto.InputListProcessTasksProposals;
import com.bbva.pzic.proposals.v0.processtasks.facade.dto.ProcessTasks;
import com.bbva.pzic.proposals.v0.processtasks.facade.mapper.IListProcessTasksProposalsMapper;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import static org.junit.Assert.*;

public class ListProcessTasksProposalsMapperTest {
    private IListProcessTasksProposalsMapper mapper;

    @Before
    public void setUp(){
        mapper = new ListProcessTasksProposalsMapper();
    }

    @Test
    public void mapInFullTest() throws IOException {

        InputListProcessTasksProposals result = mapper.mapIn("982HE","72514963");

        assertNotNull(result);
        assertNotNull(result.getBusinessProcessId());
        assertNotNull(result.getTaskId());

        assertEquals("982HE",result.getBusinessProcessId());
        assertEquals("72514963" ,result.getTaskId());
    }

    @Test
    public void mapInEmptyTest(){
        InputListProcessTasksProposals result = mapper.mapIn(null,null);

        assertNotNull(result);
        assertNull(result.getBusinessProcessId());
        assertNull(result.getTaskId());
    }

    @Test
    public void mapOutFullTest() throws IOException{

        ProcessTasks input = new ProcessTasks();
        ServiceResponse<ProcessTasks> result = mapper.mapOut(input);

        assertNotNull(result);
        assertNotNull(result.getData());
    }

    @Test
    public void mapOutEmptyTest(){
        ServiceResponse<ProcessTasks> result = mapper.mapOut(null);
        assertNull(result);
    }
}
