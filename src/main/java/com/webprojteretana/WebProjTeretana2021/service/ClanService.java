package com.webprojteretana.WebProjTeretana2021.service;

import com.webprojteretana.WebProjTeretana2021.entity.Clan;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ClanService {

    Clan create(Clan clan) throws Exception;

    List<Clan> findAll();

    Clan update(Clan clan) throws  Exception;

    Clan findOne(Long id);

    Clan login(String email, String lozinka);
}
