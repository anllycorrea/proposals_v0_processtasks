// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.bbva.pzic.proposals.dao.model.uglp;

import java.lang.String;

privileged aspect FormatoUGMSGLP2_Roo_ToString {
    
    public String FormatoUGMSGLP2.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Idpagin: ").append(getIdpagin()).append(", ");
        sb.append("Tampagi: ").append(getTampagi());
        return sb.toString();
    }
    
}