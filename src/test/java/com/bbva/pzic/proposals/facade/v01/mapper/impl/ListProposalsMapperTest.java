package com.bbva.pzic.proposals.facade.v01.mapper.impl;

import com.bbva.pzic.proposals.business.dto.DTOInputListProposals;
import com.bbva.pzic.proposals.facade.v01.mapper.IListProposalsMapper;
import com.bbva.pzic.proposals.util.mappers.EnumMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ListProposalsMapperTest {

    @InjectMocks
    private IListProposalsMapper proposalsMapper;

    @Mock
    private EnumMapper propertyReader;

    @Before
    public void init() {
        proposalsMapper = new ListProposalsMapper();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testMapInput() {
        final String customerId = "1";
        final String documentType = "DNI";
        final String documentNumber = "00000001";
        final String productClassification = "CREDIT_CARD";
        final String paginationKey = "123456789qwertyuio";
        final Long pageSize = 123L;

        Mockito.when(propertyReader.getBackendValue("documentType.id", documentType)).thenReturn("L");
        Mockito.when(propertyReader.getBackendValue("product.productClassification.id", productClassification)).thenReturn("CC");

        final DTOInputListProposals dtoInputListProposals = proposalsMapper.mapInput(customerId, documentType, documentNumber,
                productClassification, paginationKey, pageSize);

        assertNotNull(dtoInputListProposals);
        assertEquals(customerId, dtoInputListProposals.getCustomerId());
        assertEquals("L", dtoInputListProposals.getDocumentType());
        assertEquals(documentNumber, dtoInputListProposals.getDocumentNumber());
        assertEquals("CC", dtoInputListProposals.getProductClassificationId());
        assertEquals(paginationKey, dtoInputListProposals.getPaginationKey());
        assertEquals(pageSize, dtoInputListProposals.getPageSize());
    }
}