package com.bbva.pzic.proposals.dao.model.pcunt001_1;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.FilaCampoTabular;
import com.bbva.jee.arq.spring.core.host.TipoCampo;

import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.javabean.annotations.RooSerializable;

/**
 * <p>Bean fila para el campo tabular <code>contacts</code>, utilizado por la clase <code>Participant</code></p>
 * 
 * @see Participant
 * 
 * @author Arquitectura Spring BBVA
 */
@FilaCampoTabular
@RooJavaBean
@RooToString
@RooSerializable
public class Contacts {
	
	/**
	 * <p>Campo <code>contact</code>, &iacute;ndice: <code>1</code>, tipo: <code>DTO</code>
	 */
	@Campo(indice = 1, nombre = "contact", tipo = TipoCampo.DTO)
	private Contact contact;
	
}