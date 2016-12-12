package com.bbva.pzic.proposals.canonic;

import com.bbva.jee.arq.spring.core.servicing.utils.Pagination;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.List;

/**
 * @author Entelgy
 */
@XmlRootElement(name = "ProposalData", namespace = "urn:com:bbva:pzic:proposals:canonic")
@XmlType(name = "ProposalData", namespace = "urn:com:bbva:pzic:proposals:canonic")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProposalData implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Proposal> data;

    private Pagination pagination;

    public List<Proposal> getData() {
        return data;
    }

    public void setData(List<Proposal> data) {
        this.data = data;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }
}