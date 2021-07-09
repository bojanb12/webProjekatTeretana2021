$(document).ready(function () {

    var fitnesCentarId = localStorage.getItem('fitnesCentarID');
    var fitnesCentarNaziv = localStorage.getItem('fitnesCentarNaziv');
    localStorage.setItem('idFC', fitnesCentarId);

    //$('#imeFC').append(fitnesCentarNaziv);

    $.ajax({
        type: "GET",
        url: "http://localhost:8085/api/sale/" + fitnesCentarId,
        dataType: "json",
        success: function (data) {
            console.log("SUCCESS:", data);


            for (i = 0; i < data.length; i++) {                     // prolazimo kroz listu svih zaposlenih

                     var row = "<tr>";
                     row += "<td>" + data[i]['kapacitet'] + "</td>";
                     row += "<td>" + data[i]['oznaka'] + "</td>";

                                                                       //dugme za aktivaciju naloga trenera (administrator mora da potvrdi registraciju)
                     var btn = "<button class='btnObrisiSalu' data-id=" + data[i]['id'] + ">Obrisi</button>";
                     row += "<td>" + btn + "</td>";
                     row += "</tr>";

                     $('#sale').append(row);                     // ubacujemo kreirani red u tabelu čiji je id = employees
            }


        },
        error: function (data) {
            console.log("ERROR:\n", data);
             alert("Odabrani fitnes centar nema registrovanih sala.");
        }
    });
});

$(document).on('click', '.btnObrisiSalu', function () {

    var idSala = this.dataset.id;

    var idFC = localStorage.getItem('idFC');

    var myJSON=formToJSON(idFC, idSala);

    $.ajax({
            type: "POST",
            url: "http://localhost:8085/api/fitnesCentri/obrisiSalu",
            dataType: "json",
            contentType: "application/json",
            data:myJSON,
            success: function (data) {
                console.log("SUCCESS : ", data);
                alert("Sala obrisana!");
                window.location.href = "listaSala.html";


            },
                   error: function (data) {
                       alert("Greska!");
                       window.location.href = "listaSala.html";
                       console.log("ERROR : ", data);
                   }
               });

});

function formToJSON(idFC, idSala) {
             return JSON.stringify(
                      {
                        "idFC": idFC,
                        "idSala": idSala
                       }
             );
       };

