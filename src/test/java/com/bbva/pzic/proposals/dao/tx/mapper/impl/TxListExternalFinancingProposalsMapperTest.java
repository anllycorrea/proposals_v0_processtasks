package com.bbva.pzic.proposals.dao.tx.mapper.impl;

import com.bbva.pzic.proposals.DummyMock;
import com.bbva.pzic.proposals.business.dto.DTOInputListExternalFinancingProposals;
import com.bbva.pzic.proposals.business.dto.DTOOutExternalFinancingProposalData;
import com.bbva.pzic.proposals.canonic.ExternalFinancingProposal;
import com.bbva.pzic.proposals.dao.model.uglp.FormatoUGMEGLP;
import com.bbva.pzic.proposals.dao.model.uglp.FormatoUGMSGLP1;
import com.bbva.pzic.proposals.dao.model.uglp.FormatoUGMSGLP2;
import com.bbva.pzic.proposals.dao.model.uglp.mock.FormatUglpMock;
import com.bbva.pzic.proposals.dao.tx.mapper.ITxListExternalFinancingProposalsMapper;
import com.bbva.pzic.proposals.util.mappers.EnumMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.util.List;

/**
 * Created on 12/04/2017.
 *
 * @author Entelgy
 */
public class TxListExternalFinancingProposalsMapperTest {
    final static String DELIVERY_TYPE_ID = "VIRTUAL";
    final static String STATUS_ID = "PENDING_SIGNATURE";

    @InjectMocks
    private ITxListExternalFinancingProposalsMapper proposalsMapper;

    @Mock
    private EnumMapper enumMapper;
    private DummyMock dummyMock;
    private FormatUglpMock formatUglpMock;

    @Before
    public void setUp() {
        proposalsMapper = new TxListExternalFinancingProposalsMapper();
        dummyMock = new DummyMock();
        formatUglpMock = new FormatUglpMock();
        MockitoAnnotations.initMocks(this);
    }

    public void enumMapOut() {
        Mockito.when(enumMapper.getEnumValue("externalFinancingProposals.status.id", "8")).thenReturn(STATUS_ID);
        Mockito.when(enumMapper.getEnumValue("externalFinancingProposals.delivery.deliveryType.id", "1")).thenReturn(DELIVERY_TYPE_ID);
    }

    @Test
    public void mapInFullTest() {
        DTOInputListExternalFinancingProposals dtoIn = dummyMock.getDtoInputListExternalFinancingProposals();
        FormatoUGMEGLP result = proposalsMapper.mapIn(dtoIn);
        Assert.assertNotNull(result);

        Assert.assertNotNull(result.getCodemp());
        Assert.assertEquals(result.getCodemp(), dtoIn.getThirdPartyProviderId());

        Assert.assertNotNull(result.getTipdocu());
        Assert.assertEquals(result.getTipdocu(), dtoIn.getHolderIdentityDocumentsDocumentTypeId());

        Assert.assertNotNull(result.getNrodocu());
        Assert.assertEquals(result.getNrodocu(), dtoIn.getHolderIdentityDocumentsDocumentNumber());

        Assert.assertNotNull(result.getFecrdes());

        Assert.assertNotNull(result.getFecrhas());

        Assert.assertNotNull(result.getIdpagin());
        Assert.assertEquals(result.getIdpagin(), dtoIn.getPaginationKey());

        Assert.assertNotNull(result.getTampagi());
        Assert.assertEquals(result.getTampagi().toString(), dtoIn.getPageSize().toString());

    }

    @Test
    public void mapInWithOutThirdPartyProviderIdTest() {
        DTOInputListExternalFinancingProposals dtoIn = dummyMock.getDtoInputListExternalFinancingProposals();
        dtoIn.setThirdPartyProviderId(null);
        FormatoUGMEGLP result = proposalsMapper.mapIn(dtoIn);
        Assert.assertNotNull(result);

        Assert.assertNull(result.getCodemp());

        Assert.assertNotNull(result.getTipdocu());
        Assert.assertEquals(result.getTipdocu(), dtoIn.getHolderIdentityDocumentsDocumentTypeId());

        Assert.assertNotNull(result.getNrodocu());
        Assert.assertEquals(result.getNrodocu(), dtoIn.getHolderIdentityDocumentsDocumentNumber());

        Assert.assertNotNull(result.getFecrdes());

        Assert.assertNotNull(result.getFecrhas());

        Assert.assertNotNull(result.getIdpagin());
        Assert.assertEquals(result.getIdpagin(), dtoIn.getPaginationKey());

        Assert.assertNotNull(result.getTampagi());
        Assert.assertEquals(result.getTampagi().toString(), dtoIn.getPageSize().toString());

    }

