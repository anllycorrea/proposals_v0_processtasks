package com.bbva.pzic.proposals.v0.processtasks.dao.model.ppcutge1_1;

import com.bbva.jee.arq.spring.core.host.Cabecera;
import com.bbva.jee.arq.spring.core.host.NombreCabecera;
import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.Formato;
import com.bbva.jee.arq.spring.core.host.RespuestaTransaccion;
import com.bbva.jee.arq.spring.core.host.TipoCampo;

import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.javabean.annotations.RooSerializable;



/**
 * Bean de respuesta para la transacci&oacute;n <code>PPCUTGE1</code>
 * 
 * @see PeticionTransaccionPpcutge1_1
 */
@RespuestaTransaccion
@Formato(nombre = "1")
@RooJavaBean
@RooSerializable
public class RespuestaTransaccionPpcutge1_1 {
	
	/**
	 * <p>Cabecera <code>COD-AVISO</code></p>
	 */
	@Cabecera(nombre=NombreCabecera.CODIGO_AVISO)
	private String codigoAviso;
	
	/**
	 * <p>Cabecera <code>DES-AVISO</code></p>
	 */
	@Cabecera(nombre=NombreCabecera.DESCRIPCION_AVISO)
	private String descripcionAviso;
	
	/**
	 * <p>Cabecera <code>COD-UUAA-AVISO</code></p>
	 */
	@Cabecera(nombre=NombreCabecera.APLICACION_AVISO)
	private String aplicacionAviso;
	
	/**
	 * <p>Cabecera <code>COD-RETORNO</code></p>
	 */
	@Cabecera(nombre=NombreCabecera.CODIGO_RETORNO)
	private String codigoRetorno;
	
	/**
	 * <p>Campo <code>campo_1_businessProcessId</code>, &iacute;ndice: <code>1</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 1, nombre = "businessProcessId", tipo = TipoCampo.ALFANUMERICO, longitudMaxima = 40, signo = true, obligatorio = true)
	private String campo_1_businessprocessid;
	
	/**
	 * <p>Campo <code>campo_2_taskId</code>, &iacute;ndice: <code>2</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 2, nombre = "taskId", tipo = TipoCampo.ALFANUMERICO, longitudMaxima = 10, signo = true, obligatorio = true)
	private String campo_2_taskid;
	
	/**
	 * <p>Campo <code>status</code>, &iacute;ndice: <code>3</code>, tipo: <code>DTO</code>
	 */
	@Campo(indice = 3, nombre = "status", tipo = TipoCampo.DTO)
	private Status status;
	
}