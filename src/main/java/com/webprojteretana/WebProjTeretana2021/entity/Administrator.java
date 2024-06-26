package com.webprojteretana.WebProjTeretana2021.entity;
// administrator (nasledjuje korisnika)
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("admin")
public class Administrator implements Serializable{

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
    private String brojTel;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String adresa;

    @Column(nullable = false)
    private String datumRodjenja;

    //@Column(nullable = false)
    //private Boolean aktivan;

    @Column(nullable = false)
    private String uloga;

    public Administrator() {
    }

    public Administrator(Long id, String korisnickoIme, String lozinka, String ime, String prezime, String brojTel, String email, String adresa, String datumRodjenja, String uloga) {
        this.id = id;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
        this.brojTel = brojTel;
        this.email = email;
        this.adresa = adresa;
        this.datumRodjenja = datumRodjenja;
        this.uloga = uloga;
    }

    public Administrator(String korisnickoIme, String lozinka, String ime, String prezime, String brojTel, String email, String adresa, String datumRodjenja, String uloga) {
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
        this.brojTel = brojTel;
        this.email = email;
        this.adresa = adresa;
        this.datumRodjenja = datumRodjenja;
        this.uloga = uloga;
    }
    //geteri i seteri:


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

    public String getUloga() {
        return uloga;
    }

    public void setUloga(String uloga) {
        this.uloga = uloga;
    }
}
