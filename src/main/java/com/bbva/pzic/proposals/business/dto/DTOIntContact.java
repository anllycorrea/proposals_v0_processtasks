package com.bbva.pzic.proposals.business.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created on 15/11/2019.
 *
 * @author Entelgy
 */
public class DTOIntContact {

    @NotNull(groups = ValidationGroup.CreateQuestionnairesValidateAccess.class)
    private String contactDetailType;
    @NotNull(groups = ValidationGroup.CreateQuestionnairesValidateAccessMobile.class)
    private String number;
    @Valid
    private DTOIntPhoneCompany phoneCompany;
    @NotNull(groups = ValidationGroup.CreateQuestionnairesValidateAccessEmail.class)
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
