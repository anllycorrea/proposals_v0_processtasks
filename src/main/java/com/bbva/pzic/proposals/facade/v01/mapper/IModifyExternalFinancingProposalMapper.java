package com.bbva.pzic.proposals.facade.v01.mapper;

import com.bbva.pzic.proposals.business.dto.DTOInputModifyExternalFinancingProposal;
import com.bbva.pzic.proposals.canonic.ExternalFinancingProposal;

/**
 * Created on 12/04/2017.
 *
 * @author Entelgy
 */
public interface IModifyExternalFinancingProposalMapper {

    DTOInputModifyExternalFinancingProposal mapIn(String externalFinancingProposalId, ExternalFinancingProposal externalFinancingProposal);
}