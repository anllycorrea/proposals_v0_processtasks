package com.bbva.pzic.proposals.dao.mapper;

import com.bbva.pzic.proposals.business.dto.DTOInputListProposals;
import com.bbva.pzic.proposals.canonic.ProposalData;
import com.bbva.pzic.proposals.dao.model.listProposals.FormatProposalData;

import java.util.HashMap;

/**
 * Created on 06/12/2016.
 *
 * @author Entelgy
 */
public interface IListProposalsDAOMapper {

    /**
     * Creates a new dictionary (key: value) with the provided parameter.
     *
     * @param dtoInputListProposals
     * @return the created dictionary.
     */
    HashMap<String, String> mapInput(DTOInputListProposals dtoInputListProposals);

    /**
     * Creates a new {@Link ProposalData} instance and initializes it with the provided
     * parameter.
     *
     * @param formatProposalData
     * @return the created object.
     */
    ProposalData mapOutput(FormatProposalData formatProposalData);

}
