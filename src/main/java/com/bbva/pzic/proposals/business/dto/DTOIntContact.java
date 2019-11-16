package com.bbva.pzic.proposals.business.dto;

/**
 * Created on 15/11/2019.
 *
 * @author Entelgy
 */
public class DTOIntContact {

    private String contactDetailType;
    private String number;
    private DTOIntPhoneCompany phoneCompany;
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

    public DTOIntPhoneCompany getPhoneCompany() {
        return phoneCompany;
    }

    public void setPhoneCompany(DTOIntPhoneCompany phoneCompany) {
        this.phoneCompany = phoneCompany;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
