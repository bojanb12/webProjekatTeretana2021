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
public class Clan extends Korisnik{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "odradio trening",
            joinColumns = @JoinColumn(name = "clan_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "trening_id", referencedColumnName = "id"))
    private Set<Trening> odradjeniTreninzi = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "prijavio trening",
            joinColumns = @JoinColumn(name = "clan_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "trening_id", referencedColumnName = "id"))
    private Set<Trening> prijavljeniTreninzi = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "daje ocenu",
            joinColumns = @JoinColumn(name = "clan_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "ocena_id", referencedColumnName = "id"))
    private Set<Ocena> oceneOdrTreninga = new HashSet<>();
}
