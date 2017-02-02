package com.bbva.pzic.proposals.canonic;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * @author Entelgy
 */
@XmlRootElement(name = "Instalment", namespace = "urn:com:bbva:pzic:proposals:canonic")
@XmlType(name = "Instalment", namespace = "urn:com:bbva:pzic:proposals:canonic")
@XmlAccessorType(XmlAccessType.FIELD)
public class Instalment implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Instalment identifier.
     */
    private String id;
    /**
     * Current instalment monetary amount.
     */
    @Valid
    private Principal principal;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Principal getPrincipal() {
        return principal;
    }

    public void setPrincipal(Principal principal) {
        this.principal = principal;
    }
}