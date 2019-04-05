package com.bbva.pzic.proposals.dao;

import com.bbva.pzic.proposals.business.dto.DTOInputListProposals;
import com.bbva.pzic.proposals.canonic.ProposalData;

/**
 * Created on 06/12/2016.
 *
 * @author Entelgy
 */
public interface IListProposalsDAO {

    /**
     * Gets all proposals of products that match the query filter
     *
     * @param queryFilter filter
     * @return a list of financial statements
     */
    ProposalData listProposals(DTOInputListProposals queryFilter);

}