package com.bbva.pzic.proposals.facade.v0.impl;

import com.bbva.jee.arq.spring.core.auditoria.DatoAuditable;
import com.bbva.jee.arq.spring.core.servicing.annotations.SMC;
import com.bbva.jee.arq.spring.core.servicing.annotations.SN;
import com.bbva.jee.arq.spring.core.servicing.annotations.VN;
import com.bbva.pzic.proposals.business.ISrvIntProposalsV0;
import com.bbva.pzic.proposals.canonic.Proposals;
import com.bbva.pzic.proposals.canonic.SimulatedProposal;
import com.bbva.pzic.proposals.canonic.SimulatedProposalsData;
import com.bbva.pzic.proposals.facade.v0.ISrvProposalsV0;
import com.bbva.pzic.proposals.facade.v0.mapper.IListProposalsMapper;
import com.bbva.pzic.proposals.facade.v0.mapper.ISimulateProposalsMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 * Created on 28/12/2017.
 *
 * @author Entelgy
 */
@Path("/v0")
@Produces(MediaType.APPLICATION_JSON)
@SN(registryID = "SNPE1700055", logicalID = "proposals")
@VN(vnn = "v0")
@Service
public class SrvProposalsV0 implements ISrvProposalsV0, com.bbva.jee.arq.spring.core.servicing.utils.ContextAware {

    private static final Log LOG = LogFactory.getLog(SrvProposalsV0.class);
    public HttpHeaders httpHeaders;
    public UriInfo uriInfo;
    @Autowired
    private ISrvIntProposalsV0 srvIntProposals;
    @Resource(name = "listProposalsMapperV0")
    private IListProposalsMapper listProposalsMapper;
    @Autowired
    private ISimulateProposalsMapper simulateProposalsMapper;

    @Override
    public void setHttpHeaders(HttpHeaders httpHeaders) {
        this.httpHeaders = httpHeaders;
    }

    @Override
    public void setUriInfo(UriInfo uriInfo) {
        this.uriInfo = uriInfo;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @GET
    @Path("/proposals")
    @SMC(registryID = "SMCPE1720157", logicalID = "listProposals")
    public Proposals listProposals(
            @QueryParam("participant.identityDocument.documentType.id") final String documentTypeId,
            @DatoAuditable(omitir = true)
            @QueryParam("participant.identityDocument.documentNumber") final String documentNumber,
            @QueryParam("customer.id") final String customerId) {
        LOG.info("----- Invoking service listProposals -----");
        return listProposalsMapper.mapOut(srvIntProposals
                .listProposals(listProposalsMapper.mapIn(
                        documentTypeId,
                        documentNumber, customerId)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @POST
    @Path("/proposals/simulate")
    @Consumes(MediaType.APPLICATION_JSON)
    @SMC(registryID = "SMCPE1720158", logicalID = "simulateProposals")
    public SimulatedProposalsData simulateProposals(final SimulatedProposal simulatedProposal) {
        LOG.info("----- Invoking service simulateProposals -----");
        return srvIntProposals.simulateProposals(simulateProposalsMapper.mapIn(simulatedProposal));
    }
}