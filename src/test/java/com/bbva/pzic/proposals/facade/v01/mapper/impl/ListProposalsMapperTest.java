package com.bbva.pzic.proposals.facade.v01.mapper.impl;

import com.bbva.pzic.proposals.business.dto.DTOInputListProposals;
import com.bbva.pzic.proposals.facade.v01.mapper.IListProposalsMapper;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ListProposalsMapperTest {

    private IListProposalsMapper proposalsMapper;

    @Before
    public void init()  {
        proposalsMapper = new ListProposalsMapper();
    }

    @Test
    public void testMapInput() {
        final String documentType = "DNI";
        final String documentNumber = "00000001";
        final String productClassification = "CREDIT_CARD";
        final String paginationKey = "123456789qwertyuio";
        final Long pageSize = new Long(123);
        final DTOInputListProposals dtoInputListProposals = proposalsMapper.mapInput(documentType, documentNumber,
                productClassification, paginationKey, pageSize);
        assertNotNull(dtoInputListProposals);
        assertEquals(documentType, dtoInputListProposals.getDocumentType());
        assertEquals(documentNumber, dtoInputListProposals.getDocumentNumber());
        assertEquals(productClassification, dtoInputListProposals.getProductClassification());
        assertEquals(paginationKey, dtoInputListProposals.getPaginationKey());
        assertEquals(pageSize, dtoInputListProposals.getPageSize());
    }

}