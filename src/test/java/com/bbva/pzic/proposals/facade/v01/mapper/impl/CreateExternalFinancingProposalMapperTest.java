package com.bbva.pzic.proposals.facade.v01.mapper.impl;

import com.bbva.pzic.proposals.DummyMock;
import com.bbva.pzic.proposals.business.dto.DTOIntExternalFinancingProposal;
import com.bbva.pzic.proposals.canonic.ExternalFinancingProposal;
import com.bbva.pzic.proposals.canonic.IdentityDocument;
import com.bbva.pzic.proposals.facade.v01.mapper.ICreateExternalFinancingProposalMapper;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created on 12/04/2017.
 *
 * @author Entelgy
 */
public class CreateExternalFinancingProposalMapperTest {

    private ICreateExternalFinancingProposalMapper mapper;

    private DummyMock dummyMock;

    @Before
    public void setUp() {
        mapper = new CreateExternalFinancingProposalMapper();
        dummyMock = new DummyMock();
    }

    @Test
    public void mapInFullTest() throws IOException {

        ExternalFinancingProposal externalFinancingProposal = dummyMock.getExternalFinancingProposal();

        DTOIntExternalFinancingProposal result = mapper.mapIn(externalFinancingProposal);

        assertNotNull(result);
        assertNotNull(result.getTariff());
        assertNotNull(result.getCurrency());
        assertNotNull(result.getInitialAmount());
        assertNotNull(result.getPaymentDay());
        assertNotNull(result.getDeliveryTypeId());
        assertNotNull(result.getDeliveryVirtualDestination());
        assertNotNull(result.getOperation());
        assertNotNull(result.getOperation().getOperationType());
        assertNotNull(result.getExternalProduct());
        assertNotNull(result.getExternalProduct().getCommercialValueAmount());
        assertNotNull(result.getThirdPartyProvider());
        assertNotNull(result.getThirdPartyProvider().getExternalSalesChannel());

        assertEquals(externalFinancingProposal.getHolder().getIdentityDocuments().get(0).getDocumentType().getId(), result.getDocumentTypeId());
        assertEquals(externalFinancingProposal.getHolder().getIdentityDocuments().get(0).getDocumentNumber(), result.getDocumentNumber());
        assertEquals(externalFinancingProposal.getTariff().getId(), result.getTariff().getId());
        assertEquals(externalFinancingProposal.getCurrency(), result.getCurrency());
        assertEquals(externalFinancingProposal.getInitialAmount().getAmount(), result.getInitialAmount().getAmount());
        assertEquals(externalFinancingProposal.getInitialAmount().getCurrency(), result.getInitialAmount().getCurrency());
        assertEquals(externalFinancingProposal.getPaymentDay(), result.getPaymentDay());
        assertEquals(externalFinancingProposal.getDelivery().getDeliveryType().getId(), result.getDeliveryTypeId());
        assertEquals(externalFinancingProposal.getDelivery().getVirtualDestination(), result.getDeliveryVirtualDestination());
        assertEquals(externalFinancingProposal.getOperation().getId(), result.getOperation().getId());
        assertEquals(externalFinancingProposal.getOperation().getOperationType().getId(), result.getOperation().getOperationType().getId());
        assertEquals(externalFinancingProposal.getExternalProduct().getId(), result.getExternalProduct().getId());
        assertEquals(externalFinancingProposal.getExternalProduct().getCommercialValueAmount().getAmount(), result.getExternalProduct().getCommercialValueAmount().getAmount());
        assertEquals(externalFinancingProposal.getExternalProduct().getCommercialValueAmount().getCurrency(), result.getExternalProduct().getCommercialValueAmount().getCurrency());
        assertEquals(externalFinancingProposal.getThirdPartyProvider().getExternalSalesChannel().getId(), result.getThirdPartyProvider().getExternalSalesChannel().getId());
        assertEquals(externalFinancingProposal.getThirdPartyProvider().getId(), result.getThirdPartyProvider().getId());
    }

