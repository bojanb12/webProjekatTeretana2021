package com.webprojteretana.WebProjTeretana2021.service;

import com.webprojteretana.WebProjTeretana2021.entity.FitnesCentar;
import com.webprojteretana.WebProjTeretana2021.entity.Termin;

import java.util.List;

public interface TerminService {

    Termin create(Termin termin) throws Exception;

    List<Termin> findAll();

    Termin update(Termin termin) throws  Exception;

    Termin findOne(Long id);
}
