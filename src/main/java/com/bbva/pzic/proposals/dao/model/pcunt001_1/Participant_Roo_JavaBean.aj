// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.bbva.pzic.proposals.dao.model.pcunt001_1;

import com.bbva.pzic.proposals.dao.model.pcunt001_1.Contacts;
import com.bbva.pzic.proposals.dao.model.pcunt001_1.Identitydocument;
import com.bbva.pzic.proposals.dao.model.pcunt001_1.Participant;
import java.util.List;

privileged aspect Participant_Roo_JavaBean {
    
    /**
     * Gets id value
     * 
     * @return String
     */
    public String Participant.getId() {
        return this.id;
    }
    
    /**
     * Sets id value
     * 
     * @param id
     * @return Participant
     */
    public Participant Participant.setId(String id) {
        this.id = id;
        return this;
    }
    
    /**
     * Gets identitydocument value
     * 
     * @return Identitydocument
     */
    public Identitydocument Participant.getIdentitydocument() {
        return this.identitydocument;
    }
    
    /**
     * Sets identitydocument value
     * 
     * @param identitydocument
     * @return Participant
     */
    public Participant Participant.setIdentitydocument(Identitydocument identitydocument) {
        this.identitydocument = identitydocument;
        return this;
    }
    
    /**
     * Gets contacts value
     * 
     * @return List
     */
    public List<Contacts> Participant.getContacts() {
        return this.contacts;
    }
    
    /**
     * Sets contacts value
     * 
     * @param contacts
     * @return Participant
     */
    public Participant Participant.setContacts(List<Contacts> contacts) {
        this.contacts = contacts;
        return this;
    }
    
}
