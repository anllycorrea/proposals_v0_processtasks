package com.bbva.pzic.proposals.business;

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
public interface ISrvIntProposalsV0 {

    List<Proposal> listProposals(InputListProposals listProposals);

    SimulatedProposalsData simulateProposals(DTOIntSimulatedProposal simulatedProposal);

    ExternalFinancingProposal createExternalFinancingProposal(DTOIntExternalFinancingProposal dtoIntExternalFinancingProposal);

    DTOOutExternalFinancingProposalData listExternalFinancingProposals(DTOInputListExternalFinancingProposals dtoIn);

    void modifyExternalFinancingProposal(DTOInputModifyExternalFinancingProposal dtoIn);
}