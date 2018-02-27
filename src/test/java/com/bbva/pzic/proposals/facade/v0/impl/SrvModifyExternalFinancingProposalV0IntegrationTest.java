package com.bbva.pzic.proposals.facade.v0.impl;

import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.jee.arq.spring.core.servicing.test.BusinessServiceTestContextLoader;
import com.bbva.jee.arq.spring.core.servicing.test.MockInvocationContextTestExecutionListener;
import com.bbva.pzic.proposals.DummyMock;
import com.bbva.pzic.proposals.canonic.ExternalFinancingProposal;
import com.bbva.pzic.proposals.util.Errors;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import javax.ws.rs.core.Response;
import java.io.IOException;

import static org.junit.Assert.*;

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
public class SrvModifyExternalFinancingProposalV0IntegrationTest {

    @Autowired
    private SrvProposalsV0 srvProposalsV0;

    private DummyMock mock = new DummyMock();

    @Test
    public void testModifyExternalFinancingProposal() throws IOException {
        ExternalFinancingProposal payload = mock.modifyExternalFinancingProposalPayload();
        Response response = srvProposalsV0.modifyExternalFinancingProposal(DummyMock.EXTERNAL_FINANCING_PROPOSAL_ID, payload);

        assertEquals(200, response.getStatus());
        assertNull(response.getEntity());
    }

    @Test
    public void testModifyExternalFinancingProposalWithDeliveryTypeIdEmpty() throws IOException {
        ExternalFinancingProposal payload = mock.modifyExternalFinancingProposalPayload();
        payload.getDelivery().getDeliveryType().setId(null);
        Response response = srvProposalsV0.modifyExternalFinancingProposal(DummyMock.EXTERNAL_FINANCING_PROPOSAL_ID, payload);

        assertEquals(200, response.getStatus());
        assertNull(response.getEntity());
    }

    @Test
    public void testModifyExternalFinancingProposalWithDeliveryEmailEmpty() throws IOException {
        ExternalFinancingProposal payload = mock.modifyExternalFinancingProposalPayload();
        payload.getDelivery().setEmail(null);
        Response response = srvProposalsV0.modifyExternalFinancingProposal(DummyMock.EXTERNAL_FINANCING_PROPOSAL_ID, payload);

        assertEquals(200, response.getStatus());
        assertNull(response.getEntity());
    }

    @Test
    public void testModifyExternalFinancingProposalWithStatusIdEmpty() throws IOException{
        try {
            ExternalFinancingProposal payload = mock.modifyExternalFinancingProposalPayload();
            payload.getStatus().setId(null);
            srvProposalsV0.modifyExternalFinancingProposal(DummyMock.EXTERNAL_FINANCING_PROPOSAL_ID, payload);
            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.MANDATORY_PARAMETERS_MISSING, e.getErrorCode());
        }
    }

    @Test
    public void testModifyExternalFinancingProposalWrongIdSize() throws IOException {
        try {
            ExternalFinancingProposal payload = mock.modifyExternalFinancingProposalPayload();
            srvProposalsV0.modifyExternalFinancingProposal("0011013096000000010", payload);
            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.WRONG_PARAMETERS, e.getErrorCode());
        }
    }

    @Test
    public void testModifyExternalFinancingProposalWrongDeliveryTypeIdSize() throws IOException {
        try {
            ExternalFinancingProposal payload = mock.modifyExternalFinancingProposalPayload();
            payload.getDelivery().getDeliveryType().setId("DD");
            srvProposalsV0.modifyExternalFinancingProposal(DummyMock.EXTERNAL_FINANCING_PROPOSAL_ID, payload);

            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.WRONG_PARAMETERS, e.getErrorCode());
        }
    }

    @Test
    public void testModifyExternalFinancingProposalWrongDeliveryEmailSize() throws IOException {
        try {
            ExternalFinancingProposal payload = mock.modifyExternalFinancingProposalPayload();
            payload.getDelivery().setEmail("0912ED102DJ9W1DFWWDJ1D912DJ18JHW9E192D18234718IW5KF");
            srvProposalsV0.modifyExternalFinancingProposal(DummyMock.EXTERNAL_FINANCING_PROPOSAL_ID, payload);

            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.WRONG_PARAMETERS, e.getErrorCode());
        }
    }

    @Test
    public void testModifyExternalFinancingProposalWrongStatusIdSize() throws IOException {
        try {
            ExternalFinancingProposal payload = mock.modifyExternalFinancingProposalPayload();
            payload.getStatus().setId("88");
            srvProposalsV0.modifyExternalFinancingProposal(DummyMock.EXTERNAL_FINANCING_PROPOSAL_ID, payload);

            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.WRONG_PARAMETERS, e.getErrorCode());
        }
    }
}