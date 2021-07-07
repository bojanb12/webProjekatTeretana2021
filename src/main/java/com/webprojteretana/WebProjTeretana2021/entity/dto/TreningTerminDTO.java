package com.webprojteretana.WebProjTeretana2021.entity.dto;

public class TreningTerminDTO {

    private Long idTrening;

    private Long idTermin;

    public TreningTerminDTO(Long idTrening, Long idTermin) {
        this.idTrening = idTrening;
        this.idTermin = idTermin;
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
