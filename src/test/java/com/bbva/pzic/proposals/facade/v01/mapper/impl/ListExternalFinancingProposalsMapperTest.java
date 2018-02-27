package com.bbva.pzic.proposals.facade.v01.mapper.impl;

import com.bbva.pzic.proposals.DummyMock;
import com.bbva.pzic.proposals.business.dto.DTOInputListExternalFinancingProposals;
import com.bbva.pzic.proposals.business.dto.DTOOutExternalFinancingProposalData;
import com.bbva.pzic.proposals.canonic.ExternalFinancingProposal;
import com.bbva.pzic.proposals.canonic.ExternalFinancingProposalData;
import com.bbva.pzic.proposals.facade.v0.mapper.impl.ListExternalFinancingProposalsMapper;
import com.bbva.pzic.proposals.facade.v0.mapper.IListExternalFinancingProposalsMapper;
import com.bbva.pzic.proposals.util.mappers.EnumMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.util.ArrayList;
/**
 * Created on 12/04/2017.
 *
 * @author Entelgy
 */
public class ListExternalFinancingProposalsMapperTest {
    public final static String THIRD_PARTY_PROVIDER_ID = "TDPE";
    public final static String EXTERNAL_PRODUCT_CATEGORY_TYPE_ID = "CE";
    public final static String HOLDER_IDENTITY_DOCUMENTS_DOCUMENT_NUMBER = "45635269";
    public final static String HOLDER_IDENTITY_DOCUMENTS_DOCUMENT_TYPE_ID = "DNI";
    public final static String FROM_REQUEST_DATE = "2016-02-28";
    public final static String TO_REQUEST_DATE = "2016-02-28";
    public final static String DOCUMENT_TYPE_VALUE = "L";
    public final static String PAGINATION_KEY = "abc";
    public final static Long PAGE_SIZE = 12L;

    @InjectMocks
    private IListExternalFinancingProposalsMapper proposalsMapper;
    @Mock
    private EnumMapper enumMapper;
    private DummyMock dummyMock;

    @Before
    public void setUp() {
        proposalsMapper = new ListExternalFinancingProposalsMapper();
        dummyMock = new DummyMock();
        MockitoAnnotations.initMocks(this);
    }

    public void enumMapIn() {
        Mockito.when(enumMapper.getBackendValue("documentType.id", HOLDER_IDENTITY_DOCUMENTS_DOCUMENT_TYPE_ID)).thenReturn(DOCUMENT_TYPE_VALUE);
    }

    @Test
    public void mapInFullTest() {
        enumMapIn();
        DTOInputListExternalFinancingProposals dtoIn = proposalsMapper.mapIn(THIRD_PARTY_PROVIDER_ID, EXTERNAL_PRODUCT_CATEGORY_TYPE_ID, HOLDER_IDENTITY_DOCUMENTS_DOCUMENT_TYPE_ID, HOLDER_IDENTITY_DOCUMENTS_DOCUMENT_NUMBER, FROM_REQUEST_DATE, TO_REQUEST_DATE, PAGINATION_KEY, PAGE_SIZE);
        Assert.assertNotNull(dtoIn);

        Assert.assertNotNull(dtoIn.getThirdPartyProviderId());
        Assert.assertEquals(dtoIn.getThirdPartyProviderId(), THIRD_PARTY_PROVIDER_ID);

        Assert.assertNotNull(dtoIn.getExternalproductCategoryTypeId());
        Assert.assertEquals(dtoIn.getExternalproductCategoryTypeId(), EXTERNAL_PRODUCT_CATEGORY_TYPE_ID);

        Assert.assertNotNull(dtoIn.getHolderIdentityDocumentsDocumentTypeId());
        Assert.assertEquals(dtoIn.getHolderIdentityDocumentsDocumentTypeId(), DOCUMENT_TYPE_VALUE);

        Assert.assertNotNull(dtoIn.getHolderIdentityDocumentsDocumentNumber());
        Assert.assertEquals(dtoIn.getHolderIdentityDocumentsDocumentNumber(), HOLDER_IDENTITY_DOCUMENTS_DOCUMENT_NUMBER);

        Assert.assertNotNull(dtoIn.getFromRequestDate());
        Assert.assertEquals(dtoIn.getFromRequestDate(), FROM_REQUEST_DATE);

        Assert.assertNotNull(dtoIn.getToRequestDate());
        Assert.assertEquals(dtoIn.getToRequestDate(), TO_REQUEST_DATE);

        Assert.assertNotNull(dtoIn.getPaginationKey());
        Assert.assertEquals(dtoIn.getPaginationKey(), PAGINATION_KEY);

        Assert.assertNotNull(dtoIn.getPageSize());

    }

