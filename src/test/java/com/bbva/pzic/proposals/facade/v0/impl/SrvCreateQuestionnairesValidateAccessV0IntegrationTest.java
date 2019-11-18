package com.bbva.pzic.proposals.facade.v0.impl;

import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponse;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.jee.arq.spring.core.servicing.test.BusinessServiceTestContextLoader;
import com.bbva.jee.arq.spring.core.servicing.test.MockInvocationContextTestExecutionListener;
import com.bbva.pzic.proposals.EntityStubs;
import com.bbva.pzic.proposals.facade.v0.ISrvProposalsV0;
import com.bbva.pzic.proposals.facade.v0.dto.ValidateAccess;
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

import java.io.IOException;

import static com.bbva.pzic.proposals.util.Errors.MANDATORY_PARAMETERS_MISSING;
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
    public void createQuestionnairesValidateAccessTest() throws IOException {
        ServiceResponse<ValidateAccess> result = srvProposalsV0.createQuestionnairesValidateAccess(
                EntityStubs.getInstance().getValidateAccess());

        assertNotNull(result.getData());
    }

    @Test
    public void createQuestionnairesValidateAccessWithoutParticipantTest() throws IOException {
        expectedException.expect(BusinessServiceException.class);
        expectedException.expect(BusinessServiceExceptionMatcher.hasErrorCode(MANDATORY_PARAMETERS_MISSING));

        ValidateAccess payload = EntityStubs.getInstance().getValidateAccess();
        payload.setParticipant(null);

        srvProposalsV0.createQuestionnairesValidateAccess(payload);
    }

    @Test
    public void createQuestionnairesValidateAccessWithoutParticipantIdTest() throws IOException {
        expectedException.expect(BusinessServiceException.class);
        expectedException.expect(BusinessServiceExceptionMatcher.hasErrorCode(MANDATORY_PARAMETERS_MISSING));

        ValidateAccess payload = EntityStubs.getInstance().getValidateAccess();
        payload.getParticipant().setId(null);

        srvProposalsV0.createQuestionnairesValidateAccess(payload);
    }

    @Test
    public void createQuestionnairesValidateAccessWithoutParticipantIdentityDocumentTest() throws IOException {
        ValidateAccess payload = EntityStubs.getInstance().getValidateAccess();
        payload.getParticipant().setIdentityDocument(null);

        ServiceResponse<ValidateAccess> result = srvProposalsV0.createQuestionnairesValidateAccess(payload);

        assertNotNull(result.getData());
    }

    @Test
    public void createQuestionnairesValidateAccessWithoutParticipantIdentityDocumentDocumentTypeTest() throws IOException {
        expectedException.expect(BusinessServiceException.class);
        expectedException.expect(BusinessServiceExceptionMatcher.hasErrorCode(MANDATORY_PARAMETERS_MISSING));

        ValidateAccess payload = EntityStubs.getInstance().getValidateAccess();
        payload.getParticipant().getIdentityDocument().setDocumentType(null);

        srvProposalsV0.createQuestionnairesValidateAccess(payload);
    }

    @Test
    public void createQuestionnairesValidateAccessWithoutParticipantIdentityDocumentDocumentTypeIdTest() throws IOException {
        expectedException.expect(BusinessServiceException.class);
        expectedException.expect(BusinessServiceExceptionMatcher.hasErrorCode(MANDATORY_PARAMETERS_MISSING));

        ValidateAccess payload = EntityStubs.getInstance().getValidateAccess();
        payload.getParticipant().getIdentityDocument().getDocumentType().setId(null);

        srvProposalsV0.createQuestionnairesValidateAccess(payload);
    }

    @Test
    public void createQuestionnairesValidateAccessWithoutParticipantIdentityDocumentDocumentNumberTest() throws IOException {
        expectedException.expect(BusinessServiceException.class);
        expectedException.expect(BusinessServiceExceptionMatcher.hasErrorCode(MANDATORY_PARAMETERS_MISSING));

        ValidateAccess payload = EntityStubs.getInstance().getValidateAccess();
        payload.getParticipant().getIdentityDocument().setDocumentNumber(null);

        srvProposalsV0.createQuestionnairesValidateAccess(payload);
    }

    @Test
    public void createQuestionnairesValidateAccessWithoutParticipantContactsTest() throws IOException {
        ValidateAccess payload = EntityStubs.getInstance().getValidateAccess();
        payload.getParticipant().setContacts(null);

        ServiceResponse<ValidateAccess> result = srvProposalsV0.createQuestionnairesValidateAccess(payload);

        assertNotNull(result.getData());
    }

    @Test
    public void createQuestionnairesValidateAccessWithoutParticipantContactsMobileContactDetailTypeTest() throws IOException {
        expectedException.expect(BusinessServiceException.class);
        expectedException.expect(BusinessServiceExceptionMatcher.hasErrorCode(MANDATORY_PARAMETERS_MISSING));

        ValidateAccess payload = EntityStubs.getInstance().getValidateAccess();
        payload.getParticipant().getContacts().get(0).setContactDetailType(null);

        srvProposalsV0.createQuestionnairesValidateAccess(payload);
    }

    @Test
    public void createQuestionnairesValidateAccessWithoutParticipantContactsMobileNumberTest() throws IOException {
        expectedException.expect(BusinessServiceException.class);
        expectedException.expect(BusinessServiceExceptionMatcher.hasErrorCode(MANDATORY_PARAMETERS_MISSING));

        ValidateAccess payload = EntityStubs.getInstance().getValidateAccess();
        payload.getParticipant().getContacts().get(0).setNumber(null);

        srvProposalsV0.createQuestionnairesValidateAccess(payload);
    }

    @Test
    public void createQuestionnairesValidateAccessWithoutParticipantContactsMobilePhoneCompanyTest() throws IOException {
        ValidateAccess payload = EntityStubs.getInstance().getValidateAccess();
        payload.getParticipant().getContacts().get(0).setPhoneCompany(null);

        ServiceResponse<ValidateAccess> result = srvProposalsV0.createQuestionnairesValidateAccess(payload);

        assertNotNull(result);
    }
    // TODO
