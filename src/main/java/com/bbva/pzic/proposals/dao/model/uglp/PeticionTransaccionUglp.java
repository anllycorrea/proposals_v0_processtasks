package com.bbva.pzic.proposals.dao.model.uglp;

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
 * <p>Transacci&oacute;n <code>UGLP</code></p>
 * <p>Informaci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Tipo:</b> 1</li>
 *    <li><b>Subtipo:</b> 1</li>
 *    <li><b>Versi&oacute;n:</b> 1</li>
 *    <li><b>Clase de petici&oacute;n:</b> PeticionTransaccionUglp</li>
 *    <li><b>Clase de respuesta:</b> RespuestaTransaccionUglp</li>
 * </ul>
 * </p>
 * <p>Configuraci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Nombre configuraci&oacute;n:</b> default_ps9_mx</li>
 * </ul>
 * </p>
 * <p>Copy de la transacci&oacute;n:</p>
 * <code><pre> * FICHERO: PEBD.QGFD.FIX.QGDTCCT.UGLP.D1170410.txt
 * UGLPSERVICIO LISTA PROPUES-FINA. TELEFOUG        UG2CLIPPPBDUGPO UGMEGLP             UGLP  NN3000CNNNNN    SSTN     E  NNNSSNNN  NN                2017-04-04P022422 2017-04-1014.32.18P022422 2017-04-04-17.54.02.582275P022422 0001-01-010001-01-01
 * 
 * FICHERO: PEBD.QGFD.FIX.QGDTFDF.UGMEGLP.D1170410.txt
 * UGMEGLP �LISTA PROPUESTA FINAN. TELEF. �F�07�00055�01�00001�TIPDOCU�IDENT.TIPO DOCUMENTO�A�001�0�R�        �
 * UGMEGLP �LISTA PROPUESTA FINAN. TELEF. �F�07�00055�02�00002�NRODOCU�NRO DOCUMENTO       �A�010�0�R�        �
 * UGMEGLP �LISTA PROPUESTA FINAN. TELEF. �F�07�00055�03�00012�CODEMP �IDENT. EMPRESA      �A�004�0�R�        �
 * UGMEGLP �LISTA PROPUESTA FINAN. TELEF. �F�07�00055�04�00016�FECRDES�FECHA CREAC. DESDE  �A�010�0�R�        �
 * UGMEGLP �LISTA PROPUESTA FINAN. TELEF. �F�07�00055�05�00026�FECRHAS�FECHA CREA. HASTA   �A�010�0�R�        �
 * UGMEGLP �LISTA PROPUESTA FINAN. TELEF. �F�07�00055�06�00036�IDPAGIN�IDENT. PAGINACION   �A�018�0�O�        �
 * UGMEGLP �LISTA PROPUESTA FINAN. TELEF. �F�07�00055�07�00054�TAMPAGI�TAM�O PAGINACION    �N�002�0�O�        �
 * 
 * FICHERO: PEBD.QGFD.FIX.QGDTFDF.UGMSGLP1.D1170410.txt
 * UGMSGLP1�LISTADO PROPUESTA FINA. TELEF �X�21�00343�01�00001�NROCONT�NRO CONTRATO GENERA.�A�018�0�S�        �
 * UGMSGLP1�LISTADO PROPUESTA FINA. TELEF �X�21�00343�02�00019�INDESTA�IDENT. ESTADO PROP. �A�001�0�S�        �
 * UGMSGLP1�LISTADO PROPUESTA FINA. TELEF �X�21�00343�03�00020�DESESTA�DESCR. ESTADO       �A�020�0�S�        �
 * UGMSGLP1�LISTADO PROPUESTA FINA. TELEF �X�21�00343�04�00040�FESOLI �FECHA SOLICITUD     �A�010�0�S�        �
 * UGMSGLP1�LISTADO PROPUESTA FINA. TELEF �X�21�00343�05�00050�MONEDA �MONEDA CONTRATO     �A�003�0�S�        �
 * UGMSGLP1�LISTADO PROPUESTA FINA. TELEF �X�21�00343�06�00053�IMPFINA�IMPORTE FINANCIAR   �N�017�2�S�        �
 * UGMSGLP1�LISTADO PROPUESTA FINA. TELEF �X�21�00343�07�00070�CUOINI �CUOTA INICIAL       �N�017�2�S�        �
 * UGMSGLP1�LISTADO PROPUESTA FINA. TELEF �X�21�00343�08�00087�TARIFA �IDENT. TARIFA       �A�010�0�S�        �
 * UGMSGLP1�LISTADO PROPUESTA FINA. TELEF �X�21�00343�09�00097�TASASEG�TASA SEGURO         �N�008�5�S�        �
 * UGMSGLP1�LISTADO PROPUESTA FINA. TELEF �X�21�00343�10�00105�CODSEG �IDENT. SEGURO       �A�004�0�S�        �
 * UGMSGLP1�LISTADO PROPUESTA FINA. TELEF �X�21�00343�11�00109�DESCSEG�DESCRI. SEGURO      �A�040�0�S�        �
 * UGMSGLP1�LISTADO PROPUESTA FINA. TELEF �X�21�00343�12�00149�TIPENVI�TIPO DE ENVIO       �A�001�0�S�        �
 * UGMSGLP1�LISTADO PROPUESTA FINA. TELEF �X�21�00343�13�00150�DESENV �DESCRI. TIPO ENVIO  �A�010�0�S�        �
 * UGMSGLP1�LISTADO PROPUESTA FINA. TELEF �X�21�00343�14�00160�FEDESEM�FECHA DESEMBOLSO    �A�010�0�S�        �
 * UGMSGLP1�LISTADO PROPUESTA FINA. TELEF �X�21�00343�15�00170�CODBIEN�IDENT. DEL EQUIPO   �A�015�0�S�        �
 * UGMSGLP1�LISTADO PROPUESTA FINA. TELEF �X�21�00343�16�00185�IMPBIEN�IMPORTE DEL BIEN    �N�017�2�S�        �
 * UGMSGLP1�LISTADO PROPUESTA FINA. TELEF �X�21�00343�17�00202�NOMBR  �NOMBRES DE PERSONA  �A�020�0�S�        �
 * UGMSGLP1�LISTADO PROPUESTA FINA. TELEF �X�21�00343�18�00222�APEPAT �APELLIDO PATERNO    �A�020�0�S�        �
 * UGMSGLP1�LISTADO PROPUESTA FINA. TELEF �X�21�00343�19�00242�APEMAT �APELLIDO MATERNO    �A�020�0�S�        �
 * UGMSGLP1�LISTADO PROPUESTA FINA. TELEF �X�21�00343�20�00262�MAILCON�EMAIL ENVIO EECC    �A�050�0�S�        �
 * UGMSGLP1�LISTADO PROPUESTA FINA. TELEF �X�21�00343�21�00312�IDTOKEN�IDENT. OPERACION TEL�A�032�0�S�        �
 * 
 * FICHERO: PEBD.QGFD.FIX.QGDTFDF.UGMSGLP2.D1170410.txt
 * UGMSGLP2�PAGINACION LISTA PROPUESTA    �X�02�00020�01�00001�IDPAGIN�ID.SIG. EFECT.CONSUL�A�018�0�S�        �
 * UGMSGLP2�PAGINACION LISTA PROPUESTA    �X�02�00020�02�00019�TAMPAGI�TAMANIO DE PAGINA   �N�002�0�S�        �
 * 
 * FICHERO: PEBD.QGFD.FIX.QGDTFDX.UGLP.D1170410.txt
 * UGLPUGMSGLP1UGNCGLP1UG2CLIPP1S                             P022422 2017-04-04-17.56.17.339900P022422 2017-04-04-17.56.17.339927
 * UGLPUGMSGLP2UGNCGLP2UG2CLIPP1S                             P022422 2017-04-05-18.08.36.832690P022422 2017-04-05-18.08.36.832714
 * 
</pre></code>
 * 
 * @see RespuestaTransaccionUglp
 *
 * @author Arquitectura Spring BBVA
 */
@Transaccion(
	nombre = "UGLP",
	tipo = 1, 
	subtipo = 1,	
	version = 1,
	configuracion = "default_ps9_mx",
	respuesta = RespuestaTransaccionUglp.class,
	atributos = {@Atributo(nombre = "altamiraExtendido", valor = "true"), @Atributo(nombre = "tipoCopy", valor = "FIJA")}
)
@Multiformato(formatos = {FormatoUGMEGLP.class})
@RooJavaBean
@RooToString
@RooSerializable
public class PeticionTransaccionUglp implements MensajeMultiparte {
	
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