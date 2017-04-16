package com.bbva.pzic.proposals.facade.v01.impl;

import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.jee.arq.spring.core.servicing.test.BusinessServiceTestContextLoader;
import com.bbva.jee.arq.spring.core.servicing.test.MockInvocationContextTestExecutionListener;
import com.bbva.pzic.proposals.canonic.ExternalFinancingProposal;
import com.bbva.pzic.proposals.dao.model.ugap.mock.TransaccionUgapMock;
import com.bbva.pzic.proposals.util.Errors;
import com.bbva.pzic.utilTest.UriInfoImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.cxf.helpers.IOUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;

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
public class SrvCreateExternalFinancingProposalV01IntegrationTest {
    private static final String EXTERNAL_FINANCING_PROPOSAL = "com/bbva/pzic/proposals/facade/v01/mapper/impl/externalFinancingProposal.json";

    @Autowired
    private SrvProposalsV01 srvProposalsV01;

    private ObjectMapper objectMapper;

    @Before
    public void setUp() {
        objectMapper = new ObjectMapper();
        UriInfo uriInfo = new UriInfoImpl();
        uriInfo.getPathParameters().add("external-financing-proposal-id", "external-financing-proposal-id");
        srvProposalsV01.setUriInfo(uriInfo);
    }

    @Test
    public void testCreateExternalFinancingProposal() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = getInstance(EXTERNAL_FINANCING_PROPOSAL, ExternalFinancingProposal.class);

        Response response = srvProposalsV01.createExternalFinancingProposal(externalFinancingProposal);

