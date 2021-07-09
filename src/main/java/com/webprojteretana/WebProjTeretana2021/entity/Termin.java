package com.webprojteretana.WebProjTeretana2021.entity;
// termin - povezuje salu i trening (u kojoj sali je koji trening)
import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Termin implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String vreme;

    @Column(nullable = false)
    private String dan;

    @Column(nullable = false)
    private String cena;

    @Column(nullable = false)
    private Integer slobodnihMesta;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Sala salaTermin;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Trening treningTermin;



    public Termin() {
    }

    public Termin(Long id, String vreme, String dan, String cena, Sala salaTermin, Trening treningTermin, Integer slobodnihMesta) {
        this.id = id;
        this.vreme = vreme;
        this.dan = dan;
        this.cena = cena;
        this.salaTermin = salaTermin;
        this.treningTermin = treningTermin;
        this.slobodnihMesta = slobodnihMesta;
    }

    public Termin(String vreme, String dan, String cena, Sala salaTermin, Trening treningTermin, Integer slobodnihMesta) {
        this.vreme = vreme;
        this.dan = dan;
        this.cena = cena;
        this.salaTermin = salaTermin;
        this.treningTermin = treningTermin;
        this.slobodnihMesta = slobodnihMesta;
    }

    public Termin(String vreme, String dan, String cena, Sala salaTermin) {
        this.vreme = vreme;
        this.dan = dan;
        this.cena = cena;
        this.salaTermin = salaTermin;
    }

    public Termin(Long id, String vreme, String dan, String cena) {
        this.id = id;
        this.vreme = vreme;
        this.dan = dan;
        this.cena = cena;
    }

    public Termin(String vreme, String dan, String cena, Sala salaTermin, Trening treningTermin) {
        this.vreme = vreme;
        this.dan = dan;
        this.cena = cena;
        this.salaTermin = salaTermin;
        this.treningTermin = treningTermin;
    }

    public Termin(Long id, String vreme, String dan, String cena, Sala salaTermin, Trening treningTermin) {
        this.id = id;
        this.vreme = vreme;
        this.dan = dan;
        this.cena = cena;
        this.salaTermin = salaTermin;
        this.treningTermin = treningTermin;
    }

    public Termin(String vreme, String dan, String cena, Integer slobodnihMesta) {
        this.vreme = vreme;
        this.dan = dan;
        this.cena = cena;
        this.slobodnihMesta = slobodnihMesta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVreme() {
        return vreme;
    }

    public void setVreme(String vreme) {
        this.vreme = vreme;
    }

    public String getDan() {
        return dan;
    }

    public void setDan(String dan) {
        this.dan = dan;
    }

    public String getCena() {
        return cena;
    }

    public void setCena(String cena) {
        this.cena = cena;
    }

    public Sala getSalaTermin() {
        return salaTermin;
    }

    public void setSalaTermin(Sala salaTermin) {
        this.salaTermin = salaTermin;
    }

    public Trening getTreningTermin() {
        return treningTermin;
    }

    public void setTreningTermin(Trening treningTermin) {
        this.treningTermin = treningTermin;
    }

    public Integer getSlobodnihMesta() {
        return slobodnihMesta;
    }

    public void setSlobodnihMesta(Integer slobodnihMesta) {
        this.slobodnihMesta = slobodnihMesta;
    }
}
