// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.bbva.pzic.proposals.dao.model.ugap;

import java.lang.String;

privileged aspect FormatoUGMEGAP_Roo_ToString {
    
    public String FormatoUGMEGAP.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cocliex: ").append(getCocliex()).append(", ");
        sb.append("Codbien: ").append(getCodbien()).append(", ");
        sb.append("Codcnc: ").append(getCodcnc()).append(", ");
        sb.append("Codemp: ").append(getCodemp()).append(", ");
        sb.append("Codofic: ").append(getCodofic()).append(", ");
        sb.append("Codtr: ").append(getCodtr()).append(", ");
        sb.append("Diafact: ").append(getDiafact()).append(", ");
        sb.append("Diapago: ").append(getDiapago()).append(", ");
        sb.append("Idtoken: ").append(getIdtoken()).append(", ");
        sb.append("Impbien: ").append(getImpbien()).append(", ");
        sb.append("Impfina: ").append(getImpfina()).append(", ");
        sb.append("Mailcon: ").append(getMailcon()).append(", ");
        sb.append("Moneda: ").append(getMoneda()).append(", ");
        sb.append("Nrodocu: ").append(getNrodocu()).append(", ");
        sb.append("Tarifa: ").append(getTarifa()).append(", ");
        sb.append("Tipdocu: ").append(getTipdocu()).append(", ");
        sb.append("Tipenvi: ").append(getTipenvi());
        return sb.toString();
    }
    
}
