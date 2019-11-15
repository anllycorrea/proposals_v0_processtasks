package com.bbva.pzic.proposals.dao.model.pcunt001_1.mock;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.pzic.proposals.dao.model.pcunt001_1.PeticionTransaccionPcunt001_1;
import com.bbva.pzic.proposals.dao.model.pcunt001_1.RespuestaTransaccionPcunt001_1;
import org.springframework.stereotype.Component;

/**
 * Invocador de la transacci&oacute;n <code>PCUNT001</code>
 *
 * @see PeticionTransaccionPcunt001_1
 * @see RespuestaTransaccionPcunt001_1
 */
@Component("transaccionPcunt001_1")
public class TransaccionPcunt001_1Mock implements InvocadorTransaccion<PeticionTransaccionPcunt001_1, RespuestaTransaccionPcunt001_1> {

    @Override
    public RespuestaTransaccionPcunt001_1 invocar(PeticionTransaccionPcunt001_1 transaccion) {
        return null;
    }

    @Override
    public RespuestaTransaccionPcunt001_1 invocarCache(PeticionTransaccionPcunt001_1 transaccion) throws ExcepcionTransaccion {
        return null;
    }

    @Override
    public void vaciarCache() {
    }
}
