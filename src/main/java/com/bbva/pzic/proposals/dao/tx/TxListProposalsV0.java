package com.bbva.pzic.proposals.dao.tx;

import com.bbva.pzic.proposals.dao.tx.mapper.ITxListProposalsMapperV0;
import com.bbva.pzic.proposals.util.tx.Tx;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created on 28/12/2017.
 *
 * @author Entelgy
 */
@Tx
public class TxListProposalsV0 {

    @Autowired
    private ITxListProposalsMapperV0 txListProposalsMapper;
}