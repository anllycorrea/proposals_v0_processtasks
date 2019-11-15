package com.bbva.pzic.proposals.facade.v0.mapper.impl;

import com.bbva.pzic.proposals.EntityStubs;
import com.bbva.pzic.proposals.business.dto.DTOIntSimulatedProposal;
import com.bbva.pzic.proposals.canonic.SimulatedProposal;
import com.bbva.pzic.proposals.facade.v0.mapper.ISimulateProposalsMapper;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created on 28/12/2017.
 *
 * @author Entelgy
 */
public class SimulateProposalsMapperTest {

    private ISimulateProposalsMapper simulateProposalsMapper;
    private EntityStubs entityStubs = EntityStubs.getInstance();

    @Before
    public void setUp() {
        simulateProposalsMapper = new SimulateProposalsMapper();
    }

    @Test
    public void mapInFullTest() throws IOException {
        SimulatedProposal simulatedProposal = entityStubs.getSimulatedProposal();
        DTOIntSimulatedProposal result = simulateProposalsMapper.mapIn(simulatedProposal);

        assertNotNull(result);
        assertNotNull(result.getParticipant().getIdentityDocument().getDocumentType().getId());
        assertNotNull(result.getParticipant().getIdentityDocument().getDocumentNumber());
        assertNotNull(result.getProducts().get(0).getProductClassification().getId());
        assertNotNull(result.getProducts().get(1).getProductClassification().getId());
        assertNotNull(result.getProposal().getTerm().getFrequency());
        assertNotNull(result.getProposal().getTerm().getValue());
        assertNotNull(result.getProposal().getProduct().getProductClassification().getId());
        assertNotNull(result.getProposal().getGrantedAmount().getValue());
        assertNotNull(result.getProposal().getGrantedAmount().getCurrency());
        assertNotNull(result.getProposal().getInstallmentPayment().getAmount());
        assertNotNull(result.getProposal().getInstallmentPayment().getCurrency());
        assertNotNull(result.getProposal().getInterestRate());

        assertEquals("DNI", result.getParticipant().getIdentityDocument().getDocumentType().getId());
        assertEquals("74585467", result.getParticipant().getIdentityDocument().getDocumentNumber());
        assertEquals("CO", result.getProducts().get(0).getProductClassification().getId());
        assertEquals("TC", result.getProducts().get(1).getProductClassification().getId());
        assertEquals("MONTHLY", result.getProposal().getTerm().getFrequency());
        assertEquals(new Integer("36"), result.getProposal().getTerm().getValue());
        assertEquals("TC", result.getProposal().getProduct().getProductClassification().getId());
        assertEquals(new BigDecimal("6100.00"), result.getProposal().getGrantedAmount().getValue());
        assertEquals("PEN", result.getProposal().getGrantedAmount().getCurrency());
        assertEquals(new BigDecimal("310.17279"), result.getProposal().getInstallmentPayment().getAmount());
        assertEquals("PEN", result.getProposal().getInstallmentPayment().getCurrency());
        assertEquals(new BigDecimal("54.99"), result.getProposal().getInterestRate());
    }

    @Test
    public void mapInEmptyTest() {
        DTOIntSimulatedProposal result = simulateProposalsMapper.mapIn(new SimulatedProposal());

        assertNotNull(result);
        assertNull(result.getParticipant());
        assertNull(result.getProducts());
        assertNull(result.getProposal());
    }
}
