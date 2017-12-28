package com.bbva.pzic.proposals.facade.v0.impl;

import com.bbva.jee.arq.spring.core.servicing.annotations.SMC;
import com.bbva.jee.arq.spring.core.servicing.annotations.SN;
import com.bbva.jee.arq.spring.core.servicing.annotations.VN;
import com.bbva.pzic.proposals.business.ISrvIntProposalsV0;
import com.bbva.pzic.proposals.business.dto.DTOIntProposals;
import com.bbva.pzic.proposals.canonic.Proposals;
import com.bbva.pzic.proposals.canonic.SimulatedProposal;
import com.bbva.pzic.proposals.canonic.SimulatedProposalsData;
import com.bbva.pzic.proposals.facade.v0.ISrvProposalsV0;
import com.bbva.pzic.proposals.facade.v0.mapper.IListProposalsMapperV0;
import com.bbva.pzic.proposals.facade.v0.mapper.ISimulateProposalsMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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
public class SrvProposalsV0
        implements
        ISrvProposalsV0,
        com.bbva.jee.arq.spring.core.servicing.utils.ContextAware {

    private static final Log LOG = LogFactory.getLog(SrvProposalsV0.class);
    public HttpHeaders httpHeaders;
    public UriInfo uriInfo;
    @Autowired
    private ISrvIntProposalsV0 srvIntProposals;
    @Autowired
    private IListProposalsMapperV0 listProposalsMapper;
    @Autowired
    private ISimulateProposalsMapper simulateProposalsMapper;

    /**
     * {@inheritDoc}
     */
    @Override
    @GET
    @Path("/proposals")
    @SMC(registryID = "SMCPE1720157", logicalID = "listProposals")
    public Proposals listProposals(
            @QueryParam("participant.identityDocument.documentType.id") final String participantIdentityDocumentDocumentTypeId,
            @QueryParam("participant.identityDocument.documentNumber") final String participantIdentityDocumentDocumentNumber,
            @QueryParam("customer.id") final String customerId) {
        LOG.info("----- Invoking service listProposals -----");
        DTOIntProposals dTOIntProposals = srvIntProposals
                .listProposals(listProposalsMapper.mapIn(
                        participantIdentityDocumentDocumentTypeId,
                        participantIdentityDocumentDocumentNumber, customerId));
        Proposals proposals = listProposalsMapper.mapOut(dTOIntProposals);
        if (proposals == null) {
            return null;
        }
        return proposals;
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

    @Override
    public void setHttpHeaders(HttpHeaders httpHeaders) {
        this.httpHeaders = httpHeaders;
    }

    @Override
    public void setUriInfo(UriInfo uriInfo) {
        this.uriInfo = uriInfo;
    }
}