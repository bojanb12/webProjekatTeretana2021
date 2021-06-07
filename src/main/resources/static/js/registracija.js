$(document).on("submit", "form", function(event){

    // da se izbegne izvrsavanja pravog submita forme
    event.preventDefault();

    var korisnickoIme = $("#korisnickoIme").val();
    var lozinka = $("#lozinka").val();
    var ime = $("#ime").val();
    var prezime = $("#prezime").val();
    var brojTel = $("#brojTel").val();
    var email = $("#email").val();
    var adresa = $("#adresa").val();
    var datumRodjenja = $("#datumRodjenja").val();
    var aktivan = 'Da';

    //var danas = new Date(); // datum registracije

    var noviJSON = formToJSON(korisnickoIme, lozinka, ime, prezime, brojTel, email, adresa, datumRodjenja, aktivan);

    $.ajax({
            type: "POST",
            url: "http://localhost:8083/api/clanovi/registration",
            dataType: "json",
            contentType: "application/json",
            data: noviJSON,
            success: function () {
                 alert("Nalog " + ime + " " + prezime + " je uspešno kreiran!");
                 window.location.href = "home.html";
                 },
            error: function (data) {
                 alert("Greška!");
            }
    });
});

function formToJSON(korisnickoIme, lozinka, ime, prezime, brojTel, email, adresa, datumRodjenja, aktivan){
    return JSON.stringify(
        {
        "korisnickoIme": korisnickoIme,
        "lozinka": lozinka,
        "ime": ime,
        "prezime": prezime,
        "brojTel": brojTel,
        "email": email,
        "adresa": adresa,
        "datumRodjenja": datumRodjenja,
        "aktivan" : aktivan
        //"danas": danas,
        }
    );
};