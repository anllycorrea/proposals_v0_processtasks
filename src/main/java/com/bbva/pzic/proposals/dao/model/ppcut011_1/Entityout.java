package com.bbva.pzic.proposals.dao.model.ppcut011_1;

import java.util.List;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.FilaCampoTabular;
import com.bbva.jee.arq.spring.core.host.TipoCampo;

import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.javabean.annotations.RooSerializable;

/**
 * <p>Bean fila para el campo tabular <code>EntityOut</code>, utilizado por la clase <code>RespuestaTransaccionPpcut011_1</code></p>
 * 
 * @see RespuestaTransaccionPpcut011_1
 * 
 * @author Arquitectura Spring BBVA
 */
@FilaCampoTabular
@RooJavaBean
@RooSerializable
public class Entityout {
	
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
	
	/**
	 * <p>Campo <code>validationDictum</code>, &iacute;ndice: <code>3</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 3, nombre = "validationDictum", tipo = TipoCampo.ALFANUMERICO, longitudMaxima = 50, signo = true, obligatorio = true)
	private String validationdictum;
	
	/**
	 * <p>Campo <code>dictumReasons</code>, &iacute;ndice: <code>4</code>, tipo: <code>LIST</code>
	 */
	@Campo(indice = 4, nombre = "dictumReasons", tipo = TipoCampo.LIST)
	private List<Dictumreasons> dictumreasons;
	
}