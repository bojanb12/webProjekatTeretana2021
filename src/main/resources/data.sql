-- admin nalog za pristupanje admin funkcionalnostima
INSERT INTO ADMINISTRATOR (KORISNICKO_IME, LOZINKA, IME, PREZIME, BROJ_TEL, EMAIL, ADRESA, DATUM_RODJENJA, ULOGA) VALUES ('Admin1', 'admin', 'Eric', 'Clapton', '+3819957432', 'admin@admin', '21 Baker Street', 'Mart 30.1945', 'Administrator');


INSERT INTO CLAN (KORISNICKO_IME, LOZINKA, IME, PREZIME, BROJ_TEL, EMAIL, ADRESA, DATUM_RODJENJA, AKTIVAN, ULOGA) VALUES ('Clan1', 'clan', 'Alice', 'Liddel', '+381600093', 'clan@clan', 'Wonderland Sreet 22', '08.11.1954.', TRUE, 'Clan');
INSERT INTO CLAN (KORISNICKO_IME, LOZINKA, IME, PREZIME, BROJ_TEL, EMAIL, ADRESA, DATUM_RODJENJA, AKTIVAN, ULOGA) VALUES ('Clan2', 'clan1', 'Mark', 'Knopfler', '+381600093', 'clan1@gmail.com', 'Sulstans of Swing 28', '17.03.1967.', TRUE, 'Clan');
--trener
INSERT INTO TRENER (KORISNICKO_IME, LOZINKA, IME, PREZIME, BROJ_TEL, EMAIL, ADRESA, DATUM_RODJENJA, AKTIVAN, ULOGA) VALUES ('TRENER1', 'trener', 'Eric', 'Clapton', '+3819957432', 'trener@trener', '21 Baker Street', 'Mart 30.1945', TRUE, 'Trener');
INSERT INTO TRENER (KORISNICKO_IME, LOZINKA, IME, PREZIME, BROJ_TEL, EMAIL, ADRESA, DATUM_RODJENJA, AKTIVAN, ULOGA) VALUES ('trenerPera', 'trener1', 'Pera', 'Peric', '+381444448', 'trener@gmail.com', 'Narodnog Fronta 40', '15.02.1978.', TRUE, 'Trener');
INSERT INTO TRENER (KORISNICKO_IME, LOZINKA, IME, PREZIME, BROJ_TEL, EMAIL, ADRESA, DATUM_RODJENJA, AKTIVAN, ULOGA) VALUES ('TRENER2', 'TRENER2', 'Kazuo', 'Ishiguro', '+381655452', 'TRENER2@gmail.com', 'Osaka', '08.11.1954.', FALSE, 'Trener');
INSERT INTO TRENER (KORISNICKO_IME, LOZINKA, IME, PREZIME, BROJ_TEL, EMAIL, ADRESA, DATUM_RODJENJA, AKTIVAN, ULOGA) VALUES ('Trener Goran', 'trenergoran', 'Goran', 'Gorić', '+381222788', 'goran.g@gmail.com', 'Novosadska 17', 'Mart 30.1945', FALSE, 'Trener');
INSERT INTO TRENER (KORISNICKO_IME, LOZINKA, IME, PREZIME, BROJ_TEL, EMAIL, ADRESA, DATUM_RODJENJA, AKTIVAN, ULOGA) VALUES ('trenerPera', 'trener2', 'Pera', 'Pericic', '+381444448', 'pera@gmail.com', 'Narodnog Fronta 178', '15.02.1978.', TRUE, 'Trener');
INSERT INTO TRENER (KORISNICKO_IME, LOZINKA, IME, PREZIME, BROJ_TEL, EMAIL, ADRESA, DATUM_RODJENJA, AKTIVAN, ULOGA) VALUES ('alice22', 'trener2', 'Alice', 'Liddel', '+381600093', 'trener2@gmail.com', 'Wonderland Sreet 22', '08.11.1954.', TRUE, 'Trener');

--INSERT INTO CLAN (KORISNICKO_IME, LOZINKA, IME, PREZIME, BROJ_TEL, EMAIL, ADRESA, DATUM_RODJENJA, AKTIVAN, ULOGA) VALUES ('alice22', 'trener2', 'Alice', 'Liddel', '+381600093', 'trener2@gmail.com', 'Wonderland Sreet 22', '08.11.1954.', TRUE, 'Clan');
--INSERT INTO CLAN (KORISNICKO_IME, LOZINKA, IME, PREZIME, BROJ_TEL, EMAIL, ADRESA, DATUM_RODJENJA, AKTIVAN, ULOGA) VALUES ('TRENER1', 'clan', 'Eric', 'Clapton', '+3819957432', 'clan@clan', '21 Baker Street', 'Mart 30.1945', TRUE, 'Clan');


