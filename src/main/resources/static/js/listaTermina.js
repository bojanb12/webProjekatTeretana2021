$(document).ready(function () {

    var treningId = localStorage.getItem('treningId');
    var treningNaziv = localStorage.getItem('treningNaziv');

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
                     var btn = "<button class='btnPrijaviTermin' data-id=" + data[i]['id'] + ">Prijavi se na termin</button>";
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