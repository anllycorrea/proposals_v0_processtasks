package com.bbva.pzic.proposals.facade.v0.mapper;

import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponse;
import com.bbva.pzic.proposals.business.dto.DTOIntValidateAccess;
import com.bbva.pzic.proposals.facade.v0.dto.ValidateAccess;

/**
 * Created on 15/11/2019.
 *
 * @author Entelgy
 */
public interface ICreateQuestionnairesValidateAccessMapper {

    DTOIntValidateAccess mapIn(ValidateAccess validateAccess);

    ServiceResponse<ValidateAccess> mapOut(ValidateAccess validateAccess);
}
