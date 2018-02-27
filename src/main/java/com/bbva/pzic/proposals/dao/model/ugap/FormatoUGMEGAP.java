package com.bbva.pzic.proposals.dao.model.ugap;


import com.bbva.jee.arq.spring.core.auditoria.DatoAuditable;
import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.Formato;
import com.bbva.jee.arq.spring.core.host.TipoCampo;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;

import java.math.BigDecimal;

/**
 * Formato de datos <code>UGMEGAP</code> de la transacci&oacute;n <code>UGAP</code>
 *
 * @author Arquitectura Spring BBVA
 */
@Formato(nombre = "UGMEGAP")
@RooJavaBean
@RooToString
@RooSerializable
public class FormatoUGMEGAP {

    /**
     * <p>Campo <code>TIPDOCU</code>, &iacute;ndice: <code>1</code>, tipo: <code>ALFANUMERICO</code>
     */
    @Campo(indice = 1, nombre = "TIPDOCU", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 1, longitudMaxima = 1)
    private String tipdocu;

    /**
     * <p>Campo <code>NRODOCU</code>, &iacute;ndice: <code>2</code>, tipo: <code>ALFANUMERICO</code>
     */
    @DatoAuditable(omitir = true)
    @Campo(indice = 2, nombre = "NRODOCU", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 10, longitudMaxima = 10)
    private String nrodocu;

    /**
     * <p>Campo <code>TARIFA</code>, &iacute;ndice: <code>3</code>, tipo: <code>ALFANUMERICO</code>
     */
    @Campo(indice = 3, nombre = "TARIFA", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 10, longitudMaxima = 10)
    private String tarifa;

    /**
     * <p>Campo <code>IMPFINA</code>, &iacute;ndice: <code>4</code>, tipo: <code>DECIMAL</code>
     */
    @Campo(indice = 4, nombre = "IMPFINA", tipo = TipoCampo.DECIMAL, longitudMinima = 17, longitudMaxima = 17, decimales = 2)
    private BigDecimal impfina;

    /**
     * <p>Campo <code>DIAFACT</code>, &iacute;ndice: <code>5</code>, tipo: <code>ENTERO</code>
     */
    @Campo(indice = 5, nombre = "DIAFACT", tipo = TipoCampo.ENTERO, longitudMinima = 2, longitudMaxima = 2)
    private Integer diafact;

    /**
     * <p>Campo <code>DIAPAGO</code>, &iacute;ndice: <code>6</code>, tipo: <code>ENTERO</code>
     */
    @Campo(indice = 6, nombre = "DIAPAGO", tipo = TipoCampo.ENTERO, longitudMinima = 2, longitudMaxima = 2)
    private Integer diapago;

    /**
     * <p>Campo <code>MAILCON</code>, &iacute;ndice: <code>7</code>, tipo: <code>ALFANUMERICO</code>
     */
    @DatoAuditable(omitir = true)
    @Campo(indice = 7, nombre = "MAILCON", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 50, longitudMaxima = 50)
    private String mailcon;

    /**
     * <p>Campo <code>TIPENVI</code>, &iacute;ndice: <code>8</code>, tipo: <code>ALFANUMERICO</code>
     */
    @Campo(indice = 8, nombre = "TIPENVI", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 1, longitudMaxima = 1)
    private String tipenvi;

    /**
     * <p>Campo <code>MONEDA</code>, &iacute;ndice: <code>9</code>, tipo: <code>ALFANUMERICO</code>
     */
    @Campo(indice = 9, nombre = "MONEDA", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 3, longitudMaxima = 3)
    private String moneda;

    /**
     * <p>Campo <code>IDTOKEN</code>, &iacute;ndice: <code>10</code>, tipo: <code>ALFANUMERICO</code>
     */
    @Campo(indice = 10, nombre = "IDTOKEN", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 32, longitudMaxima = 32)
    private String idtoken;

    /**
     * <p>Campo <code>IMPBIEN</code>, &iacute;ndice: <code>11</code>, tipo: <code>DECIMAL</code>
     */
    @Campo(indice = 11, nombre = "IMPBIEN", tipo = TipoCampo.DECIMAL, longitudMinima = 17, longitudMaxima = 17, decimales = 2)
    private BigDecimal impbien;

    /**
     * <p>Campo <code>CODBIEN</code>, &iacute;ndice: <code>12</code>, tipo: <code>ALFANUMERICO</code>
     */
    @Campo(indice = 12, nombre = "CODBIEN", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 15, longitudMaxima = 15)
    private String codbien;

    /**
     * <p>Campo <code>CODTR</code>, &iacute;ndice: <code>13</code>, tipo: <code>ALFANUMERICO</code>
     */
    @Campo(indice = 13, nombre = "CODTR", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 5, longitudMaxima = 5)
    private String codtr;

    /**
     * <p>Campo <code>CODCNC</code>, &iacute;ndice: <code>14</code>, tipo: <code>ALFANUMERICO</code>
     */
    @Campo(indice = 14, nombre = "CODCNC", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 5, longitudMaxima = 5)
    private String codcnc;

    /**
     * <p>Campo <code>CODEMP</code>, &iacute;ndice: <code>15</code>, tipo: <code>ALFANUMERICO</code>
     */
    @Campo(indice = 15, nombre = "CODEMP", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 4, longitudMaxima = 4)
    private String codemp;

    /**
     * <p>Campo <code>COCLIEX</code>, &iacute;ndice: <code>16</code>, tipo: <code>ALFANUMERICO</code>
     */
    @Campo(indice = 16, nombre = "COCLIEX", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 34, longitudMaxima = 34)
    private String cocliex;

    /**
     * <p>Campo <code>CODOFIC</code>, &iacute;ndice: <code>17</code>, tipo: <code>ALFANUMERICO</code>
     */
    @Campo(indice = 17, nombre = "CODOFIC", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 4, longitudMaxima = 4)
    private String codofic;

}