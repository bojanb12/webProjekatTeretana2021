package com.webprojteretana.WebProjTeretana2021.controller;


import com.webprojteretana.WebProjTeretana2021.entity.Termin;
import com.webprojteretana.WebProjTeretana2021.entity.Trener;
import com.webprojteretana.WebProjTeretana2021.entity.Trening;
import com.webprojteretana.WebProjTeretana2021.entity.dto.TerminDTO;
import com.webprojteretana.WebProjTeretana2021.entity.dto.TrenerDTO;
import com.webprojteretana.WebProjTeretana2021.entity.dto.TreningDTO;
import com.webprojteretana.WebProjTeretana2021.service.TerminService;
import com.webprojteretana.WebProjTeretana2021.service.TrenerService;
import com.webprojteretana.WebProjTeretana2021.service.TreningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/api/treninzi")
public class TreningController {

    @Autowired
    private TreningService treningService;

    @Autowired
    private TerminService terminService;

    @Autowired
    public TreningController(TreningService treningService) {this.treningService = treningService;}

    //metoda za dobavljanje svih treninga
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TreningDTO>> getTreninzi() {

        List<Trening> treningList = this.treningService.findAll();



        List<TreningDTO> treningDTOS = new ArrayList<>();


        for (Trening trening : treningList) {

            TreningDTO treningDTO = new TreningDTO(trening.getId(), trening.getNaziv(), trening.getOpis(), trening.getTipTreninga(), trening.getTrajanjeTreninga());
            treningDTOS.add(treningDTO);
        }


        return new ResponseEntity<>(treningDTOS, HttpStatus.OK);
    }


    @GetMapping(
            value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TreningDTO> pregledTreninga(@PathVariable(name = "id") Long id) {

        Trening trening = this.treningService.findOne(id);


        TreningDTO treningDTO = new TreningDTO(trening.getId(), trening.getNaziv(), trening.getOpis(), trening.getTipTreninga(), trening.getTrajanjeTreninga());

        return new ResponseEntity<>(treningDTO, HttpStatus.OK);
    }
}
