package com.webprojteretana.WebProjTeretana2021.service;

import com.webprojteretana.WebProjTeretana2021.entity.Clan;
import com.webprojteretana.WebProjTeretana2021.entity.FitnesCentar;

import java.util.List;

public interface FitnesCentarService {

    FitnesCentar create(FitnesCentar fitnesCentar) throws Exception;

    List<FitnesCentar> findAll();

    FitnesCentar update(FitnesCentar fitnesCentar) throws  Exception;

    FitnesCentar findOne(Long id);

}
