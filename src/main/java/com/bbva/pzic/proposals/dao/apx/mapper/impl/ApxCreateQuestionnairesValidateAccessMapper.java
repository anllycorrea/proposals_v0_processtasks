package com.bbva.pzic.proposals.dao.apx.mapper.impl;

import com.bbva.jee.arq.spring.core.managers.OutputHeaderManager;
import com.bbva.pzic.proposals.business.dto.DTOIntContact;
import com.bbva.pzic.proposals.business.dto.DTOIntValidateAccess;
import com.bbva.pzic.proposals.dao.apx.mapper.IApxCreateQuestionnairesValidateAccessMapper;
import com.bbva.pzic.proposals.dao.model.ppcut011_1.*;
import com.bbva.pzic.proposals.facade.v0.dto.Contact;
import com.bbva.pzic.proposals.facade.v0.dto.DictumReason;
import com.bbva.pzic.proposals.facade.v0.dto.ValidateAccess;
import com.bbva.pzic.proposals.util.Constants;
import com.bbva.pzic.proposals.util.mappers.Mapper;
import com.bbva.pzic.proposals.util.orika.MapperFactory;
import com.bbva.pzic.proposals.util.orika.impl.ConfigurableMapper;
import org.apache.commons.collections.CollectionUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created on 15/11/2019.
 *
 * @author Entelgy
 */
@Mapper
public class ApxCreateQuestionnairesValidateAccessMapper extends ConfigurableMapper
        implements IApxCreateQuestionnairesValidateAccessMapper {

    private static final String PRODUCT_SUBPRODUCT_ID = "product.subproduct.id";
    private static final String PRODUCT_ID = "product.id";
    private static final String PARTICIPANT_ID = "participant.id";

    private OutputHeaderManager outputHeaderManager;

    public ApxCreateQuestionnairesValidateAccessMapper(OutputHeaderManager outputHeaderManager) {
        this.outputHeaderManager = outputHeaderManager;
    }

    @Override
    protected void configure(MapperFactory factory) {
        super.configure(factory);

        factory.classMap(DTOIntValidateAccess.class, Entityin.class)
                .field(PARTICIPANT_ID, PARTICIPANT_ID)
                .field("participant.identityDocument.documentType.id", "participant.identitydocument.documenttype.id")
                .field("participant.identityDocument.documentNumber", "participant.identitydocument.documentnumber")
                .field(PRODUCT_ID, PRODUCT_ID)
                .field(PRODUCT_SUBPRODUCT_ID, PRODUCT_SUBPRODUCT_ID)
                .register();

        factory.classMap(DTOIntContact.class, Contacts.class)
                .field("contactDetailType", "contact.contactdetailtype")
                .field("number", "contact.number")
                .field("phoneCompany.id", "contact.phonecompany.id")
                .field("address", "contact.address")
                .register();

        factory.classMap(ValidateAccess.class, Entityout.class)
                .field(PARTICIPANT_ID, PARTICIPANT_ID)
                .field("participant.identityDocument.documentType.id", "participant.identitydocument.documenttype.id")
                .field("participant.identityDocument.documentNumber", "participant.identitydocument.documentnumber")
                .field(PRODUCT_ID, PRODUCT_ID)
                .field(PRODUCT_SUBPRODUCT_ID, PRODUCT_SUBPRODUCT_ID)
                .register();

        factory.classMap(Contact.class, Contacts.class)
                .field("contactDetailType", "contact.contactdetailtype")
                .field("number", "contact.number")
                .field("phoneCompany.id", "contact.phonecompany.id")
                .field("phoneCompany.name", "contact.phonecompany.name")
                .field("address", "contact.address")
                .register();
    }

    @Override
    public Entityin mapIn(final DTOIntValidateAccess dtoInt) {
        Entityin entityIn = map(dtoInt, Entityin.class);

        if (dtoInt.getParticipant() != null &&
                CollectionUtils.isNotEmpty(dtoInt.getParticipant().getContacts())) {
            if (entityIn.getParticipant() == null) {
                entityIn.setParticipant(new Participant());
            }
            entityIn.getParticipant().setContacts(mapAsList(dtoInt.getParticipant().getContacts(), Contacts.class));
        }

        return entityIn;
    }

    @Override
    public ValidateAccess mapOut(final Entityout entityOut) {
        if (entityOut.getHeaders() != null && entityOut.getHeaders().getContactid() != null) {
            outputHeaderManager.setHeader(Constants.CONTACT_ID, entityOut.getHeaders().getContactid());
        }

        ValidateAccess validateAccess = map(entityOut, ValidateAccess.class);

        if (entityOut.getParticipant() != null &&
                CollectionUtils.isNotEmpty(entityOut.getParticipant().getContacts())) {
            if (validateAccess.getParticipant() == null) {
                validateAccess.setParticipant(new com.bbva.pzic.proposals.facade.v0.dto.ParticipantProposal());
            }
            validateAccess.getParticipant().setContacts(mapAsList(entityOut.getParticipant().getContacts(), Contact.class));
        }
        validateAccess.setValidationDictum(entityOut.getValidationdictum());
        validateAccess.setDictumReasons(mapOutDictumReasons(entityOut.getDictumreasons()));

        return validateAccess;
    }

    private List<DictumReason> mapOutDictumReasons(final List<Dictumreasons> dictumreasons) {
        if (CollectionUtils.isEmpty(dictumreasons)) {
            return null;
        }

        return dictumreasons.stream().filter(Objects::nonNull).map(this::mapOutDictumReason).collect(Collectors.toList());
    }

    private DictumReason mapOutDictumReason(final Dictumreasons dictumreasons) {
        if (dictumreasons.getDictumreason() == null) {
            return null;
        }

        DictumReason result = new DictumReason();
        result.setId(dictumreasons.getDictumreason().getId());
        result.setDescription(dictumreasons.getDictumreason().getDescription());
        return result;
    }
}
