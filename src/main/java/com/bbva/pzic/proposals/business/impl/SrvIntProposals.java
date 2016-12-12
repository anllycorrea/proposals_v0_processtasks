package com.bbva.pzic.proposals.business.impl;

import com.bbva.pzic.proposals.business.ISrvIntProposals;
import com.bbva.pzic.proposals.business.dto.DTOInputListProposals;
import com.bbva.pzic.proposals.canonic.ProposalData;
import com.bbva.pzic.proposals.dao.IListProposalsDAO;
import com.bbva.pzic.proposals.util.validation.Validator;
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
public class SrvIntProposals implements ISrvIntProposals {

    private static final Log LOG = LogFactory.getLog(SrvIntProposals.class);

    @Autowired
    private IListProposalsDAO listProposalsDAO;

    @Autowired
    private Validator validator;

    /**
     * @see ISrvIntProposals#listProposals(DTOInputListProposals)
     */
    @Override
    public ProposalData listProposals(DTOInputListProposals queryFilter) {
        LOG.info("... called method SrvIntProposals.listProposals ...");
        LOG.info("... validating listProposals input parameters ...");
        validator.validate(queryFilter);
        return listProposalsDAO.listProposals(queryFilter);
    }

}
