package com.bbva.pzic.proposals.facade.v0.mapper.impl;

import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponse;
import com.bbva.pzic.proposals.EntityStubs;
import com.bbva.pzic.proposals.business.dto.InputListProposals;
import com.bbva.pzic.proposals.canonic.Proposal;
import com.bbva.pzic.proposals.util.mappers.EnumMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.util.List;

import static com.bbva.pzic.proposals.EntityStubs.*;

/**
 * Created on 28/12/2017.
 *
 * @author Entelgy
 */
@RunWith(MockitoJUnitRunner.class)
public class ListProposalsMapperTest {

    @InjectMocks
    private ListProposalsMapper proposalsMapper;
    @Mock
    private EnumMapper enumMapper;
    private EntityStubs entityStubs = EntityStubs.getInstance();

    @Before
    public void init() {
        Mockito.when(enumMapper.getBackendValue("documentType.id", "DNI")).thenReturn("L");
    }

    @Test
    public void mapInFullTest() {
        InputListProposals result = proposalsMapper.mapIn(DOCUMENT_TYPE_ID, DOCUMENT_NUMBER, CUSTOMER_ID);

        Assert.assertNotNull(result);
        Assert.assertEquals(CUSTOMER_ID, result.getCustomerId());
        Assert.assertEquals("L", result.getDocumentTypeId());
        Assert.assertEquals(DOCUMENT_NUMBER, result.getDocumentNumber());
    }

    @Test
    public void mapOutFullTest() throws IOException {
        List<Proposal> dto = entityStubs.buildDtoIntProposals();
        ServiceResponse<List<Proposal>> proposals = proposalsMapper.mapOut(dto);

        Assert.assertNotNull(proposals);
        Assert.assertNotNull(proposals.getData());
        Assert.assertEquals(2, proposals.getData().size());

        Proposal proposal = proposals.getData().get(0);

        Assert.assertNotNull(proposal.getId());
        Assert.assertNotNull(proposal.getTerm().getFrequency());
        Assert.assertNotNull(proposal.getTerm().getValue());
        Assert.assertNotNull(proposal.getProduct().getProductClassification().getId());
        Assert.assertNotNull(proposal.getGrantedAmount().getValue());
        Assert.assertNotNull(proposal.getGrantedAmount().getCurrency());
        Assert.assertNotNull(proposal.getInstallmentPayment().getAmount());
        Assert.assertNotNull(proposal.getInstallmentPayment().getCurrency());
        Assert.assertNotNull(proposal.getInterestAnnualRate());

        Assert.assertEquals(dto.get(0).getId(), proposal.getId());
        Assert.assertEquals(dto.get(0).getTerm().getFrequency(), proposal.getTerm().getFrequency());
        Assert.assertEquals(dto.get(0).getTerm().getValue(), proposal.getTerm().getValue());
        Assert.assertEquals(dto.get(0).getProduct().getProductClassification().getId(), proposal.getProduct().getProductClassification().getId());
        Assert.assertEquals(dto.get(0).getGrantedAmount().getValue(), proposal.getGrantedAmount().getValue());
        Assert.assertEquals(dto.get(0).getGrantedAmount().getCurrency(), proposal.getGrantedAmount().getCurrency());
        Assert.assertEquals(dto.get(0).getInstallmentPayment().getAmount(), proposal.getInstallmentPayment().getAmount());
        Assert.assertEquals(dto.get(0).getInstallmentPayment().getCurrency(), proposal.getInstallmentPayment().getCurrency());
        Assert.assertEquals(dto.get(0).getInterestAnnualRate(), proposal.getInterestAnnualRate());

        proposal = proposals.getData().get(1);

        Assert.assertNotNull(proposal.getId());
        Assert.assertNotNull(proposal.getTerm().getFrequency());
        Assert.assertNotNull(proposal.getTerm().getValue());
        Assert.assertNotNull(proposal.getProduct().getProductClassification().getId());
        Assert.assertNotNull(proposal.getGrantedAmount().getValue());
        Assert.assertNotNull(proposal.getGrantedAmount().getCurrency());
        Assert.assertNotNull(proposal.getInstallmentPayment().getAmount());
        Assert.assertNotNull(proposal.getInstallmentPayment().getCurrency());
        Assert.assertNotNull(proposal.getInterestAnnualRate());

        Assert.assertEquals(dto.get(1).getId(), proposal.getId());
        Assert.assertEquals(dto.get(1).getTerm().getFrequency(), proposal.getTerm().getFrequency());
        Assert.assertEquals(dto.get(1).getTerm().getValue(), proposal.getTerm().getValue());
        Assert.assertEquals(dto.get(1).getProduct().getProductClassification().getId(), proposal.getProduct().getProductClassification().getId());
        Assert.assertEquals(dto.get(1).getGrantedAmount().getValue(), proposal.getGrantedAmount().getValue());
        Assert.assertEquals(dto.get(1).getGrantedAmount().getCurrency(), proposal.getGrantedAmount().getCurrency());
        Assert.assertEquals(dto.get(1).getInstallmentPayment().getAmount(), proposal.getInstallmentPayment().getAmount());
        Assert.assertEquals(dto.get(1).getInstallmentPayment().getCurrency(), proposal.getInstallmentPayment().getCurrency());
        Assert.assertEquals(dto.get(1).getInterestAnnualRate(), proposal.getInterestAnnualRate());

    }

    @Test
    public void mapOutNulltest() {
        ServiceResponse<List<Proposal>> proposals = proposalsMapper.mapOut(null);

        Assert.assertNull(proposals);
    }

}
