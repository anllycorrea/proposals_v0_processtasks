package com.bbva.pzic.proposals.dao.tx.mapper.impl;

import com.bbva.pzic.proposals.DummyMock;
import com.bbva.pzic.proposals.business.dto.DTOIntExternalFinancingProposal;
import com.bbva.pzic.proposals.canonic.ExternalFinancingProposal;
import com.bbva.pzic.proposals.dao.model.ugap.FormatoUGMEGAP;
import com.bbva.pzic.proposals.dao.model.ugap.FormatoUGMSGAP1;
import com.bbva.pzic.proposals.dao.model.ugap.mock.FormatUgapMock;
import com.bbva.pzic.proposals.util.mappers.EnumMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created on 12/04/2017.
 *
 * @author Entelgy
 */
public class TxCreateExternalFinancingProposalMapperTest {
    private static final String PROPERTY_DOCUMENT_TYPE_ID_DNI_VALUE_TESTED = "DNI";
    private static final String PROPERTY_DOCUMENT_TYPE_ID_DNI_KEY_TESTED = "L";

    private static final String PROPERTY_DELIVERY_TYPE_ID_VIRTUAL_VALUE_TESTED = "VIRTUAL";
    private static final String PROPERTY_DELIVERY_TYPE_ID_VIRTUAL_KEY_TESTED = "1";

    @InjectMocks
    private TxCreateExternalFinancingProposalMapper mapper;

    @Mock
    private EnumMapper enumMapper;

    private DummyMock dummyMock;
    private FormatUgapMock formatUgapMock;

    @Before
    public void setUp() {
        dummyMock = new DummyMock();
        formatUgapMock = new FormatUgapMock();
        MockitoAnnotations.initMocks(this);
        mapInEnum();
    }

    private void mapInEnum() {
        Mockito.when(enumMapper.getBackendValue("documentType.id",
                PROPERTY_DOCUMENT_TYPE_ID_DNI_VALUE_TESTED)).thenReturn(PROPERTY_DOCUMENT_TYPE_ID_DNI_KEY_TESTED);
        Mockito.when(enumMapper.getBackendValue("externalFinancingProposals.delivery.deliveryType.id",
                PROPERTY_DELIVERY_TYPE_ID_VIRTUAL_VALUE_TESTED)).thenReturn(PROPERTY_DELIVERY_TYPE_ID_VIRTUAL_KEY_TESTED);
    }

    @Test
    public void mapInFullTest() throws IOException {
        DTOIntExternalFinancingProposal dtoIntExternalFinancingProposal = dummyMock.getDTOIntExternalFinancingProposal();
        FormatoUGMEGAP result = mapper.mapIn(dtoIntExternalFinancingProposal);

        assertNotNull(result);
        assertNotNull(result.getMoneda());
        assertNotNull(result.getDiapago());
        assertNotNull(result.getImpfina());
        assertNotNull(result.getTarifa());
        assertNotNull(result.getTipenvi());
        assertNotNull(result.getMailcon());
        assertNotNull(result.getCodbien());
        assertNotNull(result.getImpbien());
        assertNotNull(result.getTipdocu());
        assertNotNull(result.getNrodocu());
        assertNotNull(result.getIdtoken());
        assertNotNull(result.getCodtr());
        assertNotNull(result.getCodemp());
        assertNotNull(result.getCodcnc());
        assertNotNull(result.getCocliex());
        assertNotNull(result.getCodofic());

        assertEquals(dtoIntExternalFinancingProposal.getCurrency(), result.getMoneda());
        assertEquals(dtoIntExternalFinancingProposal.getPaymentDay(), result.getDiapago());
        assertEquals(dtoIntExternalFinancingProposal.getInitialAmount().getAmount(), result.getImpfina());
        assertEquals(dtoIntExternalFinancingProposal.getTariff().getId(), result.getTarifa());
        assertEquals(PROPERTY_DELIVERY_TYPE_ID_VIRTUAL_KEY_TESTED, result.getTipenvi());
        assertEquals(dtoIntExternalFinancingProposal.getEmail(), result.getMailcon());
        assertEquals(dtoIntExternalFinancingProposal.getExternalProduct().getId(), result.getCodbien());
        assertEquals(dtoIntExternalFinancingProposal.getExternalProduct().getCommercialValue().getAmount(), result.getImpbien());
        assertEquals(PROPERTY_DOCUMENT_TYPE_ID_DNI_KEY_TESTED, result.getTipdocu());
        assertEquals(dtoIntExternalFinancingProposal.getDocumentNumber(), result.getNrodocu());
        assertEquals(dtoIntExternalFinancingProposal.getOperation().getId(), result.getIdtoken());
        assertEquals(dtoIntExternalFinancingProposal.getOperation().getOperationType().getId(), result.getCodtr());
        assertEquals(dtoIntExternalFinancingProposal.getThirdPartyProvider().getId(), result.getCodemp());
        assertEquals(dtoIntExternalFinancingProposal.getThirdPartyProvider().getExternalSalesChannel().getId(), result.getCodcnc());
        assertEquals(dtoIntExternalFinancingProposal.getThirdPartyProvider().getUserId(), result.getCocliex());
        assertEquals(dtoIntExternalFinancingProposal.getBranchId(), result.getCodofic());
    }

    @Test
    public void mapInEmptyTest() {
        FormatoUGMEGAP result = mapper.mapIn(new DTOIntExternalFinancingProposal());
        assertNotNull(result);

        assertNull(result.getTipdocu());
        assertNull(result.getNrodocu());
        assertNull(result.getTarifa());
        assertNull(result.getImpfina());
        assertNull(result.getDiapago());
        assertNull(result.getMailcon());
        assertNull(result.getTipenvi());
        assertNull(result.getMoneda());
        assertNull(result.getIdtoken());
        assertNull(result.getImpbien());
        assertNull(result.getCodbien());
        assertNull(result.getCodtr());
        assertNull(result.getCodcnc());
        assertNull(result.getCodemp());
        assertNull(result.getCocliex());
        assertNull(result.getCodofic());
    }


    @Test
    public void mapOutFullTest() throws IOException {

        FormatoUGMSGAP1 formatoUGMSGAP1 = formatUgapMock.getFormatoUGMSGAP1();

        ExternalFinancingProposal result = mapper.mapOut(formatoUGMSGAP1);
        assertNotNull(result);
        assertNotNull(result.getId());
    }

    @Test
    public void mapOutWithoutFormatTest() throws IOException {
        ExternalFinancingProposal result = mapper.mapOut(null);
        assertNull(result);
    }

    @Test
    public void mapOutEmptyTest() throws IOException {
        ExternalFinancingProposal result = mapper.mapOut(new FormatoUGMSGAP1());
        assertNotNull(result);
        assertNull(result.getId());
    }
}