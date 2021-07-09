package com.webprojteretana.WebProjTeretana2021.service;

import com.webprojteretana.WebProjTeretana2021.entity.Clan;
import com.webprojteretana.WebProjTeretana2021.entity.FitnesCentar;
import com.webprojteretana.WebProjTeretana2021.entity.Sala;

import java.util.List;
import java.util.Set;

public interface FitnesCentarService {


    FitnesCentar create(FitnesCentar fitnesCentar) throws Exception;

    List<FitnesCentar> findAll();

    FitnesCentar update(FitnesCentar fitnesCentar) throws  Exception;

    FitnesCentar findOne(Long id);

    void dodajSalu(Long idFC, Sala sala);

    void delete(Long id);

    void obrisiSalu(Long idFC, Long idSale);



}
