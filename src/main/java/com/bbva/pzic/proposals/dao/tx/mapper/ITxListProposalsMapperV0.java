package com.bbva.pzic.proposals.dao.tx.mapper;

import com.bbva.pzic.proposals.business.dto.InputListProposals;
import com.bbva.pzic.proposals.canonic.Proposal;
import com.bbva.pzic.proposals.dao.model.hyt6.FormatoHYMR601;
import com.bbva.pzic.proposals.dao.model.hyt6.FormatoHYMR602;

/**
 * Created on 28/12/2017.
 *
 * @author Entelgy
 */
public interface ITxListProposalsMapperV0 {

    FormatoHYMR601 mapIn(InputListProposals listProposals);

    Proposal mapOut(FormatoHYMR602 formatOut, Proposal proposal);
}