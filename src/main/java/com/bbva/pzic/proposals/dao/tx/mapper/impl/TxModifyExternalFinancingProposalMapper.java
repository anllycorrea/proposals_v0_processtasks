package com.bbva.pzic.proposals.dao.tx.mapper.impl;

import com.bbva.pzic.proposals.business.dto.DTOInputModifyExternalFinancingProposal;
import com.bbva.pzic.proposals.dao.model.ugmp.FormatoUGMEGMP;
import com.bbva.pzic.proposals.dao.tx.mapper.ITxModifyExternalFinancingProposalMapper;
import com.bbva.pzic.proposals.util.mappers.Mapper;
import com.bbva.pzic.proposals.util.orika.MapperFactory;
import com.bbva.pzic.proposals.util.orika.impl.ConfigurableMapper;

/**
 * Created on 12/04/2017.
 *
 * @author Entelgy
 */
@Mapper("txModifyExternalFinancingProposalMapper")
public class TxModifyExternalFinancingProposalMapper extends ConfigurableMapper implements ITxModifyExternalFinancingProposalMapper {

    @Override
    protected void configure(MapperFactory factory) {
        super.configure(factory);

        factory.classMap(FormatoUGMEGMP.class, DTOInputModifyExternalFinancingProposal.class)
                .field("nrocont", "externalFinancingProposalId")
                .field("tipenvi", "externalFinancingProposal.deliveryTypeId")
                .field("mailcon", "externalFinancingProposal.email")
                .field("indesta", "externalFinancingProposal.statusId")
                .register();
    }

    @Override
    public FormatoUGMEGMP mapIn(final DTOInputModifyExternalFinancingProposal dtoIn) {
        return map(dtoIn, FormatoUGMEGMP.class);
    }
}