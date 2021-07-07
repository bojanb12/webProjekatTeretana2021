package com.webprojteretana.WebProjTeretana2021.controller;

import com.webprojteretana.WebProjTeretana2021.entity.*;
import com.webprojteretana.WebProjTeretana2021.entity.dto.*;
import com.webprojteretana.WebProjTeretana2021.service.FitnesCentarService;
import com.webprojteretana.WebProjTeretana2021.service.TerminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/api/termini")
public class TerminController {

    @Autowired
    private TerminService terminService;

    @Autowired
    public TerminController(TerminService terminService) {this.terminService = terminService;}


    //metoda za dobavljanje svih termina
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminDTO>> getTermini() {

        List<Termin> terminList = this.terminService.findAll();



        List<TerminDTO> terminDTOS = new ArrayList<>();


        for (Termin termin : terminList) {

            TerminDTO terminDTO = new TerminDTO(termin.getId(), termin.getVreme(), termin.getDan(), termin.getCena());
            terminDTOS.add(terminDTO);
        }


        return new ResponseEntity<>(terminDTOS, HttpStatus.OK);
    }


    // kreiranje termina
    @PostMapping(value="/kreiranjeTermina", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TerminDTO> createTermin(@RequestBody TerminDTO terminDTO) throws Exception {

        Termin termin = new Termin(terminDTO.getVreme(), terminDTO.getDan(), terminDTO.getCena(), terminDTO.getSalaTermin(), terminDTO.getTreningTermin());

        Termin newTermin = terminService.create(termin);

        TerminDTO newTerminDTO = new TerminDTO(newTermin.getVreme(), newTermin.getDan(), newTermin.getCena(), newTermin.getSalaTermin(), newTermin.getTreningTermin());

        return new ResponseEntity<>(newTerminDTO, HttpStatus.OK);
    }

    //dobavljanje termina za pregled
    @GetMapping(
            value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)  // tip odgovora
    public ResponseEntity<TerminDTO> pregledTermina(@PathVariable(name = "id") Long id) {

        Termin termin = this.terminService.findOne(id);

        TerminDTO terminDTO = new TerminDTO(termin.getId(), termin.getVreme(), termin.getDan(), termin.getCena(), termin.getSalaTermin(), termin.getTreningTermin(), termin.getSlobodnihMesta());

        return new ResponseEntity<>(terminDTO, HttpStatus.OK);
    }

    // metoda za azuriranje postojeceg termina
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TerminDTO> updateTermin(@PathVariable Long id, @RequestBody TerminDTO terminDTO) throws Exception {

        Termin termin = new Termin(terminDTO.getVreme(), terminDTO.getDan(), terminDTO.getCena(), terminDTO.getSalaTermin(), terminDTO.getTreningTermin(), terminDTO.getSlobodnihMesta());

        termin.setId(id);


        Termin updatedTermin = terminService.update(termin);


        TerminDTO updatedTerminDTO = new TerminDTO(updatedTermin.getId(), updatedTermin.getVreme(), updatedTermin.getDan(), updatedTermin.getCena(), updatedTermin.getSalaTermin(), updatedTermin.getTreningTermin());


        return new ResponseEntity<>(updatedTerminDTO, HttpStatus.OK);
    }
}
