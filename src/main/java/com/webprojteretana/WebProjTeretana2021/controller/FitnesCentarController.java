package com.webprojteretana.WebProjTeretana2021.controller;

import com.webprojteretana.WebProjTeretana2021.entity.Clan;
import com.webprojteretana.WebProjTeretana2021.entity.FitnesCentar;
import com.webprojteretana.WebProjTeretana2021.entity.dto.ClanDTO;
import com.webprojteretana.WebProjTeretana2021.entity.dto.FitnesCentarDTO;
import com.webprojteretana.WebProjTeretana2021.entity.dto.LoginClanDTO;
import com.webprojteretana.WebProjTeretana2021.service.ClanService;
import com.webprojteretana.WebProjTeretana2021.service.FitnesCentarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value="/api/fitnesCentri")
public class FitnesCentarController {

    @Autowired
    private FitnesCentarService fitnesCentarService;

    @Autowired
    public FitnesCentarController(FitnesCentarService fitnesCentarService) {this.fitnesCentarService = fitnesCentarService;}


    //registracija
    @PostMapping(value="/registration", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FitnesCentarDTO> createFitnesCentar(@RequestBody FitnesCentarDTO fitnesCentarDTO) throws Exception {

        FitnesCentar fitnesCentar = new FitnesCentar(fitnesCentarDTO.getNazivFC(), fitnesCentarDTO.getAdresaFC(), fitnesCentarDTO.getTelefonFC(), fitnesCentarDTO.getEmailFC());

        FitnesCentar newFitnesCentar = fitnesCentarService.create(fitnesCentar);

        FitnesCentarDTO newFitnesCentarDTO = new FitnesCentarDTO(newFitnesCentar.getNazivFC(), newFitnesCentar.getAdresaFC(), newFitnesCentar.getTelefonFC(), newFitnesCentar.getEmailFC());

        return new ResponseEntity<>(newFitnesCentarDTO, HttpStatus.OK);
    }

    //trazenje fitnes centra po id
    @GetMapping(
            value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)  // tip odgovora
    public ResponseEntity<FitnesCentarDTO> pregledFitnesCentra(@PathVariable(name = "id") Long id) {

        FitnesCentar fitnesCentar = this.fitnesCentarService.findOne(id);


        FitnesCentarDTO fitnesCentarDTO = new FitnesCentarDTO(fitnesCentar.getId(), fitnesCentar.getNazivFC(), fitnesCentar.getAdresaFC(), fitnesCentar.getTelefonFC(), fitnesCentar.getEmailFC());


        return new ResponseEntity<>(fitnesCentarDTO, HttpStatus.OK);
    }



    /*
    @PostMapping(
            value="/login",
            consumes= MediaType.APPLICATION_JSON_VALUE,
            produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClanDTO> login(@RequestBody LoginClanDTO clanDTO) throws Exception{

        Clan clan = clanService.login(clanDTO.getEmail(), clanDTO.getLozinka());

        ClanDTO logovaniClan = new ClanDTO();

        if (clan != null) {

            logovaniClan = new ClanDTO(clan.getId(), clan.getKorisnickoIme(), clan.getLozinka(), clan.getIme(), clan.getPrezime(), clan.getBrojTel(), clan.getEmail(), clan.getAdresa(), clan.getDatumRodjenja(), clan.getAktivan(), clan.getUloga());
            return new ResponseEntity<>(logovaniClan, HttpStatus.OK);

        }
        return new ResponseEntity<>(logovaniClan, HttpStatus.BAD_REQUEST);

    }
    */
}