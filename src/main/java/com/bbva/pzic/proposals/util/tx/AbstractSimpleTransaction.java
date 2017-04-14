package com.bbva.pzic.proposals.util.tx;

import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.MensajeMultiparte;
import com.bbva.jee.arq.spring.core.host.protocolo.ExcepcionRespuestaHost;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.ErrorMappingHelper;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.pzic.proposals.util.Errors;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @param <E>
 * @param <FE>
 * @param <S>
 * @param <FS>
 * @author Entelgy
 */
public abstract class AbstractSimpleTransaction<E, FE, S, FS> {

    private static final Log LOG = LogFactory.getLog(AbstractSimpleTransaction.class);

    @Autowired
    private ErrorMappingHelper errorMappingHelper;

    /**
     * @param dtoIn DTO con los datos de entrada
     * @return formato de entrada
     */
    protected abstract FE mapDtoInToRequestFormat(E dtoIn);

    /**
     * @param formatOutput formato de salida a mapear
     * @param dtoIn        DTO de entrada
     * @return DTO mapeado
     */
    protected abstract S mapResponseFormatToDtoOut(FS formatOutput, E dtoIn);

    /**
     * Devuelve la transaccion
     *
     * @return la transaccion a invocar
     */
    protected abstract InvocadorTransaccion<?, ?> getTransaction();

    /**
     * @param entrada peticion de entrada
     * @return respuesta del backend
     */
    @SuppressWarnings("unchecked")
    public S invoke(E entrada) {
        try {
            InvocadorTransaccion<?, ?> transaction = getTransaction();

            // Obtenemos la clase de la petición de entrada con la información
            // dada en el invocador...
            final ParameterizedType tipoInterfaceInvocador = (ParameterizedType) transaction.getClass()
                    .getGenericInterfaces()[0];
            final Type[] tiposArgumentosPeticionYRespuesta = tipoInterfaceInvocador.getActualTypeArguments();
            final Class<?> clasePeticion = (Class<?>) tiposArgumentosPeticionYRespuesta[0];
            // ... y creamos una instancia para mandarla en la transacción
            MensajeMultiparte peticion = (MensajeMultiparte) clasePeticion.newInstance();

            final Object formatoEntrada = mapDtoInToRequestFormat(entrada);

            // ... y lo añadimos al a petición
            peticion.getCuerpo().getPartes().add(formatoEntrada);

            LOG.info(String.format("......... Peticion %s .........", peticion));

            // Invocamos a la transacción...
            final MensajeMultiparte respuesta = (MensajeMultiparte) transaction.getClass()
                    .getMethod("invocar", peticion.getClass()).invoke(transaction, peticion);

            LOG.info(String.format("......... Respuesta %s .........", respuesta));

            // ... y comprobamos posibles errores
            final ExcepcionRespuestaHost excepcionRespuestaHost = errorMappingHelper
                    .ps9ResponseToHostException(peticion, respuesta);

            if (excepcionRespuestaHost != null) {
                LOG.info(String.format("......... Excepcion %s .........", excepcionRespuestaHost));
                throw excepcionRespuestaHost;
            }

            // ... y obtener la copy de salida
            LOG.info(String.format("......... Copies obtenidos de Host %d ........", respuesta.getCuerpo().getPartes().size()));

            final CopySalida copySalida = respuesta.getCuerpo().getParte(CopySalida.class);

            final ParameterizedType typeInterfaceOutput = (ParameterizedType) this.getClass().getGenericSuperclass();
            final Type[] typesOutput = typeInterfaceOutput.getActualTypeArguments();

            // Obtenemos el formato de salida
            FS formatoSalida = null;
            if (copySalida != null) {
                final Class<FS> claseFormatoSalida = (Class<FS>) typesOutput[3];
                formatoSalida = copySalida.getCopy(claseFormatoSalida);
            }

            // Get output class
            final Class<?> claseSalida = (Class<?>) typesOutput[2];

            // E invocamos al mapper que lo mapeará a la entidad esperada
            final S outputReturn = mapResponseFormatToDtoOut(formatoSalida, entrada);

            return outputReturn == null ? (S) claseSalida.newInstance() : outputReturn;

        } catch (NoSuchMethodException | InstantiationException | InvocationTargetException | IllegalAccessException e) {
            throw new BusinessServiceException(Errors.TECHNICAL_ERROR, e);
        }
    }
}
