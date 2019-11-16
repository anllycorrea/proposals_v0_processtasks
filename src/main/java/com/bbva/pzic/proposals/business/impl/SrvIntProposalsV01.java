package com.bbva.pzic.proposals.business.impl;

import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.pzic.proposals.business.ISrvIntProposalsV01;
import com.bbva.pzic.proposals.business.dto.DTOInputListProposals;
import com.bbva.pzic.proposals.canonic.ProposalData;
import com.bbva.pzic.proposals.dao.IListProposalsDAO;
import com.bbva.pzic.proposals.util.Errors;
import com.bbva.pzic.routine.validator.Validator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 06/12/2016.
 *
 * @author Entelgy
 */
@Service
public class SrvIntProposalsV01 implements ISrvIntProposalsV01 {

    private static final Log LOG = LogFactory.getLog(SrvIntProposalsV01.class);

    @Autowired
    private IListProposalsDAO listProposalsDAO;

    @Autowired
    private Validator validator;

    /**
     * @see ISrvIntProposalsV01#listProposals(DTOInputListProposals)
     */
    @Override
    public ProposalData listProposals(final DTOInputListProposals queryFilter) {
        LOG.info("... called method SrvIntProposalsV01.listProposals ...");
        if (queryFilter.getCustomerId() == null
                && (queryFilter.getDocumentType() == null || queryFilter.getDocumentNumber() == null)) {
            throw new BusinessServiceException(Errors.PARAMETERS_MISSING);
        }
        validator.validate(queryFilter);

        return listProposalsDAO.listProposals(queryFilter);
    }
}
