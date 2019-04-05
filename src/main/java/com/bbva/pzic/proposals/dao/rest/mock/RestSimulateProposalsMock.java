package com.bbva.pzic.proposals.dao.rest.mock;

import com.bbva.pzic.proposals.dao.model.simulateproposals.Oferta;
import com.bbva.pzic.proposals.dao.model.simulateproposals.SimulatedProposalRequest;
import com.bbva.pzic.proposals.dao.rest.RestSimulateProposals;
import com.bbva.pzic.proposals.dao.rest.mock.stub.RestSimulateProposalsBuilder;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created on 28/12/2017.
 *
 * @author Entelgy
 */
@Component
@Primary
public class RestSimulateProposalsMock extends RestSimulateProposals {

    public static final String EMPTY_DATA = "99999999";

    private RestSimulateProposalsBuilder restSimulateProposalsBuilder;

    @PostConstruct
    public void init() {
        restSimulateProposalsBuilder = new RestSimulateProposalsBuilder();
    }

    @Override
    public List<Oferta> connect(final String urlPropertyValue, final SimulatedProposalRequest entityPayload) {
        if (EMPTY_DATA.equals(entityPayload.getDocumentNumber())) {
            return null;
        }
        return restSimulateProposalsBuilder.buildSimulatedProposalsResponse();
    }
}