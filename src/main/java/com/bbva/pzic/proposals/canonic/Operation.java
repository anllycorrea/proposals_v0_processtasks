package com.bbva.pzic.proposals.canonic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * Created on 12/04/2017.
 *
 * @author Entelgy
 */
@XmlRootElement(name = "Operation", namespace = "urn:com:bbva:pzic:proposals:canonic")
@XmlType(name = "Operation", namespace = "urn:com:bbva:pzic:proposals:canonic")
@XmlAccessorType(XmlAccessType.FIELD)
public class Operation implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Identifier of the operation that allows an intercompany relationship.
     */
    private String id;
    /**
     * Operation type to obtain an external product.
     */
    private OperationType operationType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }
}