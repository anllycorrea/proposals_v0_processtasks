package com.bbva.pzic.proposals.dao.model.ugap.mock;

import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.pzic.proposals.dao.model.ugap.FormatoUGMEGAP;
import com.bbva.pzic.proposals.dao.model.ugap.FormatoUGMSGAP1;
import com.bbva.pzic.proposals.dao.model.ugap.PeticionTransaccionUgap;
import com.bbva.pzic.proposals.dao.model.ugap.RespuestaTransaccionUgap;
import com.bbva.pzic.proposals.util.Errors;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.cxf.helpers.IOUtils;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;

/**
 * Invocador de la transacci&oacute;n <code>UGAP</code>
 *
 * @see PeticionTransaccionUgap
 * @see RespuestaTransaccionUgap
 */
@Component("transaccionUgap")
public class TransaccionUgapMock implements InvocadorTransaccion<PeticionTransaccionUgap, RespuestaTransaccionUgap> {
    public static final String NRO_DOCUMENTO = "1234567890";
    private static final String FORMATO_UGMSGAP1 = "com/bbva/pzic/proposals/dao/model/ugap/mock/FormatoUGMSGAP1.json";
    private ObjectMapper mapper;

    @PostConstruct
    public void init() {
        mapper = new ObjectMapper();
    }

    @Override
    public RespuestaTransaccionUgap invocar(PeticionTransaccionUgap transaccion) {
        final RespuestaTransaccionUgap response = new RespuestaTransaccionUgap();
        final FormatoUGMEGAP format = (FormatoUGMEGAP) transaccion.getCuerpo().getPartes().get(0);
        if (!NRO_DOCUMENTO.equalsIgnoreCase(format.getNrodocu())) {
            CopySalida copy = buildData(getInstance(FORMATO_UGMSGAP1, FormatoUGMSGAP1.class));
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

    private <T> T getInstance(String file, Class<T> claz) {
        InputStream in = Thread.currentThread().getContextClassLoader().
                getResourceAsStream(file);
        try {
            return mapper.readValue(IOUtils.readBytesFromStream(in), claz);
        } catch (IOException e) {
            throw new BusinessServiceException(Errors.TECHNICAL_ERROR, e);
        }
    }

}