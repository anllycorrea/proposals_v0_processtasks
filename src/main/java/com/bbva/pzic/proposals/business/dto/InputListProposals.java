package com.bbva.pzic.proposals.business.dto;



/**
 * Created on 28/12/2017.
 * 
 * @author Entelgy
 */
public class InputListProposals {

	private String participantIdentityDocumentDocumentTypeId;
	private String participantIdentityDocumentDocumentNumber;
	private String customerId;

	public String getParticipantIdentityDocumentDocumentTypeId() {
		return participantIdentityDocumentDocumentTypeId;
	}

	public void setParticipantIdentityDocumentDocumentTypeId(
			String participantIdentityDocumentDocumentTypeId) {
		this.participantIdentityDocumentDocumentTypeId = participantIdentityDocumentDocumentTypeId;
	}

	public String getParticipantIdentityDocumentDocumentNumber() {
		return participantIdentityDocumentDocumentNumber;
	}

	public void setParticipantIdentityDocumentDocumentNumber(
			String participantIdentityDocumentDocumentNumber) {
		this.participantIdentityDocumentDocumentNumber = participantIdentityDocumentDocumentNumber;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
}