    @Test
    public void mapInWithoutThirdPartyProviderIdTest() {
        enumMapIn();
        DTOInputListExternalFinancingProposals dtoIn = proposalsMapper.mapIn(null, EXTERNAL_PRODUCT_CATEGORY_TYPE_ID, HOLDER_IDENTITY_DOCUMENTS_DOCUMENT_TYPE_ID, HOLDER_IDENTITY_DOCUMENTS_DOCUMENT_NUMBER, FROM_REQUEST_DATE, TO_REQUEST_DATE, PAGINATION_KEY, PAGE_SIZE);
        Assert.assertNotNull(dtoIn);

        Assert.assertNull(dtoIn.getThirdPartyProviderId());

        Assert.assertNotNull(dtoIn.getExternalproductCategoryTypeId());
        Assert.assertEquals(dtoIn.getExternalproductCategoryTypeId(), EXTERNAL_PRODUCT_CATEGORY_TYPE_ID);

        Assert.assertNotNull(dtoIn.getHolderIdentityDocumentsDocumentTypeId());
        Assert.assertEquals(dtoIn.getHolderIdentityDocumentsDocumentTypeId(), DOCUMENT_TYPE_VALUE);

        Assert.assertNotNull(dtoIn.getHolderIdentityDocumentsDocumentNumber());
        Assert.assertEquals(dtoIn.getHolderIdentityDocumentsDocumentNumber(), HOLDER_IDENTITY_DOCUMENTS_DOCUMENT_NUMBER);

        Assert.assertNotNull(dtoIn.getFromRequestDate());
        Assert.assertEquals(dtoIn.getFromRequestDate(), FROM_REQUEST_DATE);

        Assert.assertNotNull(dtoIn.getToRequestDate());
        Assert.assertEquals(dtoIn.getToRequestDate(), TO_REQUEST_DATE);

        Assert.assertNotNull(dtoIn.getPaginationKey());
        Assert.assertEquals(dtoIn.getPaginationKey(), PAGINATION_KEY);

        Assert.assertNotNull(dtoIn.getPageSize());

    }

    @Test
    public void mapInWithoutExternalProductCategpryTypeIdTest() {
        enumMapIn();
        DTOInputListExternalFinancingProposals dtoIn = proposalsMapper.mapIn(THIRD_PARTY_PROVIDER_ID, null, HOLDER_IDENTITY_DOCUMENTS_DOCUMENT_TYPE_ID, HOLDER_IDENTITY_DOCUMENTS_DOCUMENT_NUMBER, FROM_REQUEST_DATE, TO_REQUEST_DATE, PAGINATION_KEY, PAGE_SIZE);
        Assert.assertNotNull(dtoIn);

        Assert.assertNotNull(dtoIn.getThirdPartyProviderId());
        Assert.assertEquals(dtoIn.getThirdPartyProviderId(), THIRD_PARTY_PROVIDER_ID);

        Assert.assertNull(dtoIn.getExternalproductCategoryTypeId());

        Assert.assertNotNull(dtoIn.getHolderIdentityDocumentsDocumentTypeId());
        Assert.assertEquals(dtoIn.getHolderIdentityDocumentsDocumentTypeId(), DOCUMENT_TYPE_VALUE);

        Assert.assertNotNull(dtoIn.getHolderIdentityDocumentsDocumentNumber());
        Assert.assertEquals(dtoIn.getHolderIdentityDocumentsDocumentNumber(), HOLDER_IDENTITY_DOCUMENTS_DOCUMENT_NUMBER);

        Assert.assertNotNull(dtoIn.getFromRequestDate());
        Assert.assertEquals(dtoIn.getFromRequestDate(), FROM_REQUEST_DATE);

        Assert.assertNotNull(dtoIn.getToRequestDate());
        Assert.assertEquals(dtoIn.getToRequestDate(), TO_REQUEST_DATE);

        Assert.assertNotNull(dtoIn.getPaginationKey());
        Assert.assertEquals(dtoIn.getPaginationKey(), PAGINATION_KEY);

        Assert.assertNotNull(dtoIn.getPageSize());

    }

