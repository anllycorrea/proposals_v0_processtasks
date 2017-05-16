package com.bbva.pzic.proposals.facade.v01.impl;

import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.jee.arq.spring.core.servicing.test.BusinessServiceTestContextLoader;
import com.bbva.jee.arq.spring.core.servicing.test.MockInvocationContextTestExecutionListener;
import com.bbva.pzic.proposals.DummyMock;
import com.bbva.pzic.proposals.canonic.ExternalFinancingProposal;
import com.bbva.pzic.proposals.dao.model.ugap.mock.TransaccionUgapMock;
import com.bbva.pzic.proposals.util.Errors;
import com.bbva.pzic.utilTest.UriInfoImpl;
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

    @Autowired
    private SrvProposalsV01 srvProposalsV01;

    private DummyMock dummyMock;

    @Before
    public void setUp() {
        dummyMock = new DummyMock();
        UriInfo uriInfo = new UriInfoImpl();
        uriInfo.getPathParameters().add("external-financing-proposal-id", "external-financing-proposal-id");
        srvProposalsV01.setUriInfo(uriInfo);
    }

    @Test
    public void testCreateExternalFinancingProposal() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = dummyMock.getExternalFinancingProposal();

        Response response = srvProposalsV01.createExternalFinancingProposal(DummyMock.THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);

        assertNotNull(response);
        assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatus());
        assertNull(response.getEntity());
    }

    @Test
    public void testCreateExternalFinancingProposalOnlyMandatory() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = dummyMock.getExternalFinancingProposal();

        Response response = srvProposalsV01.createExternalFinancingProposal(null, externalFinancingProposal);

        assertNotNull(response);
        assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatus());
        assertNull(response.getEntity());
    }

    @Test
    public void testCreateExternalFinancingProposalWithoutResponse() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = dummyMock.getExternalFinancingProposal();
        externalFinancingProposal.getHolder().getIdentityDocuments().get(0).setDocumentNumber(TransaccionUgapMock.NRO_DOCUMENTO);

        Response response = srvProposalsV01.createExternalFinancingProposal(DummyMock.THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);

        assertNotNull(response);
        assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatus());
        assertNull(response.getEntity());
    }

    /*
    Validaciones de Obligatoriedad
    */
    /*
    externalProduct.id
     */
    @Test
    public void testCreateExternalFinancingProposalWithOutExternalProductId() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = dummyMock.getExternalFinancingProposal();
        externalFinancingProposal.getExternalProduct().setId(null);
        try {
            srvProposalsV01.createExternalFinancingProposal(DummyMock.THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);
            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.MANDATORY_PARAMETERS_MISSING, e.getErrorCode());
        }
    }
    /*
    externalProduct.commercialValue
     */
    @Test
    public void testCreateExternalFinancingProposalWithOutExternalProductCommercialValue() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = dummyMock.getExternalFinancingProposal();
        externalFinancingProposal.getExternalProduct().setCommercialValue(null);
        try{
            srvProposalsV01.createExternalFinancingProposal(DummyMock.THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);
            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.MANDATORY_PARAMETERS_MISSING, e.getErrorCode());
        }
    }
    /*
    externalProduct.commercialValue.amount
     */
    @Test
    public void testCreateExternalFinancingProposalWithOutExternalProductCommercialAmountValue() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = dummyMock.getExternalFinancingProposal();
        externalFinancingProposal.getExternalProduct().getCommercialValue().setAmount(null);
        try{
            srvProposalsV01.createExternalFinancingProposal(DummyMock.THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);
            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.MANDATORY_PARAMETERS_MISSING, e.getErrorCode());
        }
    }
    /*
    externalProduct.commercialValue.currency
     */
    @Test
    public void testCreateExternalFinancingProposalWithOutExternalProductCommercialValueCurrency() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = dummyMock.getExternalFinancingProposal();
        externalFinancingProposal.getExternalProduct().getCommercialValue().setCurrency(null);
    try{
        srvProposalsV01.createExternalFinancingProposal(DummyMock.THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);
        fail();
    } catch (BusinessServiceException e) {
        assertEquals(Errors.MANDATORY_PARAMETERS_MISSING, e.getErrorCode());
    }
}
    /*
    holder
    */
    @Test
    public void testCreateExternalFinancingProposalWithOutHolder() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = dummyMock.getExternalFinancingProposal();
        externalFinancingProposal.setHolder(null);

        try {
            srvProposalsV01.createExternalFinancingProposal(DummyMock.THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);
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
        ExternalFinancingProposal externalFinancingProposal = dummyMock.getExternalFinancingProposal();
        externalFinancingProposal.getHolder().setIdentityDocuments(null);

        try {
            srvProposalsV01.createExternalFinancingProposal(DummyMock.THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);
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
        ExternalFinancingProposal externalFinancingProposal = dummyMock.getExternalFinancingProposal();
        externalFinancingProposal.getHolder().getIdentityDocuments().clear();
        externalFinancingProposal.getHolder().getIdentityDocuments().add(null);

        try {
            srvProposalsV01.createExternalFinancingProposal(DummyMock.THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);
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
        ExternalFinancingProposal externalFinancingProposal = dummyMock.getExternalFinancingProposal();
        externalFinancingProposal.getHolder().getIdentityDocuments().get(0).setDocumentNumber(null);

        try {
            srvProposalsV01.createExternalFinancingProposal(DummyMock.THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);

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
        ExternalFinancingProposal externalFinancingProposal = dummyMock.getExternalFinancingProposal();
        externalFinancingProposal.getHolder().getIdentityDocuments().get(0).setDocumentType(null);

        try {
            srvProposalsV01.createExternalFinancingProposal(DummyMock.THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);

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
        ExternalFinancingProposal externalFinancingProposal = dummyMock.getExternalFinancingProposal();
        externalFinancingProposal.getHolder().getIdentityDocuments().get(0).getDocumentType().setId(null);

        try {
            srvProposalsV01.createExternalFinancingProposal(DummyMock.THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);
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
        ExternalFinancingProposal externalFinancingProposal = dummyMock.getExternalFinancingProposal();
        externalFinancingProposal.setTariff(null);

        try {
            srvProposalsV01.createExternalFinancingProposal(DummyMock.THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);

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
        ExternalFinancingProposal externalFinancingProposal = dummyMock.getExternalFinancingProposal();
        externalFinancingProposal.getTariff().setId(null);

        try {
            srvProposalsV01.createExternalFinancingProposal(DummyMock.THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);

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
        ExternalFinancingProposal externalFinancingProposal = dummyMock.getExternalFinancingProposal();
        externalFinancingProposal.setCurrency(null);

        try {
            srvProposalsV01.createExternalFinancingProposal(DummyMock.THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);
            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.MANDATORY_PARAMETERS_MISSING, e.getErrorCode());
        }
    }

    /*
    operation.operationType.id
     */
    @Test
    public void testCreateExternalFinancingProposalWithOutOperationTypeId() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = dummyMock.getExternalFinancingProposal();
        externalFinancingProposal.getOperation().getOperationType().setId(null);
        try{
            srvProposalsV01.createExternalFinancingProposal(DummyMock.THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);
            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.MANDATORY_PARAMETERS_MISSING, e.getErrorCode());
        }
    }

    /*
    branch
    */
    @Test
    public void testCreateExternalFinancingProposalWithOutBranch() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = dummyMock.getExternalFinancingProposal();
        externalFinancingProposal.setBranch(null);
        try{
            srvProposalsV01.createExternalFinancingProposal(DummyMock.THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);
            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.MANDATORY_PARAMETERS_MISSING, e.getErrorCode());
        }
    }

    /*
    branch.id
    */
    @Test
    public void testCreateExternalFinancingProposalWithOutBranchId() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = dummyMock.getExternalFinancingProposal();
        externalFinancingProposal.getBranch().setId(null);
        try{
            srvProposalsV01.createExternalFinancingProposal(DummyMock.THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);
            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.MANDATORY_PARAMETERS_MISSING, e.getErrorCode());
        }
    }

    /*
    thirdPartyProvider.externalSalesChannel.
    */
    @Test
    public void testCreateExternalFinancingProposalWithOutExternalSalesChannel() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = dummyMock.getExternalFinancingProposal();
        externalFinancingProposal.getThirdPartyProvider().setExternalSalesChannel(null);
        try{
            srvProposalsV01.createExternalFinancingProposal(DummyMock.THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);
            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.MANDATORY_PARAMETERS_MISSING, e.getErrorCode());
        }
    }

    /*
    thirdPartyProvider.externalSalesChannel.id
    */
    @Test
    public void testCreateExternalFinancingProposalWithOutExternalSalesChannelId() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = dummyMock.getExternalFinancingProposal();
        externalFinancingProposal.getThirdPartyProvider().getExternalSalesChannel().setId(null);
        try{
            srvProposalsV01.createExternalFinancingProposal(DummyMock.THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);
            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.MANDATORY_PARAMETERS_MISSING, e.getErrorCode());
        }
    }

    @Test
    public void testCreateExternalFinancingProposalWithOutInitial() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = dummyMock.getExternalFinancingProposal();
        externalFinancingProposal.setInitialAmount(null);

        try {
            srvProposalsV01.createExternalFinancingProposal(DummyMock.THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);

            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.MANDATORY_PARAMETERS_MISSING, e.getErrorCode());
        }
    }

    @Test
    public void testCreateExternalFinancingProposalWithOutInitialAmount() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = dummyMock.getExternalFinancingProposal();
        externalFinancingProposal.getInitialAmount().setAmount(null);

        try {
            srvProposalsV01.createExternalFinancingProposal(DummyMock.THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);

            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.MANDATORY_PARAMETERS_MISSING, e.getErrorCode());
        }
    }

    @Test
    public void testCreateExternalFinancingProposalWithOutInitialAmountCurrency() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = dummyMock.getExternalFinancingProposal();
        externalFinancingProposal.getInitialAmount().setCurrency(null);

        try {
            srvProposalsV01.createExternalFinancingProposal(DummyMock.THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);

            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.MANDATORY_PARAMETERS_MISSING, e.getErrorCode());
        }
    }

    @Test
    public void testCreateExternalFinancingProposalWithOutPaymentDay() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = dummyMock.getExternalFinancingProposal();
        externalFinancingProposal.setPaymentDay(null);

        try {
            srvProposalsV01.createExternalFinancingProposal(DummyMock.THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);

            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.MANDATORY_PARAMETERS_MISSING, e.getErrorCode());
        }
    }

    @Test
    public void testCreateExternalFinancingProposalWithOutDelivery() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = dummyMock.getExternalFinancingProposal();
        externalFinancingProposal.setDelivery(null);

        try {
            srvProposalsV01.createExternalFinancingProposal(DummyMock.THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);

            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.MANDATORY_PARAMETERS_MISSING, e.getErrorCode());
        }
    }

    @Test
    public void testCreateExternalFinancingProposalWithOutDeliveryType() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = dummyMock.getExternalFinancingProposal();
        externalFinancingProposal.getDelivery().setDeliveryType(null);

        try {
            srvProposalsV01.createExternalFinancingProposal(DummyMock.THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);

            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.MANDATORY_PARAMETERS_MISSING, e.getErrorCode());
        }
    }

    @Test
    public void testCreateExternalFinancingProposalWithOutDeliveryTypeId() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = dummyMock.getExternalFinancingProposal();
        externalFinancingProposal.getDelivery().getDeliveryType().setId(null);

        try {
            srvProposalsV01.createExternalFinancingProposal(DummyMock.THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);

            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.MANDATORY_PARAMETERS_MISSING, e.getErrorCode());
        }
    }

    @Test
    public void testCreateExternalFinancingProposalWithOutDeliveryEmail() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = dummyMock.getExternalFinancingProposal();
        externalFinancingProposal.getDelivery().setEmail(null);

        try {
            srvProposalsV01.createExternalFinancingProposal(DummyMock.THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);

            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.MANDATORY_PARAMETERS_MISSING, e.getErrorCode());
        }
    }

    @Test
    public void testCreateExternalFinancingProposalWithOutOperation() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = dummyMock.getExternalFinancingProposal();
        externalFinancingProposal.setOperation(null);

        try {
            srvProposalsV01.createExternalFinancingProposal(DummyMock.THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);

            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.MANDATORY_PARAMETERS_MISSING, e.getErrorCode());
        }
    }

    @Test
    public void testCreateExternalFinancingProposalWithOutOperationId() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = dummyMock.getExternalFinancingProposal();
        externalFinancingProposal.getOperation().setId(null);

        try {
            srvProposalsV01.createExternalFinancingProposal(DummyMock.THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);

            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.MANDATORY_PARAMETERS_MISSING, e.getErrorCode());
        }
    }

    @Test
    public void testCreateExternalFinancingProposalWithOutThirdPartyProvider() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = dummyMock.getExternalFinancingProposal();
        externalFinancingProposal.setThirdPartyProvider(null);

        try {
            srvProposalsV01.createExternalFinancingProposal(DummyMock.THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);

            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.MANDATORY_PARAMETERS_MISSING, e.getErrorCode());
        }
    }

    @Test
    public void testCreateExternalFinancingProposalWithOutThirdPartyProviderId() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = dummyMock.getExternalFinancingProposal();
        externalFinancingProposal.getThirdPartyProvider().setId(null);

        try {
            srvProposalsV01.createExternalFinancingProposal(DummyMock.THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);
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
        ExternalFinancingProposal externalFinancingProposal = dummyMock.getExternalFinancingProposal();
        externalFinancingProposal.getHolder().getIdentityDocuments().get(0).setDocumentNumber("12345678901");

        try {
            srvProposalsV01.createExternalFinancingProposal(DummyMock.THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);

            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.WRONG_PARAMETERS, e.getErrorCode());
        }
    }

    @Test
    public void testCreateExternalFinancingProposalInvalidSizeTariffId() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = dummyMock.getExternalFinancingProposal();
        externalFinancingProposal.getTariff().setId("12345678901");

        try {
            srvProposalsV01.createExternalFinancingProposal(DummyMock.THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);

            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.WRONG_PARAMETERS, e.getErrorCode());
        }
    }

    @Test
    public void testCreateExternalFinancingProposalInvalidSizeThirdPartyProviderUserId() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = dummyMock.getExternalFinancingProposal();

        try {
            srvProposalsV01.createExternalFinancingProposal("12345678901576586567565476546545646543653543564354356435463653654323498676", externalFinancingProposal);

            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.WRONG_PARAMETERS, e.getErrorCode());
        }
    }

    @Test
    public void testCreateExternalFinancingProposalInvalidSizeBranchId() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = dummyMock.getExternalFinancingProposal();
        externalFinancingProposal.getBranch().setId("12345678901");

        try {
            srvProposalsV01.createExternalFinancingProposal(DummyMock.THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);

            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.WRONG_PARAMETERS, e.getErrorCode());
        }
    }

    @Test
    public void testCreateExternalFinancingProposalInvalidSizeCurrency() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = dummyMock.getExternalFinancingProposal();
        externalFinancingProposal.setCurrency("1234");

        try {
            srvProposalsV01.createExternalFinancingProposal(DummyMock.THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);

            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.WRONG_PARAMETERS, e.getErrorCode());
        }
    }

    @Test
    public void testCreateExternalFinancingProposalInvalidSizeFractionInitialAmount() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = dummyMock.getExternalFinancingProposal();
        externalFinancingProposal.getInitialAmount().setAmount(new BigDecimal("789.856"));

        try {
            srvProposalsV01.createExternalFinancingProposal(DummyMock.THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);

            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.WRONG_PARAMETERS, e.getErrorCode());
        }
    }

    @Test
    public void testCreateExternalFinancingProposalInvalidSizeIntegerInitialAmount() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = dummyMock.getExternalFinancingProposal();
        externalFinancingProposal.getInitialAmount().setAmount(new BigDecimal("1234567890123456.85"));

        try {
            srvProposalsV01.createExternalFinancingProposal(DummyMock.THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);

            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.WRONG_PARAMETERS, e.getErrorCode());
        }
    }

    @Test
    public void testCreateExternalFinancingProposalInvalidSizeInitialAmountCurrency() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = dummyMock.getExternalFinancingProposal();
        externalFinancingProposal.getInitialAmount().setCurrency("1234");

        try {
            srvProposalsV01.createExternalFinancingProposal(DummyMock.THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);

            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.WRONG_PARAMETERS, e.getErrorCode());
        }
    }

    @Test
    public void testCreateExternalFinancingProposalInvalidSizePaymentDay() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = dummyMock.getExternalFinancingProposal();
        externalFinancingProposal.setPaymentDay(123);

        try {
            srvProposalsV01.createExternalFinancingProposal(DummyMock.THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);

            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.WRONG_PARAMETERS, e.getErrorCode());
        }
    }

    @Test
    public void testCreateExternalFinancingProposalInvalidSizeDeliveryEmail() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = dummyMock.getExternalFinancingProposal();
        externalFinancingProposal.getDelivery().setEmail("123456789012345678901234567890123456789012345678901");

        try {
            srvProposalsV01.createExternalFinancingProposal(DummyMock.THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);

            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.WRONG_PARAMETERS, e.getErrorCode());
        }
    }

    @Test
    public void testCreateExternalFinancingProposalInvalidSizeOperationId() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = dummyMock.getExternalFinancingProposal();
        externalFinancingProposal.getOperation().setId("123456789012345678901234567890123");

        try {
            srvProposalsV01.createExternalFinancingProposal(DummyMock.THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);

            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.WRONG_PARAMETERS, e.getErrorCode());
        }
    }

    @Test
    public void testCreateExternalFinancingProposalInvalidSizeThirdPartyProviderId() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = dummyMock.getExternalFinancingProposal();
        externalFinancingProposal.getThirdPartyProvider().setId("TDPE1");

        try {
            srvProposalsV01.createExternalFinancingProposal(DummyMock.THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);

            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.WRONG_PARAMETERS, e.getErrorCode());
        }
    }

    @Test
    public void testCreateExternalFinancingProposalInvalidSizeThirdPartyProviderExternalChannelSalesId() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = dummyMock.getExternalFinancingProposal();
        externalFinancingProposal.getThirdPartyProvider().getExternalSalesChannel().setId("CEC178876");

        try {
            srvProposalsV01.createExternalFinancingProposal(DummyMock.THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);

            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.WRONG_PARAMETERS, e.getErrorCode());
        }
    }

    @Test
    public void testCreateExternalFinancingProposalInvalidSizeOperationTypeId() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = dummyMock.getExternalFinancingProposal();
        externalFinancingProposal.getOperation().getOperationType().setId("ALTA12");

        try {
            srvProposalsV01.createExternalFinancingProposal(DummyMock.THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);

            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.WRONG_PARAMETERS, e.getErrorCode());
        }
    }

    @Test
    public void testCreateExternalFinancingProposalInvalidSizeExternalProductId() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = dummyMock.getExternalFinancingProposal();
        externalFinancingProposal.getExternalProduct().setId("1234567890123456");

        try {
            srvProposalsV01.createExternalFinancingProposal(DummyMock.THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);

            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.WRONG_PARAMETERS, e.getErrorCode());
        }
    }

    @Test
    public void testCreateExternalFinancingProposalInvalidSizeIntegerExternalProductCommercialValue() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = dummyMock.getExternalFinancingProposal();
        externalFinancingProposal.getExternalProduct().getCommercialValue().setAmount(new BigDecimal("1234567890123456.89"));

        try {
            srvProposalsV01.createExternalFinancingProposal(DummyMock.THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);

            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.WRONG_PARAMETERS, e.getErrorCode());
        }
    }

    @Test
    public void testCreateExternalFinancingProposalInvalidSizeFractionExternalProductCommercialValue() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = dummyMock.getExternalFinancingProposal();
        externalFinancingProposal.getExternalProduct().getCommercialValue().setAmount(new BigDecimal("123456789012345.897"));

        try {
            srvProposalsV01.createExternalFinancingProposal(DummyMock.THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);

            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.WRONG_PARAMETERS, e.getErrorCode());
        }
    }

    @Test
    public void testCreateExternalFinancingProposalInvalidSizeExternalProductCommercialValueCurrency() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = dummyMock.getExternalFinancingProposal();
        externalFinancingProposal.getExternalProduct().getCommercialValue().setCurrency("1234");

        try {
            srvProposalsV01.createExternalFinancingProposal(DummyMock.THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);

            fail();
        } catch (BusinessServiceException e) {
            assertEquals(Errors.WRONG_PARAMETERS, e.getErrorCode());
        }
    }
}