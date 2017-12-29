package com.bbva.pzic.proposals.dao.model.hyt6.mock;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;
import com.bbva.pzic.proposals.dao.model.hyt6.FormatoHYMR601;
import com.bbva.pzic.proposals.dao.model.hyt6.FormatoHYMR602;
import com.bbva.pzic.proposals.dao.model.hyt6.PeticionTransaccionHyt6;
import com.bbva.pzic.proposals.dao.model.hyt6.RespuestaTransaccionHyt6;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 29/12/2017.
 *
 * @author Entelgy
 */
@Component("transaccionHyt6")
public class TransaccionHyt6Mock implements InvocadorTransaccion<PeticionTransaccionHyt6, RespuestaTransaccionHyt6> {

    public static final String TEST_EMPTY = "8888";
    public static final String TEST_NULL = "9999";
    private FormatoHYMRMock mock;

    @PostConstruct
    public void init() {
        mock = new FormatoHYMRMock();
    }

    @Override
    public RespuestaTransaccionHyt6 invocar(PeticionTransaccionHyt6 peticion) throws ExcepcionTransaccion {
        final RespuestaTransaccionHyt6 response = new RespuestaTransaccionHyt6();
        FormatoHYMR601 format = (FormatoHYMR601) peticion.getCuerpo().getPartes().get(0);
        if (TEST_NULL.equals(format.getCodcent())) {
            return response;
        }
        try {
            if (TEST_EMPTY.equals(format.getCodcent())) {
                response.getCuerpo().getPartes().addAll(buildDataCopies(mock.buildFormatoHYMR602sEmpty()));
            } else {
                response.getCuerpo().getPartes().addAll(buildDataCopies(mock.buildFormatoHYMR602s()));

            }
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        return response;
    }

    @Override
    public RespuestaTransaccionHyt6 invocarCache(PeticionTransaccionHyt6 peticion) throws ExcepcionTransaccion {
        return null;
    }

    @Override
    public void vaciarCache() {

    }


    private List<CopySalida> buildDataCopies(List<FormatoHYMR602> formatoHYMR602s) throws IOException {
        List<FormatoHYMR602> formats = formatoHYMR602s;

        List<CopySalida> copies = new ArrayList<>();
        for (FormatoHYMR602 format : formats) {
            CopySalida copy = new CopySalida();
            copy.setCopy(format);
            copies.add(copy);
        }
        return copies;
    }

}
