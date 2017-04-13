package com.bbva.pzic.proposals.facade.v01.impl;

import com.bbva.jee.arq.spring.core.servicing.annotations.PATCH;
import com.bbva.jee.arq.spring.core.servicing.annotations.SMC;
import com.bbva.jee.arq.spring.core.servicing.annotations.SN;
import com.bbva.jee.arq.spring.core.servicing.annotations.VN;
import com.bbva.jee.arq.spring.core.servicing.utils.BusinessServicesToolKit;
import com.bbva.pzic.proposals.business.ISrvIntProposals;
import com.bbva.pzic.proposals.canonic.ExternalFinancingProposal;
import com.bbva.pzic.proposals.canonic.ProposalData;
import com.bbva.pzic.proposals.facade.v01.ISrvProposalsV01;
import com.bbva.pzic.proposals.facade.v01.mapper.IListProposalsMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * @author Entelgy
 */
@Path("/V01")
@SN(registryID = "SNPE1500084", logicalID = "proposals")
@VN(vnn = "V01")
@Produces(MediaType.APPLICATION_JSON)
@Service
public class SrvProposalsV01 implements ISrvProposalsV01, com.bbva.jee.arq.spring.core.servicing.utils.ContextAware {

    private static final Log LOG = LogFactory.getLog(SrvProposalsV01.class);

    public UriInfo uriInfo;
    public HttpHeaders httpHeaders;

    @Autowired
    private BusinessServicesToolKit businessToolKit;

    @Autowired
    private ISrvIntProposals srvIntProposals;

    @Autowired
    private IListProposalsMapper listProposalsMapper;

    @Override
    public void setUriInfo(UriInfo uriInfo) {
        this.uriInfo = uriInfo;
    }

    @Override
    public void setHttpHeaders(HttpHeaders httpHeaders) {
        this.httpHeaders = httpHeaders;
    }

    /**
     * @see ISrvProposalsV01#listProposals(String, String, String, String, String, Long)
     */
    @Override
    @GET
    @Path("/")
    @SMC(registryID = "SMCPE1500164", logicalID = "listProposals")
    public Response listProposals(@QueryParam(CUSTOMER_ID) final String customerId,
                                  @QueryParam(DOCUMENT_TYPE) final String documentType,
                                  @QueryParam(DOCUMENT_NUMBER) final String documentNumber,
                                  @QueryParam(PRODUCT_CLASSIFICATION_ID) final String productClassification,
                                  @QueryParam(PAGINATION_KEY) final String paginationKey,
                                  @QueryParam(PAGE_SIZE) final Long pageSize) {
        LOG.info("... called method SrvProposalsV01.listProposals ...");
        final ProposalData proposalData =
                srvIntProposals
                        .listProposals(listProposalsMapper.mapInput(customerId, documentType, documentNumber, productClassification, paginationKey, pageSize));
        if ((proposalData.getData() == null || proposalData.getData().isEmpty()) && proposalData.getPagination() == null) {
            return Response.noContent().build();
        } else if (proposalData.getPagination() == null) {
            return Response.ok(proposalData).build();
        } else {
            proposalData.setPagination(businessToolKit.getPaginationBuider()
                    .setPagination(SrvProposalsV01.class, "listProposals", uriInfo,
                            proposalData.getPagination().getNextPage(), null,
                            proposalData.getPagination().getPageSize(), null,
                            null, null, null).build());
            return Response.ok(proposalData).status(206).build();
        }
    }

    @Override
    @GET
    @Path("/external-financing-proposals")
    @SMC(registryID = "SMCPE1720029", logicalID = "listExternalFinancingProposals")
    public Response listExternalFinancingProposals(String thirdPartyProviderId, String holderIdentityDocumentsDocumentTypeId, String holderIdentityDocumentsDocumentNumber, String fromRequestDate, String toRequestDate, String paginationKey, Long pageSize) {
        return null;
    }

    @Override
    @POST
    @Path("/external-financing-proposals")
    @SMC(registryID = "SMCPE1720028", logicalID = "createExternalFinancingProposal")
    public Response createExternalFinancingProposal(ExternalFinancingProposal payload) {
        return null;
    }

    @Override
    @PATCH
    @Path("/external-financing-proposals/{external-financing-proposal-id}")
    @SMC(registryID = "SMCPE1720030", logicalID = "modifyExternalFinancingProposal")
    public Response modifyExternalFinancingProposal(@PathParam("external-financing-proposal-id") String externalFinancingProposalId, ExternalFinancingProposal payload) {
        return null;
    }
}