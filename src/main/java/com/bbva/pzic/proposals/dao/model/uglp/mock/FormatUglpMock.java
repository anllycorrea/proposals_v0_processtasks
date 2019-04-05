package com.bbva.pzic.proposals.dao.model.uglp.mock;

import com.bbva.pzic.proposals.dao.model.uglp.FormatoUGMSGLP1;
import com.bbva.pzic.proposals.dao.model.uglp.FormatoUGMSGLP2;
import com.bbva.pzic.proposals.util.helper.ObjectMapperHelper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;
import java.util.List;

/**
 * Created on 13/04/2017.
 *
 * @author Entelgy
 */
public class FormatUglpMock {

    private ObjectMapperHelper objectMapper;

    public FormatUglpMock() {
        objectMapper = ObjectMapperHelper.getInstance();
    }

    public List<FormatoUGMSGLP1> getFormatoUGMSGLP1s() throws IOException {
        return objectMapper.readValue(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("com/bbva/pzic/proposals/dao/model/uglp/mock/listFormatoUGMSGLP1.json"), new TypeReference<List<FormatoUGMSGLP1>>() {
        });
    }

    public FormatoUGMSGLP2 getFormatoUGMSGLP2() throws IOException {
        return objectMapper.readValue(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("com/bbva/pzic/proposals/dao/model/uglp/mock/formatoUGMSGLP2.json"), FormatoUGMSGLP2.class);
    }
}
