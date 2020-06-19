package com.bbva.pzic.proposals.dao.model.ppcut011_1;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.FilaCampoTabular;
import com.bbva.jee.arq.spring.core.host.TipoCampo;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooSerializable;

import java.util.List;

/**
 * <p>Bean fila para el campo tabular <code>participant</code>, utilizado por la clase <code>Entityin</code></p>
 * 
 * @see Entityin
 * 
 * @author Arquitectura Spring BBVA
 */
@FilaCampoTabular
@RooJavaBean
@RooSerializable
public class Participant {
	
	/**
	 * <p>Campo <code>id</code>, &iacute;ndice: <code>1</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 1, nombre = "id", tipo = TipoCampo.ALFANUMERICO, longitudMaxima = 50, signo = true, obligatorio = true)
	private String id;
	
	/**
	 * <p>Campo <code>contacts</code>, &iacute;ndice: <code>2</code>, tipo: <code>LIST</code>
	 */
	@Campo(indice = 2, nombre = "contacts", tipo = TipoCampo.LIST)
	private List<Contacts> contacts;
	
	/**
	 * <p>Campo <code>identityDocument</code>, &iacute;ndice: <code>3</code>, tipo: <code>DTO</code>
	 */
	@Campo(indice = 3, nombre = "identityDocument", tipo = TipoCampo.DTO)
	private Identitydocument identitydocument;
	
}