package com.webprojteretana.WebProjTeretana2021.entity;
// ocene koje clanovi daju za treninge,
// preko treninga se vidi koji trener je drzao trening,
// tako da se treneri zapravo ocenjuju od strane clanova

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Ocena implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String komentarOcena;

    @Column(nullable = false)
    private Long vrednostOcene;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Trening treningZaKojiJeOcena;

    //dodati clana koji je dao ocenu
}
