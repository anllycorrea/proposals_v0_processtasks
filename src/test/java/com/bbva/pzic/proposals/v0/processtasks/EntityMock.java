package com.bbva.pzic.proposals.v0.processtasks;

import com.bbva.pzic.proposals.v0.processtasks.business.dto.InputListProcessTasksProposals;
import com.bbva.pzic.proposals.v0.processtasks.dao.model.ppcutge1_1.RespuestaTransaccionPpcutge1_1;
import com.bbva.pzic.proposals.v0.processtasks.util.mappers.ObjectMapperHelper;

import java.io.IOException;

public class EntityMock {
    private static final EntityMock INSTANCE = new EntityMock();

    private ObjectMapperHelper objectMapper;

    private EntityMock() {
        objectMapper = ObjectMapperHelper.getInstance();
    }

    public static EntityMock getInstance() {
        return INSTANCE;
    }

    public InputListProcessTasksProposals getInputlistProcessTasksProposals()  throws IOException {
        return objectMapper.readValue(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("mock/InputlistProcessTasksProposals.json"), InputListProcessTasksProposals.class);
    }

    public RespuestaTransaccionPpcutge1_1 getRespuestaTraccionPpcutge1_1() throws  IOException{
        return objectMapper.readValue(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("mock/respuestaTransaccionPpcutge1_1.json"), RespuestaTransaccionPpcutge1_1.class);
    }
}