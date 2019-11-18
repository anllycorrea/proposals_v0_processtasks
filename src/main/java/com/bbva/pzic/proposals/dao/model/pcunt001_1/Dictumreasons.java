package com.bbva.pzic.proposals.dao.model.pcunt001_1;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.FilaCampoTabular;
import com.bbva.jee.arq.spring.core.host.TipoCampo;

import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.javabean.annotations.RooSerializable;

/**
 * <p>Bean fila para el campo tabular <code>dictumReasons</code>, utilizado por la clase <code>Entityout</code></p>
 * 
 * @see Entityout
 * 
 * @author Arquitectura Spring BBVA
 */
@FilaCampoTabular
@RooJavaBean
@RooSerializable
public class Dictumreasons {
	
	/**
	 * <p>Campo <code>dictumReason</code>, &iacute;ndice: <code>1</code>, tipo: <code>DTO</code>
	 */
	@Campo(indice = 1, nombre = "dictumReason", tipo = TipoCampo.DTO)
	private Dictumreason dictumreason;
	
}