    @Test
    public void mapInWithoutHolderIdentityDocumentsDocumentTypeIdTest() {
        DTOInputListExternalFinancingProposals dtoIn = dummyMock.getDtoInputListExternalFinancingProposals();
        dtoIn.setHolderIdentityDocumentsDocumentTypeId(null);
        FormatoUGMEGLP result = proposalsMapper.mapIn(dtoIn);
        Assert.assertNotNull(result);

        Assert.assertNotNull(result.getCodemp());
        Assert.assertEquals(result.getCodemp(), dtoIn.getThirdPartyProviderId());

        Assert.assertNull(result.getTipdocu());

        Assert.assertNotNull(result.getNrodocu());
        Assert.assertEquals(result.getNrodocu(), dtoIn.getHolderIdentityDocumentsDocumentNumber());

        Assert.assertNotNull(result.getFecrdes());

        Assert.assertNotNull(result.getFecrhas());

        Assert.assertNotNull(result.getIdpagin());
        Assert.assertEquals(result.getIdpagin(), dtoIn.getPaginationKey());

        Assert.assertNotNull(result.getTampagi());
        Assert.assertEquals(result.getTampagi().toString(), dtoIn.getPageSize().toString());

    }

    @Test
    public void mapInWithOutTest() {
        DTOInputListExternalFinancingProposals dtoIn = dummyMock.getDtoInputListExternalFinancingProposals();
        dtoIn.setHolderIdentityDocumentsDocumentNumber(null);
        FormatoUGMEGLP result = proposalsMapper.mapIn(dtoIn);
        Assert.assertNotNull(result);

        Assert.assertNotNull(result.getCodemp());
        Assert.assertEquals(result.getCodemp(), dtoIn.getThirdPartyProviderId());

        Assert.assertNotNull(result.getTipdocu());
        Assert.assertEquals(result.getTipdocu(), dtoIn.getHolderIdentityDocumentsDocumentTypeId());

        Assert.assertNull(result.getNrodocu());

        Assert.assertNotNull(result.getFecrdes());

        Assert.assertNotNull(result.getFecrhas());

        Assert.assertNotNull(result.getIdpagin());
        Assert.assertEquals(result.getIdpagin(), dtoIn.getPaginationKey());

        Assert.assertNotNull(result.getTampagi());
        Assert.assertEquals(result.getTampagi().toString(), dtoIn.getPageSize().toString());

    }

    @Test
    public void mapInWithoutFromRequestDateTest() {
        DTOInputListExternalFinancingProposals dtoIn = dummyMock.getDtoInputListExternalFinancingProposals();
        dtoIn.setFromRequestDate(null);
        FormatoUGMEGLP result = proposalsMapper.mapIn(dtoIn);
        Assert.assertNotNull(result);

        Assert.assertNotNull(result.getCodemp());
        Assert.assertEquals(result.getCodemp(), dtoIn.getThirdPartyProviderId());

        Assert.assertNotNull(result.getTipdocu());
        Assert.assertEquals(result.getTipdocu(), dtoIn.getHolderIdentityDocumentsDocumentTypeId());

        Assert.assertNotNull(result.getNrodocu());
        Assert.assertEquals(result.getNrodocu(), dtoIn.getHolderIdentityDocumentsDocumentNumber());

        Assert.assertNull(result.getFecrdes());

        Assert.assertNotNull(result.getFecrhas());

        Assert.assertNotNull(result.getIdpagin());
        Assert.assertEquals(result.getIdpagin(), dtoIn.getPaginationKey());

        Assert.assertNotNull(result.getTampagi());
        Assert.assertEquals(result.getTampagi().toString(), dtoIn.getPageSize().toString());

    }

