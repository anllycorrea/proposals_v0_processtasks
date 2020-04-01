package com.bbva.pzic.proposals.dao.tx;

import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.pzic.proposals.business.dto.DTOInputListExternalFinancingProposals;
import com.bbva.pzic.proposals.business.dto.DTOOutExternalFinancingProposalData;
import com.bbva.pzic.proposals.dao.model.uglp.*;
import com.bbva.pzic.proposals.dao.tx.mapper.ITxListExternalFinancingProposalsMapper;
import com.bbva.pzic.proposals.util.tx.Tx;
import com.bbva.pzic.routine.commons.utils.host.templates.impl.DoubleOutputFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

/**
 * Created on 12/04/2017.
 *
 * @author Entelgy
 */
@Tx
public class TxListExternalFinancingProposals extends DoubleOutputFormat<DTOInputListExternalFinancingProposals, FormatoUGMEGLP, DTOOutExternalFinancingProposalData, FormatoUGMSGLP1, FormatoUGMSGLP2> {

    @Resource(name = "txListExternalFinancingProposalsMapper")
    private ITxListExternalFinancingProposalsMapper proposalsMapper;

    @Resource(name = "transaccionUglp")
    private transient InvocadorTransaccion<PeticionTransaccionUglp, RespuestaTransaccionUglp> transaction;

    @Autowired
    public TxListExternalFinancingProposals(@Qualifier("transaccionUglp") InvocadorTransaccion<PeticionTransaccionUglp, RespuestaTransaccionUglp> transaction) {
        super(transaction, PeticionTransaccionUglp::new, DTOOutExternalFinancingProposalData::new, FormatoUGMSGLP1.class, FormatoUGMSGLP2.class);
    }

    @Override
    protected FormatoUGMEGLP mapInput(DTOInputListExternalFinancingProposals dtoInputListExternalFinancingProposals) {
        return proposalsMapper.mapIn(dtoInputListExternalFinancingProposals);
    }

    @Override
    protected DTOOutExternalFinancingProposalData mapFirstOutputFormat(FormatoUGMSGLP1 formatoUGMSGLP1, DTOInputListExternalFinancingProposals dtoInputListExternalFinancingProposals, DTOOutExternalFinancingProposalData dtoOutExternalFinancingProposalData) {
        return proposalsMapper.mapOut1(formatoUGMSGLP1, dtoOutExternalFinancingProposalData);
    }

    @Override
    protected DTOOutExternalFinancingProposalData mapSecondOutputFormat(FormatoUGMSGLP2 formatoUGMSGLP2, DTOInputListExternalFinancingProposals dtoInputListExternalFinancingProposals, DTOOutExternalFinancingProposalData dtoOutExternalFinancingProposalData) {
        return proposalsMapper.mapOut2(formatoUGMSGLP2, dtoOutExternalFinancingProposalData);
    }
}