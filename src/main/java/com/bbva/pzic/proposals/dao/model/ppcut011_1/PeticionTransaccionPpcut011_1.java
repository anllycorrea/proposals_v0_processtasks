package com.bbva.pzic.proposals.dao.model.ppcut011_1;

import com.bbva.jee.arq.spring.core.host.Atributo;
import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.TipoCampo;
import com.bbva.jee.arq.spring.core.host.Transaccion;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooSerializable;

/**
 * <p>Transacci&oacute;n <code>PPCUT011</code></p>
 * <p>Informaci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Tipo:</b> 1</li>
 *    <li><b>Subtipo:</b> 1</li>
 *    <li><b>Versi&oacute;n:</b> 1</li>
 *    <li><b>Clase de petici&oacute;n:</b> PeticionTransaccionPpcut011_1</li>
 *    <li><b>Clase de respuesta:</b> RespuestaTransaccionPpcut011_1</li>
 * </ul>
 * </p>
 * <p>Configuraci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Nombre configuraci&oacute;n:</b> default_apx</li>
 * </ul>
 * </p>
 * <p>Copy de la transacci&oacute;n:</p>
 * <code><pre> * FICHERO: PPCUT011-01-PE.xml
 * &lt;?xml version=&quot;1.0&quot; encoding=&quot;UTF-8&quot; standalone=&quot;yes&quot; ?&gt;
 * &lt;transaction xmlns=&quot;http://www.w3schools.com&quot; transactionName=&quot;PPCUT011&quot; application=&quot;PPCU&quot; version=&quot;01&quot; country=&quot;PE&quot;
 * language=&quot;ES&quot;&gt;
 * &lt;paramsIn&gt;
 * &lt;dto name=&quot;EntityIn&quot; package=&quot;com.bbva.ppcu.dto.validateaccess.dto.ValidateAccessDTO&quot; artifactId=&quot;PPCUC011&quot;
 * mandatory=&quot;0&quot; order=&quot;1&quot;&gt;
 * &lt;dto name=&quot;product&quot; package=&quot;com.bbva.ppcu.dto.validateaccess.dto.ProductDTO&quot; artifactId=&quot;PPCUC011&quot;
 * mandatory=&quot;0&quot; order=&quot;1&quot;&gt;
 * &lt;parameter order=&quot;1&quot; name=&quot;id&quot; type=&quot;String&quot; size=&quot;50&quot; mandatory=&quot;1&quot;/&gt;
 * &lt;dto name=&quot;subproduct&quot; package=&quot;com.bbva.ppcu.dto.validateaccess.dto.SubProductDTO&quot;
 * artifactId=&quot;PPCUC011&quot; mandatory=&quot;0&quot; order=&quot;2&quot;&gt;
 * &lt;parameter order=&quot;1&quot; name=&quot;id&quot; type=&quot;String&quot; size=&quot;50&quot; mandatory=&quot;1&quot;/&gt;
 * &lt;/dto&gt;
 * &lt;/dto&gt;
 * &lt;dto name=&quot;participant&quot; package=&quot;com.bbva.ppcu.dto.validateaccess.dto.ParticipantDTO&quot; artifactId=&quot;PPCUC011&quot;
 * mandatory=&quot;1&quot; order=&quot;2&quot;&gt;
 * &lt;parameter order=&quot;1&quot; name=&quot;id&quot; type=&quot;String&quot; size=&quot;50&quot; mandatory=&quot;1&quot;/&gt;
 * &lt;list name=&quot;contacts&quot; order=&quot;2&quot; mandatory=&quot;0&quot;&gt;
 * &lt;dto name=&quot;contact&quot; package=&quot;com.bbva.ppcu.dto.validateaccess.dto.ContactDTO&quot; artifactId=&quot;PPCUC011&quot;
 * mandatory=&quot;0&quot; order=&quot;1&quot;&gt;
 * &lt;parameter order=&quot;1&quot; name=&quot;contactDetailType&quot; type=&quot;String&quot; size=&quot;50&quot; mandatory=&quot;1&quot;/&gt;
 * &lt;parameter order=&quot;2&quot; name=&quot;number&quot; type=&quot;String&quot; size=&quot;50&quot; mandatory=&quot;0&quot;/&gt;
 * &lt;parameter order=&quot;3&quot; name=&quot;address&quot; type=&quot;String&quot; size=&quot;100&quot; mandatory=&quot;0&quot;/&gt;
 * &lt;dto name=&quot;phoneCompany&quot; package=&quot;com.bbva.ppcu.dto.validateaccess.dto.PhoneCompanyDTO&quot;
 * artifactId=&quot;PPCUC011&quot; mandatory=&quot;0&quot; order=&quot;4&quot;&gt;
 * &lt;parameter order=&quot;1&quot; name=&quot;id&quot; type=&quot;String&quot; size=&quot;50&quot; mandatory=&quot;1&quot;/&gt;
 * &lt;/dto&gt;
 * &lt;/dto&gt;
 * &lt;/list&gt;
 * &lt;dto name=&quot;identityDocument&quot; package=&quot;com.bbva.ppcu.dto.validateaccess.dto.IdentityDocumentDTO&quot;
 * artifactId=&quot;PPCUC011&quot; mandatory=&quot;0&quot; order=&quot;3&quot;&gt;
 * &lt;parameter order=&quot;1&quot; name=&quot;documentNumber&quot; type=&quot;String&quot; size=&quot;50&quot; mandatory=&quot;1&quot;/&gt;
 * &lt;dto name=&quot;documentType&quot; package=&quot;com.bbva.ppcu.dto.validateaccess.dto.DocumentTypeDTO&quot;
 * artifactId=&quot;PPCUC011&quot; mandatory=&quot;1&quot; order=&quot;2&quot;&gt;
 * &lt;parameter order=&quot;1&quot; name=&quot;id&quot; type=&quot;String&quot; size=&quot;50&quot; mandatory=&quot;1&quot;/&gt;
 * &lt;/dto&gt;
 * &lt;/dto&gt;
 * &lt;/dto&gt;
 * &lt;/dto&gt;
 * &lt;/paramsIn&gt;
 * &lt;paramsOut&gt;
 * &lt;dto name=&quot;EntityOut&quot; package=&quot;com.bbva.ppcu.dto.validateaccess.dto.ValidateAccessDTO&quot; artifactId=&quot;PPCUC011&quot;
 * mandatory=&quot;0&quot; order=&quot;1&quot;&gt;
 * &lt;parameter order=&quot;1&quot; name=&quot;validationDictum&quot; type=&quot;String&quot; size=&quot;50&quot; mandatory=&quot;1&quot;/&gt;
 * &lt;list name=&quot;dictumReasons&quot; order=&quot;2&quot; mandatory=&quot;0&quot;&gt;
 * &lt;dto name=&quot;dictumReason&quot; package=&quot;com.bbva.ppcu.dto.validateaccess.dto.DictumReasonDTO&quot; artifactId=&quot;PPCUC011&quot;
 * mandatory=&quot;0&quot; order=&quot;1&quot;&gt;
 * &lt;parameter order=&quot;1&quot; name=&quot;id&quot; type=&quot;String&quot; size=&quot;50&quot; mandatory=&quot;1&quot;/&gt;
 * &lt;parameter order=&quot;2&quot; name=&quot;description&quot; type=&quot;String&quot; size=&quot;100&quot; mandatory=&quot;1&quot;/&gt;
 * &lt;/dto&gt;
 * &lt;/list&gt;
 * &lt;dto name=&quot;product&quot; package=&quot;com.bbva.ppcu.dto.validateaccess.dto.ProductDTO&quot; artifactId=&quot;PPCUC011&quot;
 * mandatory=&quot;0&quot; order=&quot;3&quot;&gt;
 * &lt;parameter order=&quot;1&quot; name=&quot;id&quot; type=&quot;String&quot; size=&quot;50&quot; mandatory=&quot;1&quot;/&gt;
 * &lt;dto name=&quot;subproduct&quot; package=&quot;com.bbva.ppcu.dto.validateaccess.dto.SubProductDTO&quot;
 * artifactId=&quot;PPCUC011&quot; mandatory=&quot;0&quot; order=&quot;2&quot;&gt;
 * &lt;parameter order=&quot;1&quot; name=&quot;id&quot; type=&quot;String&quot; size=&quot;50&quot; mandatory=&quot;1&quot;/&gt;
 * &lt;/dto&gt;
 * &lt;/dto&gt;
 * &lt;dto name=&quot;participant&quot; package=&quot;com.bbva.ppcu.dto.validateaccess.dto.ParticipantDTO&quot; artifactId=&quot;PPCUC011&quot;
 * mandatory=&quot;1&quot; order=&quot;4&quot;&gt;
 * &lt;parameter order=&quot;1&quot; name=&quot;id&quot; type=&quot;String&quot; size=&quot;50&quot; mandatory=&quot;1&quot;/&gt;
 * &lt;list name=&quot;contacts&quot; order=&quot;2&quot; mandatory=&quot;0&quot;&gt;
 * &lt;dto name=&quot;contact&quot; package=&quot;com.bbva.ppcu.dto.validateaccess.dto.ContactDTO&quot; artifactId=&quot;PPCUC011&quot;
 * mandatory=&quot;0&quot; order=&quot;1&quot;&gt;
 * &lt;parameter order=&quot;1&quot; name=&quot;contactDetailType&quot; type=&quot;String&quot; size=&quot;50&quot; mandatory=&quot;1&quot;/&gt;
 * &lt;parameter order=&quot;2&quot; name=&quot;number&quot; type=&quot;String&quot; size=&quot;50&quot; mandatory=&quot;0&quot;/&gt;
 * &lt;parameter order=&quot;3&quot; name=&quot;address&quot; type=&quot;String&quot; size=&quot;100&quot; mandatory=&quot;0&quot;/&gt;
 * &lt;dto name=&quot;phoneCompany&quot; package=&quot;com.bbva.ppcu.dto.validateaccess.dto.PhoneCompanyDTO&quot;
 * artifactId=&quot;PPCUC011&quot; mandatory=&quot;0&quot; order=&quot;4&quot;&gt;
 * &lt;parameter order=&quot;1&quot; name=&quot;id&quot; type=&quot;String&quot; size=&quot;50&quot; mandatory=&quot;1&quot;/&gt;
 * &lt;parameter order=&quot;2&quot; name=&quot;name&quot; type=&quot;String&quot; size=&quot;50&quot; mandatory=&quot;1&quot;/&gt;
 * &lt;/dto&gt;
 * &lt;/dto&gt;
 * &lt;/list&gt;
 * &lt;dto name=&quot;identityDocument&quot; package=&quot;com.bbva.ppcu.dto.validateaccess.dto.IdentityDocumentDTO&quot;
 * artifactId=&quot;PPCUC011&quot; mandatory=&quot;0&quot; order=&quot;3&quot;&gt;
 * &lt;parameter order=&quot;1&quot; name=&quot;documentNumber&quot; type=&quot;String&quot; size=&quot;50&quot; mandatory=&quot;1&quot;/&gt;
 * &lt;dto name=&quot;documentType&quot; package=&quot;com.bbva.ppcu.dto.validateaccess.dto.DocumentTypeDTO&quot;
 * artifactId=&quot;PPCUC011&quot; mandatory=&quot;1&quot; order=&quot;2&quot;&gt;
 * &lt;parameter order=&quot;1&quot; name=&quot;id&quot; type=&quot;String&quot; size=&quot;50&quot; mandatory=&quot;1&quot;/&gt;
 * &lt;/dto&gt;
 * &lt;/dto&gt;
 * &lt;/dto&gt;
 * &lt;dto order=&quot;5&quot; name=&quot;headers&quot; mandatory=&quot;0&quot; package=&quot;com.bbva.ppcu.dto.validateaccess.dto.HeaderDTO&quot;
 * artifactId=&quot;PPCUC011&quot;&gt;
 * &lt;parameter order=&quot;1&quot; name=&quot;contactId&quot; mandatory=&quot;0&quot; type=&quot;String&quot; size=&quot;160&quot;/&gt;
 * &lt;/dto&gt;
 * &lt;/dto&gt;
 * &lt;/paramsOut&gt;
 * &lt;description&gt;Control de Reintentos por datos de contacto&lt;/description&gt;
 * &lt;/transaction&gt;
</pre></code>
 * 
 * @see RespuestaTransaccionPpcut011_1
 *
 * @author Arquitectura Spring BBVA
 */
@Transaccion(
	nombre = "PPCUT011",
	tipo = 1, 
	subtipo = 1,	
	version = 1,
	configuracion = "default_apx",
	respuesta = RespuestaTransaccionPpcut011_1.class,
	atributos = {@Atributo(nombre = "country", valor = "PE")}
)
@RooJavaBean
@RooSerializable
public class PeticionTransaccionPpcut011_1 {
		
		/**
	 * <p>Campo <code>EntityIn</code>, &iacute;ndice: <code>1</code>, tipo: <code>DTO</code>
	 */
	@Campo(indice = 1, nombre = "EntityIn", tipo = TipoCampo.DTO)
	private Entityin entityin;
	
}