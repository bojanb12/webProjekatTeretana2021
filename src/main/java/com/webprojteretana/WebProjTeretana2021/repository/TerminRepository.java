package com.webprojteretana.WebProjTeretana2021.repository;

import com.webprojteretana.WebProjTeretana2021.entity.Sala;
import com.webprojteretana.WebProjTeretana2021.entity.Termin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TerminRepository extends JpaRepository<Termin, Long> {
}
