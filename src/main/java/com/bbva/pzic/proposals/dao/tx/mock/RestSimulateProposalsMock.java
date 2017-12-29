package com.bbva.pzic.proposals.dao.tx.mock;

import com.bbva.pzic.proposals.dao.model.simulateproposals.SimulatedProposalRequest;
import com.bbva.pzic.proposals.dao.model.simulateproposals.SimulatedProposalsResponse;
import com.bbva.pzic.proposals.dao.tx.RestSimulateProposals;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

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
    public SimulatedProposalsResponse connect(final String urlPropertyValue, final SimulatedProposalRequest entityPayload) {
        SimulatedProposalsResponse build = restSimulateProposalsBuilder.buildSimulatedProposalsResponse();

        if (EMPTY_DATA.equals(entityPayload.getDocumentNumber())) {
            build.setListaOfertas(null);
            return build;
        }
        return build;
    }
}