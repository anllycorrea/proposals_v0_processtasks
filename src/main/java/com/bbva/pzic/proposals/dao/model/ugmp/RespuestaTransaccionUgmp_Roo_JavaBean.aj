// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.bbva.pzic.proposals.dao.model.ugmp;

import com.bbva.jee.arq.spring.core.host.CuerpoMultiparte;
import com.bbva.pzic.proposals.dao.model.ugmp.RespuestaTransaccionUgmp;

privileged aspect RespuestaTransaccionUgmp_Roo_JavaBean {
    
    /**
     * Gets codigoRetorno value
     * 
     * @return String
     */
    public String RespuestaTransaccionUgmp.getCodigoRetorno() {
        return this.codigoRetorno;
    }
    
    /**
     * Sets codigoRetorno value
     * 
     * @param codigoRetorno
     * @return RespuestaTransaccionUgmp
     */
    public RespuestaTransaccionUgmp RespuestaTransaccionUgmp.setCodigoRetorno(String codigoRetorno) {
        this.codigoRetorno = codigoRetorno;
        return this;
    }
    
    /**
     * Gets codigoControl value
     * 
     * @return String
     */
    public String RespuestaTransaccionUgmp.getCodigoControl() {
        return this.codigoControl;
    }
    
    /**
     * Sets codigoControl value
     * 
     * @param codigoControl
     * @return RespuestaTransaccionUgmp
     */
    public RespuestaTransaccionUgmp RespuestaTransaccionUgmp.setCodigoControl(String codigoControl) {
        this.codigoControl = codigoControl;
        return this;
    }
    
    /**
     * Sets cuerpo value
     * 
     * @param cuerpo
     * @return RespuestaTransaccionUgmp
     */
    public RespuestaTransaccionUgmp RespuestaTransaccionUgmp.setCuerpo(CuerpoMultiparte cuerpo) {
        this.cuerpo = cuerpo;
        return this;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return String
     */
    public String RespuestaTransaccionUgmp.toString() {
        return "RespuestaTransaccionUgmp {" + 
                "codigoRetorno='" + codigoRetorno + '\'' + 
                ", codigoControl='" + codigoControl + '\'' + "}" + super.toString();
    }
    
}
