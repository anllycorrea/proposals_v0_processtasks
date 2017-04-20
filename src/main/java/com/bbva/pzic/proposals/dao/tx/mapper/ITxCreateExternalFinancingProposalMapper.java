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

    /**
     * mapeo de entrada al formato HOST
     *
     * @param dtoIn DTO con los campos validados
     * @return {@link FormatoUGMEGAP}
     */
    FormatoUGMEGAP mapIn(DTOIntExternalFinancingProposal dtoIn);

    /**
     * Mapeo del cuerpo de la respuesta de un Formato Host a una entidad canonica
     *
     * @param formatOutput formato que contiene el cuerpo de la respuesta
     * @return {@link ExternalFinancingProposal}
     */
    ExternalFinancingProposal mapOut(FormatoUGMSGAP1 formatOutput);
}