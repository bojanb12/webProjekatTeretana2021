package com.webprojteretana.WebProjTeretana2021.entity;
// Fitnes Centar (sadrzi sale, raspored treninga, i trenere koji treniraju)
import java.io.Serializable;
import javax.persistence.*;

@Entity
public class FitnesCentar {

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

}
