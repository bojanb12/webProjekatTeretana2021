package com.webprojteretana.WebProjTeretana2021.entity;
//trener (nasledjuje korisnika)
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

@Entity
public class Trener extends Korisnik{

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


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "drzi_trening",
            joinColumns = @JoinColumn(name = "trener_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "trening_id", referencedColumnName = "id"))
    private Set<Trening> treninziKojeDrzi = new HashSet<>();

    @Column(nullable = false)
    private Long prosecnaOcena;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private FitnesCentar fitnesCentarTrenera;
}
