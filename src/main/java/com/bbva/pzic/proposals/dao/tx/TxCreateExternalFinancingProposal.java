package com.bbva.pzic.proposals.dao.tx;

import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.pzic.proposals.business.dto.DTOIntExternalFinancingProposal;
import com.bbva.pzic.proposals.canonic.ExternalFinancingProposal;
import com.bbva.pzic.proposals.dao.model.ugap.FormatoUGMEGAP;
import com.bbva.pzic.proposals.dao.model.ugap.FormatoUGMSGAP1;
import com.bbva.pzic.proposals.dao.model.ugap.PeticionTransaccionUgap;
import com.bbva.pzic.proposals.dao.model.ugap.RespuestaTransaccionUgap;
import com.bbva.pzic.proposals.dao.tx.mapper.ITxCreateExternalFinancingProposalMapper;
import com.bbva.pzic.proposals.util.tx.AbstractSimpleTransaction;
import com.bbva.pzic.proposals.util.tx.Tx;

import javax.annotation.Resource;

/**
 * Created on 12/04/2017.
 *
 * @author Entelgy
 */
@Tx
public class TxCreateExternalFinancingProposal extends AbstractSimpleTransaction<DTOIntExternalFinancingProposal, FormatoUGMEGAP, ExternalFinancingProposal, FormatoUGMSGAP1> {

    @Resource(name = "txCreateExternalFinancingProposalMapper")
    private ITxCreateExternalFinancingProposalMapper txCreateExternalFinancingProposalMapper;

    @Resource(name = "transaccionUgap")
    private transient InvocadorTransaccion<PeticionTransaccionUgap, RespuestaTransaccionUgap> transaction;

    @Override
    protected FormatoUGMEGAP mapDtoInToRequestFormat(DTOIntExternalFinancingProposal dtoIn) {
        return txCreateExternalFinancingProposalMapper.mapIn(dtoIn);
    }

    @Override
    protected ExternalFinancingProposal mapResponseFormatToDtoOut(FormatoUGMSGAP1 formatOutput, DTOIntExternalFinancingProposal dtoIn) {
        return txCreateExternalFinancingProposalMapper.mapOut(formatOutput);
    }

    @Override
    protected InvocadorTransaccion<?, ?> getTransaction() {
        return transaction;
    }
}