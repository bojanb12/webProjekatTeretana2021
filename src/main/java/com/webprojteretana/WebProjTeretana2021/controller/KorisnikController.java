package com.webprojteretana.WebProjTeretana2021.controller;

import com.webprojteretana.WebProjTeretana2021.entity.Korisnik;
import com.webprojteretana.WebProjTeretana2021.entity.dto.KorisnikDTO;
import com.webprojteretana.WebProjTeretana2021.entity.dto.LoginKorisnikDTO;
import com.webprojteretana.WebProjTeretana2021.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity; //ResponseEntity koristimo kao HTTP odgovor, to je odgovor koji vracamo

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/korisnici")
public class KorisnikController {
    private final KorisnikService korisnikService;

    // constructor-based dependency injection
    @Autowired
    public KorisnikController(KorisnikService korisnikService) {
        this.korisnikService = korisnikService;
    }

    @GetMapping(
            value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<KorisnikDTO> korisnikProfil(@PathVariable(name = "id") Long id) {
        Korisnik korisnik = this.korisnikService.findOne(id);

        KorisnikDTO korisnikDTO = new KorisnikDTO();
        korisnikDTO.setKorisnickoIme(korisnik.getKorisnickoIme());
        korisnikDTO.setLozinka(korisnik.getLozinka());
        korisnikDTO.setIme(korisnik.getIme());
        korisnikDTO.setPrezime(korisnik.getPrezime());
        korisnikDTO.setUloga(korisnik.getUloga());
        korisnikDTO.setBrojTel(korisnik.getBrojTel());
        korisnikDTO.setEmail(korisnik.getEmail());
        korisnikDTO.setAdresa(korisnik.getAdresa());
        korisnikDTO.setDatumRodjenja(korisnik.getDatumRodjenja());
        korisnikDTO.setAktivan(korisnik.getAktivan());

        return new ResponseEntity<>(korisnikDTO, HttpStatus.OK);
    }


    @GetMapping(                                               // value nije naveden, jer koristimo bazni url
            produces = MediaType.APPLICATION_JSON_VALUE)       // tip odgovora
    public ResponseEntity<List<KorisnikDTO>> korisniciSvi() {

        List<Korisnik> korisnikList = this.korisnikService.findAll();


        List<KorisnikDTO> korisnikDTOS = new ArrayList<>();

        for (Korisnik korisnik : korisnikList) {

            KorisnikDTO korisnikDTO = new KorisnikDTO(korisnik.getId(), korisnik.getKorisnickoIme(), korisnik.getLozinka(),
                    korisnik.getIme(), korisnik.getPrezime(), korisnik.getUloga(), korisnik.getEmail(), korisnik.getAdresa(),
                    korisnik.getBrojTel(), korisnik.getDatumRodjenja(), korisnik.getAktivan());
            korisnikDTOS.add(korisnikDTO);
        }
        return new ResponseEntity<>(korisnikDTOS, HttpStatus.OK);
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KorisnikDTO> login(@RequestBody LoginKorisnikDTO korisnikDTO) throws Exception {

        Korisnik korisnik = korisnikService.login(korisnikDTO.getEmail(), korisnikDTO.getLozinka());

        KorisnikDTO logovaniKorisnik = new KorisnikDTO();

        if (korisnik != null) {

            logovaniKorisnik = new KorisnikDTO(korisnik.getId(), korisnik.getKorisnickoIme(), korisnik.getLozinka(),
                    korisnik.getIme(), korisnik.getPrezime(), korisnik.getUloga(), korisnik.getEmail(), korisnik.getAdresa(),
                    korisnik.getBrojTel(), korisnik.getDatumRodjenja(), korisnik.getAktivan());
            return new ResponseEntity<>(logovaniKorisnik, HttpStatus.OK);

        }
        return new ResponseEntity<>(logovaniKorisnik, HttpStatus.BAD_REQUEST);

    }

    @GetMapping(
            value = "/promena/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<KorisnikDTO> promenaUloge(@PathVariable(name = "id") Long id) {
        this.korisnikService.change(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(
            value = "/obrisi/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<KorisnikDTO> obrisiUlogu(@PathVariable(name = "id") Long id) {
        this.korisnikService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
