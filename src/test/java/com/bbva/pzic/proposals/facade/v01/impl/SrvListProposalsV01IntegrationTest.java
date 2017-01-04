package com.bbva.pzic.proposals.facade.v01.impl;

import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.jee.arq.spring.core.servicing.test.BusinessServiceTestContextLoader;
import com.bbva.jee.arq.spring.core.servicing.test.MockInvocationContextTestExecutionListener;
import com.bbva.pzic.proposals.canonic.ProposalData;
import com.bbva.pzic.proposals.util.Errors;
import com.bbva.pzic.utilTest.UriInfoImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import javax.ws.rs.core.Response;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = BusinessServiceTestContextLoader.class, locations = {"classpath*:/META-INF/spring/applicationContext-*.xml", "classpath:/META-INF/spring/business-service-test.xml"})
@TestExecutionListeners(listeners = {MockInvocationContextTestExecutionListener.class, DependencyInjectionTestExecutionListener.class})
public class SrvListProposalsV01IntegrationTest {

    private static final String DOCUMENT_TYPE = "DNI";
    private static final String DOCUMENT_NUMBER = "00000001";
    private static final String PRODUCT_CLASSIFICATION = "CREDIT_CARD";
    private static final String PAGINATION_KEY = "123456789qwertyuio";
    private static final Long PAGE_SIZE = 123L;

    @Autowired
    private SrvProposalsV01 srvProposalsV01;

    @Before
    public void setUp() {
        srvProposalsV01.setUriInfo(new UriInfoImpl());
    }

    @Test
    public void testListProposalsThatReturnsPartialList() {
        final Response response =
                srvProposalsV01.listProposals(DOCUMENT_TYPE, DOCUMENT_NUMBER, PRODUCT_CLASSIFICATION, PAGINATION_KEY, PAGE_SIZE);
        assertEquals(206, response.getStatus());
        final ProposalData proposalData = (ProposalData) response.getEntity();
        assertNotNull(proposalData);
        assertNotNull(proposalData.getData());
        assertNotNull(proposalData.getPagination());
        assertNotSame(0, proposalData.getData().size());
    }

    @Test
    public void testListProposalsThatReturnsCompleteList() {
        final String documentNumber = "00000002";
        final Response response =
                srvProposalsV01.listProposals(DOCUMENT_TYPE, documentNumber, PRODUCT_CLASSIFICATION, PAGINATION_KEY, PAGE_SIZE);
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        final ProposalData proposalData = (ProposalData) response.getEntity();
        assertNotNull(proposalData);
        assertNotNull(proposalData.getData());
        assertNull(proposalData.getPagination());
        assertNotSame(0, proposalData.getData().size());
    }

    @Test
    public void testListProposalsThatReturnsEmptyList() {
        final String documentNumber = "00000003";
        final Response response =
                srvProposalsV01.listProposals(DOCUMENT_TYPE, documentNumber, PRODUCT_CLASSIFICATION, PAGINATION_KEY, PAGE_SIZE);
        assertEquals(Response.Status.NO_CONTENT.getStatusCode(), response.getStatus());
    }

    @Test
    public void testListProposalsWithoutDocumentType() {
        try {
            srvProposalsV01.listProposals(null, DOCUMENT_NUMBER, PRODUCT_CLASSIFICATION, PAGINATION_KEY, PAGE_SIZE);
            fail("Expected MANDATORY_PARAMETERS_MISSING exception");
        } catch (BusinessServiceException e) {
            assertThat(e.getErrorCode(), is(equalTo(Errors.MANDATORY_PARAMETERS_MISSING)));
        }
    }

    @Test
    public void testListProposalsWithInvalidDocumentType() {
        final String documentType = "LIBRETA_ELECTORAL";
        try {
            srvProposalsV01.listProposals(documentType, DOCUMENT_NUMBER, PRODUCT_CLASSIFICATION, PAGINATION_KEY, PAGE_SIZE);
            fail("Expected WRONG_PARAMETERS exception");
        } catch (BusinessServiceException e) {
            assertThat(e.getErrorCode(), is(equalTo(Errors.WRONG_PARAMETERS)));
        }
    }

    @Test
    public void testListProposalsWithoutDocumentNumber() {
        try {
            srvProposalsV01.listProposals(DOCUMENT_TYPE, null, PRODUCT_CLASSIFICATION, PAGINATION_KEY, PAGE_SIZE);
            fail("Expected MANDATORY_PARAMETERS_MISSING exception");
        } catch (BusinessServiceException e) {
            assertThat(e.getErrorCode(), is(equalTo(Errors.MANDATORY_PARAMETERS_MISSING)));
        }
    }

    @Test
    public void testListProposalsWithDocumentNumberLengthGreaterThanEight() {
        final String documentNumber = "000000012345";
        try {
            srvProposalsV01.listProposals(DOCUMENT_TYPE, documentNumber, PRODUCT_CLASSIFICATION, PAGINATION_KEY, PAGE_SIZE);
            fail("Expected WRONG_PARAMETERS exception");
        } catch (BusinessServiceException e) {
            assertThat(e.getErrorCode(), is(equalTo(Errors.WRONG_PARAMETERS)));
        }
    }

    @Test
    public void testListProposalsWithInvalidProductClassification() {
        final String productClassification = "ROCK_CARD";
        try {
            srvProposalsV01.listProposals(DOCUMENT_TYPE, DOCUMENT_NUMBER, productClassification, PAGINATION_KEY, PAGE_SIZE);
            fail("Expected WRONG_PARAMETERS exception");
        } catch (BusinessServiceException e) {
            assertThat(e.getErrorCode(), is(equalTo(Errors.WRONG_PARAMETERS)));
        }
    }

    @Test
    public void testListProposalsWithPaginationKeyLengthGreaterThanEight() {
        final String paginationKey = "123456789qwertyuiop";
        try {
            srvProposalsV01.listProposals(DOCUMENT_TYPE, DOCUMENT_NUMBER, PRODUCT_CLASSIFICATION, paginationKey, PAGE_SIZE);
            fail("Expected WRONG_PARAMETERS exception");
        } catch (BusinessServiceException e) {
            assertThat(e.getErrorCode(), is(equalTo(Errors.WRONG_PARAMETERS)));
        }
    }

    @Test
    public void testListProposalsWithPageSizeLengthGreaterThanEight() {
        try {
            srvProposalsV01.listProposals(DOCUMENT_TYPE, DOCUMENT_NUMBER, PRODUCT_CLASSIFICATION, PAGINATION_KEY, 1234L);
            fail("Expected WRONG_PARAMETERS exception");
        } catch (BusinessServiceException e) {
            assertThat(e.getErrorCode(), is(equalTo(Errors.WRONG_PARAMETERS)));
        }
    }

}