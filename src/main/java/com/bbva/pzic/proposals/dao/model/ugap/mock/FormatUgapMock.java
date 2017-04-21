package com.bbva.pzic.proposals.dao.model.ugap.mock;

import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.pzic.proposals.dao.model.ugap.FormatoUGMSGAP1;
import com.bbva.pzic.proposals.util.Errors;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created on 13/04/2017.
 *
 * @author Entelgy
 */
@Component
public class FormatUgapMock {

    private ObjectMapper objectMapper;

    public FormatUgapMock() {
        objectMapper = new ObjectMapper();
    }

    public FormatoUGMSGAP1 getFormatoUGMSGAP1() {
        try {
            return objectMapper.readValue(Thread.currentThread().getContextClassLoader()
                    .getResourceAsStream("com/bbva/pzic/proposals/dao/model/ugap/mock/FormatoUGMSGAP1.json"), FormatoUGMSGAP1.class);
        } catch (IOException e) {
            throw new BusinessServiceException(Errors.TECHNICAL_ERROR, e);
        }
    }
}
