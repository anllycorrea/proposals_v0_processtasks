package com.bbva.pzic.proposals.business.dto;


import javax.validation.Valid;
import java.math.BigDecimal;

/**
 * Created on 12/04/2017.
 *
 * @author Entelgy
 */
public class DTOIntRelatedProduct {

    private BigDecimal percentage;
    @Valid
    private DTOIntRelatedProductType relatedProductType;

    public BigDecimal getPercentage() {
        return percentage;
    }

    public void setPercentage(BigDecimal percentage) {
        this.percentage = percentage;
    }

    public DTOIntRelatedProductType getRelatedProductType() {
        return relatedProductType;
    }

    public void setRelatedProductType(
            DTOIntRelatedProductType relatedProductType) {
        this.relatedProductType = relatedProductType;
    }
}