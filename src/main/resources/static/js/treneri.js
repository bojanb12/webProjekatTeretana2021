// Prikaz svih trenera
$(document).ready(function () {

    $.ajax({
        type: "GET",
        url: "http://localhost:8083/api/treneri",
        dataType: "json",
        success: function (response) {
            console.log("SUCCESS:\n", response);

            for (let trener of response) {

                let row = "<tr>";
                row += "<td>" + trener.ime + "</td>";
                row += "<td>" + trener.prezime + "</td>";
                row += "<td>" + trener.brojTel + "</td>";
                row += "<td>" + trener.adresa + "</td>";
                row += "<td>" + trener.email + "</td>";
                row += "<td>" + trener.aktivan + "</td>";

                //dugme za aktivaciju naloga trenera (administrator mora da potvrdi registraciju)
                let btn = "<button class='btnAktiviraj' data-id=" + trener.id + ">Aktiviraj nalog</button>";
                row += "<td>" + btn + "</td>";
                row += "</tr>";

                $('#treneri').append(row);
            }
        },
        error: function (response) {
            console.log("ERROR:\n", response);
             alert("Greška!");
        }
    });
});

$(document).on('click', '.btnAktiviraj', function () {

    let trenerId = this.dataset.id;

    $.ajax({
        type: "GET",
        url: "http://localhost:8083/api/treneri/aktiviraj/" + trenerId,  // this.id je button id, a kao button id je postavljen id zaposlenog
        dataType: "json",
        success: function (data) {
            window.location.href = "treneri.html";                             // prikaži taj element
        },
        error: function () {
            console.log("Greška!");
            window.location.href = "treneri.html";
        }
    });
});