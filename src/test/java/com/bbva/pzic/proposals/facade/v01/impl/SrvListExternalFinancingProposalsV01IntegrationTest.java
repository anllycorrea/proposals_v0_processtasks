package com.bbva.pzic.proposals.facade.v01.impl;

import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.jee.arq.spring.core.servicing.test.BusinessServiceTestContextLoader;
import com.bbva.jee.arq.spring.core.servicing.test.MockInvocationContextTestExecutionListener;
import com.bbva.pzic.proposals.canonic.ExternalFinancingProposalData;
import com.bbva.pzic.proposals.dao.model.uglp.mock.TransaccionUglpMock;
import com.bbva.pzic.proposals.facade.v01.mapper.impl.ListExternalFinancingProposalsMapperTest;
import com.bbva.pzic.proposals.util.Errors;
import com.bbva.pzic.utilTest.UriInfoImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created on 12/04/2017.
 *
 * @author Entelgy
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = BusinessServiceTestContextLoader.class, locations = {
        "classpath*:/META-INF/spring/applicationContext-*.xml",
        "classpath:/META-INF/spring/business-service-test.xml"})
@TestExecutionListeners(listeners = {
        MockInvocationContextTestExecutionListener.class,
        DependencyInjectionTestExecutionListener.class})
public class SrvListExternalFinancingProposalsV01IntegrationTest {

    @Autowired
    private SrvProposalsV01 srvProposalsV01;

    @Before
    public void setUp() {
        srvProposalsV01.setUriInfo(new UriInfoImpl());
    }

    @Test
    public void testListExternalFinancingProposals() {
        Response response = srvProposalsV01.listExternalFinancingProposals(
                ListExternalFinancingProposalsMapperTest.THIRD_PARTY_PROVIDER_ID,
                ListExternalFinancingProposalsMapperTest.HOLDER_IDENTITY_DOCUMENTS_DOCUMENT_TYPE_ID,
                ListExternalFinancingProposalsMapperTest.HOLDER_IDENTITY_DOCUMENTS_DOCUMENT_NUMBER,
                ListExternalFinancingProposalsMapperTest.FROM_REQUEST_DATE,
                ListExternalFinancingProposalsMapperTest.TO_REQUEST_DATE,
                ListExternalFinancingProposalsMapperTest.PAGINATION_KEY,
                ListExternalFinancingProposalsMapperTest.PAGE_SIZE);

        Assert.assertNotNull(response);
        Assert.assertEquals(206, response.getStatus());
        Assert.assertTrue(response.getEntity() instanceof ExternalFinancingProposalData);
    }

    @Test
    public void testListExternalFinancingProposalsTestEmpty() {
        Response response = srvProposalsV01.listExternalFinancingProposals(
                ListExternalFinancingProposalsMapperTest.THIRD_PARTY_PROVIDER_ID,
                ListExternalFinancingProposalsMapperTest.HOLDER_IDENTITY_DOCUMENTS_DOCUMENT_TYPE_ID,
                TransaccionUglpMock.TEST_EMPTY,
                ListExternalFinancingProposalsMapperTest.FROM_REQUEST_DATE,
                ListExternalFinancingProposalsMapperTest.TO_REQUEST_DATE,
                ListExternalFinancingProposalsMapperTest.PAGINATION_KEY,
                ListExternalFinancingProposalsMapperTest.PAGE_SIZE);

        Assert.assertNull(response);

    }

    @Test
    public void testListExternalFinancingProposalsTestNotPagination() {
        Response response = srvProposalsV01.listExternalFinancingProposals(
                ListExternalFinancingProposalsMapperTest.THIRD_PARTY_PROVIDER_ID,
                ListExternalFinancingProposalsMapperTest.HOLDER_IDENTITY_DOCUMENTS_DOCUMENT_TYPE_ID,
                TransaccionUglpMock.TEST_NOT_PAGINATION,
                ListExternalFinancingProposalsMapperTest.FROM_REQUEST_DATE,
                ListExternalFinancingProposalsMapperTest.TO_REQUEST_DATE,
                ListExternalFinancingProposalsMapperTest.PAGINATION_KEY,
                ListExternalFinancingProposalsMapperTest.PAGE_SIZE);

        Assert.assertNotNull(response);
        Assert.assertEquals(200, response.getStatus());
        Assert.assertTrue(response.getEntity() instanceof ExternalFinancingProposalData);
    }

