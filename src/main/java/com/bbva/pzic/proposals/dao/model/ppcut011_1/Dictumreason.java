package com.bbva.pzic.proposals.dao.model.ppcut011_1;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.FilaCampoTabular;
import com.bbva.jee.arq.spring.core.host.TipoCampo;

import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.javabean.annotations.RooSerializable;

/**
 * <p>Bean fila para el campo tabular <code>dictumReason</code>, utilizado por la clase <code>Dictumreasons</code></p>
 * 
 * @see Dictumreasons
 * 
 * @author Arquitectura Spring BBVA
 */
@FilaCampoTabular
@RooJavaBean
@RooSerializable
public class Dictumreason {
	
	/**
	 * <p>Campo <code>id</code>, &iacute;ndice: <code>1</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 1, nombre = "id", tipo = TipoCampo.ALFANUMERICO, longitudMaxima = 50, signo = true, obligatorio = true)
	private String id;
	
	/**
	 * <p>Campo <code>description</code>, &iacute;ndice: <code>2</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 2, nombre = "description", tipo = TipoCampo.ALFANUMERICO, longitudMaxima = 100, signo = true, obligatorio = true)
	private String description;
	
}