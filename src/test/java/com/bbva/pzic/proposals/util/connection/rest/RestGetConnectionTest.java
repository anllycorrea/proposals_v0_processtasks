package com.bbva.pzic.proposals.util.connection.rest;

import com.bbva.jee.arq.spring.core.rest.RestConnectorResponse;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.pzic.proposals.canonic.Proposal;
import com.bbva.pzic.proposals.util.Errors;
import com.bbva.pzic.proposals.util.connection.BaseRestConnectionTest;
import com.bbva.pzic.proposals.util.connection.rest.impl.RestGetConnectionDummyImpl;
import org.apache.cxf.helpers.IOUtils;
import org.junit.Assert;
import org.junit.Test;
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

import static org.junit.Assert.*;

/**
 * Created on 04/01/2017
 *
 * @author Entelgy
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class RestGetConnectionTest extends BaseRestConnectionTest {

    @InjectMocks
    @Autowired
    private RestGetConnectionDummyImpl restGetConnection;

    @Test
    public void restGetConnectionTest() throws IOException {
        InputStream in = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("com/bbva/pzic/proposals/dao/mock/Proposal.json");

        RestConnectorResponse response = new RestConnectorResponse();
        response.setContentBytes(IOUtils.readBytesFromStream(in));
        response.generateResponseBody();

        Mockito.when(configurationManager.getProperty(Mockito.anyString())).thenReturn("localhost");
        Mockito.when(restConnector.doGet(Mockito.anyString(), Matchers.<HashMap<String, String>>any(),
                Matchers.<HashMap<String, String>>any(), Mockito.anyString(), Mockito.anyBoolean())).
                thenReturn(response);

        Proposal result = restGetConnection.invoke("abc");

        Assert.assertNotNull(result);
    }

    @Test
    public void restGetPathParamsConnectionTest() throws IOException {
        InputStream in = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("com/bbva/pzic/proposals/dao/mock/Proposal.json");

        RestConnectorResponse response = new RestConnectorResponse();
        response.setContentBytes(IOUtils.readBytesFromStream(in));
        response.generateResponseBody();

        Mockito.when(configurationManager.getProperty(Mockito.anyString())).thenReturn("localhost/{key1}/{key3}");
        Mockito.when(restConnector.doGet(Mockito.anyString(), Matchers.<HashMap<String, String>>any(),
                Matchers.<HashMap<String, String>>any(), Mockito.anyString(), Mockito.anyBoolean())).
                thenReturn(response);

        Proposal result = restGetConnection.invokeWithPathParams("abc");

        assertNotNull(result);
    }

    @Test
    public void restGetQueryParamsConnectionTest() throws IOException {
        InputStream in = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("com/bbva/pzic/proposals/dao/mock/Proposal.json");

        RestConnectorResponse response = new RestConnectorResponse();
        response.setContentBytes(IOUtils.readBytesFromStream(in));
        response.generateResponseBody();

        Mockito.when(configurationManager.getProperty(Mockito.anyString())).thenReturn("localhost/{key1}/{key3}");
        Mockito.when(restConnector.doGet(Mockito.anyString(), Matchers.<HashMap<String, String>>any(),
                Matchers.<HashMap<String, String>>any(), Mockito.anyString(), Mockito.anyBoolean())).
                thenReturn(response);

        Proposal result = restGetConnection.invokeWithQueryParams("abc");

        assertNotNull(result);
    }

    @Test
    public void restErrorResponseTest() throws IOException {
        try {
            InputStream in = Thread.currentThread().getContextClassLoader()
                    .getResourceAsStream("json/error-response.json");

            RestConnectorResponse response = new RestConnectorResponse();
            response.setStatusCode(400);
            response.setContentBytes(IOUtils.readBytesFromStream(in));
            Map<String, String> headers = new HashMap<String, String>();
            headers.put("errorMessage", "an error message");
            response.setHeaders(headers);
            response.generateResponseBody();

            Mockito.when(configurationManager.getProperty(Mockito.anyString())).thenReturn("localhost");
            Mockito.when(restConnector.doGet(Mockito.anyString(), Matchers.<HashMap<String, String>>any(),
                    Matchers.<HashMap<String, String>>any(), Mockito.anyString(), Mockito.anyBoolean())).
                    thenReturn(response);

            restGetConnection.invoke("abc");
            fail();
        } catch (final BusinessServiceException e) {
            assertEquals(409, e.getHttpStatus());
            assertEquals(Errors.FUNCTIONAL_ERROR, e.getErrorCode());
        }
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
                    .getResourceAsStream("com/bbva/pzic/proposals/dao/mock/Pagination.json");

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