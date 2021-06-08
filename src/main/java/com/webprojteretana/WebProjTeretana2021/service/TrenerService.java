package com.webprojteretana.WebProjTeretana2021.service;

import com.webprojteretana.WebProjTeretana2021.entity.Clan;
import com.webprojteretana.WebProjTeretana2021.entity.Trener;

import java.util.List;

public interface TrenerService {

    Trener create(Trener trener) throws Exception;

    List<Trener> findAll();

    Trener update(Trener trener) throws  Exception;

    Trener findOne(Long id);

    Trener login(String email, String lozinka);
}
