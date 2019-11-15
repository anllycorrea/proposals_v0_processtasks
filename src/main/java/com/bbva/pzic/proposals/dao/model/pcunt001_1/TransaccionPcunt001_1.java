package com.bbva.pzic.proposals.dao.model.pcunt001_1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;

/**
 * Invocador de la transacci&oacute;n <code>PCUNT001</code>
 * 
 * @see PeticionTransaccionPcunt001_1
 * @see RespuestaTransaccionPcunt001_1
 */
@Component
public class TransaccionPcunt001_1 implements InvocadorTransaccion<PeticionTransaccionPcunt001_1,RespuestaTransaccionPcunt001_1> {
	
	@Autowired
	private ServicioTransacciones servicioTransacciones;
	
	@Override
	public RespuestaTransaccionPcunt001_1 invocar(PeticionTransaccionPcunt001_1 transaccion) throws ExcepcionTransaccion {
		return servicioTransacciones.invocar(PeticionTransaccionPcunt001_1.class, RespuestaTransaccionPcunt001_1.class, transaccion);
	}
	
	@Override
	public RespuestaTransaccionPcunt001_1 invocarCache(PeticionTransaccionPcunt001_1 transaccion) throws ExcepcionTransaccion {
		return servicioTransacciones.invocar(PeticionTransaccionPcunt001_1.class, RespuestaTransaccionPcunt001_1.class, transaccion);
	}
	
	@Override
	public void vaciarCache() {}	
}