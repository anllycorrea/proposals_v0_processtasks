package com.bbva.pzic.proposals.dao.apx.mapper.impl;

import com.bbva.jee.arq.spring.core.managers.OutputHeaderManager;
import com.bbva.pzic.proposals.EntityStubs;
import com.bbva.pzic.proposals.business.dto.DTOIntValidateAccess;
import com.bbva.pzic.proposals.dao.model.ppcut011_1.Entityin;
import com.bbva.pzic.proposals.dao.model.ppcut011_1.Entityout;
import com.bbva.pzic.proposals.dao.model.ppcut011_1.mock.Ppcut011_1Stubs;
import com.bbva.pzic.proposals.facade.v0.dto.ValidateAccess;
import com.bbva.pzic.proposals.util.Constants;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created on 15/11/2019.
 *
 * @author Entelgy
 */
@RunWith(MockitoJUnitRunner.class)
public class ApxCreateQuestionnairesValidateAccessMapperTest {

    @InjectMocks
    private ApxCreateQuestionnairesValidateAccessMapper mapper;
    @Mock
    private OutputHeaderManager outputHeaderManager;

    @Test
    public void mapInFullTest() throws IOException {
        DTOIntValidateAccess input = EntityStubs.getInstance().getDTOIntValidateAccess();

        Entityin result = mapper.mapIn(input);

        assertNotNull(result);
        assertNotNull(result.getParticipant());
        assertNotNull(result.getParticipant().getId());
        assertNotNull(result.getParticipant().getIdentitydocument());
        assertNotNull(result.getParticipant().getIdentitydocument().getDocumenttype());
        assertNotNull(result.getParticipant().getIdentitydocument().getDocumenttype().getId());
        assertNotNull(result.getParticipant().getIdentitydocument().getDocumentnumber());

        assertNotNull(result.getParticipant().getContacts().get(0).getContact().getContactdetailtype());
        assertNotNull(result.getParticipant().getContacts().get(0).getContact().getNumber());
        assertNotNull(result.getParticipant().getContacts().get(0).getContact().getPhonecompany());
        assertNotNull(result.getParticipant().getContacts().get(0).getContact().getPhonecompany().getId());
        assertNull(result.getParticipant().getContacts().get(0).getContact().getAddress());

        assertNotNull(result.getParticipant().getContacts().get(1).getContact().getContactdetailtype());
        assertNull(result.getParticipant().getContacts().get(1).getContact().getNumber());
        assertNull(result.getParticipant().getContacts().get(1).getContact().getPhonecompany());
        assertNotNull(result.getParticipant().getContacts().get(1).getContact().getAddress());

        assertNotNull(result.getProduct());
        assertNotNull(result.getProduct().getId());
        assertNotNull(result.getProduct().getSubproduct());
        assertNotNull(result.getProduct().getSubproduct().getId());

        assertEquals(input.getParticipant().getId(), result.getParticipant().getId());
        assertEquals(input.getParticipant().getIdentityDocument().getDocumentType().getId(), result.getParticipant().getIdentitydocument().getDocumenttype().getId());
        assertEquals(input.getParticipant().getIdentityDocument().getDocumentNumber(), result.getParticipant().getIdentitydocument().getDocumentnumber());
        assertEquals(input.getParticipant().getContacts().get(0).getContactDetailType(), result.getParticipant().getContacts().get(0).getContact().getContactdetailtype());
        assertEquals(input.getParticipant().getContacts().get(0).getNumber(), result.getParticipant().getContacts().get(0).getContact().getNumber());
        assertEquals(input.getParticipant().getContacts().get(0).getPhoneCompany().getId(), result.getParticipant().getContacts().get(0).getContact().getPhonecompany().getId());
        assertEquals(input.getParticipant().getContacts().get(1).getContactDetailType(), result.getParticipant().getContacts().get(1).getContact().getContactdetailtype());
        assertEquals(input.getParticipant().getContacts().get(1).getAddress(), result.getParticipant().getContacts().get(1).getContact().getAddress());
        assertEquals(input.getProduct().getId(), result.getProduct().getId());
        assertEquals(input.getProduct().getSubproduct().getId(), result.getProduct().getSubproduct().getId());
    }

    @Test
    public void mapInWithoutContactsTest() throws IOException {
        DTOIntValidateAccess input = EntityStubs.getInstance().getDTOIntValidateAccess();
        input.getParticipant().setContacts(null);

        Entityin result = mapper.mapIn(input);

        assertNotNull(result);
        assertNotNull(result.getParticipant());
        assertNotNull(result.getProduct());
    }

    @Test
    public void mapInOnlyContactsTest() throws IOException {
        DTOIntValidateAccess input = EntityStubs.getInstance().getDTOIntValidateAccess();
        input.getParticipant().setId(null);
        input.getParticipant().setIdentityDocument(null);

        Entityin result = mapper.mapIn(input);

        assertNotNull(result);
        assertNotNull(result.getParticipant());
        assertNotNull(result.getProduct());
    }

    @Test
    public void mapInEmptyTest() {
        Entityin result = mapper.mapIn(new DTOIntValidateAccess());

        assertNotNull(result);
        assertNull(result.getParticipant());
        assertNull(result.getProduct());
    }

