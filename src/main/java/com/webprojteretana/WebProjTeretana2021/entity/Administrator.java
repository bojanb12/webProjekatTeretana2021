package com.webprojteretana.WebProjTeretana2021.entity;
// administrator (nasledjuje korisnika)
import java.io.Serializable;
import javax.persistence.*;

@Entity
@DiscriminatorValue("admin")
public class Administrator extends Korisnik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
