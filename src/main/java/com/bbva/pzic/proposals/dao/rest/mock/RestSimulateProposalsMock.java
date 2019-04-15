package com.bbva.pzic.proposals.dao.rest.mock;

import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.pzic.proposals.dao.model.simulateproposals.SimulatedProposalRequest;
import com.bbva.pzic.proposals.dao.model.simulateproposals.SimulatedProposalsResponse;
import com.bbva.pzic.proposals.dao.rest.RestSimulateProposals;
import com.bbva.pzic.proposals.dao.rest.mock.stub.RestSimulateProposalsBuilder;
import com.bbva.pzic.proposals.util.Errors;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;

/**
 * Created on 28/12/2017.
 *
 * @author Entelgy
 */
@Component
@Primary
public class RestSimulateProposalsMock extends RestSimulateProposals {

    public static final String EMPTY_DATA = "99999999";
    public static final String ERROR_RESPONSE = "88888888";

    private RestSimulateProposalsBuilder restSimulateProposalsBuilder;

    @PostConstruct
    public void init() {
        restSimulateProposalsBuilder = new RestSimulateProposalsBuilder();
    }

    @Override
    public SimulatedProposalsResponse connect(final String urlPropertyValue, final SimulatedProposalRequest entityPayload) {
        if (EMPTY_DATA.equals(entityPayload.getDocumentNumber())) {
            return null;
        }

        try {
            if (ERROR_RESPONSE.equals(entityPayload.getDocumentNumber())) {
                evaluateResponse(restSimulateProposalsBuilder.buildMessages(), 400);
            }

            return restSimulateProposalsBuilder.buildSimulatedProposalsResponse();
        } catch (IOException e) {
            throw new BusinessServiceException(Errors.TECHNICAL_ERROR, e);
        }
    }
}