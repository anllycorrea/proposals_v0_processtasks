package com.bbva.pzic.proposals.dao.model.simulateproposals;

import java.util.List;

/**
 * Created on 28/12/2017.
 *
 * @author Entelgy
 */
public class SimulatedProposalsResponse {

    private List<Oferta> listaOfertas;

    public List<Oferta> getListaOfertas() {
        return listaOfertas;
    }

    public void setListaOfertas(List<Oferta> listaOfertas) {
        this.listaOfertas = listaOfertas;
    }
}
