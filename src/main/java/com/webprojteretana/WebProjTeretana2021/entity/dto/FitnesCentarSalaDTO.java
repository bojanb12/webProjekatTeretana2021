package com.webprojteretana.WebProjTeretana2021.entity.dto;

import com.webprojteretana.WebProjTeretana2021.entity.FitnesCentar;

public class FitnesCentarSalaDTO {

    private Long idFitnesCentar;

    private Long idSala;

    private String nazivFC;
    private String adresaFC;
    private String telefonFC;
    private String emailFC;

    private Long kapacitet;
    private String oznaka;
    private FitnesCentar salaFC;

    public FitnesCentarSalaDTO() {
    }

    public FitnesCentarSalaDTO(Long idFitnesCentar, Long idSala) {
        this.idFitnesCentar = idFitnesCentar;
        this.idSala = idSala;
    }

    public FitnesCentarSalaDTO(Long idFitnesCentar, Long idSala, String nazivFC, String adresaFC, String telefonFC, String emailFC, Long kapacitet, String oznaka) {
        this.idFitnesCentar = idFitnesCentar;
        this.idSala = idSala;
        this.nazivFC = nazivFC;
        this.adresaFC = adresaFC;
        this.telefonFC = telefonFC;
        this.emailFC = emailFC;
        this.kapacitet = kapacitet;
        this.oznaka = oznaka;
    }

    public Long getIdFitnesCentar() {
        return idFitnesCentar;
    }

    public void setIdFitnesCentar(Long idFitnesCentar) {
        this.idFitnesCentar = idFitnesCentar;
    }

    public Long getIdSala() {
        return idSala;
    }

    public void setIdSala(Long idSala) {
        this.idSala = idSala;
    }
}
