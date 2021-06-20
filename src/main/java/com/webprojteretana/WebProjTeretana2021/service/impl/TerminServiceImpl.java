package com.webprojteretana.WebProjTeretana2021.service.impl;


import com.webprojteretana.WebProjTeretana2021.entity.FitnesCentar;
import com.webprojteretana.WebProjTeretana2021.entity.Termin;
import com.webprojteretana.WebProjTeretana2021.repository.FitnesCentarRepository;
import com.webprojteretana.WebProjTeretana2021.repository.TerminRepository;
import com.webprojteretana.WebProjTeretana2021.service.TerminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TerminServiceImpl implements TerminService {

    private final TerminRepository terminRepository;

    @Autowired
    public TerminServiceImpl(TerminRepository terminRepository) {
        this.terminRepository = terminRepository;
    }

    @Override
    public Termin create(Termin termin) throws Exception {
        if (termin.getId() != null) {
            throw new Exception("ID must be null!");
        }
        Termin newTermin = this.terminRepository.save(termin);
        return newTermin;
    }

    @Override
    public List<Termin> findAll() {
        return null;
    }

    @Override
    public Termin update(Termin termin) throws Exception {
        return null;
    }


    @Override
    public Termin findOne(Long id) {
        return terminRepository.getOne(id);

    }
}
