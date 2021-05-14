package com.webprojteretana.WebProjTeretana2021.entity;
//trener (nasledjuje korisnika)
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Trener extends Korisnik{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Trening> treninziKojeDrzi = new ArrayList<>();
}
