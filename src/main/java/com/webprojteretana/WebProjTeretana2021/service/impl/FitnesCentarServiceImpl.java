package com.webprojteretana.WebProjTeretana2021.service.impl;

import com.webprojteretana.WebProjTeretana2021.entity.Clan;
import com.webprojteretana.WebProjTeretana2021.entity.FitnesCentar;
import com.webprojteretana.WebProjTeretana2021.entity.Sala;
import com.webprojteretana.WebProjTeretana2021.entity.Trening;
import com.webprojteretana.WebProjTeretana2021.repository.ClanRepository;
import com.webprojteretana.WebProjTeretana2021.repository.FitnesCentarRepository;
import com.webprojteretana.WebProjTeretana2021.service.FitnesCentarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class FitnesCentarServiceImpl implements FitnesCentarService {

    private final FitnesCentarRepository fitnesCentarRepository;

    @Autowired
    public FitnesCentarServiceImpl(FitnesCentarRepository fitnesCentarRepository) {
        this.fitnesCentarRepository = fitnesCentarRepository;
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
}
