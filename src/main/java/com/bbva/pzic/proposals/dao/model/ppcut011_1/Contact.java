package com.bbva.pzic.proposals.dao.model.ppcut011_1;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.FilaCampoTabular;
import com.bbva.jee.arq.spring.core.host.TipoCampo;

import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.javabean.annotations.RooSerializable;

/**
 * <p>Bean fila para el campo tabular <code>contact</code>, utilizado por la clase <code>Contacts</code></p>
 * 
 * @see Contacts
 * 
 * @author Arquitectura Spring BBVA
 */
@FilaCampoTabular
@RooJavaBean
@RooSerializable
public class Contact {
	
	/**
	 * <p>Campo <code>contactDetailType</code>, &iacute;ndice: <code>1</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 1, nombre = "contactDetailType", tipo = TipoCampo.ALFANUMERICO, longitudMaxima = 50, signo = true, obligatorio = true)
	private String contactdetailtype;
	
	/**
	 * <p>Campo <code>number</code>, &iacute;ndice: <code>2</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 2, nombre = "number", tipo = TipoCampo.ALFANUMERICO, longitudMaxima = 50, signo = true)
	private String number;
	
	/**
	 * <p>Campo <code>phoneCompany</code>, &iacute;ndice: <code>3</code>, tipo: <code>DTO</code>
	 */
	@Campo(indice = 3, nombre = "phoneCompany", tipo = TipoCampo.DTO)
	private Phonecompany phonecompany;
	
	/**
	 * <p>Campo <code>address</code>, &iacute;ndice: <code>4</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 4, nombre = "address", tipo = TipoCampo.ALFANUMERICO, longitudMaxima = 100, signo = true)
	private String address;
	
}