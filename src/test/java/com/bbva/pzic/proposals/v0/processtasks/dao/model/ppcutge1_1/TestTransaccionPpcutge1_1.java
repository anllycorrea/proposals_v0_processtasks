package com.bbva.pzic.proposals.v0.processtasks.dao.model.ppcutge1_1;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Test de la transacci&oacute;n <code>PISDT303</code>
 *
 * @author Arquitectura Spring BBVA
 */

@RunWith(MockitoJUnitRunner.class)
public class TestTransaccionPpcutge1_1 {

    @InjectMocks
    private TransaccionPpcutge1_1 transaccion;

    @Mock
    private ServicioTransacciones servicioTransacciones;

    @Test
    public void test() {

        PeticionTransaccionPpcutge1_1 peticion = new PeticionTransaccionPpcutge1_1();
        RespuestaTransaccionPpcutge1_1 respuesta = new RespuestaTransaccionPpcutge1_1();

        when(servicioTransacciones.invocar(PeticionTransaccionPpcutge1_1.class, RespuestaTransaccionPpcutge1_1.class, peticion))
                .thenReturn(respuesta);
        RespuestaTransaccionPpcutge1_1 result = transaccion.invocar(peticion);
        assertEquals(result, respuesta);

    }
}