    @Test
    public void mapInWithoutToRequestDateTest() {
        DTOInputListExternalFinancingProposals dtoIn = dummyMock.getDtoInputListExternalFinancingProposals();
        dtoIn.setToRequestDate(null);
        FormatoUGMEGLP result = proposalsMapper.mapIn(dtoIn);
        Assert.assertNotNull(result);

        Assert.assertNotNull(result.getCodemp());
        Assert.assertEquals(result.getCodemp(), dtoIn.getThirdPartyProviderId());

        Assert.assertNotNull(result.getTipdocu());
        Assert.assertEquals(result.getTipdocu(), dtoIn.getHolderIdentityDocumentsDocumentTypeId());

        Assert.assertNotNull(result.getNrodocu());
        Assert.assertEquals(result.getNrodocu(), dtoIn.getHolderIdentityDocumentsDocumentNumber());

        Assert.assertNotNull(result.getFecrdes());

        Assert.assertNull(result.getFecrhas());

        Assert.assertNotNull(result.getIdpagin());
        Assert.assertEquals(result.getIdpagin(), dtoIn.getPaginationKey());

        Assert.assertNotNull(result.getTampagi());
        Assert.assertEquals(result.getTampagi().toString(), dtoIn.getPageSize().toString());

    }

    @Test
    public void mapInWithoutPaginationKeyTest() {
        DTOInputListExternalFinancingProposals dtoIn = dummyMock.getDtoInputListExternalFinancingProposals();
        dtoIn.setPaginationKey(null);
        FormatoUGMEGLP result = proposalsMapper.mapIn(dtoIn);
        Assert.assertNotNull(result);

        Assert.assertNotNull(result.getCodemp());
        Assert.assertEquals(result.getCodemp(), dtoIn.getThirdPartyProviderId());

        Assert.assertNotNull(result.getTipdocu());
        Assert.assertEquals(result.getTipdocu(), dtoIn.getHolderIdentityDocumentsDocumentTypeId());

        Assert.assertNotNull(result.getNrodocu());
        Assert.assertEquals(result.getNrodocu(), dtoIn.getHolderIdentityDocumentsDocumentNumber());

        Assert.assertNotNull(result.getFecrdes());

        Assert.assertNotNull(result.getFecrhas());

        Assert.assertNull(result.getIdpagin());

        Assert.assertNotNull(result.getTampagi());
        Assert.assertEquals(result.getTampagi().toString(), dtoIn.getPageSize().toString());

    }

    @Test
    public void mapInWithoutPageSizeTest() {
        DTOInputListExternalFinancingProposals dtoIn = dummyMock.getDtoInputListExternalFinancingProposals();
        dtoIn.setPageSize(null);
        FormatoUGMEGLP result = proposalsMapper.mapIn(dtoIn);
        Assert.assertNotNull(result);

        Assert.assertNotNull(result.getCodemp());
        Assert.assertEquals(result.getCodemp(), dtoIn.getThirdPartyProviderId());

        Assert.assertNotNull(result.getTipdocu());
        Assert.assertEquals(result.getTipdocu(), dtoIn.getHolderIdentityDocumentsDocumentTypeId());

        Assert.assertNotNull(result.getNrodocu());
        Assert.assertEquals(result.getNrodocu(), dtoIn.getHolderIdentityDocumentsDocumentNumber());

        Assert.assertNotNull(result.getFecrdes());

        Assert.assertNotNull(result.getFecrhas());

        Assert.assertNotNull(result.getIdpagin());
        Assert.assertEquals(result.getIdpagin(), dtoIn.getPaginationKey());

        Assert.assertNull(result.getTampagi());
    }