        assertNotNull(response);
        assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatus());
        assertNull(response.getEntity());
    }

    @Test
    public void testCreateExternalFinancingProposalOnlyMandatory() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = getInstance(EXTERNAL_FINANCING_PROPOSAL, ExternalFinancingProposal.class);
        externalFinancingProposal.getOperation().setOperationType(null);
        externalFinancingProposal.setExternalProduct(null);
        externalFinancingProposal.getThirdPartyProvider().setExternalSalesChannel(null);

        Response response = srvProposalsV01.createExternalFinancingProposal(externalFinancingProposal);

        assertNotNull(response);
        assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatus());
        assertNull(response.getEntity());
    }

    @Test
    public void testCreateExternalFinancingProposalWithOutOperationTypeId() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = getInstance(EXTERNAL_FINANCING_PROPOSAL, ExternalFinancingProposal.class);
        externalFinancingProposal.getOperation().getOperationType().setId(null);

        Response response = srvProposalsV01.createExternalFinancingProposal(externalFinancingProposal);

        assertNotNull(response);
        assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatus());
        assertNull(response.getEntity());
    }

    @Test
    public void testCreateExternalFinancingProposalWithOutExternalProductId() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = getInstance(EXTERNAL_FINANCING_PROPOSAL, ExternalFinancingProposal.class);
        externalFinancingProposal.getExternalProduct().setId(null);

        Response response = srvProposalsV01.createExternalFinancingProposal(externalFinancingProposal);

        assertNotNull(response);
        assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatus());
        assertNull(response.getEntity());
    }

    @Test
    public void testCreateExternalFinancingProposalWithOutExternalProductCommercialValue() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = getInstance(EXTERNAL_FINANCING_PROPOSAL, ExternalFinancingProposal.class);
        externalFinancingProposal.getExternalProduct().setCommercialValueAmount(null);

        Response response = srvProposalsV01.createExternalFinancingProposal(externalFinancingProposal);

        assertNotNull(response);
        assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatus());
        assertNull(response.getEntity());
    }

    @Test
    public void testCreateExternalFinancingProposalWithOutExternalProductCommercialValueAmount() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = getInstance(EXTERNAL_FINANCING_PROPOSAL, ExternalFinancingProposal.class);
        externalFinancingProposal.getExternalProduct().getCommercialValueAmount().setAmount(null);

        Response response = srvProposalsV01.createExternalFinancingProposal(externalFinancingProposal);

        assertNotNull(response);
        assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatus());
        assertNull(response.getEntity());
    }

    @Test
    public void testCreateExternalFinancingProposalWithOutExternalProductCommercialValueAmountCurrency() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = getInstance(EXTERNAL_FINANCING_PROPOSAL, ExternalFinancingProposal.class);
        externalFinancingProposal.getExternalProduct().getCommercialValueAmount().setCurrency(null);

        Response response = srvProposalsV01.createExternalFinancingProposal(externalFinancingProposal);

        assertNotNull(response);
        assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatus());
        assertNull(response.getEntity());
    }

    @Test
    public void testCreateExternalFinancingProposalWithoutResponse() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = getInstance(EXTERNAL_FINANCING_PROPOSAL, ExternalFinancingProposal.class);
        externalFinancingProposal.getHolder().getIdentityDocuments().get(0).setDocumentNumber(TransaccionUgapMock.NRO_DOCUMENTO);

        Response response = srvProposalsV01.createExternalFinancingProposal(externalFinancingProposal);

        assertNotNull(response);
        assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatus());
        assertNull(response.getEntity());
    }

    /*
    Validaciones de Obligatoriedad
    */
    /*
    holder
    */
    @Test
    public void testCreateExternalFinancingProposalWithOutHolder() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = getInstance(EXTERNAL_FINANCING_PROPOSAL, ExternalFinancingProposal.class);
        externalFinancingProposal.setHolder(null);

        try {
            srvProposalsV01.createExternalFinancingProposal(externalFinancingProposal);

            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.MANDATORY_PARAMETERS_MISSING, e.getErrorCode());
        }
    }

    /*
    holder.identityDocuments
    */
    @Test
    public void testCreateExternalFinancingProposalWithOutHolderIdentityDocuments() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = getInstance(EXTERNAL_FINANCING_PROPOSAL, ExternalFinancingProposal.class);
        externalFinancingProposal.getHolder().setIdentityDocuments(null);

        try {
            srvProposalsV01.createExternalFinancingProposal(externalFinancingProposal);

            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.MANDATORY_PARAMETERS_MISSING, e.getErrorCode());
        }
    }

    /*
    holder.identityDocuments
    */
    @Test
    public void testCreateExternalFinancingProposalWithOutHolderIdentityDocumentItems() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = getInstance(EXTERNAL_FINANCING_PROPOSAL, ExternalFinancingProposal.class);
        externalFinancingProposal.getHolder().getIdentityDocuments().clear();
        externalFinancingProposal.getHolder().getIdentityDocuments().add(null);

        try {
            srvProposalsV01.createExternalFinancingProposal(externalFinancingProposal);

            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.MANDATORY_PARAMETERS_MISSING, e.getErrorCode());
        }
    }

    /*
    holder.identityDocuments[0].documentNumber
    */
    @Test
    public void testCreateExternalFinancingProposalWithOutHolderIdentityDocumentNumber() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = getInstance(EXTERNAL_FINANCING_PROPOSAL, ExternalFinancingProposal.class);
        externalFinancingProposal.getHolder().getIdentityDocuments().get(0).setDocumentNumber(null);

        try {
            srvProposalsV01.createExternalFinancingProposal(externalFinancingProposal);

            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.MANDATORY_PARAMETERS_MISSING, e.getErrorCode());
        }
    }

    /*
    holder.identityDocuments[0].documentType
    */
    @Test
    public void testCreateExternalFinancingProposalWithOutHolderIdentityDocumentType() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = getInstance(EXTERNAL_FINANCING_PROPOSAL, ExternalFinancingProposal.class);
        externalFinancingProposal.getHolder().getIdentityDocuments().get(0).setDocumentType(null);

        try {
            srvProposalsV01.createExternalFinancingProposal(externalFinancingProposal);

            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.MANDATORY_PARAMETERS_MISSING, e.getErrorCode());
        }
    }

    /*
    holder.identityDocuments[0].documentType.id
    */
    @Test
    public void testCreateExternalFinancingProposalWithOutHolderIdentityDocumentTypeId() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = getInstance(EXTERNAL_FINANCING_PROPOSAL, ExternalFinancingProposal.class);
        externalFinancingProposal.getHolder().getIdentityDocuments().get(0).getDocumentType().setId(null);

        try {
            srvProposalsV01.createExternalFinancingProposal(externalFinancingProposal);

            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.MANDATORY_PARAMETERS_MISSING, e.getErrorCode());
        }
    }

    /*
    tariff
    */
    @Test
    public void testCreateExternalFinancingProposalWithOutTariff() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = getInstance(EXTERNAL_FINANCING_PROPOSAL, ExternalFinancingProposal.class);
        externalFinancingProposal.setTariff(null);

        try {
            srvProposalsV01.createExternalFinancingProposal(externalFinancingProposal);

            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.MANDATORY_PARAMETERS_MISSING, e.getErrorCode());
        }
    }

    /*
    tariff.id
    */
    @Test
    public void testCreateExternalFinancingProposalWithOutTariffId() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = getInstance(EXTERNAL_FINANCING_PROPOSAL, ExternalFinancingProposal.class);
        externalFinancingProposal.getTariff().setId(null);

        try {
            srvProposalsV01.createExternalFinancingProposal(externalFinancingProposal);

            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.MANDATORY_PARAMETERS_MISSING, e.getErrorCode());
        }
    }

    /*
    currency
    */
    @Test
    public void testCreateExternalFinancingProposalWithOutCurrency() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = getInstance(EXTERNAL_FINANCING_PROPOSAL, ExternalFinancingProposal.class);
        externalFinancingProposal.setCurrency(null);

        try {
            srvProposalsV01.createExternalFinancingProposal(externalFinancingProposal);

            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.MANDATORY_PARAMETERS_MISSING, e.getErrorCode());
        }
    }

    @Test
    public void testCreateExternalFinancingProposalWithOutInitial() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = getInstance(EXTERNAL_FINANCING_PROPOSAL, ExternalFinancingProposal.class);
        externalFinancingProposal.setInitialAmount(null);

        try {
            srvProposalsV01.createExternalFinancingProposal(externalFinancingProposal);

            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.MANDATORY_PARAMETERS_MISSING, e.getErrorCode());
        }
    }

    @Test
    public void testCreateExternalFinancingProposalWithOutInitialAmount() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = getInstance(EXTERNAL_FINANCING_PROPOSAL, ExternalFinancingProposal.class);
        externalFinancingProposal.getInitialAmount().setAmount(null);

        try {
            srvProposalsV01.createExternalFinancingProposal(externalFinancingProposal);

            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.MANDATORY_PARAMETERS_MISSING, e.getErrorCode());
        }
    }

    @Test
    public void testCreateExternalFinancingProposalWithOutInitialAmountCurrency() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = getInstance(EXTERNAL_FINANCING_PROPOSAL, ExternalFinancingProposal.class);
        externalFinancingProposal.getInitialAmount().setCurrency(null);

        try {
            srvProposalsV01.createExternalFinancingProposal(externalFinancingProposal);

            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.MANDATORY_PARAMETERS_MISSING, e.getErrorCode());
        }
    }

    @Test
    public void testCreateExternalFinancingProposalWithOutPaymentDay() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = getInstance(EXTERNAL_FINANCING_PROPOSAL, ExternalFinancingProposal.class);
        externalFinancingProposal.setPaymentDay(null);

        try {
            srvProposalsV01.createExternalFinancingProposal(externalFinancingProposal);

            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.MANDATORY_PARAMETERS_MISSING, e.getErrorCode());
        }
    }

    @Test
    public void testCreateExternalFinancingProposalWithOutDelivery() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = getInstance(EXTERNAL_FINANCING_PROPOSAL, ExternalFinancingProposal.class);
        externalFinancingProposal.setDelivery(null);

        try {
            srvProposalsV01.createExternalFinancingProposal(externalFinancingProposal);

            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.MANDATORY_PARAMETERS_MISSING, e.getErrorCode());
        }
    }

    @Test
    public void testCreateExternalFinancingProposalWithOutDeliveryType() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = getInstance(EXTERNAL_FINANCING_PROPOSAL, ExternalFinancingProposal.class);
        externalFinancingProposal.getDelivery().setDeliveryType(null);

        try {
            srvProposalsV01.createExternalFinancingProposal(externalFinancingProposal);

            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.MANDATORY_PARAMETERS_MISSING, e.getErrorCode());
        }
    }

    @Test
    public void testCreateExternalFinancingProposalWithOutDeliveryTypeId() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = getInstance(EXTERNAL_FINANCING_PROPOSAL, ExternalFinancingProposal.class);
        externalFinancingProposal.getDelivery().getDeliveryType().setId(null);

        try {
            srvProposalsV01.createExternalFinancingProposal(externalFinancingProposal);

            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.MANDATORY_PARAMETERS_MISSING, e.getErrorCode());
        }
    }

    @Test
    public void testCreateExternalFinancingProposalWithOutDeliveryVirtualDestination() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = getInstance(EXTERNAL_FINANCING_PROPOSAL, ExternalFinancingProposal.class);
        externalFinancingProposal.getDelivery().setVirtualDestination(null);

        try {
            srvProposalsV01.createExternalFinancingProposal(externalFinancingProposal);

            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.MANDATORY_PARAMETERS_MISSING, e.getErrorCode());
        }
    }

    @Test
    public void testCreateExternalFinancingProposalWithOutOperation() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = getInstance(EXTERNAL_FINANCING_PROPOSAL, ExternalFinancingProposal.class);
        externalFinancingProposal.setOperation(null);

        try {
            srvProposalsV01.createExternalFinancingProposal(externalFinancingProposal);

            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.MANDATORY_PARAMETERS_MISSING, e.getErrorCode());
        }
    }

    @Test
    public void testCreateExternalFinancingProposalWithOutOperationId() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = getInstance(EXTERNAL_FINANCING_PROPOSAL, ExternalFinancingProposal.class);
        externalFinancingProposal.getOperation().setId(null);

        try {
            srvProposalsV01.createExternalFinancingProposal(externalFinancingProposal);

            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.MANDATORY_PARAMETERS_MISSING, e.getErrorCode());
        }
    }

    @Test
    public void testCreateExternalFinancingProposalWithOutThirdPartyProvider() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = getInstance(EXTERNAL_FINANCING_PROPOSAL, ExternalFinancingProposal.class);
        externalFinancingProposal.setThirdPartyProvider(null);

        try {
            srvProposalsV01.createExternalFinancingProposal(externalFinancingProposal);

            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.MANDATORY_PARAMETERS_MISSING, e.getErrorCode());
        }
    }

    @Test
    public void testCreateExternalFinancingProposalWithOutThirdPartyProviderId() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = getInstance(EXTERNAL_FINANCING_PROPOSAL, ExternalFinancingProposal.class);
        externalFinancingProposal.getThirdPartyProvider().setId(null);

        try {
            srvProposalsV01.createExternalFinancingProposal(externalFinancingProposal);

            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.MANDATORY_PARAMETERS_MISSING, e.getErrorCode());
        }
    }

    /*
    Validacion Tamanios
    */
    @Test
    public void testCreateExternalFinancingProposalInvalidSizeHolderIdentityDocumentNumber() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = getInstance(EXTERNAL_FINANCING_PROPOSAL, ExternalFinancingProposal.class);
        externalFinancingProposal.getHolder().getIdentityDocuments().get(0).setDocumentNumber("12345678901");

        try {
            srvProposalsV01.createExternalFinancingProposal(externalFinancingProposal);

            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.WRONG_PARAMETERS, e.getErrorCode());
        }
    }

    @Test
    public void testCreateExternalFinancingProposalInvalidSizeTariffId() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = getInstance(EXTERNAL_FINANCING_PROPOSAL, ExternalFinancingProposal.class);
        externalFinancingProposal.getTariff().setId("12345678901");

        try {
            srvProposalsV01.createExternalFinancingProposal(externalFinancingProposal);

            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.WRONG_PARAMETERS, e.getErrorCode());
        }
    }

    @Test
    public void testCreateExternalFinancingProposalInvalidSizeCurrency() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = getInstance(EXTERNAL_FINANCING_PROPOSAL, ExternalFinancingProposal.class);
        externalFinancingProposal.setCurrency("1234");

        try {
            srvProposalsV01.createExternalFinancingProposal(externalFinancingProposal);

            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.WRONG_PARAMETERS, e.getErrorCode());
        }
    }

    @Test
    public void testCreateExternalFinancingProposalInvalidSizeFractionInitialAmount() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = getInstance(EXTERNAL_FINANCING_PROPOSAL, ExternalFinancingProposal.class);
        externalFinancingProposal.getInitialAmount().setAmount(new BigDecimal("789.856"));

        try {
            srvProposalsV01.createExternalFinancingProposal(externalFinancingProposal);

            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.WRONG_PARAMETERS, e.getErrorCode());
        }
    }

    @Test
    public void testCreateExternalFinancingProposalInvalidSizeIntegerInitialAmount() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = getInstance(EXTERNAL_FINANCING_PROPOSAL, ExternalFinancingProposal.class);
        externalFinancingProposal.getInitialAmount().setAmount(new BigDecimal("1234567890123456.85"));

        try {
            srvProposalsV01.createExternalFinancingProposal(externalFinancingProposal);

            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.WRONG_PARAMETERS, e.getErrorCode());
        }
    }

    @Test
    public void testCreateExternalFinancingProposalInvalidSizeInitialAmountCurrency() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = getInstance(EXTERNAL_FINANCING_PROPOSAL, ExternalFinancingProposal.class);
        externalFinancingProposal.getInitialAmount().setCurrency("1234");

        try {
            srvProposalsV01.createExternalFinancingProposal(externalFinancingProposal);

            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.WRONG_PARAMETERS, e.getErrorCode());
        }
    }

    @Test
    public void testCreateExternalFinancingProposalInvalidSizePaymentDay() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = getInstance(EXTERNAL_FINANCING_PROPOSAL, ExternalFinancingProposal.class);
        externalFinancingProposal.setPaymentDay(123);

        try {
            srvProposalsV01.createExternalFinancingProposal(externalFinancingProposal);

            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.WRONG_PARAMETERS, e.getErrorCode());
        }
    }

    @Test
    public void testCreateExternalFinancingProposalInvalidSizeDeliveryVirtualDestination() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = getInstance(EXTERNAL_FINANCING_PROPOSAL, ExternalFinancingProposal.class);
        externalFinancingProposal.getDelivery().setVirtualDestination("123456789012345678901234567890123456789012345678901");

        try {
            srvProposalsV01.createExternalFinancingProposal(externalFinancingProposal);

            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.WRONG_PARAMETERS, e.getErrorCode());
        }
    }

    @Test
    public void testCreateExternalFinancingProposalInvalidSizeOperationId() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = getInstance(EXTERNAL_FINANCING_PROPOSAL, ExternalFinancingProposal.class);
        externalFinancingProposal.getOperation().setId("123456789012345678901234567890123");

        try {
            srvProposalsV01.createExternalFinancingProposal(externalFinancingProposal);

            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.WRONG_PARAMETERS, e.getErrorCode());
        }
    }

    @Test
    public void testCreateExternalFinancingProposalInvalidSizeThirdPartyProviderId() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = getInstance(EXTERNAL_FINANCING_PROPOSAL, ExternalFinancingProposal.class);
        externalFinancingProposal.getThirdPartyProvider().setId("TDPE1");

        try {
            srvProposalsV01.createExternalFinancingProposal(externalFinancingProposal);

            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.WRONG_PARAMETERS, e.getErrorCode());
        }
    }

    @Test
    public void testCreateExternalFinancingProposalInvalidSizeOperationTypeId() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = getInstance(EXTERNAL_FINANCING_PROPOSAL, ExternalFinancingProposal.class);
        externalFinancingProposal.getOperation().getOperationType().setId("ALTA12");

        try {
            srvProposalsV01.createExternalFinancingProposal(externalFinancingProposal);

            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.WRONG_PARAMETERS, e.getErrorCode());
        }
    }

    @Test
    public void testCreateExternalFinancingProposalInvalidSizeExternalProductId() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = getInstance(EXTERNAL_FINANCING_PROPOSAL, ExternalFinancingProposal.class);
        externalFinancingProposal.getExternalProduct().setId("1234567890123456");

        try {
            srvProposalsV01.createExternalFinancingProposal(externalFinancingProposal);

            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.WRONG_PARAMETERS, e.getErrorCode());
        }
    }

    @Test
    public void testCreateExternalFinancingProposalInvalidSizeIntegerExternalProductCommercialValueAmount() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = getInstance(EXTERNAL_FINANCING_PROPOSAL, ExternalFinancingProposal.class);
        externalFinancingProposal.getExternalProduct().getCommercialValueAmount().setAmount(new BigDecimal("1234567890123456.89"));

        try {
            srvProposalsV01.createExternalFinancingProposal(externalFinancingProposal);

            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.WRONG_PARAMETERS, e.getErrorCode());
        }
    }

    @Test
    public void testCreateExternalFinancingProposalInvalidSizeFractionExternalProductCommercialValueAmount() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = getInstance(EXTERNAL_FINANCING_PROPOSAL, ExternalFinancingProposal.class);
        externalFinancingProposal.getExternalProduct().getCommercialValueAmount().setAmount(new BigDecimal("123456789012345.897"));

        try {
            srvProposalsV01.createExternalFinancingProposal(externalFinancingProposal);

            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.WRONG_PARAMETERS, e.getErrorCode());
        }
    }

    @Test
    public void testCreateExternalFinancingProposalInvalidSizeExternalProductCommercialValueAmountCurrency() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = getInstance(EXTERNAL_FINANCING_PROPOSAL, ExternalFinancingProposal.class);
        externalFinancingProposal.getExternalProduct().getCommercialValueAmount().setCurrency("1234");

        try {
            srvProposalsV01.createExternalFinancingProposal(externalFinancingProposal);

            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.WRONG_PARAMETERS, e.getErrorCode());
        }
    }


    private <T> T getInstance(String file, Class<T> claz) throws IOException {
        InputStream in = Thread.currentThread().getContextClassLoader().
                getResourceAsStream(file);
        return objectMapper.readValue(IOUtils.readBytesFromStream(in), claz);
    }
}