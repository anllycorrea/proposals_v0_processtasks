package com.bbva.pzic.proposals.canonic;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.List;

/**
 * @author Entelgy
 */
@XmlRootElement(name = "Limit", namespace = "urn:com:bbva:pzic:proposals:canonic")
@XmlType(name = "Limit", namespace = "urn:com:bbva:pzic:proposals:canonic")
@XmlAccessorType(XmlAccessType.FIELD)
public class Limit implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Limit identifier.
     */
    private String limitId;
    /**
     * Limit localized description.
     */
    private String name;
    /**
     * Monetary restriction related to the current limit. This amount may be
     * provided in several currencies (depending on the country).
     */
    @Valid
    private List<AmountLimit> amountLimits;

    public String getLimitId() {
        return limitId;
    }

    public void setLimitId(String limitId) {
        this.limitId = limitId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AmountLimit> getAmountLimits() {
        return amountLimits;
    }

    public void setAmountLimits(List<AmountLimit> amountLimits) {
        this.amountLimits = amountLimits;
    }
}