package com.webprojteretana.WebProjTeretana2021.entity;
//trener (nasledjuje korisnika)
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

@Entity
public class Trener implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
