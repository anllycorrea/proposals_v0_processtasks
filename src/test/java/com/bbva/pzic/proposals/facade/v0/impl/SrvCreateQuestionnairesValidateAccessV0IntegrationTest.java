package com.bbva.pzic.proposals.facade.v0.impl;

import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponse;
import com.bbva.jee.arq.spring.core.servicing.test.BusinessServiceTestContextLoader;
import com.bbva.jee.arq.spring.core.servicing.test.MockInvocationContextTestExecutionListener;
import com.bbva.pzic.proposals.facade.v0.ISrvProposalsV0;
import com.bbva.pzic.proposals.facade.v0.dto.ValidateAccess;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import static org.junit.Assert.assertNotNull;

/**
 * Created on 15/11/2019.
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
public class SrvCreateQuestionnairesValidateAccessV0IntegrationTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    @Autowired
    private ISrvProposalsV0 srvProposalsV0;

    @Test
    public void createQuestionnairesValidateAccessTest() {
        ServiceResponse<ValidateAccess> result = srvProposalsV0.createQuestionnairesValidateAccess(null);

        assertNotNull(result.getData());
    }
}
