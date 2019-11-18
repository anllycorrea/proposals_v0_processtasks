package com.bbva.pzic.proposals.dao.model.pcunt001_1.mock;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.pzic.proposals.dao.model.pcunt001_1.PeticionTransaccionPcunt001_1;
import com.bbva.pzic.proposals.dao.model.pcunt001_1.RespuestaTransaccionPcunt001_1;
import com.bbva.pzic.proposals.util.Errors;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Invocador de la transacci&oacute;n <code>PCUNT001</code>
 *
 * @see PeticionTransaccionPcunt001_1
 * @see RespuestaTransaccionPcunt001_1
 */
@Component("transaccionPcunt001_1")
public class TransaccionPcunt001_1Fake implements InvocadorTransaccion<PeticionTransaccionPcunt001_1, RespuestaTransaccionPcunt001_1> {

    @Override
    public RespuestaTransaccionPcunt001_1 invocar(PeticionTransaccionPcunt001_1 transaccion) {
        try {
            RespuestaTransaccionPcunt001_1 response = new RespuestaTransaccionPcunt001_1();
            response.setEntityout(Pcunt001_1Stubs.getInstance().getEntityOut());
            return response;
        } catch (IOException e) {
            throw new BusinessServiceException(Errors.TECHNICAL_ERROR, e);
        }
    }

    @Override
    public RespuestaTransaccionPcunt001_1 invocarCache(PeticionTransaccionPcunt001_1 transaccion) throws ExcepcionTransaccion {
        return null;
    }

    @Override
    public void vaciarCache() {
    }
}
