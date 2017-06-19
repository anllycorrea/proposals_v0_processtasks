package com.bbva.pzic.proposals.dao.model.uglp;


import java.util.Date;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.Formato;
import com.bbva.jee.arq.spring.core.host.TipoCampo;

/**
 * Formato de datos <code>UGMEGLP</code> de la transacci&oacute;n <code>UGLP</code>
 * 
 * @author Arquitectura Spring BBVA
 */
@Formato(nombre = "UGMEGLP")
@RooJavaBean
@RooToString
@RooSerializable
public class FormatoUGMEGLP {

	/**
	 * <p>Campo <code>TIPDOCU</code>, &iacute;ndice: <code>1</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 1, nombre = "TIPDOCU", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 1, longitudMaxima = 1)
	private String tipdocu;
	
	/**
	 * <p>Campo <code>NRODOCU</code>, &iacute;ndice: <code>2</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 2, nombre = "NRODOCU", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 10, longitudMaxima = 10)
	private String nrodocu;
	
	/**
	 * <p>Campo <code>CODEMP</code>, &iacute;ndice: <code>3</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 3, nombre = "CODEMP", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 4, longitudMaxima = 4)
	private String codemp;
	
	/**
	 * <p>Campo <code>TIPBIEN</code>, &iacute;ndice: <code>4</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 4, nombre = "TIPBIEN", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 2, longitudMaxima = 2)
	private String tipbien;
	
	/**
	 * <p>Campo <code>FECRDES</code>, &iacute;ndice: <code>5</code>, tipo: <code>FECHA</code>
	 */
	@Campo(indice = 5, nombre = "FECRDES", tipo = TipoCampo.FECHA, longitudMinima = 10, longitudMaxima = 10, formato = "yyyy-MM-dd")
	private Date fecrdes;
	
	/**
	 * <p>Campo <code>FECRHAS</code>, &iacute;ndice: <code>6</code>, tipo: <code>FECHA</code>
	 */
	@Campo(indice = 6, nombre = "FECRHAS", tipo = TipoCampo.FECHA, longitudMinima = 10, longitudMaxima = 10, formato = "yyyy-MM-dd")
	private Date fecrhas;
	
	/**
	 * <p>Campo <code>IDPAGIN</code>, &iacute;ndice: <code>7</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 7, nombre = "IDPAGIN", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 18, longitudMaxima = 18)
	private String idpagin;
	
	/**
	 * <p>Campo <code>TAMPAGI</code>, &iacute;ndice: <code>8</code>, tipo: <code>ENTERO</code>
	 */
	@Campo(indice = 8, nombre = "TAMPAGI", tipo = TipoCampo.ENTERO, longitudMinima = 2, longitudMaxima = 2)
	private Integer tampagi;
	
}