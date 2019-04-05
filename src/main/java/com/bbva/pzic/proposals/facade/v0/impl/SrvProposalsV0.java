package com.bbva.pzic.proposals.facade.v0.impl;

import com.bbva.jee.arq.spring.core.auditoria.DatoAuditable;
import com.bbva.jee.arq.spring.core.servicing.annotations.PATCH;
import com.bbva.jee.arq.spring.core.servicing.annotations.SMC;
import com.bbva.jee.arq.spring.core.servicing.annotations.SN;
import com.bbva.jee.arq.spring.core.servicing.annotations.VN;
import com.bbva.jee.arq.spring.core.servicing.utils.BusinessServicesToolKit;
import com.bbva.pzic.proposals.business.ISrvIntProposalsV0;
import com.bbva.pzic.proposals.business.dto.DTOOutExternalFinancingProposalData;
import com.bbva.pzic.proposals.canonic.*;
import com.bbva.pzic.proposals.facade.v0.ISrvProposalsV0;
import com.bbva.pzic.proposals.facade.v0.mapper.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import static com.bbva.pzic.proposals.facade.v01.ISrvProposalsV01.PAGE_SIZE;
import static com.bbva.pzic.proposals.facade.v01.ISrvProposalsV01.PAGINATION_KEY;

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

    @Resource(name = "createExternalFinancingProposalMapper")
    private ICreateExternalFinancingProposalMapper createExternalFinancingProposalMapper;

    @Resource(name = "listExternalFinancingProposalsMapper")
    private IListExternalFinancingProposalsMapper proposalsMapper;

    @Resource(name = "modifyExternalFinancingProposalMapper")
    private IModifyExternalFinancingProposalMapper modifyExternalFinancingProposalMapper;

    @Autowired
    private ISimulateProposalsMapper simulateProposalsMapper;

    @Autowired
    private BusinessServicesToolKit businessToolKit;

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
        return listProposalsMapper.mapOut(
                srvIntProposals.listProposals(
                        listProposalsMapper.mapIn(documentTypeId, documentNumber, customerId)));
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

    /**
     * @see ISrvProposalsV0#createExternalFinancingProposal(String, ExternalFinancingProposal)
     */
    @Override
    @POST
    @Path("/external-financing-proposals")
    @Consumes(MediaType.APPLICATION_JSON)
    @SMC(registryID = "SMCPE1720028", logicalID = "createExternalFinancingProposal")
    public ExternalFinancingProposal createExternalFinancingProposal(@QueryParam("thirdPartyProvider.userId") final String thirdPartyProviderUserId,
                                                                     final ExternalFinancingProposal payload) {
        LOG.info("------ SrvIntProposals.createExternalFinancingProposal ------");
        return srvIntProposals.createExternalFinancingProposal(
                createExternalFinancingProposalMapper.mapIn(thirdPartyProviderUserId, payload));
    }

    @Override
    @GET
    @Path("/external-financing-proposals")
    @SMC(registryID = "SMCPE1720029", logicalID = "listExternalFinancingProposals")
    public ExternalFinancingProposalData listExternalFinancingProposals(
            @QueryParam(THIRD_PARTY_PROVIDER_ID) final String thirdPartyProviderId,
            @QueryParam(EXTERNAL_PRODUCT_CATEGORY_TYPE_ID) final String externalproductCategoryTypeId,
            @QueryParam(HOLDER_IDENTITY_DOCUMENTS_DOCUMENT_TYPE_ID) final String holderIdentityDocumentsDocumentTypeId,
            @DatoAuditable(omitir = true) @QueryParam(HOLDER_IDENTITY_DOCUMENTS_DOCUMENT_NUMBER) final String holderIdentityDocumentsDocumentNumber,
            @QueryParam(FROM_REQUEST_DATE) final String fromRequestDate,
            @QueryParam(TO_REQUEST_DATE) final String toRequestDate,
            @QueryParam(PAGINATION_KEY) String paginationKey,
            @QueryParam(PAGE_SIZE) Long pageSize) {
        LOG.info("----- Invoking service listExternalFinancingProposals -----");
        DTOOutExternalFinancingProposalData proposalData = srvIntProposals.listExternalFinancingProposals(
                proposalsMapper.mapIn(thirdPartyProviderId, externalproductCategoryTypeId, holderIdentityDocumentsDocumentTypeId,
                        holderIdentityDocumentsDocumentNumber, fromRequestDate, toRequestDate, paginationKey, pageSize));
        ExternalFinancingProposalData data = proposalsMapper.mapOut(proposalData);
        if (data == null) {
            return null;
        }

        if (proposalData.getPagination() == null) {
            return data;
        }

        data.setPagination(businessToolKit.getPaginationBuider()
                .setPagination(SrvProposalsV0.class, "listExternalFinancingProposals", uriInfo,
                        proposalData.getPagination().getPaginationKey(), null,
                        proposalData.getPagination().getPageSize(), null,
                        null, null, null).build());

        return data;
    }

    @Override
    @PATCH
    @Path("/external-financing-proposals/{external-financing-proposal-id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @SMC(registryID = "SMCPE1720030", logicalID = "modifyExternalFinancingProposal")
    public Response modifyExternalFinancingProposal(@PathParam("external-financing-proposal-id") final String externalFinancingProposalId,
                                                    final ExternalFinancingProposal payload) {
        srvIntProposals.modifyExternalFinancingProposal(
                modifyExternalFinancingProposalMapper.mapIn(externalFinancingProposalId, payload)
        );

        return Response.ok().build();
    }

}