    @Test
    public void mapOut1FullTest() throws IOException {
        enumMapOut();
        List<FormatoUGMSGLP1> ugmsglp1List = formatUglpMock.getFormatoUGMSGLP1s();

        FormatoUGMSGLP1 formatoIn = ugmsglp1List.get(0);

        DTOOutExternalFinancingProposalData proposalData = proposalsMapper.mapOut1(formatoIn, new DTOOutExternalFinancingProposalData());
        Assert.assertNotNull(proposalData);

        ExternalFinancingProposal result = proposalData.getData().get(0);
        Assert.assertNotNull(result);

        Assert.assertNotNull(result.getId());
        Assert.assertEquals(result.getId(), formatoIn.getNrocont());

        Assert.assertNotNull(result.getRequestDate());

        Assert.assertNotNull(result.getDisbursementDate());

        Assert.assertEquals(result.getCurrency(), formatoIn.getMoneda());

        Assert.assertNotNull(result.getInitialFee());
        Assert.assertNotNull(result.getInitialFee().getAmount());
        Assert.assertEquals(result.getInitialFee().getAmount(), formatoIn.getCuoini());
        Assert.assertNotNull(result.getInitialFee().getAmount());
        Assert.assertEquals(result.getInitialFee().getCurrency(), formatoIn.getMoneda());

        Assert.assertNotNull(result.getInitialAmount());
        Assert.assertNotNull(result.getInitialAmount().getAmount());
        Assert.assertEquals(result.getInitialAmount().getAmount(), formatoIn.getImpfina());
        Assert.assertNotNull(result.getInitialAmount().getCurrency());
        Assert.assertEquals(result.getInitialAmount().getCurrency(), formatoIn.getMoneda());

        Assert.assertNotNull(result.getTariff());
        Assert.assertNotNull(result.getTariff().getId());
        Assert.assertEquals(result.getTariff().getId(), formatoIn.getTarifa());

        Assert.assertNotNull(result.getRelatedProduct());
        Assert.assertNotNull(result.getRelatedProduct().getRelatedProductType());
        Assert.assertNotNull(result.getRelatedProduct().getRelatedProductType().getId());
        Assert.assertEquals(result.getRelatedProduct().getRelatedProductType().getId(), formatoIn.getCodseg());
        Assert.assertNotNull(result.getRelatedProduct().getRelatedProductType().getName());
        Assert.assertEquals(result.getRelatedProduct().getRelatedProductType().getName(), formatoIn.getDescseg());

        Assert.assertNotNull(result.getRelatedProduct().getPercentage());
        Assert.assertEquals(result.getRelatedProduct().getPercentage(), formatoIn.getTasaseg());

        Assert.assertNotNull(result.getDelivery());
        Assert.assertNotNull(result.getDelivery().getType());
        Assert.assertNotNull(result.getDelivery().getType().getId());
        Assert.assertEquals(result.getDelivery().getType().getId(), DELIVERY_TYPE_ID);
        Assert.assertNotNull(result.getDelivery().getType().getName());
        Assert.assertEquals(result.getDelivery().getType().getName(), formatoIn.getDesenv());

        Assert.assertNotNull(result.getDelivery().getEmail());
        Assert.assertEquals(result.getDelivery().getEmail(), formatoIn.getMailcon());

        Assert.assertNotNull(result.getExternalProduct());
        Assert.assertNotNull(result.getExternalProduct().getId());
        Assert.assertEquals(result.getExternalProduct().getId(), formatoIn.getCodbien());
        Assert.assertNotNull(result.getExternalProduct().getCommercialValue());
        Assert.assertNotNull(result.getExternalProduct().getCommercialValue().getAmount());
        Assert.assertEquals(result.getExternalProduct().getCommercialValue().getAmount(), formatoIn.getImpbien());
        Assert.assertNotNull(result.getExternalProduct().getCommercialValue().getCurrency());
        Assert.assertEquals(result.getExternalProduct().getCommercialValue().getCurrency(), formatoIn.getMoneda());

        Assert.assertNotNull(result.getHolder());
        Assert.assertNotNull(result.getHolder().getName());
        Assert.assertEquals(result.getHolder().getName(), formatoIn.getNombr());
        Assert.assertNotNull(result.getHolder().getLastName());
        Assert.assertEquals(result.getHolder().getLastName(), formatoIn.getApepat());
        Assert.assertNotNull(result.getHolder().getMotherLastName());
        Assert.assertEquals(result.getHolder().getMotherLastName(), formatoIn.getApemat());

        Assert.assertNotNull(result.getOperation());
        Assert.assertNotNull(result.getOperation().getId());
        Assert.assertEquals(result.getOperation().getId(), formatoIn.getIdtoken());

        Assert.assertNotNull(result.getStatus());
        Assert.assertNotNull(result.getStatus().getId());
        Assert.assertEquals(result.getStatus().getId(), STATUS_ID);
        Assert.assertNotNull(result.getStatus().getName());
        Assert.assertEquals(result.getStatus().getName(), formatoIn.getDesesta());

    }

