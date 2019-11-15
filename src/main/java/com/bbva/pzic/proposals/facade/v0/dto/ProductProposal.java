package com.bbva.pzic.proposals.facade.v0.dto;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.io.Serializable;

/**
 * @author Entelgy
 */
@XmlRootElement(name = "productProposal", namespace = "urn:com:bbva:pzic:proposals:facade:v0:dto")
@XmlType(name = "productProposal", namespace = "urn:com:bbva:pzic:proposals:facade:v0:dto")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductProposal implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * Product identifier.
	 */
	private String id;
	/**
	 * Contains the subproduct related to a product.
	 */
	private SubproductProposal subproduct;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public SubproductProposal getSubproduct() {
		return subproduct;
	}

	public void setSubproduct(SubproductProposal subproduct) {
		this.subproduct = subproduct;
	}
}