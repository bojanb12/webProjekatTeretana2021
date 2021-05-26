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
    @JoinTable(name = "odrzavajuTreninge",
            joinColumns = @JoinColumn(name = "fitnescentar_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "trener_id", referencedColumnName = "id"))
    private Set<Trener> treneri = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Sala> sale = new HashSet<>();

    //geteri i seteri:

    public Long getId() {
        return id;
    }

    public String getNazivFC() {
        return nazivFC;
    }

    public String getAdresaFC() {
        return adresaFC;
    }

    public String getTelefonFC() {
        return telefonFC;
    }

    public String getEmailFC() {
        return emailFC;
    }

    public Set<Trener> getTreneri() {
        return treneri;
    }

    public Set<Sala> getSale() {
        return sale;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNazivFC(String nazivFC) {
        this.nazivFC = nazivFC;
    }

    public void setAdresaFC(String adresaFC) {
        this.adresaFC = adresaFC;
    }

    public void setTelefonFC(String telefonFC) {
        this.telefonFC = telefonFC;
    }

    public void setEmailFC(String emailFC) {
        this.emailFC = emailFC;
    }

    public void setTreneri(Set<Trener> treneri) {
        this.treneri = treneri;
    }

    public void setSale(Set<Sala> sale) {
        this.sale = sale;
    }

}
