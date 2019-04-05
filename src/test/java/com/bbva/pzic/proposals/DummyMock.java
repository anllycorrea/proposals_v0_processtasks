package com.bbva.pzic.proposals;

import com.bbva.pzic.proposals.business.dto.*;
import com.bbva.pzic.proposals.canonic.ExternalFinancingProposal;
import com.bbva.pzic.proposals.canonic.Proposal;
import com.bbva.pzic.proposals.canonic.SimulatedProposal;
import com.bbva.pzic.proposals.facade.v01.mapper.impl.ListExternalFinancingProposalsMapperTest;
import com.bbva.pzic.proposals.util.helper.ObjectMapperHelper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;
import java.util.List;

/**
 * Created on 13/04/2017.
 *
 * @author Entelgy
 */
public final class DummyMock {

    public static final String EXTERNAL_FINANCING_PROPOSAL_ID = "001101309600000001";
    public static final String THIRD_PARTY_PROVIDER_USER_ID = "12312432";
    public final static String EXTERNAL_FINANCING_PROPOSALS_DELIVERY_TYPE_ID = "D";
    public final static String EXTERNAL_FINANCING_PROPOSALS_DELIVERY_TYPE_VALUE = "DIGITAL";
    public final static String STATUS_ID = "8";
    public final static String STATUS_VALUE = "PENDING_SIGNATURE";
    public final static String CUSTOMER_ID = "12345678";
    public final static String DOCUMENT_NUMBER = "12345678910";
    public final static String DOCUMENT_TYPE_ID = "DNI";

    private ObjectMapperHelper objectMapper;

    public DummyMock() {
        objectMapper = ObjectMapperHelper.getInstance();
    }

    public DTOOutExternalFinancingProposalData getDtoOutExternalFinancingProposalData() throws IOException {
        return objectMapper.readValue(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("json/DTOOutExternalFinancingProposalData.json"), DTOOutExternalFinancingProposalData.class);
    }

    public DTOInputListExternalFinancingProposals getDtoInputListExternalFinancingProposals() {
        DTOInputListExternalFinancingProposals dtoIn = new DTOInputListExternalFinancingProposals();
        dtoIn.setThirdPartyProviderId(ListExternalFinancingProposalsMapperTest.THIRD_PARTY_PROVIDER_ID);
        dtoIn.setExternalproductCategoryTypeId(ListExternalFinancingProposalsMapperTest.EXTERNAL_PRODUCT_CATEGORY_TYPE_ID);
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

    public ExternalFinancingProposal getExternalFinancingProposal() throws IOException {
        return objectMapper.readValue(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("json/externalFinancingProposal.json"), ExternalFinancingProposal.class);
    }

    public InputListProposals buildInputListProposals() {
        InputListProposals proposals = new InputListProposals();
        proposals.setCustomerId(CUSTOMER_ID);
        proposals.setDocumentTypeId(DOCUMENT_TYPE_ID);
        proposals.setDocumentNumber(DOCUMENT_NUMBER);
        return proposals;
    }

    public List<Proposal> buildDtoIntProposals() throws IOException {
        return objectMapper.readValue(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("json/list-proporsal-response.json"), new TypeReference<List<Proposal>>() {
        });
    }

    public SimulatedProposal getSimulatedProposal() throws IOException {
        return objectMapper.readValue(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("json/simulatedProposal.json"), SimulatedProposal.class);
    }

    public DTOIntSimulatedProposal getDtoIntSimulatedProposal() throws IOException {
        return objectMapper.readValue(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("json/simulatedProposal.json"), DTOIntSimulatedProposal.class);
    }
}
