package com.bbva.pzic.proposals.dao.mapper;

import com.bbva.pzic.proposals.business.dto.DTOInputListProposals;

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

}
