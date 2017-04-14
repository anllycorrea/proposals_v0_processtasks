package com.bbva.pzic.proposals.dao.model.ugap;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

/**
 * Test de la transacci&oacute;n <code>UGAP</code>
 *
 * @author Arquitectura Spring BBVA
 */
@RunWith(MockitoJUnitRunner.class)
public class TestTransaccionUgap {


    @InjectMocks
    private TransaccionUgap transaccion;

    @Spy
    private ServicioTransacciones servicioTransacciones = Mockito.mock(ServicioTransacciones.class);

    @Test
    public void test() throws ExcepcionTransaccion {

        PeticionTransaccionUgap peticion = new PeticionTransaccionUgap();

        RespuestaTransaccionUgap respuesta = new RespuestaTransaccionUgap();

        Mockito.when(servicioTransacciones.invocar(PeticionTransaccionUgap.class, RespuestaTransaccionUgap.class,
                peticion)).thenReturn(respuesta);

        RespuestaTransaccionUgap result = transaccion.invocar(peticion);

        assertEquals(result, respuesta);
    }
}