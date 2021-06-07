package com.webprojteretana.WebProjTeretana2021.controller;

import com.webprojteretana.WebProjTeretana2021.entity.Clan;
import com.webprojteretana.WebProjTeretana2021.entity.dto.ClanDTO;
import com.webprojteretana.WebProjTeretana2021.service.ClanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/clanovi")
public class ClanController {

    @Autowired
    private ClanService clanService;


    @Autowired
    public ClanController(ClanService clanService) {
        this.clanService = clanService;
    }

    @PostMapping(
            value = "/registracija",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ClanDTO> registracijaClana(@RequestBody ClanDTO clanDTO) throws Exception{

        Clan clan = new Clan(clanDTO.getIme(), clanDTO.getPrezime(), clanDTO.getKorisnickoIme(), clanDTO.getEmail(), clanDTO.getLozinka(), clanDTO.getBrojTel(), clanDTO.getAdresa(), clanDTO.getDatumRodjenja(), clanDTO.getDatumRodjenja());

        Clan noviClan = clanService.create(clan);

        ClanDTO noviClanDTO = new ClanDTO(noviClan.getId(), noviClan.getKorisnickoIme(), noviClan.getLozinka(), noviClan.getIme(), noviClan.getPrezime(), noviClan.getUloga(), noviClan.getBrojTel(), noviClan.getEmail(), noviClan.getAdresa(), noviClan.getDatumRodjenja());

        return new ResponseEntity<>(noviClanDTO, HttpStatus.OK);
    }

}

    /*
         Prikaz jednog zaposlenog
         @PathVariable omogućava da se iz URL-a ekstrahuju podaci koji su namapirani na pozicione parametre.

         Primer putanje:  http://localhost:8080/api/employees/1

    @GetMapping(
            value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)  // tip odgovora
    public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable(name = "id") Long id) {
        // Dobavljamo zaposlenog po ID-u
        Employee employee = this.employeeService.findOne(id);

        // Kreiramo objekat klase EmployeeDTO
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setFirstName(employee.getFirstName());
        employeeDTO.setLastName(employee.getLastName());
        employeeDTO.setPosition(employee.getPosition());

        // Vraćamo ResponseEntity
        // ResponseEntity predstavlja ceo HTTP odgovor: status kod, zaglavlja i body.
        // Možemo u potpunosti da kontrolišemo šta će se nalaziti u odgovoru koji želimo da vratimo.
        // Ako je došlo do greške postavljamo drugi HttpStatus npr. HttpStatus.BAD_REQUEST
        return new ResponseEntity<>(employeeDTO, HttpStatus.OK);
    }
    */
