package com.webprojteretana.WebProjTeretana2021.service.impl;

import com.webprojteretana.WebProjTeretana2021.entity.Clan;
import com.webprojteretana.WebProjTeretana2021.repository.ClanRepository;
import com.webprojteretana.WebProjTeretana2021.service.ClanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ClanServiceImpl implements ClanService {

    private final ClanRepository clanRepository;

    public ClanServiceImpl(ClanRepository clanRepository) {
        this.clanRepository = clanRepository;
    }

    @Override
    public Clan create(Clan clan) throws Exception {
        if (clan.getId() != null) {
            throw new Exception("ID must be null!");
        }
        Date datum = new Date();
        Clan newClan = this.clanRepository.save(clan);
        return newClan;
    }


    @Override
    public Clan findOne(Long id) {
        return clanRepository.getOne(id);

    }
}
