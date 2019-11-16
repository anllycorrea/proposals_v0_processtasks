package com.bbva.pzic.proposals.facade.v0.dto;

import com.bbva.jee.arq.spring.core.auditoria.DatoAuditable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * @author Entelgy
 */
@XmlRootElement(name = "identityDocument", namespace = "urn:com:bbva:pzic:proposals:facade:v0:dto")
@XmlType(name = "identityDocument", namespace = "urn:com:bbva:pzic:proposals:facade:v0:dto")
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
    @DatoAuditable(omitir = true)
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
