$(document).on("submit", "form", function(event){

    // da se izbegne izvrsavanja pravog submita forme
    event.preventDefault();

    var oznaka = $("#oznaka").val();
    var kapacitet = $("#kapacitet").val();
    var fitnesCentarId = localStorage.getItem('fitnesCentarID');

    //var danas = new Date(); // datum registracije

    var noviJSON = formToJSON(oznaka, kapacitet);

    $.ajax({
            type: "POST",
            url: "http://localhost:8085/api/sale/registration/" + fitnesCentarId,
            dataType: "json",
            contentType: "application/json",
            data: noviJSON,
            success: function () {
                 alert("Sala " + oznaka + " je uspešno registrovana!");
                 window.location.href = "listaSala.html";
                 },
            error: function (data) {
                 alert("Greška!");
            }
    });
});

function formToJSON(oznaka, kapacitet, fitnesCentarId){
    return JSON.stringify(
        {
        "oznaka": oznaka,
        "kapacitet": kapacitet
        //"fitnesCentarId": fitnesCentarId
        }
    );
};