--trening
INSERT INTO TRENING (NAZIV, OPIS, TIP_TRENINGA, TRAJANJE_TRENINGA, TRENER_TRENINGA_ID) VALUES ('Lift It!', 'Vežbe sa tegovima', 'Weight Lifting', '45min', 1);
INSERT INTO TRENING (NAZIV, OPIS, TIP_TRENINGA, TRAJANJE_TRENINGA, TRENER_TRENINGA_ID) VALUES ('Burn It!', 'Trčanje i skakanje', 'Kondicioni trening', '60min', 1);
INSERT INTO TRENING (NAZIV, OPIS, TIP_TRENINGA, TRAJANJE_TRENINGA) VALUES ('Yoga 1', 'Istezanje i pokretnost mišića', 'Istezanje', '30min');
INSERT INTO TRENING (NAZIV, OPIS, TIP_TRENINGA, TRAJANJE_TRENINGA) VALUES ('Arms day', 'Istezanje i pokretnost mišića', 'Vežbanje', '30min');
INSERT INTO TRENING (NAZIV, OPIS, TIP_TRENINGA, TRAJANJE_TRENINGA) VALUES ('Yoga 3', 'Istezanje i pokretnost mišića', 'Istezanje', '30min');
--INSERT INTO TRENING (NAZIV, OPIS, TIP_TRENINGA, TRAJANJE_TRENINGA) VALUES ('Burn It 2!', 'Trčanje i skakanje', 'Kondicioni trening', '45min');
--INSERT INTO TRENING (NAZIV, OPIS, TIP_TRENINGA, TRAJANJE_TRENINGA) VALUES ('Burn It MAX!', 'Trčanje i skakanje', 'Kondicioni trening', '120min');
--INSERT INTO TRENING (NAZIV, OPIS, TIP_TRENINGA, TRAJANJE_TRENINGA) VALUES ('Lift It!', 'Vežbe sa tegovima', 'Weight Lifting', '45min');
--INSERT INTO TRENING (NAZIV, OPIS, TIP_TRENINGA, TRAJANJE_TRENINGA) VALUES ('Runing', 'Trčanje i skakanje', 'Kondicioni trening', '60min');
--INSERT INTO TRENING (NAZIV, OPIS, TIP_TRENINGA, TRAJANJE_TRENINGA) VALUES ('Yoga 5', 'Istezanje i pokretnost mišića', 'Istezanje', '30min');
--INSERT INTO TRENING (NAZIV, OPIS, TIP_TRENINGA, TRAJANJE_TRENINGA) VALUES ('Yoga 4', 'Istezanje i pokretnost mišića', 'Istezanje', '30min');
--INSERT INTO TRENING (NAZIV, OPIS, TIP_TRENINGA, TRAJANJE_TRENINGA) VALUES ('Aerobik 1', 'Istezanje i pokretnost mišića', 'Vežbanje', '30min');
--INSERT INTO TRENING (NAZIV, OPIS, TIP_TRENINGA, TRAJANJE_TRENINGA) VALUES ('Rekreativni trening', 'Trčanje i skakanje', 'Kondicioni trening', '45min');
--INSERT INTO TRENING (NAZIV, OPIS, TIP_TRENINGA, TRAJANJE_TRENINGA) VALUES ('Leg Day', 'Trčanje i skakanje', 'Muscle Building', '120min');
--INSERT INTO TRENING (NAZIV, OPIS, TIP_TRENINGA, TRAJANJE_TRENINGA) VALUES ('Lift It!', 'Vežbe sa tegovima', 'Weight Lifting', '45min');
--INSERT INTO TRENING (NAZIV, OPIS, TIP_TRENINGA, TRAJANJE_TRENINGA) VALUES ('Burn It!', 'Trčanje i skakanje', 'Kondicioni trening', '60min');
--INSERT INTO TRENING (NAZIV, OPIS, TIP_TRENINGA, TRAJANJE_TRENINGA) VALUES ('Heavy Lifting 1', 'Istezanje i pokretnost mišića', 'Weight Lifting', '30min');
--INSERT INTO TRENING (NAZIV, OPIS, TIP_TRENINGA, TRAJANJE_TRENINGA) VALUES ('Aerobik 2', 'Istezanje i pokretnost mišića', 'Istezanje', '30min');
--INSERT INTO TRENING (NAZIV, OPIS, TIP_TRENINGA, TRAJANJE_TRENINGA) VALUES ('Aerobik 3', 'Istezanje i pokretnost mišića', 'Istezanje', '30min');
--INSERT INTO TRENING (NAZIV, OPIS, TIP_TRENINGA, TRAJANJE_TRENINGA) VALUES ('Heavy Lifting 2', 'Trčanje i skakanje', 'Weight Lifting', '45min');
--INSERT INTO TRENING (NAZIV, OPIS, TIP_TRENINGA, TRAJANJE_TRENINGA) VALUES ('Rekreacija', 'Trčanje i skakanje', 'Kondicioni trening', '120min');


