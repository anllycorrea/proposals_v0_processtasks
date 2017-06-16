package com.bbva.pzic.proposals.dao.model.ugap;

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
 * <p>Transacci&oacute;n <code>UGAP</code></p>
 * <p>Informaci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Tipo:</b> 1</li>
 *    <li><b>Subtipo:</b> 1</li>
 *    <li><b>Versi&oacute;n:</b> 1</li>
 *    <li><b>Clase de petici&oacute;n:</b> PeticionTransaccionUgap</li>
 *    <li><b>Clase de respuesta:</b> RespuestaTransaccionUgap</li>
 * </ul>
 * </p>
 * <p>Configuraci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Nombre configuraci&oacute;n:</b> default_ps9_mx</li>
 * </ul>
 * </p>
 * <p>Copy de la transacci&oacute;n:</p>
 * <code><pre> * FICHERO: PEBT.QGFD.FIX.QGDTCCT.UGAP.D1170613.txt
 * UGAPALTA PROPUESTA FINANCI. TELEFONICA UG        UG2CALPPPBDUGPO UGMEGAP             UGAP  NN3000CNNNNN    SSTN     E  NNNSSNNN  NN                2017-04-04P022422 2017-05-1110.50.23XP92403 2017-04-04-17.25.58.178851P022422 0001-01-010001-01-01
 * 
 * FICHERO: PEBT.QGFD.FIX.QGDTFDF.UGMEGAP.D1170613.txt
 * UGMEGAP �ALTA PROPUESTA FINANCIAMIENTO �F�17�00212�01�00016�TIPDOCU�IDENT.TIPO DOCUMENTO�A�001�0�R�        �
 * UGMEGAP �ALTA PROPUESTA FINANCIAMIENTO �F�17�00212�02�00020�NRODOCU�NRO DOCUMENTO IDENT.�A�010�0�R�        �
 * UGMEGAP �ALTA PROPUESTA FINANCIAMIENTO �F�17�00212�03�00033�TARIFA �IDENT. TARIFA FINAN �A�010�0�R�        �
 * UGMEGAP �ALTA PROPUESTA FINANCIAMIENTO �F�17�00212�04�00046�IMPFINA�IMPORTE FINANCIAR   �N�017�2�R�        �
 * UGMEGAP �ALTA PROPUESTA FINANCIAMIENTO �F�17�00212�05�00066�DIAFACT�DIA DE FACTURACION  �N�002�0�R�        �
 * UGMEGAP �ALTA PROPUESTA FINANCIAMIENTO �F�17�00212�06�00071�DIAPAGO�DIA DE PAGO         �N�002�0�R�        �
 * UGMEGAP �ALTA PROPUESTA FINANCIAMIENTO �F�17�00212�07�00076�MAILCON�EMAIL ENV. DOCUMEN  �A�050�0�R�        �
 * UGMEGAP �ALTA PROPUESTA FINANCIAMIENTO �F�17�00212�08�00129�TIPENVI�TIPO ENVIO EECC     �A�001�0�R�        �
 * UGMEGAP �ALTA PROPUESTA FINANCIAMIENTO �F�17�00212�09�00133�MONEDA �MONEDA PRESTAMO     �A�003�0�R�        �
 * UGMEGAP �ALTA PROPUESTA FINANCIAMIENTO �F�17�00212�10�00139�IDTOKEN�IDENT.OPERACION TELF�A�032�0�R�        �
 * UGMEGAP �ALTA PROPUESTA FINANCIAMIENTO �F�17�00212�11�00174�IMPBIEN�IMPORTE DEL EQUIPO  �N�017�2�R�        �
 * UGMEGAP �ALTA PROPUESTA FINANCIAMIENTO �F�17�00212�12�00194�CODBIEN�IDENT. DEL EQUIPO   �A�015�0�R�        �
 * UGMEGAP �ALTA PROPUESTA FINANCIAMIENTO �F�17�00212�13�00212�CODTR  �IDENT. TRX TELEFONIC�A�005�0�R�        �
 * UGMEGAP �ALTA PROPUESTA FINANCIAMIENTO �F�17�00212�14�00220�CODCNC �IDENT. CNC TELEFONIC�A�005�0�R�        �
 * UGMEGAP �ALTA PROPUESTA FINANCIAMIENTO �F�17�00212�15�00228�CODEMP �IDENT. EMPRESA FINAN�A�004�0�R�        �
 * UGMEGAP �ALTA PROPUESTA FINANCIAMIENTO �F�17�00212�16�00235�COCLIEX�IDENT.CLIENTE TELEFN�A�034�0�O�        �
 * UGMEGAP �ALTA PROPUESTA FINANCIAMIENTO �F�17�00212�17�00272�CODOFIC�CODIGO DE OFICINA   �A�004�0�R�        �
 * 
 * FICHERO: PEBT.QGFD.FIX.QGDTFDF.UGMSGAP1.D1170613.txt
 * UGMSGAP1�ALTA PROPUESTA FINAN. TELEFON.�X�01�00018�01�00001�NROCONT�NRO CONTRATO GENERA.�A�018�0�S�        �
 * 
 * FICHERO: PEBT.QGFD.FIX.QGDTFDX.UGAP.D1170613.txt
 * UGAPUGMSGAP1UGNCGAP1UG2CALPP1S                             P022422 2017-04-04-17.28.03.228321P022422 2017-04-04-17.28.03.228346
 * 
</pre></code>
 * 
 * @see RespuestaTransaccionUgap
 *
 * @author Arquitectura Spring BBVA
 */
@Transaccion(
	nombre = "UGAP",
	tipo = 1, 
	subtipo = 1,	
	version = 1,
	configuracion = "default_ps9_mx",
	respuesta = RespuestaTransaccionUgap.class,
	atributos = {@Atributo(nombre = "altamiraExtendido", valor = "true"), @Atributo(nombre = "tipoCopy", valor = "FIJA")}
)
@Multiformato(formatos = {FormatoUGMEGAP.class})
@RooJavaBean
@RooToString
@RooSerializable
public class PeticionTransaccionUgap implements MensajeMultiparte {
	
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