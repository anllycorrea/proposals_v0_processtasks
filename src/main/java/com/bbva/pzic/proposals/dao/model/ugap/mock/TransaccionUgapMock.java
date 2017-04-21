package com.bbva.pzic.proposals.dao.model.ugap.mock;

import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;
import com.bbva.pzic.proposals.dao.model.ugap.FormatoUGMEGAP;
import com.bbva.pzic.proposals.dao.model.ugap.PeticionTransaccionUgap;
import com.bbva.pzic.proposals.dao.model.ugap.RespuestaTransaccionUgap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Invocador de la transacci&oacute;n <code>UGAP</code>
 *
 * @see PeticionTransaccionUgap
 * @see RespuestaTransaccionUgap
 */
@Component("transaccionUgap")
public class TransaccionUgapMock implements InvocadorTransaccion<PeticionTransaccionUgap, RespuestaTransaccionUgap> {

    public static final String NRO_DOCUMENTO = "1234567890";

    @Autowired
    private FormatUgapMock mock;

    @Override
    public RespuestaTransaccionUgap invocar(PeticionTransaccionUgap transaccion) {
        final RespuestaTransaccionUgap response = new RespuestaTransaccionUgap();
        final FormatoUGMEGAP format = (FormatoUGMEGAP) transaccion.getCuerpo().getPartes().get(0);
        if (!NRO_DOCUMENTO.equalsIgnoreCase(format.getNrodocu())) {
            CopySalida copy = buildData(mock.getFormatoUGMSGAP1());
            response.getCuerpo().getPartes().add(copy);
        }

        return response;
    }

    @Override
    public RespuestaTransaccionUgap invocarCache(PeticionTransaccionUgap transaccion) {
        return null;
    }

    @Override
    public void vaciarCache() {
    }

    private CopySalida buildData(Object object) {
        CopySalida copy = new CopySalida();
        copy.setCopy(object);
        return copy;
    }
}