package com.bbva.pzic.proposals.dao.apx.mapper.impl;

import com.bbva.pzic.proposals.business.dto.DTOIntContact;
import com.bbva.pzic.proposals.business.dto.DTOIntValidateAccess;
import com.bbva.pzic.proposals.dao.apx.mapper.IApxCreateQuestionnairesValidateAccessMapper;
import com.bbva.pzic.proposals.dao.model.pcunt001_1.Contacts;
import com.bbva.pzic.proposals.dao.model.pcunt001_1.Entityin;
import com.bbva.pzic.proposals.dao.model.pcunt001_1.Entityout;
import com.bbva.pzic.proposals.dao.model.pcunt001_1.Participant;
import com.bbva.pzic.proposals.facade.v0.dto.ValidateAccess;
import com.bbva.pzic.proposals.util.mappers.Mapper;
import com.bbva.pzic.proposals.util.orika.MapperFactory;
import com.bbva.pzic.proposals.util.orika.impl.ConfigurableMapper;
import org.apache.commons.collections.CollectionUtils;

/**
 * Created on 15/11/2019.
 *
 * @author Entelgy
 */
@Mapper
public class ApxCreateQuestionnairesValidateAccessMapper extends ConfigurableMapper
        implements IApxCreateQuestionnairesValidateAccessMapper {

    @Override
    protected void configure(MapperFactory factory) {
        super.configure(factory);

        factory.classMap(DTOIntValidateAccess.class, Entityin.class)
                .field("participant.id", "participant.id")
                .field("participant.identityDocument.documentType.id", "participant.identitydocument.documenttype.id")
                .field("participant.identityDocument.documentNumber", "participant.identitydocument.documentnumber")
                .field("product.id", "product.id")
                .field("product.subproduct.id", "product.subproduct.id")
                .register();

        factory.classMap(DTOIntContact.class, Contacts.class)
                .field("contactDetailType", "contact.contactdetailtype")
                .field("number", "contact.number")
                .field("phoneCompany.id", "contact.phonecompany.id")
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
    public ValidateAccess mapOut(final Entityout entityout) {
        return null;
    }
}
