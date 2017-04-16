package com.bbva.pzic.proposals.dao.model.uglp;

import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Test de la transacci&oacute;n <code>UGLP</code>
 *
 * @author Arquitectura Spring BBVA
 */
@RunWith(MockitoJUnitRunner.class)
public class TestTransaccionUglp {

    @InjectMocks
    private TransaccionUglp transaccion;

    @Spy
    private ServicioTransacciones servicioTransacciones = Mockito.mock(ServicioTransacciones.class);

    @Test
    public void test() {

        PeticionTransaccionUglp peticion = new PeticionTransaccionUglp();
        RespuestaTransaccionUglp respuesta = transaccion.invocar(peticion);

        Mockito.when(servicioTransacciones.invocar(PeticionTransaccionUglp.class, RespuestaTransaccionUglp.class,
                peticion)).thenReturn(respuesta);

        RespuestaTransaccionUglp result = transaccion.invocar(peticion);
        Assert.assertEquals(result, respuesta);
    }
}