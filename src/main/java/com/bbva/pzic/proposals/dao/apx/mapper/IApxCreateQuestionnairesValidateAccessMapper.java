package com.bbva.pzic.proposals.dao.apx.mapper;

import com.bbva.pzic.proposals.business.dto.DTOIntValidateAccess;
import com.bbva.pzic.proposals.dao.model.ppcut011_1.Entityin;
import com.bbva.pzic.proposals.dao.model.ppcut011_1.Entityout;
import com.bbva.pzic.proposals.facade.v0.dto.ValidateAccess;

/**
 * Created on 15/11/2019.
 *
 * @author Entelgy
 */
public interface IApxCreateQuestionnairesValidateAccessMapper {

    Entityin mapIn(DTOIntValidateAccess dtoInt);

    ValidateAccess mapOut(Entityout entityOut);
}
