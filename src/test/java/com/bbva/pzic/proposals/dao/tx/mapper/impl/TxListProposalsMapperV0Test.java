package com.bbva.pzic.proposals.dao.tx.mapper.impl;

import com.bbva.pzic.proposals.EntityStubs;
import com.bbva.pzic.proposals.business.dto.InputListProposals;
import com.bbva.pzic.proposals.canonic.Proposal;
import com.bbva.pzic.proposals.dao.model.hyt6.FormatoHYMR601;
import com.bbva.pzic.proposals.dao.model.hyt6.FormatoHYMR602;
import com.bbva.pzic.proposals.dao.model.hyt6.mock.FormatoHYMRMock;
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
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 29/12/2017.
 *
 * @author Entelgy
 */
@RunWith(MockitoJUnitRunner.class)
public class TxListProposalsMapperV0Test {

    @InjectMocks
    private TxListProposalsMapperV0 proposalsMapperV0;
    @Mock
    private EnumMapper enumMapper;

    private FormatoHYMRMock formatoHYMRMock = new FormatoHYMRMock();
    private EntityStubs entityStubs = EntityStubs.getInstance();

    @Before
    public void setUp() {
        Mockito.when(enumMapper.getEnumValue("conditions.period.id", "D")).thenReturn("DAILY");
        Mockito.when(enumMapper.getEnumValue("conditions.period.id", "M")).thenReturn("MONTHLY");
        Mockito.when(enumMapper.getEnumValue("conditions.period.id", "A")).thenReturn("ANNUALLY");

    }

    @Test
    public void mapInFullTest() {
        InputListProposals proposals = entityStubs.buildInputListProposals();
        FormatoHYMR601 result = proposalsMapperV0.mapIn(proposals);

        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getCodcent());
        Assert.assertNotNull(result.getNumero());
        Assert.assertNotNull(result.getTipo());

        Assert.assertEquals(proposals.getCustomerId(), result.getCodcent());
        Assert.assertEquals(proposals.getDocumentTypeId(), result.getTipo());
        Assert.assertEquals(proposals.getDocumentNumber(), result.getNumero());
    }

    @Test
    public void mapInIntanseTest() {

        FormatoHYMR601 result = proposalsMapperV0.mapIn(new InputListProposals());

        Assert.assertNotNull(result);

        Assert.assertNull(result.getNumero());
        Assert.assertNull(result.getTipo());
        Assert.assertNull(result.getCodcent());

    }

    @Test
    public void mapInWithoutCustomerIdTest() {
        InputListProposals proposals = entityStubs.buildInputListProposals();
        proposals.setCustomerId(null);
        FormatoHYMR601 result = proposalsMapperV0.mapIn(proposals);


        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getNumero());
        Assert.assertNotNull(result.getTipo());

        Assert.assertNull(result.getCodcent());

        Assert.assertEquals(proposals.getDocumentTypeId(), result.getTipo());
        Assert.assertEquals(proposals.getDocumentNumber(), result.getNumero());
    }

    @Test
    public void mapInWithoutDocumentTypeIdTest() {
        InputListProposals proposals = entityStubs.buildInputListProposals();
        proposals.setDocumentTypeId(null);
        FormatoHYMR601 result = proposalsMapperV0.mapIn(proposals);


        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getNumero());
        Assert.assertNull(result.getTipo());

        Assert.assertNull(result.getTipo());

        Assert.assertEquals(proposals.getCustomerId(), result.getCodcent());
        Assert.assertEquals(proposals.getDocumentNumber(), result.getNumero());
    }

    @Test
    public void mapInWithoutDocumentNumberTest() {
        InputListProposals proposals = entityStubs.buildInputListProposals();
        proposals.setDocumentNumber(null);
        FormatoHYMR601 result = proposalsMapperV0.mapIn(proposals);

        Assert.assertNotNull(result);
        Assert.assertNull(result.getNumero());
        Assert.assertNotNull(result.getTipo());

        Assert.assertNull(result.getNumero());

        Assert.assertEquals(proposals.getCustomerId(), result.getCodcent());
        Assert.assertEquals(proposals.getDocumentTypeId(), result.getTipo());
    }

    @Test
    public void mapOutFullTest() throws IOException {
        FormatoHYMR602 mock = formatoHYMRMock.buildFormatoHYMR602s().get(0);
        List<Proposal> l = proposalsMapperV0.mapOut(mock, new ArrayList<>());
        Proposal result = l.get(0);
        Assert.assertEquals(mock.getId(), result.getId());
        Assert.assertEquals("DAILY", result.getTerm().getFrequency());
        Assert.assertEquals(mock.getPlazo(), result.getTerm().getValue());
        Assert.assertEquals(mock.getTippro(), result.getProduct().getProductClassification().getId());
        Assert.assertEquals(mock.getMontprd(), result.getGrantedAmount().getValue());
        Assert.assertEquals(mock.getMoneda(), result.getGrantedAmount().getCurrency());
        Assert.assertEquals(mock.getCuoprd(), result.getInstallmentPayment().getAmount());
        Assert.assertEquals(mock.getMoneda(), result.getInstallmentPayment().getCurrency());
        Assert.assertEquals(mock.getTea(), result.getInterestAnnualRate());


        mock = formatoHYMRMock.buildFormatoHYMR602s().get(1);
        result = proposalsMapperV0.mapOut(mock,l).get(1);
        Assert.assertEquals(mock.getId(), result.getId());
        Assert.assertEquals("MONTHLY", result.getTerm().getFrequency());
        Assert.assertEquals(mock.getPlazo(), result.getTerm().getValue());
        Assert.assertEquals(mock.getTippro(), result.getProduct().getProductClassification().getId());
        Assert.assertEquals(mock.getMontprd(), result.getGrantedAmount().getValue());
        Assert.assertEquals(mock.getMoneda(), result.getGrantedAmount().getCurrency());
        Assert.assertEquals(mock.getCuoprd(), result.getInstallmentPayment().getAmount());
        Assert.assertEquals(mock.getMoneda(), result.getInstallmentPayment().getCurrency());
        Assert.assertEquals(mock.getTea(), result.getInterestAnnualRate());

        mock = formatoHYMRMock.buildFormatoHYMR602s().get(2);
        result = proposalsMapperV0.mapOut(mock,l).get(2);

        Assert.assertEquals(mock.getId(), result.getId());
        Assert.assertEquals("ANNUALLY", result.getTerm().getFrequency());
        Assert.assertEquals(mock.getPlazo(), result.getTerm().getValue());
        Assert.assertEquals(mock.getTippro(), result.getProduct().getProductClassification().getId());
        Assert.assertEquals(mock.getMontprd(), result.getGrantedAmount().getValue());
        Assert.assertEquals(mock.getMoneda(), result.getGrantedAmount().getCurrency());
        Assert.assertEquals(mock.getCuoprd(), result.getInstallmentPayment().getAmount());
        Assert.assertEquals(mock.getMoneda(), result.getInstallmentPayment().getCurrency());
        Assert.assertEquals(mock.getTea(), result.getInterestAnnualRate());

    }

//    @Test
//    public void mapOutEmptyTest() throws IOException {
//        FormatoHYMR602 mock = formatoHYMRMock.buildFormatoHYMR602sEmpty().get(0);
//        List<Proposal> list = proposalsMapperV0.mapOut(mock, new ArrayList<>());
//        Assert.assertNull(list);
//
//    }

}
