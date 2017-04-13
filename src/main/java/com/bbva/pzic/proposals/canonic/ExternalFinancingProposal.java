package com.bbva.pzic.proposals.canonic;

import com.bbva.jee.arq.spring.core.servicing.utils.ShortDateAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.util.Date;

/**
 * Created on 12/04/2017.
 *
 * @author Entelgy
 */
@XmlRootElement(name = "ExternalFinancingProposal", namespace = "urn:com:bbva:pzic:proposals:canonic")
@XmlType(name = "ExternalFinancingProposal", namespace = "urn:com:bbva:pzic:proposals:canonic")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExternalFinancingProposal implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Identifier of the external financing proposal.
     */
    private String id;
    /**
     * Request date of the external financing proposal.
     */
    @XmlSchemaType(name = "date")
    @XmlJavaTypeAdapter(ShortDateAdapter.class)
    private Date requestDate;
    /**
     * Disbursement date of the external financing proposal.
     */
    @XmlSchemaType(name = "date")
    @XmlJavaTypeAdapter(ShortDateAdapter.class)
    private Date openingDate;
    /**
     * String based on ISO-4217 for specifying the currency related to the
     * external financing proposal.
     */
    private String currency;
    /**
     * Initial fee of the external financing proposal.
     */
    private InitialFee initialFee;
    /**
     * Initial amount financed.
     */
    private InitialAmount initialAmount;
    /**
     * Applied tariff to the external financing proposal.
     */
    private Tariff tariff;
    /**
     * Product related to the external financing proposal.
     */
    private RelatedProduct relatedProduct;
    /**
     * Documentation delivery type related to the external financing proposal.
     */
    private DocumentationDeliveryType documentationDeliveryType;
    /**
     * Financed external product.
     */
    private ExternalProduct externalProduct;
    /**
     * Holder related with the external financing proposal.
     */
    private Holder holder;
    /**
     * Operation related to the external financing proposal.
     */
    private Operation operation;
    /**
     * Status of the external financing proposal.
     */
    private Status status;
    /**
     * Day of the calendar that the payment of the quota must be made.
     */
    private Integer paymentDay;
    /**
     * Third party provider that provides a external product.
     */
    private ThirdPartyProvider thirdPartyProvider;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(Date openingDate) {
        this.openingDate = openingDate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public InitialFee getInitialFee() {
        return initialFee;
    }

    public void setInitialFee(InitialFee initialFee) {
        this.initialFee = initialFee;
    }

    public InitialAmount getInitialAmount() {
        return initialAmount;
    }

    public void setInitialAmount(InitialAmount initialAmount) {
        this.initialAmount = initialAmount;
    }

    public Tariff getTariff() {
        return tariff;
    }

    public void setTariff(Tariff tariff) {
        this.tariff = tariff;
    }

    public RelatedProduct getRelatedProduct() {
        return relatedProduct;
    }

    public void setRelatedProduct(RelatedProduct relatedProduct) {
        this.relatedProduct = relatedProduct;
    }

    public DocumentationDeliveryType getDocumentationDeliveryType() {
        return documentationDeliveryType;
    }

    public void setDocumentationDeliveryType(
            DocumentationDeliveryType documentationDeliveryType) {
        this.documentationDeliveryType = documentationDeliveryType;
    }

    public ExternalProduct getExternalProduct() {
        return externalProduct;
    }

    public void setExternalProduct(ExternalProduct externalProduct) {
        this.externalProduct = externalProduct;
    }

    public Holder getHolder() {
        return holder;
    }

    public void setHolder(Holder holder) {
        this.holder = holder;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Integer getPaymentDay() {
        return paymentDay;
    }

    public void setPaymentDay(Integer paymentDay) {
        this.paymentDay = paymentDay;
    }

    public ThirdPartyProvider getThirdPartyProvider() {
        return thirdPartyProvider;
    }

    public void setThirdPartyProvider(ThirdPartyProvider thirdPartyProvider) {
        this.thirdPartyProvider = thirdPartyProvider;
    }
}