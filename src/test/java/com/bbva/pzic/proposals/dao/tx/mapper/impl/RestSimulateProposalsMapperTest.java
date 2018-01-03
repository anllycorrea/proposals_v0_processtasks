package com.bbva.pzic.proposals.dao.tx.mapper.impl;

import com.bbva.jee.arq.spring.core.servicing.context.ServiceInvocationContext;
import com.bbva.pzic.proposals.DummyMock;
import com.bbva.pzic.proposals.business.dto.DTOIntSimulatedProposal;
import com.bbva.pzic.proposals.canonic.SimulatedProposal;
import com.bbva.pzic.proposals.canonic.SimulatedProposalsData;
import com.bbva.pzic.proposals.dao.model.simulateproposals.SimulatedProposalRequest;
import com.bbva.pzic.proposals.dao.model.simulateproposals.SimulatedProposalsResponse;
import com.bbva.pzic.proposals.dao.tx.mock.RestSimulateProposalsBuilder;
import com.bbva.pzic.proposals.util.mappers.EnumMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import static com.bbva.pzic.proposals.DummyMock.CONTEXT_PROVIDER_SESSION_USER;
import static org.junit.Assert.*;

/**
 * Created on 29/12/2017.
 *
 * @author Entelgy
 */
public class RestSimulateProposalsMapperTest {

    @InjectMocks
    private RestSimulateProposalsMapper restSimulateProposalsMapper;

    @Mock
    private ServiceInvocationContext contextProvider;

    @Mock
    private EnumMapper enumMapper;

    private DummyMock dummyMock;

