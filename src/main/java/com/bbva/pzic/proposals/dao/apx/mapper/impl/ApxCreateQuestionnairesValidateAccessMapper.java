package com.bbva.pzic.proposals.dao.apx.mapper.impl;

import com.bbva.pzic.proposals.business.dto.DTOIntValidateAccess;
import com.bbva.pzic.proposals.dao.apx.mapper.IApxCreateQuestionnairesValidateAccessMapper;
import com.bbva.pzic.proposals.dao.model.pcunt001_1.Entityin;
import com.bbva.pzic.proposals.dao.model.pcunt001_1.Entityout;
import com.bbva.pzic.proposals.facade.v0.dto.ValidateAccess;
import com.bbva.pzic.proposals.util.mappers.Mapper;

/**
 * Created on 15/11/2019.
 *
 * @author Entelgy
 */
@Mapper
public class ApxCreateQuestionnairesValidateAccessMapper
        implements IApxCreateQuestionnairesValidateAccessMapper {

    @Override
    public Entityin mapIn(final DTOIntValidateAccess dtoInt) {
        return null;
    }

    @Override
    public ValidateAccess mapOut(final Entityout entityout) {
        return null;
    }
}
