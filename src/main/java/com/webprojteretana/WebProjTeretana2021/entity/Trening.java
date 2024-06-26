package com.webprojteretana.WebProjTeretana2021.entity;
//trening
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

@Entity
public class Trening implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String naziv;

    @Column(nullable = false)
    private String opis;

    @Column(nullable = false)
    private String tipTreninga;

    @Column(nullable = false)
    private String trajanjeTreninga;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "odradili",
            joinColumns = @JoinColumn(name = "trening_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "clan_id", referencedColumnName = "id"))
    private Set<Clan> clanoviOdrTrening = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "prijavili",
            joinColumns = @JoinColumn(name = "trening_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "clan_id", referencedColumnName = "id"))
    private Set<Clan> prijavljeniClanovi = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "ocenili",
            joinColumns = @JoinColumn(name = "trening_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "ocena_id", referencedColumnName = "id"))
    private Set<Ocena> ocenaTreninga = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Trener trenerTreninga;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "ima_termine",
            joinColumns = @JoinColumn(name = "trening_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "termin_id", referencedColumnName = "id"))
    private Set<Termin> terminiTreninga = new HashSet<>();

    public Trening() {
    }

    public Trening(Long id, String naziv, String opis, String tipTreninga, String trajanjeTreninga) {
        this.id = id;
        this.naziv = naziv;
        this.opis = opis;
        this.tipTreninga = tipTreninga;
        this.trajanjeTreninga = trajanjeTreninga;
    }

    public Trening(String naziv, String opis, String tipTreninga, String trajanjeTreninga) {
        this.naziv = naziv;
        this.opis = opis;
        this.tipTreninga = tipTreninga;
        this.trajanjeTreninga = trajanjeTreninga;
    }
    //geteri i seteri:

    public Long getId() {
        return id;
    }

    public String getNaziv() {
        return naziv;
    }

    public String getOpis() {
        return opis;
    }

    public String getTipTreninga() {
        return tipTreninga;
    }

    public String getTrajanjeTreninga() {
        return trajanjeTreninga;
    }

    public Set<Clan> getClanoviOdrTrening() {
        return clanoviOdrTrening;
    }

    public Set<Clan> getPrijavljeniClanovi() {
        return prijavljeniClanovi;
    }

    public Set<Ocena> getOcenaTreninga() {
        return ocenaTreninga;
    }

    public Trener getTrenerTreninga() {
        return trenerTreninga;
    }



    public void setId(Long id) {
        this.id = id;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public void setTipTreninga(String tipTreninga) {
        this.tipTreninga = tipTreninga;
    }

    public void setTrajanjeTreninga(String trajanjeTreninga) {
        this.trajanjeTreninga = trajanjeTreninga;
    }

    public void setClanoviOdrTrening(Set<Clan> clanoviOdrTrening) {
        this.clanoviOdrTrening = clanoviOdrTrening;
    }

    public void setPrijavljeniClanovi(Set<Clan> prijavljeniClanovi) {
        this.prijavljeniClanovi = prijavljeniClanovi;
    }

    public void setOcenaTreninga(Set<Ocena> ocenaTreninga) {
        this.ocenaTreninga = ocenaTreninga;
    }

    public void setTrenerTreninga(Trener trenerTreninga) {
        this.trenerTreninga = trenerTreninga;
    }

    public Set<Termin> getTerminiTreninga() {
        return terminiTreninga;
    }

    public void setTerminiTreninga(Set<Termin> terminiTreninga) {
        this.terminiTreninga = terminiTreninga;
    }

    public Trening(Long id, String naziv, String opis, String tipTreninga, String trajanjeTreninga, Set<Termin> terminiTreninga) {
        this.id = id;
        this.naziv = naziv;
        this.opis = opis;
        this.tipTreninga = tipTreninga;
        this.trajanjeTreninga = trajanjeTreninga;
        this.terminiTreninga = terminiTreninga;
    }

    public Trening(String naziv, String opis, String tipTreninga, String trajanjeTreninga, Set<Termin> terminiTreninga) {
        this.naziv = naziv;
        this.opis = opis;
        this.tipTreninga = tipTreninga;
        this.trajanjeTreninga = trajanjeTreninga;
        this.terminiTreninga = terminiTreninga;
    }
}
