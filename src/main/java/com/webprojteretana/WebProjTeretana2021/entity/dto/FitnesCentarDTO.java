package com.webprojteretana.WebProjTeretana2021.entity.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class FitnesCentarDTO {


    private Long id;
    private String nazivFC;
    private String adresaFC;
    private String telefonFC;
    private String emailFC;

    public FitnesCentarDTO() {
    }

    public FitnesCentarDTO(Long id, String nazivFC, String adresaFC, String telefonFC, String emailFC) {
        this.id = id;
        this.nazivFC = nazivFC;
        this.adresaFC = adresaFC;
        this.telefonFC = telefonFC;
        this.emailFC = emailFC;
    }

    public FitnesCentarDTO(String nazivFC, String adresaFC, String telefonFC, String emailFC) {
        this.nazivFC = nazivFC;
        this.adresaFC = adresaFC;
        this.telefonFC = telefonFC;
        this.emailFC = emailFC;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazivFC() {
        return nazivFC;
    }

    public void setNazivFC(String nazivFC) {
        this.nazivFC = nazivFC;
    }

    public String getAdresaFC() {
        return adresaFC;
    }

    public void setAdresaFC(String adresaFC) {
        this.adresaFC = adresaFC;
    }

    public String getTelefonFC() {
        return telefonFC;
    }

    public void setTelefonFC(String telefonFC) {
        this.telefonFC = telefonFC;
    }

    public String getEmailFC() {
        return emailFC;
    }

    public void setEmailFC(String emailFC) {
        this.emailFC = emailFC;
    }
}
