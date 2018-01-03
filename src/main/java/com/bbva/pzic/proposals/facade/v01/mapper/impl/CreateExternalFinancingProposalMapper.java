package com.bbva.pzic.proposals.facade.v01.mapper.impl;

import com.bbva.pzic.proposals.business.dto.DTOIntExternalFinancingProposal;
import com.bbva.pzic.proposals.business.dto.DTOIntThirdPartyProvider;
import com.bbva.pzic.proposals.canonic.ExternalFinancingProposal;
import com.bbva.pzic.proposals.canonic.Holder;
import com.bbva.pzic.proposals.canonic.IdentityDocument;
import com.bbva.pzic.proposals.facade.v01.mapper.ICreateExternalFinancingProposalMapper;
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
@Mapper("createExternalFinancingProposalMapper")
public class CreateExternalFinancingProposalMapper extends ConfigurableMapper implements ICreateExternalFinancingProposalMapper {

    private static final int FIRST = 0;

    @Autowired
    private EnumMapper mapper;

    @Override
    protected void configure(MapperFactory factory) {
        super.configure(factory);

        factory.classMap(ExternalFinancingProposal.class, DTOIntExternalFinancingProposal.class)
                .field("currency", "currency")
                .field("paymentDay", "paymentDay")
                .field("billingDay", "billingDay")
                .field("initialAmount.amount", "initialAmount.amount")
                .field("initialAmount.currency", "initialAmount.currency")
                .field("tariff.id", "tariff.id")
                .field("delivery.email", "email")
                .field("externalProduct.id", "externalProduct.id")
                .field("externalProduct.commercialValue.amount", "externalProduct.commercialValue.amount")
                .field("externalProduct.commercialValue.currency", "externalProduct.commercialValue.currency")
                .field("operation.id", "operation.id")
                .field("operation.operationType.id", "operation.operationType.id")
                .field("thirdPartyProvider.id", "thirdPartyProvider.id")
                .field("thirdPartyProvider.externalSalesChannel.id", "thirdPartyProvider.externalSalesChannel.id")
                .field("branch.id", "branchId")
                .register();
    }

    /**
     * @see ICreateExternalFinancingProposalMapper#mapIn(String, com.bbva.pzic.proposals.canonic.ExternalFinancingProposal)
     */
    @Override
    public DTOIntExternalFinancingProposal mapIn(final String thirdPartyProviderUserId, final ExternalFinancingProposal externalFinancingProposal) {
        if (externalFinancingProposal == null) {
            return null;
        }

        DTOIntExternalFinancingProposal dtoIntExternalFinancingProposal = map(externalFinancingProposal, DTOIntExternalFinancingProposal.class);
        if (externalFinancingProposal.getDelivery() != null && externalFinancingProposal.getDelivery().getType() != null) {
            dtoIntExternalFinancingProposal.setDeliveryTypeId(mapper.getBackendValue("externalFinancingProposals.delivery.type.id", externalFinancingProposal.getDelivery().getType().getId()));
        }

        if (thirdPartyProviderUserId != null) {
            if (dtoIntExternalFinancingProposal.getThirdPartyProvider() == null) {
                dtoIntExternalFinancingProposal.setThirdPartyProvider(new DTOIntThirdPartyProvider());
            }
            dtoIntExternalFinancingProposal.getThirdPartyProvider().setUserId(thirdPartyProviderUserId);
        }

        if (hasIdentityDocument(externalFinancingProposal.getHolder())) {
            IdentityDocument identityDocument = externalFinancingProposal.getHolder().getIdentityDocuments().get(FIRST);
            mapInDocument(dtoIntExternalFinancingProposal, identityDocument);
        }

        return dtoIntExternalFinancingProposal;
    }

    private boolean hasIdentityDocument(Holder holder) {
        return holder != null && holder.getIdentityDocuments() != null
                && !holder.getIdentityDocuments().isEmpty() && holder.getIdentityDocuments().get(FIRST) != null;
    }

    private void mapInDocument(DTOIntExternalFinancingProposal dtoIntExternalFinancingProposal, IdentityDocument identityDocument) {
        if (identityDocument.getDocumentType() != null) {
            dtoIntExternalFinancingProposal.setDocumentTypeId(mapper.getBackendValue("documentType.id", identityDocument.getDocumentType().getId()));
        }
        dtoIntExternalFinancingProposal.setDocumentNumber(identityDocument.getDocumentNumber());
    }
}