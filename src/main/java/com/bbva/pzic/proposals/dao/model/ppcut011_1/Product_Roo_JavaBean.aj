// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.bbva.pzic.proposals.dao.model.ppcut011_1;

import com.bbva.pzic.proposals.dao.model.ppcut011_1.Product;
import com.bbva.pzic.proposals.dao.model.ppcut011_1.Subproduct;

privileged aspect Product_Roo_JavaBean {
    
    /**
     * Gets id value
     * 
     * @return String
     */
    public String Product.getId() {
        return this.id;
    }
    
    /**
     * Sets id value
     * 
     * @param id
     * @return Product
     */
    public Product Product.setId(String id) {
        this.id = id;
        return this;
    }
    
    /**
     * Gets subproduct value
     * 
     * @return Subproduct
     */
    public Subproduct Product.getSubproduct() {
        return this.subproduct;
    }
    
    /**
     * Sets subproduct value
     * 
     * @param subproduct
     * @return Product
     */
    public Product Product.setSubproduct(Subproduct subproduct) {
        this.subproduct = subproduct;
        return this;
    }
    
}