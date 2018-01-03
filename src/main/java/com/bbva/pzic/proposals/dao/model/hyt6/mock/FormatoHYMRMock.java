package com.bbva.pzic.proposals.dao.model.hyt6.mock;

import com.bbva.pzic.proposals.dao.model.hyt6.FormatoHYMR602;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

/**
 * Created on 29/12/2017.
 *
 * @author Entelgy
 */
public class FormatoHYMRMock {

    private ObjectMapper objectMapper;

    public FormatoHYMRMock() {
        objectMapper = new ObjectMapper();
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
