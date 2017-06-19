package com.bbva.pzic.proposals.dao.tx.mapper.impl;

import com.bbva.pzic.proposals.business.dto.DTOIntExternalFinancingProposal;
import com.bbva.pzic.proposals.canonic.ExternalFinancingProposal;
import com.bbva.pzic.proposals.dao.model.ugap.FormatoUGMEGAP;
import com.bbva.pzic.proposals.dao.model.ugap.FormatoUGMSGAP1;
import com.bbva.pzic.proposals.dao.tx.mapper.ITxCreateExternalFinancingProposalMapper;
import com.bbva.pzic.proposals.util.mappers.Mapper;
import com.bbva.pzic.proposals.util.orika.MapperFactory;
import com.bbva.pzic.proposals.util.orika.impl.ConfigurableMapper;

/**
 * Created on 12/04/2017.
 *
 * @author Entelgy
 */
@Mapper("txCreateExternalFinancingProposalMapper")
public class TxCreateExternalFinancingProposalMapper extends ConfigurableMapper implements ITxCreateExternalFinancingProposalMapper {

    @Override
    protected void configure(MapperFactory factory) {
        super.configure(factory);

        factory.classMap(FormatoUGMEGAP.class, DTOIntExternalFinancingProposal.class)
                .field("moneda", "currency")
                .field("diapago", "paymentDay")
                .field("diafact", "billingDay")
                .field("impfina", "initialAmount.amount")
                .field("tarifa", "tariff.id")
                .field("tipenvi", "deliveryTypeId")
                .field("mailcon", "email")
                .field("codbien", "externalProduct.id")
                .field("impbien", "externalProduct.commercialValue.amount")
                .field("tipdocu", "documentTypeId")
                .field("nrodocu", "documentNumber")
                .field("idtoken", "operation.id")
                .field("codtr", "operation.operationType.id")
                .field("codemp", "thirdPartyProvider.id")
                .field("codcnc", "thirdPartyProvider.externalSalesChannel.id")
                .field("cocliex", "thirdPartyProvider.userId")
                .field("codofic", "branchId")
                .register();
    }

    /**
     * @see ITxCreateExternalFinancingProposalMapper#mapIn(DTOIntExternalFinancingProposal)
     */
    @Override
    public FormatoUGMEGAP mapIn(DTOIntExternalFinancingProposal dtoIn) {
        return map(dtoIn, FormatoUGMEGAP.class);
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