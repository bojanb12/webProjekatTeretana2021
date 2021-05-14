package com.webprojteretana.WebProjTeretana2021.entity;
// Fitnes Centar (sadrzi sale, raspored treninga, i trenere koji treniraju)
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

@Entity
public class FitnesCentar implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nazivFC;

    @Column(nullable = false)
    private String adresaFC;

    @Column(nullable = false)
    private String telefonFC;

    @Column(nullable = false)
    private String emailFC;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Trener> treneri = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Sala> sale = new HashSet<>();

}
