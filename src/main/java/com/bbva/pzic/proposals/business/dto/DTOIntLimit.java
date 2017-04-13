package com.bbva.pzic.proposals.business.dto;


import java.util.List;
import javax.validation.Valid;

/**
 * Created on 12/04/2017.
 * 
 * @author Entelgy
 */
public class DTOIntLimit {

	private String id;
	private String name;
	@Valid
	private List<DTOIntAmount> amounts;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<DTOIntAmount> getAmounts() {
		return amounts;
	}

	public void setAmounts(List<DTOIntAmount> amounts) {
		this.amounts = amounts;
	}
}