-- trener - termin

INSERT INTO DRZI_TRENINGE (trening_id, trener_id) VALUES (1, 1);
INSERT INTO DRZI_TRENINGE (trener_id, trening_id) VALUES (1, 2);
INSERT INTO DRZI_TRENINGE (trener_id, trening_id) VALUES (1, 3);



-- TERMINI

INSERT INTO TERMIN (VREME, DAN, CENA, SLOBODNIH_MESTA) VALUES ('17:30', 'Utorak', '1500', '10');
INSERT INTO TERMIN (VREME, DAN, CENA, SLOBODNIH_MESTA) VALUES ('10:30', 'Četvrtak', '1200', '20');
INSERT INTO TERMIN (VREME, DAN, CENA, SLOBODNIH_MESTA) VALUES ('12:45', 'Petak', '1600', '5');
INSERT INTO TERMIN (VREME, DAN, CENA, SLOBODNIH_MESTA) VALUES ('12:45', 'Ponedeljak', '1600', '5');
INSERT INTO TERMIN (VREME, DAN, CENA, SLOBODNIH_MESTA) VALUES ('19:25', 'Subota', '2000', '5');

-- TRENING - TERMIN

INSERT INTO IMA_TERMINE (trening_id, termin_id) VALUES (1, 2);
INSERT INTO IMA_TERMINE (trening_id, termin_id) VALUES (1, 1);
INSERT INTO IMA_TERMINE (trening_id, termin_id) VALUES (2, 3);
INSERT INTO IMA_TERMINE (trening_id, termin_id) VALUES (2, 4);
INSERT INTO IMA_TERMINE (trening_id, termin_id) VALUES (3, 5);


INSERT INTO PRIJAVIO_TRENING (clan_id, trening_id) VALUES (1, 1);
INSERT INTO PRIJAVIO_TRENING (clan_id, trening_id) VALUES (1, 5);

INSERT INTO ODRADIO_TRENING (clan_id, trening_id) VALUES (1, 2);
INSERT INTO ODRADIO_TRENING (clan_id, trening_id) VALUES (1, 3);
INSERT INTO ODRADIO_TRENING (clan_id, trening_id) VALUES (1, 4);




INSERT INTO OCENA (komentar_ocena, vrednost_ocene) VALUES ('Odličan!', 5);

-- FITNES CENTRI - SALE

INSERT INTO FITNES_CENTAR (NAZIVFC, ADRESAFC, TELEFONFC, EMAILFC) VALUES ('FTN Gym', 'Neke Ulice 22', '+3816455872', 'ftn.gym@gmail.com');
INSERT INTO FITNES_CENTAR (NAZIVFC, ADRESAFC, TELEFONFC, EMAILFC) VALUES ('PMF Gains', 'Matematička 41', '+381645871', 'matgym@gmail.com');

INSERT INTO SALA (KAPACITET, OZNAKA) VALUES (20, 'Sala 1');
INSERT INTO SALA (KAPACITET, OZNAKA) VALUES (25, 'Sala A4');
INSERT INTO SALA (KAPACITET, OZNAKA) VALUES (50, 'Sala Sport1');
INSERT INTO SALA (KAPACITET, OZNAKA) VALUES (15, 'Sala B4');
INSERT INTO SALA (KAPACITET, OZNAKA) VALUES (10, 'Sala B3');

INSERT INTO IMA_SALE (fitnes_centar_id, sala_id) VALUES (1, 2);
INSERT INTO IMA_SALE (fitnes_centar_id, sala_id) VALUES (1, 1);
INSERT INTO IMA_SALE (fitnes_centar_id, sala_id) VALUES (1, 3);
INSERT INTO IMA_SALE (fitnes_centar_id, sala_id) VALUES (2, 5);

--INSERT INTO TRENINGTERMIN (TERMIN_ID, TRENING_ID) VALUES (1, 1);

--INSERT INTO KORISNIK (korisnicko_ime, LOZINKA, IME, PREZIME, ULOGA, broj_tel, EMAIL, ADRESA, datum_rodjenja, AKTIVAN) VALUES ('FTN Gym', 'Neke Ulice 22', '+3816455872', 'ftn.gym@gmail.com', 'ftn.gym@gmail.com', 'ftn.gym@gmail.com', 'ftn.gym@gmail.com', 'ftn.gym@gmail.com', 'ftn.gym@gmail.com', TRUE);