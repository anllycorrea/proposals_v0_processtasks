package com.bbva.pzic.proposals.canonic;

import com.bbva.jee.arq.spring.core.servicing.utils.Pagination;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.List;

/**
 * Created on 13/04/2017.
 *
 * @author Entelgy
 */
@XmlRootElement(name = "ExternalFinancingProposalData", namespace = "urn:com:bbva:pzic:proposals:canonic")
@XmlType(name = "ExternalFinancingProposalData", namespace = "urn:com:bbva:pzic:proposals:canonic")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExternalFinancingProposalData implements Serializable {

    private static final long serialVersionUID = 1L;
    private List<ExternalFinancingProposal> data;
    private Pagination pagination;

    public List<ExternalFinancingProposal> getData() {
        return data;
    }

    public void setData(List<ExternalFinancingProposal> data) {
        this.data = data;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }
}
