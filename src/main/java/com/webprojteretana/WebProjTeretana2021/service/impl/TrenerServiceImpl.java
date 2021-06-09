package com.webprojteretana.WebProjTeretana2021.service.impl;

import com.webprojteretana.WebProjTeretana2021.entity.Clan;
import com.webprojteretana.WebProjTeretana2021.entity.Trener;
import com.webprojteretana.WebProjTeretana2021.repository.ClanRepository;
import com.webprojteretana.WebProjTeretana2021.repository.TrenerRepository;
import com.webprojteretana.WebProjTeretana2021.service.TrenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrenerServiceImpl implements TrenerService {

    private final TrenerRepository trenerRepository;

    @Autowired
    public TrenerServiceImpl(TrenerRepository trenerRepository) {
        this.trenerRepository = trenerRepository;
    }

    @Override
    public Trener create(Trener trener) throws Exception {
        if (trener.getId() != null) {
            throw new Exception("ID must be null!");
        }
        Trener newTrener = this.trenerRepository.save(trener);
        return newTrener;
    }

    @Override
    public List<Trener> findAll() {
        List<Trener> treneri = this.trenerRepository.findAll();
        return treneri;
    }

    @Override
    public Trener update(Trener trener) throws Exception {
        Trener trenerToUpdate = this.trenerRepository.getOne(trener.getId());
        if (trenerToUpdate == null) {
            throw new Exception("Trener doesn't exist!");
        }

        // Postavljanje novog radnog mesta
        trenerToUpdate.setAktivan(trener.getAktivan());

        // Čuvanje u bazi
        Trener savedTrener = this.trenerRepository.save(trenerToUpdate);
        return savedTrener;
    }


    @Override
    public Trener findOne(Long id) {
        Trener trener = this.trenerRepository.getOne(id);
        return trener;
    }

    @Override
    public Trener login(String email, String lozinka){
        return  this.trenerRepository.findByEmailAndLozinka(email, lozinka);
    }
}
