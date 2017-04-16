package com.bbva.pzic.proposals.dao;

import com.bbva.pzic.proposals.business.dto.DTOInputListExternalFinancingProposals;
import com.bbva.pzic.proposals.business.dto.DTOInputModifyExternalFinancingProposal;
import com.bbva.pzic.proposals.business.dto.DTOIntExternalFinancingProposal;
import com.bbva.pzic.proposals.business.dto.DTOOutExternalFinancingProposalData;
import com.bbva.pzic.proposals.canonic.ExternalFinancingProposal;

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

    ExternalFinancingProposal createExternalFinancingProposal(DTOIntExternalFinancingProposal dtoIn);

    void modifyExternalFinancingProposal(DTOInputModifyExternalFinancingProposal dtoIn);
}