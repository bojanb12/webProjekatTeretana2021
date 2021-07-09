package com.webprojteretana.WebProjTeretana2021.service.impl;

import com.webprojteretana.WebProjTeretana2021.entity.*;
import com.webprojteretana.WebProjTeretana2021.repository.TrenerRepository;
import com.webprojteretana.WebProjTeretana2021.repository.TreningRepository;
import com.webprojteretana.WebProjTeretana2021.service.TreningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class TreningServiceImpl implements TreningService {

    private final TreningRepository treningRepository;

    @Autowired
    public TreningServiceImpl(TreningRepository treningRepository) {
        this.treningRepository = treningRepository;
    }

    @Override
    public Trening create(Trening trening) throws Exception {
        if (trening.getId() != null) {
            throw new Exception("ID must be null!");
        }
        Trening newTrening = this.treningRepository.save(trening);
        return newTrening;
    }

    @Override
    public List<Trening> findAll() {
        List<Trening> treninzi = this.treningRepository.findAll();
        return treninzi;
    }


    @Override
    public Trening findOne(Long id) {
        Trening trening = this.treningRepository.getOne(id);
        return trening;
    }


    //TEK TREBA IMPLEMENTIRATI!
    @Override
    public Trening update(Trening trening) throws Exception {
        return null;
    }

    @Override
    public void  dodajTermin (Long idTrening, Termin termin){
        Trening trening = treningRepository.getOne(idTrening);
        Set<Termin> termini=trening.getTerminiTreninga();
        termini.add(termin);
        trening.setTerminiTreninga(termini);
        Trening trening1 = this.treningRepository.save(trening);
    }
}
