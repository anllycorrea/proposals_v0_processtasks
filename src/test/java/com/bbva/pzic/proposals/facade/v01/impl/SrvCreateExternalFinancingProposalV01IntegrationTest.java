package com.bbva.pzic.proposals.facade.v01.impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.runner.RunWith;
import com.bbva.jee.arq.spring.core.servicing.test.BusinessServiceTestContextLoader;
import org.springframework.test.context.ContextConfiguration;
import com.bbva.jee.arq.spring.core.servicing.test.MockInvocationContextTestExecutionListener;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.TestExecutionListeners;

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
public class SrvCreateExternalFinancingProposalV01IntegrationTest {

	@Autowired
	private SrvProposalsV01 srvProposalsV01;

	@Test
	public void testCreateExternalFinancingProposal() {

	}
}