    @Test
    public void testListExternalFinancingProposalsWithoutPageSize() {
        Response response = srvProposalsV01.listExternalFinancingProposals(
                ListExternalFinancingProposalsMapperTest.THIRD_PARTY_PROVIDER_ID,
                ListExternalFinancingProposalsMapperTest.HOLDER_IDENTITY_DOCUMENTS_DOCUMENT_TYPE_ID,
                ListExternalFinancingProposalsMapperTest.HOLDER_IDENTITY_DOCUMENTS_DOCUMENT_NUMBER,
                ListExternalFinancingProposalsMapperTest.FROM_REQUEST_DATE,
                ListExternalFinancingProposalsMapperTest.TO_REQUEST_DATE,
                ListExternalFinancingProposalsMapperTest.PAGINATION_KEY,
                null);

        Assert.assertNotNull(response);
        Assert.assertEquals(206, response.getStatus());
        Assert.assertTrue(response.getEntity() instanceof ExternalFinancingProposalData);
    }

    @Test
    public void testListExternalFinancingProposalsWithoutPaginationKey() {
        Response response = srvProposalsV01.listExternalFinancingProposals(
                ListExternalFinancingProposalsMapperTest.THIRD_PARTY_PROVIDER_ID,
                ListExternalFinancingProposalsMapperTest.HOLDER_IDENTITY_DOCUMENTS_DOCUMENT_TYPE_ID,
                ListExternalFinancingProposalsMapperTest.HOLDER_IDENTITY_DOCUMENTS_DOCUMENT_NUMBER,
                ListExternalFinancingProposalsMapperTest.FROM_REQUEST_DATE,
                ListExternalFinancingProposalsMapperTest.TO_REQUEST_DATE,
                null,
                ListExternalFinancingProposalsMapperTest.PAGE_SIZE);

        Assert.assertNotNull(response);
        Assert.assertEquals(206, response.getStatus());
        Assert.assertTrue(response.getEntity() instanceof ExternalFinancingProposalData);
    }

    //Validaciones de ogligatoriedad

    @Test
    public void testListExternalFinancingProposalsWithoutThirdPartyProviderId() {
        try {
            srvProposalsV01.listExternalFinancingProposals(
                    null,
                    ListExternalFinancingProposalsMapperTest.HOLDER_IDENTITY_DOCUMENTS_DOCUMENT_TYPE_ID,
                    ListExternalFinancingProposalsMapperTest.HOLDER_IDENTITY_DOCUMENTS_DOCUMENT_NUMBER,
                    ListExternalFinancingProposalsMapperTest.FROM_REQUEST_DATE,
                    ListExternalFinancingProposalsMapperTest.TO_REQUEST_DATE,
                    ListExternalFinancingProposalsMapperTest.PAGINATION_KEY,
                    ListExternalFinancingProposalsMapperTest.PAGE_SIZE);
            fail();
        } catch (final BusinessServiceException e) {
            assertEquals(Errors.MANDATORY_PARAMETERS_MISSING, e.getErrorCode());
        }
    }

    @Test
    public void testListExternalFinancingProposalsWithoutHolderIdentityDocumentsDocumentTypeId() {
        try {
            srvProposalsV01.listExternalFinancingProposals(
                    ListExternalFinancingProposalsMapperTest.THIRD_PARTY_PROVIDER_ID,
                    null,
                    ListExternalFinancingProposalsMapperTest.HOLDER_IDENTITY_DOCUMENTS_DOCUMENT_NUMBER,
                    ListExternalFinancingProposalsMapperTest.FROM_REQUEST_DATE,
                    ListExternalFinancingProposalsMapperTest.TO_REQUEST_DATE,
                    ListExternalFinancingProposalsMapperTest.PAGINATION_KEY,
                    ListExternalFinancingProposalsMapperTest.PAGE_SIZE);
        } catch (final BusinessServiceException e) {
            assertEquals(Errors.MANDATORY_PARAMETERS_MISSING, e.getErrorCode());
        }
    }

    @Test
    public void testListExternalFinancingProposalsWithoutHolderIdentityDocumentsDocumentNumber() {
        try {
            srvProposalsV01.listExternalFinancingProposals(
                    ListExternalFinancingProposalsMapperTest.THIRD_PARTY_PROVIDER_ID,
                    ListExternalFinancingProposalsMapperTest.HOLDER_IDENTITY_DOCUMENTS_DOCUMENT_TYPE_ID,
                    null,
                    ListExternalFinancingProposalsMapperTest.FROM_REQUEST_DATE,
                    ListExternalFinancingProposalsMapperTest.TO_REQUEST_DATE,
                    ListExternalFinancingProposalsMapperTest.PAGINATION_KEY,
                    ListExternalFinancingProposalsMapperTest.PAGE_SIZE);
        } catch (final BusinessServiceException e) {
            assertEquals(Errors.MANDATORY_PARAMETERS_MISSING, e.getErrorCode());
        }

    }

