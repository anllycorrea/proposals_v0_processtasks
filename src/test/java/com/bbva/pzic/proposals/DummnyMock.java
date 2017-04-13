package com.bbva.pzic.proposals;

import com.bbva.pzic.proposals.business.dto.DTOInputListExternalFinancingProposals;
import com.bbva.pzic.proposals.business.dto.DTOOutExternalFinancingProposalData;
import com.bbva.pzic.proposals.dao.model.uglp.FormatoUGMSGLP1;
import com.bbva.pzic.proposals.dao.model.uglp.FormatoUGMSGLP2;
import com.bbva.pzic.proposals.facade.v01.mapper.impl.ListExternalFinancingProposalsMapperTest;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

/**
 * Created on 13/04/2017.
 *
 * @author Entelgy
 */
public class DummnyMock {
    private ObjectMapper objectMapper;

    public DummnyMock() {
        objectMapper = new ObjectMapper();
    }

    public DTOOutExternalFinancingProposalData getDtoOutExternalFinancingProposalData() throws IOException {
        return objectMapper.readValue(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("com/bbva/pzic/proposals/facade/v01/mapper/impl/DTOOutExternalFinancingProposalData.json"), DTOOutExternalFinancingProposalData.class);
    }

    public List<FormatoUGMSGLP1> getFormatoUGMSGLP1List() throws IOException {
        return objectMapper.readValue(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("com/bbva/pzic/proposals/dao/model/uglp/mock/listFormatoUGMSGLP1.json"),new TypeReference<List<FormatoUGMSGLP1>>() {
        });
    }

    public DTOInputListExternalFinancingProposals getDtoInputListExternalFinancingProposals(){
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

    public FormatoUGMSGLP2 getFormatoUGMSGLP2(){
        FormatoUGMSGLP2 ugmsglp2 = new FormatoUGMSGLP2();
        ugmsglp2.setIdpagin("abc123");
        ugmsglp2.setTampagi(123);
        return ugmsglp2;
    }

}
