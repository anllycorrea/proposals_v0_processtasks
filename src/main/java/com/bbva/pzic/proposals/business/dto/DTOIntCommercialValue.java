package com.bbva.pzic.proposals.business.dto;


import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

/**
 * Created on 12/04/2017.
 *
 * @author Entelgy
 */
public class DTOIntCommercialValue {
    @NotNull(groups = ValidationGroup.CreateExternalFinancingProposal.class)
    @Digits(integer = 15, fraction = 2, groups = ValidationGroup.CreateExternalFinancingProposal.class)
    private BigDecimal amount;
    @NotNull(groups = ValidationGroup.CreateExternalFinancingProposal.class)
    @Size(max = 3, groups = ValidationGroup.CreateExternalFinancingProposal.class)
    private String currency;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}