    @Test
    public void mapInWithoutHolderTest() throws IOException {

        ExternalFinancingProposal externalFinancingProposal = dummyMock.getExternalFinancingProposal();
        externalFinancingProposal.setHolder(null);

        DTOIntExternalFinancingProposal result = mapper.mapIn(externalFinancingProposal);

        assertNotNull(result);

        assertNotNull(result.getTariff());
        assertNotNull(result.getCurrency());
        assertNotNull(result.getInitialAmount());
        assertNotNull(result.getPaymentDay());
        assertNotNull(result.getDeliveryTypeId());
        assertNotNull(result.getDeliveryVirtualDestination());
        assertNotNull(result.getOperation());
        assertNotNull(result.getOperation().getOperationType());
        assertNotNull(result.getExternalProduct());
        assertNotNull(result.getExternalProduct().getCommercialValueAmount());
        assertNotNull(result.getThirdPartyProvider());
        assertNotNull(result.getThirdPartyProvider().getExternalSalesChannel());


        assertNull(result.getDocumentTypeId());
        assertNull(result.getDocumentNumber());
        assertEquals(externalFinancingProposal.getTariff().getId(), result.getTariff().getId());
        assertEquals(externalFinancingProposal.getCurrency(), result.getCurrency());
        assertEquals(externalFinancingProposal.getInitialAmount().getAmount(), result.getInitialAmount().getAmount());
        assertEquals(externalFinancingProposal.getInitialAmount().getCurrency(), result.getInitialAmount().getCurrency());
        assertEquals(externalFinancingProposal.getPaymentDay(), result.getPaymentDay());
        assertEquals(externalFinancingProposal.getDelivery().getDeliveryType().getId(), result.getDeliveryTypeId());
        assertEquals(externalFinancingProposal.getDelivery().getVirtualDestination(), result.getDeliveryVirtualDestination());
        assertEquals(externalFinancingProposal.getOperation().getId(), result.getOperation().getId());
        assertEquals(externalFinancingProposal.getOperation().getOperationType().getId(), result.getOperation().getOperationType().getId());
        assertEquals(externalFinancingProposal.getExternalProduct().getId(), result.getExternalProduct().getId());
        assertEquals(externalFinancingProposal.getExternalProduct().getCommercialValueAmount().getAmount(), result.getExternalProduct().getCommercialValueAmount().getAmount());
        assertEquals(externalFinancingProposal.getExternalProduct().getCommercialValueAmount().getCurrency(), result.getExternalProduct().getCommercialValueAmount().getCurrency());
        assertEquals(externalFinancingProposal.getThirdPartyProvider().getExternalSalesChannel().getId(), result.getThirdPartyProvider().getExternalSalesChannel().getId());
        assertEquals(externalFinancingProposal.getThirdPartyProvider().getId(), result.getThirdPartyProvider().getId());
    }

