package com.bbva.pzic.proposals.dao.model.uglp;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Invocador de la transacci&oacute;n <code>UGLP</code>
 *
 * @see PeticionTransaccionUglp
 * @see RespuestaTransaccionUglp
 */
@Component("transaccionUglp")
public class TransaccionUglp implements InvocadorTransaccion<PeticionTransaccionUglp, RespuestaTransaccionUglp> {

    @Autowired
    private ServicioTransacciones servicioTransacciones;

    @Override
    public RespuestaTransaccionUglp invocar(PeticionTransaccionUglp transaccion) throws ExcepcionTransaccion {
        return servicioTransacciones.invocar(PeticionTransaccionUglp.class, RespuestaTransaccionUglp.class, transaccion);
    }

    @Override
    public RespuestaTransaccionUglp invocarCache(PeticionTransaccionUglp transaccion) throws ExcepcionTransaccion {
        return servicioTransacciones.invocar(PeticionTransaccionUglp.class, RespuestaTransaccionUglp.class, transaccion);
    }

    @Override
    public void vaciarCache() {
    }
}