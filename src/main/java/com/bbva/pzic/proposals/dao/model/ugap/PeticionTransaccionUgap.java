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
 * <code><pre> * FICHERO: PEBD.QGFD.FIX.QGDTCCT.UGAP.D1170504.txt
 * UGAPALTA PROPUESTA FINANCI. TELEFONICA UG        UG2CALPPPBDUGPO UGMEGAP             UGAP  NN3000CNNNNN    SSTN     E  NNNSSNNN  NN                2017-04-04P022422 2017-05-0418.12.51P022422 2017-04-04-17.25.58.178851P022422 0001-01-010001-01-01
 * 
 * FICHERO: PEBD.QGFD.FIX.QGDTFDF.UGMEGAP.D1170504.txt
 * UGMEGAP �ALTA PROPUESTA FINANCIAMIENTO �F�15�00206�01�00001�TIPDOCU�IDENT.TIPO DOCUMENTO�A�001�0�R�        �
 * UGMEGAP �ALTA PROPUESTA FINANCIAMIENTO �F�15�00206�02�00002�NRODOCU�NRO DOCUMENTO IDENT.�A�010�0�R�        �
 * UGMEGAP �ALTA PROPUESTA FINANCIAMIENTO �F�15�00206�03�00012�TARIFA �IDENT. TARIFA FINAN �A�010�0�R�        �
 * UGMEGAP �ALTA PROPUESTA FINANCIAMIENTO �F�15�00206�04�00022�IMPFINA�IMPORTE FINANCIAR   �N�017�2�R�        �
 * UGMEGAP �ALTA PROPUESTA FINANCIAMIENTO �F�15�00206�05�00039�DIAPAGO�DIA DE PAGO         �N�002�0�R�        �
 * UGMEGAP �ALTA PROPUESTA FINANCIAMIENTO �F�15�00206�06�00041�MAILCON�EMAIL ENV. DOCUMEN  �A�050�0�R�        �
 * UGMEGAP �ALTA PROPUESTA FINANCIAMIENTO �F�15�00206�07�00091�TIPENVI�TIPO ENVIO EECC     �A�001�0�R�        �
 * UGMEGAP �ALTA PROPUESTA FINANCIAMIENTO �F�15�00206�08�00092�MONEDA �MONEDA PRESTAMO     �A�003�0�R�        �
 * UGMEGAP �ALTA PROPUESTA FINANCIAMIENTO �F�15�00206�09�00095�IDTOKEN�IDENT.OPERACION TELF�A�032�0�R�        �
 * UGMEGAP �ALTA PROPUESTA FINANCIAMIENTO �F�15�00206�10�00127�IMPBIEN�IMPORTE DEL EQUIPO  �N�017�2�R�        �
 * UGMEGAP �ALTA PROPUESTA FINANCIAMIENTO �F�15�00206�11�00144�CODBIEN�IDENT. DEL EQUIPO   �A�015�0�R�        �
 * UGMEGAP �ALTA PROPUESTA FINANCIAMIENTO �F�15�00206�12�00159�CODTR  �IDENT. TRX TELEFONIC�A�005�0�R�        �
 * UGMEGAP �ALTA PROPUESTA FINANCIAMIENTO �F�15�00206�13�00164�CODCNC �IDENT. CNC TELEFONIC�A�005�0�R�        �
 * UGMEGAP �ALTA PROPUESTA FINANCIAMIENTO �F�15�00206�14�00169�CODEMP �IDENT. EMPRESA FINAN�A�004�0�R�        �
 * UGMEGAP �ALTA PROPUESTA FINANCIAMIENTO �F�15�00206�15�00173�COCLIEX�IDENT.CLIENTE TELEFN�A�034�0�O�        �
 * 
 * FICHERO: PEBD.QGFD.FIX.QGDTFDF.UGMSGAP1.D1170504.txt
 * UGMSGAP1�ALTA PROPUESTA FINAN. TELEFON.�X�01�00018�01�00001�NROCONT�NRO CONTRATO GENERA.�A�018�0�S�        �
 * 
 * FICHERO: PEBD.QGFD.FIX.QGDTFDX.UGAP.D1170504.txt
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