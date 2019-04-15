package com.bbva.pzic.proposals.business.dto;


/**
 * Created on 28/12/2017.
 *
 * @author Entelgy
 */
public class DTOIntProduct {

    private DTOIntProductClassification productClassification;
    private DTOIntTitle title;

    public DTOIntProductClassification getProductClassification() {
        return productClassification;
    }

    public void setProductClassification(
            DTOIntProductClassification productClassification) {
        this.productClassification = productClassification;
    }

    public DTOIntTitle getTitle() {
        return title;
    }

    public void setTitle(DTOIntTitle title) {
        this.title = title;
    }
}