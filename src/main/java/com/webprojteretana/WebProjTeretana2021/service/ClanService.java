package com.webprojteretana.WebProjTeretana2021.service;

import com.webprojteretana.WebProjTeretana2021.entity.Clan;
import org.springframework.stereotype.Service;

@Service
public interface ClanService {
    Clan create(Clan clan) throws Exception;

    Clan findOne(Long id);
}
