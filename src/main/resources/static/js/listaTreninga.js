// Prikaz svih treninga
$(document).ready(function () {

    $.ajax({
        type: "GET",
        url: "http://localhost:8083/api/treninzi",
        dataType: "json",
        success: function (response) {
            console.log("SUCCESS:\n", response);

            for (let trener of response) {

                var  row = "<tr>";
                row += "<td>" + trener.naziv + "</td>";
                row += "<td>" + trener.tipTreninga + "</td>";
                row += "<td>" + trener.trajanjeTreninga + "</td>";


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