    @Test
    public void mapInWithoutHolderIdentityDocumentsTest() throws IOException {

        ExternalFinancingProposal externalFinancingProposal = dummyMock.getExternalFinancingProposal();
        externalFinancingProposal.getHolder().setIdentityDocuments(null);

        DTOIntExternalFinancingProposal result = mapper.mapIn(externalFinancingProposal);

        assertNotNull(result);
        assertNotNull(result.getTariff());
        assertNotNull(result.getCurrency());
        assertNotNull(result.getInitialAmount());
        assertNotNull(result.getPaymentDay());
        assertNotNull(result.getDeliveryTypeId());
        assertNotNull(result.getDeliveryVirtualDestination());
        assertNotNull(result.getOperation());
        assertNotNull(result.getOperation().getOperationType());
        assertNotNull(result.getExternalProduct());
        assertNotNull(result.getExternalProduct().getCommercialValueAmount());
        assertNotNull(result.getThirdPartyProvider());
        assertNotNull(result.getThirdPartyProvider().getExternalSalesChannel());


        assertNull(result.getDocumentTypeId());
        assertNull(result.getDocumentNumber());
        assertEquals(externalFinancingProposal.getTariff().getId(), result.getTariff().getId());
        assertEquals(externalFinancingProposal.getCurrency(), result.getCurrency());
        assertEquals(externalFinancingProposal.getInitialAmount().getAmount(), result.getInitialAmount().getAmount());
        assertEquals(externalFinancingProposal.getInitialAmount().getCurrency(), result.getInitialAmount().getCurrency());
        assertEquals(externalFinancingProposal.getPaymentDay(), result.getPaymentDay());
        assertEquals(externalFinancingProposal.getDelivery().getDeliveryType().getId(), result.getDeliveryTypeId());
        assertEquals(externalFinancingProposal.getDelivery().getVirtualDestination(), result.getDeliveryVirtualDestination());
        assertEquals(externalFinancingProposal.getOperation().getId(), result.getOperation().getId());
        assertEquals(externalFinancingProposal.getOperation().getOperationType().getId(), result.getOperation().getOperationType().getId());
        assertEquals(externalFinancingProposal.getExternalProduct().getId(), result.getExternalProduct().getId());
        assertEquals(externalFinancingProposal.getExternalProduct().getCommercialValueAmount().getAmount(), result.getExternalProduct().getCommercialValueAmount().getAmount());
        assertEquals(externalFinancingProposal.getExternalProduct().getCommercialValueAmount().getCurrency(), result.getExternalProduct().getCommercialValueAmount().getCurrency());
        assertEquals(externalFinancingProposal.getThirdPartyProvider().getExternalSalesChannel().getId(), result.getThirdPartyProvider().getExternalSalesChannel().getId());
        assertEquals(externalFinancingProposal.getThirdPartyProvider().getId(), result.getThirdPartyProvider().getId());
    }

    @Test
    public void mapInWithHolderIdentityDocumentsEmptyTest() throws IOException {

        ExternalFinancingProposal externalFinancingProposal = dummyMock.getExternalFinancingProposal();
        externalFinancingProposal.getHolder().setIdentityDocuments(new ArrayList<IdentityDocument>());

        DTOIntExternalFinancingProposal result = mapper.mapIn(externalFinancingProposal);

        assertNotNull(result);
        assertNotNull(result.getTariff());
        assertNotNull(result.getCurrency());
        assertNotNull(result.getInitialAmount());
        assertNotNull(result.getPaymentDay());
        assertNotNull(result.getDeliveryTypeId());
        assertNotNull(result.getDeliveryVirtualDestination());
        assertNotNull(result.getOperation());
        assertNotNull(result.getOperation().getOperationType());
        assertNotNull(result.getExternalProduct());
        assertNotNull(result.getExternalProduct().getCommercialValueAmount());
        assertNotNull(result.getThirdPartyProvider());
        assertNotNull(result.getThirdPartyProvider().getExternalSalesChannel());

        assertNull(result.getDocumentTypeId());
        assertNull(result.getDocumentNumber());
        assertEquals(externalFinancingProposal.getTariff().getId(), result.getTariff().getId());
        assertEquals(externalFinancingProposal.getCurrency(), result.getCurrency());
        assertEquals(externalFinancingProposal.getInitialAmount().getAmount(), result.getInitialAmount().getAmount());
        assertEquals(externalFinancingProposal.getInitialAmount().getCurrency(), result.getInitialAmount().getCurrency());
        assertEquals(externalFinancingProposal.getPaymentDay(), result.getPaymentDay());
        assertEquals(externalFinancingProposal.getDelivery().getDeliveryType().getId(), result.getDeliveryTypeId());
        assertEquals(externalFinancingProposal.getDelivery().getVirtualDestination(), result.getDeliveryVirtualDestination());
        assertEquals(externalFinancingProposal.getOperation().getId(), result.getOperation().getId());
        assertEquals(externalFinancingProposal.getOperation().getOperationType().getId(), result.getOperation().getOperationType().getId());
        assertEquals(externalFinancingProposal.getExternalProduct().getId(), result.getExternalProduct().getId());
        assertEquals(externalFinancingProposal.getExternalProduct().getCommercialValueAmount().getAmount(), result.getExternalProduct().getCommercialValueAmount().getAmount());
        assertEquals(externalFinancingProposal.getExternalProduct().getCommercialValueAmount().getCurrency(), result.getExternalProduct().getCommercialValueAmount().getCurrency());
        assertEquals(externalFinancingProposal.getThirdPartyProvider().getExternalSalesChannel().getId(), result.getThirdPartyProvider().getExternalSalesChannel().getId());
        assertEquals(externalFinancingProposal.getThirdPartyProvider().getId(), result.getThirdPartyProvider().getId());
    }

