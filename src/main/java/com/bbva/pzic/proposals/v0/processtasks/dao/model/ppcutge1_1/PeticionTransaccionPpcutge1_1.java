package com.bbva.pzic.proposals.v0.processtasks.dao.model.ppcutge1_1;

import com.bbva.jee.arq.spring.core.host.Atributo;
import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.TipoCampo;
import com.bbva.jee.arq.spring.core.host.Transaccion;

import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.javabean.annotations.RooSerializable;

/**
 * <p>Transacci&oacute;n <code>PPCUTGE1</code></p>
 * <p>Informaci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Tipo:</b> 1</li>
 *    <li><b>Subtipo:</b> 1</li>
 *    <li><b>Versi&oacute;n:</b> 1</li>
 *    <li><b>Clase de petici&oacute;n:</b> PeticionTransaccionPpcutge1_1</li>
 *    <li><b>Clase de respuesta:</b> RespuestaTransaccionPpcutge1_1</li>
 * </ul>
 * </p>
 * <p>Configuraci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Nombre configuraci&oacute;n:</b> default_apx</li>
 * </ul>
 * </p>
 * <p>Copy de la transacci&oacute;n:</p>
 * <code><pre> * FICHERO: PPCUTGE1-01-PE.xml
 * &lt;?xml version=&quot;1.0&quot; encoding=&quot;UTF-8&quot; standalone=&quot;yes&quot;?&gt;
 * &lt;transaction xmlns=&quot;http://www.w3schools.com&quot; transactionName=&quot;PPCUTGE1&quot; application=&quot;PPCU&quot; version=&quot;01&quot; country=&quot;PE&quot;
 * language=&quot;ES&quot;&gt;
 * &lt;paramsIn&gt;
 * &lt;parameter order=&quot;1&quot; name=&quot;businessProcessId&quot; mandatory=&quot;0&quot; type=&quot;String&quot; size=&quot;40&quot;/&gt;
 * &lt;parameter order=&quot;2&quot; name=&quot;taskId&quot; mandatory=&quot;0&quot; type=&quot;String&quot; size=&quot;10&quot;/&gt;
 * &lt;/paramsIn&gt;
 * &lt;paramsOut&gt;
 * &lt;parameter order=&quot;1&quot; name=&quot;businessProcessId&quot; mandatory=&quot;1&quot; type=&quot;String&quot; size=&quot;40&quot;/&gt;
 * &lt;parameter order=&quot;2&quot; name=&quot;taskId&quot; mandatory=&quot;1&quot; type=&quot;String&quot; size=&quot;10&quot;/&gt;
 * &lt;dto order=&quot;3&quot; name=&quot;status&quot; mandatory=&quot;1&quot; package=&quot;com.bbva.ppcu.dto.getestado.StatusDTO&quot;
 * artifactId=&quot;PPCUCGE1&quot;&gt;
 * &lt;parameter order=&quot;1&quot; name=&quot;id&quot; mandatory=&quot;1&quot; type=&quot;String&quot; size=&quot;20&quot;/&gt;
 * &lt;parameter order=&quot;2&quot; name=&quot;description&quot; mandatory=&quot;1&quot; type=&quot;String&quot; size=&quot;100&quot;/&gt;
 * &lt;/dto&gt;
 * &lt;/paramsOut&gt;
 * &lt;description&gt;Transaccion para obtener el estado de proceso&lt;/description&gt;
 * &lt;/transaction&gt;
</pre></code>
 * 
 * @see RespuestaTransaccionPpcutge1_1
 *
 * @author Arquitectura Spring BBVA
 */
@Transaccion(
	nombre = "PPCUTGE1",
	tipo = 1, 
	subtipo = 1,	
	version = 1,
	configuracion = "default_apx",
	respuesta = RespuestaTransaccionPpcutge1_1.class,
	atributos = {@Atributo(nombre = "country", valor = "PE")}
)
@RooJavaBean
@RooSerializable
public class PeticionTransaccionPpcutge1_1 {
		
		/**
	 * <p>Campo <code>businessProcessId</code>, &iacute;ndice: <code>1</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 1, nombre = "businessProcessId", tipo = TipoCampo.ALFANUMERICO, longitudMaxima = 40, signo = true)
	private String businessprocessid;
	
	/**
	 * <p>Campo <code>taskId</code>, &iacute;ndice: <code>2</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 2, nombre = "taskId", tipo = TipoCampo.ALFANUMERICO, longitudMaxima = 10, signo = true)
	private String taskid;
	
}