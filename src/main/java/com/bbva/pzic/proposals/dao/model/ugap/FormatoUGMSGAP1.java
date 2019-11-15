package com.bbva.pzic.proposals.dao.model.ugap;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.TipoCampo;
import com.bbva.jee.arq.spring.core.host.Formato;

import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooSerializable;
import org.springframework.roo.addon.javabean.annotations.RooToString;


/**
 * Formato de datos <code>UGMSGAP1</code> de la transacci&oacute;n <code>UGAP</code>
 *
 * @author Arquitectura Spring BBVA
 */
@Formato(nombre = "UGMSGAP1")
@RooJavaBean
@RooToString
@RooSerializable
public class FormatoUGMSGAP1 {

	/**
	 * <p>Campo <code>NROCONT</code>, &iacute;ndice: <code>1</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 1, nombre = "NROCONT", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 18, longitudMaxima = 18)
	private String nrocont;

}
