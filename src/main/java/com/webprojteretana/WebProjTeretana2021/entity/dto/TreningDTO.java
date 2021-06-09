package com.webprojteretana.WebProjTeretana2021.entity.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class TreningDTO {


    private Long id;
    private String naziv;
    private String opis;
    private String tipTreninga;
    private String trajanjeTreninga;

    public TreningDTO() {
    }

    public TreningDTO(Long id, String naziv, String opis, String tipTreninga, String trajanjeTreninga) {
        this.id = id;
        this.naziv = naziv;
        this.opis = opis;
        this.tipTreninga = tipTreninga;
        this.trajanjeTreninga = trajanjeTreninga;
    }

    public TreningDTO(String naziv, String opis, String tipTreninga, String trajanjeTreninga) {
        this.naziv = naziv;
        this.opis = opis;
        this.tipTreninga = tipTreninga;
        this.trajanjeTreninga = trajanjeTreninga;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getTipTreninga() {
        return tipTreninga;
    }

    public void setTipTreninga(String tipTreninga) {
        this.tipTreninga = tipTreninga;
    }

    public String getTrajanjeTreninga() {
        return trajanjeTreninga;
    }

    public void setTrajanjeTreninga(String trajanjeTreninga) {
        this.trajanjeTreninga = trajanjeTreninga;
    }
}