    @Test
    public void mapInWithHolderIdentityDocumentsNullItemTest() throws IOException {

        ExternalFinancingProposal externalFinancingProposal = dummyMock.getExternalFinancingProposal();
        externalFinancingProposal.getHolder().getIdentityDocuments().clear();
        externalFinancingProposal.getHolder().getIdentityDocuments().add(null);

        DTOIntExternalFinancingProposal result = mapper.mapIn(externalFinancingProposal);

        assertNotNull(result);
        assertNotNull(result.getTariff());
        assertNotNull(result.getCurrency());
        assertNotNull(result.getInitialAmount());
        assertNotNull(result.getPaymentDay());
        assertNotNull(result.getDeliveryTypeId());
        assertNotNull(result.getDeliveryVirtualDestination());
        assertNotNull(result.getOperation());
        assertNotNull(result.getOperation().getOperationType());
        assertNotNull(result.getExternalProduct());
        assertNotNull(result.getExternalProduct().getCommercialValueAmount());
        assertNotNull(result.getThirdPartyProvider());
        assertNotNull(result.getThirdPartyProvider().getExternalSalesChannel());

        assertNull(result.getDocumentTypeId());
        assertNull(result.getDocumentNumber());
        assertEquals(externalFinancingProposal.getTariff().getId(), result.getTariff().getId());
        assertEquals(externalFinancingProposal.getCurrency(), result.getCurrency());
        assertEquals(externalFinancingProposal.getInitialAmount().getAmount(), result.getInitialAmount().getAmount());
        assertEquals(externalFinancingProposal.getInitialAmount().getCurrency(), result.getInitialAmount().getCurrency());
        assertEquals(externalFinancingProposal.getPaymentDay(), result.getPaymentDay());
        assertEquals(externalFinancingProposal.getDelivery().getDeliveryType().getId(), result.getDeliveryTypeId());
        assertEquals(externalFinancingProposal.getDelivery().getVirtualDestination(), result.getDeliveryVirtualDestination());
        assertEquals(externalFinancingProposal.getOperation().getId(), result.getOperation().getId());
        assertEquals(externalFinancingProposal.getOperation().getOperationType().getId(), result.getOperation().getOperationType().getId());
        assertEquals(externalFinancingProposal.getExternalProduct().getId(), result.getExternalProduct().getId());
        assertEquals(externalFinancingProposal.getExternalProduct().getCommercialValueAmount().getAmount(), result.getExternalProduct().getCommercialValueAmount().getAmount());
        assertEquals(externalFinancingProposal.getExternalProduct().getCommercialValueAmount().getCurrency(), result.getExternalProduct().getCommercialValueAmount().getCurrency());
        assertEquals(externalFinancingProposal.getThirdPartyProvider().getExternalSalesChannel().getId(), result.getThirdPartyProvider().getExternalSalesChannel().getId());
        assertEquals(externalFinancingProposal.getThirdPartyProvider().getId(), result.getThirdPartyProvider().getId());
    }

    @Test
    public void mapInEmptyTest() throws IOException {

        DTOIntExternalFinancingProposal result = mapper.mapIn(new ExternalFinancingProposal());

        assertNotNull(result);
        assertNull(result.getTariff());
        assertNull(result.getCurrency());
        assertNull(result.getInitialAmount());
        assertNull(result.getPaymentDay());
        assertNull(result.getDeliveryTypeId());
        assertNull(result.getDeliveryVirtualDestination());
        assertNull(result.getOperation());
        assertNull(result.getExternalProduct());
        assertNull(result.getThirdPartyProvider());
        assertNull(result.getDocumentTypeId());
        assertNull(result.getDocumentNumber());
    }

    @Test
    public void mapInWithNullTest() throws IOException {

        DTOIntExternalFinancingProposal result = mapper.mapIn(null);

        assertNull(result);
    }

}