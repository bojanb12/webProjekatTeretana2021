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

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Sala salaTermin;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Trening treningTermin;
}
