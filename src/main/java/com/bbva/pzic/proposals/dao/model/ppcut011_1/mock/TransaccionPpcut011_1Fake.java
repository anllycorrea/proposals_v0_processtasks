package com.bbva.pzic.proposals.dao.model.ppcut011_1.mock;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.pzic.proposals.dao.model.ppcut011_1.PeticionTransaccionPpcut011_1;
import com.bbva.pzic.proposals.dao.model.ppcut011_1.RespuestaTransaccionPpcut011_1;
import com.bbva.pzic.proposals.util.Errors;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Invocador de la transacci&oacute;n <code>PCUNT001</code>
 *
 * @see PeticionTransaccionPpcut011_1
 * @see RespuestaTransaccionPpcut011_1
 */
@Component("transaccionPpcut011_1")
public class TransaccionPpcut011_1Fake implements InvocadorTransaccion<PeticionTransaccionPpcut011_1, RespuestaTransaccionPpcut011_1> {

    @Override
    public RespuestaTransaccionPpcut011_1 invocar(PeticionTransaccionPpcut011_1 transaccion) {
        try {
            RespuestaTransaccionPpcut011_1 response = new RespuestaTransaccionPpcut011_1();
            response.setEntityout(Ppcut011_1Stubs.getInstance().getEntityOut());
            return response;
        } catch (IOException e) {
            throw new BusinessServiceException(Errors.TECHNICAL_ERROR, e);
        }
    }

    @Override
    public RespuestaTransaccionPpcut011_1 invocarCache(PeticionTransaccionPpcut011_1 transaccion) throws ExcepcionTransaccion {
        return null;
    }

    @Override
    public void vaciarCache() {
    }
}
