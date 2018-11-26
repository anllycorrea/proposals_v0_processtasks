package com.bbva.pzic.proposals.util.connection.rest;

import com.bbva.jee.arq.spring.core.rest.RestConnectorResponse;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.jee.arq.spring.core.servicing.utils.Pagination;
import com.bbva.pzic.proposals.util.Errors;
import com.bbva.pzic.proposals.util.connection.BaseRestConnectionTest;
import com.bbva.pzic.proposals.util.connection.rest.impl.RestGetConnectionDummyImpl;
import com.bbva.pzic.utilTest.BusinessServiceExceptionMatcher;
import org.apache.cxf.helpers.IOUtils;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import static com.bbva.pzic.proposals.util.Errors.MANDATORY_PARAMETERS_MISSING;
import static org.junit.Assert.*;

/**
 * Created on 04/01/2017
 *
 * @author Entelgy
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class RestGetConnectionTest extends BaseRestConnectionTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();


    @InjectMocks
    @Autowired
    private RestGetConnectionDummyImpl restGetConnection;

    @Test
    public void restGetConnectionTest() throws IOException {
        InputStream in = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("com/bbva/pzic/proposals/dao/mock/Pagination.json");

        RestConnectorResponse response = new RestConnectorResponse();
        response.setContentBytes(IOUtils.readBytesFromStream(in));
        response.generateResponseBody();

        Mockito.when(configurationManager.getProperty(Mockito.anyString())).thenReturn("localhost");
        Mockito.when(restConnector.doGet(Mockito.anyString(), Matchers.<HashMap<String, String>>any(),
                Matchers.<HashMap<String, String>>any(), Mockito.anyString(), Mockito.anyBoolean())).
                thenReturn(response);

        Pagination result = restGetConnection.invoke("abc");

        Assert.assertNotNull(result);
    }

    @Test
    public void restGetPathParamsConnectionTest() throws IOException {
        InputStream in = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("com/bbva/pzic/proposals/dao/mock/Pagination.json");

        RestConnectorResponse response = new RestConnectorResponse();
        response.setContentBytes(IOUtils.readBytesFromStream(in));
        response.generateResponseBody();

        Mockito.when(configurationManager.getProperty(Mockito.anyString())).thenReturn("localhost/{key1}/{key3}");
        Mockito.when(restConnector.doGet(Mockito.anyString(), Matchers.<HashMap<String, String>>any(),
                Matchers.<HashMap<String, String>>any(), Mockito.anyString(), Mockito.anyBoolean())).
                thenReturn(response);

        Pagination result = restGetConnection.invokeWithPathParams("abc");

        assertNotNull(result);
    }

    @Test
    public void restGetQueryParamsConnectionTest() throws IOException {
        InputStream in = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("com/bbva/pzic/proposals/dao/mock/Pagination.json");

        RestConnectorResponse response = new RestConnectorResponse();
        response.setContentBytes(IOUtils.readBytesFromStream(in));
        response.generateResponseBody();

        Mockito.when(configurationManager.getProperty(Mockito.anyString())).thenReturn("localhost/{key1}/{key3}");
        Mockito.when(restConnector.doGet(Mockito.anyString(), Matchers.<HashMap<String, String>>any(),
                Matchers.<HashMap<String, String>>any(), Mockito.anyString(), Mockito.anyBoolean())).
                thenReturn(response);

        Pagination result = restGetConnection.invokeWithQueryParams("abc");

        assertNotNull(result);
    }

    @Test
    public void restErrorResponseTest() throws IOException {
        expectedException.expect(BusinessServiceException.class);
        expectedException.expect(BusinessServiceExceptionMatcher.hasErrorCode(Errors.FUNCTIONAL_ERROR));

        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("json/error-response.json");

        RestConnectorResponse response = new RestConnectorResponse();
        response.setStatusCode(400);
        response.setContentBytes(IOUtils.readBytesFromStream(in));
        Map<String, String> headers = new HashMap<>();
        headers.put("errorCode", "an error code");
        headers.put("errorMessage", "an error message");
        response.setHeaders(headers);
        response.generateResponseBody();

        Mockito.when(configurationManager.getProperty(Mockito.anyString())).thenReturn("localhost");
        Mockito.when(restConnector.doGet(Mockito.anyString(), Matchers.<HashMap<String, String>>any(),
                Matchers.<HashMap<String, String>>any(), Mockito.anyString(), Mockito.anyBoolean())).
                thenReturn(response);

        restGetConnection.invoke("abc");

    }

    @Test
    public void restWrongSeverityResponseBodyTest() throws IOException {
        try {
            InputStream in = Thread.currentThread().getContextClassLoader()
                    .getResourceAsStream("json/error-response-wrong-severity.json");

            RestConnectorResponse response = new RestConnectorResponse();
            response.setStatusCode(404);
            response.setContentBytes(IOUtils.readBytesFromStream(in));
            response.generateResponseBody();

            Mockito.when(configurationManager.getProperty(Mockito.anyString())).thenReturn("localhost");
            Mockito.when(restConnector.doGet(Mockito.anyString(), Matchers.<HashMap<String, String>>any(),
                    Matchers.<HashMap<String, String>>any(), Mockito.anyString(), Mockito.anyBoolean())).
                    thenReturn(response);

            restGetConnection.invoke("abc");
            fail();
        } catch (final BusinessServiceException e) {
            assertEquals(500, e.getHttpStatus());
        }
    }

    @Test
    public void restWrongErrorResponseBodyTest() throws IOException {
        try {
            InputStream in = Thread.currentThread().getContextClassLoader()
                    .getResourceAsStream("com/bbva/pzic/proposals/dao/mock/FormatProposalData.json");

            RestConnectorResponse response = new RestConnectorResponse();
            response.setStatusCode(400);
            response.setContentBytes(IOUtils.readBytesFromStream(in));
            response.generateResponseBody();

            Mockito.when(configurationManager.getProperty(Mockito.anyString())).thenReturn("localhost");
            Mockito.when(restConnector.doGet(Mockito.anyString(), Matchers.<HashMap<String, String>>any(),
                    Matchers.<HashMap<String, String>>any(), Mockito.anyString(), Mockito.anyBoolean())).
                    thenReturn(response);

            restGetConnection.invoke("abc");
            fail();
        } catch (final BusinessServiceException e) {
            assertEquals(500, e.getHttpStatus());
        }
    }
}