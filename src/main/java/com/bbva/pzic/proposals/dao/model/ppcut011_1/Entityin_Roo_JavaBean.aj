// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.bbva.pzic.proposals.dao.model.ppcut011_1;

import com.bbva.pzic.proposals.dao.model.ppcut011_1.Entityin;
import com.bbva.pzic.proposals.dao.model.ppcut011_1.Participant;
import com.bbva.pzic.proposals.dao.model.ppcut011_1.Product;

privileged aspect Entityin_Roo_JavaBean {
    
    /**
     * Gets product value
     * 
     * @return Product
     */
    public Product Entityin.getProduct() {
        return this.product;
    }
    
    /**
     * Sets product value
     * 
     * @param product
     * @return Entityin
     */
    public Entityin Entityin.setProduct(Product product) {
        this.product = product;
        return this;
    }
    
    /**
     * Gets participant value
     * 
     * @return Participant
     */
    public Participant Entityin.getParticipant() {
        return this.participant;
    }
    
    /**
     * Sets participant value
     * 
     * @param participant
     * @return Entityin
     */
    public Entityin Entityin.setParticipant(Participant participant) {
        this.participant = participant;
        return this;
    }
    
}