package com.bbva.pzic.proposals.business.dto;



/**
 * Created on 28/12/2017.
 * 
 * @author Entelgy
 */
public class DTOIntParticipant {

	private String id;
	private DTOIntIdentityDocument identityDocument;
	private String segmentationCode;
	private DTOIntRiskLevel riskLevel;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public DTOIntIdentityDocument getIdentityDocument() {
		return identityDocument;
	}

	public void setIdentityDocument(DTOIntIdentityDocument identityDocument) {
		this.identityDocument = identityDocument;
	}

	public String getSegmentationCode() {
		return segmentationCode;
	}

	public void setSegmentationCode(String segmentationCode) {
		this.segmentationCode = segmentationCode;
	}

	public DTOIntRiskLevel getRiskLevel() {
		return riskLevel;
	}

	public void setRiskLevel(DTOIntRiskLevel riskLevel) {
		this.riskLevel = riskLevel;
	}
}