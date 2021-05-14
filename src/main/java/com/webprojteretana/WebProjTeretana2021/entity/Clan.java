package com.webprojteretana.WebProjTeretana2021.entity;
// clan (nasledjuje korisnika)
import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Clan extends Korisnik{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
