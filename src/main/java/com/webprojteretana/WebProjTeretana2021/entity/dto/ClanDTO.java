package com.webprojteretana.WebProjTeretana2021.entity.dto;

public class ClanDTO {

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

    public ClanDTO() {

    }

    public ClanDTO(String korisnickoIme, String lozinka, String ime, String prezime, String uloga, String brojTel, String email, String adresa, String datumRodjenja, Boolean aktivan) {
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

    public ClanDTO(String korisnickoIme, String lozinka, String ime, String prezime, String uloga, String brojTel, String email, String adresa, String datumRodjenja) {
    }

    public ClanDTO(Long id, String korisnickoIme, String lozinka, String ime, String prezime, String uloga, String brojTel, String email, String adresa, String datumRodjenja) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getUloga() {
        return uloga;
    }

    public void setUloga(String uloga) {
        this.uloga = uloga;
    }

    public String getBrojTel() {
        return brojTel;
    }

    public void setBrojTel(String brojTel) {
        this.brojTel = brojTel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(String datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public Boolean getAktivan() {
        return aktivan;
    }

    public void setAktivan(Boolean aktivan) {
        this.aktivan = aktivan;
    }
}
