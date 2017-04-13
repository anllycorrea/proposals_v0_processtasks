package com.bbva.pzic.proposals.business.dto;


import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.Valid;

/**
 * Created on 12/04/2017.
 * 
 * @author Entelgy
 */
public class DTOIntHolder {

	private String name;
	private String lastName;
	private String mohterLastName;
	@NotNull(groups = ValidationGroup.CreateExternalFinancingProposal.class)
	@Size(groups = ValidationGroup.CreateExternalFinancingProposal.class, min = 1)
	@Valid
	private List<DTOIntContactsInformation> contactsInformation;
	@NotNull(groups = ValidationGroup.CreateExternalFinancingProposal.class)
	@Size(groups = ValidationGroup.CreateExternalFinancingProposal.class, min = 1)
	@Valid
	private List<DTOIntIdentityDocument> identityDocuments;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMohterLastName() {
		return mohterLastName;
	}

	public void setMohterLastName(String mohterLastName) {
		this.mohterLastName = mohterLastName;
	}

	public List<DTOIntContactsInformation> getContactsInformation() {
		return contactsInformation;
	}

	public void setContactsInformation(
			List<DTOIntContactsInformation> contactsInformation) {
		this.contactsInformation = contactsInformation;
	}

	public List<DTOIntIdentityDocument> getIdentityDocuments() {
		return identityDocuments;
	}

	public void setIdentityDocuments(
			List<DTOIntIdentityDocument> identityDocuments) {
		this.identityDocuments = identityDocuments;
	}
}