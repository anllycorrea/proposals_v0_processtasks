package com.bbva.pzic.proposals.business.dto;


import com.bbva.pzic.proposals.canonic.Proposal;

import java.util.List;

/**
 * Created on 28/12/2017.
 * 
 * @author Entelgy
 */
public class DTOIntProposals {

	private List<Proposal> data;

	public List<Proposal> getData() {
		return data;
	}

	public void setData(List<Proposal> data) {
		this.data = data;
	}
}