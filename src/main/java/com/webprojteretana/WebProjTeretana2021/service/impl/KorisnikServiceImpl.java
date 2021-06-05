package com.webprojteretana.WebProjTeretana2021.service.impl;

import com.webprojteretana.WebProjTeretana2021.entity.Korisnik;
import com.webprojteretana.WebProjTeretana2021.repository.KorisnikRepository;
import com.webprojteretana.WebProjTeretana2021.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class KorisnikServiceImpl implements KorisnikService {

    @Autowired
    private KorisnikRepository korisnikRepository;


    @Override
    public Korisnik create(Korisnik korisnik) throws Exception{

        if( korisnik.getId() != null) {
            throw new Exception("ID must be null");
        }

        return this.korisnikRepository.save(korisnik);
    }

    @Override
    public List<Korisnik> findAll(){
        return this.korisnikRepository.findAll();
    }

    @Override
    public Korisnik findOne(Long id){
        return this.korisnikRepository.getOne(id);
    }

    @Override
    public Korisnik login(String email, String lozinka){
        return  this.korisnikRepository.findByEmailAndLozinka(email, lozinka);

    }

    @Override
    public void delete(Long id) {
        Korisnik korisnik = korisnikRepository.getOne(id);
        korisnikRepository.delete(korisnik);
    }

    @Override
    public void change(Long id){
        Korisnik korisnik = korisnikRepository.getOne(id);

        if (korisnik.getUloga().equals("Trener")){
            korisnik.setUloga("Trener");
        } else {
            korisnik.setUloga("Clan");
        }

        korisnikRepository.save(korisnik);
    }
}
