package com.bbva.pzic.proposals.dao.apx;

import com.bbva.pzic.proposals.business.dto.DTOIntValidateAccess;
import com.bbva.pzic.proposals.dao.apx.mapper.IApxCreateQuestionnairesValidateAccessMapper;
import com.bbva.pzic.proposals.facade.v0.dto.ValidateAccess;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created on 15/11/2019.
 *
 * @author Entelgy
 */
@Component("apxCreateQuestionnairesValidateAccess")
public class ApxCreateQuestionnairesValidateAccess {

    @Resource(name = "apxCreateQuestionnairesValidateAccessMapper")
    private IApxCreateQuestionnairesValidateAccessMapper mapper;

    public ValidateAccess invoke(final DTOIntValidateAccess dtoInt) {
        return null;
    }
}
