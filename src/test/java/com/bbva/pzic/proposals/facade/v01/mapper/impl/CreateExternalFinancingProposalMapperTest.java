package com.bbva.pzic.proposals.facade.v01.mapper.impl;

import com.bbva.pzic.proposals.DummyMock;
import com.bbva.pzic.proposals.business.dto.DTOIntExternalFinancingProposal;
import com.bbva.pzic.proposals.canonic.ExternalFinancingProposal;
import com.bbva.pzic.proposals.canonic.IdentityDocument;
import com.bbva.pzic.proposals.facade.v0.mapper.impl.CreateExternalFinancingProposalMapper;
import com.bbva.pzic.proposals.util.mappers.EnumMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created on 12/04/2017.
 *
 * @author Entelgy
 */
public class CreateExternalFinancingProposalMapperTest {

    @InjectMocks
    private CreateExternalFinancingProposalMapper mapper;

    @Mock
    private EnumMapper enumMapper;

    private DummyMock dummyMock;

    @Before
    public void setUp() {
        mapper = new CreateExternalFinancingProposalMapper();
        dummyMock = new DummyMock();
        MockitoAnnotations.initMocks(this);
        mapInEnumMapper();
    }

    public void mapInEnumMapper() {
        Mockito.when(enumMapper.getBackendValue("externalFinancingProposals.delivery.deliveryType.id", "DIGITAL")).thenReturn("D");
        Mockito.when(enumMapper.getBackendValue("documentType.id", "DNI")).thenReturn("L");
    }

    @Test
    public void mapInFullTest() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = dummyMock.getExternalFinancingProposal();
        DTOIntExternalFinancingProposal result = mapper.mapIn(DummyMock.THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);

        assertNotNull(result);
        assertNotNull(result.getCurrency());
        assertNotNull(result.getPaymentDay());
        assertNotNull(result.getInitialAmount().getAmount());
        assertNotNull(result.getInitialAmount().getCurrency());
        assertNotNull(result.getTariff().getId());
        assertNotNull(result.getDeliveryTypeId());
        assertNotNull(result.getEmail());
        assertNotNull(result.getExternalProduct().getId());
        assertNotNull(result.getExternalProduct().getCommercialValue().getAmount());
        assertNotNull(result.getExternalProduct().getCommercialValue().getCurrency());
        assertNotNull(result.getDocumentTypeId());
        assertNotNull(result.getDocumentNumber());
        assertNotNull(result.getOperation().getId());
        assertNotNull(result.getOperation().getOperationType());
        assertNotNull(result.getThirdPartyProvider().getId());
        assertNotNull(result.getThirdPartyProvider().getExternalSalesChannel().getId());
        assertNotNull(result.getThirdPartyProvider().getUserId());
        assertNotNull(result.getBranchId());

