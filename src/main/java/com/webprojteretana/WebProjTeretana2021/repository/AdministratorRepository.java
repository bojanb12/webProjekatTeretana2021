package com.webprojteretana.WebProjTeretana2021.repository;

// @Autowired stavljamo iznad metoda koje koristimo u repositry kako bi ona komunicirala sa servisom i kontrolerom

import com.webprojteretana.WebProjTeretana2021.entity.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministratorRepository extends JpaRepository<Administrator, Long> {
}
