package com.bbva.pzic.proposals.dao.model.ugmp;

import com.bbva.jee.arq.spring.core.host.Atributo;
import com.bbva.jee.arq.spring.core.host.Cuerpo;
import com.bbva.jee.arq.spring.core.host.CuerpoMultiparte;
import com.bbva.jee.arq.spring.core.host.MensajeMultiparte;
import com.bbva.jee.arq.spring.core.host.Multiformato;
import com.bbva.jee.arq.spring.core.host.Transaccion;

import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooSerializable;
import org.springframework.roo.addon.javabean.annotations.RooToString;

/**
 * <p>Transacci&oacute;n <code>UGMP</code></p>
 * <p>Informaci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Tipo:</b> 1</li>
 *    <li><b>Subtipo:</b> 1</li>
 *    <li><b>Versi&oacute;n:</b> 1</li>
 *    <li><b>Clase de petici&oacute;n:</b> PeticionTransaccionUgmp</li>
 *    <li><b>Clase de respuesta:</b> RespuestaTransaccionUgmp</li>
 * </ul>
 * </p>
 * <p>Configuraci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Nombre configuraci&oacute;n:</b> default_ps9_mx</li>
 * </ul>
 * </p>
 * <p>Copy de la transacci&oacute;n:</p>
 * <code><pre> * FICHERO: PEBD.QGFD.FIX.QGDTCCT.UGMP.D1170410.txt
 * UGMPSERVICIO MODIF. PROPUE. FINAN.TELEFUG        UG2CMOPPPBDUGPO UGMEGMP             UGMP  NN3000CNNNNN    SSTN     E  NNNSSNNN  NN                2017-04-04P022422 2017-04-0418.03.41P022422 2017-04-04-18.02.29.777857P022422 0001-01-010001-01-01
 *
 * FICHERO: PEBD.QGFD.FIX.QGDTFDF.UGMEGMP.D1170410.txt
 * UGMEGMP �MODIFICACION PROPUESTA TELEF  �F�04�00070�01�00001�NROCONT�NRO CONTRATO GENERAD�A�018�0�R�        �
 * UGMEGMP �MODIFICACION PROPUESTA TELEF  �F�04�00070�02�00019�INDESTA�IDENT. ESTADO       �A�001�0�R�        �
 * UGMEGMP �MODIFICACION PROPUESTA TELEF  �F�04�00070�03�00020�MAILCON�EMAIL ENVIO EECC    �A�050�0�O�        �
 * UGMEGMP �MODIFICACION PROPUESTA TELEF  �F�04�00070�04�00070�TIPENVI�TIPO ENVIO          �A�001�0�O�        �
 *
 * FICHERO: PEBD.QGFD.FIX.QGDTFDX.UGMP.D1170410.txt
 *
</pre></code>
 *
 * @see RespuestaTransaccionUgmp
 *
 * @author Arquitectura Spring BBVA
 */
@Transaccion(
	nombre = "UGMP",
	tipo = 1,
	subtipo = 1,
	version = 1,
	configuracion = "default_ps9_mx",
	respuesta = RespuestaTransaccionUgmp.class,
	atributos = {@Atributo(nombre = "altamiraExtendido", valor = "true"), @Atributo(nombre = "tipoCopy", valor = "FIJA")}
)
@Multiformato(formatos = {FormatoUGMEGMP.class})
@RooJavaBean
@RooToString
@RooSerializable
public class PeticionTransaccionUgmp implements MensajeMultiparte {

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
