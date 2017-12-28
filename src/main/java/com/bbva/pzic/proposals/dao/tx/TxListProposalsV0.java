package com.bbva.pzic.proposals.dao.tx;

import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.pzic.proposals.business.dto.InputListProposals;
import com.bbva.pzic.proposals.canonic.Proposals;
import com.bbva.pzic.proposals.dao.model.hyt6.FormatoHYMR601;
import com.bbva.pzic.proposals.dao.model.hyt6.FormatoHYMR602;
import com.bbva.pzic.proposals.dao.model.hyt6.PeticionTransaccionHyt6;
import com.bbva.pzic.proposals.dao.model.hyt6.RespuestaTransaccionHyt6;
import com.bbva.pzic.proposals.dao.tx.mapper.ITxListProposalsMapperV0;
import com.bbva.pzic.proposals.util.tx.AbstractSimpleListTransaction;
import com.bbva.pzic.proposals.util.tx.Tx;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * Created on 28/12/2017.
 *
 * @author Entelgy
 */
@Tx
public class TxListProposalsV0 extends AbstractSimpleListTransaction<InputListProposals, FormatoHYMR601, Proposals, FormatoHYMR602> {

    @Autowired
    private ITxListProposalsMapperV0 txListProposalsMapper;

    @Resource(name = "transaccionHyt6")
    private transient InvocadorTransaccion<PeticionTransaccionHyt6, RespuestaTransaccionHyt6> transaccion;

    @Override
    protected FormatoHYMR601 mapDtoInToRequestFormat(InputListProposals dtoIn) {
        return txListProposalsMapper.mapIn(dtoIn);
    }

    @Override
    protected Proposals mapResponseFormatToDtoOut(FormatoHYMR602 formatOutput, InputListProposals dtoIn, Proposals dtoOut) {
        return txListProposalsMapper.mapOut(formatOutput, dtoOut);
    }

    @Override
    protected InvocadorTransaccion<?, ?> getTransaction() {
        return transaccion;
    }
}