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

    //da li cena da bude u terminu ili u treningu???
    //treba staviti u prikazu treninga da se izlistaju i termini
    @Column(nullable = false)
    private String cena;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Sala salaTermin;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Trening treningTermin;

    //geteri i seteri:

    public Long getId() {
        return id;
    }

    public String getVreme() {
        return vreme;
    }

    public String getDan() {
        return dan;
    }

    public Sala getSalaTermin() {
        return salaTermin;
    }

    public Trening getTreningTermin() {
        return treningTermin;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setVreme(String vreme) {
        this.vreme = vreme;
    }

    public void setDan(String dan) {
        this.dan = dan;
    }

    public void setSalaTermin(Sala salaTermin) {
        this.salaTermin = salaTermin;
    }

    public void setTreningTermin(Trening treningTermin) {
        this.treningTermin = treningTermin;
    }
}
