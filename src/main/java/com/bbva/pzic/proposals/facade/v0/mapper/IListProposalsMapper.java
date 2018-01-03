package com.bbva.pzic.proposals.facade.v0.mapper;

import com.bbva.pzic.proposals.business.dto.InputListProposals;
import com.bbva.pzic.proposals.canonic.Proposal;
import com.bbva.pzic.proposals.canonic.Proposals;

import java.util.List;

/**
 * Created on 28/12/2017.
 *
 * @author Entelgy
 */
public interface IListProposalsMapper {

    InputListProposals mapIn(String participantIdentityDocumentDocumentTypeId,
                             String participantIdentityDocumentDocumentNumber, String customerId);

    Proposals mapOut(List<Proposal> proposals);
}