    @Test
    public void mapInWithoutHolderIdentityDocumentsDocumentTypeIdTest() {
        DTOInputListExternalFinancingProposals dtoIn = proposalsMapper.mapIn(THIRD_PARTY_PROVIDER_ID, EXTERNAL_PRODUCT_CATEGORY_TYPE_ID, null, HOLDER_IDENTITY_DOCUMENTS_DOCUMENT_NUMBER, FROM_REQUEST_DATE, TO_REQUEST_DATE, PAGINATION_KEY, PAGE_SIZE);
        Assert.assertNotNull(dtoIn);

        Assert.assertNotNull(dtoIn.getThirdPartyProviderId());
        Assert.assertEquals(dtoIn.getThirdPartyProviderId(), THIRD_PARTY_PROVIDER_ID);

        Assert.assertNotNull(dtoIn.getExternalproductCategoryTypeId());
        Assert.assertEquals(dtoIn.getExternalproductCategoryTypeId(), EXTERNAL_PRODUCT_CATEGORY_TYPE_ID);

        Assert.assertNull(dtoIn.getHolderIdentityDocumentsDocumentTypeId());

        Assert.assertNotNull(dtoIn.getHolderIdentityDocumentsDocumentNumber());
        Assert.assertEquals(dtoIn.getHolderIdentityDocumentsDocumentNumber(), HOLDER_IDENTITY_DOCUMENTS_DOCUMENT_NUMBER);

        Assert.assertNotNull(dtoIn.getFromRequestDate());
        Assert.assertEquals(dtoIn.getFromRequestDate(), FROM_REQUEST_DATE);

        Assert.assertNotNull(dtoIn.getToRequestDate());
        Assert.assertEquals(dtoIn.getToRequestDate(), TO_REQUEST_DATE);

        Assert.assertNotNull(dtoIn.getPaginationKey());
        Assert.assertEquals(dtoIn.getPaginationKey(), PAGINATION_KEY);

        Assert.assertNotNull(dtoIn.getPageSize());

    }

    @Test
    public void mapInWithoutHolderIdentityDocumentsDocumentNumberTest() {
        enumMapIn();
        DTOInputListExternalFinancingProposals dtoIn = proposalsMapper.mapIn(THIRD_PARTY_PROVIDER_ID, EXTERNAL_PRODUCT_CATEGORY_TYPE_ID, HOLDER_IDENTITY_DOCUMENTS_DOCUMENT_TYPE_ID, null, FROM_REQUEST_DATE, TO_REQUEST_DATE, PAGINATION_KEY, PAGE_SIZE);
        Assert.assertNotNull(dtoIn);

        Assert.assertNotNull(dtoIn.getThirdPartyProviderId());
        Assert.assertEquals(dtoIn.getThirdPartyProviderId(), THIRD_PARTY_PROVIDER_ID);

        Assert.assertNotNull(dtoIn.getExternalproductCategoryTypeId());
        Assert.assertEquals(dtoIn.getExternalproductCategoryTypeId(), EXTERNAL_PRODUCT_CATEGORY_TYPE_ID);

        Assert.assertNotNull(dtoIn.getHolderIdentityDocumentsDocumentTypeId());
        Assert.assertEquals(dtoIn.getHolderIdentityDocumentsDocumentTypeId(), DOCUMENT_TYPE_VALUE);

        Assert.assertNull(dtoIn.getHolderIdentityDocumentsDocumentNumber());


        Assert.assertNotNull(dtoIn.getFromRequestDate());
        Assert.assertEquals(dtoIn.getFromRequestDate(), FROM_REQUEST_DATE);

        Assert.assertNotNull(dtoIn.getToRequestDate());
        Assert.assertEquals(dtoIn.getToRequestDate(), TO_REQUEST_DATE);

        Assert.assertNotNull(dtoIn.getPaginationKey());
        Assert.assertEquals(dtoIn.getPaginationKey(), PAGINATION_KEY);

        Assert.assertNotNull(dtoIn.getPageSize());

    }

