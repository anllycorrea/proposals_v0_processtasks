package com.bbva.pzic.proposals;

import com.bbva.pzic.proposals.business.dto.DTOInputListExternalFinancingProposals;
import com.bbva.pzic.proposals.business.dto.DTOInputModifyExternalFinancingProposal;
import com.bbva.pzic.proposals.business.dto.DTOIntExternalFinancingProposal;
import com.bbva.pzic.proposals.business.dto.DTOOutExternalFinancingProposalData;
import com.bbva.pzic.proposals.canonic.ExternalFinancingProposal;
import com.bbva.pzic.proposals.facade.v01.mapper.impl.ListExternalFinancingProposalsMapperTest;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created on 13/04/2017.
 *
 * @author Entelgy
 */
public class DummyMock {

    public static final String EXTERNAL_FINANCING_PROPOSAL_ID = "001101309600000001";

    private ObjectMapper objectMapper;

    public DummyMock() {
        objectMapper = new ObjectMapper();
    }

    public DTOOutExternalFinancingProposalData getDtoOutExternalFinancingProposalData() throws IOException {
        return objectMapper.readValue(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("com/bbva/pzic/proposals/facade/v01/mapper/impl/DTOOutExternalFinancingProposalData.json"), DTOOutExternalFinancingProposalData.class);
    }

    public DTOInputListExternalFinancingProposals getDtoInputListExternalFinancingProposals() {
        DTOInputListExternalFinancingProposals dtoIn = new DTOInputListExternalFinancingProposals();
        dtoIn.setThirdPartyProviderId(ListExternalFinancingProposalsMapperTest.THIRD_PARTY_PROVIDER_ID);
        dtoIn.setHolderIdentityDocumentsDocumentTypeId(ListExternalFinancingProposalsMapperTest.DOCUMENT_TYPE_VALUE);
        dtoIn.setHolderIdentityDocumentsDocumentNumber(ListExternalFinancingProposalsMapperTest.HOLDER_IDENTITY_DOCUMENTS_DOCUMENT_NUMBER);
        dtoIn.setFromRequestDate(ListExternalFinancingProposalsMapperTest.FROM_REQUEST_DATE);
        dtoIn.setToRequestDate(ListExternalFinancingProposalsMapperTest.TO_REQUEST_DATE);
        dtoIn.setPaginationKey(ListExternalFinancingProposalsMapperTest.PAGINATION_KEY);
        dtoIn.setPageSize(ListExternalFinancingProposalsMapperTest.PAGE_SIZE);
        return dtoIn;
    }

    public ExternalFinancingProposal modifyExternalFinancingProposalPayload() throws IOException {
        return objectMapper.readValue(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("json/modifyExternalFinancingProposal_payload.json"), ExternalFinancingProposal.class);
    }

    public DTOIntExternalFinancingProposal getDTOIntExternalFinancingProposal() throws IOException {
        return objectMapper.readValue(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("json/dtoIntExternalFinancingProposal.json"), DTOIntExternalFinancingProposal.class);
    }

    public DTOInputModifyExternalFinancingProposal getDTOInputModifyExternalFinancingProposal() throws IOException {
        DTOInputModifyExternalFinancingProposal dto = new DTOInputModifyExternalFinancingProposal();
        dto.setExternalFinancingProposalId(EXTERNAL_FINANCING_PROPOSAL_ID);
        dto.setExternalFinancingProposal(getDTOIntExternalFinancingProposal());
        return dto;
    }
}
