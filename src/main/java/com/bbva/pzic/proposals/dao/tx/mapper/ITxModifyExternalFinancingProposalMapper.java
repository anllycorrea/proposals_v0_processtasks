package com.bbva.pzic.proposals.dao.tx.mapper;

import com.bbva.pzic.proposals.business.dto.DTOInputModifyExternalFinancingProposal;
import com.bbva.pzic.proposals.dao.model.ugmp.FormatoUGMEGMP;

/**
 * Created on 12/04/2017.
 *
 * @author Entelgy
 */
public interface ITxModifyExternalFinancingProposalMapper {

    FormatoUGMEGMP mapIn(DTOInputModifyExternalFinancingProposal dtoIn);
}