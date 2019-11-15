package com.bbva.pzic.proposals.dao.model.pcunt001_1;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.FilaCampoTabular;
import com.bbva.jee.arq.spring.core.host.TipoCampo;

import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.javabean.annotations.RooSerializable;

/**
 * <p>Bean fila para el campo tabular <code>identityDocument</code>, utilizado por la clase <code>Participant</code></p>
 * 
 * @see Participant
 * 
 * @author Arquitectura Spring BBVA
 */
@FilaCampoTabular
@RooJavaBean
@RooToString
@RooSerializable
public class Identitydocument {
	
	/**
	 * <p>Campo <code>documentType</code>, &iacute;ndice: <code>1</code>, tipo: <code>DTO</code>
	 */
	@Campo(indice = 1, nombre = "documentType", tipo = TipoCampo.DTO)
	private Documenttype documenttype;
	
	/**
	 * <p>Campo <code>documentNumber</code>, &iacute;ndice: <code>2</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 2, nombre = "documentNumber", tipo = TipoCampo.ALFANUMERICO, longitudMaxima = 50, signo = true, obligatorio = true)
	private String documentnumber;
	
}