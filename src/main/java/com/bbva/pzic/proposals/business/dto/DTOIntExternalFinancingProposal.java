package com.bbva.pzic.proposals.business.dto;


import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.Valid;

/**
 * Created on 12/04/2017.
 * 
 * @author Entelgy
 */
public class DTOIntExternalFinancingProposal {

	private String id;
	private Date requestDate;
	private Date openingDate;
	@NotNull(groups = ValidationGroup.CreateExternalFinancingProposal.class)
	private String currency;
	@Valid
	private DTOIntInitialFee initialFee;
	@NotNull(groups = ValidationGroup.CreateExternalFinancingProposal.class)
	@Valid
	private DTOIntInitialAmount initialAmount;
	@NotNull(groups = ValidationGroup.CreateExternalFinancingProposal.class)
	@Valid
	private DTOIntTariff tariff;
	@Valid
	private DTOIntRelatedProduct relatedProduct;
	@NotNull(groups = ValidationGroup.CreateExternalFinancingProposal.class)
	@Valid
	private DTOIntDocumentationDeliveryType documentationDeliveryType;
	@Valid
	private DTOIntExternalProduct externalProduct;
	@NotNull(groups = ValidationGroup.CreateExternalFinancingProposal.class)
	@Valid
	private DTOIntHolder holder;
	@NotNull(groups = ValidationGroup.CreateExternalFinancingProposal.class)
	@Valid
	private DTOIntOperation operation;
	@NotNull(groups = ValidationGroup.ModifyExternalFinancingProposal.class)
	@Valid
	private DTOIntStatus status;
	@NotNull(groups = ValidationGroup.CreateExternalFinancingProposal.class)
	private Integer paymentDay;
	@NotNull(groups = ValidationGroup.CreateExternalFinancingProposal.class)
	@Valid
	private DTOIntThirdPartyProvider thirdPartyProvider;

	private String documentTypeId;
	private String documentNumber;

	private String deliveryTypeId;
	private String deliveryVirtualDestination;

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

	public DTOIntInitialFee getInitialFee() {
		return initialFee;
	}

	public void setInitialFee(DTOIntInitialFee initialFee) {
		this.initialFee = initialFee;
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

	public DTOIntRelatedProduct getRelatedProduct() {
		return relatedProduct;
	}

	public void setRelatedProduct(DTOIntRelatedProduct relatedProduct) {
		this.relatedProduct = relatedProduct;
	}

	public DTOIntDocumentationDeliveryType getDocumentationDeliveryType() {
		return documentationDeliveryType;
	}

	public void setDocumentationDeliveryType(
			DTOIntDocumentationDeliveryType documentationDeliveryType) {
		this.documentationDeliveryType = documentationDeliveryType;
	}

	public DTOIntExternalProduct getExternalProduct() {
		return externalProduct;
	}

	public void setExternalProduct(DTOIntExternalProduct externalProduct) {
		this.externalProduct = externalProduct;
	}

	public DTOIntHolder getHolder() {
		return holder;
	}

	public void setHolder(DTOIntHolder holder) {
		this.holder = holder;
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