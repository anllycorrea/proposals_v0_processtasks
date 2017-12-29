package com.bbva.pzic.proposals.facade.v0.mapper.impl;

import com.bbva.pzic.proposals.business.dto.InputListProposals;
import com.bbva.pzic.proposals.facade.v0.mapper.IListProposalsMapper;
import com.bbva.pzic.proposals.util.mappers.EnumMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static com.bbva.pzic.proposals.DummyMock.*;

/**
 * Created on 28/12/2017.
 *
 * @author Entelgy
 */
public class ListProposalsMapperTest {

    @InjectMocks
    private IListProposalsMapper proposalsMapper;

    @Mock
    private EnumMapper enumMapper;

    @Before
    public void init() {
        proposalsMapper = new ListProposalsMapper();
        MockitoAnnotations.initMocks(this);
        Mockito.when(enumMapper.getBackendValue("documentType.id", "DNI")).thenReturn("L");

    }

    @Test
    public void mapInFullTest() {
        InputListProposals result = proposalsMapper.mapIn(DOCUMENT_TYPE_ID, DOCUMENT_NUMBER, CUSTOMER_ID);

        Assert.assertNotNull(result);
        Assert.assertEquals(CUSTOMER_ID, result.getCustomerId());
        Assert.assertEquals("L", result.getDocumentTypeId());
        Assert.assertEquals(DOCUMENT_NUMBER, result.getDocumentNumber());
    }

}