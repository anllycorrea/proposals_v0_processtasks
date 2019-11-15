package com.bbva.pzic.proposals.dao.apx;

import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.pzic.proposals.business.dto.DTOIntValidateAccess;
import com.bbva.pzic.proposals.dao.apx.mapper.IApxCreateQuestionnairesValidateAccessMapper;
import com.bbva.pzic.proposals.dao.model.pcunt001_1.PeticionTransaccionPcunt001_1;
import com.bbva.pzic.proposals.dao.model.pcunt001_1.RespuestaTransaccionPcunt001_1;
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
    @Resource(name = "transaccionPcunt001_1")
    private transient InvocadorTransaccion<PeticionTransaccionPcunt001_1, RespuestaTransaccionPcunt001_1> transaccion;

    public ValidateAccess invoke(final DTOIntValidateAccess dtoInt) {
        PeticionTransaccionPcunt001_1 request = new PeticionTransaccionPcunt001_1();
        request.setEntityin(mapper.mapIn(dtoInt));

        RespuestaTransaccionPcunt001_1 response = transaccion.invocar(request);

        return mapper.mapOut(response.getEntityout());
    }
}
