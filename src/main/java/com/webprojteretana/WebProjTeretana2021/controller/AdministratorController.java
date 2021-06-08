package com.webprojteretana.WebProjTeretana2021.controller;

import com.webprojteretana.WebProjTeretana2021.entity.Administrator;
import com.webprojteretana.WebProjTeretana2021.entity.Clan;
import com.webprojteretana.WebProjTeretana2021.entity.dto.AdministratorDTO;
import com.webprojteretana.WebProjTeretana2021.entity.dto.ClanDTO;
import com.webprojteretana.WebProjTeretana2021.entity.dto.LoginAdministratorDTO;
import com.webprojteretana.WebProjTeretana2021.entity.dto.LoginClanDTO;
import com.webprojteretana.WebProjTeretana2021.service.AdministratorService;
import com.webprojteretana.WebProjTeretana2021.service.ClanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/api/administratori")
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;

    @Autowired
    public AdministratorController(AdministratorService administratorService) {this.administratorService = administratorService;}


    //registracija
    @PostMapping(value="/registration", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AdministratorDTO> createAdministrator(@RequestBody AdministratorDTO administratorDTO) throws Exception {

        Administrator administrator = new Administrator(administratorDTO.getKorisnickoIme(), administratorDTO.getLozinka(), administratorDTO.getIme(), administratorDTO.getPrezime(), administratorDTO.getBrojTel(), administratorDTO.getEmail(), administratorDTO.getAdresa(), administratorDTO.getDatumRodjenja(), administratorDTO.getUloga());

        Administrator newAdministrator = administratorService.create(administrator);

        AdministratorDTO newAdministratorDTO = new AdministratorDTO(newAdministrator.getKorisnickoIme(), newAdministrator.getLozinka(), newAdministrator.getIme(), newAdministrator.getPrezime(), newAdministrator.getBrojTel(), newAdministrator.getEmail(), newAdministrator.getAdresa(), newAdministrator.getDatumRodjenja(), newAdministrator.getUloga());

        return new ResponseEntity<>(newAdministratorDTO, HttpStatus.OK);
    }


    @PostMapping(
            value="/login",
            consumes= MediaType.APPLICATION_JSON_VALUE,
            produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AdministratorDTO> login(@RequestBody LoginAdministratorDTO administratorDTO) throws Exception{

        Administrator administrator = administratorService.login(administratorDTO.getEmail(), administratorDTO.getLozinka());

        AdministratorDTO logovaniAdministrator = new AdministratorDTO();

        if (administrator != null) {

            logovaniAdministrator = new AdministratorDTO(administrator.getId(), administrator.getKorisnickoIme(), administrator.getLozinka(), administrator.getIme(), administrator.getPrezime(), administrator.getBrojTel(), administrator.getEmail(), administrator.getAdresa(), administrator.getDatumRodjenja(), administrator.getUloga());
            return new ResponseEntity<>(logovaniAdministrator, HttpStatus.OK);

        }
        return new ResponseEntity<>(logovaniAdministrator, HttpStatus.BAD_REQUEST);

    }

    @GetMapping(
            value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)  // tip odgovora
    public ResponseEntity<AdministratorDTO> pregledAdministratora(@PathVariable(name = "id") Long id) {
        // Dobavljamo zaposlenog po ID-u
        Administrator administrator = this.administratorService.findOne(id);

        // Kreiramo objekat klase EmployeeDTO
        AdministratorDTO administratorDTO = new AdministratorDTO(administrator.getId(), administrator.getKorisnickoIme(), administrator.getLozinka(), administrator.getIme(), administrator.getPrezime(), administrator.getBrojTel(), administrator.getEmail(), administrator.getAdresa(), administrator.getDatumRodjenja(), administrator.getUloga());


        // Vraćamo ResponseEntity
        // ResponseEntity predstavlja ceo HTTP odgovor: status kod, zaglavlja i body.
        // Možemo u potpunosti da kontrolišemo šta će se nalaziti u odgovoru koji želimo da vratimo.
        // Ako je došlo do greške postavljamo drugi HttpStatus npr. HttpStatus.BAD_REQUEST
        return new ResponseEntity<>(administratorDTO, HttpStatus.OK);
    }
}
