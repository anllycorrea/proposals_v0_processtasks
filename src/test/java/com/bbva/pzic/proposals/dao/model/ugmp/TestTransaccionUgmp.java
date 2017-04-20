package com.bbva.pzic.proposals.dao.model.ugmp;

import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Test de la transacci&oacute;n <code>UGMP</code>
 *
 * @author Arquitectura Spring BBVA
 */
@RunWith(MockitoJUnitRunner.class)
public class TestTransaccionUgmp {

    @InjectMocks
    private TransaccionUgmp transaccion;

    @Spy
    private ServicioTransacciones servicioTransacciones = Mockito.mock(ServicioTransacciones.class);

    @Test
    public void test() {

        PeticionTransaccionUgmp peticion = new PeticionTransaccionUgmp();
        RespuestaTransaccionUgmp respuesta = transaccion.invocar(peticion);

        Mockito.when(servicioTransacciones.invocar(PeticionTransaccionUgmp.class, RespuestaTransaccionUgmp.class,
                peticion)).thenReturn(respuesta);

        RespuestaTransaccionUgmp result = transaccion.invocar(peticion);
        Assert.assertEquals(result, respuesta);
    }
}