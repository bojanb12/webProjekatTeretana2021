/*$(document).ready(function () {    // Čeka se trenutak kada je DOM(Document Object Model) učitan da bi JS mogao sa njim da manipuliše.
    // ajax poziv
    $.ajax({
        type: "GET",                                                // HTTP metoda
        url: "http://localhost:8083/api/clanovi",                 // URL koji se gađa
        dataType: "json",                                           // tip povratne vrednosti
        success: function (data) {
            console.log("SUCCESS : ", data);                        // ispisujemo u konzoli povratnu vrednost
            for (i = 0; i < data.length; i++) {                     // prolazimo kroz listu svih zaposlenih
                var row = "<tr>";                                   // kreiramo red za tabelu
                row += "<td>" + data[i]['id'] + "</td>";     // ubacujemo podatke jednog zaposlenog u polja
                row += "<td>" + data[i]['korisnickoIMe'] + "</td>";
                row += "<td>" + data[i]['lastName'] + "</td>";
                row += "<td>" + data[i]['userName'] + "</td>";
                row += "<td>" + data[i]['password'] + "</td>";
                row += "<td>" + data[i]['positionn'] + "</td>";
                row += "<td>" + data[i]['adress'] + "</td>";
                row += "<td>" + data[i]['email'] + "</td>";
                row += "<td>" + data[i]['phoneNumber'] + "</td>";

                // kreiramo button i stavljamo idButton = idZaposlenog
                var btn = "<button class='btnSeeMore' id = " + data[i]['id'] + ">See more</button>";
                var btn1="<button class='btnDelete' id= " + data[i]['id'] + "> Delete </button>";
                var btn2="<button class='btnPromeniUlogu' id= " + data[i]['id'] + "> Promeni Ulogu </button>";
                var btn3="<button class='btnPromeniUlogu' id= " + data[i]['id'] + "> Izmeni Korisnika </button>";

                row += "<td>" + btn + "</td>";                      // ubacujemo button u poslednje polje reda
                row += "<td>" + btn1 + "</td>";
                row += "<td>" + btn2 + "</td>";
                row += "<td>" + btn3 + "</td>";

                $('#korisnici').append(row);                        // ubacujemo kreirani red u tabelu čiji je id = employees
            }
            var ulogaUlogovanogKorisnika = localStorage.getItem('positionn');
            if (ulogaUlogovanogKorisnika!="Administrator"){
                var provera=$("#allKorisnici");
                provera.hide();
                }

        },
               error: function (data) {
                   console.log("ERROR : ", data);
               }
           });
       });