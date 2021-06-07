package com.webprojteretana.WebProjTeretana2021.service.impl;

import com.webprojteretana.WebProjTeretana2021.entity.Clan;
import com.webprojteretana.WebProjTeretana2021.repository.ClanRepository;
import com.webprojteretana.WebProjTeretana2021.service.ClanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ClanServiceImpl implements ClanService {

    private final ClanRepository clanRepository;

    @Autowired
    public ClanServiceImpl(ClanRepository clanRepository) {
        this.clanRepository = clanRepository;
    }

    @Override
    public Clan create(Clan clan) throws Exception {
        if (clan.getId() != null) {
            throw new Exception("ID must be null!");
        }
        Clan newClan = this.clanRepository.save(clan);
        return newClan;
    }

    @Override
    public List<Clan> findAll() {
        return null;
    }

    @Override
    public Clan update(Clan clan) throws Exception {
        return null;
    }


    @Override
    public Clan findOne(Long id) {
        return clanRepository.getOne(id);

    }
}
