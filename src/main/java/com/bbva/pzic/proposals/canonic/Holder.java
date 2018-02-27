package com.bbva.pzic.proposals.canonic;

import com.bbva.jee.arq.spring.core.auditoria.DatoAuditable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.List;

/**
 * Created on 10/05/2017.
 *
 * @author Entelgy
 */
@XmlRootElement(name = "Holder", namespace = "urn:com:bbva:pzic:proposals:canonic")
@XmlType(name = "Holder", namespace = "urn:com:bbva:pzic:proposals:canonic")
@XmlAccessorType(XmlAccessType.FIELD)
public class Holder implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Holder name.
     */
    @DatoAuditable(omitir = true)
    private String name;
    /**
     * Holder last name.
     */
    @DatoAuditable(omitir = true)
    private String lastName;
    /**
     * Holder mother last name.
     */
    @DatoAuditable(omitir = true)
    private String motherLastName;
    /**
     * Holder identity document.
     */
    private List<IdentityDocument> identityDocuments;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMotherLastName() {
        return motherLastName;
    }

    public void setMotherLastName(String motherLastName) {
        this.motherLastName = motherLastName;
    }

    public List<IdentityDocument> getIdentityDocuments() {
        return identityDocuments;
    }

    public void setIdentityDocuments(List<IdentityDocument> identityDocuments) {
        this.identityDocuments = identityDocuments;
    }
}