package com.bbva.pzic.proposals.dao.tx.mapper.impl;

import com.bbva.pzic.proposals.business.dto.DTOInputModifyExternalFinancingProposal;
import com.bbva.pzic.proposals.dao.model.ugmp.FormatoUGMEGMP;
import com.bbva.pzic.proposals.dao.tx.mapper.ITxModifyExternalFinancingProposalMapper;
import com.bbva.pzic.proposals.util.mappers.EnumMapper;
import com.bbva.pzic.proposals.util.mappers.Mapper;
import com.bbva.pzic.proposals.util.orika.MapperFactory;
import com.bbva.pzic.proposals.util.orika.impl.ConfigurableMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created on 12/04/2017.
 *
 * @author Entelgy
 */
@Mapper("txModifyExternalFinancingProposalMapper")
public class TxModifyExternalFinancingProposalMapper extends ConfigurableMapper implements ITxModifyExternalFinancingProposalMapper {

    @Autowired
    private EnumMapper enumMapper;

    @Override
    protected void configure(MapperFactory factory) {
        super.configure(factory);

        factory.classMap(FormatoUGMEGMP.class, DTOInputModifyExternalFinancingProposal.class)
                .field("nrocont", "externalFinancingProposalId")
                .field("mailcon", "externalFinancingProposal.deliveryVirtualDestination")
                .register();
    }

    @Override
    public FormatoUGMEGMP mapIn(final DTOInputModifyExternalFinancingProposal dtoIn) {
        FormatoUGMEGMP format = map(dtoIn, FormatoUGMEGMP.class);
        format.setIndesta(enumMapper.getBackendValue("externalFinancingProposal.status.id", dtoIn.getExternalFinancingProposal().getStatusId()));
        format.setTipenvi(enumMapper.getBackendValue("externalFinancingProposal.delivery.deliveryType.id", dtoIn.getExternalFinancingProposal().getDeliveryTypeId()));
        return format;
    }
}