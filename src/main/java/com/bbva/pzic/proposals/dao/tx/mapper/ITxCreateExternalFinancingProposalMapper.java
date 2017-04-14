package com.bbva.pzic.proposals.dao.tx.mapper;

import com.bbva.pzic.proposals.business.dto.DTOIntExternalFinancingProposal;
import com.bbva.pzic.proposals.canonic.ExternalFinancingProposal;
import com.bbva.pzic.proposals.dao.model.ugap.FormatoUGMEGAP;
import com.bbva.pzic.proposals.dao.model.ugap.FormatoUGMSGAP1;

/**
 * Created on 12/04/2017.
 * 
 * @author Entelgy
 */
public interface ITxCreateExternalFinancingProposalMapper {

    FormatoUGMEGAP mapIn(DTOIntExternalFinancingProposal dtoIntExternalFinancingProposal);

    ExternalFinancingProposal mapOut(FormatoUGMSGAP1 formatoUGMSGAP1);
}