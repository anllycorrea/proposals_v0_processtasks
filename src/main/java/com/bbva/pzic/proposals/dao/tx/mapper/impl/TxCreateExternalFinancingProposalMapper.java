package com.bbva.pzic.proposals.dao.tx.mapper.impl;

import com.bbva.pzic.proposals.business.dto.DTOIntExternalFinancingProposal;
import com.bbva.pzic.proposals.canonic.ExternalFinancingProposal;
import com.bbva.pzic.proposals.dao.model.ugap.FormatoUGMEGAP;
import com.bbva.pzic.proposals.dao.model.ugap.FormatoUGMSGAP1;
import com.bbva.pzic.proposals.dao.tx.mapper.ITxCreateExternalFinancingProposalMapper;
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
@Mapper("txCreateExternalFinancingProposalMapper")
public class TxCreateExternalFinancingProposalMapper extends ConfigurableMapper
        implements
        ITxCreateExternalFinancingProposalMapper {

    @Autowired
    private EnumMapper enumMapper;

    @Override
    protected void configure(MapperFactory factory) {
        super.configure(factory);

        factory.classMap(FormatoUGMEGAP.class, DTOIntExternalFinancingProposal.class)
                .field("nrodocu", "documentNumber")
                .field("tarifa", "tariff.id")
                .field("moneda", "currency")
                .field("impfina", "initialAmount.amount")
                .field("diapago", "paymentDay")
                .field("mailcon", "deliveryVirtualDestination")
                .field("idtoken", "operation.id")
                .field("codtr", "operation.operationType.id")
                .field("codbien", "externalProduct.id")
                .field("impbien", "externalProduct.commercialValueAmount.amount")
                .field("codcnc", "thirdPartyProvider.externalSalesChannel.id")
                .field("codemp", "thirdPartyProvider.id")
                .register();
    }

    /**
     * @see ITxCreateExternalFinancingProposalMapper#mapIn(DTOIntExternalFinancingProposal)
     */
    @Override
    public FormatoUGMEGAP mapIn(DTOIntExternalFinancingProposal dtoIn) {
        FormatoUGMEGAP formatoUGMEGAP = map(dtoIn, FormatoUGMEGAP.class);

        if (dtoIn.getDocumentTypeId() != null) {
            formatoUGMEGAP.setTipdocu(enumMapper.getBackendValue("documentType.id",
                    dtoIn.getDocumentTypeId()));
        }
        if (dtoIn.getDeliveryTypeId() != null) {
            formatoUGMEGAP.setTipenvi(enumMapper.getBackendValue("externalFinancingProposals.delivery.type.id",
                    dtoIn.getDeliveryTypeId()));
        }

        return formatoUGMEGAP;
    }

    /**
     * @see ITxCreateExternalFinancingProposalMapper#mapOut(FormatoUGMSGAP1)
     */
    @Override
    public ExternalFinancingProposal mapOut(FormatoUGMSGAP1 formatoUGMSGAP1) {
        if (formatoUGMSGAP1 == null) {
            return null;
        }

        ExternalFinancingProposal externalFinancingProposal = new ExternalFinancingProposal();
        externalFinancingProposal.setId(formatoUGMSGAP1.getNrocont());
        return externalFinancingProposal;
    }
}