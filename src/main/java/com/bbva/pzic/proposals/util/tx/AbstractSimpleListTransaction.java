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
import java.util.ArrayList;
import java.util.List;

/**
 * @param <I> DTO de entrada
 * @param <E> Formato de entrada
 * @param <O> DTO de salida
 * @param <S> Formato de salida
 * @author Entelgy
 */
public abstract class AbstractSimpleListTransaction<I, E, O, S> {

    private static final Log LOG = LogFactory.getLog(AbstractSimpleListTransaction.class);

    @Autowired
    private ErrorMappingHelper errorMappingHelper;

    /**
     * @param dtoIn DTO con los datos de entrada
     * @return formato de entrada
     */
    protected abstract E mapDtoInToRequestFormat(I dtoIn);

    /**
     * @param formatOutput formato 1 de salida a mapear
     * @param dtoIn        DTO de entrada
     * @param dtoOut       DTO de salida
     * @return DTO mapeado
     */
    protected abstract O mapResponseFormatToDtoOut(S formatOutput, I dtoIn, O dtoOut);

    /**
     * Devuelve la transaccion
     *
     * @return la transaccion a invocar
     */
    protected abstract InvocadorTransaccion<?, ?> getTransaction();

    /**
     * @param input peticion de entrada
     * @return respuesta del backend
     */
    @SuppressWarnings("unchecked")
    public List<O> invoke(final I input) {
        try {
            final InvocadorTransaccion<?, ?> transaction = getTransaction();

            // Obtenemos la clase de la petición de entrada con la información
            // dada en el invocador...
            final ParameterizedType tipoInterfaceInvocador = (ParameterizedType) transaction.getClass()
                    .getGenericInterfaces()[0];
            final Type[] tiposArgumentosPeticionYRespuesta = tipoInterfaceInvocador.getActualTypeArguments();
            final Class<?> clasePeticion = (Class<?>) tiposArgumentosPeticionYRespuesta[0];
            // ... y creamos una instancia para mandarla en la transacción
            MensajeMultiparte peticion = (MensajeMultiparte) clasePeticion.newInstance();

            final Object formatoEntrada = mapDtoInToRequestFormat(input);

            LOG.info(String.format("......... Formato de entrada %s .........", formatoEntrada));

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
            final List<CopySalida> copysSalida = respuesta.getCuerpo().getPartes(CopySalida.class);

            LOG.info(String.format("......... Copies obtenidos de Host %d ........", copysSalida.size()));

            if (copysSalida.isEmpty()) {
                return null;
            }

            final List<O> salidaList = new ArrayList<>();

            final ParameterizedType typeInterfaceOutput = (ParameterizedType) this.getClass().getGenericSuperclass();

            final Type[] typesListTransaction = typeInterfaceOutput.getActualTypeArguments();

            final Class<?> claseSalida = (Class<?>) typesListTransaction[2];
            O output = (O) claseSalida.newInstance();

            S formatoSalida = null;

            for (final CopySalida copySalida : copysSalida) {
                // Obtenemos el formato de salida
                if (copySalida != null) {
                    final Class<S> claseFormatoSalida = (Class<S>) typesListTransaction[3];
                    formatoSalida = copySalida.getCopy(claseFormatoSalida);
                }
                output = mapResponseFormatToDtoOut(formatoSalida, input, output);
                salidaList.add(output);
            }

            return salidaList;

        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new BusinessServiceException(Errors.TECHNICAL_ERROR, e);
        }
    }
}
