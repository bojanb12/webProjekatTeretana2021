package com.webprojteretana.WebProjTeretana2021.service.impl;

import com.webprojteretana.WebProjTeretana2021.entity.Administrator;
import com.webprojteretana.WebProjTeretana2021.entity.Clan;
import com.webprojteretana.WebProjTeretana2021.repository.AdministratorRepository;
import com.webprojteretana.WebProjTeretana2021.repository.ClanRepository;
import com.webprojteretana.WebProjTeretana2021.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministratorServiceImpl implements AdministratorService {

    private final AdministratorRepository administratorRepository;

    @Autowired
    public AdministratorServiceImpl(AdministratorRepository administratorRepository) {
        this.administratorRepository = administratorRepository;
    }

    @Override
    public Administrator create(Administrator administrator) throws Exception {
        if (administrator.getId() != null) {
            throw new Exception("ID must be null!");
        }
        Administrator newAdministrator = this.administratorRepository.save(administrator);
        return newAdministrator;
    }

    @Override
    public List<Administrator> findAll() {
        return null;
    }

    @Override
    public Administrator update(Administrator administrator) throws Exception {
        return null;
    }


    @Override
    public Administrator findOne(Long id) {
        return administratorRepository.getOne(id);

    }

    @Override
    public Administrator login(String email, String lozinka){
        return  this.administratorRepository.findByEmailAndLozinka(email, lozinka);
    }

}
