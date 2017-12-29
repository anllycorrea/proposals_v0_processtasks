package com.bbva.pzic.proposals.dao.model.simulateproposals;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created on 28/12/2017.
 *
 * @author Entelgy
 */
public class SimulatedProposalRequest {

    private String customerId;
    private String documentType;
    private String documentNumber;
    private List<ProductClassification> productClassifications;
    private BigDecimal codPlazoSel;
    private String tipplazoSel;
    private BigDecimal valCuotaSel;
    private BigDecimal valMontoSel;
    private BigDecimal tasaSel;
    private String codProductoSel;
    private String divisa;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public List<ProductClassification> getProductClassifications() {
        return productClassifications;
    }

    public void setProductClassifications(List<ProductClassification> productClassifications) {
        this.productClassifications = productClassifications;
    }

    public BigDecimal getCodPlazoSel() {
        return codPlazoSel;
    }

    public void setCodPlazoSel(BigDecimal codPlazoSel) {
        this.codPlazoSel = codPlazoSel;
    }

    public String getTipplazoSel() {
        return tipplazoSel;
    }

    public void setTipplazoSel(String tipplazoSel) {
        this.tipplazoSel = tipplazoSel;
    }

    public BigDecimal getValCuotaSel() {
        return valCuotaSel;
    }

    public void setValCuotaSel(BigDecimal valCuotaSel) {
        this.valCuotaSel = valCuotaSel;
    }

    public BigDecimal getValMontoSel() {
        return valMontoSel;
    }

    public void setValMontoSel(BigDecimal valMontoSel) {
        this.valMontoSel = valMontoSel;
    }

    public BigDecimal getTasaSel() {
        return tasaSel;
    }

    public void setTasaSel(BigDecimal tasaSel) {
        this.tasaSel = tasaSel;
    }

    public String getCodProductoSel() {
        return codProductoSel;
    }

    public void setCodProductoSel(String codProductoSel) {
        this.codProductoSel = codProductoSel;
    }

    public String getDivisa() {
        return divisa;
    }

    public void setDivisa(String divisa) {
        this.divisa = divisa;
    }
}
