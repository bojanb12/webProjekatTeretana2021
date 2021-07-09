package com.webprojteretana.WebProjTeretana2021.service.impl;

import com.webprojteretana.WebProjTeretana2021.entity.*;
import com.webprojteretana.WebProjTeretana2021.repository.ClanRepository;
import com.webprojteretana.WebProjTeretana2021.repository.FitnesCentarRepository;
import com.webprojteretana.WebProjTeretana2021.repository.SalaRepository;
import com.webprojteretana.WebProjTeretana2021.service.FitnesCentarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class FitnesCentarServiceImpl implements FitnesCentarService {

    private final FitnesCentarRepository fitnesCentarRepository;

    private final SalaRepository salaRepository;

    @Autowired
    public FitnesCentarServiceImpl(FitnesCentarRepository fitnesCentarRepository, SalaRepository salaRepository) {
        this.fitnesCentarRepository = fitnesCentarRepository;
        this.salaRepository = salaRepository;
    }

    @Override
    public FitnesCentar create(FitnesCentar fitnesCentar) throws Exception {
        if (fitnesCentar.getId() != null) {
            throw new Exception("ID must be null!");
        }
        FitnesCentar newFitnesCentar = this.fitnesCentarRepository.save(fitnesCentar);
        return newFitnesCentar;
    }

    @Override
    public List<FitnesCentar> findAll() {
        List<FitnesCentar> fitnesCentri = this.fitnesCentarRepository.findAll();
        return fitnesCentri;
    }

    @Override
    public FitnesCentar update(FitnesCentar fitnesCentar) throws Exception {
        return null;
    }


    @Override
    public FitnesCentar findOne(Long id) {
        return fitnesCentarRepository.getOne(id);

    }

    @Override
    public void  dodajSalu (Long idFC, Sala sala){
        FitnesCentar fitnesCentar = fitnesCentarRepository.getOne(idFC);
        Set<Sala> sale=fitnesCentar.getSale();
        sale.add(sala);
        fitnesCentar.setSale(sale);
        FitnesCentar fitnesCentar1=this.fitnesCentarRepository.save(fitnesCentar);
    }

    @Override
    public void delete(Long id) {
        FitnesCentar fitnesCentar = fitnesCentarRepository.getOne(id);
        fitnesCentarRepository.delete(fitnesCentar);
    }


    // metoda za brisanje sale iz fitnes centra
    @Override
    public void obrisiSalu(Long idFitnesCentra,Long idSale){

        FitnesCentar fitnesCentar = fitnesCentarRepository.getOne(idFitnesCentra);
        Sala sala = salaRepository.getOne(idSale);
        Set<Sala> sale= fitnesCentar.getSale();

        sale.remove(sala);
        salaRepository.save(sala);

        fitnesCentar.setSale(sale);
        fitnesCentarRepository.save(fitnesCentar);

    }
}
