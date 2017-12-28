package com.bbva.pzic.proposals.business.impl;

import com.bbva.pzic.proposals.business.ISrvIntProposalsV0;
import com.bbva.pzic.proposals.business.dto.DTOIntProposals;
import com.bbva.pzic.proposals.business.dto.InputListProposals;
import com.bbva.pzic.proposals.business.dto.ValidationGroup;
import com.bbva.pzic.proposals.dao.IProposalsDAOV0;
import com.bbva.pzic.proposals.util.validation.Validator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 28/12/2017.
 *
 * @author Entelgy
 */
@Service
public class SrvIntProposalsV0 implements ISrvIntProposalsV0 {

    private static final Log LOG = LogFactory.getLog(SrvIntProposalsV0.class);
    @Autowired
    private IProposalsDAOV0 proposalsDAOV0;
    @Autowired
    private Validator validator;

    @Override
    public DTOIntProposals listProposals(final InputListProposals listProposals) {
        LOG.info("... Invoking method SrvIntProposals.listProposals ...");
        LOG.info("... Validating listProposals input parameter ...");
        validator.validate(listProposals, ValidationGroup.ListProposalsV0.class);
        return proposalsDAOV0.listProposals(listProposals);
    }
}