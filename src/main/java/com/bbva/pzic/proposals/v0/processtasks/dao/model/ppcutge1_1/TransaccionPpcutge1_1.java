package com.bbva.pzic.proposals.v0.processtasks.dao.model.ppcutge1_1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;

/**
 * Invocador de la transacci&oacute;n <code>PPCUTGE1</code>
 * 
 * @see PeticionTransaccionPpcutge1_1
 * @see RespuestaTransaccionPpcutge1_1
 */
@Component
public class TransaccionPpcutge1_1 implements InvocadorTransaccion<PeticionTransaccionPpcutge1_1,RespuestaTransaccionPpcutge1_1> {
	
	@Autowired
	private ServicioTransacciones servicioTransacciones;
	
	@Override
	public RespuestaTransaccionPpcutge1_1 invocar(PeticionTransaccionPpcutge1_1 transaccion) {
		return servicioTransacciones.invocar(PeticionTransaccionPpcutge1_1.class, RespuestaTransaccionPpcutge1_1.class, transaccion);
	}
	
	@Override
	public RespuestaTransaccionPpcutge1_1 invocarCache(PeticionTransaccionPpcutge1_1 transaccion) {
		return servicioTransacciones.invocar(PeticionTransaccionPpcutge1_1.class, RespuestaTransaccionPpcutge1_1.class, transaccion);
	}
	
	@Override
	public void vaciarCache() {
		//this method does not have to be used anymore
	}
}