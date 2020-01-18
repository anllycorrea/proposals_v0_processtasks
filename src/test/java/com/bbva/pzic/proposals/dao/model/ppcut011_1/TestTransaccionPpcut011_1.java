package com.bbva.pzic.proposals.dao.model.ppcut011_1;

import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Test de la transacci&oacute;n <code>PPCUT011</code>
 *
 * @author Arquitectura Spring BBVA
 */
@RunWith(MockitoJUnitRunner.class)
public class TestTransaccionPpcut011_1 {

    @InjectMocks
    private TransaccionPpcut011_1 transaccion;

    @Mock
    private ServicioTransacciones servicioTransacciones;

    @Test
    public void test() {
        PeticionTransaccionPpcut011_1 rq = new PeticionTransaccionPpcut011_1();
        RespuestaTransaccionPpcut011_1 rs = new RespuestaTransaccionPpcut011_1();

        when(servicioTransacciones.invocar(PeticionTransaccionPpcut011_1.class, RespuestaTransaccionPpcut011_1.class, rq)).thenReturn(rs);

        RespuestaTransaccionPpcut011_1 result = transaccion.invocar(rq);

        assertEquals(result, rs);
    }
}
