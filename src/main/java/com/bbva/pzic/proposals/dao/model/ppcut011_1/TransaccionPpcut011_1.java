package com.bbva.pzic.proposals.dao.model.ppcut011_1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;

/**
 * Invocador de la transacci&oacute;n <code>PPCUT011</code>
 * 
 * @see PeticionTransaccionPpcut011_1
 * @see RespuestaTransaccionPpcut011_1
 */
@Component
public class TransaccionPpcut011_1 implements InvocadorTransaccion<PeticionTransaccionPpcut011_1,RespuestaTransaccionPpcut011_1> {
	
	@Autowired
	private ServicioTransacciones servicioTransacciones;
	
	@Override
	public RespuestaTransaccionPpcut011_1 invocar(PeticionTransaccionPpcut011_1 transaccion) {
		return servicioTransacciones.invocar(PeticionTransaccionPpcut011_1.class, RespuestaTransaccionPpcut011_1.class, transaccion);
	}
	
	@Override
	public RespuestaTransaccionPpcut011_1 invocarCache(PeticionTransaccionPpcut011_1 transaccion) {
		return servicioTransacciones.invocar(PeticionTransaccionPpcut011_1.class, RespuestaTransaccionPpcut011_1.class, transaccion);
	}
	
	@Override
	public void vaciarCache() {
		//this method does not have to be used anymore
	}
}