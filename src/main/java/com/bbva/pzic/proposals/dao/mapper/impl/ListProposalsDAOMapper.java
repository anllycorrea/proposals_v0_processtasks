package com.bbva.pzic.proposals.dao.mapper.impl;

import com.bbva.pzic.proposals.business.dto.DTOInputListProposals;
import com.bbva.pzic.proposals.canonic.*;
import com.bbva.pzic.proposals.dao.mapper.IListProposalsDAOMapper;
import com.bbva.pzic.proposals.dao.model.listproposals.FormatProposal;
import com.bbva.pzic.proposals.dao.model.listproposals.FormatProposalData;
import com.bbva.pzic.proposals.facade.v01.ISrvProposalsV01;
import com.bbva.pzic.proposals.util.orika.MapperFactory;
import com.bbva.pzic.proposals.util.orika.impl.ConfigurableMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created on 06/12/2016.
 *
 * @author Entelgy
 */
@Component
public class ListProposalsDAOMapper extends ConfigurableMapper implements IListProposalsDAOMapper {

    private static final Log LOG = LogFactory.getLog(ListProposalsDAOMapper.class);

    @Override
    protected void configure(MapperFactory factory) {

        super.configure(factory);

        factory.classMap(FormatProposalData.class, ProposalData.class)
                .field("idPagin", "pagination.nextPage")
                .field("tampagi", "pagination.pageSize")
                .register();

        factory.classMap(FormatProposal.class, Proposal.class)
                .field("idPropuesta", "id")
                .field("campanha", "campaign.code")
                .field("codigoCentral", "customerId")
                .field("codInterno", "internalCode")
                .field("flujoOperativo", "procurementFlow.name")
                .field("codFlujoOpe", "procurementFlow.id")
                .field("tipplazo", "term.id")
                .field("codPlazo", "term.value")
                .field("familiaProducto", "product.productType.id")
                .field("codSubProducto", "product.title.id")
                .field("desSubProducto", "product.title.name")
                .field("valBin", "product.bin")
                .field("codProducto", "product.productClassification.id")
                .field("desProducto", "product.productClassification.name")
                .field("desConfigProducto", "product.productConfiguration.description")
                .field("codConfigProducto", "product.productConfiguration.id")
                .field("stRiesgo", "riskType.id")
                .register();
    }

    /**
     * @see IListProposalsDAOMapper#mapInput(DTOInputListProposals)
     */
    @Override
    public HashMap<String, String> mapInput(final DTOInputListProposals dtoInputListProposals) {
        LOG.info("... called method ListProposalsDAOMapper.mapInput ...");
        HashMap<String, String> map = new HashMap<>();
        map.put(ISrvProposalsV01.CUSTOMER_ID, dtoInputListProposals.getCustomerId());
        map.put(ISrvProposalsV01.DOCUMENT_TYPE, dtoInputListProposals.getDocumentType());
        map.put(ISrvProposalsV01.DOCUMENT_NUMBER, dtoInputListProposals.getDocumentNumber());
        map.put(ISrvProposalsV01.PRODUCT_CLASSIFICATION_ID, dtoInputListProposals.getProductClassificationId());
        map.put(ISrvProposalsV01.PAGINATION_KEY, dtoInputListProposals.getPaginationKey());
        if (dtoInputListProposals.getPageSize() != null) {
            map.put(ISrvProposalsV01.PAGE_SIZE, dtoInputListProposals.getPageSize().toString());
        }
        return map;
    }

    /**
     * @see IListProposalsDAOMapper#mapOutput(FormatProposalData)
     */
    @Override
    public ProposalData mapOutput(final FormatProposalData formatProposalData) {
        LOG.info("... called method ListProposalsDAOMapper.mapOutput ...");
        ProposalData proposalData = map(formatProposalData, ProposalData.class);
        if (formatProposalData.getListaOfertas() != null) {
            final List<Proposal> proposals = new ArrayList<>();
            for (final FormatProposal formatProposal : formatProposalData.getListaOfertas()) {
                final Proposal proposal = map(formatProposal, Proposal.class);
                final List<Indicator> indicators = new ArrayList<>();
                indicators.add(newIndicator("ADDRESS_VALIDATION",
                        stringToBoolean(formatProposal.getVdomiciliaria())));
                indicators.add(newIndicator("WORKPLACE_VALIDATION",
                        stringToBoolean(formatProposal.getVlaboral())));
                proposal.setIndicators(indicators);

                final List<Limit> limits = new ArrayList<>();
                limits.add(newLimit("ADJUSTED", formatProposal.getValLimiteAjust(), formatProposal.getDivisa()));
                limits.add(newLimit("CONTRACT", formatProposal.getValLimiteContrato(), formatProposal.getDivisa()));
                limits.add(newLimit("REAL", formatProposal.getValLimiteReal(), formatProposal.getDivisa()));
                proposal.setLimits(limits);
                final List<Instalment> instalments = new ArrayList<>();
                instalments.add(newInstalment("ADJUSTED", formatProposal.getValCuotaAjust(), formatProposal.getDivisa()));
                instalments.add(newInstalment("CONTRACT", formatProposal.getValCuotaContrato(), formatProposal.getDivisa()));
                instalments.add(newInstalment("REAL", formatProposal.getValCuotaReal(), formatProposal.getDivisa()));
                proposal.setInstalments(instalments);
                final List<Rate> rates = new ArrayList<>();
                rates.add(newRate("PROPOSED", formatProposal.getValTasa()));
                rates.add(newRate("MAXIMUM", formatProposal.getTasaMax()));
                rates.add(newRate("MINIMUM", formatProposal.getTasaMin()));
                proposal.setRates(rates);
                final List<Range> ranges = new ArrayList<>();
                ranges.add(newRange("MAXIMUM", formatProposal.getRangoMax()));
                ranges.add(newRange("MINIMUM", formatProposal.getRangoMin()));
                proposal.setRanges(ranges);

                proposals.add(proposal);
            }
            proposalData.setData(proposals);
        }
        return proposalData;
    }

    private Rate newRate(String id, BigDecimal value) {
        final Rate rate = new Rate();
        rate.setId(id);
        rate.setValue(value);
        return rate;
    }

    private Range newRange(String id, BigDecimal value) {
        final Range range = new Range();
        range.setId(id);
        range.setValue(value);
        return range;
    }

    private Limit newLimit(String id, BigDecimal amountValue, String amountCurrency) {
        final List<Amount> amounts = new ArrayList<>();
        final Amount amount = new Amount();
        amount.setCurrency(amountCurrency);
        amount.setValue(amountValue);
        amounts.add(amount);
        final Limit limit = new Limit();
        limit.setId(id);
        limit.setAmounts(amounts);
        return limit;
    }

    private Instalment newInstalment(String id, BigDecimal principalAmountValue, String principalAmountCurrency) {
        final Principal principal = new Principal();
        principal.setAmount(principalAmountValue);
        principal.setCurrency(principalAmountCurrency);
        final Instalment instalment = new Instalment();
        instalment.setId(id);
        instalment.setPrincipal(principal);
        return instalment;
    }

    private Indicator newIndicator(String id, Boolean isActive) {
        final Indicator indicator = new Indicator();
        indicator.setId(id);
        indicator.setIsActive(isActive);
        return indicator;
    }

    private Boolean stringToBoolean(String str) {
        return str == null ? null : "SI".equalsIgnoreCase(str) ? Boolean.TRUE : Boolean.FALSE;
    }
}
