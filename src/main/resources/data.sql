-- admin nalog za pristupanje admin funkcionalnostima
INSERT INTO ADMINISTRATOR (KORISNICKO_IME, LOZINKA, IME, PREZIME, BROJ_TEL, EMAIL, ADRESA, DATUM_RODJENJA, ULOGA) VALUES ('Admin1', 'admin', 'Eric', 'Clapton', '+3819957432', 'admin@admin', '21 Baker Street', 'Mart 30.1945', 'Administrator');
INSERT INTO TRENER (KORISNICKO_IME, LOZINKA, IME, PREZIME, BROJ_TEL, EMAIL, ADRESA, DATUM_RODJENJA, AKTIVAN, ULOGA) VALUES ('TRENER1', 'TRENER1', 'Eric', 'Clapton', '+3819957432', 'TRENER@TRENER', '21 Baker Street', 'Mart 30.1945', TRUE, 'Trener');
INSERT INTO TRENER (KORISNICKO_IME, LOZINKA, IME, PREZIME, BROJ_TEL, EMAIL, ADRESA, DATUM_RODJENJA, AKTIVAN, ULOGA) VALUES ('TRENER2', 'TRENER2', 'Kazuo', 'Ishiguro', '+381655452', 'TRENER2@gmail.com', 'Osaka', '08.11.1954.', FALSE, 'Trener');
INSERT INTO TRENER (KORISNICKO_IME, LOZINKA, IME, PREZIME, BROJ_TEL, EMAIL, ADRESA, DATUM_RODJENJA, AKTIVAN, ULOGA) VALUES ('TRENER2', 'TRENER2', 'Kazuo', 'Ishiguro', '+381655452', 'TRENER2@gmail.com', 'Osaka', '08.11.1954.', FALSE, 'Trener');
INSERT INTO OCENA (komentar_ocena, vrednost_ocene) VALUES ('Odličan!', 5);

INSERT INTO FITNES_CENTAR (NAZIVFC, ADRESAFC, TELEFONFC, EMAILFC) VALUES ('FTN Gym', 'Neke Ulice 22', '+3816455872', 'ftn.gym@gmail.com');
INSERT INTO FITNES_CENTAR (NAZIVFC, ADRESAFC, TELEFONFC, EMAILFC) VALUES ('PMF Gains', 'Matematička 41', '+381645871', 'matgym@gmail.com');

INSERT INTO SALA (KAPACITET, OZNAKA) VALUES (20, 'Sala 1');

INSERT INTO NALAZI (sala_id, fitnescentar_id) VALUES (1, 1);

--INSERT INTO KORISNIK (korisnicko_ime, LOZINKA, IME, PREZIME, ULOGA, broj_tel, EMAIL, ADRESA, datum_rodjenja, AKTIVAN) VALUES ('FTN Gym', 'Neke Ulice 22', '+3816455872', 'ftn.gym@gmail.com', 'ftn.gym@gmail.com', 'ftn.gym@gmail.com', 'ftn.gym@gmail.com', 'ftn.gym@gmail.com', 'ftn.gym@gmail.com', TRUE);