    @Test
    public void mapOut1DTOOutExternalFinancingProposalDataNullTest() throws IOException {
        enumMapOut();
        List<FormatoUGMSGLP1> ugmsglp1List = formatUglpMock.getFormatoUGMSGLP1s();

        FormatoUGMSGLP1 formatoIn = ugmsglp1List.get(0);

        DTOOutExternalFinancingProposalData proposalData = proposalsMapper.mapOut1(formatoIn, null);
        Assert.assertNotNull(proposalData);

        ExternalFinancingProposal result = proposalData.getData().get(0);
        Assert.assertNotNull(result);

        Assert.assertNotNull(result.getId());
        Assert.assertEquals(result.getId(), formatoIn.getNrocont());

        Assert.assertNotNull(result.getRequestDate());

        Assert.assertNotNull(result.getDisbursementDate());

        Assert.assertEquals(result.getCurrency(), formatoIn.getMoneda());

        Assert.assertNotNull(result.getInitialFee());
        Assert.assertNotNull(result.getInitialFee().getAmount());
        Assert.assertEquals(result.getInitialFee().getAmount(), formatoIn.getCuoini());
        Assert.assertNotNull(result.getInitialFee().getAmount());
        Assert.assertEquals(result.getInitialFee().getCurrency(), formatoIn.getMoneda());

        Assert.assertNotNull(result.getInitialAmount());
        Assert.assertNotNull(result.getInitialAmount().getAmount());
        Assert.assertEquals(result.getInitialAmount().getAmount(), formatoIn.getImpfina());
        Assert.assertNotNull(result.getInitialAmount().getCurrency());
        Assert.assertEquals(result.getInitialAmount().getCurrency(), formatoIn.getMoneda());

        Assert.assertNotNull(result.getTariff());
        Assert.assertNotNull(result.getTariff().getId());
        Assert.assertEquals(result.getTariff().getId(), formatoIn.getTarifa());

        Assert.assertNotNull(result.getRelatedProduct());
        Assert.assertNotNull(result.getRelatedProduct().getRelatedProductType());
        Assert.assertNotNull(result.getRelatedProduct().getRelatedProductType().getId());
        Assert.assertEquals(result.getRelatedProduct().getRelatedProductType().getId(), formatoIn.getCodseg());
        Assert.assertNotNull(result.getRelatedProduct().getRelatedProductType().getName());
        Assert.assertEquals(result.getRelatedProduct().getRelatedProductType().getName(), formatoIn.getDescseg());

        Assert.assertNotNull(result.getRelatedProduct().getPercentage());
        Assert.assertEquals(result.getRelatedProduct().getPercentage(), formatoIn.getTasaseg());

        Assert.assertNotNull(result.getDelivery());
        Assert.assertNotNull(result.getDelivery().getType());
        Assert.assertNotNull(result.getDelivery().getType().getId());
        Assert.assertEquals(result.getDelivery().getType().getId(), DELIVERY_TYPE_ID);
        Assert.assertNotNull(result.getDelivery().getType().getName());
        Assert.assertEquals(result.getDelivery().getType().getName(), formatoIn.getDesenv());

        Assert.assertNotNull(result.getDelivery().getEmail());
        Assert.assertEquals(result.getDelivery().getEmail(), formatoIn.getMailcon());

        Assert.assertNotNull(result.getExternalProduct());
        Assert.assertNotNull(result.getExternalProduct().getId());
        Assert.assertEquals(result.getExternalProduct().getId(), formatoIn.getCodbien());
        Assert.assertNotNull(result.getExternalProduct().getCommercialValue());
        Assert.assertNotNull(result.getExternalProduct().getCommercialValue().getAmount());
        Assert.assertEquals(result.getExternalProduct().getCommercialValue().getAmount(), formatoIn.getImpbien());
        Assert.assertNotNull(result.getExternalProduct().getCommercialValue().getCurrency());
        Assert.assertEquals(result.getExternalProduct().getCommercialValue().getCurrency(), formatoIn.getMoneda());

        Assert.assertNotNull(result.getHolder());
        Assert.assertNotNull(result.getHolder().getName());
        Assert.assertEquals(result.getHolder().getName(), formatoIn.getNombr());
        Assert.assertNotNull(result.getHolder().getLastName());
        Assert.assertEquals(result.getHolder().getLastName(), formatoIn.getApepat());
        Assert.assertNotNull(result.getHolder().getMotherLastName());
        Assert.assertEquals(result.getHolder().getMotherLastName(), formatoIn.getApemat());

        Assert.assertNotNull(result.getOperation());
        Assert.assertNotNull(result.getOperation().getId());
        Assert.assertEquals(result.getOperation().getId(), formatoIn.getIdtoken());

        Assert.assertNotNull(result.getStatus());
        Assert.assertNotNull(result.getStatus().getId());
        Assert.assertEquals(result.getStatus().getId(), STATUS_ID);
        Assert.assertNotNull(result.getStatus().getName());
        Assert.assertEquals(result.getStatus().getName(), formatoIn.getDesesta());

    }