        assertEquals(externalFinancingProposal.getCurrency(), result.getCurrency());
        assertEquals(externalFinancingProposal.getPaymentDay(), result.getPaymentDay());
        assertEquals(externalFinancingProposal.getInitialAmount().getAmount(), result.getInitialAmount().getAmount());
        assertEquals(externalFinancingProposal.getInitialAmount().getCurrency(), result.getInitialAmount().getCurrency());
        assertEquals(externalFinancingProposal.getTariff().getId(), result.getTariff().getId());
        assertEquals("D", result.getDeliveryTypeId());
        assertEquals(externalFinancingProposal.getDelivery().getEmail(), result.getEmail());
        assertEquals(externalFinancingProposal.getExternalProduct().getId(), result.getExternalProduct().getId());
        assertEquals(externalFinancingProposal.getExternalProduct().getCommercialValue().getAmount(), result.getExternalProduct().getCommercialValue().getAmount());
        assertEquals(externalFinancingProposal.getExternalProduct().getCommercialValue().getCurrency(), result.getExternalProduct().getCommercialValue().getCurrency());
        assertEquals("L", result.getDocumentTypeId());
        assertEquals(externalFinancingProposal.getHolder().getIdentityDocuments().get(0).getDocumentNumber(), result.getDocumentNumber());
        assertEquals(externalFinancingProposal.getOperation().getId(), result.getOperation().getId());
        assertEquals(externalFinancingProposal.getOperation().getOperationType().getId(), result.getOperation().getOperationType().getId());
        assertEquals(externalFinancingProposal.getThirdPartyProvider().getId(), result.getThirdPartyProvider().getId());
        assertEquals(externalFinancingProposal.getThirdPartyProvider().getExternalSalesChannel().getId(), result.getThirdPartyProvider().getExternalSalesChannel().getId());
        assertEquals(DummyMock.THIRD_PARTY_PROVIDER_USER_ID, result.getThirdPartyProvider().getUserId());
        assertEquals(externalFinancingProposal.getBranch().getId(), result.getBranchId());
    }

    @Test
    public void mapInWithoutHolderTest() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = dummyMock.getExternalFinancingProposal();
        externalFinancingProposal.setHolder(null);
        DTOIntExternalFinancingProposal result = mapper.mapIn(DummyMock.THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);

        assertNotNull(result);
        assertNotNull(result.getTariff());
        assertNotNull(result.getCurrency());
        assertNotNull(result.getInitialAmount());
        assertNotNull(result.getPaymentDay());
        assertNotNull(result.getDeliveryTypeId());
        assertNotNull(result.getEmail());
        assertNotNull(result.getOperation());
        assertNotNull(result.getOperation().getOperationType());
        assertNotNull(result.getExternalProduct());
        assertNotNull(result.getExternalProduct().getCommercialValue().getAmount());
        assertNotNull(result.getExternalProduct().getCommercialValue().getCurrency());
        assertNotNull(result.getThirdPartyProvider());
        assertNotNull(result.getThirdPartyProvider().getExternalSalesChannel());
        assertNotNull(result.getThirdPartyProvider().getUserId());
        assertNotNull(result.getBranchId());
        assertNull(result.getDocumentTypeId());
        assertNull(result.getDocumentNumber());

        assertEquals(externalFinancingProposal.getTariff().getId(), result.getTariff().getId());
        assertEquals(externalFinancingProposal.getCurrency(), result.getCurrency());
        assertEquals(externalFinancingProposal.getInitialAmount().getAmount(), result.getInitialAmount().getAmount());
        assertEquals(externalFinancingProposal.getInitialAmount().getCurrency(), result.getInitialAmount().getCurrency());
        assertEquals(externalFinancingProposal.getPaymentDay(), result.getPaymentDay());
        assertEquals("D", result.getDeliveryTypeId());
        assertEquals(externalFinancingProposal.getDelivery().getEmail(), result.getEmail());
        assertEquals(externalFinancingProposal.getOperation().getId(), result.getOperation().getId());
        assertEquals(externalFinancingProposal.getOperation().getOperationType().getId(), result.getOperation().getOperationType().getId());
        assertEquals(externalFinancingProposal.getExternalProduct().getId(), result.getExternalProduct().getId());
        assertEquals(externalFinancingProposal.getExternalProduct().getCommercialValue().getAmount(), result.getExternalProduct().getCommercialValue().getAmount());
        assertEquals(externalFinancingProposal.getExternalProduct().getCommercialValue().getCurrency(), result.getExternalProduct().getCommercialValue().getCurrency());
        assertEquals(externalFinancingProposal.getThirdPartyProvider().getExternalSalesChannel().getId(), result.getThirdPartyProvider().getExternalSalesChannel().getId());
        assertEquals(externalFinancingProposal.getThirdPartyProvider().getId(), result.getThirdPartyProvider().getId());
        assertEquals(DummyMock.THIRD_PARTY_PROVIDER_USER_ID, result.getThirdPartyProvider().getUserId());
        assertEquals(externalFinancingProposal.getBranch().getId(), result.getBranchId());
    }

    @Test
    public void mapInWithoutHolderIdentityDocumentsTest() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = dummyMock.getExternalFinancingProposal();
        externalFinancingProposal.getHolder().setIdentityDocuments(null);
        DTOIntExternalFinancingProposal result = mapper.mapIn(DummyMock.THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);

        assertNotNull(result);
        assertNotNull(result.getTariff());
        assertNotNull(result.getCurrency());
        assertNotNull(result.getInitialAmount());
        assertNotNull(result.getPaymentDay());
        assertNotNull(result.getDeliveryTypeId());
        assertNotNull(result.getEmail());
        assertNotNull(result.getOperation());
        assertNotNull(result.getOperation().getOperationType());
        assertNotNull(result.getExternalProduct());
        assertNotNull(result.getExternalProduct().getCommercialValue().getAmount());
        assertNotNull(result.getExternalProduct().getCommercialValue().getCurrency());
        assertNotNull(result.getThirdPartyProvider());
        assertNotNull(result.getThirdPartyProvider().getExternalSalesChannel());
        assertNotNull(result.getThirdPartyProvider().getUserId());
        assertNotNull(result.getBranchId());
        assertNull(result.getDocumentTypeId());
        assertNull(result.getDocumentNumber());

        assertEquals(externalFinancingProposal.getTariff().getId(), result.getTariff().getId());
        assertEquals(externalFinancingProposal.getCurrency(), result.getCurrency());
        assertEquals(externalFinancingProposal.getInitialAmount().getAmount(), result.getInitialAmount().getAmount());
        assertEquals(externalFinancingProposal.getInitialAmount().getCurrency(), result.getInitialAmount().getCurrency());
        assertEquals(externalFinancingProposal.getPaymentDay(), result.getPaymentDay());
        assertEquals("D", result.getDeliveryTypeId());
        assertEquals(externalFinancingProposal.getDelivery().getEmail(), result.getEmail());
        assertEquals(externalFinancingProposal.getOperation().getId(), result.getOperation().getId());
        assertEquals(externalFinancingProposal.getOperation().getOperationType().getId(), result.getOperation().getOperationType().getId());
        assertEquals(externalFinancingProposal.getExternalProduct().getId(), result.getExternalProduct().getId());
        assertEquals(externalFinancingProposal.getExternalProduct().getCommercialValue().getAmount(), result.getExternalProduct().getCommercialValue().getAmount());
        assertEquals(externalFinancingProposal.getExternalProduct().getCommercialValue().getCurrency(), result.getExternalProduct().getCommercialValue().getCurrency());
        assertEquals(externalFinancingProposal.getThirdPartyProvider().getExternalSalesChannel().getId(), result.getThirdPartyProvider().getExternalSalesChannel().getId());
        assertEquals(externalFinancingProposal.getThirdPartyProvider().getId(), result.getThirdPartyProvider().getId());
        assertEquals(DummyMock.THIRD_PARTY_PROVIDER_USER_ID, result.getThirdPartyProvider().getUserId());
        assertEquals(externalFinancingProposal.getBranch().getId(), result.getBranchId());
    }

    @Test
    public void mapInWithHolderIdentityDocumentsEmptyTest() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = dummyMock.getExternalFinancingProposal();
        externalFinancingProposal.getHolder().setIdentityDocuments(new ArrayList<IdentityDocument>());
        DTOIntExternalFinancingProposal result = mapper.mapIn(DummyMock.THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);

        assertNotNull(result);
        assertNotNull(result.getTariff());
        assertNotNull(result.getCurrency());
        assertNotNull(result.getInitialAmount());
        assertNotNull(result.getPaymentDay());
        assertNotNull(result.getDeliveryTypeId());
        assertNotNull(result.getEmail());
        assertNotNull(result.getOperation());
        assertNotNull(result.getOperation().getOperationType());
        assertNotNull(result.getExternalProduct());
        assertNotNull(result.getExternalProduct().getCommercialValue().getAmount());
        assertNotNull(result.getExternalProduct().getCommercialValue().getCurrency());
        assertNotNull(result.getThirdPartyProvider());
        assertNotNull(result.getThirdPartyProvider().getExternalSalesChannel());
        assertNotNull(result.getThirdPartyProvider().getUserId());
        assertNotNull(result.getBranchId());
        assertNull(result.getDocumentTypeId());
        assertNull(result.getDocumentNumber());

        assertEquals(externalFinancingProposal.getTariff().getId(), result.getTariff().getId());
        assertEquals(externalFinancingProposal.getCurrency(), result.getCurrency());
        assertEquals(externalFinancingProposal.getInitialAmount().getAmount(), result.getInitialAmount().getAmount());
        assertEquals(externalFinancingProposal.getInitialAmount().getCurrency(), result.getInitialAmount().getCurrency());
        assertEquals(externalFinancingProposal.getPaymentDay(), result.getPaymentDay());
        assertEquals("D", result.getDeliveryTypeId());
        assertEquals(externalFinancingProposal.getDelivery().getEmail(), result.getEmail());
        assertEquals(externalFinancingProposal.getOperation().getId(), result.getOperation().getId());
        assertEquals(externalFinancingProposal.getOperation().getOperationType().getId(), result.getOperation().getOperationType().getId());
        assertEquals(externalFinancingProposal.getExternalProduct().getId(), result.getExternalProduct().getId());
        assertEquals(externalFinancingProposal.getExternalProduct().getCommercialValue().getAmount(), result.getExternalProduct().getCommercialValue().getAmount());
        assertEquals(externalFinancingProposal.getExternalProduct().getCommercialValue().getCurrency(), result.getExternalProduct().getCommercialValue().getCurrency());
        assertEquals(externalFinancingProposal.getThirdPartyProvider().getExternalSalesChannel().getId(), result.getThirdPartyProvider().getExternalSalesChannel().getId());
        assertEquals(externalFinancingProposal.getThirdPartyProvider().getId(), result.getThirdPartyProvider().getId());
        assertEquals(DummyMock.THIRD_PARTY_PROVIDER_USER_ID, result.getThirdPartyProvider().getUserId());
        assertEquals(externalFinancingProposal.getBranch().getId(), result.getBranchId());
    }

    @Test
    public void mapInWithHolderIdentityDocumentsNullItemTest() throws IOException {
        ExternalFinancingProposal externalFinancingProposal = dummyMock.getExternalFinancingProposal();
        externalFinancingProposal.getHolder().getIdentityDocuments().clear();
        externalFinancingProposal.getHolder().getIdentityDocuments().add(null);
        DTOIntExternalFinancingProposal result = mapper.mapIn(DummyMock.THIRD_PARTY_PROVIDER_USER_ID, externalFinancingProposal);

        assertNotNull(result);
        assertNotNull(result.getTariff());
        assertNotNull(result.getCurrency());
        assertNotNull(result.getInitialAmount());
        assertNotNull(result.getPaymentDay());
        assertNotNull(result.getDeliveryTypeId());
        assertNotNull(result.getEmail());
        assertNotNull(result.getOperation());
        assertNotNull(result.getOperation().getOperationType());
        assertNotNull(result.getExternalProduct());
        assertNotNull(result.getExternalProduct().getCommercialValue().getAmount());
        assertNotNull(result.getExternalProduct().getCommercialValue().getCurrency());
        assertNotNull(result.getThirdPartyProvider());
        assertNotNull(result.getThirdPartyProvider().getExternalSalesChannel());
        assertNotNull(result.getThirdPartyProvider().getUserId());
        assertNotNull(result.getBranchId());
        assertNull(result.getDocumentTypeId());
        assertNull(result.getDocumentNumber());

        assertEquals(externalFinancingProposal.getTariff().getId(), result.getTariff().getId());
        assertEquals(externalFinancingProposal.getCurrency(), result.getCurrency());
        assertEquals(externalFinancingProposal.getInitialAmount().getAmount(), result.getInitialAmount().getAmount());
        assertEquals(externalFinancingProposal.getInitialAmount().getCurrency(), result.getInitialAmount().getCurrency());
        assertEquals(externalFinancingProposal.getPaymentDay(), result.getPaymentDay());
        assertEquals("D", result.getDeliveryTypeId());
        assertEquals(externalFinancingProposal.getDelivery().getEmail(), result.getEmail());
        assertEquals(externalFinancingProposal.getOperation().getId(), result.getOperation().getId());
        assertEquals(externalFinancingProposal.getOperation().getOperationType().getId(), result.getOperation().getOperationType().getId());
        assertEquals(externalFinancingProposal.getExternalProduct().getId(), result.getExternalProduct().getId());
        assertEquals(externalFinancingProposal.getExternalProduct().getCommercialValue().getAmount(), result.getExternalProduct().getCommercialValue().getAmount());
        assertEquals(externalFinancingProposal.getExternalProduct().getCommercialValue().getCurrency(), result.getExternalProduct().getCommercialValue().getCurrency());
        assertEquals(externalFinancingProposal.getThirdPartyProvider().getExternalSalesChannel().getId(), result.getThirdPartyProvider().getExternalSalesChannel().getId());
        assertEquals(externalFinancingProposal.getThirdPartyProvider().getId(), result.getThirdPartyProvider().getId());
        assertEquals(DummyMock.THIRD_PARTY_PROVIDER_USER_ID, result.getThirdPartyProvider().getUserId());
        assertEquals(externalFinancingProposal.getBranch().getId(), result.getBranchId());
    }

    @Test
    public void mapInPartialEmptyTest() throws IOException {
        DTOIntExternalFinancingProposal result = mapper.mapIn(DummyMock.THIRD_PARTY_PROVIDER_USER_ID, new ExternalFinancingProposal());

        assertNotNull(result);
        assertNull(result.getTariff());
        assertNull(result.getCurrency());
        assertNull(result.getInitialAmount());
        assertNull(result.getPaymentDay());
        assertNull(result.getDeliveryTypeId());
        assertNull(result.getEmail());
        assertNull(result.getOperation());
        assertNull(result.getExternalProduct());
        assertNull(result.getThirdPartyProvider().getId());
        assertNull(result.getThirdPartyProvider().getExternalSalesChannel());
        assertNotNull(result.getThirdPartyProvider().getUserId());
        assertNull(result.getBranchId());
        assertNull(result.getDocumentTypeId());
        assertNull(result.getDocumentNumber());

        assertEquals(DummyMock.THIRD_PARTY_PROVIDER_USER_ID, result.getThirdPartyProvider().getUserId());
    }

    @Test
    public void mapInEmptyTest() throws IOException {
        DTOIntExternalFinancingProposal result = mapper.mapIn(null, new ExternalFinancingProposal());

        assertNotNull(result);
        assertNull(result.getTariff());
        assertNull(result.getCurrency());
        assertNull(result.getInitialAmount());
        assertNull(result.getPaymentDay());
        assertNull(result.getDeliveryTypeId());
        assertNull(result.getEmail());
        assertNull(result.getOperation());
        assertNull(result.getExternalProduct());
        assertNull(result.getThirdPartyProvider());
        assertNull(result.getDocumentTypeId());
        assertNull(result.getDocumentNumber());
        assertNull(result.getBranchId());
    }

    @Test
    public void mapInWithNullTest() throws IOException {
        DTOIntExternalFinancingProposal result = mapper.mapIn(null, null);

        assertNull(result);
    }
}