package com.bbva.pzic.proposals.dao.mapper.impl;

import com.bbva.pzic.proposals.business.dto.DTOInputListProposals;
import com.bbva.pzic.proposals.canonic.Proposal;
import com.bbva.pzic.proposals.canonic.ProposalData;
import com.bbva.pzic.proposals.dao.mapper.IListProposalsDAOMapper;
import com.bbva.pzic.proposals.dao.model.listproposals.FormatProposal;
import com.bbva.pzic.proposals.dao.model.listproposals.FormatProposalData;
import com.bbva.pzic.proposals.util.helper.ObjectMapperHelper;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import static com.bbva.pzic.proposals.facade.v01.ISrvProposalsV01.*;
import static org.junit.Assert.*;

public class ListProposalsDAOMapperTest {

    private IListProposalsDAOMapper listProposalsDAOMapper;

    @Before
    public void init() {
        listProposalsDAOMapper = new ListProposalsDAOMapper();
    }

    @Test
    public void testMapInput() {
        final DTOInputListProposals dtoInputListProposals = new DTOInputListProposals();
        dtoInputListProposals.setCustomerId("1");
        dtoInputListProposals.setDocumentType("L");
        dtoInputListProposals.setDocumentNumber("00000001");
        dtoInputListProposals.setProductClassificationId("TC");
        dtoInputListProposals.setPaginationKey("123456789qwertyuio");
        dtoInputListProposals.setPageSize(123L);

        final Map<String, String> parameters = listProposalsDAOMapper.mapInput(dtoInputListProposals);
        assertEquals(dtoInputListProposals.getCustomerId(), parameters.get(CUSTOMER_ID));
        assertEquals(dtoInputListProposals.getDocumentType(), parameters.get(DOCUMENT_TYPE));
        assertEquals(dtoInputListProposals.getDocumentNumber(), parameters.get(DOCUMENT_NUMBER));
        assertEquals(dtoInputListProposals.getProductClassificationId(), parameters.get(PRODUCT_CLASSIFICATION_ID));
        assertEquals(dtoInputListProposals.getPaginationKey(), parameters.get(PAGINATION_KEY));
        assertEquals(dtoInputListProposals.getPageSize().toString(), parameters.get(PAGE_SIZE));
    }

