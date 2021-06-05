$(document).on("submit", "form", function(event){

    // da se izbegne izvrsavanja pravog submita forme
    event.preventDefault();

    var korisnickoIme = $("#korisnickoIme").val();
    var lozinka = $("#lozinka").val();
    var ime = $("#ime").val();
    var prezime = $("#prezime").val();
    var uloga = $("#uloga").val();
    var brojTel = $("#brojTel").val();
    var email = $("#email").val();
    var adresa = $("#adresa").val();
    var datumRodj = $("#datumRodj").val();
    var danas = new Date(); // datum registracije
    var status= 1;

    var noviJSON = formToJSON(korisnickoIme,lozinka,ime,prezime,uloga,brojTel,email,adresa,datumRodj,danas,status);

    $.ajax({
            type: "POST",
            url: "http://localhost:8080/api/registracija",
            dataType: "json",
            contentType: "application/json",
            data: noviJSON,
            success: function () {
                 alert(ime + " " + prezime + " je uspešno kreiran kao " + uloga);
                 window.location.href = "home.html";
                 },
            error: function (data) {
                 alert("Greška!");
            }
    });
});