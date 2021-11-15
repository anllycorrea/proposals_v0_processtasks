package com.bbva.pzic.proposals.v0.processtasks.dao.model.ppcutge1_1;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.FilaCampoTabular;
import com.bbva.jee.arq.spring.core.host.TipoCampo;

import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.javabean.annotations.RooSerializable;

/**
 * <p>Bean fila para el campo tabular <code>status</code>, utilizado por la clase <code>RespuestaTransaccionPpcutge1_1</code></p>
 * 
 * @see RespuestaTransaccionPpcutge1_1
 * 
 * @author Arquitectura Spring BBVA
 */
@FilaCampoTabular
@RooJavaBean
@RooSerializable
public class Status {
	
	/**
	 * <p>Campo <code>id</code>, &iacute;ndice: <code>1</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 1, nombre = "id", tipo = TipoCampo.ALFANUMERICO, longitudMaxima = 20, signo = true, obligatorio = true)
	private String id;
	
	/**
	 * <p>Campo <code>description</code>, &iacute;ndice: <code>2</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 2, nombre = "description", tipo = TipoCampo.ALFANUMERICO, longitudMaxima = 100, signo = true, obligatorio = true)
	private String description;
	
}