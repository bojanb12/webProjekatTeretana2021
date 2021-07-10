// Prikaz svih treninga
$(document).ready(function () {

    $.ajax({
        type: "GET",
        url: "http://localhost:8085/api/treninzi",
        dataType: "json",
        success: function (response) {
            console.log("SUCCESS:\n", response);

            for (let trening of response) {

                var  row = "<tr>";
                row += "<td>" + trening.naziv + "</td>";
                row += "<td>" + trening.tipTreninga + "</td>";
                row += "<td>" + trening.trajanjeTreninga + "</td>";





                //dugme za aktivaciju naloga trenera (administrator mora da potvrdi registraciju)
                let btn = "<button class='btnTermini' data-id=" + trening.id + ">Prikazi termine</button>";
                row += "<td>" + btn + "</td>";
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

$(document).on('click', '.btnTermini', function () {

    let treningId = this.dataset.id;
    let treningNaziv = this.dataset.naziv;
    localStorage.setItem('treningId3', treningId);
    localStorage.setItem('treningNaziv3', treningNaziv);
    window.location.href = "listaTerminaPocetna.html";

});