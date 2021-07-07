 $(document).ready(function () {

    var idKorisnika = localStorage.getItem('id');

    $.ajax({
            type: "GET",
            url: "http://localhost:8083/api/clanovi/" + idKorisnika,  // this.id je button id, a kao button id je postavljen id zaposlenog
            dataType: "json",
            success: function (data) {
                console.log("SUCCESS : ", data);

                $('#ime').append(data['ime']);
                $('#prezime').append(data['prezime']);
                $('#brojTel').append(data['brojTel']);
                $('#email').append(data['email']);
                $('#adresa').append(data['adresa']);

                var employeesDiv = $("#profilClan");              // dobavi element čiji je id = oneEmployee
                employeesDiv.show();                               // prikaži taj element
            },
            error: function (data) {
                console.log("ERROR : ", data);
            }
        });
});