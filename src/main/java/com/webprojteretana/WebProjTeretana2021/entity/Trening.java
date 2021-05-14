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
}
