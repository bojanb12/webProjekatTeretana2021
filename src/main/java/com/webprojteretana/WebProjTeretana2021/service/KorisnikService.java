package com.webprojteretana.WebProjTeretana2021.service;


import com.webprojteretana.WebProjTeretana2021.entity.Korisnik;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface KorisnikService {

    Korisnik create (Korisnik korisnik) throws Exception;

    List<Korisnik> findAll();

    Korisnik findOne(Long id);

    Korisnik login(String email, String lozinka);

    void change (Long id);

    void delete (Long id);
}