    @Test
    public void mapInWithoutFromRequestDateTest() {
        enumMapIn();
        DTOInputListExternalFinancingProposals dtoIn = proposalsMapper.mapIn(THIRD_PARTY_PROVIDER_ID, EXTERNAL_PRODUCT_CATEGORY_TYPE_ID, HOLDER_IDENTITY_DOCUMENTS_DOCUMENT_TYPE_ID, HOLDER_IDENTITY_DOCUMENTS_DOCUMENT_NUMBER, null, TO_REQUEST_DATE, PAGINATION_KEY, PAGE_SIZE);
        Assert.assertNotNull(dtoIn);

        Assert.assertNotNull(dtoIn.getThirdPartyProviderId());
        Assert.assertEquals(dtoIn.getThirdPartyProviderId(), THIRD_PARTY_PROVIDER_ID);

        Assert.assertNotNull(dtoIn.getExternalproductCategoryTypeId());
        Assert.assertEquals(dtoIn.getExternalproductCategoryTypeId(), EXTERNAL_PRODUCT_CATEGORY_TYPE_ID);

        Assert.assertNotNull(dtoIn.getHolderIdentityDocumentsDocumentTypeId());
        Assert.assertEquals(dtoIn.getHolderIdentityDocumentsDocumentTypeId(), DOCUMENT_TYPE_VALUE);

        Assert.assertNotNull(dtoIn.getHolderIdentityDocumentsDocumentNumber());
        Assert.assertEquals(dtoIn.getHolderIdentityDocumentsDocumentNumber(), HOLDER_IDENTITY_DOCUMENTS_DOCUMENT_NUMBER);

        Assert.assertNull(dtoIn.getFromRequestDate());

        Assert.assertNotNull(dtoIn.getToRequestDate());
        Assert.assertEquals(dtoIn.getToRequestDate(), TO_REQUEST_DATE);

        Assert.assertNotNull(dtoIn.getPaginationKey());
        Assert.assertEquals(dtoIn.getPaginationKey(), PAGINATION_KEY);

        Assert.assertNotNull(dtoIn.getPageSize());

    }

    @Test
    public void mapInWithoutToRequestDateTest() {
        enumMapIn();
        DTOInputListExternalFinancingProposals dtoIn = proposalsMapper.mapIn(THIRD_PARTY_PROVIDER_ID, EXTERNAL_PRODUCT_CATEGORY_TYPE_ID, HOLDER_IDENTITY_DOCUMENTS_DOCUMENT_TYPE_ID, HOLDER_IDENTITY_DOCUMENTS_DOCUMENT_NUMBER, FROM_REQUEST_DATE, null, PAGINATION_KEY, PAGE_SIZE);
        Assert.assertNotNull(dtoIn);

        Assert.assertNotNull(dtoIn.getThirdPartyProviderId());
        Assert.assertEquals(dtoIn.getThirdPartyProviderId(), THIRD_PARTY_PROVIDER_ID);

        Assert.assertNotNull(dtoIn.getExternalproductCategoryTypeId());
        Assert.assertEquals(dtoIn.getExternalproductCategoryTypeId(), EXTERNAL_PRODUCT_CATEGORY_TYPE_ID);

        Assert.assertNotNull(dtoIn.getHolderIdentityDocumentsDocumentTypeId());
        Assert.assertEquals(dtoIn.getHolderIdentityDocumentsDocumentTypeId(), DOCUMENT_TYPE_VALUE);

        Assert.assertNotNull(dtoIn.getHolderIdentityDocumentsDocumentNumber());
        Assert.assertEquals(dtoIn.getHolderIdentityDocumentsDocumentNumber(), HOLDER_IDENTITY_DOCUMENTS_DOCUMENT_NUMBER);

        Assert.assertNotNull(dtoIn.getFromRequestDate());
        Assert.assertEquals(dtoIn.getFromRequestDate(), FROM_REQUEST_DATE);

        Assert.assertNull(dtoIn.getToRequestDate());

        Assert.assertNotNull(dtoIn.getPaginationKey());
        Assert.assertEquals(dtoIn.getPaginationKey(), PAGINATION_KEY);

        Assert.assertNotNull(dtoIn.getPageSize());

    }

