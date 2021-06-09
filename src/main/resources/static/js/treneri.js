// Prikaz svih trenera
$(document).ready(function () {    // Čeka se trenutak kada je DOM(Document Object Model) učitan da bi JS mogao sa njim da manipuliše.
    // ajax poziv za dobavljanje svih zaposlenih sa backend-a i prikaz u tabeli
    $.ajax({
        type: "GET",                                                // HTTP metoda
        url: "http://localhost:8083/api/treneri",                 // URL koji se gađa
        dataType: "json",                                           // tip povratne vrednosti
        success: function (response) {                              // ova f-ja se izvršava posle uspešnog zahteva
            console.log("SUCCESS:\n", response);                    // ispisujemo u konzoli povratnu vrednost radi provere

            for (let trener of response) {                        // prolazimo kroz listu svih zaposlenih

                let row = "<tr>";                                   // kreiramo red za tabelu
                row += "<td>" + trener.ime + "</td>";
                row += "<td>" + trener.prezime + "</td>";
                row += "<td>" + trener.brojTel + "</td>";
                row += "<td>" + trener.adresa + "</td>";
                row += "<td>" + trener.email + "</td>";
                row += "<td>" + trener.aktivan + "</td>";
                // kreiramo button i definisemo custom data atribut id = id zaposlenog
                let btn = "<button class='btnAktiviraj' data-id=" + trener.id + ">Aktiviraj/Deaktiviraj</button>";
                row += "<td>" + btn + "</td>";                      // ubacujemo button u poslednju ćeliju reda
                row += "</tr>";                                     // završavamo kreiranje reda

                $('#treneri').append(row);                        // ubacujemo kreirani red u tabelu čiji je id = employees
            }
        },
        error: function (response) {                                // ova f-ja se izvršava posle neuspešnog zahteva
            console.log("ERROR:\n", response);
             alert("Greška!");
        }
    });
});