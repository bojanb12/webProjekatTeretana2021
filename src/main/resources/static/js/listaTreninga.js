// Prikaz svih treninga
$(document).ready(function () {

    $.ajax({
        type: "GET",
        url: "http://localhost:8083/api/treninzi",
        dataType: "json",
        success: function (response) {
            console.log("SUCCESS:\n", response);

            for (let trening of response) {

                var  row = "<tr>";
                row += "<td>" + trening.naziv + "</td>";
                row += "<td>" + trening.tipTreninga + "</td>";
                row += "<td>" + trening.trajanjeTreninga + "</td>";
               // row += "<td>" + trening.terminTreninga.getVreme() + "</td>";


                //dugme za aktivaciju naloga trenera (administrator mora da potvrdi registraciju)
                //let btn = "<button class='btnAktiviraj' data-id=" + trener.id + ">Aktiviraj nalog</button>";
                //row += "<td>" + btn + "</td>";
                row += "</tr>";

                $('#treninzi').append(row);
            }
        },
        error: function (response) {
            console.log("ERROR:\n", response);
             alert("Greška!");
        }
    });
});

