package com.bbva.pzic.proposals.business;

import com.bbva.pzic.proposals.business.dto.DTOInputListProposals;
import com.bbva.pzic.proposals.canonic.ProposalData;

/**
 * Created on 12/12/2016.
 *
 * @author Entelgy
 */
public interface ISrvIntProposals {

    /**
     * Validates all constraints on queryFilter and then gets all proposals of products that
     * match the query filter
     *
     * @param queryFilter filter
     * @return a list of proposals
     * @throws com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException if a constraint violation occurred
     */
    ProposalData listProposals(DTOInputListProposals queryFilter);

}
