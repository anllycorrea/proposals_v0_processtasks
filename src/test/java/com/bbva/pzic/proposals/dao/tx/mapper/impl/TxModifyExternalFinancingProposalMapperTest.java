package com.bbva.pzic.proposals.dao.tx.mapper.impl;

import com.bbva.pzic.proposals.DummyMock;
import com.bbva.pzic.proposals.business.dto.DTOInputModifyExternalFinancingProposal;
import com.bbva.pzic.proposals.dao.model.ugmp.FormatoUGMEGMP;
import com.bbva.pzic.proposals.dao.tx.mapper.ITxModifyExternalFinancingProposalMapper;
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
public class TxModifyExternalFinancingProposalMapperTest {

    @InjectMocks
    private ITxModifyExternalFinancingProposalMapper mapper;

    @Mock
    private EnumMapper enumMapper;

    private DummyMock dummyMock;

    @Before
    public void setUp() {
        mapper = new TxModifyExternalFinancingProposalMapper();
        dummyMock = new DummyMock();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void mapInFullTest() throws IOException {
        DTOInputModifyExternalFinancingProposal dtoIn = dummyMock.getDTOInputModifyExternalFinancingProposal();

        Mockito.when(enumMapper.getBackendValue("externalFinancingProposals.status.id", dtoIn.getExternalFinancingProposal().getStatusId())).thenReturn("A");
        Mockito.when(enumMapper.getBackendValue("externalFinancingProposals.delivery.deliveryType.id", dtoIn.getExternalFinancingProposal().getDeliveryTypeId())).thenReturn("B");

        FormatoUGMEGMP result = mapper.mapIn(dtoIn);

        assertNotNull(result.getNrocont());
        assertNotNull(result.getIndesta());
        assertNotNull(result.getTipenvi());
        assertNotNull(result.getMailcon());

        assertEquals(dtoIn.getExternalFinancingProposalId(), result.getNrocont());
        assertEquals("A", result.getIndesta());
        assertEquals("B", result.getTipenvi());
        assertEquals(dtoIn.getExternalFinancingProposal().getEmail(), result.getMailcon());
    }

    @Test
    public void mapInMandatoryTest() throws IOException {
        DTOInputModifyExternalFinancingProposal dtoIn = dummyMock.getDTOInputModifyExternalFinancingProposal();
        dtoIn.getExternalFinancingProposal().setDeliveryTypeId(null);
        dtoIn.getExternalFinancingProposal().setEmail(null);

        Mockito.when(enumMapper.getBackendValue("externalFinancingProposals.status.id", dtoIn.getExternalFinancingProposal().getStatusId())).thenReturn("A");

        FormatoUGMEGMP result = mapper.mapIn(dtoIn);

        assertNotNull(result.getNrocont());
        assertNotNull(result.getIndesta());
        assertNull(result.getTipenvi());
        assertNull(result.getMailcon());

        assertEquals(dtoIn.getExternalFinancingProposalId(), result.getNrocont());
        assertEquals("A", result.getIndesta());
    }
}