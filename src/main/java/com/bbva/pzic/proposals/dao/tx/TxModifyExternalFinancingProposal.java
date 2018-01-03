package com.bbva.pzic.proposals.dao.tx;

import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.pzic.proposals.business.dto.DTOInputModifyExternalFinancingProposal;
import com.bbva.pzic.proposals.dao.model.ugmp.FormatoUGMEGMP;
import com.bbva.pzic.proposals.dao.model.ugmp.PeticionTransaccionUgmp;
import com.bbva.pzic.proposals.dao.model.ugmp.RespuestaTransaccionUgmp;
import com.bbva.pzic.proposals.dao.tx.mapper.ITxModifyExternalFinancingProposalMapper;
import com.bbva.pzic.proposals.util.tx.AbstractSimpleTransaction;
import com.bbva.pzic.proposals.util.tx.IFormatNotApply;
import com.bbva.pzic.proposals.util.tx.Tx;

import javax.annotation.Resource;

/**
 * Created on 12/04/2017.
 *
 * @author Entelgy
 */
@Tx("txModifyExternalFinancingProposal")
public class TxModifyExternalFinancingProposal extends AbstractSimpleTransaction<DTOInputModifyExternalFinancingProposal, FormatoUGMEGMP, DTOInputModifyExternalFinancingProposal, IFormatNotApply> {

    @Resource(name = "txModifyExternalFinancingProposalMapper")
    private ITxModifyExternalFinancingProposalMapper mapper;

    @Resource(name = "transaccionUgmp")
    private InvocadorTransaccion<PeticionTransaccionUgmp, RespuestaTransaccionUgmp> transaction;

    @Override
    protected FormatoUGMEGMP mapDtoInToRequestFormat(final DTOInputModifyExternalFinancingProposal dtoIn) {
        return mapper.mapIn(dtoIn);
    }

    @Override
    protected DTOInputModifyExternalFinancingProposal mapResponseFormatToDtoOut(IFormatNotApply formatOutput, DTOInputModifyExternalFinancingProposal dtoIn) {
        return null;
    }

    @Override
    protected InvocadorTransaccion<?, ?> getTransaction() {
        return transaction;
    }
}