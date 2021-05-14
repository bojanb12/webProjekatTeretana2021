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
    private List<Trening> odradjeniTreninzi = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Trening> prijavljeniTreninzi = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Ocena> oceneOdradjenihTreninga = new ArrayList<>();
}
