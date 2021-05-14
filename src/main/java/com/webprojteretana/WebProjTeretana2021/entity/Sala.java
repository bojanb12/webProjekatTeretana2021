package com.webprojteretana.WebProjTeretana2021.entity;
// sala (deo fitnes centra)
import java.io.Serializable;
import javax.persistence.*;


// DA LI DA SALA NASLEDJUJE FITNES CENTAR??

@Entity
public class Sala implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long kapacitet;

    @Column(nullable = false)
    private String oznaka;

}