    private RestSimulateProposalsBuilder restSimulateProposalsBuilder;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        dummyMock = new DummyMock();
        restSimulateProposalsBuilder = new RestSimulateProposalsBuilder();
    }

    private void mapInEnumMapper() {
        Mockito.when(contextProvider.getUser()).thenReturn(CONTEXT_PROVIDER_SESSION_USER);
        Mockito.when(enumMapper.getBackendValue("documentType.id", "DNI")).thenReturn("L");
        Mockito.when(enumMapper.getBackendValue("conditions.period.id", "MONTHLY")).thenReturn("M");
    }

    private void mapOutEnumMapper() {
        Mockito.when(enumMapper.getEnumValue("proposals.procurementFlow.id", "F")).thenReturn("FAST");
        Mockito.when(enumMapper.getEnumValue("conditions.period.id", "M")).thenReturn("MONTHLY");
        Mockito.when(enumMapper.getEnumValue("proposals.riskType.id", "CQ")).thenReturn("NO_RISK");
        Mockito.when(enumMapper.getEnumValue("product.productType.id", "50")).thenReturn("CARDS");
    }

    @Test
    public void mapInFullTest() throws IOException {
        mapInEnumMapper();
        DTOIntSimulatedProposal dtoIntSimulatedProposal = dummyMock.getDtoIntSimulatedProposal();

        SimulatedProposalRequest request = restSimulateProposalsMapper.mapIn(dtoIntSimulatedProposal);

        assertNotNull(request);
        assertNotNull(request.getCustomerId());
        assertNotNull(request.getDocumentType());
        assertNotNull(request.getDocumentNumber());
        assertNotNull(request.getProductClassifications().get(0).getId());
        assertNotNull(request.getProductClassifications().get(1).getId());
        assertNotNull(request.getTipplazoSel());
        assertNotNull(request.getCodPlazoSel());
        assertNotNull(request.getCodProductoSel());
        assertNotNull(request.getValMontoSel());
        assertNotNull(request.getDivisa());
        assertNotNull(request.getValCuotaSel());
        assertNotNull(request.getDivisa());
        assertNotNull(request.getTasaSel());

        assertEquals(CONTEXT_PROVIDER_SESSION_USER, request.getCustomerId());
        assertEquals("L", request.getDocumentType());
        assertEquals("74585467", request.getDocumentNumber());
        assertEquals("CO", request.getProductClassifications().get(0).getId());
        assertEquals("TC", request.getProductClassifications().get(1).getId());
        assertEquals("M", request.getTipplazoSel());
        assertEquals(new BigDecimal("36"), request.getCodPlazoSel());
        assertEquals("TC", request.getCodProductoSel());
        assertEquals(new BigDecimal("6100.00"), request.getValMontoSel());
        assertEquals("PEN", request.getDivisa());
        assertEquals(new BigDecimal("310.17279"), request.getValCuotaSel());
        assertEquals("PEN", request.getDivisa());
        assertEquals(new BigDecimal("54.99"), request.getTasaSel());
    }

    @Test
    public void mapInEmptyTest() {
        mapInEnumMapper();
        SimulatedProposalRequest request = restSimulateProposalsMapper.mapIn(new DTOIntSimulatedProposal());

        assertNotNull(request);
        assertNotNull(request.getCustomerId());
        assertNull(request.getDocumentType());
        assertNull(request.getDocumentNumber());
        assertNull(request.getProductClassifications());
        assertNull(request.getTipplazoSel());
        assertNull(request.getCodPlazoSel());
        assertNull(request.getCodProductoSel());
        assertNull(request.getValMontoSel());
        assertNull(request.getDivisa());
        assertNull(request.getValCuotaSel());
        assertNull(request.getDivisa());
        assertNull(request.getTasaSel());
    }

    @Test
    public void mapOutFull() {
        mapOutEnumMapper();

        SimulatedProposalsResponse simulatedProposalsResponse = restSimulateProposalsBuilder.buildSimulatedProposalsResponse();
        SimulatedProposalsData result = restSimulateProposalsMapper.mapOut(simulatedProposalsResponse);

        assertNotNull(result);
        List<SimulatedProposal> data = result.getData();
        assertNotNull(data);
        SimulatedProposal simulatedProposal1 = data.get(0);
        assertNotNull(simulatedProposal1);
        assertNotNull(simulatedProposal1.getParticipant().getId());
        assertNotNull(simulatedProposal1.getParticipant().getIdentityDocument().getDocumentType().getId());
        assertNotNull(simulatedProposal1.getParticipant().getIdentityDocument().getDocumentNumber());
        assertNotNull(simulatedProposal1.getParticipant().getSegmentationCode());
        assertNotNull(simulatedProposal1.getParticipant().getRiskLevel().getId());
        assertNotNull(simulatedProposal1.getParticipant().getRiskLevel().getName());
        assertNotNull(simulatedProposal1.getInternalCode());
        assertNotNull(simulatedProposal1.getProcurementFlow().getProcurementFlowType().getId());
        assertNotNull(simulatedProposal1.getProcurementFlow().getProcurementFlowType().getName());
        assertNotNull(simulatedProposal1.getIndicators().get(0).getId());
        assertNotNull(simulatedProposal1.getIndicators().get(0).getIsActive());
        assertNotNull(simulatedProposal1.getIndicators().get(1).getId());
        assertNotNull(simulatedProposal1.getIndicators().get(1).getIsActive());
        assertNotNull(simulatedProposal1.getCampaign().getCode());
        assertNotNull(simulatedProposal1.getTerm().getFrequency());
        assertNotNull(simulatedProposal1.getTerm().getValue());
        assertNotNull(simulatedProposal1.getProduct().getBin());
        assertNotNull(simulatedProposal1.getProduct().getTitle().getId());
        assertNotNull(simulatedProposal1.getProduct().getTitle().getName());
        assertNotNull(simulatedProposal1.getProduct().getRiskGroup());
        assertNotNull(simulatedProposal1.getProduct().getProductType().getId());
        assertNotNull(simulatedProposal1.getProduct().getProductClassification().getId());
        assertNotNull(simulatedProposal1.getProduct().getProductClassification().getName());
        assertNotNull(simulatedProposal1.getProduct().getProductConfiguration().getId());
        assertNotNull(simulatedProposal1.getProduct().getProductConfiguration().getDescription());
        assertNotNull(simulatedProposal1.getInterestRates().get(0).getInterestRateType());
        assertNotNull(simulatedProposal1.getInterestRates().get(0).getValue());
        assertNotNull(simulatedProposal1.getInterestRates().get(1).getInterestRateType());
        assertNotNull(simulatedProposal1.getInterestRates().get(1).getValue());
        assertNotNull(simulatedProposal1.getInterestRates().get(2).getInterestRateType());
        assertNotNull(simulatedProposal1.getInterestRates().get(2).getValue());
        assertNotNull(simulatedProposal1.getRanges().get(0).getId());
        assertNotNull(simulatedProposal1.getRanges().get(0).getValue());
        assertNotNull(simulatedProposal1.getRanges().get(1).getId());
        assertNotNull(simulatedProposal1.getRanges().get(1).getValue());
        assertNotNull(simulatedProposal1.getInstallments().get(0).getInstallmentType());
        assertNotNull(simulatedProposal1.getInstallments().get(0).getPrincipal().getAmount());
        assertNotNull(simulatedProposal1.getInstallments().get(0).getPrincipal().getCurrency());
        assertNotNull(simulatedProposal1.getInstallments().get(1).getInstallmentType());
        assertNotNull(simulatedProposal1.getInstallments().get(1).getPrincipal().getAmount());
        assertNotNull(simulatedProposal1.getInstallments().get(1).getPrincipal().getCurrency());
        assertNotNull(simulatedProposal1.getInstallments().get(2).getInstallmentType());
        assertNotNull(simulatedProposal1.getInstallments().get(2).getPrincipal().getAmount());
        assertNotNull(simulatedProposal1.getInstallments().get(2).getPrincipal().getCurrency());
        assertNotNull(simulatedProposal1.getGrantedAmounts().get(0).getGrantedAmountType().getId());
        assertNotNull(simulatedProposal1.getGrantedAmounts().get(0).getValue());
        assertNotNull(simulatedProposal1.getGrantedAmounts().get(0).getCurrency());
        assertNotNull(simulatedProposal1.getGrantedAmounts().get(1).getGrantedAmountType().getId());
        assertNotNull(simulatedProposal1.getGrantedAmounts().get(1).getValue());
        assertNotNull(simulatedProposal1.getGrantedAmounts().get(1).getCurrency());
        assertNotNull(simulatedProposal1.getGrantedAmounts().get(2).getGrantedAmountType().getId());
        assertNotNull(simulatedProposal1.getGrantedAmounts().get(2).getValue());
        assertNotNull(simulatedProposal1.getGrantedAmounts().get(2).getCurrency());

        assertEquals("90015783", simulatedProposal1.getParticipant().getId());
        assertEquals("L", simulatedProposal1.getParticipant().getIdentityDocument().getDocumentType().getId());
        assertEquals("12345678", simulatedProposal1.getParticipant().getIdentityDocument().getDocumentNumber());
        assertEquals("A7", simulatedProposal1.getParticipant().getSegmentationCode());
        assertEquals("A", simulatedProposal1.getParticipant().getRiskLevel().getId());
        assertEquals("Alto", simulatedProposal1.getParticipant().getRiskLevel().getName());
        assertEquals("428", simulatedProposal1.getInternalCode());
        assertEquals("FAST", simulatedProposal1.getProcurementFlow().getProcurementFlowType().getId());
        assertEquals("FAST", simulatedProposal1.getProcurementFlow().getProcurementFlowType().getName());
        assertEquals("ADDRESS_VALIDATION", simulatedProposal1.getIndicators().get(0).getId());
        assertTrue(simulatedProposal1.getIndicators().get(0).getIsActive());
        assertEquals("WORKPLACE_VALIDATION", simulatedProposal1.getIndicators().get(1).getId());
        assertFalse(simulatedProposal1.getIndicators().get(1).getIsActive());
        assertEquals("201609", simulatedProposal1.getCampaign().getCode());
        assertEquals("MONTHLY", simulatedProposal1.getTerm().getFrequency());
        assertEquals(new Integer("36"), simulatedProposal1.getTerm().getValue());
        assertEquals("512312", simulatedProposal1.getProduct().getBin());
        assertEquals("MD", simulatedProposal1.getProduct().getTitle().getId());
        assertEquals("Mastercard Clásica", simulatedProposal1.getProduct().getTitle().getName());
        assertEquals("NO_RISK", simulatedProposal1.getProduct().getRiskGroup());
        assertEquals("CARDS", simulatedProposal1.getProduct().getProductType().getId());
        assertEquals("TC", simulatedProposal1.getProduct().getProductClassification().getId());
        assertEquals("Tarjetas de Crédito", simulatedProposal1.getProduct().getProductClassification().getName());
        assertEquals("208", simulatedProposal1.getProduct().getProductConfiguration().getId());
        assertEquals("BAJO", simulatedProposal1.getProduct().getProductConfiguration().getDescription());

        assertEquals("PROPOSED", simulatedProposal1.getInterestRates().get(0).getInterestRateType());
        assertEquals(new BigDecimal("54.99"), simulatedProposal1.getInterestRates().get(0).getValue());
        assertEquals("MAXIMUM", simulatedProposal1.getInterestRates().get(1).getInterestRateType());
        assertEquals(new BigDecimal("0"), simulatedProposal1.getInterestRates().get(1).getValue());
        assertEquals("MINIMUM", simulatedProposal1.getInterestRates().get(2).getInterestRateType());
        assertEquals(new BigDecimal("0"), simulatedProposal1.getInterestRates().get(2).getValue());

        assertEquals("MAXIMUM", simulatedProposal1.getRanges().get(0).getId());
        assertEquals(new BigDecimal("100000"), simulatedProposal1.getRanges().get(0).getValue());
        assertEquals("MINIMUM", simulatedProposal1.getRanges().get(1).getId());
        assertEquals(new BigDecimal("700"), simulatedProposal1.getRanges().get(1).getValue());

        assertEquals("ADJUSTED", simulatedProposal1.getInstallments().get(0).getInstallmentType());
        assertEquals(new BigDecimal("310.17279"), simulatedProposal1.getInstallments().get(0).getPrincipal().getAmount());
        assertEquals("PEN", simulatedProposal1.getInstallments().get(0).getPrincipal().getCurrency());
        assertEquals("CONTRACT", simulatedProposal1.getInstallments().get(1).getInstallmentType());
        assertEquals(new BigDecimal("310.17279"), simulatedProposal1.getInstallments().get(1).getPrincipal().getAmount());
        assertEquals("PEN", simulatedProposal1.getInstallments().get(1).getPrincipal().getCurrency());
        assertEquals("REAL", simulatedProposal1.getInstallments().get(2).getInstallmentType());
        assertEquals(new BigDecimal("313.16"), simulatedProposal1.getInstallments().get(2).getPrincipal().getAmount());
        assertEquals("PEN", simulatedProposal1.getInstallments().get(2).getPrincipal().getCurrency());

        assertEquals("ADJUSTED", simulatedProposal1.getGrantedAmounts().get(0).getGrantedAmountType().getId());
        assertEquals(new BigDecimal("6100"), simulatedProposal1.getGrantedAmounts().get(0).getValue());
        assertEquals("PEN", simulatedProposal1.getGrantedAmounts().get(0).getCurrency());
        assertEquals("CONTRACTED", simulatedProposal1.getGrantedAmounts().get(1).getGrantedAmountType().getId());
        assertEquals(new BigDecimal("6100"), simulatedProposal1.getGrantedAmounts().get(1).getValue());
        assertEquals("PEN", simulatedProposal1.getGrantedAmounts().get(1).getCurrency());
        assertEquals("REAL", simulatedProposal1.getGrantedAmounts().get(2).getGrantedAmountType().getId());
        assertEquals(new BigDecimal("6159"), simulatedProposal1.getGrantedAmounts().get(2).getValue());
        assertEquals("PEN", simulatedProposal1.getGrantedAmounts().get(2).getCurrency());

        SimulatedProposal simulatedProposal2 = data.get(1);
        assertNotNull(simulatedProposal2);
        assertNotNull(simulatedProposal2.getParticipant().getId());
        assertNotNull(simulatedProposal2.getParticipant().getIdentityDocument().getDocumentType().getId());
        assertNotNull(simulatedProposal2.getParticipant().getIdentityDocument().getDocumentNumber());
        assertNotNull(simulatedProposal2.getParticipant().getSegmentationCode());
        assertNotNull(simulatedProposal2.getParticipant().getRiskLevel().getId());
        assertNotNull(simulatedProposal2.getParticipant().getRiskLevel().getName());
        assertNotNull(simulatedProposal2.getInternalCode());
        assertNotNull(simulatedProposal2.getProcurementFlow().getProcurementFlowType().getId());
        assertNotNull(simulatedProposal2.getProcurementFlow().getProcurementFlowType().getName());
        assertNotNull(simulatedProposal2.getIndicators().get(0).getId());
        assertNotNull(simulatedProposal2.getIndicators().get(0).getIsActive());
        assertNotNull(simulatedProposal2.getIndicators().get(1).getId());
        assertNotNull(simulatedProposal2.getIndicators().get(1).getIsActive());
        assertNotNull(simulatedProposal2.getCampaign().getCode());
        assertNotNull(simulatedProposal2.getTerm().getFrequency());
        assertNotNull(simulatedProposal2.getTerm().getValue());
        assertNotNull(simulatedProposal2.getProduct().getBin());
        assertNotNull(simulatedProposal2.getProduct().getTitle().getId());
        assertNotNull(simulatedProposal2.getProduct().getTitle().getName());
        assertNotNull(simulatedProposal2.getProduct().getRiskGroup());
        assertNotNull(simulatedProposal2.getProduct().getProductType().getId());
        assertNotNull(simulatedProposal2.getProduct().getProductClassification().getId());
        assertNotNull(simulatedProposal2.getProduct().getProductClassification().getName());
        assertNotNull(simulatedProposal2.getProduct().getProductConfiguration().getId());
        assertNotNull(simulatedProposal2.getProduct().getProductConfiguration().getDescription());
        assertNotNull(simulatedProposal2.getInterestRates().get(0).getInterestRateType());
        assertNotNull(simulatedProposal2.getInterestRates().get(0).getValue());
        assertNotNull(simulatedProposal2.getInterestRates().get(1).getInterestRateType());
        assertNotNull(simulatedProposal2.getInterestRates().get(1).getValue());
        assertNotNull(simulatedProposal2.getInterestRates().get(2).getInterestRateType());
        assertNotNull(simulatedProposal2.getInterestRates().get(2).getValue());
        assertNotNull(simulatedProposal2.getRanges().get(0).getId());
        assertNotNull(simulatedProposal2.getRanges().get(0).getValue());
        assertNotNull(simulatedProposal2.getRanges().get(1).getId());
        assertNotNull(simulatedProposal2.getRanges().get(1).getValue());
        assertNotNull(simulatedProposal2.getInstallments().get(0).getInstallmentType());
        assertNotNull(simulatedProposal2.getInstallments().get(0).getPrincipal().getAmount());
        assertNotNull(simulatedProposal2.getInstallments().get(0).getPrincipal().getCurrency());
        assertNotNull(simulatedProposal2.getInstallments().get(1).getInstallmentType());
        assertNotNull(simulatedProposal2.getInstallments().get(1).getPrincipal().getAmount());
        assertNotNull(simulatedProposal2.getInstallments().get(1).getPrincipal().getCurrency());
        assertNotNull(simulatedProposal2.getInstallments().get(2).getInstallmentType());
        assertNotNull(simulatedProposal2.getInstallments().get(2).getPrincipal().getAmount());
        assertNotNull(simulatedProposal2.getInstallments().get(2).getPrincipal().getCurrency());
        assertNotNull(simulatedProposal2.getGrantedAmounts().get(0).getGrantedAmountType().getId());
        assertNotNull(simulatedProposal2.getGrantedAmounts().get(0).getValue());
        assertNotNull(simulatedProposal2.getGrantedAmounts().get(0).getCurrency());
        assertNotNull(simulatedProposal2.getGrantedAmounts().get(1).getGrantedAmountType().getId());
        assertNotNull(simulatedProposal2.getGrantedAmounts().get(1).getValue());
        assertNotNull(simulatedProposal2.getGrantedAmounts().get(1).getCurrency());
        assertNotNull(simulatedProposal2.getGrantedAmounts().get(2).getGrantedAmountType().getId());
        assertNotNull(simulatedProposal2.getGrantedAmounts().get(2).getValue());
        assertNotNull(simulatedProposal2.getGrantedAmounts().get(2).getCurrency());

        assertEquals("90015783", simulatedProposal2.getParticipant().getId());
        assertEquals("R", simulatedProposal2.getParticipant().getIdentityDocument().getDocumentType().getId());
        assertEquals("12345678901", simulatedProposal2.getParticipant().getIdentityDocument().getDocumentNumber());
        assertEquals("B6", simulatedProposal2.getParticipant().getSegmentationCode());
        assertEquals("B", simulatedProposal2.getParticipant().getRiskLevel().getId());
        assertEquals("Bajo", simulatedProposal2.getParticipant().getRiskLevel().getName());
        assertEquals("427", simulatedProposal2.getInternalCode());
        assertEquals("FAST", simulatedProposal2.getProcurementFlow().getProcurementFlowType().getId());
        assertEquals("FAST", simulatedProposal2.getProcurementFlow().getProcurementFlowType().getName());
        assertEquals("ADDRESS_VALIDATION", simulatedProposal2.getIndicators().get(0).getId());
        assertTrue(simulatedProposal2.getIndicators().get(0).getIsActive());
        assertEquals("WORKPLACE_VALIDATION", simulatedProposal2.getIndicators().get(1).getId());
        assertFalse(simulatedProposal2.getIndicators().get(1).getIsActive());
        assertEquals("201609", simulatedProposal2.getCampaign().getCode());
        assertEquals("MONTHLY", simulatedProposal2.getTerm().getFrequency());
        assertEquals(new Integer("36"), simulatedProposal2.getTerm().getValue());
        assertEquals("512409", simulatedProposal2.getProduct().getBin());
        assertEquals("MP", simulatedProposal2.getProduct().getTitle().getId());
        assertEquals("Mastercard Oro", simulatedProposal2.getProduct().getTitle().getName());
        assertEquals("NO_RISK", simulatedProposal2.getProduct().getRiskGroup());
        assertEquals("CARDS", simulatedProposal2.getProduct().getProductType().getId());
        assertEquals("TC", simulatedProposal2.getProduct().getProductClassification().getId());
        assertEquals("Tarjetas de Crédito", simulatedProposal2.getProduct().getProductClassification().getName());
        assertEquals("208", simulatedProposal2.getProduct().getProductConfiguration().getId());
        assertEquals("BAJO", simulatedProposal2.getProduct().getProductConfiguration().getDescription());

        assertEquals("PROPOSED", simulatedProposal2.getInterestRates().get(0).getInterestRateType());
        assertEquals(new BigDecimal("39.99"), simulatedProposal2.getInterestRates().get(0).getValue());
        assertEquals("MAXIMUM", simulatedProposal2.getInterestRates().get(1).getInterestRateType());
        assertEquals(new BigDecimal("0"), simulatedProposal2.getInterestRates().get(1).getValue());
        assertEquals("MINIMUM", simulatedProposal2.getInterestRates().get(2).getInterestRateType());
        assertEquals(new BigDecimal("0"), simulatedProposal2.getInterestRates().get(2).getValue());

        assertEquals("MAXIMUM", simulatedProposal2.getRanges().get(0).getId());
        assertEquals(new BigDecimal("100000"), simulatedProposal2.getRanges().get(0).getValue());
        assertEquals("MINIMUM", simulatedProposal2.getRanges().get(1).getId());
        assertEquals(new BigDecimal("700"), simulatedProposal2.getRanges().get(1).getValue());

        assertEquals("ADJUSTED", simulatedProposal2.getInstallments().get(0).getInstallmentType());
        assertEquals(new BigDecimal("313.1601"), simulatedProposal2.getInstallments().get(0).getPrincipal().getAmount());
        assertEquals("PEN", simulatedProposal2.getInstallments().get(0).getPrincipal().getCurrency());
        assertEquals("CONTRACT", simulatedProposal2.getInstallments().get(1).getInstallmentType());
        assertEquals(new BigDecimal("313.1601"), simulatedProposal2.getInstallments().get(1).getPrincipal().getAmount());
        assertEquals("PEN", simulatedProposal2.getInstallments().get(1).getPrincipal().getCurrency());
        assertEquals("REAL", simulatedProposal2.getInstallments().get(2).getInstallmentType());
        assertEquals(new BigDecimal("313.16"), simulatedProposal2.getInstallments().get(2).getPrincipal().getAmount());
        assertEquals("PEN", simulatedProposal2.getInstallments().get(2).getPrincipal().getCurrency());

        assertEquals("ADJUSTED", simulatedProposal2.getGrantedAmounts().get(0).getGrantedAmountType().getId());
        assertEquals(new BigDecimal("7000"), simulatedProposal2.getGrantedAmounts().get(0).getValue());
        assertEquals("PEN", simulatedProposal2.getGrantedAmounts().get(0).getCurrency());
        assertEquals("CONTRACTED", simulatedProposal2.getGrantedAmounts().get(1).getGrantedAmountType().getId());
        assertEquals(new BigDecimal("7000"), simulatedProposal2.getGrantedAmounts().get(1).getValue());
        assertEquals("PEN", simulatedProposal2.getGrantedAmounts().get(1).getCurrency());
        assertEquals("REAL", simulatedProposal2.getGrantedAmounts().get(2).getGrantedAmountType().getId());
        assertEquals(new BigDecimal("7000"), simulatedProposal2.getGrantedAmounts().get(2).getValue());
        assertEquals("PEN", simulatedProposal2.getGrantedAmounts().get(2).getCurrency());

        SimulatedProposal simulatedProposal3 = data.get(2);
        assertNotNull(simulatedProposal3);
        assertNull(simulatedProposal3.getParticipant());
        assertNull(simulatedProposal3.getInternalCode());
        assertNull(simulatedProposal3.getProcurementFlow());
        assertNotNull(simulatedProposal3.getIndicators().get(0).getId());
        assertNotNull(simulatedProposal3.getIndicators().get(0).getIsActive());
        assertNotNull(simulatedProposal3.getIndicators().get(1).getId());
        assertNotNull(simulatedProposal3.getIndicators().get(1).getIsActive());
        assertNull(simulatedProposal3.getCampaign());
        assertNull(simulatedProposal3.getTerm());
        assertNull(simulatedProposal3.getProduct());
        assertNotNull(simulatedProposal3.getInterestRates().get(0).getInterestRateType());
        assertNull(simulatedProposal3.getInterestRates().get(0).getValue());
        assertNotNull(simulatedProposal3.getInterestRates().get(1).getInterestRateType());
        assertNull(simulatedProposal3.getInterestRates().get(1).getValue());
        assertNotNull(simulatedProposal3.getInterestRates().get(2).getInterestRateType());
        assertNull(simulatedProposal3.getInterestRates().get(2).getValue());
        assertNotNull(simulatedProposal3.getRanges().get(0).getId());
        assertNull(simulatedProposal3.getRanges().get(0).getValue());
        assertNotNull(simulatedProposal3.getRanges().get(1).getId());
        assertNull(simulatedProposal3.getRanges().get(1).getValue());
        assertNotNull(simulatedProposal3.getInstallments().get(0).getInstallmentType());
        assertNull(simulatedProposal3.getInstallments().get(0).getPrincipal().getAmount());
        assertNull(simulatedProposal3.getInstallments().get(0).getPrincipal().getCurrency());
        assertNotNull(simulatedProposal3.getInstallments().get(1).getInstallmentType());
        assertNull(simulatedProposal3.getInstallments().get(1).getPrincipal().getAmount());
        assertNull(simulatedProposal3.getInstallments().get(1).getPrincipal().getCurrency());
        assertNotNull(simulatedProposal3.getInstallments().get(2).getInstallmentType());
        assertNull(simulatedProposal3.getInstallments().get(2).getPrincipal().getAmount());
        assertNull(simulatedProposal3.getInstallments().get(2).getPrincipal().getCurrency());
        assertNotNull(simulatedProposal3.getGrantedAmounts().get(0).getGrantedAmountType().getId());
        assertNull(simulatedProposal3.getGrantedAmounts().get(0).getValue());
        assertNull(simulatedProposal3.getGrantedAmounts().get(0).getCurrency());
        assertNotNull(simulatedProposal3.getGrantedAmounts().get(1).getGrantedAmountType().getId());
        assertNull(simulatedProposal3.getGrantedAmounts().get(1).getValue());
        assertNull(simulatedProposal3.getGrantedAmounts().get(1).getCurrency());
        assertNotNull(simulatedProposal3.getGrantedAmounts().get(2).getGrantedAmountType().getId());
        assertNull(simulatedProposal3.getGrantedAmounts().get(2).getValue());
        assertNull(simulatedProposal3.getGrantedAmounts().get(2).getCurrency());

        assertEquals("ADDRESS_VALIDATION", simulatedProposal3.getIndicators().get(0).getId());
        assertEquals("WORKPLACE_VALIDATION", simulatedProposal3.getIndicators().get(1).getId());
        assertEquals("PROPOSED", simulatedProposal3.getInterestRates().get(0).getInterestRateType());
        assertEquals("MAXIMUM", simulatedProposal3.getInterestRates().get(1).getInterestRateType());
        assertEquals("MINIMUM", simulatedProposal3.getInterestRates().get(2).getInterestRateType());
        assertEquals("MAXIMUM", simulatedProposal3.getRanges().get(0).getId());
        assertEquals("MINIMUM", simulatedProposal3.getRanges().get(1).getId());
        assertEquals("ADJUSTED", simulatedProposal3.getInstallments().get(0).getInstallmentType());
        assertEquals("CONTRACT", simulatedProposal3.getInstallments().get(1).getInstallmentType());
        assertEquals("REAL", simulatedProposal3.getInstallments().get(2).getInstallmentType());
        assertEquals("ADJUSTED", simulatedProposal3.getGrantedAmounts().get(0).getGrantedAmountType().getId());
        assertEquals("CONTRACTED", simulatedProposal3.getGrantedAmounts().get(1).getGrantedAmountType().getId());
        assertEquals("REAL", simulatedProposal3.getGrantedAmounts().get(2).getGrantedAmountType().getId());
    }

    @Test
    public void mapOutEmpty() {
        SimulatedProposalsData result = restSimulateProposalsMapper.mapOut(new SimulatedProposalsResponse());

        assertNull(result);
    }
}