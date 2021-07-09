package com.webprojteretana.WebProjTeretana2021.entity.dto;

public class FitnesCentarSalaDTO {

    private Long idFitnesCentar;

    private Long idSala;

    public FitnesCentarSalaDTO() {
    }

    public FitnesCentarSalaDTO(Long idFitnesCentar, Long idSala) {
        this.idFitnesCentar = idFitnesCentar;
        this.idSala = idSala;
    }

    public Long getIdFitnesCentar() {
        return idFitnesCentar;
    }

    public void setIdFitnesCentar(Long idFitnesCentar) {
        this.idFitnesCentar = idFitnesCentar;
    }

    public Long getIdSala() {
        return idSala;
    }

    public void setIdSala(Long idSala) {
        this.idSala = idSala;
    }
}
