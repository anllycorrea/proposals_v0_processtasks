package com.bbva.pzic.proposals.dao.model.ppcut011_1;

import com.bbva.jee.arq.spring.core.host.*;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooSerializable;


/**
 * Bean de respuesta para la transacci&oacute;n <code>PPCUT011</code>
 * 
 * @see PeticionTransaccionPpcut011_1
 */
@RespuestaTransaccion
@Formato(nombre = "1")
@RooJavaBean
@RooSerializable
public class RespuestaTransaccionPpcut011_1 {
	
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
	 * <p>Campo <code>EntityOut</code>, &iacute;ndice: <code>1</code>, tipo: <code>DTO</code>
	 */
	@Campo(indice = 1, nombre = "EntityOut", tipo = TipoCampo.DTO)
	private Entityout entityout;
	
}