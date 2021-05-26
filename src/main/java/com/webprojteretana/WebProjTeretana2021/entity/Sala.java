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


    //geter i seteri:

    public Long getId() {
        return id;
    }

    public Long getKapacitet() {
        return kapacitet;
    }

    public String getOznaka() {
        return oznaka;
    }

    public FitnesCentar getSalaFC() {
        return salaFC;
    }

    public Set<Termin> getTerminiSala() {
        return terminiSala;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setKapacitet(Long kapacitet) {
        this.kapacitet = kapacitet;
    }

    public void setOznaka(String oznaka) {
        this.oznaka = oznaka;
    }

    public void setSalaFC(FitnesCentar salaFC) {
        this.salaFC = salaFC;
    }

    public void setTerminiSala(Set<Termin> terminiSala) {
        this.terminiSala = terminiSala;
    }

}
