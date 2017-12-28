package com.bbva.pzic.proposals.dao.tx.mapper.impl;

import com.bbva.pzic.proposals.business.dto.DTOIntProposals;
import com.bbva.pzic.proposals.business.dto.InputListProposals;
import com.bbva.pzic.proposals.dao.tx.mapper.ITxListProposalsMapperV0;
import com.bbva.pzic.proposals.util.mappers.Mapper;

/**
 * Created on 28/12/2017.
 *
 * @author Entelgy
 */
@Mapper
public class TxListProposalsMapperV0 implements ITxListProposalsMapperV0 {

    @Override
    public Object mapIn(final InputListProposals listProposals) {
        return null;
    }

    @Override
    public DTOIntProposals mapOut(final Object object,
                                  final DTOIntProposals proposals) {
        return null;
    }
}