package com.bbva.pzic.proposals.dao.model.pcunt001_1;

import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Test de la transacci&oacute;n <code>PCUNT001</code>
 *
 * @author Arquitectura Spring BBVA
 */
@RunWith(MockitoJUnitRunner.class)
public class TestTransaccionPcunt001_1 {

    @InjectMocks
    private TransaccionPcunt001_1 transaccion;

    @Mock
    private ServicioTransacciones servicioTransacciones;

    @Test
    public void test() {

        PeticionTransaccionPcunt001_1 peticion = new PeticionTransaccionPcunt001_1();
        RespuestaTransaccionPcunt001_1 respuesta = new RespuestaTransaccionPcunt001_1();

        Mockito.when(servicioTransacciones.invocar(PeticionTransaccionPcunt001_1.class, RespuestaTransaccionPcunt001_1.class,
                peticion)).thenReturn(respuesta);

        RespuestaTransaccionPcunt001_1 result = transaccion.invocar(peticion);

        Assert.assertEquals(result, respuesta);
    }
}