//    @Test
//    public void createQuestionnairesValidateAccessWithoutParticipantContactsMobilePhoneCompanyIdTest() throws IOException {
//        expectedException.expect(BusinessServiceException.class);
//        expectedException.expect(BusinessServiceExceptionMatcher.hasErrorCode(MANDATORY_PARAMETERS_MISSING));
//
//        ValidateAccess payload = EntityStubs.getInstance().getValidateAccess();
//        payload.getParticipant().getContacts().get(0).getPhoneCompany().setId(null);
//
//        srvProposalsV0.createQuestionnairesValidateAccess(payload);
//    }

    @Test
    public void createQuestionnairesValidateAccessWithoutParticipantContactsEmailContactDetailTypeTest() throws IOException {
        expectedException.expect(BusinessServiceException.class);
        expectedException.expect(BusinessServiceExceptionMatcher.hasErrorCode(MANDATORY_PARAMETERS_MISSING));

        ValidateAccess payload = EntityStubs.getInstance().getValidateAccess();
        payload.getParticipant().getContacts().get(1).setContactDetailType(null);

        srvProposalsV0.createQuestionnairesValidateAccess(payload);
    }

    @Test
    public void createQuestionnairesValidateAccessWithoutParticipantContactsEmailAddressTest() throws IOException {
        expectedException.expect(BusinessServiceException.class);
        expectedException.expect(BusinessServiceExceptionMatcher.hasErrorCode(MANDATORY_PARAMETERS_MISSING));

        ValidateAccess payload = EntityStubs.getInstance().getValidateAccess();
        payload.getParticipant().getContacts().get(1).setAddress(null);

        srvProposalsV0.createQuestionnairesValidateAccess(payload);
    }

    @Test
    public void createQuestionnairesValidateAccessWithoutProductTest() throws IOException {
        ValidateAccess payload = EntityStubs.getInstance().getValidateAccess();
        payload.setProduct(null);

        ServiceResponse<ValidateAccess> result = srvProposalsV0.createQuestionnairesValidateAccess(payload);

        assertNotNull(result);
    }

    @Test
    public void createQuestionnairesValidateAccessWithoutProductIdTest() throws IOException {
        expectedException.expect(BusinessServiceException.class);
        expectedException.expect(BusinessServiceExceptionMatcher.hasErrorCode(MANDATORY_PARAMETERS_MISSING));

        ValidateAccess payload = EntityStubs.getInstance().getValidateAccess();
        payload.getProduct().setId(null);

        srvProposalsV0.createQuestionnairesValidateAccess(payload);
    }

    @Test
    public void createQuestionnairesValidateAccessWithoutProductSubproductTest() throws IOException {
        ValidateAccess payload = EntityStubs.getInstance().getValidateAccess();
        payload.getProduct().setSubproduct(null);

        ServiceResponse<ValidateAccess> result = srvProposalsV0.createQuestionnairesValidateAccess(payload);

        assertNotNull(result);
    }

    @Test
    public void createQuestionnairesValidateAccessWithoutProductSubproductIdTest() throws IOException {
        expectedException.expect(BusinessServiceException.class);
        expectedException.expect(BusinessServiceExceptionMatcher.hasErrorCode(MANDATORY_PARAMETERS_MISSING));

        ValidateAccess payload = EntityStubs.getInstance().getValidateAccess();
        payload.getProduct().getSubproduct().setId(null);

        srvProposalsV0.createQuestionnairesValidateAccess(payload);
    }
}
