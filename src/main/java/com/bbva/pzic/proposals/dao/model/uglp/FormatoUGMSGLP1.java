package com.bbva.pzic.proposals.dao.model.uglp;

import com.bbva.jee.arq.spring.core.auditoria.DatoAuditable;
import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.Formato;
import com.bbva.jee.arq.spring.core.host.TipoCampo;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooSerializable;
import org.springframework.roo.addon.javabean.annotations.RooToString;

import java.math.BigDecimal;


/**
 * Formato de datos <code>UGMSGLP1</code> de la transacci&oacute;n <code>UGLP</code>
 *
 * @author Arquitectura Spring BBVA
 */
@Formato(nombre = "UGMSGLP1")
@RooJavaBean
@RooToString
@RooSerializable
public class FormatoUGMSGLP1 {

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
	 * <p>Campo <code>DESESTA</code>, &iacute;ndice: <code>3</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 3, nombre = "DESESTA", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 20, longitudMaxima = 20)
	private String desesta;

	/**
	 * <p>Campo <code>FESOLI</code>, &iacute;ndice: <code>4</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 4, nombre = "FESOLI", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 10, longitudMaxima = 10)
	private String fesoli;

	/**
	 * <p>Campo <code>MONEDA</code>, &iacute;ndice: <code>5</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 5, nombre = "MONEDA", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 3, longitudMaxima = 3)
	private String moneda;

	/**
	 * <p>Campo <code>IMPFINA</code>, &iacute;ndice: <code>6</code>, tipo: <code>DECIMAL</code>
	 */
	@Campo(indice = 6, nombre = "IMPFINA", tipo = TipoCampo.DECIMAL, longitudMinima = 17, longitudMaxima = 17, decimales = 2)
	private BigDecimal impfina;

	/**
	 * <p>Campo <code>CUOINI</code>, &iacute;ndice: <code>7</code>, tipo: <code>DECIMAL</code>
	 */
	@Campo(indice = 7, nombre = "CUOINI", tipo = TipoCampo.DECIMAL, longitudMinima = 17, longitudMaxima = 17, decimales = 2)
	private BigDecimal cuoini;

	/**
	 * <p>Campo <code>TARIFA</code>, &iacute;ndice: <code>8</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 8, nombre = "TARIFA", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 10, longitudMaxima = 10)
	private String tarifa;

	/**
	 * <p>Campo <code>TASASEG</code>, &iacute;ndice: <code>9</code>, tipo: <code>DECIMAL</code>
	 */
	@Campo(indice = 9, nombre = "TASASEG", tipo = TipoCampo.DECIMAL, longitudMinima = 8, longitudMaxima = 8, decimales = 5)
	private BigDecimal tasaseg;

	/**
	 * <p>Campo <code>CODSEG</code>, &iacute;ndice: <code>10</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 10, nombre = "CODSEG", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 4, longitudMaxima = 4)
	private String codseg;

	/**
	 * <p>Campo <code>DESCSEG</code>, &iacute;ndice: <code>11</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 11, nombre = "DESCSEG", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 40, longitudMaxima = 40)
	private String descseg;

	/**
	 * <p>Campo <code>TIPENVI</code>, &iacute;ndice: <code>12</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 12, nombre = "TIPENVI", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 1, longitudMaxima = 1)
	private String tipenvi;

	/**
	 * <p>Campo <code>DESENV</code>, &iacute;ndice: <code>13</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 13, nombre = "DESENV", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 10, longitudMaxima = 10)
	private String desenv;

	/**
	 * <p>Campo <code>FEDESEM</code>, &iacute;ndice: <code>14</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 14, nombre = "FEDESEM", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 10, longitudMaxima = 10)
	private String fedesem;

	/**
	 * <p>Campo <code>CODBIEN</code>, &iacute;ndice: <code>15</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 15, nombre = "CODBIEN", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 15, longitudMaxima = 15)
	private String codbien;

	/**
	 * <p>Campo <code>IMPBIEN</code>, &iacute;ndice: <code>16</code>, tipo: <code>DECIMAL</code>
	 */
	@Campo(indice = 16, nombre = "IMPBIEN", tipo = TipoCampo.DECIMAL, longitudMinima = 17, longitudMaxima = 17, decimales = 2)
	private BigDecimal impbien;

	/**
	 * <p>Campo <code>NOMBR</code>, &iacute;ndice: <code>17</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@DatoAuditable(omitir = true)
	@Campo(indice = 17, nombre = "NOMBR", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 20, longitudMaxima = 20)
	private String nombr;

	/**
	 * <p>Campo <code>APEPAT</code>, &iacute;ndice: <code>18</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@DatoAuditable(omitir = true)
	@Campo(indice = 18, nombre = "APEPAT", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 20, longitudMaxima = 20)
	private String apepat;

	/**
	 * <p>Campo <code>APEMAT</code>, &iacute;ndice: <code>19</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@DatoAuditable(omitir = true)
	@Campo(indice = 19, nombre = "APEMAT", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 20, longitudMaxima = 20)
	private String apemat;

	/**
	 * <p>Campo <code>MAILCON</code>, &iacute;ndice: <code>20</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@DatoAuditable(omitir = true)
	@Campo(indice = 20, nombre = "MAILCON", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 50, longitudMaxima = 50)
	private String mailcon;

	/**
	 * <p>Campo <code>IDTOKEN</code>, &iacute;ndice: <code>21</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@DatoAuditable(omitir = true)
	@Campo(indice = 21, nombre = "IDTOKEN", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 32, longitudMaxima = 32)
	private String idtoken;

}
