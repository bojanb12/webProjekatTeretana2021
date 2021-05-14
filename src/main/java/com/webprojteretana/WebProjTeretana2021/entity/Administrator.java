package com.webprojteretana.WebProjTeretana2021.entity;
// administrator (nasledjuje korisnika)
import javax.persistence.*;

@Entity
@DiscriminatorValue("admin")
public class Administrator extends Korisnik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Administrator(Long id) {
        this.id = id;
    }
}
