$(document).on("submit", "form", function(event){

    // da se izbegne izvrsavanja pravog submita forme
    event.preventDefault();

    var nazivFC = $("#nazivFC").val();
    var adresaFC = $("#adresaFC").val();
    var telefonFC = $("#telefonFC").val();
    var emailFC = $("#emailFC").val();

    //var danas = new Date(); // datum registracije

    var noviJSON = formToJSON(nazivFC, adresaFC, telefonFC, emailFC);

    $.ajax({
            type: "POST",
            url: "http://localhost:8083/api/fitnesCentri/registration",
            dataType: "json",
            contentType: "application/json",
            data: noviJSON,
            success: function () {
                 alert("Fitnes centar " + nazivFC + " je uspešno registrovan!");
                 window.location.href = "pocetnaAdmin.html";
                 },
            error: function (data) {
                 alert("Greška!");
            }
    });
});

function formToJSON(nazivFC, adresaFC, telefonFC, emailFC){
    return JSON.stringify(
        {

        "nazivFC" = nazivFC,
        "adresaFC" = adresaFC,
        "telefonFC" = telefonFC,
        "emailFC" = emailFC

        }
    );
};