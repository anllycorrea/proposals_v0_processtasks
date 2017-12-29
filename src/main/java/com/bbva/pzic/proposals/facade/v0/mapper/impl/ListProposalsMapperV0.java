package com.bbva.pzic.proposals.facade.v0.mapper.impl;

import com.bbva.pzic.proposals.business.dto.DTOIntProposals;
import com.bbva.pzic.proposals.business.dto.InputListProposals;
import com.bbva.pzic.proposals.canonic.Proposals;
import com.bbva.pzic.proposals.facade.v0.mapper.IListProposalsMapperV0;
import com.bbva.pzic.proposals.util.mappers.EnumMapper;
import com.bbva.pzic.proposals.util.mappers.Mapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created on 28/12/2017.
 * 
 * @author Entelgy
 */
@Mapper
public class ListProposalsMapperV0 implements IListProposalsMapperV0 {

	private static final Log LOG = LogFactory.getLog(ListProposalsMapperV0.class);

    @Autowired
    private EnumMapper enumMapper;

    @Override
    public InputListProposals mapIn(
            final String participantIdentityDocumentDocumentTypeId,
            final String participantIdentityDocumentDocumentNumber,
            final String customerId) {
        LOG.info("... called method ListProposalsMapper.mapIn ...");
        InputListProposals inputListProposals = new InputListProposals();
        inputListProposals
                .setDocumentTypeId(
                        enumMapper.getBackendValue("documentType.id",participantIdentityDocumentDocumentTypeId) );
        inputListProposals
                .setDocumentNumber(participantIdentityDocumentDocumentNumber);
        inputListProposals.setCustomerId(customerId);
        return inputListProposals;
    }

    @Override
    public Proposals mapOut(final DTOIntProposals dtoIntProposals) {
        LOG.info("... called method ListProposalsMapper.mapOut ...");
        if (dtoIntProposals.getData() == null) {
            return null;
        }
        Proposals proposals = new Proposals();
        proposals.setData(dtoIntProposals.getData());
        return proposals;
    }
}