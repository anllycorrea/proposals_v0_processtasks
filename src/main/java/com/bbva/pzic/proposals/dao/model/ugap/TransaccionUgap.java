package com.bbva.pzic.proposals.dao.model.ugap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;

/**
 * Invocador de la transacci&oacute;n <code>UGAP</code>
 * 
 * @see PeticionTransaccionUgap
 * @see RespuestaTransaccionUgap
 */
@Component
public class TransaccionUgap implements InvocadorTransaccion<PeticionTransaccionUgap,RespuestaTransaccionUgap> {
	
	@Autowired
	private ServicioTransacciones servicioTransacciones;
	
	@Override
	public RespuestaTransaccionUgap invocar(PeticionTransaccionUgap transaccion) throws ExcepcionTransaccion {
		return servicioTransacciones.invocar(PeticionTransaccionUgap.class, RespuestaTransaccionUgap.class, transaccion);
	}
	
	@Override
	public RespuestaTransaccionUgap invocarCache(PeticionTransaccionUgap transaccion) throws ExcepcionTransaccion {
		return servicioTransacciones.invocar(PeticionTransaccionUgap.class, RespuestaTransaccionUgap.class, transaccion);
	}
	
	@Override
	public void vaciarCache() {}	
}