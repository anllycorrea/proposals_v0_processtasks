package com.bbva.pzic.proposals.dao.tx.mapper.impl;

import com.bbva.pzic.proposals.business.dto.DTOIntExternalFinancingProposal;
import com.bbva.pzic.proposals.canonic.ExternalFinancingProposal;
import com.bbva.pzic.proposals.dao.model.ugap.FormatoUGMEGAP;
import com.bbva.pzic.proposals.dao.model.ugap.FormatoUGMSGAP1;
import com.bbva.pzic.proposals.util.mappers.EnumMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.cxf.helpers.IOUtils;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created on 12/04/2017.
 *
 * @author Entelgy
 */
public class TxCreateExternalFinancingProposalMapperTest {
    private static final String DTO_EXTERNAL_FINANCING_PROPOSAL = "com/bbva/pzic/proposals/dao/tx/mapper/impl/dtoIntExternalFinancingProposal.json";
    private static final String FORMATO_UGMSGAP1 = "com/bbva/pzic/proposals/dao/model/ugap/mock/FormatoUGMSGAP1.json";

    private static final String PROPERTY_DOCUMENT_TYPE_ID_DNI_VALUE_TESTED = "DNI";
    private static final String PROPERTY_DOCUMENT_TYPE_ID_DNI_KEY_TESTED = "L";

    private static final String PROPERTY_DELIVERY_TYPE_ID_VIRTUAL_VALUE_TESTED = "VIRTUAL";
    private static final String PROPERTY_DELIVERY_TYPE_ID_VIRTUAL_KEY_TESTED = "1";

    @InjectMocks
    private TxCreateExternalFinancingProposalMapper mapper;

    @Mock
    private EnumMapper enumMapper;

    private ObjectMapper objectMapper;

    @Before
    public void setUp() {
        objectMapper = new ObjectMapper();
        MockitoAnnotations.initMocks(this);
        mapInEnum();
    }

    private void mapInEnum() {

        Mockito.when(enumMapper.getBackendValue("documentType.id",
                PROPERTY_DOCUMENT_TYPE_ID_DNI_VALUE_TESTED)).thenReturn(PROPERTY_DOCUMENT_TYPE_ID_DNI_KEY_TESTED);
        Mockito.when(enumMapper.getBackendValue("externalFinancingProposals.delivery.type.id",
                PROPERTY_DELIVERY_TYPE_ID_VIRTUAL_VALUE_TESTED)).thenReturn(PROPERTY_DELIVERY_TYPE_ID_VIRTUAL_KEY_TESTED);
    }

    @Test
    public void mapInFullTest() throws IOException {

        DTOIntExternalFinancingProposal dtoIntExternalFinancingProposal = getInstance(DTO_EXTERNAL_FINANCING_PROPOSAL, DTOIntExternalFinancingProposal.class);
        FormatoUGMEGAP result = mapper.mapIn(dtoIntExternalFinancingProposal);

        assertNotNull(result);
        assertNotNull(result.getTipdocu());
        assertNotNull(result.getNrodocu());
        assertNotNull(result.getTarifa());
        assertNotNull(result.getImpfina());
        assertNotNull(result.getDiapago());
        assertNotNull(result.getMailcon());
        assertNotNull(result.getTipenvi());
        assertNotNull(result.getMoneda());
        assertNotNull(result.getIdtoken());
        assertNotNull(result.getImpbien());
        assertNotNull(result.getCodbien());
        assertNotNull(result.getCodtr());
        assertNotNull(result.getCodcnc());
        assertNotNull(result.getCodemp());

        assertEquals(PROPERTY_DOCUMENT_TYPE_ID_DNI_KEY_TESTED, result.getTipdocu());
        assertEquals(dtoIntExternalFinancingProposal.getDocumentNumber(), result.getNrodocu());
        assertEquals(dtoIntExternalFinancingProposal.getTariff().getId(), result.getTarifa());
        assertEquals(dtoIntExternalFinancingProposal.getCurrency(), result.getMoneda());
        assertEquals(dtoIntExternalFinancingProposal.getInitialAmount().getAmount(), result.getImpfina());
        assertEquals(dtoIntExternalFinancingProposal.getPaymentDay(), result.getDiapago());
        assertEquals(PROPERTY_DELIVERY_TYPE_ID_VIRTUAL_KEY_TESTED, result.getTipenvi());
        assertEquals(dtoIntExternalFinancingProposal.getDeliveryVirtualDestination(), result.getMailcon());
        assertEquals(dtoIntExternalFinancingProposal.getOperation().getId(), result.getIdtoken());
        assertEquals(dtoIntExternalFinancingProposal.getOperation().getOperationType().getId(), result.getCodtr());
        assertEquals(dtoIntExternalFinancingProposal.getExternalProduct().getId(), result.getCodbien());
        assertEquals(dtoIntExternalFinancingProposal.getExternalProduct().getCommercialValueAmount().getAmount(), result.getImpbien());
        assertEquals(dtoIntExternalFinancingProposal.getThirdPartyProvider().getExternalSalesChannel().getId(), result.getCodcnc());
        assertEquals(dtoIntExternalFinancingProposal.getThirdPartyProvider().getId(), result.getCodemp());
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
    }


    @Test
    public void mapOutFullTest() throws IOException {

        FormatoUGMSGAP1 formatoUGMSGAP1 = getInstance(FORMATO_UGMSGAP1, FormatoUGMSGAP1.class);

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

    private <T> T getInstance(String file, Class<T> claz) throws IOException {
        InputStream in = Thread.currentThread().getContextClassLoader().
                getResourceAsStream(file);
        return objectMapper.readValue(IOUtils.readBytesFromStream(in), claz);
    }
}