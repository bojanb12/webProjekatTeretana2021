$(document).on("submit", "form", function(event){

    // da se izbegne izvrsavanja pravog submita forme
    event.preventDefault();

    var vreme = $("#vreme").val();
    var dan = $("#dan").val();
    var cena = $("#cena").val();
    var slobodnihMesta = $("#slobodnihMesta").val();
    var treningID = localStorage.getItem('treningId2');

    //var danas = new Date(); // datum registracije

    var noviJSON = formToJSON(vreme, dan, cena, slobodnihMesta);

    $.ajax({
            type: "POST",
            url: "http://localhost:8085/api/termini/registration/" + treningID,
            dataType: "json",
            contentType: "application/json",
            data: noviJSON,
            success: function () {
                 alert("Termin  je uspešno kreiran!");
                 window.location.href = "terminiTrener.html";
                 },
            error: function (data) {
                 alert("Greška!");
            }
    });
});

function formToJSON(vreme, dan, cena, slobodnihMesta){
    return JSON.stringify(
        {
        "vreme": vreme,
        "dan": dan,
        "cena": cena,
        "slobodnihMesta": slobodnihMesta

        }
    );
};