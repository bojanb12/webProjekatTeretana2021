package com.webprojteretana.WebProjTeretana2021.entity;
// termin - povezuje salu i trening (u kojoj sali je koji trening)
import java.io.Serializable;
import javax.persistence.*;
public class Termin implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String vreme;

    @Column(nullable = false)
    private String dan;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "održavaSeU",
            joinColumns = @JoinColumn(name = "sala_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "termin_id", referencedColumnName = "id"))
    private Sala salaTermin;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "terminTreninga",
            joinColumns = @JoinColumn(name = "sala_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "trening_id", referencedColumnName = "id"))
    private Trening treningTermin;
}
