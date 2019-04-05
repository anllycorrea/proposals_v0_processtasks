package com.bbva.pzic.proposals.facade.v0.impl;

import com.bbva.jee.arq.spring.core.servicing.test.BusinessServiceTestContextLoader;
import com.bbva.jee.arq.spring.core.servicing.test.MockInvocationContextTestExecutionListener;
import com.bbva.pzic.proposals.DummyMock;
import com.bbva.pzic.proposals.canonic.SimulatedProposal;
import com.bbva.pzic.proposals.canonic.SimulatedProposalsData;
import com.bbva.pzic.proposals.facade.v0.ISrvProposalsV0;
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

import java.io.IOException;

import static com.bbva.pzic.proposals.dao.rest.mock.RestSimulateProposalsMock.EMPTY_DATA;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created on 28/12/2017.
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
public class SrvSimulateProposalsV0IntegrationTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    @Autowired
    private ISrvProposalsV0 srvProposalsV0;
    private DummyMock dummyMock;

    @Before
    public void setUp() {
        dummyMock = new DummyMock();
    }

    @Test
    public void simulateProposalsTest() throws IOException {
        SimulatedProposal simulatedProposal = dummyMock.getSimulatedProposal();

        SimulatedProposalsData result = srvProposalsV0.simulateProposals(simulatedProposal);

        assertNotNull(result);
        assertNotNull(result.getData());
    }

    @Test
    public void simulateProposalsEmptyTest() throws IOException {
        SimulatedProposal simulatedProposal = dummyMock.getSimulatedProposal();
        simulatedProposal.getParticipant().getIdentityDocument().setDocumentNumber(EMPTY_DATA);
        SimulatedProposalsData result = srvProposalsV0.simulateProposals(simulatedProposal);

        assertNull(result);
    }

    @Test
    public void simulateProposalsWithoutFieldsTest() {
        SimulatedProposalsData result = srvProposalsV0.simulateProposals(new SimulatedProposal());

        assertNotNull(result);
        assertNotNull(result.getData());
    }
}