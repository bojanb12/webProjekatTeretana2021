package com.webprojteretana.WebProjTeretana2021.service;

import com.webprojteretana.WebProjTeretana2021.entity.Sala;
import com.webprojteretana.WebProjTeretana2021.entity.Termin;

import java.util.List;

public interface SalaService {

    Sala create(Sala sala) throws Exception;

    List<Sala> findAll();

    Sala update(Sala sala) throws  Exception;

    Sala findOne(Long id);

    void delete(Long id);
}
