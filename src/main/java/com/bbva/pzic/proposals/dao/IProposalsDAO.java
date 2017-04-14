package com.bbva.pzic.proposals.dao;

import com.bbva.pzic.proposals.business.dto.DTOInputListExternalFinancingProposals;
import com.bbva.pzic.proposals.business.dto.DTOOutExternalFinancingProposalData;

/**
 * Created on 12/04/2017.
 *
 * @author Entelgy
 */
public interface IProposalsDAO {
    /**
     * Metodo que realiza la conexion con host
     *
     * @param dtoIn DTO con los datos de entrada validados
     * @return {@link DTOOutExternalFinancingProposalData}
     */
    DTOOutExternalFinancingProposalData listExternalFinancingProposals(DTOInputListExternalFinancingProposals dtoIn);
}