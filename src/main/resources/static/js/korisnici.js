$(document).on("submit", "form", function(event){

    // da se izbegne izvrsavanja pravog submita forme
    event.preventDefault();

    var email = $("#email").val();
    var lozinka = $("#lozinka").val();

    var myJSON = formToJSON(email, lozinka);

    $.ajax({
        type: "POST",
        url: "http://localhost:8083/api/korisnici",
        dataType: "json",
        contentType: "application/json",
        data: myJSON,
        success: function (data) {
            // data = ulogovani korisnik koji je vratila metoda iz kontrolera
            // mozemo tu vrednost da ispisemo u konzoli
            console.log(data);

            // postavljamo ulogovanog korisnika na localStorage
            // na isti nacin moze da se postavi i email, username itd.
            localStorage.setItem('uloga', data['uloga']);

            // kasnije u bilo kom js fajlu moze da se dobavi ulogovani korisnik ili njegova uloga na sledeci nacin:
            var ulogaUlogovanogKorisnika = localStorage.getItem('uloga');
            // ispisujemo ulogu u konzoli da bismo potvrdili da je sve u redu
            console.log("Ovo je postavljena uloga ulogovanog korisnika:" + ulogaUlogovanogKorisnika);
            if(ulogaUlogovanogKorisnika == "Administrator"){
                window.location.href = "administrator-ulogovan.html";
            } else if (ulogaUlogovanogKorisnika == "Clan"){
                window.location.href = "clan-ulogovan.html";
            } else {
            // redirektujemo se na neku drugu stranicu
            window.location.href = "pocetna.html";}
        },
        error: function (data) {
            console.log(data);
            alert("Greska");
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
}