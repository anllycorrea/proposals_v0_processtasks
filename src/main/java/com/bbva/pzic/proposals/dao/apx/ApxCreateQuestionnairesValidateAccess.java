package com.bbva.pzic.proposals.dao.apx;

import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.pzic.proposals.business.dto.DTOIntValidateAccess;
import com.bbva.pzic.proposals.dao.apx.mapper.IApxCreateQuestionnairesValidateAccessMapper;
import com.bbva.pzic.proposals.dao.model.ppcut011_1.PeticionTransaccionPpcut011_1;
import com.bbva.pzic.proposals.dao.model.ppcut011_1.RespuestaTransaccionPpcut011_1;
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
    @Resource(name = "transaccionPpcut011_1")
    private transient InvocadorTransaccion<PeticionTransaccionPpcut011_1, RespuestaTransaccionPpcut011_1> transaccion;

    public ValidateAccess invoke(final DTOIntValidateAccess dtoInt) {
        PeticionTransaccionPpcut011_1 request = new PeticionTransaccionPpcut011_1();
        request.setEntityin(mapper.mapIn(dtoInt));

        RespuestaTransaccionPpcut011_1 response = transaccion.invocar(request);

        return mapper.mapOut(response.getEntityout());
    }
}
