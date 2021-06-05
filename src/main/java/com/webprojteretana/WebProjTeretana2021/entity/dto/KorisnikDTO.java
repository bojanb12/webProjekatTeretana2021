package com.webprojteretana.WebProjTeretana2021.entity.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class KorisnikDTO {

    private Long id;

    private String korisnickoIme;

    private String lozinka;

    private String ime;

    private String prezime;

    private String uloga;

    private String brojTel;

    private String email;

    private String adresa;

    private String datumRodjenja;

    private Boolean aktivan = true;

    public KorisnikDTO(){

    }

    public KorisnikDTO(Long id, String korisnickoIme, String lozinka, String ime,
                       String prezime, String uloga, String brojTel, String email,
                       String adresa, String datumRodjenja, Boolean aktivan) {
        this.id = id;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
        this.uloga = uloga;
        this.brojTel = brojTel;
        this.email = email;
        this.adresa = adresa;
        this.datumRodjenja = datumRodjenja;
        this.aktivan = aktivan;
    }

    public Long getId() {
        return id;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public String getUloga() {
        return uloga;
    }

    public String getBrojTel() {
        return brojTel;
    }

    public String getEmail() {
        return email;
    }

    public String getAdresa() {
        return adresa;
    }

    public String getDatumRodjenja() {
        return datumRodjenja;
    }

    public Boolean getAktivan() {
        return aktivan;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public void setUloga(String uloga) {
        this.uloga = uloga;
    }

    public void setBrojTel(String brojTel) {
        this.brojTel = brojTel;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public void setDatumRodjenja(String datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public void setAktivan(Boolean aktivan) {
        this.aktivan = aktivan;
    }

}
