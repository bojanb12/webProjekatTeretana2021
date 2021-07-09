package com.webprojteretana.WebProjTeretana2021.entity.dto;

import com.webprojteretana.WebProjTeretana2021.entity.Sala;
import com.webprojteretana.WebProjTeretana2021.entity.Trening;

import javax.persistence.*;

public class TerminDTO {

    private Long id;
    private String vreme;
    private String dan;
    private String cena;
    private Sala salaTermin;
    private Trening treningTermin;
    private Integer slobodnihMesta;

    public TerminDTO() {
    }

    public TerminDTO(Long id, String vreme, String dan, String cena, Sala salaTermin, Trening treningTermin) {
        this.id = id;
        this.vreme = vreme;
        this.dan = dan;
        this.cena = cena;
        this.salaTermin = salaTermin;
        this.treningTermin = treningTermin;
    }

    public TerminDTO(String vreme, String dan, String cena, Sala salaTermin, Trening treningTermin) {
        this.vreme = vreme;
        this.dan = dan;
        this.cena = cena;
        this.salaTermin = salaTermin;
        this.treningTermin = treningTermin;
    }

    public TerminDTO(String vreme, String dan, String cena, Sala salaTermin, Trening treningTermin, Integer slobodnihMesta) {
        this.vreme = vreme;
        this.dan = dan;
        this.cena = cena;
        this.salaTermin = salaTermin;
        this.treningTermin = treningTermin;
    }

    public TerminDTO(Long id, String vreme, String dan, String cena) {
        this.id = id;
        this.vreme = vreme;
        this.dan = dan;
        this.cena = cena;
    }

    public TerminDTO(String vreme, String dan, String cena) {
        this.vreme = vreme;
        this.dan = dan;
        this.cena = cena;
    }

    public TerminDTO(Long id, String vreme, String dan, String cena, Sala salaTermin, Trening treningTermin, Integer slobodnihMesta) {
        this.id = id;
        this.vreme = vreme;
        this.dan = dan;
        this.cena = cena;
        this.salaTermin = salaTermin;
        this.treningTermin = treningTermin;
        this.slobodnihMesta = slobodnihMesta;
    }

    public TerminDTO(Long id, String vreme, String dan, String cena, Integer slobodnihMesta) {
        this.id = id;
        this.vreme = vreme;
        this.dan = dan;
        this.cena = cena;
        this.slobodnihMesta = slobodnihMesta;
    }

    public TerminDTO(String vreme, String dan, String cena, Integer slobodnihMesta) {
        this.vreme = vreme;
        this.dan = dan;
        this.cena = cena;
        this.slobodnihMesta = slobodnihMesta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVreme() {
        return vreme;
    }

    public void setVreme(String vreme) {
        this.vreme = vreme;
    }

    public String getDan() {
        return dan;
    }

    public void setDan(String dan) {
        this.dan = dan;
    }

    public String getCena() {
        return cena;
    }

    public void setCena(String cena) {
        this.cena = cena;
    }

    public Sala getSalaTermin() {
        return salaTermin;
    }

    public void setSalaTermin(Sala salaTermin) {
        this.salaTermin = salaTermin;
    }

    public Trening getTreningTermin() {
        return treningTermin;
    }

    public void setTreningTermin(Trening treningTermin) {
        this.treningTermin = treningTermin;
    }

    public Integer getSlobodnihMesta() {
        return slobodnihMesta;
    }

    public void setSlobodnihMesta(Integer slobodnihMesta) {
        this.slobodnihMesta = slobodnihMesta;
    }
}
