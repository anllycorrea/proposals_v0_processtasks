package com.bbva.pzic.proposals.canonic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * Created on 13/04/2017.
 *
 * @author Entelgy
 */
@XmlRootElement(name = "Delivery", namespace = "urn:com:bbva:pzic:proposals:canonic")
@XmlType(name = "Delivery", namespace = "urn:com:bbva:pzic:proposals:canonic")
@XmlAccessorType(XmlAccessType.FIELD)
public class Delivery implements Serializable {

    private static final long serialVersionUID = 1L;

    private DeliveryType deliveryType;

    private String virtualDestination;

    public DeliveryType getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(DeliveryType deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String getVirtualDestination() {
        return virtualDestination;
    }

    public void setVirtualDestination(String virtualDestination) {
        this.virtualDestination = virtualDestination;
    }
}
