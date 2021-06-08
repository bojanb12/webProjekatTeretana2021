$(document).on("submit", "form", function(event){

    // da se izbegne izvrsavanja pravog submita forme
    event.preventDefault();

    var email = $("#email").val();
    var lozinka = $("#lozinka").val();

    var myJSON = formToJSON(email, lozinka);

    $.ajax({
        type: "POST",
        url: "http://localhost:8083/api/clanovi/login",
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
            if (ulogaUlogovanogKorisnika == 'Clan'){
                alert("Ulogovan je clan " + korisnickoImeUlogovanogKorisnika + " .");
                window.location.href = "pocetna.html";
            }
            else if (ulogaUlogovanogKorisnika == 'Trener'){
                alert("Ulogovan je trener " + korisnickoImeUlogovanogKorisnika + " .");
                window.location.href = "pocetnaTrener.html";
            }
            else {
                window.location.href = "pocetna.html";
            }
            // redirektujemo se na neku drugu stranicu

        },
        error: function (data) {
            console.log(data);
            alert("Greska pri logovanju!");
        }
    });
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
