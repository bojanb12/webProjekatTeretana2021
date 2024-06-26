package com.webprojteretana.WebProjTeretana2021.controller;


import com.webprojteretana.WebProjTeretana2021.entity.*;
import com.webprojteretana.WebProjTeretana2021.entity.dto.*;
import com.webprojteretana.WebProjTeretana2021.service.ClanService;
import com.webprojteretana.WebProjTeretana2021.service.TerminService;
import com.webprojteretana.WebProjTeretana2021.service.TrenerService;
import com.webprojteretana.WebProjTeretana2021.service.TreningService;
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
@RequestMapping(value="/api/treninzi")
public class TreningController {

    @Autowired
    private TreningService treningService;

    @Autowired
    private TerminService terminService;

    @Autowired
    private TrenerService trenerService;

    @Autowired
    private ClanService clanService;

    @Autowired
    public TreningController(TreningService treningService, TerminService terminService, TrenerService trenerService, ClanService clanService) {
        this.treningService = treningService;
        this.terminService = terminService;
        this.trenerService = trenerService;
        this.clanService = clanService;
    }

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


    /*@GetMapping(
            value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TreningDTO> pregledTreninga(@PathVariable(name = "id") Long id) {

        Trening trening = this.treningService.findOne(id);


        TreningDTO treningDTO = new TreningDTO(trening.getId(), trening.getNaziv(), trening.getOpis(), trening.getTipTreninga(), trening.getTrajanjeTreninga());

        return new ResponseEntity<>(treningDTO, HttpStatus.OK);
    }*/

    // metoda za dobavljanje treninga za odredjenog trenera
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/{id}")
    public ResponseEntity<Set<TreningDTO>> prikaziTermine(@PathVariable(name = "id") Long id) throws Exception {

        Trener trener = trenerService.findOne(id);

        Set<Trening> treninzi = trener.getTreninziKojeDrzi();

        Set<TreningDTO> treningDTOS= new HashSet<>();

        if (treninzi.isEmpty()){
            throw new Exception("Nema treninga za odabranog trenera.");
        }else
            for(Trening trening: treninzi){
                TreningDTO treningDTO= new TreningDTO(trening.getId(), trening.getNaziv(), trening.getOpis(), trening.getTipTreninga(), trening.getTrajanjeTreninga());
                treningDTOS.add(treningDTO);
            }

        return new ResponseEntity<>(treningDTOS, HttpStatus.OK);


    }


    // metoda za brisanje termina za odredjeni trening, brise se iz treninga preko servis metode obrisiTermin
    @PostMapping(
            value="/obrisiTermin",
            consumes = MediaType.APPLICATION_JSON_VALUE,     // tip podataka koje metoda može da primi
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public void obrisiTermin(@RequestBody TreningTerminDTO treningTerminDTO) throws Exception{

        Long idTrening=treningTerminDTO.getIdTrening();

        Long idTermin=treningTerminDTO.getIdTermin();

        treningService.obrisiTermin(idTrening,idTermin);


    }

    // metoda za prikaz prijavljenih treninga (povezana tabela privavio_trening)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/prijavljeni/{id}")
    public ResponseEntity<Set<TreningDTO>> prikaziPrijavljeneTreninge(@PathVariable(name = "id") Long id) throws Exception {

        Clan clan = clanService.findOne(id);

        Set<Trening> treninzi = clan.getPrijavljeniTreninzi();

        Set<TreningDTO> treningDTOS= new HashSet<>();

        if (treninzi.isEmpty()){
            throw new Exception("Nema treninga za odabranog trenera.");
        }else
            for(Trening trening: treninzi){
                TreningDTO treningDTO= new TreningDTO(trening.getId(), trening.getNaziv(), trening.getOpis(), trening.getTipTreninga(), trening.getTrajanjeTreninga());
                treningDTOS.add(treningDTO);
            }

        return new ResponseEntity<>(treningDTOS, HttpStatus.OK);


    }


    // metoda za prikazivanje odradjenih treninga (tabela odradio_trening)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/odradjeni/{id}")
    public ResponseEntity<Set<TreningDTO>> prikaziOdradjeneTreninge(@PathVariable(name = "id") Long id) throws Exception {

        Clan clan = clanService.findOne(id);

        Set<Trening> treninzi = clan.getOdradjeniTreninzi();

        Set<TreningDTO> treningDTOS= new HashSet<>();

        if (treninzi.isEmpty()){
            throw new Exception("Nema treninga za odabranog trenera.");
        }else
            for(Trening trening: treninzi){
                TreningDTO treningDTO= new TreningDTO(trening.getId(), trening.getNaziv(), trening.getOpis(), trening.getTipTreninga(), trening.getTrajanjeTreninga());
                treningDTOS.add(treningDTO);
            }

        return new ResponseEntity<>(treningDTOS, HttpStatus.OK);


    }
}
