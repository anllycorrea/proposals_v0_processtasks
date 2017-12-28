package com.bbva.pzic.proposals.dao.tx.mapper;

import com.bbva.pzic.proposals.business.dto.DTOIntProposals;
import com.bbva.pzic.proposals.business.dto.InputListProposals;

/**
 * Created on 28/12/2017.
 * 
 * @author Entelgy
 */
public interface ITxListProposalsMapperV0 {

	Object mapIn(InputListProposals listProposals);

	DTOIntProposals mapOut(Object object, DTOIntProposals proposals);
}