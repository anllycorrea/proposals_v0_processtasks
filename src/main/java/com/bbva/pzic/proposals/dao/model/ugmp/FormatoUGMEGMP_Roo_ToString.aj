// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.bbva.pzic.proposals.dao.model.ugmp;

import java.lang.String;

privileged aspect FormatoUGMEGMP_Roo_ToString {
    
    public String FormatoUGMEGMP.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Indesta: ").append(getIndesta()).append(", ");
        sb.append("Mailcon: ").append(getMailcon()).append(", ");
        sb.append("Nrocont: ").append(getNrocont()).append(", ");
        sb.append("Tipenvi: ").append(getTipenvi());
        return sb.toString();
    }
    
}
