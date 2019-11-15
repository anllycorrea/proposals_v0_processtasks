package com.bbva.pzic.proposals.dao;

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
public interface IProposalsDAO {

    List<Proposal> listProposals(InputListProposals listProposals);

    DTOIntSimulatedProposals simulateProposals(DTOIntSimulatedProposal simulatedProposal);

    ExternalFinancingProposal createExternalFinancingProposal(DTOIntExternalFinancingProposal dtoIn);

    DTOOutExternalFinancingProposalData listExternalFinancingProposals(DTOInputListExternalFinancingProposals dtoIn);

    void modifyExternalFinancingProposal(DTOInputModifyExternalFinancingProposal dtoIn);

    ValidateAccess createQuestionnairesValidateAccess(DTOIntValidateAccess dtoInt);
}
