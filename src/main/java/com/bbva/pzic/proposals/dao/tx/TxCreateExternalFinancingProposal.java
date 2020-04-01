package com.bbva.pzic.proposals.dao.tx;

import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.pzic.proposals.business.dto.DTOIntExternalFinancingProposal;
import com.bbva.pzic.proposals.canonic.ExternalFinancingProposal;
import com.bbva.pzic.proposals.dao.model.ugap.FormatoUGMEGAP;
import com.bbva.pzic.proposals.dao.model.ugap.FormatoUGMSGAP1;
import com.bbva.pzic.proposals.dao.model.ugap.PeticionTransaccionUgap;
import com.bbva.pzic.proposals.dao.model.ugap.RespuestaTransaccionUgap;
import com.bbva.pzic.proposals.dao.tx.mapper.ITxCreateExternalFinancingProposalMapper;
import com.bbva.pzic.proposals.util.tx.Tx;
import com.bbva.pzic.routine.commons.utils.host.templates.impl.SingleOutputFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

/**
 * Created on 12/04/2017.
 *
 * @author Entelgy
 */
@Tx
public class TxCreateExternalFinancingProposal extends SingleOutputFormat<DTOIntExternalFinancingProposal, FormatoUGMEGAP, ExternalFinancingProposal, FormatoUGMSGAP1> {

    @Resource(name = "txCreateExternalFinancingProposalMapper")
    private ITxCreateExternalFinancingProposalMapper txCreateExternalFinancingProposalMapper;

    @Autowired
    public TxCreateExternalFinancingProposal(@Qualifier("transaccionUgap") InvocadorTransaccion<PeticionTransaccionUgap, RespuestaTransaccionUgap> transaction) {
        super(transaction, PeticionTransaccionUgap::new, ExternalFinancingProposal::new, FormatoUGMSGAP1.class);
    }

    @Override
    protected FormatoUGMEGAP mapInput(DTOIntExternalFinancingProposal dtoIntExternalFinancingProposal) {
        return txCreateExternalFinancingProposalMapper.mapIn(dtoIntExternalFinancingProposal);
    }

    @Override
    protected ExternalFinancingProposal mapFirstOutputFormat(FormatoUGMSGAP1 formatoUGMSGAP1, DTOIntExternalFinancingProposal dtoIntExternalFinancingProposal, ExternalFinancingProposal externalFinancingProposal) {
        return txCreateExternalFinancingProposalMapper.mapOut(formatoUGMSGAP1);
    }
}