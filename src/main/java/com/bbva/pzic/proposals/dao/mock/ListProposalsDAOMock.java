package com.bbva.pzic.proposals.dao.mock;

import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.jee.arq.spring.core.servicing.utils.Pagination;
import com.bbva.pzic.proposals.business.dto.DTOInputListProposals;
import com.bbva.pzic.proposals.canonic.Proposal;
import com.bbva.pzic.proposals.canonic.ProposalData;
import com.bbva.pzic.proposals.dao.IListProposalsDAO;
import com.bbva.pzic.proposals.dao.mapper.IListProposalsDAOMapper;
import com.bbva.pzic.proposals.facade.v01.ISrvProposalsV01;
import com.bbva.pzic.proposals.util.Errors;
import com.bbva.pzic.proposals.util.helper.ObjectMapperHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.cxf.helpers.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created on 06/12/2016.
 *
 * @author Entelgy
 */
@Primary
@Component
public class ListProposalsDAOMock implements IListProposalsDAO {

    private static final Log LOG = LogFactory.getLog(ListProposalsDAOMock.class);

    public static final String DOCUMENT_NUMBER_FOR_PARTIAL_LIST = "00000001";
    public static final String DOCUMENT_NUMBER_FOR_COMPLETE_LIST = "00000002";

    @Autowired
    private IListProposalsDAOMapper proposalsDAOMapper;

    @Autowired
    private ObjectMapperHelper mapper;

    /**
     * @see IListProposalsDAO#listProposals(DTOInputListProposals)
     */
    @Override
    public ProposalData listProposals(DTOInputListProposals queryFilter) {
        HashMap<String, String> inputParameters = proposalsDAOMapper.mapInput(queryFilter);
        final ProposalData proposalData = new ProposalData();
        if (DOCUMENT_NUMBER_FOR_PARTIAL_LIST.equals(inputParameters.get(ISrvProposalsV01.DOCUMENT_NUMBER))) {
            try {
                final List<Proposal> proposals = new ArrayList<Proposal>();
                proposals.add(buildProposal());
                proposalData.setData(proposals);
                proposalData.setPagination(buildPagination());
            } catch (IOException e) {
                LOG.error(String.format("... Error: %s ...", e.getMessage()));
                throw new BusinessServiceException(Errors.TECHNICAL_ERROR, e);
            }
        } else if (DOCUMENT_NUMBER_FOR_COMPLETE_LIST.equals(inputParameters.get(ISrvProposalsV01.DOCUMENT_NUMBER))) {
            try {
                final List<Proposal> proposals = new ArrayList<Proposal>();
                proposals.add(buildProposal());
                proposalData.setData(proposals);
            } catch (IOException e) {
                LOG.error(String.format("... Error: %s ...", e.getMessage()));
                throw new BusinessServiceException(Errors.TECHNICAL_ERROR, e);
            }
        }
        return proposalData;
    }

    private Pagination buildPagination() throws IOException {
        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(
                "com/bbva/pzic/proposals/dao/mock/Pagination.json");
        return mapper.readValue(IOUtils.readBytesFromStream(in), Pagination.class);
    }

    private Proposal buildProposal() throws IOException {
        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(
                "com/bbva/pzic/proposals/dao/mock/Proposal.json");
        return mapper.readValue(IOUtils.readBytesFromStream(in), Proposal.class);
    }

}
