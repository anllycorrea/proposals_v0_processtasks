package com.bbva.pzic.proposals.facade.v01.impl;

import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.jee.arq.spring.core.servicing.test.BusinessServiceTestContextLoader;
import com.bbva.jee.arq.spring.core.servicing.test.MockInvocationContextTestExecutionListener;
import com.bbva.pzic.proposals.canonic.ProposalData;
import com.bbva.pzic.proposals.util.Errors;
import com.bbva.pzic.utilTest.BusinessServiceExceptionMatcher;
import com.bbva.pzic.utilTest.UriInfoImpl;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import javax.ws.rs.core.Response;

import static com.bbva.pzic.proposals.dao.mock.ListProposalsDAOMock.*;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = BusinessServiceTestContextLoader.class, locations = {"classpath*:/META-INF/spring/applicationContext-*.xml", "classpath:/META-INF/spring/business-service-test.xml"})
@TestExecutionListeners(listeners = {MockInvocationContextTestExecutionListener.class, DependencyInjectionTestExecutionListener.class})
public class SrvListProposalsV01IntegrationTest {

    private static final String DOCUMENT_TYPE = "DNI";
    private static final String PRODUCT_CLASSIFICATION = "CREDIT_CARD";
    private static final String PAGINATION_KEY = "123456789qwertyuio";
    private static final Long PAGE_SIZE = 123L;
    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    @Autowired
    private SrvProposalsV01 srvProposalsV01;

    @Before
    public void setUp() {
        srvProposalsV01.setUriInfo(new UriInfoImpl());
    }

    @Test
    public void testListProposalsThatReturnsPartialList() {
        final Response response =
                srvProposalsV01.listProposals(CUSTOMER_ID_FOR_PARTIAL_LIST, DOCUMENT_TYPE, DOCUMENT_NUMBER_FOR_PARTIAL_LIST, PRODUCT_CLASSIFICATION, PAGINATION_KEY, PAGE_SIZE);
        assertEquals(206, response.getStatus());
        final ProposalData proposalData = (ProposalData) response.getEntity();
        assertNotNull(proposalData);
        assertNotNull(proposalData.getData());
        assertNotNull(proposalData.getPagination());
        assertNotSame(0, proposalData.getData().size());
    }

    @Test
    public void testListProposalsThatReturnsPartialListWithoutDocumentTypeIdAndDocumentNumber() {
        final Response response =
                srvProposalsV01.listProposals(CUSTOMER_ID_FOR_PARTIAL_LIST, null, null, PRODUCT_CLASSIFICATION, PAGINATION_KEY, PAGE_SIZE);
        assertEquals(206, response.getStatus());
        final ProposalData proposalData = (ProposalData) response.getEntity();
        assertNotNull(proposalData);
        assertNotNull(proposalData.getData());
        assertNotNull(proposalData.getPagination());
        assertNotSame(0, proposalData.getData().size());
    }

    @Test
    public void testListProposalsThatReturnsPartialListWithoutCustomerId() {
        final Response response =
                srvProposalsV01.listProposals(null, DOCUMENT_TYPE, DOCUMENT_NUMBER_FOR_PARTIAL_LIST, PRODUCT_CLASSIFICATION, PAGINATION_KEY, PAGE_SIZE);
        assertEquals(206, response.getStatus());
        final ProposalData proposalData = (ProposalData) response.getEntity();
        assertNotNull(proposalData);
        assertNotNull(proposalData.getData());
        assertNotNull(proposalData.getPagination());
        assertNotSame(0, proposalData.getData().size());
    }

    @Test
    public void testListProposalsThatReturnsPartialListWithoutDocumentTypeId() {
        final Response response =
                srvProposalsV01.listProposals(CUSTOMER_ID_FOR_PARTIAL_LIST, null, DOCUMENT_NUMBER_FOR_PARTIAL_LIST, PRODUCT_CLASSIFICATION, PAGINATION_KEY, PAGE_SIZE);
        assertEquals(206, response.getStatus());
        final ProposalData proposalData = (ProposalData) response.getEntity();
        assertNotNull(proposalData);
        assertNotNull(proposalData.getData());
        assertNotNull(proposalData.getPagination());
        assertNotSame(0, proposalData.getData().size());
    }

    @Test
    public void testListProposalsThatReturnsPartialListWithoutDocumentNumber() {
        final Response response =
                srvProposalsV01.listProposals(CUSTOMER_ID_FOR_PARTIAL_LIST, DOCUMENT_TYPE, null, PRODUCT_CLASSIFICATION, PAGINATION_KEY, PAGE_SIZE);
        assertEquals(206, response.getStatus());
        final ProposalData proposalData = (ProposalData) response.getEntity();
        assertNotNull(proposalData);
        assertNotNull(proposalData.getData());
        assertNotNull(proposalData.getPagination());
        assertNotSame(0, proposalData.getData().size());
    }

