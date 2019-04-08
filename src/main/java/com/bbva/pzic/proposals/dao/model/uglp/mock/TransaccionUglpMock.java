package com.bbva.pzic.proposals.dao.model.uglp.mock;

import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;
import com.bbva.pzic.proposals.dao.model.uglp.FormatoUGMEGLP;
import com.bbva.pzic.proposals.dao.model.uglp.FormatoUGMSGLP1;
import com.bbva.pzic.proposals.dao.model.uglp.PeticionTransaccionUglp;
import com.bbva.pzic.proposals.dao.model.uglp.RespuestaTransaccionUglp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 13/04/2017.
 *
 * @author Entelgy
 */
@Component("transaccionUglp")
public class TransaccionUglpMock implements InvocadorTransaccion<PeticionTransaccionUglp, RespuestaTransaccionUglp> {

    public static final String TEST_EMPTY = "9999";
    public static final String TEST_NOT_PAGINATION = "8888";

    @Autowired
    private FormatUglpMock mock;

    @Override
    public RespuestaTransaccionUglp invocar(PeticionTransaccionUglp peticionTransaccionUglp) {
        final RespuestaTransaccionUglp response = new RespuestaTransaccionUglp();
        response.setCodigoControl("OK");
        response.setCodigoRetorno("OK_COMMIT");

        FormatoUGMEGLP format = (FormatoUGMEGLP) peticionTransaccionUglp.getCuerpo().getPartes().get(0);
        String nroDocu = format.getNrodocu();
        if (TEST_EMPTY.equalsIgnoreCase(nroDocu)) {
            return response;
        }
        try {
            if (TEST_NOT_PAGINATION.equalsIgnoreCase(nroDocu)) {
                response.getCuerpo().getPartes().addAll(buildDataCopies());

            } else {
                response.getCuerpo().getPartes().addAll(buildDataCopies());
                response.getCuerpo().getPartes().add(buildPaginationCopy());
            }
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        return response;
    }

    @Override
    public RespuestaTransaccionUglp invocarCache(PeticionTransaccionUglp peticionTransaccionUglp) {
        return null;
    }

    @Override
    public void vaciarCache() {

    }

    private List<CopySalida> buildDataCopies() throws IOException {
        List<FormatoUGMSGLP1> formats = mock.getFormatoUGMSGLP1s();

        List<CopySalida> copies = new ArrayList<>();
        for (FormatoUGMSGLP1 format : formats) {
            CopySalida copy = new CopySalida();
            copy.setCopy(format);
            copies.add(copy);
        }
        return copies;
    }

    private CopySalida buildPaginationCopy() throws IOException {
        CopySalida copy = new CopySalida();
        copy.setCopy(mock.getFormatoUGMSGLP2());
        return copy;
    }
}
