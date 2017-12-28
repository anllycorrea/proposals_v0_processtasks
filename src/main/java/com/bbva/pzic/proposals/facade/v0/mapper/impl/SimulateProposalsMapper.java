package com.bbva.pzic.proposals.facade.v0.mapper.impl;

import com.bbva.pzic.proposals.business.dto.DTOIntSimulatedProposal;
import com.bbva.pzic.proposals.canonic.SimulatedProposal;
import com.bbva.pzic.proposals.facade.v0.mapper.ISimulateProposalsMapper;
import com.bbva.pzic.proposals.util.mappers.Mapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created on 28/12/2017.
 *
 * @author Entelgy
 */
@Mapper
public class SimulateProposalsMapper implements ISimulateProposalsMapper {

    private static final Log LOG = LogFactory.getLog(SimulateProposalsMapper.class);



    @Override
    public DTOIntSimulatedProposal mapIn(final SimulatedProposal simulatedProposal) {
        LOG.info("... called method SimulateProposalsMapper.mapIn ...");
        DTOIntSimulatedProposal dTOIntSimulatedProposal = new DTOIntSimulatedProposal();
        return dTOIntSimulatedProposal;
    }
}