package com.webprojteretana.WebProjTeretana2021.service.impl;

import com.webprojteretana.WebProjTeretana2021.entity.Clan;
import com.webprojteretana.WebProjTeretana2021.entity.Trener;
import com.webprojteretana.WebProjTeretana2021.repository.ClanRepository;
import com.webprojteretana.WebProjTeretana2021.repository.TrenerRepository;
import com.webprojteretana.WebProjTeretana2021.service.TrenerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
        return null;
    }

    @Override
    public Trener update(Trener trener) throws Exception {
        return null;
    }


    @Override
    public Trener findOne(Long id) {
        return trenerRepository.getOne(id);

    }

    @Override
    public Trener login(String email, String lozinka){
        return  this.trenerRepository.findByEmailAndLozinka(email, lozinka);
    }
}
