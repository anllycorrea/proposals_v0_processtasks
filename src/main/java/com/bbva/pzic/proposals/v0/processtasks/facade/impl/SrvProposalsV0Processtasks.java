package com.bbva.pzic.proposals.v0.processtasks.facade.impl;

import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponse;
import com.bbva.jee.arq.spring.core.servicing.annotations.SMC;
import com.bbva.jee.arq.spring.core.servicing.annotations.SN;
import com.bbva.jee.arq.spring.core.servicing.annotations.VN;
import com.bbva.pzic.proposals.v0.processtasks.business.ISrvIntProposalsV0Processtasks;
import com.bbva.pzic.proposals.v0.processtasks.business.dto.InputListProcessTasksProposals;
import com.bbva.pzic.proposals.v0.processtasks.dao.apx.mapper.IApxListProcessTasksProposalsMappers;
import com.bbva.pzic.proposals.v0.processtasks.facade.ISrvProposalsV0Processtasks;
import com.bbva.pzic.proposals.v0.processtasks.facade.dto.ProcessTasks;
import com.bbva.pzic.proposals.v0.processtasks.facade.mapper.IListProcessTasksProposalsMapper;
import com.bbva.pzic.routine.processing.data.DataProcessingExecutor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

@Path("/v0")
@Produces(MediaType.APPLICATION_JSON)
@SN(registryID = "SNPE1700055", logicalID = "proposals")
@VN(vnn = "v0")
@Service
public class SrvProposalsV0Processtasks implements ISrvProposalsV0Processtasks {

    private static final Log LOG = LogFactory.getLog(SrvProposalsV0Processtasks.class);

    @Autowired
    private IListProcessTasksProposalsMapper listProcessTasksProposalsMapper;

    @Autowired
    private ISrvIntProposalsV0Processtasks srvintProposalsV0Proposals;

    @Autowired
    private DataProcessingExecutor inputDataProcessingExecutor;

    @Autowired
    private DataProcessingExecutor outputDataProcessingExecutor;

    @Override
    @GET
    @Path("/process-tasks")
    @Consumes(MediaType.APPLICATION_JSON)
    @SMC(registryID = "SMGG20203823", logicalID="listProcessTasksProposals", forcedCatalog = "gabiCatalog")
    public ServiceResponse<ProcessTasks> listProcessTasksProposals(@QueryParam("businessProcessId") final String businessProcessId,
                                                                   @QueryParam("taskId") final String taskId) {


        LOG.info("----- Invoking service createFinancialStatementDuplicateRequest -----");

        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("businessProcessId", businessProcessId);
        queryParams.put("taskId", taskId);

        inputDataProcessingExecutor.perform( "SMGG20203823", null,  null, queryParams);


        ServiceResponse<ProcessTasks> serviceResponse = listProcessTasksProposalsMapper.mapOut(
                srvintProposalsV0Proposals.listProcessTasksProposals(
                        listProcessTasksProposalsMapper.mapIn(
                                (String) queryParams.get("businessProcessId"),
                                (String) queryParams.get("taskId")
                        )
                )
        );

        outputDataProcessingExecutor.perform( "SMGG20203823", serviceResponse, null,  null);

        return serviceResponse;
    }

}
