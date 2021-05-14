package com.webprojteretana.WebProjTeretana2021.entity;
//trening
import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Trening implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String naziv;

    @Column(nullable = false)
    private String opis;

    @Column(nullable = false)
    private String tipTreninga;

    @Column(nullable = false)
    private String trajanjeTreninga;
}
