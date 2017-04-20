package com.bbva.pzic.proposals.dao.model.ugmp;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Invocador de la transacci&oacute;n <code>UGMP</code>
 *
 * @see PeticionTransaccionUgmp
 * @see RespuestaTransaccionUgmp
 */
@Component("transaccionUgmp")
public class TransaccionUgmp implements InvocadorTransaccion<PeticionTransaccionUgmp, RespuestaTransaccionUgmp> {

    @Autowired
    private ServicioTransacciones servicioTransacciones;

    @Override
    public RespuestaTransaccionUgmp invocar(PeticionTransaccionUgmp transaccion) throws ExcepcionTransaccion {
        return servicioTransacciones.invocar(PeticionTransaccionUgmp.class, RespuestaTransaccionUgmp.class, transaccion);
    }

    @Override
    public RespuestaTransaccionUgmp invocarCache(PeticionTransaccionUgmp transaccion) throws ExcepcionTransaccion {
        return servicioTransacciones.invocar(PeticionTransaccionUgmp.class, RespuestaTransaccionUgmp.class, transaccion);
    }

    @Override
    public void vaciarCache() {
    }
}