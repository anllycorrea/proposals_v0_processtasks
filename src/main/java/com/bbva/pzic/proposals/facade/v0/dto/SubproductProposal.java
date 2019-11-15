package com.bbva.pzic.proposals.facade.v0.dto;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.io.Serializable;

/**
 * @author Entelgy
 */
@XmlRootElement(name = "subproductProposal", namespace = "urn:com:bbva:pzic:proposals:facade:v0:dto")
@XmlType(name = "subproductProposal", namespace = "urn:com:bbva:pzic:proposals:facade:v0:dto")
@XmlAccessorType(XmlAccessType.FIELD)
public class SubproductProposal implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * Subproduct identifier. Flow to be followed according to the type of
	 * subproduct that is being requested (agreements, refinanced, among
	 * others).
	 */
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}