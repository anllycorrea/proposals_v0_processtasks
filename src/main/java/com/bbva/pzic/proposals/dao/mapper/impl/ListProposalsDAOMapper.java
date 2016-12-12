package com.bbva.pzic.proposals.dao.mapper.impl;

import com.bbva.pzic.proposals.business.dto.DTOInputListProposals;
import com.bbva.pzic.proposals.dao.mapper.IListProposalsDAOMapper;
import com.bbva.pzic.proposals.facade.v01.ISrvProposalsV01;
import com.bbva.pzic.proposals.util.mappers.EnumMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * Created on 06/12/2016.
 *
 * @author Entelgy
 */
@Component
public class ListProposalsDAOMapper implements IListProposalsDAOMapper {

    private static final Log LOG = LogFactory.getLog(ListProposalsDAOMapper.class);

    @Autowired
    private EnumMapper enumMapper;

    /**
     * @see IListProposalsDAOMapper#mapInput(DTOInputListProposals)
     */
    @Override
    public HashMap<String, String> mapInput(DTOInputListProposals dtoInputListProposals) {
        LOG.info("... called method ListProposalsDAOMapper.mapInput ...");
        HashMap<String, String> map = new HashMap<String, String>();
        map.put(ISrvProposalsV01.DOCUMENT_TYPE, enumMapper.getBackendValue("documentType.id", dtoInputListProposals.getDocumentType()));
        map.put(ISrvProposalsV01.DOCUMENT_NUMBER, dtoInputListProposals.getDocumentNumber());
        if (dtoInputListProposals.getProductClassification() != null) {
            map.put(ISrvProposalsV01.PRODUCT_CLASSIFICATION, enumMapper.getBackendValue("product.productClassification.id", dtoInputListProposals.getProductClassification()));
        }
        map.put(ISrvProposalsV01.PAGINATION_KEY, dtoInputListProposals.getPaginationKey());
        if (dtoInputListProposals.getPageSize() != null) {
            map.put(ISrvProposalsV01.PAGE_SIZE, dtoInputListProposals.getPageSize().toString());
        }
        return map;
    }

}
