INSERT INTO OCENA (komentar_ocena, vrednost_ocene) VALUES ('Odličan!', 5);

INSERT INTO FITNES_CENTAR (NAZIVFC, ADRESAFC, TELEFONFC, EMAILFC) VALUES ('FTN Gym', 'Neke Ulice 22', '+3816455872', 'ftn.gym@gmail.com');
INSERT INTO FITNES_CENTAR (NAZIVFC, ADRESAFC, TELEFONFC, EMAILFC) VALUES ('PMF Gains', 'Matematička 41', '+381645871', 'matgym@gmail.com');

INSERT INTO SALA (KAPACITET, OZNAKA) VALUES (20, 'Sala 1');

INSERT INTO NALAZI (sala_id, fitnescentar_id) VALUES (1, 1);

--INSERT INTO KORISNIK (korisnicko_ime, LOZINKA, IME, PREZIME, ULOGA, broj_tel, EMAIL, ADRESA, datum_rodjenja, AKTIVAN) VALUES ('FTN Gym', 'Neke Ulice 22', '+3816455872', 'ftn.gym@gmail.com', 'ftn.gym@gmail.com', 'ftn.gym@gmail.com', 'ftn.gym@gmail.com', 'ftn.gym@gmail.com', 'ftn.gym@gmail.com', TRUE);