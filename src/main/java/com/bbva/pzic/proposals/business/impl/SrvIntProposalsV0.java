package com.bbva.pzic.proposals.business.impl;

import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.pzic.proposals.business.ISrvIntProposalsV0;
import com.bbva.pzic.proposals.business.dto.DTOIntSimulatedProposal;
import com.bbva.pzic.proposals.business.dto.InputListProposals;
import com.bbva.pzic.proposals.business.dto.ValidationGroup;
import com.bbva.pzic.proposals.canonic.Proposal;
import com.bbva.pzic.proposals.canonic.SimulatedProposalsData;
import com.bbva.pzic.proposals.dao.IProposalsDAOV0;
import com.bbva.pzic.proposals.util.Errors;
import com.bbva.pzic.proposals.util.validation.Validator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<Proposal> listProposals(final InputListProposals inputListProposals) {
        LOG.info("... Invoking method SrvIntProposals.listProposals ...");
        LOG.info("... Validating listProposals input parameter ...");
        validator.validate(inputListProposals, ValidationGroup.ListProposalsV0.class);

        if (inputListProposals.getCustomerId() == null &&
                (inputListProposals.getDocumentTypeId() == null&& inputListProposals.getDocumentNumber() == null)) {
            throw new BusinessServiceException(Errors.MANDATORY_PARAMETERS_MISSING);
        } else if (inputListProposals.getCustomerId() == null && (inputListProposals.getDocumentTypeId() == null
                || inputListProposals.getDocumentNumber() == null)) {
            throw new BusinessServiceException(Errors.PARAMETERS_MISSING);
        }
        return proposalsDAOV0.listProposals(inputListProposals);
    }

    @Override
    public SimulatedProposalsData simulateProposals(final DTOIntSimulatedProposal simulatedProposal) {
        LOG.info("... Invoking method SrvIntProposals.simulateProposals ...");
        LOG.info("... Validating simulateProposals input parameter ...");
        validator.validate(simulatedProposal, ValidationGroup.SimulateProposals.class);
        return proposalsDAOV0.simulateProposals(simulatedProposal);
    }
}