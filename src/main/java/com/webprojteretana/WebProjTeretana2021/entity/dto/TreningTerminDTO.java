package com.webprojteretana.WebProjTeretana2021.entity.dto;

import com.webprojteretana.WebProjTeretana2021.entity.Sala;
import com.webprojteretana.WebProjTeretana2021.entity.Termin;
import com.webprojteretana.WebProjTeretana2021.entity.Trening;

public class TreningTerminDTO {

    private Long idTrening;

    private Long idTermin;

    private String naziv;
    private String opis;
    private String tipTreninga;
    private String trajanjeTreninga;
    private Termin terminTreninga;

    private String vreme;
    private String dan;
    private String cena;
    private Sala salaTermin;
    private Trening treningTermin;
    private Integer slobodnihMesta;

    public TreningTerminDTO(Long idTrening, Long idTermin) {
        this.idTrening = idTrening;
        this.idTermin = idTermin;
    }

    public TreningTerminDTO() {
    }

    public TreningTerminDTO(Long idTrening, Long idTermin, String naziv, String tipTreninga, String trajanjeTreninga, String vreme, String dan, String cena, Integer slobodnihMesta) {
        this.idTrening = idTrening;
        this.idTermin = idTermin;
        this.naziv = naziv;
        this.tipTreninga = tipTreninga;
        this.trajanjeTreninga = trajanjeTreninga;
        this.vreme = vreme;
        this.dan = dan;
        this.cena = cena;
        this.slobodnihMesta = slobodnihMesta;
    }

    public Long getIdTrening() {
        return idTrening;
    }

    public void setIdTrening(Long idTrening) {
        this.idTrening = idTrening;
    }

    public Long getIdTermin() {
        return idTermin;
    }

    public void setIdTermin(Long idTermin) {
        this.idTermin = idTermin;
    }
}
