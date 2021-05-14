package com.webprojteretana.WebProjTeretana2021.entity;
// korisnik
import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Korisnik implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String korisnickoIme;

    @Column(nullable = false)
    private String lozinka;

    @Column(nullable = false)
    private String ime;

    @Column(nullable = false)
    private String prezime;

    @Column(nullable = false)
    private String uloga;

    @Column(nullable = false)
    private String brojTel;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String adresa;

    @Column(nullable = false)
    private String datumRodjenja;


//konstruktori:

    public Korisnik() {
    }

    public Korisnik(long id, String korisnickoIme, String lozinka, String ime, String prezime, String uloga, String brojTel, String email, String adresa, String datumRodjenja) {
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
    }

//geteri:

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

//seteri:

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
}

