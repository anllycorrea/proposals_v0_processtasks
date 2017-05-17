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
@XmlRootElement(name = "Links", namespace = "urn:com:bbva:pzic:proposals:canonic")
@XmlType(name = "Links", namespace = "urn:com:bbva:pzic:proposals:canonic")
@XmlAccessorType(XmlAccessType.FIELD)
public class Links implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * URI to the first page. It will be the URI to the list without paging
     * element.
     */
    private String first;
    /**
     * URI to the last page based on the current pagination configuration.
     */
    private String last;
    /**
     * URI to the previous page.
     */
    private String previous;
    /**
     * URI to the next page.
     */
    private String next;

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }
}