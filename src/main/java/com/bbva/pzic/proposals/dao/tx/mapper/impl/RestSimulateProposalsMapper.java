package com.bbva.pzic.proposals.dao.tx.mapper.impl;

import com.bbva.pzic.proposals.business.dto.DTOIntProduct;
import com.bbva.pzic.proposals.business.dto.DTOIntProductClassification;
import com.bbva.pzic.proposals.business.dto.DTOIntSimulatedProposal;
import com.bbva.pzic.proposals.canonic.SimulatedProposalsData;
import com.bbva.pzic.proposals.dao.model.simulateproposals.ProductClassification;
import com.bbva.pzic.proposals.dao.model.simulateproposals.SimulatedProposalRequest;
import com.bbva.pzic.proposals.dao.model.simulateproposals.SimulatedProposalsResponse;
import com.bbva.pzic.proposals.dao.tx.mapper.IRestSimulateProposalsMapper;
import com.bbva.pzic.proposals.util.mappers.EnumMapper;
import com.bbva.pzic.proposals.util.mappers.Mapper;
import com.bbva.pzic.proposals.util.orika.MapperFactory;
import com.bbva.pzic.proposals.util.orika.impl.ConfigurableMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 28/12/2017.
 *
 * @author Entelgy
 */
@Mapper
public class RestSimulateProposalsMapper extends ConfigurableMapper implements IRestSimulateProposalsMapper {

    @Autowired
    private EnumMapper enumMapper;

    @Override
    protected void configure(MapperFactory factory) {
        super.configure(factory);
        factory.classMap(DTOIntSimulatedProposal.class, SimulatedProposalRequest.class)
                .field("participant.id", "customerId")
                .field("participant.identityDocument.documentType.id", "documentType")//documentType.id
                .field("participant.identityDocument.documentNumber", "documentNumber")
                .field("proposal.term.frequency", "tipplazoSel")//conditions.period.id
                .field("proposal.term.value", "codPlazoSel")
                .field("proposal.product.productClassification.id", "codProductoSel")
                .field("proposal.grantedAmount.value", "valMontoSel")
                .field("proposal.grantedAmount.currency", "divisa")
                .field("proposal.installmentPayment.amount", "valCuotaSel")
                .field("proposal.installmentPayment.currency", "divisa")
                .field("proposal.interestRate", "tasaSel")
                .register();
    }

    @Override
    public SimulatedProposalRequest mapIn(DTOIntSimulatedProposal dtoIn) {
        SimulatedProposalRequest simulatedProposalRequest = map(dtoIn, SimulatedProposalRequest.class);

        List<DTOIntProduct> dtoInProducts = dtoIn.getProducts();
        if (dtoInProducts != null && !dtoInProducts.isEmpty()) {
            simulatedProposalRequest.setProductClassifications(new ArrayList<ProductClassification>());
            for (DTOIntProduct dtoIntProduct : dtoInProducts) {
                DTOIntProductClassification dtoIntProductClassification = dtoIntProduct.getProductClassification();
                if (dtoIntProductClassification != null && dtoIntProductClassification.getId() != null) {
                    ProductClassification productClassification = new ProductClassification();
                    productClassification.setId(dtoIntProductClassification.getId());
                    simulatedProposalRequest.getProductClassifications().add(productClassification);
                }
            }
        }

        //TODO mapear enumns
        return simulatedProposalRequest;
    }

    @Override
    public SimulatedProposalsData mapOut(SimulatedProposalsResponse response) {
        return null;
    }
}