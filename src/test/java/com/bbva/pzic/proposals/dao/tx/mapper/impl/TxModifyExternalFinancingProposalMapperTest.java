package com.bbva.pzic.proposals.dao.tx.mapper.impl;

import com.bbva.pzic.proposals.EntityStubs;
import com.bbva.pzic.proposals.business.dto.DTOInputModifyExternalFinancingProposal;
import com.bbva.pzic.proposals.dao.model.ugmp.FormatoUGMEGMP;
import com.bbva.pzic.proposals.dao.tx.mapper.ITxModifyExternalFinancingProposalMapper;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created on 12/04/2017.
 *
 * @author Entelgy
 */
public class TxModifyExternalFinancingProposalMapperTest {

    private ITxModifyExternalFinancingProposalMapper mapper;

    private EntityStubs entityStubs = EntityStubs.getInstance();

    @Before
    public void setUp() {
        mapper = new TxModifyExternalFinancingProposalMapper();
    }

    @Test
    public void mapInFullTest() throws IOException {
        DTOInputModifyExternalFinancingProposal dtoIn = entityStubs.getDTOInputModifyExternalFinancingProposal();
        FormatoUGMEGMP result = mapper.mapIn(dtoIn);

        assertNotNull(result.getNrocont());
        assertNotNull(result.getIndesta());
        assertNotNull(result.getTipenvi());
        assertNotNull(result.getMailcon());

        assertEquals(dtoIn.getExternalFinancingProposalId(), result.getNrocont());
        assertEquals("8", result.getIndesta());
        assertEquals("D", result.getTipenvi());
        assertEquals(dtoIn.getExternalFinancingProposal().getEmail(), result.getMailcon());
    }

    @Test
    public void mapInMandatoryTest() throws IOException {
        DTOInputModifyExternalFinancingProposal dtoIn = entityStubs.getDTOInputModifyExternalFinancingProposal();
        dtoIn.getExternalFinancingProposal().setDeliveryTypeId(null);
        dtoIn.getExternalFinancingProposal().setEmail(null);

        FormatoUGMEGMP result = mapper.mapIn(dtoIn);

        assertNotNull(result.getNrocont());
        assertNotNull(result.getIndesta());
        assertNull(result.getTipenvi());
        assertNull(result.getMailcon());

        assertEquals(dtoIn.getExternalFinancingProposalId(), result.getNrocont());
        assertEquals("8", result.getIndesta());
    }
}
