package com.bbva.pzic.proposals.dao.impl;

import com.bbva.pzic.proposals.business.dto.DTOOutListProposals;
import com.bbva.pzic.proposals.dao.IListProposalsDAO;
import com.bbva.pzic.proposals.dao.mapper.IProposalsDAOMapper;
import com.bbva.pzic.proposals.util.connection.rest.RestGetConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created on 06/12/2016.
 *
 * @author Entelgy
 */
@Repository
public class ListProposalsDAO extends RestGetConnection<DTOOutListProposals> implements IListProposalsDAO {

    @Autowired
    private IProposalsDAOMapper mapper;


}
