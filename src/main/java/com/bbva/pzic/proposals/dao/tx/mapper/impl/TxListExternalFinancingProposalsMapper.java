package com.bbva.pzic.proposals.dao.tx.mapper.impl;

import com.bbva.pzic.proposals.business.dto.DTOInputListExternalFinancingProposals;
import com.bbva.pzic.proposals.business.dto.DTOIntPagination;
import com.bbva.pzic.proposals.business.dto.DTOOutExternalFinancingProposalData;
import com.bbva.pzic.proposals.canonic.ExternalFinancingProposal;
import com.bbva.pzic.proposals.dao.model.uglp.FormatoUGMEGLP;
import com.bbva.pzic.proposals.dao.model.uglp.FormatoUGMSGLP1;
import com.bbva.pzic.proposals.dao.model.uglp.FormatoUGMSGLP2;
import com.bbva.pzic.proposals.dao.tx.mapper.ITxListExternalFinancingProposalsMapper;
import com.bbva.pzic.proposals.util.mappers.EnumMapper;
import com.bbva.pzic.proposals.util.mappers.Mapper;
import com.bbva.pzic.proposals.util.orika.MapperFactory;
import com.bbva.pzic.proposals.util.orika.converter.builtin.DateToStringConverter;
import com.bbva.pzic.proposals.util.orika.converter.builtin.LongToIntegerConverter;
import com.bbva.pzic.proposals.util.orika.impl.ConfigurableMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

/**
 * Created on 12/04/2017.
 *
 * @author Entelgy
 */
@Mapper("txListExternalFinancingProposalsMapper")
public class TxListExternalFinancingProposalsMapper extends ConfigurableMapper implements ITxListExternalFinancingProposalsMapper {

    private static final Log LOG = LogFactory.getLog(TxListExternalFinancingProposalsMapper.class);

    @Autowired
    private EnumMapper enumMapper;

    @Override
    protected void configure(MapperFactory factory) {
        super.configure(factory);

        factory.getConverterFactory().registerConverter(new LongToIntegerConverter());
        factory.getConverterFactory().registerConverter(new DateToStringConverter(DateToStringConverter.DateFormatsBBVA.SHORT_FORMAT));

        factory.classMap(FormatoUGMEGLP.class, DTOInputListExternalFinancingProposals.class)
                .field("codemp", "thirdPartyProviderId")
                .field("tipdocu", "holderIdentityDocumentsDocumentTypeId")
                .field("nrodocu", "holderIdentityDocumentsDocumentNumber")
                .field("fecrdes", "fromRequestDate")
                .field("fecrhas", "toRequestDate")
                .field("idpagin", "paginationKey")
                .field("tampagi", "pageSize")
                .register();

        factory.classMap(ExternalFinancingProposal.class, FormatoUGMSGLP1.class)
                .field("id", "nrocont")
                .field("requestDate", "fesoli")
                .field("openingDate", "fedesem")
                .field("currency", "moneda")
                .field("initialFee.amount", "cuoini")
                .field("initialFee.currency", "moneda")
                .field("initialAmount.amount", "impfina")
                .field("initialAmount.currency", "moneda")
                .field("tariff.id", "tarifa")
                .field("relatedProduct.relatedProductType.id", "codseg")
                .field("relatedProduct.relatedProductType.name", "descseg")
                .field("relatedProduct.percentage", "tasaseg")
                .field("delivery.deliveryType.id", "tipenvi")
                .field("delivery.deliveryType.name", "desenv")
                .field("delivery.virtualDestination", "mailcon")
                .field("externalProduct.id", "codbien")
                .field("externalProduct.commercialValueAmount.amount", "impbien")
                .field("externalProduct.commercialValueAmount.currency", "moneda")
                .field("holder.name", "nombr")
                .field("holder.lastName", "apepat")
                .field("holder.mohterLastName", "apemat")
                .field("operation.id", "idtoken")
                .field("status.id", "indesta")
                .field("status.name", "desesta")
                .register();
    }

    /**
     * @see com.bbva.pzic.proposals.dao.tx.mapper.ITxListExternalFinancingProposalsMapper#mapIn(com.bbva.pzic.proposals.business.dto.DTOInputListExternalFinancingProposals)
     */
    @Override
    public FormatoUGMEGLP mapIn(DTOInputListExternalFinancingProposals dtoIn) {
        return map(dtoIn, FormatoUGMEGLP.class);
    }

    /**
     * @see com.bbva.pzic.proposals.dao.tx.mapper.ITxListExternalFinancingProposalsMapper#mapOut1(com.bbva.pzic.proposals.dao.model.uglp.FormatoUGMSGLP1, com.bbva.pzic.proposals.business.dto.DTOOutExternalFinancingProposalData)
     */
    @Override
    public DTOOutExternalFinancingProposalData mapOut1(FormatoUGMSGLP1 formatOutput, DTOOutExternalFinancingProposalData dtoOut) {
        LOG.info("... call TxListExternalFinancingProposalsMapper.mapOut1...");
        DTOOutExternalFinancingProposalData proposalData = dtoOut;
        if (proposalData == null) {
            proposalData = new DTOOutExternalFinancingProposalData();
        }
        if (proposalData.getData() == null) {
            proposalData.setData(new ArrayList<ExternalFinancingProposal>());
        }
        ExternalFinancingProposal proposal = map(formatOutput, ExternalFinancingProposal.class);
        if (formatOutput.getTipenvi() != null) {
            proposal.getDelivery().getDeliveryType().setId(enumMapper.getEnumValue("externalFinancingProposals.delivery.deliveryType.id", formatOutput.getTipenvi()));
        }
        if (formatOutput.getIndesta() != null) {
            proposal.getStatus().setId(enumMapper.getEnumValue("externalFinancingProposals.status.id", formatOutput.getIndesta()));
        }
        proposalData.getData().add(proposal);
        return proposalData;
    }

    /**
     * @see com.bbva.pzic.proposals.dao.tx.mapper.ITxListExternalFinancingProposalsMapper#mapOut2(com.bbva.pzic.proposals.dao.model.uglp.FormatoUGMSGLP2, com.bbva.pzic.proposals.business.dto.DTOOutExternalFinancingProposalData)
     */
    @Override
    public DTOOutExternalFinancingProposalData mapOut2(FormatoUGMSGLP2 formatOutput, DTOOutExternalFinancingProposalData dtoOut) {
        LOG.info("... call TxListExternalFinancingProposalsMapper.mapOut2...");
        DTOOutExternalFinancingProposalData proposalData = dtoOut;
        if (proposalData == null) {
            proposalData = new DTOOutExternalFinancingProposalData();
        }
        DTOIntPagination pagination = null;
        if (formatOutput.getIdpagin() != null || formatOutput.getTampagi() != null) {
            pagination = new DTOIntPagination();
            pagination.setPaginationKey(formatOutput.getIdpagin());
            if (formatOutput.getTampagi() != null) {
                pagination.setPageSize(formatOutput.getTampagi().longValue());
            }
        }
        proposalData.setPagination(pagination);
        return proposalData;
    }
}