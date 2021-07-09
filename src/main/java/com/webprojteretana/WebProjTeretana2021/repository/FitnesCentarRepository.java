package com.webprojteretana.WebProjTeretana2021.repository;

import com.webprojteretana.WebProjTeretana2021.entity.Clan;
import com.webprojteretana.WebProjTeretana2021.entity.FitnesCentar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FitnesCentarRepository extends JpaRepository<FitnesCentar, Long> {
}
