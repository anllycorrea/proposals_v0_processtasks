package com.bbva.pzic.proposals.facade.v0.mapper.impl;

import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponse;
import com.bbva.pzic.proposals.business.dto.DTOIntContact;
import com.bbva.pzic.proposals.business.dto.DTOIntParticipantProposal;
import com.bbva.pzic.proposals.business.dto.DTOIntValidateAccess;
import com.bbva.pzic.proposals.facade.v0.dto.Contact;
import com.bbva.pzic.proposals.facade.v0.dto.ValidateAccess;
import com.bbva.pzic.proposals.facade.v0.mapper.ICreateQuestionnairesValidateAccessMapper;
import com.bbva.pzic.proposals.util.mappers.Mapper;
import com.bbva.pzic.proposals.util.orika.MapperFactory;
import com.bbva.pzic.proposals.util.orika.impl.ConfigurableMapper;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created on 15/11/2019.
 *
 * @author Entelgy
 */
@Mapper
public class CreateQuestionnairesValidateAccessMapper extends ConfigurableMapper
        implements ICreateQuestionnairesValidateAccessMapper {

    private static final Log LOG = LogFactory.getLog(CreateQuestionnairesValidateAccessMapper.class);

    @Override
    protected void configure(MapperFactory factory) {
        super.configure(factory);

        factory.classMap(ValidateAccess.class, DTOIntValidateAccess.class)
                .field("participant.id", "participant.id")
                .field("participant.identityDocument.documentType.id", "participant.identityDocument.documentType.id")
                .field("participant.identityDocument.documentNumber", "participant.identityDocument.documentNumber")
                .field("product.id", "product.id")
                .field("product.subproduct.id", "product.subproduct.id")
                .register();

        factory.classMap(Contact.class, DTOIntContact.class)
                .field("contactDetailType", "contactDetailType")
                .field("number", "number")
                .field("phoneCompany.id", "phoneCompany.id")
                .field("address", "address")
                .register();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DTOIntValidateAccess mapIn(final ValidateAccess validateAccess) {
        LOG.info("... called method CreateQuestionnairesValidateAccessMapper.mapIn ...");
        DTOIntValidateAccess dtoInt = map(validateAccess, DTOIntValidateAccess.class);

        if (validateAccess.getParticipant() != null &&
                CollectionUtils.isNotEmpty(validateAccess.getParticipant().getContacts())) {
            if (dtoInt.getParticipant() == null) {
                dtoInt.setParticipant(new DTOIntParticipantProposal());
            }
            dtoInt.getParticipant().setContacts(mapAsList(validateAccess.getParticipant().getContacts(), DTOIntContact.class));
        }

        return dtoInt;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    public ServiceResponse<ValidateAccess> mapOut(final ValidateAccess validateAccess) {
        LOG.info("... called method CreateQuestionnairesValidateAccessMapper.mapOut ...");
        if (validateAccess == null) {
            return null;
        }
        return ServiceResponse.data(validateAccess).pagination(null).build();
    }
}
