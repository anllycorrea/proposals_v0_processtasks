package com.bbva.pzic.proposals.dao.impl;

import com.bbva.pzic.proposals.business.dto.DTOInputListExternalFinancingProposals;
import com.bbva.pzic.proposals.business.dto.DTOInputModifyExternalFinancingProposal;
import com.bbva.pzic.proposals.business.dto.DTOIntExternalFinancingProposal;
import com.bbva.pzic.proposals.business.dto.DTOOutExternalFinancingProposalData;
import com.bbva.pzic.proposals.canonic.ExternalFinancingProposal;
import com.bbva.pzic.proposals.dao.IProposalsDAO;
import com.bbva.pzic.proposals.dao.tx.TxCreateExternalFinancingProposal;
import com.bbva.pzic.proposals.dao.tx.TxListExternalFinancingProposals;
import com.bbva.pzic.proposals.dao.tx.TxModifyExternalFinancingProposal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created on 12/04/2017.
 *
 * @author Entelgy
 */
@Repository
public class ProposalsDAO implements IProposalsDAO {

    @Autowired
    private TxListExternalFinancingProposals txListExternalFinancingProposals;

    @Autowired
    private TxCreateExternalFinancingProposal txCreateExternalFinancingProposal;

    @Autowired
    private TxModifyExternalFinancingProposal txModifyExternalFinancingProposal;

    /**
     * @see com.bbva.pzic.proposals.dao.IProposalsDAO#listExternalFinancingProposals(com.bbva.pzic.proposals.business.dto.DTOInputListExternalFinancingProposals)
     */
    @Override
    public DTOOutExternalFinancingProposalData listExternalFinancingProposals(final DTOInputListExternalFinancingProposals dtoIn) {
        return txListExternalFinancingProposals.invoke(dtoIn);
    }

    /**
     * @see com.bbva.pzic.proposals.dao.IProposalsDAO#createExternalFinancingProposal(com.bbva.pzic.proposals.business.dto.DTOIntExternalFinancingProposal)
     */
    @Override
    public ExternalFinancingProposal createExternalFinancingProposal(final DTOIntExternalFinancingProposal dtoIn) {
        return txCreateExternalFinancingProposal.invoke(dtoIn);
    }

    /**
     * @see com.bbva.pzic.proposals.dao.IProposalsDAO#modifyExternalFinancingProposal(com.bbva.pzic.proposals.business.dto.DTOInputModifyExternalFinancingProposal)
     */
    @Override
    public void modifyExternalFinancingProposal(final DTOInputModifyExternalFinancingProposal dtoIn) {
        txModifyExternalFinancingProposal.invoke(dtoIn);
    }
}