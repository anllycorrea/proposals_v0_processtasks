package com.bbva.pzic.proposals.dao.model.hyt6;


import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.Formato;
import com.bbva.jee.arq.spring.core.host.TipoCampo;

/**
 * Formato de datos <code>HYMR601</code> de la transacci&oacute;n <code>HYT6</code>
 * 
 * @author Arquitectura Spring BBVA
 */
@Formato(nombre = "HYMR601")
@RooJavaBean
@RooToString
@RooSerializable
public class FormatoHYMR601 {

	/**
	 * <p>Campo <code>TIPO</code>, &iacute;ndice: <code>1</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 1, nombre = "TIPO", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 1, longitudMaxima = 1)
	private String tipo;
	
	/**
	 * <p>Campo <code>NUMERO</code>, &iacute;ndice: <code>2</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 2, nombre = "NUMERO", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 11, longitudMaxima = 11)
	private String numero;
	
	/**
	 * <p>Campo <code>CODCENT</code>, &iacute;ndice: <code>3</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 3, nombre = "CODCENT", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 8, longitudMaxima = 8)
	private String codcent;
	
}