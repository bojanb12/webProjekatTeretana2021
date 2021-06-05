package com.webprojteretana.WebProjTeretana2021.entity;
//trener (nasledjuje korisnika)
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

@Entity
@DiscriminatorValue("trener")
public class Trener extends Korisnik{

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

    //geteri i seteri:

    @Override
    public Long getId() {
        return id;
    }

    public Set<Trening> getTreninziKojeDrzi() {
        return treninziKojeDrzi;
    }

    public Long getProsecnaOcena() {
        return prosecnaOcena;
    }

    public FitnesCentar getFitnesCentarTrenera() {
        return fitnesCentarTrenera;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public void setTreninziKojeDrzi(Set<Trening> treninziKojeDrzi) {
        this.treninziKojeDrzi = treninziKojeDrzi;
    }

    public void setProsecnaOcena(Long prosecnaOcena) {
        this.prosecnaOcena = prosecnaOcena;
    }

    public void setFitnesCentarTrenera(FitnesCentar fitnesCentarTrenera) {
        this.fitnesCentarTrenera = fitnesCentarTrenera;
    }
}
