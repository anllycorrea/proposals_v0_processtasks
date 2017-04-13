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
@XmlRootElement(name = "IdentityDocument", namespace = "urn:com:bbva:pzic:proposals:canonic")
@XmlType(name = "IdentityDocument", namespace = "urn:com:bbva:pzic:proposals:canonic")
@XmlAccessorType(XmlAccessType.FIELD)
public class IdentityDocument implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Identity document type.
     */
    private DocumentType documentType;
    /**
     * Identity document number.
     */
    private String documentNumber;

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }
}