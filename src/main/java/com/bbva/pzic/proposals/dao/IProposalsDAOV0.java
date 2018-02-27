package com.bbva.pzic.proposals.dao;

import com.bbva.pzic.proposals.business.dto.*;
import com.bbva.pzic.proposals.canonic.ExternalFinancingProposal;
import com.bbva.pzic.proposals.canonic.Proposal;
import com.bbva.pzic.proposals.canonic.SimulatedProposalsData;

import java.util.List;

/**
 * Created on 28/12/2017.
 *
 * @author Entelgy
 */
public interface IProposalsDAOV0 {

    List<Proposal> listProposals(InputListProposals listProposals);

    SimulatedProposalsData simulateProposals(DTOIntSimulatedProposal simulatedProposal);

    ExternalFinancingProposal createExternalFinancingProposal(DTOIntExternalFinancingProposal dtoIn);

    /**
     * Metodo que realiza la conexion con host
     *
     * @param dtoIn DTO con los datos de entrada validados
     * @return {@link DTOOutExternalFinancingProposalData}
     */
    DTOOutExternalFinancingProposalData listExternalFinancingProposals(DTOInputListExternalFinancingProposals dtoIn);

    void modifyExternalFinancingProposal(DTOInputModifyExternalFinancingProposal dtoIn);
}
