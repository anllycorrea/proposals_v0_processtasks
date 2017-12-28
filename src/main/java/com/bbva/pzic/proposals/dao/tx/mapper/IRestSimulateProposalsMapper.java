package com.bbva.pzic.proposals.dao.tx.mapper;

import com.bbva.pzic.proposals.business.dto.DTOIntSimulatedProposal;
import com.bbva.pzic.proposals.canonic.SimulatedProposalsData;

/**
 * Created on 28/12/2017.
 *
 * @author Entelgy
 */
public interface IRestSimulateProposalsMapper {

    Object mapIn(DTOIntSimulatedProposal dtoIn);

    SimulatedProposalsData mapOut(Object response);
}