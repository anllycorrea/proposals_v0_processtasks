package com.bbva.pzic.proposals.dao.tx;

import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.pzic.proposals.business.dto.DTOInputModifyExternalFinancingProposal;
import com.bbva.pzic.proposals.dao.model.ugmp.FormatoUGMEGMP;
import com.bbva.pzic.proposals.dao.model.ugmp.PeticionTransaccionUgmp;
import com.bbva.pzic.proposals.dao.model.ugmp.RespuestaTransaccionUgmp;
import com.bbva.pzic.proposals.dao.tx.mapper.ITxModifyExternalFinancingProposalMapper;
import com.bbva.pzic.proposals.util.tx.IFormatNotApply;
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
@Tx("txModifyExternalFinancingProposal")
public class TxModifyExternalFinancingProposal extends SingleOutputFormat<DTOInputModifyExternalFinancingProposal, FormatoUGMEGMP, DTOInputModifyExternalFinancingProposal, IFormatNotApply> {

    @Resource(name = "txModifyExternalFinancingProposalMapper")
    private ITxModifyExternalFinancingProposalMapper mapper;

    @Autowired
    public TxModifyExternalFinancingProposal(@Qualifier("transaccionUgmp") InvocadorTransaccion<PeticionTransaccionUgmp, RespuestaTransaccionUgmp> transaction) {
        super(transaction, PeticionTransaccionUgmp::new, DTOInputModifyExternalFinancingProposal::new, IFormatNotApply.class);
    }

    @Override
    protected FormatoUGMEGMP mapInput(DTOInputModifyExternalFinancingProposal dtoInputModifyExternalFinancingProposal) {
        return mapper.mapIn(dtoInputModifyExternalFinancingProposal);
    }

    @Override
    protected DTOInputModifyExternalFinancingProposal mapFirstOutputFormat(IFormatNotApply iFormatNotApply, DTOInputModifyExternalFinancingProposal dtoInputModifyExternalFinancingProposal, DTOInputModifyExternalFinancingProposal dtoInputModifyExternalFinancingProposal2) {
        return null;
    }
}