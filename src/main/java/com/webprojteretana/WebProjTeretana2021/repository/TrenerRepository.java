package com.webprojteretana.WebProjTeretana2021.repository;

import com.webprojteretana.WebProjTeretana2021.entity.Trener;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrenerRepository extends JpaRepository<Trener, Long> {
}
