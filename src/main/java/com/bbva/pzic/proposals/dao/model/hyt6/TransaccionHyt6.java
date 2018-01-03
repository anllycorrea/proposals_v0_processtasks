package com.bbva.pzic.proposals.dao.model.hyt6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;

/**
 * Invocador de la transacci&oacute;n <code>HYT6</code>
 * 
 * @see PeticionTransaccionHyt6
 * @see RespuestaTransaccionHyt6
 */
@Component("transaccionHyt6")
public class TransaccionHyt6 implements InvocadorTransaccion<PeticionTransaccionHyt6,RespuestaTransaccionHyt6> {
	
	@Autowired
	private ServicioTransacciones servicioTransacciones;
	
	@Override
	public RespuestaTransaccionHyt6 invocar(PeticionTransaccionHyt6 transaccion) throws ExcepcionTransaccion {
		return servicioTransacciones.invocar(PeticionTransaccionHyt6.class, RespuestaTransaccionHyt6.class, transaccion);
	}
	
	@Override
	public RespuestaTransaccionHyt6 invocarCache(PeticionTransaccionHyt6 transaccion) throws ExcepcionTransaccion {
		return servicioTransacciones.invocar(PeticionTransaccionHyt6.class, RespuestaTransaccionHyt6.class, transaccion);
	}
	
	@Override
	public void vaciarCache() {}	
}