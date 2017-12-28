package com.bbva.pzic.proposals.dao.tx.mapper.impl;

import com.bbva.pzic.proposals.business.dto.DTOIntSimulatedProposal;
import com.bbva.pzic.proposals.canonic.SimulatedProposalsData;
import com.bbva.pzic.proposals.dao.tx.mapper.IRestSimulateProposalsMapper;
import com.bbva.pzic.proposals.util.mappers.Mapper;

/**
 * Created on 28/12/2017.
 *
 * @author Entelgy
 */
@Mapper
public class RestSimulateProposalsMapper implements IRestSimulateProposalsMapper {

    @Override
    public Object mapIn(DTOIntSimulatedProposal dtoIn) {
        return null;
    }

    @Override
    public SimulatedProposalsData mapOut(Object response) {
        return null;
    }
}