    @Test
    public void testListProposalsThatReturnsCompleteList() {
        final String customerId = "2";
        final Response response =
                srvProposalsV01.listProposals(customerId, DOCUMENT_TYPE, DOCUMENT_NUMBER_FOR_COMPLETE_LIST, PRODUCT_CLASSIFICATION, PAGINATION_KEY, PAGE_SIZE);
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        final ProposalData proposalData = (ProposalData) response.getEntity();
        assertNotNull(proposalData);
        assertNotNull(proposalData.getData());
        assertNull(proposalData.getPagination());
        assertNotSame(0, proposalData.getData().size());
    }

    @Test
    public void testListProposalsThatReturnsEmptyList() {
        final String customerId = "3";
        final String documentNumber = "00000003";
        final Response response =
                srvProposalsV01.listProposals(customerId, DOCUMENT_TYPE, documentNumber, PRODUCT_CLASSIFICATION, PAGINATION_KEY, PAGE_SIZE);
        assertEquals(Response.Status.NO_CONTENT.getStatusCode(), response.getStatus());
    }

    @Test
    public void testListProposalsWithInvalidDocumentType() {
        expectedException.expect(BusinessServiceException.class);
        expectedException.expect(BusinessServiceExceptionMatcher.hasErrorCode(Errors.WRONG_PARAMETERS));

        final String documentType = "LIBRETA_ELECTORAL";
        srvProposalsV01.listProposals(CUSTOMER_ID_FOR_PARTIAL_LIST, documentType, DOCUMENT_NUMBER_FOR_PARTIAL_LIST, PRODUCT_CLASSIFICATION, PAGINATION_KEY, PAGE_SIZE);

    }

    @Test
    public void testListProposalsWithDocumentNumberLengthGreaterThanEight() {
        expectedException.expect(BusinessServiceException.class);
        expectedException.expect(BusinessServiceExceptionMatcher.hasErrorCode(Errors.WRONG_PARAMETERS));

        final String documentNumber = "000000012345";
        srvProposalsV01.listProposals(CUSTOMER_ID_FOR_PARTIAL_LIST, DOCUMENT_TYPE, documentNumber, PRODUCT_CLASSIFICATION, PAGINATION_KEY, PAGE_SIZE);

    }

    @Test
    public void testListProposalsWithInvalidProductClassification() {
        expectedException.expect(BusinessServiceException.class);
        expectedException.expect(BusinessServiceExceptionMatcher.hasErrorCode(Errors.WRONG_PARAMETERS));

        final String productClassification = "ROCK_CARD";
        srvProposalsV01.listProposals(CUSTOMER_ID_FOR_PARTIAL_LIST, DOCUMENT_TYPE, DOCUMENT_NUMBER_FOR_PARTIAL_LIST, productClassification, PAGINATION_KEY, PAGE_SIZE);

    }

    @Test
    public void testListProposalsWithPaginationKeyLengthGreaterThanEight() {
        expectedException.expect(BusinessServiceException.class);
        expectedException.expect(BusinessServiceExceptionMatcher.hasErrorCode(Errors.WRONG_PARAMETERS));

        final String paginationKey = "123456789qwertyuiop";
        srvProposalsV01.listProposals(CUSTOMER_ID_FOR_PARTIAL_LIST, DOCUMENT_TYPE, DOCUMENT_NUMBER_FOR_PARTIAL_LIST, PRODUCT_CLASSIFICATION, paginationKey, PAGE_SIZE);

    }

    @Test
    public void testListProposalsWithPageSizeLengthGreaterThanEight() {
        expectedException.expect(BusinessServiceException.class);
        expectedException.expect(BusinessServiceExceptionMatcher.hasErrorCode(Errors.WRONG_PARAMETERS));

        srvProposalsV01.listProposals(CUSTOMER_ID_FOR_PARTIAL_LIST, DOCUMENT_TYPE, DOCUMENT_NUMBER_FOR_PARTIAL_LIST, PRODUCT_CLASSIFICATION, PAGINATION_KEY, 1234L);
    }

    @Test
    public void testListProposalsWithoutCustomerIdAndDocumentTypeIdAndDocumentNumber() {
        expectedException.expect(BusinessServiceException.class);
        expectedException.expect(BusinessServiceExceptionMatcher.hasErrorCode(Errors.PARAMETERS_MISSING));
        srvProposalsV01.listProposals(null, null, null, PRODUCT_CLASSIFICATION, PAGINATION_KEY, PAGE_SIZE);

    }

    @Test
    public void testListProposalsWithoutCustomerIdAndDocumentTypeId() {
        expectedException.expect(BusinessServiceException.class);
        expectedException.expect(BusinessServiceExceptionMatcher.hasErrorCode(Errors.PARAMETERS_MISSING));

        srvProposalsV01.listProposals(null, null, DOCUMENT_NUMBER_FOR_PARTIAL_LIST, PRODUCT_CLASSIFICATION, PAGINATION_KEY, PAGE_SIZE);

    }

    @Test
    public void testListProposalsWithoutCustomerIdAndDocumentNumber() {
        expectedException.expect(BusinessServiceException.class);
        expectedException.expect(BusinessServiceExceptionMatcher.hasErrorCode(Errors.PARAMETERS_MISSING));

        srvProposalsV01.listProposals(null, DOCUMENT_TYPE, null, PRODUCT_CLASSIFICATION, PAGINATION_KEY, PAGE_SIZE);
    }

}