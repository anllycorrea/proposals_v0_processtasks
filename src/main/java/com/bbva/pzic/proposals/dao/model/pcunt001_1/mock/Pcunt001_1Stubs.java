package com.bbva.pzic.proposals.dao.model.pcunt001_1.mock;

import com.bbva.pzic.proposals.dao.model.pcunt001_1.Entityout;
import com.bbva.pzic.proposals.util.helper.ObjectMapperHelper;

import java.io.IOException;

/**
 * Created on 15/11/2019.
 *
 * @author Entelgy
 */
public final class Pcunt001_1Stubs {

    private static final Pcunt001_1Stubs INSTANCE = new Pcunt001_1Stubs();
    private ObjectMapperHelper mapper = ObjectMapperHelper.getInstance();

    private Pcunt001_1Stubs() {
    }

    public static Pcunt001_1Stubs getInstance() {
        return INSTANCE;
    }

    public Entityout getEntityOut() throws IOException {
        return mapper.readValue(Thread.currentThread().getContextClassLoader().getResourceAsStream(
                "com/bbva/pzic/proposals/dao/model/pcunt001_1/mock/entityOut.json"), Entityout.class);
    }
}
