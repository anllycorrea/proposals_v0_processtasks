package com.bbva.pzic.proposals.dao.model.listProposals;

import java.util.List;

/**
 * Created on 31/01/2017.
 *
 * @author Entelgy
 */
public class FormatProposalData {

    private List<FormatProposal> listaOfertas;
    private String idPagin;
    private String tampagi;

    public List<FormatProposal> getListaOfertas() {
        return listaOfertas;
    }

    public void setListaOfertas(List<FormatProposal> listaOfertas) {
        this.listaOfertas = listaOfertas;
    }

    public String getIdPagin() {
        return idPagin;
    }

    public void setIdPagin(String idPagin) {
        this.idPagin = idPagin;
    }

    public String getTampagi() {
        return tampagi;
    }

    public void setTampagi(String tampagi) {
        this.tampagi = tampagi;
    }
}
