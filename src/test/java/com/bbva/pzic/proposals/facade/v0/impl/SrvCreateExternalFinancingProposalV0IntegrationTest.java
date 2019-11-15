package com.bbva.pzic.proposals.facade.v0.impl;

import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.jee.arq.spring.core.servicing.test.BusinessServiceTestContextLoader;
import com.bbva.jee.arq.spring.core.servicing.test.MockInvocationContextTestExecutionListener;
import com.bbva.pzic.proposals.EntityStubs;
import com.bbva.pzic.proposals.canonic.ExternalFinancingProposal;
import com.bbva.pzic.proposals.dao.model.ugap.mock.TransaccionUgapMock;
import com.bbva.pzic.utilTest.BusinessServiceExceptionMatcher;
import com.bbva.pzic.utilTest.UriInfoImpl;
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

import javax.ws.rs.core.UriInfo;
import java.io.IOException;
import java.math.BigDecimal;

import static com.bbva.pzic.proposals.EntityStubs.THIRD_PARTY_PROVIDER_USER_ID;
import static com.bbva.pzic.proposals.util.Errors.MANDATORY_PARAMETERS_MISSING;
import static com.bbva.pzic.proposals.util.Errors.WRONG_PARAMETERS;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

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
public class SrvCreateExternalFinancingProposalV0IntegrationTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Autowired
    private SrvProposalsV0 srvProposalsV0;

    private EntityStubs entityStubs = EntityStubs.getInstance();

    @Before
    public void setUp() {
        UriInfo uriInfo = new UriInfoImpl();
        uriInfo.getPathParameters().add("external-financing-proposal-id", "external-financing-proposal-id");
        srvProposalsV0.setUriInfo(uriInfo);
    }

    @Test
    public void testCreateExternalFinancingProposal() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = entityStubs.getExternalFinancingProposal();

        ExternalFinancingProposal response = srvProposalsV0.createExternalFinancingProposal(THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);

        assertNotNull(response);
        assertNotNull(response.getId());
    }

    @Test
    public void testCreateExternalFinancingProposalOnlyMandatory() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = entityStubs.getExternalFinancingProposal();

        ExternalFinancingProposal response = srvProposalsV0.createExternalFinancingProposal(null, externalFinancingProposal);

        assertNotNull(response);
        assertNotNull(response.getId());
    }

    @Test
    public void testCreateExternalFinancingProposalWithoutResponse() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = entityStubs.getExternalFinancingProposal();
        externalFinancingProposal.getHolder().getIdentityDocuments().get(0).setDocumentNumber(TransaccionUgapMock.NRO_DOCUMENTO);

        ExternalFinancingProposal response = srvProposalsV0.createExternalFinancingProposal(THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);

        assertNotNull(response);
        assertNull(response.getId());
    }

    /*
    Validaciones de Obligatoriedad
    */
    /*
    externalProduct.id
     */
    @Test
    public void testCreateExternalFinancingProposalWithOutExternalProductId() throws IOException {
        expectedException.expect(BusinessServiceException.class);
        expectedException.expect(BusinessServiceExceptionMatcher.hasErrorCode(MANDATORY_PARAMETERS_MISSING));

        ExternalFinancingProposal externalFinancingProposal = entityStubs.getExternalFinancingProposal();
        externalFinancingProposal.getExternalProduct().setId(null);

        srvProposalsV0.createExternalFinancingProposal(THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);

    }

    /*
    externalProduct.commercialValue
     */
    @Test
    public void testCreateExternalFinancingProposalWithOutExternalProductCommercialValue() throws IOException {
        expectedException.expect(BusinessServiceException.class);
        expectedException.expect(BusinessServiceExceptionMatcher.hasErrorCode(MANDATORY_PARAMETERS_MISSING));

        ExternalFinancingProposal externalFinancingProposal = entityStubs.getExternalFinancingProposal();
        externalFinancingProposal.getExternalProduct().setCommercialValue(null);

        srvProposalsV0.createExternalFinancingProposal(THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);

    }

    /*
    externalProduct.commercialValue.amount
     */
    @Test
    public void testCreateExternalFinancingProposalWithOutExternalProductCommercialAmountValue() throws IOException {
        expectedException.expect(BusinessServiceException.class);
        expectedException.expect(BusinessServiceExceptionMatcher.hasErrorCode(MANDATORY_PARAMETERS_MISSING));

        ExternalFinancingProposal externalFinancingProposal = entityStubs.getExternalFinancingProposal();
        externalFinancingProposal.getExternalProduct().getCommercialValue().setAmount(null);

        srvProposalsV0.createExternalFinancingProposal(THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);
    }

    /*
    externalProduct.commercialValue.currency
     */
    @Test
    public void testCreateExternalFinancingProposalWithOutExternalProductCommercialValueCurrency() throws IOException {
        expectedException.expect(BusinessServiceException.class);
        expectedException.expect(BusinessServiceExceptionMatcher.hasErrorCode(MANDATORY_PARAMETERS_MISSING));

        ExternalFinancingProposal externalFinancingProposal = entityStubs.getExternalFinancingProposal();
        externalFinancingProposal.getExternalProduct().getCommercialValue().setCurrency(null);
        srvProposalsV0.createExternalFinancingProposal(THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);

    }

    /*
    holder
    */
    @Test
    public void testCreateExternalFinancingProposalWithOutHolder() throws IOException {
        expectedException.expect(BusinessServiceException.class);
        expectedException.expect(BusinessServiceExceptionMatcher.hasErrorCode(MANDATORY_PARAMETERS_MISSING));

        ExternalFinancingProposal externalFinancingProposal = entityStubs.getExternalFinancingProposal();
        externalFinancingProposal.setHolder(null);

        srvProposalsV0.createExternalFinancingProposal(THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);

    }

    /*
    holder.identityDocuments
    */
    @Test
    public void testCreateExternalFinancingProposalWithOutHolderIdentityDocuments() throws IOException {
        expectedException.expect(BusinessServiceException.class);
        expectedException.expect(BusinessServiceExceptionMatcher.hasErrorCode(MANDATORY_PARAMETERS_MISSING));

        ExternalFinancingProposal externalFinancingProposal = entityStubs.getExternalFinancingProposal();
        externalFinancingProposal.getHolder().setIdentityDocuments(null);

        srvProposalsV0.createExternalFinancingProposal(THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);

    }

    /*
    holder.identityDocuments
    */
    @Test
    public void testCreateExternalFinancingProposalWithOutHolderIdentityDocumentItems() throws IOException {
        expectedException.expect(BusinessServiceException.class);
        expectedException.expect(BusinessServiceExceptionMatcher.hasErrorCode(MANDATORY_PARAMETERS_MISSING));

        ExternalFinancingProposal externalFinancingProposal = entityStubs.getExternalFinancingProposal();
        externalFinancingProposal.getHolder().getIdentityDocuments().clear();
        externalFinancingProposal.getHolder().getIdentityDocuments().add(null);

        srvProposalsV0.createExternalFinancingProposal(THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);

    }

    /*
    holder.identityDocuments[0].documentNumber
    */
    @Test
    public void testCreateExternalFinancingProposalWithOutHolderIdentityDocumentNumber() throws IOException {
        expectedException.expect(BusinessServiceException.class);
        expectedException.expect(BusinessServiceExceptionMatcher.hasErrorCode(MANDATORY_PARAMETERS_MISSING));

        ExternalFinancingProposal externalFinancingProposal = entityStubs.getExternalFinancingProposal();
        externalFinancingProposal.getHolder().getIdentityDocuments().get(0).setDocumentNumber(null);

        srvProposalsV0.createExternalFinancingProposal(THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);

    }

    /*
    holder.identityDocuments[0].documentType
    */
    @Test
    public void testCreateExternalFinancingProposalWithOutHolderIdentityDocumentType() throws IOException {
        expectedException.expect(BusinessServiceException.class);
        expectedException.expect(BusinessServiceExceptionMatcher.hasErrorCode(MANDATORY_PARAMETERS_MISSING));

        ExternalFinancingProposal externalFinancingProposal = entityStubs.getExternalFinancingProposal();
        externalFinancingProposal.getHolder().getIdentityDocuments().get(0).setDocumentType(null);

        srvProposalsV0.createExternalFinancingProposal(THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);

    }

    /*
    holder.identityDocuments[0].documentType.id
    */
    @Test
    public void testCreateExternalFinancingProposalWithOutHolderIdentityDocumentTypeId() throws IOException {
        expectedException.expect(BusinessServiceException.class);
        expectedException.expect(BusinessServiceExceptionMatcher.hasErrorCode(MANDATORY_PARAMETERS_MISSING));

        ExternalFinancingProposal externalFinancingProposal = entityStubs.getExternalFinancingProposal();
        externalFinancingProposal.getHolder().getIdentityDocuments().get(0).getDocumentType().setId(null);

        srvProposalsV0.createExternalFinancingProposal(THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);

    }

    /*
    tariff
    */
    @Test
    public void testCreateExternalFinancingProposalWithOutTariff() throws IOException {
        expectedException.expect(BusinessServiceException.class);
        expectedException.expect(BusinessServiceExceptionMatcher.hasErrorCode(MANDATORY_PARAMETERS_MISSING));

        ExternalFinancingProposal externalFinancingProposal = entityStubs.getExternalFinancingProposal();
        externalFinancingProposal.setTariff(null);

        srvProposalsV0.createExternalFinancingProposal(THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);

    }

    /*
    tariff.id
    */
    @Test
    public void testCreateExternalFinancingProposalWithOutTariffId() throws IOException {
        expectedException.expect(BusinessServiceException.class);
        expectedException.expect(BusinessServiceExceptionMatcher.hasErrorCode(MANDATORY_PARAMETERS_MISSING));

        ExternalFinancingProposal externalFinancingProposal = entityStubs.getExternalFinancingProposal();
        externalFinancingProposal.getTariff().setId(null);

        srvProposalsV0.createExternalFinancingProposal(THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);

    }

    /*
    currency
    */
    @Test
    public void testCreateExternalFinancingProposalWithOutCurrency() throws IOException {
        expectedException.expect(BusinessServiceException.class);
        expectedException.expect(BusinessServiceExceptionMatcher.hasErrorCode(MANDATORY_PARAMETERS_MISSING));

        ExternalFinancingProposal externalFinancingProposal = entityStubs.getExternalFinancingProposal();
        externalFinancingProposal.setCurrency(null);

        srvProposalsV0.createExternalFinancingProposal(THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);

    }

    /*
    operation.operationType.id
     */
    @Test
    public void testCreateExternalFinancingProposalWithOutOperationTypeId() throws IOException {
        expectedException.expect(BusinessServiceException.class);
        expectedException.expect(BusinessServiceExceptionMatcher.hasErrorCode(MANDATORY_PARAMETERS_MISSING));

        ExternalFinancingProposal externalFinancingProposal = entityStubs.getExternalFinancingProposal();
        externalFinancingProposal.getOperation().getOperationType().setId(null);

        srvProposalsV0.createExternalFinancingProposal(THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);

    }

    @Test
    public void testCreateExternalFinancingProposalWithOutBranch() throws IOException {
        expectedException.expect(BusinessServiceException.class);
        expectedException.expect(BusinessServiceExceptionMatcher.hasErrorCode(MANDATORY_PARAMETERS_MISSING));

        ExternalFinancingProposal externalFinancingProposal = entityStubs.getExternalFinancingProposal();
        externalFinancingProposal.setBranch(null);

        srvProposalsV0.createExternalFinancingProposal(THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);
    }

    /*
    branch.id
    */
    @Test
    public void testCreateExternalFinancingProposalWithOutBranchId() throws IOException {
        expectedException.expect(BusinessServiceException.class);
        expectedException.expect(BusinessServiceExceptionMatcher.hasErrorCode(MANDATORY_PARAMETERS_MISSING));

        ExternalFinancingProposal externalFinancingProposal = entityStubs.getExternalFinancingProposal();
        externalFinancingProposal.getBranch().setId(null);

        srvProposalsV0.createExternalFinancingProposal(THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);

    }

    /*
    thirdPartyProvider.externalSalesChannel.
    */
    @Test
    public void testCreateExternalFinancingProposalWithOutExternalSalesChannel() throws IOException {
        expectedException.expect(BusinessServiceException.class);
        expectedException.expect(BusinessServiceExceptionMatcher.hasErrorCode(MANDATORY_PARAMETERS_MISSING));

        ExternalFinancingProposal externalFinancingProposal = entityStubs.getExternalFinancingProposal();
        externalFinancingProposal.getThirdPartyProvider().setExternalSalesChannel(null);

        srvProposalsV0.createExternalFinancingProposal(THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);

    }

    /*
    thirdPartyProvider.externalSalesChannel.id
    */
    @Test
    public void testCreateExternalFinancingProposalWithOutExternalSalesChannelId() throws IOException {
        expectedException.expect(BusinessServiceException.class);
        expectedException.expect(BusinessServiceExceptionMatcher.hasErrorCode(MANDATORY_PARAMETERS_MISSING));

        ExternalFinancingProposal externalFinancingProposal = entityStubs.getExternalFinancingProposal();
        externalFinancingProposal.getThirdPartyProvider().getExternalSalesChannel().setId(null);

        srvProposalsV0.createExternalFinancingProposal(THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);

    }

    @Test
    public void testCreateExternalFinancingProposalWithOutInitial() throws IOException {
        expectedException.expect(BusinessServiceException.class);
        expectedException.expect(BusinessServiceExceptionMatcher.hasErrorCode(MANDATORY_PARAMETERS_MISSING));

        ExternalFinancingProposal externalFinancingProposal = entityStubs.getExternalFinancingProposal();
        externalFinancingProposal.setInitialAmount(null);

        srvProposalsV0.createExternalFinancingProposal(THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);

    }

    @Test
    public void testCreateExternalFinancingProposalWithOutInitialAmount() throws IOException {
        expectedException.expect(BusinessServiceException.class);
        expectedException.expect(BusinessServiceExceptionMatcher.hasErrorCode(MANDATORY_PARAMETERS_MISSING));

        ExternalFinancingProposal externalFinancingProposal = entityStubs.getExternalFinancingProposal();
        externalFinancingProposal.getInitialAmount().setAmount(null);

        srvProposalsV0.createExternalFinancingProposal(THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);

    }

    @Test
    public void testCreateExternalFinancingProposalWithOutInitialAmountCurrency() throws IOException {
        expectedException.expect(BusinessServiceException.class);
        expectedException.expect(BusinessServiceExceptionMatcher.hasErrorCode(MANDATORY_PARAMETERS_MISSING));

        ExternalFinancingProposal externalFinancingProposal = entityStubs.getExternalFinancingProposal();
        externalFinancingProposal.getInitialAmount().setCurrency(null);

        srvProposalsV0.createExternalFinancingProposal(THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);
    }

    @Test
    public void testCreateExternalFinancingProposalWithOutPaymentDay() throws IOException {
        expectedException.expect(BusinessServiceException.class);
        expectedException.expect(BusinessServiceExceptionMatcher.hasErrorCode(MANDATORY_PARAMETERS_MISSING));

        ExternalFinancingProposal externalFinancingProposal = entityStubs.getExternalFinancingProposal();
        externalFinancingProposal.setPaymentDay(null);

        srvProposalsV0.createExternalFinancingProposal(THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);
    }

    @Test
    public void testCreateExternalFinancingProposalWithOutBillingDay() throws IOException {
        expectedException.expect(BusinessServiceException.class);
        expectedException.expect(BusinessServiceExceptionMatcher.hasErrorCode(MANDATORY_PARAMETERS_MISSING));

        ExternalFinancingProposal externalFinancingProposal = entityStubs.getExternalFinancingProposal();
        externalFinancingProposal.setBillingDay(null);

        srvProposalsV0.createExternalFinancingProposal(THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);
    }

    @Test
    public void testCreateExternalFinancingProposalWithOutDelivery() throws IOException {
        expectedException.expect(BusinessServiceException.class);
        expectedException.expect(BusinessServiceExceptionMatcher.hasErrorCode(MANDATORY_PARAMETERS_MISSING));

        ExternalFinancingProposal externalFinancingProposal = entityStubs.getExternalFinancingProposal();
        externalFinancingProposal.setDelivery(null);

        srvProposalsV0.createExternalFinancingProposal(THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);
    }

    @Test
    public void testCreateExternalFinancingProposalWithOutDeliveryType() throws IOException {
        expectedException.expect(BusinessServiceException.class);
        expectedException.expect(BusinessServiceExceptionMatcher.hasErrorCode(MANDATORY_PARAMETERS_MISSING));

        ExternalFinancingProposal externalFinancingProposal = entityStubs.getExternalFinancingProposal();
        externalFinancingProposal.getDelivery().setDeliveryType(null);

        srvProposalsV0.createExternalFinancingProposal(THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);
    }

    @Test
    public void testCreateExternalFinancingProposalWithOutDeliveryTypeId() throws IOException {
        expectedException.expect(BusinessServiceException.class);
        expectedException.expect(BusinessServiceExceptionMatcher.hasErrorCode(MANDATORY_PARAMETERS_MISSING));

        ExternalFinancingProposal externalFinancingProposal = entityStubs.getExternalFinancingProposal();
        externalFinancingProposal.getDelivery().getDeliveryType().setId(null);

        srvProposalsV0.createExternalFinancingProposal(THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);
    }

    @Test
    public void testCreateExternalFinancingProposalWithOutDeliveryEmail() throws IOException {
        expectedException.expect(BusinessServiceException.class);
        expectedException.expect(BusinessServiceExceptionMatcher.hasErrorCode(MANDATORY_PARAMETERS_MISSING));

        ExternalFinancingProposal externalFinancingProposal = entityStubs.getExternalFinancingProposal();
        externalFinancingProposal.getDelivery().setEmail(null);

        srvProposalsV0.createExternalFinancingProposal(THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);
    }

    @Test
    public void testCreateExternalFinancingProposalWithOutOperation() throws IOException {
        expectedException.expect(BusinessServiceException.class);
        expectedException.expect(BusinessServiceExceptionMatcher.hasErrorCode(MANDATORY_PARAMETERS_MISSING));

        ExternalFinancingProposal externalFinancingProposal = entityStubs.getExternalFinancingProposal();
        externalFinancingProposal.setOperation(null);

        srvProposalsV0.createExternalFinancingProposal(THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);
    }

    @Test
    public void testCreateExternalFinancingProposalWithOutOperationId() throws IOException {
        expectedException.expect(BusinessServiceException.class);
        expectedException.expect(BusinessServiceExceptionMatcher.hasErrorCode(MANDATORY_PARAMETERS_MISSING));

        ExternalFinancingProposal externalFinancingProposal = entityStubs.getExternalFinancingProposal();
        externalFinancingProposal.getOperation().setId(null);

        srvProposalsV0.createExternalFinancingProposal(THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);
    }

    @Test
    public void testCreateExternalFinancingProposalWithOutThirdPartyProvider() throws IOException {
        expectedException.expect(BusinessServiceException.class);
        expectedException.expect(BusinessServiceExceptionMatcher.hasErrorCode(MANDATORY_PARAMETERS_MISSING));

        ExternalFinancingProposal externalFinancingProposal = entityStubs.getExternalFinancingProposal();
        externalFinancingProposal.setThirdPartyProvider(null);

        srvProposalsV0.createExternalFinancingProposal(THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);
    }

    @Test
    public void testCreateExternalFinancingProposalWithOutThirdPartyProviderId() throws IOException {
        expectedException.expect(BusinessServiceException.class);
        expectedException.expect(BusinessServiceExceptionMatcher.hasErrorCode(MANDATORY_PARAMETERS_MISSING));

        ExternalFinancingProposal externalFinancingProposal = entityStubs.getExternalFinancingProposal();
        externalFinancingProposal.getThirdPartyProvider().setId(null);

        srvProposalsV0.createExternalFinancingProposal(THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);
    }

    @Test
    public void testCreateExternalFinancingProposalInvalidSizeHolderIdentityDocumentNumber() throws IOException {
        expectedException.expect(BusinessServiceException.class);
        expectedException.expect(BusinessServiceExceptionMatcher.hasErrorCode(WRONG_PARAMETERS));

        ExternalFinancingProposal externalFinancingProposal = entityStubs.getExternalFinancingProposal();
        externalFinancingProposal.getHolder().getIdentityDocuments().get(0).setDocumentNumber("12345678901");

        srvProposalsV0.createExternalFinancingProposal(THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);
    }

    @Test
    public void testCreateExternalFinancingProposalInvalidSizeTariffId() throws IOException {
        expectedException.expect(BusinessServiceException.class);
        expectedException.expect(BusinessServiceExceptionMatcher.hasErrorCode(WRONG_PARAMETERS));

        ExternalFinancingProposal externalFinancingProposal = entityStubs.getExternalFinancingProposal();
        externalFinancingProposal.getTariff().setId("12345678901");

        srvProposalsV0.createExternalFinancingProposal(THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);
    }

    @Test
    public void testCreateExternalFinancingProposalInvalidSizeThirdPartyProviderUserId() throws IOException {
        expectedException.expect(BusinessServiceException.class);
        expectedException.expect(BusinessServiceExceptionMatcher.hasErrorCode(WRONG_PARAMETERS));

        ExternalFinancingProposal externalFinancingProposal = entityStubs.getExternalFinancingProposal();

        srvProposalsV0.createExternalFinancingProposal("12345678901576586567565476546545646543653543564354356435463653654323498676", externalFinancingProposal);
    }

    @Test
    public void testCreateExternalFinancingProposalInvalidSizeBranchId() throws IOException {
        expectedException.expect(BusinessServiceException.class);
        expectedException.expect(BusinessServiceExceptionMatcher.hasErrorCode(WRONG_PARAMETERS));

        ExternalFinancingProposal externalFinancingProposal = entityStubs.getExternalFinancingProposal();
        externalFinancingProposal.getBranch().setId("12345678901");

        srvProposalsV0.createExternalFinancingProposal(THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);
    }

    @Test
    public void testCreateExternalFinancingProposalInvalidSizeCurrency() throws IOException {
        expectedException.expect(BusinessServiceException.class);
        expectedException.expect(BusinessServiceExceptionMatcher.hasErrorCode(WRONG_PARAMETERS));

        ExternalFinancingProposal externalFinancingProposal = entityStubs.getExternalFinancingProposal();
        externalFinancingProposal.setCurrency("1234");

        srvProposalsV0.createExternalFinancingProposal(THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);
    }

    @Test
    public void testCreateExternalFinancingProposalInvalidSizeFractionInitialAmount() throws IOException {
        expectedException.expect(BusinessServiceException.class);
        expectedException.expect(BusinessServiceExceptionMatcher.hasErrorCode(WRONG_PARAMETERS));

        ExternalFinancingProposal externalFinancingProposal = entityStubs.getExternalFinancingProposal();
        externalFinancingProposal.getInitialAmount().setAmount(new BigDecimal("789.856"));

        srvProposalsV0.createExternalFinancingProposal(THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);
    }

    @Test
    public void testCreateExternalFinancingProposalInvalidSizeIntegerInitialAmount() throws IOException {
        expectedException.expect(BusinessServiceException.class);
        expectedException.expect(BusinessServiceExceptionMatcher.hasErrorCode(WRONG_PARAMETERS));

        ExternalFinancingProposal externalFinancingProposal = entityStubs.getExternalFinancingProposal();
        externalFinancingProposal.getInitialAmount().setAmount(new BigDecimal("1234567890123456.85"));

        srvProposalsV0.createExternalFinancingProposal(THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);
    }

    @Test
    public void testCreateExternalFinancingProposalInvalidSizeInitialAmountCurrency() throws IOException {
        expectedException.expect(BusinessServiceException.class);
        expectedException.expect(BusinessServiceExceptionMatcher.hasErrorCode(WRONG_PARAMETERS));

        ExternalFinancingProposal externalFinancingProposal = entityStubs.getExternalFinancingProposal();
        externalFinancingProposal.getInitialAmount().setCurrency("1234");

        srvProposalsV0.createExternalFinancingProposal(THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);
    }

    @Test
    public void testCreateExternalFinancingProposalInvalidSizePaymentDay() throws IOException {
        expectedException.expect(BusinessServiceException.class);
        expectedException.expect(BusinessServiceExceptionMatcher.hasErrorCode(WRONG_PARAMETERS));

        ExternalFinancingProposal externalFinancingProposal = entityStubs.getExternalFinancingProposal();
        externalFinancingProposal.setPaymentDay(123);

        srvProposalsV0.createExternalFinancingProposal(THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);
    }

    @Test
    public void testCreateExternalFinancingProposalInvalidSizeDeliveryEmail() throws IOException {
        expectedException.expect(BusinessServiceException.class);
        expectedException.expect(BusinessServiceExceptionMatcher.hasErrorCode(WRONG_PARAMETERS));

        ExternalFinancingProposal externalFinancingProposal = entityStubs.getExternalFinancingProposal();
        externalFinancingProposal.getDelivery().setEmail("123456789012345678901234567890123456789012345678901");

        srvProposalsV0.createExternalFinancingProposal(THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);
    }

    @Test
    public void testCreateExternalFinancingProposalInvalidSizeOperationId() throws IOException {
        expectedException.expect(BusinessServiceException.class);
        expectedException.expect(BusinessServiceExceptionMatcher.hasErrorCode(WRONG_PARAMETERS));

        ExternalFinancingProposal externalFinancingProposal = entityStubs.getExternalFinancingProposal();
        externalFinancingProposal.getOperation().setId("123456789012345678901234567890123");

        srvProposalsV0.createExternalFinancingProposal(THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);
    }

    @Test
    public void testCreateExternalFinancingProposalInvalidSizeThirdPartyProviderId() throws IOException {
        expectedException.expect(BusinessServiceException.class);
        expectedException.expect(BusinessServiceExceptionMatcher.hasErrorCode(WRONG_PARAMETERS));

        ExternalFinancingProposal externalFinancingProposal = entityStubs.getExternalFinancingProposal();
        externalFinancingProposal.getThirdPartyProvider().setId("TDPE1");

        srvProposalsV0.createExternalFinancingProposal(THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);

    }

    @Test
    public void testCreateExternalFinancingProposalInvalidSizeThirdPartyProviderExternalChannelSalesId() throws IOException {
        expectedException.expect(BusinessServiceException.class);
        expectedException.expect(BusinessServiceExceptionMatcher.hasErrorCode(WRONG_PARAMETERS));

        ExternalFinancingProposal externalFinancingProposal = entityStubs.getExternalFinancingProposal();
        externalFinancingProposal.getThirdPartyProvider().getExternalSalesChannel().setId("CEC178876");

        srvProposalsV0.createExternalFinancingProposal(THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);
    }

    @Test
    public void testCreateExternalFinancingProposalInvalidSizeOperationTypeId() throws IOException {
        expectedException.expect(BusinessServiceException.class);
        expectedException.expect(BusinessServiceExceptionMatcher.hasErrorCode(WRONG_PARAMETERS));

        ExternalFinancingProposal externalFinancingProposal = entityStubs.getExternalFinancingProposal();
        externalFinancingProposal.getOperation().getOperationType().setId("ALTA12");

        srvProposalsV0.createExternalFinancingProposal(THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);
    }

    @Test
    public void testCreateExternalFinancingProposalInvalidSizeExternalProductId() throws IOException {
        expectedException.expect(BusinessServiceException.class);
        expectedException.expect(BusinessServiceExceptionMatcher.hasErrorCode(WRONG_PARAMETERS));

        ExternalFinancingProposal externalFinancingProposal = entityStubs.getExternalFinancingProposal();
        externalFinancingProposal.getExternalProduct().setId("1234567890123456");

        srvProposalsV0.createExternalFinancingProposal(THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);
    }

    @Test
    public void testCreateExternalFinancingProposalInvalidSizeIntegerExternalProductCommercialValue() throws IOException {
        expectedException.expect(BusinessServiceException.class);
        expectedException.expect(BusinessServiceExceptionMatcher.hasErrorCode(WRONG_PARAMETERS));

        ExternalFinancingProposal externalFinancingProposal = entityStubs.getExternalFinancingProposal();
        externalFinancingProposal.getExternalProduct().getCommercialValue().setAmount(new BigDecimal("1234567890123456.89"));

        srvProposalsV0.createExternalFinancingProposal(THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);
    }

    @Test
    public void testCreateExternalFinancingProposalInvalidSizeFractionExternalProductCommercialValue() throws IOException {
        expectedException.expect(BusinessServiceException.class);
        expectedException.expect(BusinessServiceExceptionMatcher.hasErrorCode(WRONG_PARAMETERS));

        ExternalFinancingProposal externalFinancingProposal = entityStubs.getExternalFinancingProposal();
        externalFinancingProposal.getExternalProduct().getCommercialValue().setAmount(new BigDecimal("123456789012345.897"));

        srvProposalsV0.createExternalFinancingProposal(THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);
    }

    @Test
    public void testCreateExternalFinancingProposalInvalidSizeExternalProductCommercialValueCurrency() throws IOException {
        expectedException.expect(BusinessServiceException.class);
        expectedException.expect(BusinessServiceExceptionMatcher.hasErrorCode(WRONG_PARAMETERS));

        ExternalFinancingProposal externalFinancingProposal = entityStubs.getExternalFinancingProposal();
        externalFinancingProposal.getExternalProduct().getCommercialValue().setCurrency("1234");

        srvProposalsV0.createExternalFinancingProposal(THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);
    }

    @Test
    public void testCreateExternalFinancingProposalInvalidSizeBillingDay() throws IOException {
        expectedException.expect(BusinessServiceException.class);
        expectedException.expect(BusinessServiceExceptionMatcher.hasErrorCode(WRONG_PARAMETERS));

        ExternalFinancingProposal externalFinancingProposal = entityStubs.getExternalFinancingProposal();
        externalFinancingProposal.setBillingDay(544);

        srvProposalsV0.createExternalFinancingProposal(THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);
    }
}
