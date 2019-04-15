package com.bbva.pzic.proposals.dao.model.simulateproposals;

import com.bbva.jee.arq.spring.core.servicing.gce.xml.instance.Message;

import java.util.List;

/**
 * Created on 28/12/2017.
 *
 * @author Entelgy
 */
public class SimulatedProposalsResponse {

    private List<Oferta> data;
    private List<Message> messages;

    public List<Oferta> getData() {
        return data;
    }

    public void setData(List<Oferta> data) {
        this.data = data;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
