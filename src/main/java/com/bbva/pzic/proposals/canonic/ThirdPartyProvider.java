package com.bbva.pzic.proposals.canonic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * Created on 10/05/2017.
 *
 * @author Entelgy
 */
@XmlRootElement(name = "ThirdPartyProvider", namespace = "urn:com:bbva:pzic:proposals:canonic")
@XmlType(name = "ThirdPartyProvider", namespace = "urn:com:bbva:pzic:proposals:canonic")
@XmlAccessorType(XmlAccessType.FIELD)
public class ThirdPartyProvider implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Third party provider identifier.
     */
    private String id;
    /**
     * Third party provider description.
     */
    private String name;
    /**
     * External sales channel of the third party provider that provides an
     * external product.
     */
    private ExternalSalesChannel externalSalesChannel;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ExternalSalesChannel getExternalSalesChannel() {
        return externalSalesChannel;
    }

    public void setExternalSalesChannel(
            ExternalSalesChannel externalSalesChannel) {
        this.externalSalesChannel = externalSalesChannel;
    }
}