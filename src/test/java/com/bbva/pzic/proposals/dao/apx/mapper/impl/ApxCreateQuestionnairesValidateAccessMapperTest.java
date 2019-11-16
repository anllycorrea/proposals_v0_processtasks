package com.bbva.pzic.proposals.dao.apx.mapper.impl;

import com.bbva.pzic.proposals.EntityStubs;
import com.bbva.pzic.proposals.business.dto.DTOIntValidateAccess;
import com.bbva.pzic.proposals.dao.apx.mapper.IApxCreateQuestionnairesValidateAccessMapper;
import com.bbva.pzic.proposals.dao.model.pcunt001_1.Entityin;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created on 15/11/2019.
 *
 * @author Entelgy
 */
public class ApxCreateQuestionnairesValidateAccessMapperTest {

    private IApxCreateQuestionnairesValidateAccessMapper mapper;

    @Before
    public void setUp() {
        mapper = new ApxCreateQuestionnairesValidateAccessMapper();
    }

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
}