    @Test
    public void testListExternalFinancingProposalsWithoutFromRequestDate() {
        try {
            srvProposalsV01.listExternalFinancingProposals(
                    ListExternalFinancingProposalsMapperTest.THIRD_PARTY_PROVIDER_ID,
                    ListExternalFinancingProposalsMapperTest.HOLDER_IDENTITY_DOCUMENTS_DOCUMENT_TYPE_ID,
                    ListExternalFinancingProposalsMapperTest.HOLDER_IDENTITY_DOCUMENTS_DOCUMENT_NUMBER,
                    null,
                    ListExternalFinancingProposalsMapperTest.TO_REQUEST_DATE,
                    ListExternalFinancingProposalsMapperTest.PAGINATION_KEY,
                    ListExternalFinancingProposalsMapperTest.PAGE_SIZE);
        } catch (final BusinessServiceException e) {
            assertEquals(Errors.MANDATORY_PARAMETERS_MISSING, e.getErrorCode());
        }
    }

    @Test
    public void testListExternalFinancingProposalsWithoutToRequestDate() {
        try {
            srvProposalsV01.listExternalFinancingProposals(
                    ListExternalFinancingProposalsMapperTest.THIRD_PARTY_PROVIDER_ID,
                    ListExternalFinancingProposalsMapperTest.HOLDER_IDENTITY_DOCUMENTS_DOCUMENT_TYPE_ID,
                    ListExternalFinancingProposalsMapperTest.HOLDER_IDENTITY_DOCUMENTS_DOCUMENT_NUMBER,
                    ListExternalFinancingProposalsMapperTest.FROM_REQUEST_DATE,
                    null,
                    ListExternalFinancingProposalsMapperTest.PAGINATION_KEY,
                    ListExternalFinancingProposalsMapperTest.PAGE_SIZE);
        } catch (final BusinessServiceException e) {
            assertEquals(Errors.MANDATORY_PARAMETERS_MISSING, e.getErrorCode());
        }
    }

    //Validaciones de longitud
    @Test
    public void testListExternalFinancingProposalsInvalidSizeThirdPartyProviderId() {
        try {
            srvProposalsV01.listExternalFinancingProposals(
                    "13245",
                    ListExternalFinancingProposalsMapperTest.HOLDER_IDENTITY_DOCUMENTS_DOCUMENT_TYPE_ID,
                    ListExternalFinancingProposalsMapperTest.HOLDER_IDENTITY_DOCUMENTS_DOCUMENT_NUMBER,
                    ListExternalFinancingProposalsMapperTest.FROM_REQUEST_DATE,
                    ListExternalFinancingProposalsMapperTest.TO_REQUEST_DATE,
                    ListExternalFinancingProposalsMapperTest.PAGINATION_KEY,
                    ListExternalFinancingProposalsMapperTest.PAGE_SIZE);
            fail();
        } catch (final BusinessServiceException e) {
            assertEquals(Errors.WRONG_PARAMETERS, e.getErrorCode());
        }
    }

    @Test
    public void testListExternalFinancingProposalsInvalidSizeHolderIdentityDocumentsDocumentTypeId() {
        try {
            srvProposalsV01.listExternalFinancingProposals(
                    ListExternalFinancingProposalsMapperTest.THIRD_PARTY_PROVIDER_ID,
                    "RG",
                    ListExternalFinancingProposalsMapperTest.HOLDER_IDENTITY_DOCUMENTS_DOCUMENT_NUMBER,
                    ListExternalFinancingProposalsMapperTest.FROM_REQUEST_DATE,
                    ListExternalFinancingProposalsMapperTest.TO_REQUEST_DATE,
                    ListExternalFinancingProposalsMapperTest.PAGINATION_KEY,
                    ListExternalFinancingProposalsMapperTest.PAGE_SIZE);
        } catch (final BusinessServiceException e) {
            assertEquals(Errors.WRONG_PARAMETERS, e.getErrorCode());
        }
    }

