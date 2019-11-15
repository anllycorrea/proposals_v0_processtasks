package com.bbva.pzic.proposals.facade.v0.mapper.impl;

import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponse;
import com.bbva.pzic.proposals.EntityStubs;
import com.bbva.pzic.proposals.business.dto.DTOIntValidateAccess;
import com.bbva.pzic.proposals.facade.v0.dto.ValidateAccess;
import com.bbva.pzic.proposals.facade.v0.mapper.ICreateQuestionnairesValidateAccessMapper;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created on 15/11/2019.
 *
 * @author Entelgy
 */
public class CreateQuestionnairesValidateAccessMapperTest {

    private ICreateQuestionnairesValidateAccessMapper mapper;

    @Before
    public void setUp() {
        mapper = new CreateQuestionnairesValidateAccessMapper();
    }

    @Test
    public void mapInFullTest() throws IOException {
        ValidateAccess input = EntityStubs.getInstance().getValidateAccess();

        DTOIntValidateAccess result = mapper.mapIn(input);

        assertNotNull(result);
        assertNotNull(result.getParticipant());
        assertNotNull(result.getParticipant().getId());
        assertNotNull(result.getParticipant().getIdentityDocument());
        assertNotNull(result.getParticipant().getIdentityDocument().getDocumentType());
        assertNotNull(result.getParticipant().getIdentityDocument().getDocumentType().getId());
        assertNotNull(result.getParticipant().getIdentityDocument().getDocumentNumber());
        assertNotNull(result.getProduct());
        assertNotNull(result.getProduct().getId());
        assertNotNull(result.getProduct().getSubproduct());
        assertNotNull(result.getProduct().getSubproduct().getId());
        assertEquals(input.getParticipant().getId(), result.getParticipant().getId());
        assertEquals(input.getParticipant().getIdentityDocument().getDocumentType().getId(), result.getParticipant().getIdentityDocument().getDocumentType().getId());
        assertEquals(input.getParticipant().getIdentityDocument().getDocumentNumber(), result.getParticipant().getIdentityDocument().getDocumentNumber());
        assertEquals(input.getProduct().getId(), result.getProduct().getId());
        assertEquals(input.getProduct().getSubproduct().getId(), result.getProduct().getSubproduct().getId());
    }

    @Test
    public void mapInEmptyTest() {
        DTOIntValidateAccess result = mapper.mapIn(new ValidateAccess());

        assertNotNull(result);
        assertNull(result.getParticipant());
        assertNull(result.getProduct());
    }

    @Test
    public void mapOutFullTest() {
        ServiceResponse<ValidateAccess> result = mapper.mapOut(new ValidateAccess());
        assertNotNull(result);
        assertNotNull(result.getData());
    }

    @Test
    public void mapOutEmptyTest() {
        ServiceResponse<ValidateAccess> result = mapper.mapOut(null);
        assertNull(result);
    }
}
