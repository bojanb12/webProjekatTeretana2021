package com.webprojteretana.WebProjTeretana2021.controller;

import com.webprojteretana.WebProjTeretana2021.entity.Clan;
import com.webprojteretana.WebProjTeretana2021.entity.dto.ClanDTO;
import com.webprojteretana.WebProjTeretana2021.entity.dto.LoginClanDTO;
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
    public ClanController(ClanService clanService) {this.clanService = clanService;}


    //registracija
    @PostMapping(value="/registration", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClanDTO> createClan(@RequestBody ClanDTO clanDTO) throws Exception {

        Clan clan = new Clan(clanDTO.getKorisnickoIme(), clanDTO.getLozinka(), clanDTO.getIme(), clanDTO.getPrezime(), clanDTO.getBrojTel(), clanDTO.getEmail(), clanDTO.getAdresa(), clanDTO.getDatumRodjenja(), clanDTO.getAktivan());

        Clan newClan = clanService.create(clan);

        ClanDTO newClanDTO = new ClanDTO(newClan.getKorisnickoIme(), newClan.getLozinka(), newClan.getIme(), newClan.getPrezime(), newClan.getBrojTel(), newClan.getEmail(), newClan.getAdresa(), newClan.getDatumRodjenja(), newClan.getAktivan());

        return new ResponseEntity<>(newClanDTO, HttpStatus.OK);
    }


    @PostMapping(
            value="/login",
            consumes= MediaType.APPLICATION_JSON_VALUE,
            produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClanDTO> login(@RequestBody LoginClanDTO clanDTO) throws Exception{

        Clan clan = clanService.login(clanDTO.getEmail(), clanDTO.getLozinka());

        ClanDTO logovaniClan = new ClanDTO();

        if (clan != null) {

            logovaniClan = new ClanDTO(clan.getId(), clan.getKorisnickoIme(), clan.getLozinka(), clan.getIme(), clan.getPrezime(), clan.getBrojTel(), clan.getEmail(), clan.getAdresa(), clan.getDatumRodjenja(), clan.getAktivan());
            return new ResponseEntity<>(logovaniClan, HttpStatus.OK);

        }
        return new ResponseEntity<>(logovaniClan, HttpStatus.BAD_REQUEST);

    }

    @GetMapping(
            value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)  // tip odgovora
    public ResponseEntity<ClanDTO> pregledClana(@PathVariable(name = "id") Long id) {
        // Dobavljamo zaposlenog po ID-u
        Clan clan = this.clanService.findOne(id);

        // Kreiramo objekat klase EmployeeDTO
        ClanDTO korisnikDTO = new ClanDTO(clan.getId(), clan.getKorisnickoIme(), clan.getLozinka(), clan.getIme(), clan.getPrezime(), clan.getBrojTel(), clan.getEmail(), clan.getAdresa(), clan.getDatumRodjenja(), clan.getAktivan());


        // Vraćamo ResponseEntity
        // ResponseEntity predstavlja ceo HTTP odgovor: status kod, zaglavlja i body.
        // Možemo u potpunosti da kontrolišemo šta će se nalaziti u odgovoru koji želimo da vratimo.
        // Ako je došlo do greške postavljamo drugi HttpStatus npr. HttpStatus.BAD_REQUEST
        return new ResponseEntity<>(korisnikDTO, HttpStatus.OK);
    }

}
