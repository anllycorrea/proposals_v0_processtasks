package com.bbva.pzic.proposals.dao.tx;

import com.bbva.pzic.proposals.dao.tx.mapper.ITxSimulateProposalsMapper;
import com.bbva.pzic.proposals.util.tx.Tx;

import javax.annotation.Resource;

/**
 * Created on 28/12/2017.
 * 
 * @author Entelgy
 */
@Tx("txSimulateProposals")
public class TxSimulateProposals {

	@Resource(name = "txSimulateProposalsMapper")
	private ITxSimulateProposalsMapper txSimulateProposalsMapper;
}