$(document).ready(function () {

    var treningId = localStorage.getItem('treningId2');
    var treningNaziv = localStorage.getItem('treningNaziv2');

    //$('#imeTreninga').append(treningNaziv);

    $.ajax({
        type: "GET",
        url: "http://localhost:8085/api/termini/" + treningId,
        dataType: "json",
        success: function (data) {
            console.log("SUCCESS:", data);


            for (i = 0; i < data.length; i++) {                     // prolazimo kroz listu svih zaposlenih

                     var row = "<tr>";
                     row += "<td>" + data[i]['vreme'] + "</td>";
                     row += "<td>" + data[i]['dan'] + "</td>";
                     row += "<td>" + data[i]['cena'] + "</td>";
                     row += "<td>" + data[i]['slobodnihMesta'] + "</td>";

                                                                       //dugme za aktivaciju naloga trenera (administrator mora da potvrdi registraciju)
                     var btn = "<button class='btnObrisiTermin' data-id=" + data[i]['id'] + ">Obrisi termin</button>";
                     row += "<td>" + btn + "</td>";
                     row += "</tr>";

                     $('#termini').append(row);                     // ubacujemo kreirani red u tabelu čiji je id = employees
            }


        },
        error: function (response) {
            console.log("ERROR:\n", response);
             alert("Odabrani trening nema dostupnih termina.");
        }
    });
});

$(document).on('click', '.btnObrisiTermin', function () {

    let idTermin = this.dataset.id;

    var idTrening = localStorage.getItem('treningId2');

    var myJSON=formToJSON(idTrening, idTermin);

    $.ajax({
            type: "POST",
            url: "http://localhost:8085/api/treninzi/obrisiTermin",
            dataType: "json",
            contentType: "application/json",
            data:myJSON,
            success: function (data) {
                console.log("SUCCESS : ", data);
                window.location.href = "terminiTrener.html";


            },
                   error: function (data) {
                       window.location.href = "terminiTrener.html";
                       console.log("ERROR : ", data);
                   }
               });

});

function formToJSON(idTrening, idTermin) {
             return JSON.stringify(
                      {
                        "idTrening": idTermin,
                        "idTermin": idTermin
                       }
             );
       };