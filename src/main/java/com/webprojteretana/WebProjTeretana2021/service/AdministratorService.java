package com.webprojteretana.WebProjTeretana2021.service;

import com.webprojteretana.WebProjTeretana2021.entity.Administrator;
import com.webprojteretana.WebProjTeretana2021.entity.Clan;

import java.util.List;

public interface AdministratorService {

    Administrator create(Administrator administrator) throws Exception;

    List<Administrator> findAll();

    Administrator update(Administrator administrator) throws  Exception;

    Administrator findOne(Long id);

    Administrator login(String email, String lozinka);
}
