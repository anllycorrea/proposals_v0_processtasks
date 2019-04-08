package com.bbva.pzic.proposals.util.mappers;

import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.jee.arq.spring.core.servicing.test.BusinessServiceTestContextLoader;
import com.bbva.jee.arq.spring.core.servicing.test.MockInvocationContextTestExecutionListener;
import com.bbva.pzic.proposals.util.Errors;
import com.bbva.pzic.utilTest.BusinessServiceExceptionMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import static com.bbva.pzic.proposals.util.Errors.MANDATORY_PARAMETERS_MISSING;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = BusinessServiceTestContextLoader.class, locations = {
        "classpath*:/META-INF/spring/applicationContext-*.xml",
        "classpath:/META-INF/spring/business-service-test.xml"})
@TestExecutionListeners(listeners = {
        MockInvocationContextTestExecutionListener.class,
        DependencyInjectionTestExecutionListener.class})
public class EnumMapperTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Autowired
    private EnumMapper enumMapper;

    @Test
    public void testGetBackendValue() {
        String value = enumMapper.getBackendValue("documentType.id", "DNI");
        assertEquals(value, "L");
    }

    @Test
    public void testGetNullBackendValue() {
        String value = enumMapper.getBackendValue("documentType.id", null);
        assertNull(value);
    }

    @Test
    public void testGetNullBackendValueWithEmptyParameter() {
        String value = enumMapper.getBackendValue("documentType.id", "");
        assertNull(value);
    }

    @Test
    public void testGetUnregisterBackendValue() {
        expectedException.expect(BusinessServiceException.class);
        expectedException.expect(BusinessServiceExceptionMatcher.hasErrorCode(Errors.TECHNICAL_ERROR));
        enumMapper.getEnumValue("documentType.id", "XXX");

    }

    @Test
    public void testGetEnumValue() throws Exception {
        String value = enumMapper.getEnumValue("documentType.id", "L");
        assertEquals(value, "DNI");
    }

    @Test
    public void testGetNullEnumValue() throws Exception {
        String value = enumMapper.getEnumValue("documentType.id", null);
        assertNull(value);
    }

    @Test
    public void testGetNullEnumValueWithEmptyParameter() throws Exception {
        String value = enumMapper.getEnumValue("documentType.id", "");
        assertNull(value);
    }

    @Test
    public void testGetUnregisterEnumValue() {
        expectedException.expect(BusinessServiceException.class);
        expectedException.expect(BusinessServiceExceptionMatcher.hasErrorCode(Errors.WRONG_PARAMETERS));

        enumMapper.getBackendValue("documentType.id", "X");

    }
}