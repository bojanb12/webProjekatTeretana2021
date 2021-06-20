package com.webprojteretana.WebProjTeretana2021.controller;

import com.webprojteretana.WebProjTeretana2021.entity.FitnesCentar;
import com.webprojteretana.WebProjTeretana2021.entity.Termin;
import com.webprojteretana.WebProjTeretana2021.entity.dto.FitnesCentarDTO;
import com.webprojteretana.WebProjTeretana2021.entity.dto.TerminDTO;
import com.webprojteretana.WebProjTeretana2021.service.FitnesCentarService;
import com.webprojteretana.WebProjTeretana2021.service.TerminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/termini")
public class TerminController {

    @Autowired
    private TerminService terminService;

    @Autowired
    public TerminController(TerminService terminService) {this.terminService = terminService;}


    // kreiranje termina
    @PostMapping(value="/kreiranjeTermina", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TerminDTO> createTermin(@RequestBody TerminDTO terminDTO) throws Exception {

        Termin termin = new Termin(terminDTO.getVreme(), terminDTO.getDan(), terminDTO.getCena(), terminDTO.getSalaTermin(), terminDTO.getTreningTermin());

        Termin newTermin = terminService.create(termin);

        TerminDTO newTerminDTO = new TerminDTO(newTermin.getVreme(), newTermin.getDan(), newTermin.getCena(), newTermin.getSalaTermin(), newTermin.getTreningTermin());

        return new ResponseEntity<>(newTerminDTO, HttpStatus.OK);
    }
}
