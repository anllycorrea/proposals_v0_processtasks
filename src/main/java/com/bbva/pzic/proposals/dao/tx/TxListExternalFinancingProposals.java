package com.bbva.pzic.proposals.dao.tx;

import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.pzic.proposals.business.dto.DTOInputListExternalFinancingProposals;
import com.bbva.pzic.proposals.business.dto.DTOOutExternalFinancingProposalData;
import com.bbva.pzic.proposals.dao.model.uglp.*;
import com.bbva.pzic.proposals.dao.tx.mapper.ITxListExternalFinancingProposalsMapper;
import com.bbva.pzic.proposals.util.tx.AbstractDoubleTransaction;
import com.bbva.pzic.proposals.util.tx.Tx;

import javax.annotation.Resource;

/**
 * Created on 12/04/2017.
 *
 * @author Entelgy
 */
@Tx
public class TxListExternalFinancingProposals extends AbstractDoubleTransaction<DTOInputListExternalFinancingProposals, FormatoUGMEGLP, DTOOutExternalFinancingProposalData, FormatoUGMSGLP1, FormatoUGMSGLP2> {

    @Resource(name = "txListExternalFinancingProposalsMapper")
    private ITxListExternalFinancingProposalsMapper proposalsMapper;

    @Resource(name = "transaccionUglp")
    private transient InvocadorTransaccion<PeticionTransaccionUglp, RespuestaTransaccionUglp> transaction;


    @Override
    protected FormatoUGMEGLP mapDtoInToRequestFormat(DTOInputListExternalFinancingProposals dtoIn) {
        return proposalsMapper.mapIn(dtoIn);
    }

    @Override
    protected DTOOutExternalFinancingProposalData mapResponseFormatToDtoOut(FormatoUGMSGLP1 formatOutput, DTOInputListExternalFinancingProposals dtoIn, DTOOutExternalFinancingProposalData dtoOut) {
        return proposalsMapper.mapOut1(formatOutput, dtoOut);
    }

    @Override
    protected DTOOutExternalFinancingProposalData mapResponseFormatToDtoOut2(FormatoUGMSGLP2 formatOutput, DTOInputListExternalFinancingProposals dtoIn, DTOOutExternalFinancingProposalData dtoOut) {
        return proposalsMapper.mapOut2(formatOutput, dtoOut);
    }

    @Override
    protected InvocadorTransaccion<?, ?> getTransaction() {
        return transaction;
    }
}