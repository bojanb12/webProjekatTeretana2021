$(document).on("submit", "form", function(event){

    // da se izbegne izvrsavanja pravog submita forme
    event.preventDefault();

    var email = $("#email").val();
    var lozinka = $("#lozinka").val();
    var uloga = $("#uloga").val(); // uzmemo ulogu koju je korisnik izabrao da znamo gde ga logujemo
    // ako je izabrao pogresnu ulogu i ne postoje ti kredencijali za nju izbaci se greska

    var myJSON = formToJSON(email, lozinka);

    // veliki if sa 3 opcije: clan, trener, admin (svaki salje na odredjeni /api/../login za logovanje, jer se sva tri entiteta cuvaju posebno
    if (uloga == 'Clan') {
        $.ajax({
            type: "POST",
            url: "http://localhost:8083/api/clanovi/login",
            dataType: "json",
            contentType: "application/json",
            data: myJSON,
            success: function (data) {

                console.log(data);


                //localStorage.setItem('email', data['email']);
                //localStorage.setItem('lozinka', data['lozinka']);

                localStorage.setItem('id', data['id']);
                localStorage.setItem('email', data['email']);
                localStorage.setItem('lozinka', data['lozinka']);
                localStorage.setItem('uloga', data['uloga']);
                localStorage.setItem('korisnickoIme', data['korisnickoIme']);


                var ulogaUlogovanogKorisnika = localStorage.getItem('uloga');
                var korisnickoImeUlogovanogKorisnika = localStorage.getItem('korisnickoIme');

                console.log("Ovo je postavljena uloga ulogovanog korisnika:" + ulogaUlogovanogKorisnika);


                alert("Ulogovan je član " + korisnickoImeUlogovanogKorisnika + " .");
                window.location.href = "pocetna.html";


            },
            error: function (data) {
                console.log(data);
                alert("Greska pri logovanju!");
            }
    });
    }
    else if (uloga == 'Trener'){
    $.ajax({
                type: "POST",
                url: "http://localhost:8083/api/treneri/login",
                dataType: "json",
                contentType: "application/json",
                data: myJSON,
                success: function (data) {

                    console.log(data);


                    localStorage.setItem('id', data['id']);
                    localStorage.setItem('email', data['email']);
                    localStorage.setItem('lozinka', data['lozinka']);
                    localStorage.setItem('uloga', data['uloga']);
                    localStorage.setItem('korisnickoIme', data['korisnickoIme']);
                    localStorage.setItem('aktivan', data['aktivan']);



                    var ulogaUlogovanogKorisnika = localStorage.getItem('uloga');
                    var korisnickoImeUlogovanogKorisnika = localStorage.getItem('korisnickoIme');
                    var nalogAktivan = localStorage.getItem('aktivan');

                    console.log("Ovo je postavljena uloga ulogovanog korisnika:" + ulogaUlogovanogKorisnika);
                    console.log("Ovo je stanje naloga trenera:" + nalogAktivan);
                    if (nalogAktivan == 'true'){

                        alert("Ulogovan je trener " + korisnickoImeUlogovanogKorisnika + " .");
                        window.location.href = "pocetnaTrener.html";

                    }
                    else{
                        alert("Nalog za " + korisnickoImeUlogovanogKorisnika + " nije aktiviran od strane administratora.");
                        window.location.href = "index.html";
                    }

                },
                error: function (data) {
                    console.log(data);
                    alert("Greska pri logovanju!");
                }
        });
    }
    else{
        $.ajax({
                        type: "POST",
                        url: "http://localhost:8083/api/administratori/login",
                        dataType: "json",
                        contentType: "application/json",
                        data: myJSON,
                        success: function (data) {
                            // data = ulogovani korisnik koji je vratila metoda iz kontrolera
                            // mozemo tu vrednost da ispisemo u konzoli
                            console.log(data);

                            // postavljamo ulogovanog korisnika na localStorage
                            // na isti nacin moze da se postavi i email, username itd.
                            //localStorage.setItem('email', data['email']);
                            //localStorage.setItem('lozinka', data['lozinka']);

                            localStorage.setItem('id', data['id']);
                            localStorage.setItem('email', data['email']);
                            localStorage.setItem('lozinka', data['lozinka']);
                            localStorage.setItem('uloga', data['uloga']);
                            localStorage.setItem('korisnickoIme', data['korisnickoIme']);

                            // kasnije u bilo kom js fajlu moze da se dobavi ulogovani korisnik ili njegova uloga na sledeci nacin:
                            var ulogaUlogovanogKorisnika = localStorage.getItem('uloga');
                            var korisnickoImeUlogovanogKorisnika = localStorage.getItem('korisnickoIme');
                            // ispisujemo ulogu u konzoli da bismo potvrdili da je sve u redu
                            console.log("Ovo je postavljena uloga ulogovanog korisnika:" + ulogaUlogovanogKorisnika);

                            // ovde proveravamo koja je uloga ulogovanog korisnika i ispisujemo njegovo korisnicko ime i ulogu pri logovanju
                            //if (ulogaUlogovanogKorisnika == 'Administrator'){
                            alert("Ulogovan je administrator " + korisnickoImeUlogovanogKorisnika + " .");
                            window.location.href = "pocetnaAdmin.html";



                        },
                        error: function (data) {
                            console.log(data);
                            alert("Greska pri logovanju!");
                        }
                });
    }

});

function formToJSON(email, lozinka) {
    return JSON.stringify(
        {
            "email": email,
            "lozinka": lozinka
        }
    );
};


/*$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "http://localhost:8083/api/korisnici/" + this.id,
        dataType: "json",
        success: function (data) {
            console.log("SUCCESS : ", data);
            $('#ime').append(data['ime']);
            $('#prezime').append(data['prezime']);
        },
        error: function (data) {
            console.log("ERROR : ", data);
        }
    });
});
*/
