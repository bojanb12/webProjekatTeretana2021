$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "http://localhost:8083/api/korisnici/" + this.id,
        dataType: "json",
        success: function (data) {
            console.log("SUCCESS : ", data);
            $('#ime').append(data['ime']);
            $('#prezime').append(data['prezime']);
        },
        error: function (data) {
            console.log("ERROR : ", data);
        }
    });
});