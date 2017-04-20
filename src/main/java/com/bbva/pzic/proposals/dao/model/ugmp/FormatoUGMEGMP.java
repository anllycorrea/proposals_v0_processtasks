package com.bbva.pzic.proposals.dao.model.ugmp;


import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.Formato;
import com.bbva.jee.arq.spring.core.host.TipoCampo;

/**
 * Formato de datos <code>UGMEGMP</code> de la transacci&oacute;n <code>UGMP</code>
 * 
 * @author Arquitectura Spring BBVA
 */
@Formato(nombre = "UGMEGMP")
@RooJavaBean
@RooToString
@RooSerializable
public class FormatoUGMEGMP {

	/**
	 * <p>Campo <code>NROCONT</code>, &iacute;ndice: <code>1</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 1, nombre = "NROCONT", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 18, longitudMaxima = 18)
	private String nrocont;
	
	/**
	 * <p>Campo <code>INDESTA</code>, &iacute;ndice: <code>2</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 2, nombre = "INDESTA", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 1, longitudMaxima = 1)
	private String indesta;
	
	/**
	 * <p>Campo <code>MAILCON</code>, &iacute;ndice: <code>3</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 3, nombre = "MAILCON", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 50, longitudMaxima = 50)
	private String mailcon;
	
	/**
	 * <p>Campo <code>TIPENVI</code>, &iacute;ndice: <code>4</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 4, nombre = "TIPENVI", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 1, longitudMaxima = 1)
	private String tipenvi;
	
}