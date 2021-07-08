package com.webprojteretana.WebProjTeretana2021.entity.dto;

import com.webprojteretana.WebProjTeretana2021.entity.FitnesCentar;

import javax.persistence.*;

public class SalaDTO {


    private Long id;
    private Long kapacitet;
    private String oznaka;
    private FitnesCentar salaFC;


    public SalaDTO(Long id, Long kapacitet, String oznaka, FitnesCentar salaFC) {
        this.id = id;
        this.kapacitet = kapacitet;
        this.oznaka = oznaka;
        this.salaFC = salaFC;
    }

    public SalaDTO() {
    }

    public SalaDTO(Long kapacitet, String oznaka, FitnesCentar salaFC) {
        this.kapacitet = kapacitet;
        this.oznaka = oznaka;
        this.salaFC = salaFC;
    }

    public SalaDTO(Long kapacitet, String oznaka) {
        this.kapacitet = kapacitet;
        this.oznaka = oznaka;
    }

    public SalaDTO(Long id, Long kapacitet, String oznaka) {
        this.id = id;
        this.kapacitet = kapacitet;
        this.oznaka = oznaka;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getKapacitet() {
        return kapacitet;
    }

    public void setKapacitet(Long kapacitet) {
        this.kapacitet = kapacitet;
    }

    public String getOznaka() {
        return oznaka;
    }

    public void setOznaka(String oznaka) {
        this.oznaka = oznaka;
    }

    public FitnesCentar getSalaFC() {
        return salaFC;
    }

    public void setSalaFC(FitnesCentar salaFC) {
        this.salaFC = salaFC;
    }
}
