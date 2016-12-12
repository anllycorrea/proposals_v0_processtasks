package com.bbva.pzic.proposals.facade.v01.impl;

import com.bbva.jee.arq.spring.core.servicing.annotations.SMC;
import com.bbva.jee.arq.spring.core.servicing.annotations.SN;
import com.bbva.jee.arq.spring.core.servicing.annotations.VN;
import com.bbva.jee.arq.spring.core.servicing.utils.BusinessServicesToolKit;
import com.bbva.jee.arq.spring.core.servicing.utils.ContextAware;
import com.bbva.pzic.proposals.business.ISrvIntProposals;
import com.bbva.pzic.proposals.business.dto.DTOInputListProposals;
import com.bbva.pzic.proposals.canonic.ProposalData;
import com.bbva.pzic.proposals.facade.v01.ISrvProposalsV01;
import com.bbva.pzic.proposals.facade.v01.mapper.IListProposalsMapper;
import com.wordnik.swagger.annotations.Api;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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
@Api(value = "/proposals/V01", description = "API Proposals")
@Produces(MediaType.APPLICATION_JSON)
@Service
public class SrvProposalsV01 implements ISrvProposalsV01, ContextAware {

    private static final Log LOG = LogFactory.getLog(SrvProposalsV01.class);

    public HttpHeaders httpHeaders;
    public UriInfo uriInfo;

    @Autowired
    private BusinessServicesToolKit businessToolKit;

    @Autowired
    private ISrvIntProposals srvIntProposals;

    @Autowired
    private IListProposalsMapper listProposalsMapper;

    /**
     * @see ISrvProposalsV01#listProposals(String, String, String, String, Long)
     */
    @Override
    @GET
    @Path("/")
    @SMC(registryID = "SNPE1500084", logicalID = "listProposals")
    public Response listProposals(@QueryParam(DOCUMENT_TYPE) final String documentType,
                                  @QueryParam(DOCUMENT_NUMBER) final String documentNumber,
                                  @QueryParam(PRODUCT_CLASSIFICATION) final String productClassification,
                                  @QueryParam(PAGINATION_KEY) final String paginationKey,
                                  @QueryParam(PAGE_SIZE) final Long pageSize) {
        LOG.info("... called method SrvProposalsV01.listProposals ...");
        final ProposalData proposalData =
                srvIntProposals
                        .listProposals(listProposalsMapper.mapInput(documentType, documentNumber, productClassification, paginationKey, pageSize));
        if (proposalData == null
                || ((proposalData.getData() == null || proposalData.getData().isEmpty()) && proposalData.getPagination() == null)) {
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
    public void setUriInfo(UriInfo uriInfo) {
        this.uriInfo = uriInfo;
    }

    @Override
    public void setHttpHeaders(HttpHeaders httpHeaders) {
        this.httpHeaders = httpHeaders;
    }
}