    @Test
    public void mapInWithoutPaginationKeyTest() {
        enumMapIn();
        DTOInputListExternalFinancingProposals dtoIn = proposalsMapper.mapIn(THIRD_PARTY_PROVIDER_ID, EXTERNAL_PRODUCT_CATEGORY_TYPE_ID, HOLDER_IDENTITY_DOCUMENTS_DOCUMENT_TYPE_ID, HOLDER_IDENTITY_DOCUMENTS_DOCUMENT_NUMBER, FROM_REQUEST_DATE, TO_REQUEST_DATE, null, PAGE_SIZE);
        Assert.assertNotNull(dtoIn);

        Assert.assertNotNull(dtoIn.getThirdPartyProviderId());
        Assert.assertEquals(dtoIn.getThirdPartyProviderId(), THIRD_PARTY_PROVIDER_ID);

        Assert.assertNotNull(dtoIn.getExternalproductCategoryTypeId());
        Assert.assertEquals(dtoIn.getExternalproductCategoryTypeId(), EXTERNAL_PRODUCT_CATEGORY_TYPE_ID);

        Assert.assertNotNull(dtoIn.getHolderIdentityDocumentsDocumentTypeId());
        Assert.assertEquals(dtoIn.getHolderIdentityDocumentsDocumentTypeId(), DOCUMENT_TYPE_VALUE);

        Assert.assertNotNull(dtoIn.getHolderIdentityDocumentsDocumentNumber());
        Assert.assertEquals(dtoIn.getHolderIdentityDocumentsDocumentNumber(), HOLDER_IDENTITY_DOCUMENTS_DOCUMENT_NUMBER);

        Assert.assertNotNull(dtoIn.getFromRequestDate());
        Assert.assertEquals(dtoIn.getFromRequestDate(), FROM_REQUEST_DATE);

        Assert.assertNotNull(dtoIn.getToRequestDate());
        Assert.assertEquals(dtoIn.getToRequestDate(), TO_REQUEST_DATE);

        Assert.assertNull(dtoIn.getPaginationKey());

        Assert.assertNotNull(dtoIn.getPageSize());

    }

    @Test
    public void mapInWithoutPageSizeTest() {
        enumMapIn();
        DTOInputListExternalFinancingProposals dtoIn = proposalsMapper.mapIn(THIRD_PARTY_PROVIDER_ID, EXTERNAL_PRODUCT_CATEGORY_TYPE_ID, HOLDER_IDENTITY_DOCUMENTS_DOCUMENT_TYPE_ID, HOLDER_IDENTITY_DOCUMENTS_DOCUMENT_NUMBER, FROM_REQUEST_DATE, TO_REQUEST_DATE, PAGINATION_KEY, null);
        Assert.assertNotNull(dtoIn);

        Assert.assertNotNull(dtoIn.getThirdPartyProviderId());
        Assert.assertEquals(dtoIn.getThirdPartyProviderId(), THIRD_PARTY_PROVIDER_ID);

        Assert.assertNotNull(dtoIn.getExternalproductCategoryTypeId());
        Assert.assertEquals(dtoIn.getExternalproductCategoryTypeId(), EXTERNAL_PRODUCT_CATEGORY_TYPE_ID);

        Assert.assertNotNull(dtoIn.getHolderIdentityDocumentsDocumentTypeId());
        Assert.assertEquals(dtoIn.getHolderIdentityDocumentsDocumentTypeId(), DOCUMENT_TYPE_VALUE);

        Assert.assertNotNull(dtoIn.getHolderIdentityDocumentsDocumentNumber());
        Assert.assertEquals(dtoIn.getHolderIdentityDocumentsDocumentNumber(), HOLDER_IDENTITY_DOCUMENTS_DOCUMENT_NUMBER);

        Assert.assertNotNull(dtoIn.getFromRequestDate());
        Assert.assertEquals(dtoIn.getFromRequestDate(), FROM_REQUEST_DATE);

        Assert.assertNotNull(dtoIn.getToRequestDate());
        Assert.assertEquals(dtoIn.getToRequestDate(), TO_REQUEST_DATE);

        Assert.assertNotNull(dtoIn.getPaginationKey());
        Assert.assertEquals(dtoIn.getPaginationKey(), PAGINATION_KEY);

        Assert.assertNull(dtoIn.getPageSize());

    }

    @Test
    public void mapOutFullTest() throws IOException {
        DTOOutExternalFinancingProposalData dtoOut = dummyMock.getDtoOutExternalFinancingProposalData();
        ExternalFinancingProposalData result = proposalsMapper.mapOut(dtoOut);
        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getData());
    }

    @Test
    public void mapOutListDataNullTest() throws IOException {
        DTOOutExternalFinancingProposalData dtoOut = new DTOOutExternalFinancingProposalData();
        ExternalFinancingProposalData result = proposalsMapper.mapOut(dtoOut);
        Assert.assertNull(result);
    }

    @Test
    public void mapOutListDataEmptyTest() throws IOException {
        DTOOutExternalFinancingProposalData dtoOut = new DTOOutExternalFinancingProposalData();
        dtoOut.setData(new ArrayList<ExternalFinancingProposal>());
        ExternalFinancingProposalData result = proposalsMapper.mapOut(dtoOut);
        Assert.assertNull(result);
    }
}