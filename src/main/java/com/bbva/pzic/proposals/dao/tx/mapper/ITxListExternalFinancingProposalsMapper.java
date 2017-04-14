package com.bbva.pzic.proposals.dao.tx.mapper;

import com.bbva.pzic.proposals.business.dto.DTOInputListExternalFinancingProposals;
import com.bbva.pzic.proposals.business.dto.DTOOutExternalFinancingProposalData;
import com.bbva.pzic.proposals.dao.model.uglp.FormatoUGMEGLP;
import com.bbva.pzic.proposals.dao.model.uglp.FormatoUGMSGLP1;
import com.bbva.pzic.proposals.dao.model.uglp.FormatoUGMSGLP2;

/**
 * Created on 12/04/2017.
 *
 * @author Entelgy
 */
public interface ITxListExternalFinancingProposalsMapper {
    /**
     * mapeo de entrada al formato HOST
     *
     * @param dtoIn DTO con los campos validados
     * @return {@link FormatoUGMEGLP}
     */
    FormatoUGMEGLP mapIn(DTOInputListExternalFinancingProposals dtoIn);

    /**
     * Mapeo del cuerpo de la respuesta de un Formato Host a una entidad canonica
     *
     * @param formatOutput formato que contiene el cuerpo de la respuesta
     * @param dtoOut       DTO de salida
     * @return {@link DTOOutExternalFinancingProposalData}
     */
    DTOOutExternalFinancingProposalData mapOut1(FormatoUGMSGLP1 formatOutput, DTOOutExternalFinancingProposalData dtoOut);

    /**
     * Mapeo de la paginacion de un formato host a un DTO de salida
     *
     * @param formatOutput formato con los campos de paginacion
     * @param dtoOut       DTO de salida
     * @return {@link DTOOutExternalFinancingProposalData}
     */
    DTOOutExternalFinancingProposalData mapOut2(FormatoUGMSGLP2 formatOutput, DTOOutExternalFinancingProposalData dtoOut);
}