package com.bbva.pzic.proposals.util.connection;

import com.bbva.jee.arq.spring.core.rest.RestConnector;
import com.bbva.jee.arq.spring.core.servicing.configuration.ConfigurationManager;
import com.bbva.jee.arq.spring.core.servicing.test.BusinessServiceTestContextLoader;
import com.bbva.jee.arq.spring.core.servicing.test.MockInvocationContextTestExecutionListener;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

/**
 * Created on 04/01/2017
 *
 * @author Entelgy
 */
@ContextConfiguration(loader = BusinessServiceTestContextLoader.class, locations = {"classpath*:/META-INF/spring/applicationContext-*.xml", "classpath:/META-INF/spring/business-service-test.xml"})
@TestExecutionListeners(listeners = {MockInvocationContextTestExecutionListener.class, DependencyInjectionTestExecutionListener.class})
public class BaseRestConnectionTest {

    @Mock
    protected ConfigurationManager configurationManager;

    @Mock
    protected RestConnector restConnector;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
}