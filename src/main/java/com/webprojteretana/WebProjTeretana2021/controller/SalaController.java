package com.webprojteretana.WebProjTeretana2021.controller;


import com.webprojteretana.WebProjTeretana2021.entity.*;
import com.webprojteretana.WebProjTeretana2021.entity.dto.*;
import com.webprojteretana.WebProjTeretana2021.service.FitnesCentarService;
import com.webprojteretana.WebProjTeretana2021.service.SalaService;
import com.webprojteretana.WebProjTeretana2021.service.TerminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value="/api/sale")
public class SalaController {

    @Autowired
    private SalaService salaService;

    @Autowired
    private FitnesCentarService fitnesCentarService;

    @Autowired
    public SalaController(SalaService salaService) {this.salaService = salaService;}

    //metoda za dodavanje sale za odredjeni FC
    @PostMapping(value="/registration/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SalaDTO> createSala(@RequestBody SalaDTO salaDTO, @PathVariable(name="id") Long id) throws Exception {

        FitnesCentar fitnesCentar = fitnesCentarService.findOne(id);

        Sala sala = new Sala(salaDTO.getKapacitet(), salaDTO.getOznaka());

        Sala newSala = salaService.create(sala);

        SalaDTO newSalaDTO = new SalaDTO(newSala.getKapacitet(), newSala.getOznaka());

        fitnesCentarService.dodajSalu(id, newSala);

        return new ResponseEntity<>(newSalaDTO, HttpStatus.OK);
    }

    // metoda za dobavljanje sala za odabrni fitnes centar
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/{id}")
    public ResponseEntity<Set<SalaDTO>> prikaziSale(@PathVariable(name = "id") Long id) throws Exception {

        FitnesCentar fitnesCentar = fitnesCentarService.findOne(id);

        Set<Sala> sale = fitnesCentar.getSale();

        Set<SalaDTO> salaDTOS= new HashSet<>();

        if (sale.isEmpty()){
            throw new Exception("Nema sala za odabrani fitnes centar.");
        }else
        for(Sala sala: sale){
            SalaDTO salaDTO= new SalaDTO(sala.getId(), sala.getKapacitet(), sala.getOznaka());
            salaDTOS.add(salaDTO);
        }

        return new ResponseEntity<>(salaDTOS, HttpStatus.OK);


    }
}
