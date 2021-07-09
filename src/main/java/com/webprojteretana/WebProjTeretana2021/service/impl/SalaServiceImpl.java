package com.webprojteretana.WebProjTeretana2021.service.impl;

import com.webprojteretana.WebProjTeretana2021.entity.FitnesCentar;
import com.webprojteretana.WebProjTeretana2021.entity.Sala;
import com.webprojteretana.WebProjTeretana2021.entity.Trening;
import com.webprojteretana.WebProjTeretana2021.repository.SalaRepository;
import com.webprojteretana.WebProjTeretana2021.repository.TreningRepository;
import com.webprojteretana.WebProjTeretana2021.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaServiceImpl implements SalaService {

    private final SalaRepository salaRepository;

    @Autowired
    public SalaServiceImpl(SalaRepository salaRepository) {
        this.salaRepository = salaRepository;
    }

    @Override
    public Sala create(Sala sala) throws Exception {
        if (sala.getId() != null) {
            throw new Exception("ID must be null!");
        }
        Sala newSala = this.salaRepository.save(sala);
        return newSala;
    }

    @Override
    public List<Sala> findAll() {
        List<Sala> sale = this.salaRepository.findAll();
        return sale;
    }


    @Override
    public Sala findOne(Long id) {
        Sala sala = this.salaRepository.getOne(id);
        return sala;
    }


    //TEK TREBA IMPLEMENTIRATI!
    @Override
    public Sala update(Sala sala) throws Exception {
        return null;
    }

    @Override
    public void delete(Long id) {
        Sala sala = salaRepository.getOne(id);
        salaRepository.delete(sala);
    }
}