    @Test
    public void testMapOutput() throws IOException {
        final FormatProposalData formatProposalData = buildFormatProposalData();
        final ProposalData proposalData = listProposalsDAOMapper.mapOutput(formatProposalData);
        assertEquals(3, proposalData.getData().size());
        assertNotNull(proposalData);
        assertNotNull(proposalData.getData());

        FormatProposal formatProposal = formatProposalData.getListaOfertas().get(0);
        Proposal proposal = proposalData.getData().get(0);
        assertNotNull(proposal);

        assertNotNull(proposal.getId());
        assertEquals(formatProposal.getIdPropuesta(), proposal.getId());

        assertNotNull(proposal.getCampaign());

        assertNotNull(proposal.getCampaign().getCode());
        assertEquals(formatProposal.getCampanha(), proposal.getCampaign().getCode());

        assertNotNull(proposal.getCustomerId());
        assertEquals(formatProposal.getCodigoCentral(), proposal.getCustomerId());

        assertNotNull(proposal.getProcurementFlow());
        assertNotNull(proposal.getProcurementFlow().getName());
        assertEquals(formatProposal.getFlujoOperativo(), proposal.getProcurementFlow().getName());
        assertNotNull(proposal.getProcurementFlow().getId());
        assertEquals(formatProposal.getCodFlujoOpe(), proposal.getProcurementFlow().getId());

        assertNotNull(proposal.getIndicators());
        assertEquals(2, proposal.getIndicators().size());

        assertEquals("ADDRESS_VALIDATION", proposal.getIndicators().get(0).getId());
        assertNotNull(proposal.getIndicators().get(0).getIsActive());

        assertEquals("WORKPLACE_VALIDATION", proposal.getIndicators().get(1).getId());
        assertNotNull(proposal.getIndicators().get(1).getIsActive());

        assertNotNull(proposal.getTerm());

        assertNotNull(proposal.getTerm().getId());
        assertEquals(formatProposal.getTipplazo(), proposal.getTerm().getId());

        assertNotNull(proposal.getTerm().getValue());
        assertEquals(formatProposal.getCodPlazo(), proposal.getTerm().getValue());

        assertNotNull(proposal.getProduct());
        assertNotNull(proposal.getProduct().getProductType());
        assertNotNull(proposal.getProduct().getProductType().getId());
        assertEquals(formatProposal.getFamiliaProducto(), proposal.getProduct().getProductType().getId());

        assertNotNull(proposal.getProduct().getTitle());

        assertNotNull(proposal.getProduct().getTitle().getId());
        assertEquals(formatProposal.getCodSubProducto(), proposal.getProduct().getTitle().getId());

        assertNotNull(proposal.getProduct().getBin());
        assertEquals(formatProposal.getValBin(), proposal.getProduct().getBin());

        assertNotNull(proposal.getProduct().getTitle().getName());
        assertEquals(formatProposal.getDesSubProducto(), proposal.getProduct().getTitle().getName());

        assertNotNull(proposal.getProduct().getProductClassification());

        assertNotNull(proposal.getProduct().getProductClassification().getId());
        assertEquals(formatProposal.getCodProducto(), proposal.getProduct().getProductClassification().getId());

        assertNotNull(proposal.getInternalCode());
        assertEquals(formatProposal.getCodInterno(), proposal.getInternalCode());

        assertNotNull(proposal.getProduct().getProductClassification().getName());
        assertEquals(formatProposal.getDesProducto(), proposal.getProduct().getProductClassification().getName());

        assertNotNull(proposal.getProduct().getProductConfiguration());

        assertNotNull(proposal.getProduct().getProductConfiguration().getDescription());
        assertEquals(formatProposal.getDesConfigProducto(), proposal.getProduct().getProductConfiguration().getDescription());

        assertNotNull(proposal.getProduct().getProductConfiguration().getId());
        assertEquals(formatProposal.getCodConfigProducto(), proposal.getProduct().getProductConfiguration().getId());

        assertNotNull(proposal.getRiskType());
        assertNotNull(proposal.getRiskType().getId());
        assertEquals(formatProposal.getStRiesgo(), proposal.getRiskType().getId());

        // Limits

        assertNotNull(proposal.getLimits());
        assertEquals(3, proposal.getLimits().size());

        assertNotNull(proposal.getLimits().get(0));
        assertNotNull(proposal.getLimits().get(0).getId());
        assertEquals("ADJUSTED", proposal.getLimits().get(0).getId());

        assertNotNull(proposal.getLimits().get(0).getAmounts());
        assertFalse(proposal.getLimits().get(0).getAmounts().isEmpty());

        assertNotNull(proposal.getLimits().get(0).getAmounts().get(0));

        assertNotNull(proposal.getLimits().get(0).getAmounts().get(0).getValue());
        assertEquals(formatProposal.getValLimiteAjust(), proposal.getLimits().get(0).getAmounts().get(0).getValue());

        assertNotNull(proposal.getLimits().get(0).getAmounts().get(0).getCurrency());
        assertEquals(formatProposal.getDivisa(), proposal.getLimits().get(0).getAmounts().get(0).getCurrency());

        assertNotNull(proposal.getLimits().get(1));
        assertNotNull(proposal.getLimits().get(1).getId());
        assertEquals("CONTRACT", proposal.getLimits().get(1).getId());

        assertNotNull(proposal.getLimits().get(1).getAmounts().get(0));

        assertNotNull(proposal.getLimits().get(1).getAmounts().get(0).getValue());
        assertEquals(formatProposal.getValLimiteContrato(), proposal.getLimits().get(1).getAmounts().get(0).getValue());

        assertNotNull(proposal.getLimits().get(1).getAmounts().get(0).getCurrency());
        assertEquals(formatProposal.getDivisa(), proposal.getLimits().get(1).getAmounts().get(0).getCurrency());

        assertNotNull(proposal.getLimits().get(2));
        assertNotNull(proposal.getLimits().get(2).getId());
        assertEquals("REAL", proposal.getLimits().get(2).getId());

        assertNotNull(proposal.getLimits().get(2).getAmounts().get(0));

        assertNotNull(proposal.getLimits().get(2).getAmounts().get(0).getValue());
        assertEquals(formatProposal.getValLimiteReal(), proposal.getLimits().get(2).getAmounts().get(0).getValue());

        assertNotNull(proposal.getLimits().get(2).getAmounts().get(0).getCurrency());
        assertEquals(formatProposal.getDivisa(), proposal.getLimits().get(2).getAmounts().get(0).getCurrency());

        // Instalments

        assertNotNull(proposal.getInstalments());
        assertEquals(3, proposal.getInstalments().size());

        assertNotNull(proposal.getInstalments().get(0));
        assertNotNull(proposal.getInstalments().get(0).getId());
        assertEquals("ADJUSTED", proposal.getInstalments().get(0).getId());

        assertNotNull(proposal.getInstalments().get(0).getPrincipal());

        assertNotNull(proposal.getInstalments().get(0).getPrincipal().getAmount());
        assertEquals(formatProposal.getValCuotaAjust(),
                proposal.getInstalments().get(0).getPrincipal().getAmount());

        assertNotNull(proposal.getInstalments().get(0).getPrincipal().getCurrency());
        assertEquals(formatProposal.getDivisa(), proposal.getInstalments().get(0).getPrincipal().getCurrency());

        assertNotNull(proposal.getInstalments().get(1));
        assertNotNull(proposal.getInstalments().get(1).getId());
        assertEquals("CONTRACT", proposal.getInstalments().get(1).getId());

        assertNotNull(proposal.getInstalments().get(1).getPrincipal());

        assertNotNull(proposal.getInstalments().get(1).getPrincipal().getAmount());
        assertEquals(formatProposal.getValCuotaContrato(), proposal.getInstalments().get(1).getPrincipal().getAmount());

        assertNotNull(proposal.getInstalments().get(1).getPrincipal().getCurrency());
        assertEquals(formatProposal.getDivisa(), proposal.getInstalments().get(1).getPrincipal().getCurrency());

        assertNotNull(proposal.getInstalments().get(2));
        assertNotNull(proposal.getInstalments().get(2).getId());
        assertEquals("REAL", proposal.getInstalments().get(2).getId());

        assertNotNull(proposal.getInstalments().get(2).getPrincipal());

        assertNotNull(proposal.getInstalments().get(2).getPrincipal().getAmount());
        assertEquals(formatProposal.getValCuotaReal(), proposal.getInstalments().get(2).getPrincipal().getAmount());

        assertNotNull(proposal.getInstalments().get(2).getPrincipal().getCurrency());
        assertEquals(formatProposal.getDivisa(), proposal.getInstalments().get(2).getPrincipal().getCurrency());

        // Rates
        assertNotNull(proposal.getRates());
        assertEquals(3, proposal.getRates().size());

        assertNotNull(proposal.getRates().get(0));
        assertNotNull(proposal.getRates().get(0).getId());
        assertEquals("PROPOSED", proposal.getRates().get(0).getId());

        assertNotNull(proposal.getRates().get(0).getValue());
        assertEquals(formatProposal.getValTasa(), proposal.getRates().get(0).getValue());

        assertNotNull(proposal.getRates().get(1));
        assertNotNull(proposal.getRates().get(1).getId());
        assertEquals("MAXIMUM", proposal.getRates().get(1).getId());

        assertNotNull(proposal.getRates().get(1).getValue());
        assertEquals(formatProposal.getTasaMax(), proposal.getRates().get(1).getValue());

        assertNotNull(proposal.getRates().get(2));
        assertNotNull(proposal.getRates().get(2).getId());
        assertEquals("MINIMUM", proposal.getRates().get(2).getId());

        assertNotNull(proposal.getRates().get(2).getValue());
        assertEquals(formatProposal.getTasaMin(), proposal.getRates().get(2).getValue());

        // Ranges
        assertNotNull(proposal.getRanges());
        assertEquals(2, proposal.getRanges().size());

        assertNotNull(proposal.getRanges().get(0));
        assertNotNull(proposal.getRanges().get(0).getId());
        assertEquals("MAXIMUM", proposal.getRanges().get(0).getId());

        assertNotNull(proposal.getRanges().get(0).getValue());
        assertEquals(formatProposal.getRangoMax(), proposal.getRanges().get(0).getValue());

        assertNotNull(proposal.getRanges().get(1));
        assertNotNull(proposal.getRanges().get(1).getId());
        assertEquals("MINIMUM", proposal.getRanges().get(1).getId());

        assertNotNull(proposal.getRanges().get(1).getValue());
        assertEquals(formatProposal.getRangoMin(), proposal.getRanges().get(1).getValue());

        // ######################
        // PARTIAL
        // ######################
        formatProposal = formatProposalData.getListaOfertas().get(1);
        proposal = proposalData.getData().get(1);
        assertNotNull(proposal);

        assertNotNull(proposal.getId());
        assertEquals(formatProposal.getIdPropuesta(), proposal.getId());

        assertNull(proposal.getTerm().getId());
        assertNull(proposal.getProduct().getProductType());
        assertNull(proposal.getProduct().getProductClassification().getId());
        assertNull(proposal.getRiskType());

        // ######################
        // EMPTY
        // ######################
        proposal = proposalData.getData().get(2);
        assertNotNull(proposal);

        assertNull(proposal.getId());
        assertNotNull(proposal.getIndicators());
        assertNull(proposal.getProcurementFlow());
        assertNull(proposal.getTerm());
        assertNull(proposal.getInternalCode());
        assertNull(proposal.getProduct());
        assertNotNull(proposal.getLimits());
        assertNotNull(proposal.getInstalments());
        assertNotNull(proposal.getRates());
        assertNotNull(proposal.getRanges());
        assertNull(proposal.getRiskType());

        // ######################
        // PAGINATION
        // ######################
        assertNotNull(proposalData.getPagination());
        assertNotNull(proposalData.getPagination().getNextPage());
        assertEquals(formatProposalData.getIdPagin(), proposalData.getPagination().getNextPage());
        assertNotNull(proposalData.getPagination().getPageSize());
        assertEquals(formatProposalData.getTampagi(), proposalData.getPagination().getPageSize().toString());
    }

    private FormatProposalData buildFormatProposalData() throws IOException {
        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(
                "com/bbva/pzic/proposals/dao/mock/FormatProposalData.json");
        return ObjectMapperHelper.getInstance().readValue(in, FormatProposalData.class);
    }
}