    @Test
    public void mapOut2FullTest() throws IOException {
        FormatoUGMSGLP2 ugmsglp2 = formatUglpMock.getFormatoUGMSGLP2();

        DTOOutExternalFinancingProposalData proposalData = proposalsMapper.mapOut2(ugmsglp2, new DTOOutExternalFinancingProposalData());
        Assert.assertNotNull(proposalData);
        Assert.assertNotNull(proposalData.getPagination());

        Assert.assertEquals(proposalData.getPagination().getPaginationKey(), ugmsglp2.getIdpagin());
        Assert.assertEquals(proposalData.getPagination().getPageSize().toString(), ugmsglp2.getTampagi().toString());
    }

    @Test
    public void mapOut2DTOOutNullTest() throws IOException {
        FormatoUGMSGLP2 ugmsglp2 = formatUglpMock.getFormatoUGMSGLP2();

        DTOOutExternalFinancingProposalData proposalData = proposalsMapper.mapOut2(ugmsglp2, null);
        Assert.assertNotNull(proposalData);
        Assert.assertNotNull(proposalData.getPagination());

        Assert.assertEquals(proposalData.getPagination().getPaginationKey(), ugmsglp2.getIdpagin());
        Assert.assertEquals(proposalData.getPagination().getPageSize().toString(), ugmsglp2.getTampagi().toString());
    }

    @Test
    public void mapOut2WithoutIdpaginTest() throws IOException {
        FormatoUGMSGLP2 ugmsglp2 = formatUglpMock.getFormatoUGMSGLP2();
        ugmsglp2.setIdpagin(null);

        DTOOutExternalFinancingProposalData proposalData = proposalsMapper.mapOut2(ugmsglp2, new DTOOutExternalFinancingProposalData());
        Assert.assertNotNull(proposalData);
        Assert.assertNotNull(proposalData.getPagination());

        Assert.assertNull(proposalData.getPagination().getPaginationKey());
        Assert.assertEquals(proposalData.getPagination().getPageSize().toString(), ugmsglp2.getTampagi().toString());
    }

    @Test
    public void mapOut2WithoutTampagiTest() throws IOException {
        FormatoUGMSGLP2 ugmsglp2 = formatUglpMock.getFormatoUGMSGLP2();
        ugmsglp2.setTampagi(null);

        DTOOutExternalFinancingProposalData proposalData = proposalsMapper.mapOut2(ugmsglp2, new DTOOutExternalFinancingProposalData());
        Assert.assertNotNull(proposalData);
        Assert.assertNotNull(proposalData.getPagination());

        Assert.assertEquals(proposalData.getPagination().getPaginationKey(), ugmsglp2.getIdpagin());
        Assert.assertNull(proposalData.getPagination().getPageSize());
    }

    @Test
    public void mapOut2PaginationNullTest() throws IOException {
        FormatoUGMSGLP2 ugmsglp2 = formatUglpMock.getFormatoUGMSGLP2();
        ugmsglp2.setTampagi(null);
        ugmsglp2.setIdpagin(null);
        DTOOutExternalFinancingProposalData proposalData = proposalsMapper.mapOut2(ugmsglp2, new DTOOutExternalFinancingProposalData());
        Assert.assertNotNull(proposalData);
        Assert.assertNull(proposalData.getPagination());
    }


}