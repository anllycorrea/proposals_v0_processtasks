package com.bbva.pzic.proposals.dao;

import com.bbva.pzic.proposals.business.dto.DTOIntProposals;
import com.bbva.pzic.proposals.business.dto.InputListProposals;

/**
 * Created on 28/12/2017.
 *
 * @author Entelgy
 */
public interface IProposalsDAOV0 {

    DTOIntProposals listProposals(InputListProposals listProposals);

}
