package com.bbva.pzic.proposals.facade.v01.mapper.impl;

import com.bbva.pzic.proposals.business.dto.DTOInputListExternalFinancingProposals;
import com.bbva.pzic.proposals.business.dto.DTOOutExternalFinancingProposalData;
import com.bbva.pzic.proposals.canonic.ExternalFinancingProposalData;
import com.bbva.pzic.proposals.facade.v01.mapper.IListExternalFinancingProposalsMapper;
import com.bbva.pzic.proposals.util.mappers.EnumMapper;
import com.bbva.pzic.proposals.util.mappers.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created on 12/04/2017.
 * 
 * @author Entelgy
 */
@Mapper("listExternalFinancingProposalsMapper")
public class ListExternalFinancingProposalsMapper implements IListExternalFinancingProposalsMapper {
	@Autowired
	private EnumMapper enumMapper;

	/**
	 * @see com.bbva.pzic.proposals.facade.v01.mapper.IListExternalFinancingProposalsMapper#mapIn(String, String, String, String, String, String, Long)
	 */
	@Override
	public DTOInputListExternalFinancingProposals mapIn(final String thirdPartyProviderId, final String holderIdentityDocumentsDocumentTypeId,
														final String holderIdentityDocumentsDocumentNumber, final String fromRequestDate,
														final String toRequestDate, final String paginationKey, final Long pageSize) {
		DTOInputListExternalFinancingProposals dtoIn = new DTOInputListExternalFinancingProposals();
		dtoIn.setThirdPartyProviderId(thirdPartyProviderId);
		dtoIn.setHolderIdentityDocumentsDocumentTypeId(enumMapper.getBackendValue("documentType.id",holderIdentityDocumentsDocumentTypeId));
		dtoIn.setHolderIdentityDocumentsDocumentNumber(holderIdentityDocumentsDocumentNumber);
		dtoIn.setFromRequestDate(fromRequestDate);
		dtoIn.setToRequestDate(toRequestDate);
		dtoIn.setPaginationKey(paginationKey);
		dtoIn.setPageSize(pageSize);

		return dtoIn;
	}

	/**
	 * @see com.bbva.pzic.proposals.facade.v01.mapper.IListExternalFinancingProposalsMapper#mapOut(com.bbva.pzic.proposals.business.dto.DTOOutExternalFinancingProposalData)
	 */
	@Override
	public ExternalFinancingProposalData mapOut(final DTOOutExternalFinancingProposalData dto) {
		if (dto.getData()==null || dto.getData().isEmpty()){
			return null;
		}
		ExternalFinancingProposalData  data = new ExternalFinancingProposalData();
		data.setData(dto.getData());
		return data;
	}
}