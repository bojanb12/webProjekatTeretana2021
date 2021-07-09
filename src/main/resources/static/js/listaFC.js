// Prikaz liste fitnes centara
$(document).ready(function () {

    $.ajax({
        type: "GET",
        url: "http://localhost:8085/api/fitnesCentri",
        dataType: "json",
        success: function (response) {
            console.log("SUCCESS:\n", response);

            for (let fitnesCentar of response) {

                var  row = "<tr>";
                row += "<td>" + fitnesCentar.nazivFC + "</td>";
                row += "<td>" + fitnesCentar.adresaFC + "</td>";
                row += "<td>" + fitnesCentar.telefonFC + "</td>";
                row += "<td>" + fitnesCentar.emailFC + "</td>";





                //dugme za dodavanje nove sale
                let btn = "<button class='btnSale' data-id=" + fitnesCentar.id + ">Sale</button>";
                row += "<td>" + btn + "</td>";

                let btn2 = "<button class='btnEditFC' data-id=" + fitnesCentar.id + ">Izmeni</button>";
                row += "<td>" + btn2 + "</td>";

                let btn3 = "<button class='btnObrisiFC' data-id=" + fitnesCentar.id + ">Obrisi</button>";
                row += "<td>" + btn3 + "</td>";

                row += "</tr>";

                $('#fitnesCentri').append(row);
            }
        },
        error: function (response) {
            console.log("ERROR:\n", response);
             alert("Greška!");
        }
    });
});

$(document).on('click', '.btnSale', function () {

    let fitnesCentarId = this.dataset.id;
    localStorage.setItem('fitnesCentarID', fitnesCentarId);

    let fitnesCentarNaziv = this.dataset.nazivFC;
    localStorage.setItem('fitnesCentarNaziv', fitnesCentarNaziv);

    window.location.href = "listaSala.html";

});


$(document).on('click', '.btnObrisiFC', function () {

    let idFC = this.dataset.id;

    $.ajax({
            type: "DELETE",
            url: "http://localhost:8085/api/fitnesCentri/delete/" + idFC,  // this.id je button id, a kao button id je postavljen id zaposlenog
            dataType: "json",
            success: function (data) {
                window.location.href = "fitnesCentarDeleted.html";                             // prikaži taj element
            },
            error: function () {
                alert("Fitnes centar obrisan!");
                console.log("Fitnes centar je obrisan");
                window.location.href = "listaFC.html";
            }
        });

});

 /*$(document).ready(function() {
                    $.ajax({
                        type: "GET",
                        url: "http://localhost:8083/api/termini",
                        dataType: "json",
                        success: function (response) {
                            console.log("SUCCESS:\n", response);

                            for (let termin of response) {

                                var  row = "<tr>";
                                row += "<td>" + "<td>" + "<td>" + "<td>" + termin.vreme + "</td>";





                                //dugme za aktivaciju naloga trenera (administrator mora da potvrdi registraciju)
                                //let btn = "<button class='btnAktiviraj' data-id=" + trener.id + ">Aktiviraj nalog</button>";
                                //row += "<td>" + btn + "</td>";
                                row += "</tr>";

                                $('#treninzi').last.append(row);
                            }
                        },
                        error: function (response) {
                            console.log("ERROR:\n", response);
                             alert("Greška!");
                        }
                    });
                });

*/