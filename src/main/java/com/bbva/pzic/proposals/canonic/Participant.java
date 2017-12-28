package com.bbva.pzic.proposals.canonic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * @author Entelgy
 */
@XmlRootElement(name = "participant", namespace = "urn:com:bbva:pzic:proposals:canonic")
@XmlType(name = "participant", namespace = "urn:com:bbva:pzic:proposals:canonic")
@XmlAccessorType(XmlAccessType.FIELD)
public class Participant implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * Identifier for the participant. DISCLAIMER: This field is required only
	 * if identityDocument is not used.
	 */
	private String id;
	/**
	 * Identity document number of the participant.
	 */
	private IdentityDocument identityDocument;
	/**
	 * Segment where the person belongs for Risks area.
	 */
	private String segmentationCode;
	/**
	 * Risk Level for the person. It is used as input to assign an interest rate
	 * for the product of the proposal. For example, if the person has a low
	 * risk level, he or she is able to get a better interest rate than other
	 * person that has a high risk level.
	 */
	private RiskLevel riskLevel;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public IdentityDocument getIdentityDocument() {
		return identityDocument;
	}

	public void setIdentityDocument(IdentityDocument identityDocument) {
		this.identityDocument = identityDocument;
	}

	public String getSegmentationCode() {
		return segmentationCode;
	}

	public void setSegmentationCode(String segmentationCode) {
		this.segmentationCode = segmentationCode;
	}

	public RiskLevel getRiskLevel() {
		return riskLevel;
	}

	public void setRiskLevel(RiskLevel riskLevel) {
		this.riskLevel = riskLevel;
	}
}