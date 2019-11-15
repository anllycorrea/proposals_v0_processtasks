package com.bbva.pzic.proposals.facade.v0.mapper.impl;

import com.bbva.pzic.proposals.EntityStubs;
import com.bbva.pzic.proposals.business.dto.DTOInputModifyExternalFinancingProposal;
import com.bbva.pzic.proposals.canonic.ExternalFinancingProposal;
import com.bbva.pzic.proposals.util.mappers.EnumMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;

import static com.bbva.pzic.proposals.EntityStubs.*;
import static org.junit.Assert.*;

/**
 * Created on 12/04/2017.
 *
 * @author Entelgy
 */
@RunWith(MockitoJUnitRunner.class)
public class ModifyExternalFinancingProposalMapperTest {

    private EntityStubs mock = EntityStubs.getInstance();

    @InjectMocks
    private ModifyExternalFinancingProposalMapper mapper;

    @Mock
    private EnumMapper enumMapper;

    @Before
    public void setup() {
        Mockito.when(enumMapper.getBackendValue("externalFinancingProposals.delivery.deliveryType.id", EXTERNAL_FINANCING_PROPOSALS_DELIVERY_TYPE_VALUE)).thenReturn(EXTERNAL_FINANCING_PROPOSALS_DELIVERY_TYPE_ID);
        Mockito.when(enumMapper.getBackendValue("externalFinancingProposals.status.id", STATUS_VALUE)).thenReturn(STATUS_ID);
    }

    @Test
    public void mapInFullTest() throws IOException {
        ExternalFinancingProposal payload = mock.modifyExternalFinancingProposalPayload();
        DTOInputModifyExternalFinancingProposal result = mapper.mapIn(EntityStubs.EXTERNAL_FINANCING_PROPOSAL_ID, payload);

        assertNotNull(result.getExternalFinancingProposalId());
        assertNotNull(result.getExternalFinancingProposal().getStatusId());
        assertNotNull(result.getExternalFinancingProposal().getDeliveryTypeId());
        assertNotNull(result.getExternalFinancingProposal().getEmail());

        assertEquals(EntityStubs.EXTERNAL_FINANCING_PROPOSAL_ID, result.getExternalFinancingProposalId());
        assertEquals(STATUS_ID, result.getExternalFinancingProposal().getStatusId());
        assertEquals(EXTERNAL_FINANCING_PROPOSALS_DELIVERY_TYPE_ID, result.getExternalFinancingProposal().getDeliveryTypeId());
        assertEquals(payload.getDelivery().getEmail(), result.getExternalFinancingProposal().getEmail());
    }

    @Test
    public void mapInEmptyTest() {
        DTOInputModifyExternalFinancingProposal result = mapper.mapIn(null, new ExternalFinancingProposal());

        assertNull(result.getExternalFinancingProposalId());
        assertNull(result.getExternalFinancingProposal().getStatusId());
        assertNull(result.getExternalFinancingProposal().getDeliveryTypeId());
        assertNull(result.getExternalFinancingProposal().getEmail());
    }
}