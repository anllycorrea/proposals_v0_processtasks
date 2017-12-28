package com.bbva.pzic.proposals.dao.model.hyt6;

import java.math.BigDecimal;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.TipoCampo;
import com.bbva.jee.arq.spring.core.host.Formato;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;


/**
 * Formato de datos <code>HYMR602</code> de la transacci&oacute;n <code>HYT6</code>
 * 
 * @author Arquitectura Spring BBVA
 */
@Formato(nombre = "HYMR602")
@RooJavaBean
@RooToString
@RooSerializable
public class FormatoHYMR602 {
	
	/**
	 * <p>Campo <code>ID</code>, &iacute;ndice: <code>1</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 1, nombre = "ID", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 10, longitudMaxima = 10)
	private String id;
	
	/**
	 * <p>Campo <code>TIPPRO</code>, &iacute;ndice: <code>2</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 2, nombre = "TIPPRO", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 2, longitudMaxima = 2)
	private String tippro;
	
	/**
	 * <p>Campo <code>TEA</code>, &iacute;ndice: <code>3</code>, tipo: <code>DECIMAL</code>
	 */
	@Campo(indice = 3, nombre = "TEA", tipo = TipoCampo.DECIMAL, longitudMinima = 10, longitudMaxima = 10, decimales = 7)
	private BigDecimal tea;
	
	/**
	 * <p>Campo <code>PLAZO</code>, &iacute;ndice: <code>4</code>, tipo: <code>ENTERO</code>
	 */
	@Campo(indice = 4, nombre = "PLAZO", tipo = TipoCampo.ENTERO, longitudMinima = 4, longitudMaxima = 4)
	private Integer plazo;
	
	/**
	 * <p>Campo <code>TIPPLAZ</code>, &iacute;ndice: <code>5</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 5, nombre = "TIPPLAZ", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 1, longitudMaxima = 1)
	private String tipplaz;
	
	/**
	 * <p>Campo <code>CUOPRD</code>, &iacute;ndice: <code>6</code>, tipo: <code>DECIMAL</code>
	 */
	@Campo(indice = 6, nombre = "CUOPRD", tipo = TipoCampo.DECIMAL, longitudMinima = 15, longitudMaxima = 15, decimales = 2)
	private BigDecimal cuoprd;
	
	/**
	 * <p>Campo <code>MONTPRD</code>, &iacute;ndice: <code>7</code>, tipo: <code>DECIMAL</code>
	 */
	@Campo(indice = 7, nombre = "MONTPRD", tipo = TipoCampo.DECIMAL, longitudMinima = 15, longitudMaxima = 15, decimales = 2)
	private BigDecimal montprd;
	
	/**
	 * <p>Campo <code>MONEDA</code>, &iacute;ndice: <code>8</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 8, nombre = "MONEDA", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 3, longitudMaxima = 3)
	private String moneda;
	
}