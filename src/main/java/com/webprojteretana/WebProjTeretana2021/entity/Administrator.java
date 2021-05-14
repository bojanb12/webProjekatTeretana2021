package com.webprojteretana.WebProjTeretana2021.entity;
// administrator (nasledjuje korisnika)
import javax.persistence.*;
import java.io.Serializable;

@Entity
@DiscriminatorValue("admin")
public class Administrator implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Administrator(Long id) {
        this.id = id;
    }
}
