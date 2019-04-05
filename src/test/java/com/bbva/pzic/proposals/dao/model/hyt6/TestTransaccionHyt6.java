package com.bbva.pzic.proposals.dao.model.hyt6;

import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Test de la transacci&oacute;n <code>HYT6</code>
 *
 * @author Arquitectura Spring BBVA
 */
@RunWith(MockitoJUnitRunner.class)
public class TestTransaccionHyt6 {

    @InjectMocks
    private TransaccionHyt6 transaccion;

    @Spy
    private ServicioTransacciones servicioTransacciones = Mockito.mock(ServicioTransacciones.class);

    @Test
    public void test() {

        PeticionTransaccionHyt6 peticion = new PeticionTransaccionHyt6();

        RespuestaTransaccionHyt6 respuesta = new RespuestaTransaccionHyt6();

        Mockito.when(servicioTransacciones.invocar(PeticionTransaccionHyt6.class, RespuestaTransaccionHyt6.class,
                peticion)).thenReturn(respuesta);

        RespuestaTransaccionHyt6 result = transaccion.invocar(peticion);

        Assert.assertEquals(result, respuesta);
    }
}