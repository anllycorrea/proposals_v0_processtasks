package com.bbva.pzic.proposals.facade.v0.mapper.impl;

import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponse;
import com.bbva.pzic.proposals.business.dto.DTOIntProduct;
import com.bbva.pzic.proposals.business.dto.DTOIntProductClassification;
import com.bbva.pzic.proposals.business.dto.DTOIntSimulatedProposal;
import com.bbva.pzic.proposals.business.dto.DTOIntSimulatedProposals;
import com.bbva.pzic.proposals.canonic.Product;
import com.bbva.pzic.proposals.canonic.ProductClassification;
import com.bbva.pzic.proposals.canonic.SimulatedProposal;
import com.bbva.pzic.proposals.facade.v0.mapper.ISimulateProposalsMapper;
import com.bbva.pzic.proposals.util.mappers.Mapper;
import com.bbva.pzic.proposals.util.orika.MapperFactory;
import com.bbva.pzic.proposals.util.orika.impl.ConfigurableMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 28/12/2017.
 *
 * @author Entelgy
 */
@Mapper
public class SimulateProposalsMapper extends ConfigurableMapper implements ISimulateProposalsMapper {

    private static final Log LOG = LogFactory.getLog(SimulateProposalsMapper.class);

    @Override
    protected void configure(MapperFactory factory) {
        super.configure(factory);
        factory.classMap(SimulatedProposal.class, DTOIntSimulatedProposal.class)
                .field("participant.id", "participant.id")
                .field("participant.identityDocument.documentType.id", "participant.identityDocument.documentType.id")
                .field("participant.identityDocument.documentNumber", "participant.identityDocument.documentNumber")
                .field("proposal.term.frequency", "proposal.term.frequency")
                .field("proposal.term.value", "proposal.term.value")
                .field("proposal.product.productClassification.id", "proposal.product.productClassification.id")
                .field("proposal.product.title.id", "proposal.product.title.id")
                .field("proposal.grantedAmount.value", "proposal.grantedAmount.value")
                .field("proposal.grantedAmount.currency", "proposal.grantedAmount.currency")
                .field("proposal.installmentPayment.amount", "proposal.installmentPayment.amount")
                .field("proposal.installmentPayment.currency", "proposal.installmentPayment.currency")
                .field("proposal.interestRate", "proposal.interestRate")
                .register();
    }

    @Override
    public DTOIntSimulatedProposal mapIn(final SimulatedProposal simulatedProposal) {
        LOG.info("... called method SimulateProposalsMapper.mapIn ...");
        DTOIntSimulatedProposal dtoIn = map(simulatedProposal, DTOIntSimulatedProposal.class);

        List<Product> products = simulatedProposal.getProducts();
        if (products != null && !products.isEmpty()) {
            dtoIn.setProducts(new ArrayList<DTOIntProduct>());
            for (Product product : products) {
                ProductClassification productClassification = product.getProductClassification();
                if (productClassification != null && productClassification.getId() != null) {
                    DTOIntProduct dtoIntProduct = new DTOIntProduct();
                    dtoIntProduct.setProductClassification(new DTOIntProductClassification());
                    dtoIntProduct.getProductClassification().setId(productClassification.getId());
                    dtoIn.getProducts().add(dtoIntProduct);
                }
            }
        }
        return dtoIn;
    }

    @SuppressWarnings("unchecked")
    @Override
    public ServiceResponse<List<SimulatedProposal>> mapOut(final DTOIntSimulatedProposals dtoIntSimulateProposals) {
        if (dtoIntSimulateProposals == null) {
            return null;
        }
        return ServiceResponse.data(dtoIntSimulateProposals.getData()).build();
    }
}