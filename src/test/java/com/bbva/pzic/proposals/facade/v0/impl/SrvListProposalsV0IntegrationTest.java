package com.bbva.pzic.proposals.facade.v0.impl;

import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.jee.arq.spring.core.servicing.test.BusinessServiceTestContextLoader;
import com.bbva.jee.arq.spring.core.servicing.test.MockInvocationContextTestExecutionListener;
import com.bbva.pzic.proposals.canonic.Proposals;
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

import static com.bbva.pzic.proposals.DummyMock.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created on 29/12/2017.
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
public class SrvListProposalsV0IntegrationTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    @Autowired
    private SrvProposalsV0 srvProposalsV0;

    @Before
    public void setUp() {
        srvProposalsV0.setUriInfo(new UriInfoImpl());
    }

    @Test
    public void listProposalsTest() {
        final Proposals result = srvProposalsV0.listProposals(DOCUMENT_TYPE_ID, DOCUMENT_NUMBER, CUSTOMER_ID);
        assertNotNull(result);
        assertNotNull(result.getData());

        assertEquals(3, result.getData().size());
    }


    @Test
    public void listProposalsWithoutCustomerIdTest() {
        final Proposals result = srvProposalsV0.listProposals(DOCUMENT_TYPE_ID, DOCUMENT_NUMBER, null);
        assertNotNull(result);
        assertNotNull(result.getData());

        assertEquals(3, result.getData().size());
    }

    @Test
    public void listProposalsWithoutDocumentNumberTest() {
        final Proposals result = srvProposalsV0.listProposals(DOCUMENT_TYPE_ID, null, CUSTOMER_ID);
        assertNotNull(result);
        assertNotNull(result.getData());

        assertEquals(3, result.getData().size());
    }

    @Test
    public void listProposalsWithoutDocumentTypeIdTest() {
        final Proposals result = srvProposalsV0.listProposals(null, DOCUMENT_NUMBER, CUSTOMER_ID);
        assertNotNull(result);
        assertNotNull(result.getData());

        assertEquals(3, result.getData().size());
    }

    @Test
    public void listProposalsWithoutOpcionalTest() {
        expectedException.expect(BusinessServiceException.class);
        expectedException.expect(BusinessServiceExceptionMatcher.hasErrorCode(Errors.MANDATORY_PARAMETERS_MISSING));
        srvProposalsV0.listProposals(null, null, null);

    }

    @Test
    public void listProposalsWithoutDocumentTypeIdAndCustomerIdTest() {
        expectedException.expect(BusinessServiceException.class);
        expectedException.expect(BusinessServiceExceptionMatcher.hasErrorCode(Errors.PARAMETERS_MISSING));
        srvProposalsV0.listProposals(null, DOCUMENT_NUMBER, null);

    }

    @Test
    public void listProposalsWithoutDocumentNumberAndCustomerIdTest() {
        expectedException.expect(BusinessServiceException.class);
        expectedException.expect(BusinessServiceExceptionMatcher.hasErrorCode(Errors.PARAMETERS_MISSING));

        srvProposalsV0.listProposals(DOCUMENT_TYPE_ID, null, null);

    }

    @Test
    public void listProposalsWithoutDocumentNumberAndDocumentTypeIdTest() {


        final Proposals result = srvProposalsV0.listProposals(null, null, CUSTOMER_ID);
        assertNotNull(result);
        assertNotNull(result.getData());

        assertEquals(3, result.getData().size());
    }
}
