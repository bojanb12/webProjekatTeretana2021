package com.webprojteretana.WebProjTeretana2021.controller;

import com.webprojteretana.WebProjTeretana2021.entity.Clan;
import com.webprojteretana.WebProjTeretana2021.entity.Trener;
import com.webprojteretana.WebProjTeretana2021.entity.dto.ClanDTO;
import com.webprojteretana.WebProjTeretana2021.entity.dto.LoginClanDTO;
import com.webprojteretana.WebProjTeretana2021.entity.dto.LoginTrenerDTO;
import com.webprojteretana.WebProjTeretana2021.entity.dto.TrenerDTO;
import com.webprojteretana.WebProjTeretana2021.service.ClanService;
import com.webprojteretana.WebProjTeretana2021.service.TrenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/api/treneri")
public class TrenerController {

    @Autowired
    private TrenerService trenerService;

    @Autowired
    public TrenerController(TrenerService trenerService) {this.trenerService = trenerService;}


    //registracija
    @PostMapping(value="/registration", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TrenerDTO> createTrener(@RequestBody TrenerDTO trenerDTO) throws Exception {

        Trener trener = new Trener(trenerDTO.getKorisnickoIme(), trenerDTO.getLozinka(), trenerDTO.getIme(), trenerDTO.getPrezime(), trenerDTO.getBrojTel(), trenerDTO.getEmail(), trenerDTO.getAdresa(), trenerDTO.getDatumRodjenja(), trenerDTO.getAktivan(), trenerDTO.getUloga());

        Trener newTrener = trenerService.create(trener);

        TrenerDTO newTrenerDTO = new TrenerDTO(newTrener.getKorisnickoIme(), newTrener.getLozinka(), newTrener.getIme(), newTrener.getPrezime(), newTrener.getBrojTel(), newTrener.getEmail(), newTrener.getAdresa(), newTrener.getDatumRodjenja(), newTrener.getAktivan(), newTrener.getUloga());

        return new ResponseEntity<>(newTrenerDTO, HttpStatus.OK);
    }


    @PostMapping(
            value="/login",
            consumes= MediaType.APPLICATION_JSON_VALUE,
            produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TrenerDTO> login(@RequestBody LoginTrenerDTO trenerDTO) throws Exception{

        Trener trener = trenerService.login(trenerDTO.getEmail(), trenerDTO.getLozinka());

        TrenerDTO logovaniTrener = new TrenerDTO();

        if (trener != null) {

            logovaniTrener = new TrenerDTO(trener.getId(), trener.getKorisnickoIme(), trener.getLozinka(), trener.getIme(), trener.getPrezime(), trener.getBrojTel(), trener.getEmail(), trener.getAdresa(), trener.getDatumRodjenja(), trener.getAktivan(), trener.getUloga());
            return new ResponseEntity<>(logovaniTrener, HttpStatus.OK);

        }
        return new ResponseEntity<>(logovaniTrener, HttpStatus.BAD_REQUEST);

    }

    @GetMapping(
            value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)  // tip odgovora
    public ResponseEntity<TrenerDTO> pregledTrenera(@PathVariable(name = "id") Long id) {

        Trener trener = this.trenerService.findOne(id);


        TrenerDTO trenerDTO = new TrenerDTO(trener.getId(), trener.getKorisnickoIme(), trener.getLozinka(), trener.getIme(), trener.getPrezime(), trener.getBrojTel(), trener.getEmail(), trener.getAdresa(), trener.getDatumRodjenja(), trener.getAktivan(), trener.getUloga());

        return new ResponseEntity<>(trenerDTO, HttpStatus.OK);
    }


    // metoda za azuriranje postojeceg trenera
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TrenerDTO> updateTrener(@PathVariable Long id, @RequestBody TrenerDTO trenerDTO) throws Exception {

        Trener trener = new Trener(trenerDTO.getKorisnickoIme(), trenerDTO.getLozinka(), trenerDTO.getIme(), trenerDTO.getPrezime(), trenerDTO.getBrojTel(), trenerDTO.getEmail(), trenerDTO.getAdresa(), trenerDTO.getDatumRodjenja(), trenerDTO.getAktivan(), trenerDTO.getUloga());

        trener.setId(id);


        Trener updatedTrener = trenerService.update(trener);


        TrenerDTO updatedTrenerDTO = new TrenerDTO(updatedTrener.getId(), updatedTrener.getKorisnickoIme(), updatedTrener.getLozinka(), updatedTrener.getIme(), updatedTrener.getPrezime(), updatedTrener.getBrojTel(), updatedTrener.getEmail(), updatedTrener.getAdresa(), updatedTrener.getDatumRodjenja(), updatedTrener.getAktivan(), updatedTrener.getUloga());


        return new ResponseEntity<>(updatedTrenerDTO, HttpStatus.OK);
    }

    //metoda za dobavljanje svih trenera
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TrenerDTO>> getTreneri() {

        List<Trener> trenerList = this.trenerService.findAll();


        List<TrenerDTO> trenerDTOS = new ArrayList<>();

        for (Trener trener : trenerList) {

            TrenerDTO trenerDTO = new TrenerDTO(trener.getId(), trener.getKorisnickoIme(), trener.getLozinka(), trener.getIme(), trener.getPrezime(), trener.getBrojTel(), trener.getEmail(), trener.getAdresa(), trener.getDatumRodjenja(), trener.getAktivan(), trener.getUloga());
            trenerDTOS.add(trenerDTO);
        }


        return new ResponseEntity<>(trenerDTOS, HttpStatus.OK);
    }

    //metoda za potvrdu registracije ili gašenje naloga
    @GetMapping(
            value = "/aktiviraj/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)  // tip odgovora
    public ResponseEntity<TrenerDTO> promeniAktivan(@PathVariable(name = "id") Long id) {

        this.trenerService.aktivirajNalog(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
