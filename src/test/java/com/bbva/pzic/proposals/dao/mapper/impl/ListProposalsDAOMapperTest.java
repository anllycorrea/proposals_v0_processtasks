package com.bbva.pzic.proposals.dao.mapper.impl;

import com.bbva.pzic.proposals.business.dto.DTOInputListProposals;
import com.bbva.pzic.proposals.dao.mapper.IListProposalsDAOMapper;
import com.bbva.pzic.proposals.facade.v01.ISrvProposalsV01;
import com.bbva.pzic.proposals.util.mappers.EnumMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.util.Map;

import static org.junit.Assert.*;

public class ListProposalsDAOMapperTest {

    @InjectMocks
    private ListProposalsDAOMapper listProposalsDAOMapper;

    @Mock
    private EnumMapper enumMapper;

    @Before
    public void init()  {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void mapQuotationIdPathParamTest() throws IOException {
        final String documentTypeBackendValue = "DNI";
        final String productClassificationBackendValue = "DNI";

        Mockito.when(enumMapper.getBackendValue("documentType.id", "DNI")).thenReturn(documentTypeBackendValue);
        Mockito.when(enumMapper.getBackendValue("product.productClassification.id", "CREDIT_CARD")).thenReturn(productClassificationBackendValue);

        final DTOInputListProposals dtoInputListProposals = new DTOInputListProposals();
        dtoInputListProposals.setDocumentType("DNI");
        dtoInputListProposals.setDocumentNumber("00000001");
        dtoInputListProposals.setProductClassification("CREDIT_CARD");
        dtoInputListProposals.setPaginationKey("123456789qwertyuio");
        dtoInputListProposals.setPageSize(new Long(123));
        final Map<String, String> parameters = listProposalsDAOMapper.mapInput(dtoInputListProposals);
        assertEquals(documentTypeBackendValue, parameters.get(ISrvProposalsV01.DOCUMENT_TYPE));
        assertEquals(dtoInputListProposals.getDocumentNumber(), parameters.get(ISrvProposalsV01.DOCUMENT_NUMBER));
        assertEquals(productClassificationBackendValue, parameters.get(ISrvProposalsV01.PRODUCT_CLASSIFICATION));
        assertEquals(dtoInputListProposals.getPaginationKey(), parameters.get(ISrvProposalsV01.PAGINATION_KEY));
        assertEquals(dtoInputListProposals.getPageSize().toString(), parameters.get(ISrvProposalsV01.PAGE_SIZE));
    }

}