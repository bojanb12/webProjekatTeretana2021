package com.webprojteretana.WebProjTeretana2021.service;

import com.webprojteretana.WebProjTeretana2021.entity.Sala;
import com.webprojteretana.WebProjTeretana2021.entity.Termin;
import com.webprojteretana.WebProjTeretana2021.entity.Trener;
import com.webprojteretana.WebProjTeretana2021.entity.Trening;

import java.util.List;

public interface TreningService {

    Trening create(Trening trening) throws Exception;

    List<Trening> findAll();

    Trening update(Trening trening) throws  Exception;

    Trening findOne(Long id);

    void dodajTermin(Long idTrening, Termin termin);

}
