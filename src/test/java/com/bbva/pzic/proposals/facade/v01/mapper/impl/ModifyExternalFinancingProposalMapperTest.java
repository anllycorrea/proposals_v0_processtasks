package com.bbva.pzic.proposals.facade.v01.mapper.impl;

import com.bbva.pzic.proposals.DummyMock;
import com.bbva.pzic.proposals.business.dto.DTOInputModifyExternalFinancingProposal;
import com.bbva.pzic.proposals.canonic.ExternalFinancingProposal;
import com.bbva.pzic.proposals.facade.v01.mapper.IModifyExternalFinancingProposalMapper;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created on 12/04/2017.
 *
 * @author Entelgy
 */
public class ModifyExternalFinancingProposalMapperTest {

    private IModifyExternalFinancingProposalMapper mapper;
    private DummyMock mock = new DummyMock();

    @Before
    public void setup() {
        mapper = new ModifyExternalFinancingProposalMapper();
    }

    @Test
    public void mapInFullTest() throws IOException {
        ExternalFinancingProposal payload = mock.modifyExternalFinancingProposalPayload();
        DTOInputModifyExternalFinancingProposal result = mapper.mapIn(DummyMock.EXTERNAL_FINANCING_PROPOSAL_ID, payload);

        assertNotNull(result.getExternalFinancingProposalId());
        assertNotNull(result.getExternalFinancingProposal().getStatusId());
        assertNotNull(result.getExternalFinancingProposal().getDeliveryTypeId());
        assertNotNull(result.getExternalFinancingProposal().getDeliveryVirtualDestination());

        assertEquals(DummyMock.EXTERNAL_FINANCING_PROPOSAL_ID, result.getExternalFinancingProposalId());
        assertEquals(payload.getStatus().getId(), result.getExternalFinancingProposal().getStatusId());
        assertEquals(payload.getDelivery().getDeliveryType().getId(), result.getExternalFinancingProposal().getDeliveryTypeId());
        assertEquals(payload.getDelivery().getVirtualDestination(), result.getExternalFinancingProposal().getDeliveryVirtualDestination());
    }

    @Test
    public void mapInEmptyTest() throws IOException {
        DTOInputModifyExternalFinancingProposal result = mapper.mapIn(null, new ExternalFinancingProposal());

        assertNull(result.getExternalFinancingProposalId());
        assertNull(result.getExternalFinancingProposal().getStatusId());
        assertNull(result.getExternalFinancingProposal().getDeliveryTypeId());
        assertNull(result.getExternalFinancingProposal().getDeliveryVirtualDestination());
    }
}