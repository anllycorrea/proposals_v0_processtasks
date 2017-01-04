package com.bbva.pzic.proposals.dao.mapper.impl;

import com.bbva.pzic.proposals.business.dto.DTOInputListProposals;
import com.bbva.pzic.proposals.facade.v01.ISrvProposalsV01;
import com.bbva.pzic.proposals.util.PropertyReader;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ListProposalsDAOMapperTest {

    @InjectMocks
    private ListProposalsDAOMapper listProposalsDAOMapper;

    @Mock
    private PropertyReader propertyReader;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void mapQuotationIdPathParamTest() throws IOException {
        final DTOInputListProposals dtoInputListProposals = new DTOInputListProposals();
        dtoInputListProposals.setDocumentType("L");
        dtoInputListProposals.setDocumentNumber("00000001");
        dtoInputListProposals.setProductClassification("TC");
        dtoInputListProposals.setPaginationKey("123456789qwertyuio");
        dtoInputListProposals.setPageSize(123L);
        final Map<String, String> parameters = listProposalsDAOMapper.mapInput(dtoInputListProposals);
        assertEquals(dtoInputListProposals.getDocumentType(), parameters.get(ISrvProposalsV01.DOCUMENT_TYPE));
        assertEquals(dtoInputListProposals.getDocumentNumber(), parameters.get(ISrvProposalsV01.DOCUMENT_NUMBER));
        assertEquals(dtoInputListProposals.getProductClassification(), parameters.get(ISrvProposalsV01.PRODUCT_CLASSIFICATION));
        assertEquals(dtoInputListProposals.getPaginationKey(), parameters.get(ISrvProposalsV01.PAGINATION_KEY));
        assertEquals(dtoInputListProposals.getPageSize().toString(), parameters.get(ISrvProposalsV01.PAGE_SIZE));
    }

}