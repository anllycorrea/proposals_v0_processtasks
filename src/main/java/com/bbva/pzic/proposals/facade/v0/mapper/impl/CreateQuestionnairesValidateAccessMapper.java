package com.bbva.pzic.proposals.facade.v0.mapper.impl;

import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponse;
import com.bbva.pzic.proposals.business.dto.DTOIntValidateAccess;
import com.bbva.pzic.proposals.facade.v0.dto.ValidateAccess;
import com.bbva.pzic.proposals.facade.v0.mapper.ICreateQuestionnairesValidateAccessMapper;
import com.bbva.pzic.proposals.util.mappers.Mapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created on 15/11/2019.
 *
 * @author Entelgy
 */
@Mapper
public class CreateQuestionnairesValidateAccessMapper
        implements ICreateQuestionnairesValidateAccessMapper {

    private static final Log LOG = LogFactory.getLog(CreateQuestionnairesValidateAccessMapper.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public DTOIntValidateAccess mapIn(final ValidateAccess validateAccess) {
        LOG.info("... called method CreateQuestionnairesValidateAccessMapper.mapIn ...");
        return null;
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
