package com.webprojteretana.WebProjTeretana2021.entity;
// sala (deo fitnes centra)
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;


@Entity
public class Sala implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long kapacitet;

    @Column(nullable = false)
    private String oznaka;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "nalazi",
            joinColumns = @JoinColumn(name = "sala_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "fitnescentar_id", referencedColumnName = "id"))
    private FitnesCentar salaFC;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "uSali",
            joinColumns = @JoinColumn(name = "sala_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "termin_id", referencedColumnName = "id"))
    private Set<Termin> terminiSala = new HashSet<>();




}
