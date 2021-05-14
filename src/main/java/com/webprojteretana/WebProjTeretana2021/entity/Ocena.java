package com.webprojteretana.WebProjTeretana2021.entity;
// ocene koje treneri dobijaju od strane korisnika
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
}
