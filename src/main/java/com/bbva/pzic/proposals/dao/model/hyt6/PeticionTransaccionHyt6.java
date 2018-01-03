package com.bbva.pzic.proposals.dao.model.hyt6;

import com.bbva.jee.arq.spring.core.host.Atributo;
import com.bbva.jee.arq.spring.core.host.Cuerpo;
import com.bbva.jee.arq.spring.core.host.CuerpoMultiparte;
import com.bbva.jee.arq.spring.core.host.MensajeMultiparte;
import com.bbva.jee.arq.spring.core.host.Multiformato;
import com.bbva.jee.arq.spring.core.host.Transaccion;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;

/**
 * <p>Transacci&oacute;n <code>HYT6</code></p>
 * <p>Informaci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Tipo:</b> 1</li>
 *    <li><b>Subtipo:</b> 1</li>
 *    <li><b>Versi&oacute;n:</b> 1</li>
 *    <li><b>Clase de petici&oacute;n:</b> PeticionTransaccionHyt6</li>
 *    <li><b>Clase de respuesta:</b> RespuestaTransaccionHyt6</li>
 * </ul>
 * </p>
 * <p>Configuraci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Nombre configuraci&oacute;n:</b> default_ps9_mx</li>
 * </ul>
 * </p>
 * <p>Copy de la transacci&oacute;n:</p>
 * <code><pre> * FICHERO: PEBT.QGFD.FIX.QGDTCCT.HYT6.D1171222
 * HYT6LISTADO DE PROPUESTAS              HY        HY2C00T6PBDHYPO HYMR601             HYT6  NN0000CNNNNN    SSTN     E  NNNSSNNN  NN                2017-11-10XP92352 2017-11-1509.26.34XP92354 2017-11-10-10.04.03.643216XP92352 0001-01-010001-01-01
 * FICHERO: PEBT.QGFD.FIX.QGDTFDF.HYMR601.D1171222
 * HYMR601 �NRO DE SOLICITUD              �F�03�00020�01�00001�TIPO   �TIPO DOCUMENTO      �A�001�0�O�        �
 * HYMR601 �NRO DE SOLICITUD              �F�03�00020�02�00002�NUMERO �NUMERO DOCUMENTO    �A�011�0�O�        �
 * HYMR601 �NRO DE SOLICITUD              �F�03�00020�03�00013�CODCENT�C�DIGO CENTRAL      �A�008�0�O�        �
 * FICHERO: PEBT.QGFD.FIX.QGDTFDF.HYMR602.D1171222
 * HYMR602 �NRO DE SOLICITUD              �X�08�00060�01�00001�ID     �IDENTIF UNICO PERSON�A�010�0�S�        �
 * HYMR602 �NRO DE SOLICITUD              �X�08�00060�02�00011�TIPPRO �TIPO PRODUCTO       �A�002�0�S�        �
 * HYMR602 �NRO DE SOLICITUD              �X�08�00060�03�00013�TEA    �TASA                �N�010�7�S�        �
 * HYMR602 �NRO DE SOLICITUD              �X�08�00060�04�00023�PLAZO  �PLAZO               �N�004�0�S�        �
 * HYMR602 �NRO DE SOLICITUD              �X�08�00060�05�00027�TIPPLAZ�TIPO PLAZO PRODUCTO �A�001�0�S�        �
 * HYMR602 �NRO DE SOLICITUD              �X�08�00060�06�00028�CUOPRD �CUOTA MAXIMA        �N�015�2�S�        �
 * HYMR602 �NRO DE SOLICITUD              �X�08�00060�07�00043�MONTPRD�MONTO MAX PARA PREST�N�015�2�S�        �
 * HYMR602 �NRO DE SOLICITUD              �X�08�00060�08�00058�MONEDA �MONEDA ASOC PROPUEST�A�003�0�S�        �
 * FICHERO: PEBT.QGFD.FIX.QGDTFDX.HYT6.D1171222
 * HYT6HYMR602 HYNCR602HY2C00T61S                             XP92354 2017-11-15-13.58.27.332268XP92354 2017-11-15-13.58.31.490608
</pre></code>
 * 
 * @see RespuestaTransaccionHyt6
 *
 * @author Arquitectura Spring BBVA
 */
@Transaccion(
	nombre = "HYT6",
	tipo = 1, 
	subtipo = 1,	
	version = 1,
	configuracion = "default_ps9_mx",
	respuesta = RespuestaTransaccionHyt6.class,
	atributos = {@Atributo(nombre = "altamiraExtendido", valor = "true"), @Atributo(nombre = "tipoCopy", valor = "FIJA")}
)
@Multiformato(formatos = {FormatoHYMR601.class})
@RooJavaBean
@RooToString
@RooSerializable
public class PeticionTransaccionHyt6 implements MensajeMultiparte {
	
	/**
	 * <p>Cuerpo del mensaje de petici&oacute;n multiparte</p>
	 */
	@Cuerpo
	private CuerpoMultiparte cuerpo = new CuerpoMultiparte();
	
	/**
	 * <p>Permite obtener el cuerpo del mensaje de petici&oacute;n multiparte</p>
	 */
	@Override
	public CuerpoMultiparte getCuerpo() {
		return cuerpo;
	}
	
}