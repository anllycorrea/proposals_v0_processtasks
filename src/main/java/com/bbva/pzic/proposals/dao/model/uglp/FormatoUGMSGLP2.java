package com.bbva.pzic.proposals.dao.model.uglp;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.TipoCampo;
import com.bbva.jee.arq.spring.core.host.Formato;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;


/**
 * Formato de datos <code>UGMSGLP2</code> de la transacci&oacute;n <code>UGLP</code>
 * 
 * @author Arquitectura Spring BBVA
 */
@Formato(nombre = "UGMSGLP2")
@RooJavaBean
@RooToString
@RooSerializable
public class FormatoUGMSGLP2 {
	
	/**
	 * <p>Campo <code>IDPAGIN</code>, &iacute;ndice: <code>1</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 1, nombre = "IDPAGIN", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 18, longitudMaxima = 18)
	private String idpagin;
	
	/**
	 * <p>Campo <code>TAMPAGI</code>, &iacute;ndice: <code>2</code>, tipo: <code>ENTERO</code>
	 */
	@Campo(indice = 2, nombre = "TAMPAGI", tipo = TipoCampo.ENTERO, longitudMinima = 2, longitudMaxima = 2)
	private Integer tampagi;
	
}