package com.bbva.pzic.proposals.dao.model.ppcut011_1;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.FilaCampoTabular;
import com.bbva.jee.arq.spring.core.host.TipoCampo;

import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.javabean.annotations.RooSerializable;

/**
 * <p>Bean fila para el campo tabular <code>EntityIn</code>, utilizado por la clase <code>PeticionTransaccionPpcut011_1</code></p>
 * 
 * @see PeticionTransaccionPpcut011_1
 * 
 * @author Arquitectura Spring BBVA
 */
@FilaCampoTabular
@RooJavaBean
@RooSerializable
public class Entityin {
	
	/**
	 * <p>Campo <code>product</code>, &iacute;ndice: <code>1</code>, tipo: <code>DTO</code>
	 */
	@Campo(indice = 1, nombre = "product", tipo = TipoCampo.DTO)
	private Product product;
	
	/**
	 * <p>Campo <code>participant</code>, &iacute;ndice: <code>2</code>, tipo: <code>DTO</code>
	 */
	@Campo(indice = 2, nombre = "participant", tipo = TipoCampo.DTO)
	private Participant participant;
	
}