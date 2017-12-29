package com.bbva.pzic.proposals.dao.tx.mapper.impl;

import com.bbva.pzic.proposals.business.dto.DTOIntProduct;
import com.bbva.pzic.proposals.business.dto.DTOIntProductClassification;
import com.bbva.pzic.proposals.business.dto.DTOIntSimulatedProposal;
import com.bbva.pzic.proposals.canonic.GrantedAmount;
import com.bbva.pzic.proposals.canonic.GrantedAmountType;
import com.bbva.pzic.proposals.canonic.Indicator;
import com.bbva.pzic.proposals.canonic.Installment;
import com.bbva.pzic.proposals.canonic.InterestRate;
import com.bbva.pzic.proposals.canonic.Principal;
import com.bbva.pzic.proposals.canonic.Range;
import com.bbva.pzic.proposals.canonic.SimulatedProposal;
import com.bbva.pzic.proposals.canonic.SimulatedProposalsData;
import com.bbva.pzic.proposals.dao.model.simulateproposals.Oferta;
import com.bbva.pzic.proposals.dao.model.simulateproposals.ProductClassification;
import com.bbva.pzic.proposals.dao.model.simulateproposals.SimulatedProposalRequest;
import com.bbva.pzic.proposals.dao.model.simulateproposals.SimulatedProposalsResponse;
import com.bbva.pzic.proposals.dao.tx.mapper.IRestSimulateProposalsMapper;
import com.bbva.pzic.proposals.util.mappers.EnumMapper;
import com.bbva.pzic.proposals.util.mappers.Mapper;
import com.bbva.pzic.proposals.util.orika.MapperFactory;
import com.bbva.pzic.proposals.util.orika.converter.builtin.BooleanToStringConverter;
import com.bbva.pzic.proposals.util.orika.impl.ConfigurableMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
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
        factory.getConverterFactory().registerConverter(new BooleanToStringConverter());

        factory.classMap(DTOIntSimulatedProposal.class, SimulatedProposalRequest.class)
                //.field("participant.id", "customerId")
                .field("participant.identityDocument.documentType.id", "documentType")
                .field("participant.identityDocument.documentNumber", "documentNumber")
                .field("proposal.term.frequency", "tipplazoSel")
                .field("proposal.term.value", "codPlazoSel")
                .field("proposal.product.productClassification.id", "codProductoSel")
                .field("proposal.grantedAmount.value", "valMontoSel")
                .field("proposal.grantedAmount.currency", "divisa")
                .field("proposal.installmentPayment.amount", "valCuotaSel")
                .field("proposal.installmentPayment.currency", "divisa")
                .field("proposal.interestRate", "tasaSel")
                .register();

        factory.classMap(SimulatedProposal.class, Oferta.class)
                .field("participant.id", "codigoCentral")
                .field("participant.identityDocument.documentType.id", "documentType")
                .field("participant.identityDocument.documentNumber", "documentNumber")
                .field("participant.segmentationCode", "codigoSegmento")
                .field("participant.riskLevel.id", "indicadorRiesgo")
                .field("participant.riskLevel.name", "desIndicadorRiesgo")
                .field("internalCode", "codInterno")
                .field("procurementFlow.procurementFlowType.id", "codFlujoOpe")
                .field("procurementFlow.procurementFlowType.name", "flujoOperativo")
                .field("indicators[0].isActive", "vdomiciliaria")
                .field("indicators[1].isActive", "vlaboral")
                .field("campaign.code", "campanha")
                .field("term.frequency", "tipplazo")
                .field("term.value", "codPlazo")
                .field("product.bin", "valBin")
                .field("product.title.id", "codSubProducto")
                .field("product.title.name", "desSubProducto")
                .field("product.riskGroup", "stRiesgo")
                .field("product.productType.id", "familiaProducto")
                .field("product.productClassification.id", "codProducto")
                .field("product.productClassification.name", "desProducto")
                .field("product.productConfiguration.id", "codConfigProducto")
                .field("product.productConfiguration.description", "desConfigProducto")
                .register();
    }

    @Override
    public SimulatedProposalRequest mapIn(final DTOIntSimulatedProposal dtoIn) {
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
        this.mapInEnums(simulatedProposalRequest);
        return simulatedProposalRequest;
    }

    private void mapInEnums(final SimulatedProposalRequest simulatedProposalRequest) {
        if (simulatedProposalRequest.getDocumentType() != null) {
            simulatedProposalRequest.setDocumentType(enumMapper.getBackendValue("documentType.id", simulatedProposalRequest.getDocumentType()));
        }
        if (simulatedProposalRequest.getTipplazoSel() != null) {
            simulatedProposalRequest.setTipplazoSel(enumMapper.getBackendValue("conditions.period.id", simulatedProposalRequest.getTipplazoSel()));
        }
    }

    @Override
    public SimulatedProposalsData mapOut(final SimulatedProposalsResponse response) {
        if (response.getListaOfertas() == null || !response.getListaOfertas().isEmpty()) {
            return null;
        }

        List<SimulatedProposal> data = new ArrayList<>();

        for (Oferta oferta : response.getListaOfertas()) {
            SimulatedProposal simulatedProposal = map(oferta, SimulatedProposal.class);

            simulatedProposal.setIndicators(this.addIndicators(simulatedProposal.getIndicators(), "ADDRESS_VALIDATION", oferta.getVdomiciliaria()));
            simulatedProposal.setIndicators(this.addIndicators(simulatedProposal.getIndicators(), "WORKPLACE_VALIDATION", oferta.getVlaboral()));

            simulatedProposal.setInterestRates(this.addInterestRates(simulatedProposal.getInterestRates(), "PROPOSED", oferta.getValTasa()));
            simulatedProposal.setInterestRates(this.addInterestRates(simulatedProposal.getInterestRates(), "MAXIMUM", oferta.getTasaMax()));
            simulatedProposal.setInterestRates(this.addInterestRates(simulatedProposal.getInterestRates(), "MINIMUM", oferta.getTasaMin()));

            simulatedProposal.setRanges(this.addRanges(simulatedProposal.getRanges(), "MAXIMUM", oferta.getRangoMax()));
            simulatedProposal.setRanges(this.addRanges(simulatedProposal.getRanges(), "MINIMUM", oferta.getRangoMin()));

            simulatedProposal.setInstallments(this.addInstallments(simulatedProposal.getInstallments(), "ADJUSTED", oferta.getValCuotaAjust(), oferta.getDivisa()));
            simulatedProposal.setInstallments(this.addInstallments(simulatedProposal.getInstallments(), "CONTRACT", oferta.getValCuotaContrato(), oferta.getDivisa()));
            simulatedProposal.setInstallments(this.addInstallments(simulatedProposal.getInstallments(), "REAL", oferta.getValCuotaReal(), oferta.getDivisa()));

            simulatedProposal.setGrantedAmounts(this.addGrantedAmounts(simulatedProposal.getGrantedAmounts(), "ADJUSTED", oferta.getValLimiteAjust(), oferta.getDivisa()));
            simulatedProposal.setGrantedAmounts(this.addGrantedAmounts(simulatedProposal.getGrantedAmounts(), "CONTRACTED", oferta.getValLimiteContrato(), oferta.getDivisa()));
            simulatedProposal.setGrantedAmounts(this.addGrantedAmounts(simulatedProposal.getGrantedAmounts(), "REAL", oferta.getValLimiteReal(), oferta.getDivisa()));

            this.mapOutEnums(oferta, simulatedProposal);
            data.add(simulatedProposal);
        }

        SimulatedProposalsData simulatedProposalsData = new SimulatedProposalsData();
        simulatedProposalsData.setData(data);
        return simulatedProposalsData;
    }

    private List<Indicator> addIndicators(final List<Indicator> indicators, final String id, final String value) {
        List<Indicator> list = indicators;
        if (list == null) {
            list = new ArrayList<>();
        }

        Indicator indicator = new Indicator();
        indicator.setId(id);
        indicator.setIsActive("SI".equalsIgnoreCase(value));
        list.add(indicator);
        return list;
    }

    private List<InterestRate> addInterestRates(List<InterestRate> interestRates, String id, BigDecimal value) {
        List<InterestRate> list = interestRates;

        if (list == null) {
            list = new ArrayList<>();
        }

        InterestRate interestRate = new InterestRate();
        interestRate.setInterestRateType(id);
        interestRate.setValue(value);
        list.add(interestRate);
        return list;
    }

    private List<Range> addRanges(List<Range> ranges, String id, BigDecimal value) {
        List<Range> list = ranges;

        if (list == null) {
            list = new ArrayList<>();
        }

        Range range = new Range();
        range.setId(id);
        range.setValue(value);
        list.add(range);
        return list;
    }

    private List<Installment> addInstallments(List<Installment> installments, String id, BigDecimal amount, String currency) {
        List<Installment> list = installments;

        if (list == null) {
            list = new ArrayList<>();
        }

        Installment installment = new Installment();
        installment.setInstallmentType(id);
        Principal principal = new Principal();
        principal.setAmount(amount);
        principal.setCurrency(currency);
        installment.setPrincipal(principal);
        list.add(installment);
        return list;
    }

    private List<GrantedAmount> addGrantedAmounts(List<GrantedAmount> grantedAmounts, String id, BigDecimal value, String currency) {
        List<GrantedAmount> list = grantedAmounts;

        if (list == null) {
            list = new ArrayList<>();
        }

        GrantedAmount grantedAmount = new GrantedAmount();
        GrantedAmountType grantedAmountType = new GrantedAmountType();
        grantedAmountType.setId(id);
        grantedAmount.setGrantedAmountType(grantedAmountType);
        grantedAmount.setValue(value);
        grantedAmount.setCurrency(currency);
        list.add(grantedAmount);
        return list;
    }

    private void mapOutEnums(final Oferta oferta, final SimulatedProposal simulatedProposal) {
        if (oferta.getCodFlujoOpe() != null) {
            simulatedProposal.getProcurementFlow().getProcurementFlowType().setId(enumMapper.getEnumValue("proposals.procurementFlow.id", oferta.getCodFlujoOpe()));
        }
        if (oferta.getTipplazo() != null) {
            simulatedProposal.getTerm().setFrequency(enumMapper.getEnumValue("conditions.period.id", oferta.getTipplazo()));
        }
        if (oferta.getStRiesgo() != null) {
            simulatedProposal.getProduct().setRiskGroup(enumMapper.getEnumValue("proposals.riskType.id", oferta.getStRiesgo()));
        }
        if (oferta.getFamiliaProducto() != null) {
            simulatedProposal.getProduct().getProductType().setId(enumMapper.getEnumValue("product.productType.id", oferta.getFamiliaProducto()));
        }
    }
}