package com.webprojteretana.WebProjTeretana2021.entity;
// clan (nasledjuje korisnika)
import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



@Entity
@DiscriminatorValue("clan")
public class Clan extends Korisnik{
    public Clan() {
    }

    public Clan(String korisnickoIme, String lozinka, String ime, String prezime, String uloga, String brojTel, String email, String adresa, String datumRodjenja) {
        super(korisnickoIme, lozinka, ime, prezime, uloga, brojTel, email, adresa, datumRodjenja);
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "odradio_trening",
            joinColumns = @JoinColumn(name = "clan_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "trening_id", referencedColumnName = "id"))
    private Set<Trening> odradjeniTreninzi = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "prijavio_trening",
            joinColumns = @JoinColumn(name = "clan_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "trening_id", referencedColumnName = "id"))
    private Set<Trening> prijavljeniTreninzi = new HashSet<>();


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "daje_ocenu",
            joinColumns = @JoinColumn(name = "clan_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "ocena_id", referencedColumnName = "id"))
    private Set<Ocena> oceneOdrTreninga = new HashSet<>();

//geteri i seteri:

    public void setOdradjeniTreninzi(Set<Trening> odradjeniTreninzi) {
        this.odradjeniTreninzi = odradjeniTreninzi;
    }

    public void setPrijavljeniTreninzi(Set<Trening> prijavljeniTreninzi) {
        this.prijavljeniTreninzi = prijavljeniTreninzi;
    }

    public void setOceneOdrTreninga(Set<Ocena> oceneOdrTreninga) {
        this.oceneOdrTreninga = oceneOdrTreninga;
    }

    public Set<Trening> getOdradjeniTreninzi() {
        return odradjeniTreninzi;
    }

    public Set<Trening> getPrijavljeniTreninzi() {
        return prijavljeniTreninzi;
    }

    public Set<Ocena> getOceneOdrTreninga() {
        return oceneOdrTreninga;
    }
}
