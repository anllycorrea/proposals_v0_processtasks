package com.bbva.pzic.proposals.canonic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.List;

/**
 * Created on 12/04/2017.
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
    private String name;
    /**
     * Holder last name.
     */
    private String lastName;
    /**
     * Holder mother last name.
     */
    private String mohterLastName;
    /**
     * Holder contacts information.
     */
    private List<ContactsInformation> contactsInformation;
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

    public String getMohterLastName() {
        return mohterLastName;
    }

    public void setMohterLastName(String mohterLastName) {
        this.mohterLastName = mohterLastName;
    }

    public List<ContactsInformation> getContactsInformation() {
        return contactsInformation;
    }

    public void setContactsInformation(
            List<ContactsInformation> contactsInformation) {
        this.contactsInformation = contactsInformation;
    }

    public List<IdentityDocument> getIdentityDocuments() {
        return identityDocuments;
    }

    public void setIdentityDocuments(List<IdentityDocument> identityDocuments) {
        this.identityDocuments = identityDocuments;
    }
}