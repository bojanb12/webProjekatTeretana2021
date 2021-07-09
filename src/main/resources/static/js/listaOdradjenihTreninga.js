// Prikaz svih treninga
$(document).ready(function () {

    var clanId = localStorage.getItem('id');

    $.ajax({
        type: "GET",
        url: "http://localhost:8085/api/treninzi/odradjeni/" + clanId,
        dataType: "json",
        success: function (response) {
            console.log("SUCCESS:\n", response);

            for (let trening of response) {

                var  row = "<tr>";
                row += "<td>" + trening.naziv + "</td>";
                row += "<td>" + trening.tipTreninga + "</td>";
                row += "<td>" + trening.trajanjeTreninga + "</td>";





                //dugme za aktivaciju naloga trenera (administrator mora da potvrdi registraciju)
                let btn = "<button class='btnTerminiPrikaz' data-id=" + trening.id + ">Termini</button>";
                row += "<td>" + btn + "</td>";
                row += "</tr>";

                $('#treninzi').append(row);
            }
        },
        error: function (response) {
            console.log("ERROR:\n", response);
             alert("Nemate prijavljenih treninga.");
        }
    });
});

$(document).on('click', '.btnTerminiPrikaz', function () {

    let treningId2 = this.dataset.id;
    let treningNaziv2 = this.dataset.naziv;
    localStorage.setItem('treningId2', treningId2);
    localStorage.setItem('treningNaziv2', treningNaziv2);
    window.location.href = "terminiTrener.html";

});