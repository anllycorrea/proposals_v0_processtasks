package com.bbva.pzic.proposals.dao.model.ugmp.mock;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import com.bbva.pzic.proposals.dao.model.ugmp.PeticionTransaccionUgmp;
import com.bbva.pzic.proposals.dao.model.ugmp.RespuestaTransaccionUgmp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Invocador de la transacci&oacute;n <code>UGMP</code>
 *
 * @see com.bbva.pzic.proposals.dao.model.ugmp.PeticionTransaccionUgmp
 * @see com.bbva.pzic.proposals.dao.model.ugmp.RespuestaTransaccionUgmp
 */
@Component("transaccionUgmp")
public class TransaccionUgmpMock implements InvocadorTransaccion<PeticionTransaccionUgmp, RespuestaTransaccionUgmp> {

    @Override
    public RespuestaTransaccionUgmp invocar(PeticionTransaccionUgmp transaccion)  {
        return null;
    }

    @Override
    public RespuestaTransaccionUgmp invocarCache(PeticionTransaccionUgmp transaccion)  {
        return null;
    }

    @Override
    public void vaciarCache() {
    }
}