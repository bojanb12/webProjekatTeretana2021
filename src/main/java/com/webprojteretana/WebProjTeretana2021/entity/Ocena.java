package com.webprojteretana.WebProjTeretana2021.entity;
// ocene koje clanovi daju za treninge,
// preko treninga se vidi koji trener je drzao trening,
// tako da se treneri zapravo ocenjuju od strane clanova

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Ocena implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String komentarOcena;

    @Column(nullable = false)
    private Long vrednostOcene;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Trening treningZaKojiJeOcena;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Clan clanDaoOcenu;

    //getteri i setteri:

    public Long getId() {
        return id;
    }

    public String getKomentarOcena() {
        return komentarOcena;
    }

    public Long getVrednostOcene() {
        return vrednostOcene;
    }

    public Trening getTreningZaKojiJeOcena() {
        return treningZaKojiJeOcena;
    }

    public Clan getClanDaoOcenu() {
        return clanDaoOcenu;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setKomentarOcena(String komentarOcena) {
        this.komentarOcena = komentarOcena;
    }

    public void setVrednostOcene(Long vrednostOcene) {
        this.vrednostOcene = vrednostOcene;
    }

    public void setTreningZaKojiJeOcena(Trening treningZaKojiJeOcena) {
        this.treningZaKojiJeOcena = treningZaKojiJeOcena;
    }

    public void setClanDaoOcenu(Clan clanDaoOcenu) {
        this.clanDaoOcenu = clanDaoOcenu;
    }
}
