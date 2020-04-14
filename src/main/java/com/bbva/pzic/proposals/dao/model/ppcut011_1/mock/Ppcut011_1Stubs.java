package com.bbva.pzic.proposals.dao.model.ppcut011_1.mock;

import com.bbva.pzic.proposals.dao.model.ppcut011_1.Entityout;
import com.bbva.pzic.proposals.util.helper.ObjectMapperHelper;

import java.io.IOException;

/**
 * Created on 15/11/2019.
 *
 * @author Entelgy
 */
public final class Ppcut011_1Stubs {

    private static final Ppcut011_1Stubs INSTANCE = new Ppcut011_1Stubs();

    private final ObjectMapperHelper mapper = ObjectMapperHelper.getInstance();

    private Ppcut011_1Stubs() {
    }

    public static Ppcut011_1Stubs getInstance() {
        return INSTANCE;
    }

    public Entityout getEntityOut() throws IOException {
        return mapper.readValue(Thread.currentThread().getContextClassLoader().getResourceAsStream(
                "com/bbva/pzic/proposals/dao/model/ppcut011_1/mock/entityOut.json"), Entityout.class);
    }
}