    @Test
    public void testListExternalFinancingProposalsInvalidSizeHolderIdentityDocumentsDocumentNumber() {
        try {
            srvProposalsV01.listExternalFinancingProposals(
                    ListExternalFinancingProposalsMapperTest.THIRD_PARTY_PROVIDER_ID,
                    ListExternalFinancingProposalsMapperTest.HOLDER_IDENTITY_DOCUMENTS_DOCUMENT_TYPE_ID,
                    "12345678901",
                    ListExternalFinancingProposalsMapperTest.FROM_REQUEST_DATE,
                    ListExternalFinancingProposalsMapperTest.TO_REQUEST_DATE,
                    ListExternalFinancingProposalsMapperTest.PAGINATION_KEY,
                    ListExternalFinancingProposalsMapperTest.PAGE_SIZE);
        } catch (final BusinessServiceException e) {
            assertEquals(Errors.WRONG_PARAMETERS, e.getErrorCode());
        }

    }

    @Test
    public void testListExternalFinancingProposalsInvalidSizeFromRequestDate() {
        try {
            srvProposalsV01.listExternalFinancingProposals(
                    ListExternalFinancingProposalsMapperTest.THIRD_PARTY_PROVIDER_ID,
                    ListExternalFinancingProposalsMapperTest.HOLDER_IDENTITY_DOCUMENTS_DOCUMENT_TYPE_ID,
                    ListExternalFinancingProposalsMapperTest.HOLDER_IDENTITY_DOCUMENTS_DOCUMENT_NUMBER,
                    "2017-234-04",
                    ListExternalFinancingProposalsMapperTest.TO_REQUEST_DATE,
                    ListExternalFinancingProposalsMapperTest.PAGINATION_KEY,
                    ListExternalFinancingProposalsMapperTest.PAGE_SIZE);
        } catch (final BusinessServiceException e) {
            assertEquals(Errors.WRONG_PARAMETERS, e.getErrorCode());
        }
    }

    @Test
    public void testListExternalFinancingProposalsInvalidSizeRequestDate() {
        try {
            srvProposalsV01.listExternalFinancingProposals(
                    ListExternalFinancingProposalsMapperTest.THIRD_PARTY_PROVIDER_ID,
                    ListExternalFinancingProposalsMapperTest.HOLDER_IDENTITY_DOCUMENTS_DOCUMENT_TYPE_ID,
                    ListExternalFinancingProposalsMapperTest.HOLDER_IDENTITY_DOCUMENTS_DOCUMENT_NUMBER,
                    ListExternalFinancingProposalsMapperTest.FROM_REQUEST_DATE,
                    "2017-05-123",
                    ListExternalFinancingProposalsMapperTest.PAGINATION_KEY,
                    ListExternalFinancingProposalsMapperTest.PAGE_SIZE);
        } catch (final BusinessServiceException e) {
            assertEquals(Errors.WRONG_PARAMETERS, e.getErrorCode());
        }
    }

    @Test
    public void testListExternalFinancingProposalsInvalidSizePageSize() {
        try {
            srvProposalsV01.listExternalFinancingProposals(
                    ListExternalFinancingProposalsMapperTest.THIRD_PARTY_PROVIDER_ID,
                    ListExternalFinancingProposalsMapperTest.HOLDER_IDENTITY_DOCUMENTS_DOCUMENT_TYPE_ID,
                    ListExternalFinancingProposalsMapperTest.HOLDER_IDENTITY_DOCUMENTS_DOCUMENT_NUMBER,
                    ListExternalFinancingProposalsMapperTest.FROM_REQUEST_DATE,
                    ListExternalFinancingProposalsMapperTest.TO_REQUEST_DATE,
                    ListExternalFinancingProposalsMapperTest.PAGINATION_KEY,
                    123L);
        } catch (final BusinessServiceException e) {
            assertEquals(Errors.WRONG_PARAMETERS, e.getErrorCode());
        }
    }

    @Test
    public void testListExternalFinancingProposalsInvalidSizePaginationKey() {
        try {
            srvProposalsV01.listExternalFinancingProposals(
                    ListExternalFinancingProposalsMapperTest.THIRD_PARTY_PROVIDER_ID,
                    ListExternalFinancingProposalsMapperTest.HOLDER_IDENTITY_DOCUMENTS_DOCUMENT_TYPE_ID,
                    ListExternalFinancingProposalsMapperTest.HOLDER_IDENTITY_DOCUMENTS_DOCUMENT_NUMBER,
                    ListExternalFinancingProposalsMapperTest.FROM_REQUEST_DATE,
                    ListExternalFinancingProposalsMapperTest.TO_REQUEST_DATE,
                    "1234567890123456789",
                    ListExternalFinancingProposalsMapperTest.PAGE_SIZE);

        } catch (final BusinessServiceException e) {
            assertEquals(Errors.WRONG_PARAMETERS, e.getErrorCode());
        }
    }

}