package com.bbva.pzic.proposals.facade.v0.mapper.impl;

import com.bbva.pzic.proposals.business.dto.DTOInputModifyExternalFinancingProposal;
import com.bbva.pzic.proposals.business.dto.DTOIntExternalFinancingProposal;
import com.bbva.pzic.proposals.canonic.ExternalFinancingProposal;
import com.bbva.pzic.proposals.facade.v0.mapper.IModifyExternalFinancingProposalMapper;
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
@Mapper("modifyExternalFinancingProposalMapper")
public class ModifyExternalFinancingProposalMapper extends ConfigurableMapper implements IModifyExternalFinancingProposalMapper {

    @Autowired
    private EnumMapper mapper;

    @Override
    protected void configure(MapperFactory factory) {
        super.configure(factory);

        factory.classMap(ExternalFinancingProposal.class, DTOIntExternalFinancingProposal.class)
                .field("delivery.deliveryType.id", "deliveryTypeId")
                .field("delivery.email", "email")
                .field("status.id", "statusId")
                .register();
    }

    @Override
    public DTOInputModifyExternalFinancingProposal mapIn(final String externalFinancingProposalId,
                                                         final ExternalFinancingProposal externalFinancingProposal) {
        DTOIntExternalFinancingProposal payload = map(externalFinancingProposal, DTOIntExternalFinancingProposal.class);
        if (payload.getDeliveryTypeId() != null) {
            payload.setDeliveryTypeId(mapper.getBackendValue("externalFinancingProposals.delivery.deliveryType.id", payload.getDeliveryTypeId()));
        }
        if (payload.getStatusId() != null) {
            payload.setStatusId(mapper.getBackendValue("externalFinancingProposals.status.id", payload.getStatusId()));
        }

        DTOInputModifyExternalFinancingProposal dto = new DTOInputModifyExternalFinancingProposal();
        dto.setExternalFinancingProposalId(externalFinancingProposalId);
        dto.setExternalFinancingProposal(payload);
        return dto;
    }
}