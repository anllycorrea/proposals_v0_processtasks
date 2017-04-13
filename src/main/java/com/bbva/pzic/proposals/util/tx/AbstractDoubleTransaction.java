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
import java.util.List;

/**
 * @param <E>
 * @param <FE>
 * @param <S>
 * @param <FS>
 * @param <FS2>
 */
public abstract class AbstractDoubleTransaction<E, FE, S, FS, FS2> {

    private static final Log LOG = LogFactory.getLog(AbstractDoubleTransaction.class);

    @Autowired
    private ErrorMappingHelper errorMappingHelper;

    /**
     * @param dtoIn DTO con los datos de entrada
     * @return formato de entrada
     */
    protected abstract FE mapDtoInToRequestFormat(E dtoIn);

    /**
     * @param formatOutput formato 1 de salida a mapear
     * @param dtoIn        DTO de entrada
     * @param dtoOut       DTO de salida
     * @return DTO mapeado
     */
    protected abstract S mapResponseFormatToDtoOut(FS formatOutput, E dtoIn, S dtoOut);

    /**
     * @param formatOutput Formato 2 de salida a mapear
     * @param dtoIn        DTO de entrada
     * @param dtoOut       DTO de salida
     * @return DTO mapeado
     */
    protected abstract S mapResponseFormatToDtoOut2(FS2 formatOutput, E dtoIn, S dtoOut);

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
    public S invoke(final E entrada) {

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
            final List<CopySalida> copysSalida = respuesta.getCuerpo().getPartes(CopySalida.class);

            LOG.info(String.format("......... Copies obtenidos de Host %d ........", copysSalida.size()));

            final ParameterizedType typeInterfaceOutput = (ParameterizedType) this.getClass().getGenericSuperclass();
            final Type[] typesListTransaction = typeInterfaceOutput.getActualTypeArguments();

            final Class<?> claseSalida = (Class<?>) typesListTransaction[2];

            S salida = (S) claseSalida.newInstance();

            FS formatoSalida = null;
            FS2 formatoSalida2 = null;
            for (final CopySalida copySalida : copysSalida) {
                // Obtenemos el formato de salida

                if (copySalida != null) {
                    final Class<FS> claseFormatoSalida = (Class<FS>) typesListTransaction[3];
                    formatoSalida = copySalida.getCopy(claseFormatoSalida);

                    final Class<FS2> claseFormatoSalida2 = (Class<FS2>) typesListTransaction[4];
                    formatoSalida2 = copySalida.getCopy(claseFormatoSalida2);
                }
                if (formatoSalida != null) {
                    salida = mapResponseFormatToDtoOut(formatoSalida, entrada, salida);

                } else if (formatoSalida2 != null) {
                    salida = mapResponseFormatToDtoOut2(formatoSalida2, entrada, salida);
                }
            }
            return salida;
        } catch (NoSuchMethodException | InstantiationException | InvocationTargetException | IllegalAccessException e) {
            throw new BusinessServiceException(Errors.TECHNICAL_ERROR, e);
        }
    }
}
