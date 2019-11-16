package com.bbva.pzic.proposals.facade.v0.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * @author Entelgy
 */
@XmlRootElement(name = "contact", namespace = "urn:com:bbva:pzic:proposals:facade:v0:dto")
@XmlType(name = "contact", namespace = "urn:com:bbva:pzic:proposals:facade:v0:dto")
@XmlAccessorType(XmlAccessType.FIELD)
public class Contact implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Contact information type.
     */
    private String contactDetailType;
    /**
     * Contact mobile number. This value will be masked when basic
     * authentication state. If the authentication state is advanced the
     * value will be clear.
     */
    private String number;
    /**
     * Contact vendor information.
     */
    private PhoneCompany phoneCompany;
    /**
     * Customer email address. This value will be masked when basic
     * authentication state. If the authentication state is advanced the
     * value will be clear.
     */
    private String address;

    public String getContactDetailType() {
        return contactDetailType;
    }

    public void setContactDetailType(String contactDetailType) {
        this.contactDetailType = contactDetailType;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public PhoneCompany getPhoneCompany() {
        return phoneCompany;
    }

    public void setPhoneCompany(PhoneCompany phoneCompany) {
        this.phoneCompany = phoneCompany;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
