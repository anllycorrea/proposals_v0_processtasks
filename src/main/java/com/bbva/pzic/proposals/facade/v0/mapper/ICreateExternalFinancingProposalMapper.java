package com.bbva.pzic.proposals.facade.v0.mapper;

import com.bbva.pzic.proposals.business.dto.DTOIntExternalFinancingProposal;
import com.bbva.pzic.proposals.canonic.ExternalFinancingProposal;

/**
 * Created on 12/04/2017.
 *
 * @author Entelgy
 */
public interface ICreateExternalFinancingProposalMapper {
    /**
     * Mapeo de entrada, los datos obtenidos del payload a un DTO la cual tiene
     * anotaciones de validacion
     *
     * @param thirdPartyProviderUserId  Third party provider user id
     * @param externalFinancingProposal Payload
     * @return {@link DTOIntExternalFinancingProposal}
     */
    DTOIntExternalFinancingProposal mapIn(String thirdPartyProviderUserId, ExternalFinancingProposal externalFinancingProposal);
}