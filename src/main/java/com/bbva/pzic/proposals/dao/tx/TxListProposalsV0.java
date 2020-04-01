package com.bbva.pzic.proposals.dao.tx;

import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.pzic.proposals.business.dto.InputListProposals;
import com.bbva.pzic.proposals.canonic.Proposal;
import com.bbva.pzic.proposals.dao.model.hyt6.FormatoHYMR601;
import com.bbva.pzic.proposals.dao.model.hyt6.FormatoHYMR602;
import com.bbva.pzic.proposals.dao.model.hyt6.PeticionTransaccionHyt6;
import com.bbva.pzic.proposals.dao.model.hyt6.RespuestaTransaccionHyt6;
import com.bbva.pzic.proposals.dao.tx.mapper.ITxListProposalsMapperV0;
import com.bbva.pzic.proposals.util.tx.Tx;
import com.bbva.pzic.routine.commons.utils.host.templates.impl.SingleOutputFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 28/12/2017.
 *
 * @author Entelgy
 */
@Tx
public class TxListProposalsV0 extends SingleOutputFormat<InputListProposals, FormatoHYMR601, List<Proposal>, FormatoHYMR602> {

    @Resource(name = "txListProposalsMapperV0")
    private ITxListProposalsMapperV0 txListProposalsMapper;

    @Autowired
    public TxListProposalsV0(@Qualifier("transaccionHyt6") InvocadorTransaccion<PeticionTransaccionHyt6, RespuestaTransaccionHyt6> transaction) {
        super(transaction, PeticionTransaccionHyt6::new, ArrayList::new, FormatoHYMR602.class);
    }

    @Override
    protected FormatoHYMR601 mapInput(InputListProposals inputListProposals) {
        return txListProposalsMapper.mapIn(inputListProposals);
    }

    @Override
    protected List<Proposal> mapFirstOutputFormat(FormatoHYMR602 formatoHYMR602, InputListProposals inputListProposals, List<Proposal> proposals) {
        return txListProposalsMapper.mapOut(formatoHYMR602, proposals);
    }
}