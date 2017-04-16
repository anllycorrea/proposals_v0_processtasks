package com.bbva.pzic.proposals.business.dto;


import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created on 12/04/2017.
 *
 * @author Entelgy
 */
public class DTOIntExternalFinancingProposal {

    @NotNull(groups = ValidationGroup.CreateExternalFinancingProposal.class)
    @Size(max = 3, groups = ValidationGroup.CreateExternalFinancingProposal.class)
    private String currency;
    @NotNull(groups = ValidationGroup.CreateExternalFinancingProposal.class)
    @Valid
    private DTOIntInitialAmount initialAmount;
    @NotNull(groups = ValidationGroup.CreateExternalFinancingProposal.class)
    @Valid
    private DTOIntTariff tariff;
    @Valid
    private DTOIntExternalProduct externalProduct;
    @NotNull(groups = ValidationGroup.CreateExternalFinancingProposal.class)
    @Valid
    private DTOIntOperation operation;
    @NotNull(groups = ValidationGroup.ModifyExternalFinancingProposal.class)
    @Valid
    private DTOIntStatus status;
    @NotNull(groups = ValidationGroup.CreateExternalFinancingProposal.class)
    @Digits(integer = 2, fraction = 0, groups = ValidationGroup.CreateExternalFinancingProposal.class)
    private Integer paymentDay;
    @NotNull(groups = ValidationGroup.CreateExternalFinancingProposal.class)
    @Valid
    private DTOIntThirdPartyProvider thirdPartyProvider;

    @NotNull(groups = ValidationGroup.CreateExternalFinancingProposal.class)
    private String documentTypeId;
    @NotNull(groups = ValidationGroup.CreateExternalFinancingProposal.class)
    @Size(max = 10, groups = ValidationGroup.CreateExternalFinancingProposal.class)
    private String documentNumber;

    @NotNull(groups = ValidationGroup.CreateExternalFinancingProposal.class)
    private String deliveryTypeId;
    @NotNull(groups = ValidationGroup.CreateExternalFinancingProposal.class)
    @Size(max = 50, groups = ValidationGroup.CreateExternalFinancingProposal.class)
    private String deliveryVirtualDestination;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public DTOIntInitialAmount getInitialAmount() {
        return initialAmount;
    }

    public void setInitialAmount(DTOIntInitialAmount initialAmount) {
        this.initialAmount = initialAmount;
    }

    public DTOIntTariff getTariff() {
        return tariff;
    }

    public void setTariff(DTOIntTariff tariff) {
        this.tariff = tariff;
    }

    public DTOIntExternalProduct getExternalProduct() {
        return externalProduct;
    }

    public void setExternalProduct(DTOIntExternalProduct externalProduct) {
        this.externalProduct = externalProduct;
    }

    public DTOIntOperation getOperation() {
        return operation;
    }

    public void setOperation(DTOIntOperation operation) {
        this.operation = operation;
    }

    public DTOIntStatus getStatus() {
        return status;
    }

    public void setStatus(DTOIntStatus status) {
        this.status = status;
    }

    public Integer getPaymentDay() {
        return paymentDay;
    }

    public void setPaymentDay(Integer paymentDay) {
        this.paymentDay = paymentDay;
    }

    public DTOIntThirdPartyProvider getThirdPartyProvider() {
        return thirdPartyProvider;
    }

    public void setThirdPartyProvider(
            DTOIntThirdPartyProvider thirdPartyProvider) {
        this.thirdPartyProvider = thirdPartyProvider;
    }

    public String getDocumentTypeId() {
        return documentTypeId;
    }

    public void setDocumentTypeId(String documentTypeId) {
        this.documentTypeId = documentTypeId;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getDeliveryTypeId() {
        return deliveryTypeId;
    }

    public void setDeliveryTypeId(String deliveryTypeId) {
        this.deliveryTypeId = deliveryTypeId;
    }

    public String getDeliveryVirtualDestination() {
        return deliveryVirtualDestination;
    }

    public void setDeliveryVirtualDestination(String deliveryVirtualDestination) {
        this.deliveryVirtualDestination = deliveryVirtualDestination;
    }
}