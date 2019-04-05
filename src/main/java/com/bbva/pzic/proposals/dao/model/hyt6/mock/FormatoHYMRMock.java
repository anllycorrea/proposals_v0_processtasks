package com.bbva.pzic.proposals.dao.model.hyt6.mock;

import com.bbva.pzic.proposals.dao.model.hyt6.FormatoHYMR602;
import com.bbva.pzic.proposals.util.helper.ObjectMapperHelper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;
import java.util.List;

/**
 * Created on 29/12/2017.
 *
 * @author Entelgy
 */
public class FormatoHYMRMock {

    private ObjectMapperHelper objectMapper;

    public FormatoHYMRMock() {
        objectMapper = ObjectMapperHelper.getInstance();
    }

    public List<FormatoHYMR602> buildFormatoHYMR602s() throws IOException {
        return objectMapper.readValue(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("com/bbva/pzic/proposals/dao/model/hyt6/mock/formatoHYMR.json"), new TypeReference<List<FormatoHYMR602>>() {
        });
    }

    public List<FormatoHYMR602> buildFormatoHYMR602sEmpty() throws IOException {
        return objectMapper.readValue(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("com/bbva/pzic/proposals/dao/model/hyt6/mock/formatoHYMR-Empty.json"), new TypeReference<List<FormatoHYMR602>>() {
        });
    }

}
