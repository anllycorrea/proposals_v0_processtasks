package com.bbva.pzic.proposals.dao.tx.mapper.impl;

import com.bbva.pzic.proposals.business.dto.InputListProposals;
import com.bbva.pzic.proposals.canonic.Proposal;
import com.bbva.pzic.proposals.dao.model.hyt6.FormatoHYMR601;
import com.bbva.pzic.proposals.dao.model.hyt6.FormatoHYMR602;
import com.bbva.pzic.proposals.dao.tx.mapper.ITxListProposalsMapperV0;
import com.bbva.pzic.proposals.util.mappers.EnumMapper;
import com.bbva.pzic.proposals.util.mappers.Mapper;
import com.bbva.pzic.proposals.util.orika.MapperFactory;
import com.bbva.pzic.proposals.util.orika.impl.ConfigurableMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created on 28/12/2017.
 *
 * @author Entelgy
 */
@Mapper("txListProposalsMapperV0")
public class TxListProposalsMapperV0 extends ConfigurableMapper implements ITxListProposalsMapperV0 {

    @Autowired
    private EnumMapper enumMapper;

    @Override
    protected void configure(MapperFactory factory) {
        super.configure(factory);

        factory.classMap(InputListProposals.class, FormatoHYMR601.class)
                .field("documentTypeId", "tipo")
                .field("documentNumber", "numero")
                .field("customerId", "codcent")
                .register();

        factory.classMap(FormatoHYMR602.class, Proposal.class)
                .field("id", "id")
                .field("tipplaz", "term.frequency")
                .field("plazo", "term.value")
                .field("tippro", "product.productClassification.id")
                .field("montprd", "grantedAmount.value")
                .field("moneda", "grantedAmount.currency")
                .field("cuoprd", "installmentPayment.amount")
                .field("moneda", "installmentPayment.currency")
                .field("tea", "interestAnnualRate")
                .register();

    }

    @Override
    public FormatoHYMR601 mapIn(final InputListProposals listProposals) {
        return map(listProposals, FormatoHYMR601.class);
    }

    @Override
    public List<Proposal> mapOut(final FormatoHYMR602 formatOut, final List<Proposal> proposal) {
        Proposal data = map(formatOut, Proposal.class);
        if (formatOut.getTipplaz() != null) {
            data.getTerm().setFrequency(
                    enumMapper.getEnumValue("conditions.period.id", formatOut.getTipplaz()));
        }
        proposal.add(data);
        return proposal;
    }
}
