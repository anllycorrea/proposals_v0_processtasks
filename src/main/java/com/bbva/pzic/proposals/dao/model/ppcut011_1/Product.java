package com.bbva.pzic.proposals.dao.model.ppcut011_1;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.FilaCampoTabular;
import com.bbva.jee.arq.spring.core.host.TipoCampo;

import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.javabean.annotations.RooSerializable;

/**
 * <p>Bean fila para el campo tabular <code>product</code>, utilizado por la clase <code>Entityin</code></p>
 * 
 * @see Entityin
 * 
 * @author Arquitectura Spring BBVA
 */
@FilaCampoTabular
@RooJavaBean
@RooSerializable
public class Product {
	
	/**
	 * <p>Campo <code>id</code>, &iacute;ndice: <code>1</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 1, nombre = "id", tipo = TipoCampo.ALFANUMERICO, longitudMaxima = 50, signo = true, obligatorio = true)
	private String id;
	
	/**
	 * <p>Campo <code>subproduct</code>, &iacute;ndice: <code>2</code>, tipo: <code>DTO</code>
	 */
	@Campo(indice = 2, nombre = "subproduct", tipo = TipoCampo.DTO)
	private Subproduct subproduct;
	
}