package com.bbva.pzic.proposals.business;

import com.bbva.pzic.proposals.business.dto.*;
import com.bbva.pzic.proposals.canonic.ExternalFinancingProposal;
import com.bbva.pzic.proposals.canonic.Proposal;
import com.bbva.pzic.proposals.facade.v0.dto.ValidateAccess;

import java.util.List;

/**
 * Created on 28/12/2017.
 *
 * @author Entelgy
 */
public interface ISrvIntProposals {

    List<Proposal> listProposals(InputListProposals listProposals);

    DTOIntSimulatedProposals simulateProposals(DTOIntSimulatedProposal simulatedProposal);

    ExternalFinancingProposal createExternalFinancingProposal(DTOIntExternalFinancingProposal dtoIntExternalFinancingProposal);

    DTOOutExternalFinancingProposalData listExternalFinancingProposals(DTOInputListExternalFinancingProposals dtoIn);

    void modifyExternalFinancingProposal(DTOInputModifyExternalFinancingProposal dtoIn);

    ValidateAccess createQuestionnairesValidateAccess(DTOIntValidateAccess dtoInt);
}