    @Test
    public void mapOutFullTest() throws IOException {
        Entityout output = Ppcut011_1Stubs.getInstance().getEntityOut();

        ValidateAccess result = mapper.mapOut(output);

        verify(outputHeaderManager, times(1)).setHeader(Constants.CUF_HEADER, output.getHeaders().getContactid());

        assertNotNull(result);
        assertNotNull(result.getParticipant());
        assertNotNull(result.getParticipant().getId());
        assertNotNull(result.getParticipant().getIdentityDocument());
        assertNotNull(result.getParticipant().getIdentityDocument().getDocumentType());
        assertNotNull(result.getParticipant().getIdentityDocument().getDocumentType().getId());
        assertNotNull(result.getParticipant().getIdentityDocument().getDocumentNumber());
        assertNotNull(result.getParticipant().getContacts().get(0).getContactDetailType());
        assertNotNull(result.getParticipant().getContacts().get(0).getNumber());
        assertNotNull(result.getParticipant().getContacts().get(0).getPhoneCompany());
        assertNotNull(result.getParticipant().getContacts().get(0).getPhoneCompany().getId());
        assertNotNull(result.getParticipant().getContacts().get(0).getPhoneCompany().getName());
        assertNull(result.getParticipant().getContacts().get(0).getAddress());
        assertNotNull(result.getParticipant().getContacts().get(1).getContactDetailType());
        assertNull(result.getParticipant().getContacts().get(1).getNumber());
        assertNull(result.getParticipant().getContacts().get(1).getPhoneCompany());
        assertNotNull(result.getParticipant().getContacts().get(1).getAddress());
        assertNotNull(result.getProduct());
        assertNotNull(result.getProduct().getId());
        assertNotNull(result.getProduct().getSubproduct());
        assertNotNull(result.getProduct().getSubproduct().getId());
        assertNotNull(result.getValidationDictum());
        assertNotNull(result.getDictumReasons());
        assertEquals(1, result.getDictumReasons().size());
        assertNotNull(result.getDictumReasons().get(0).getId());
        assertNotNull(result.getDictumReasons().get(0).getDescription());

        assertEquals(output.getParticipant().getId(), result.getParticipant().getId());
        assertEquals(output.getParticipant().getIdentitydocument().getDocumenttype().getId(), result.getParticipant().getIdentityDocument().getDocumentType().getId());
        assertEquals(output.getParticipant().getIdentitydocument().getDocumentnumber(), result.getParticipant().getIdentityDocument().getDocumentNumber());
        assertEquals(output.getParticipant().getContacts().get(0).getContact().getContactdetailtype(), result.getParticipant().getContacts().get(0).getContactDetailType());
        assertEquals(output.getParticipant().getContacts().get(0).getContact().getNumber(), result.getParticipant().getContacts().get(0).getNumber());
        assertEquals(output.getParticipant().getContacts().get(0).getContact().getPhonecompany().getId(), result.getParticipant().getContacts().get(0).getPhoneCompany().getId());
        assertEquals(output.getParticipant().getContacts().get(0).getContact().getPhonecompany().getName(), result.getParticipant().getContacts().get(0).getPhoneCompany().getName());
        assertEquals(output.getParticipant().getContacts().get(1).getContact().getContactdetailtype(), result.getParticipant().getContacts().get(1).getContactDetailType());
        assertEquals(output.getParticipant().getContacts().get(1).getContact().getAddress(), result.getParticipant().getContacts().get(1).getAddress());
        assertEquals(output.getProduct().getId(), result.getProduct().getId());
        assertEquals(output.getProduct().getSubproduct().getId(), result.getProduct().getSubproduct().getId());
        assertEquals(output.getValidationdictum(), result.getValidationDictum());
        assertEquals(output.getDictumreasons().get(0).getDictumreason().getId(), result.getDictumReasons().get(0).getId());
        assertEquals(output.getDictumreasons().get(0).getDictumreason().getDescription(), result.getDictumReasons().get(0).getDescription());
    }

    @Test
    public void mapOutWithoutContactsTest() throws IOException {
        Entityout output = Ppcut011_1Stubs.getInstance().getEntityOut();
        output.getParticipant().setContacts(null);

        ValidateAccess result = mapper.mapOut(output);

        assertNotNull(result);
        assertNotNull(result.getParticipant());
        assertNotNull(result.getProduct());
    }

    @Test
    public void mapOutOnlyContactsTest() throws IOException {
        Entityout output = Ppcut011_1Stubs.getInstance().getEntityOut();
        output.getParticipant().setId(null);
        output.getParticipant().setIdentitydocument(null);

        ValidateAccess result = mapper.mapOut(output);

        assertNotNull(result);
        assertNotNull(result.getParticipant());
        assertNotNull(result.getProduct());
    }

    @Test
    public void mapOutEmptyTest() {
        ValidateAccess result = mapper.mapOut(new Entityout());

        assertNotNull(result);
        assertNull(result.getParticipant());
        assertNull(result.getProduct());
        assertNull(result.getDictumReasons());
    }
}
