package com.bbva.pzic.proposals.dao.impl;

import com.bbva.pzic.proposals.business.dto.DTOInputListProposals;
import com.bbva.pzic.proposals.canonic.ProposalData;
import com.bbva.pzic.proposals.dao.IListProposalsDAO;
import com.bbva.pzic.proposals.dao.mapper.IListProposalsDAOMapper;
import com.bbva.pzic.proposals.dao.model.listProposals.FormatProposalData;
import com.bbva.pzic.proposals.util.connection.rest.RestGetConnection;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created on 06/12/2016.
 *
 * @author Entelgy
 */
@Component
public class ListProposalsDAO extends RestGetConnection<FormatProposalData> implements IListProposalsDAO {

    private static final Log LOG = LogFactory.getLog(ListProposalsDAO.class);

    private static final String LIST_PROPOSALS_URL_PROPOSALS = "servicing.url.proposals.listProposals";

    @Autowired
    private IListProposalsDAOMapper proposalsDAOMapper;

    /**
     * @see IListProposalsDAO#listProposals(DTOInputListProposals)
     */
    @Override
    public ProposalData listProposals(DTOInputListProposals queryFilter) {
        LOG.info("... called method RestGetConnection.listProposals ...");
        FormatProposalData formatProposalData =
                connect(LIST_PROPOSALS_URL_PROPOSALS, proposalsDAOMapper.mapInput(queryFilter));
        return proposalsDAOMapper.mapOutput(formatProposalData);
    }

}
