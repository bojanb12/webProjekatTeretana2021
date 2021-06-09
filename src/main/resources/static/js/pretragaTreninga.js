function pretragaTipa() {

  var input, filter, table, tr, td, i, txtValue;

  input = document.getElementById("pretragaTip"); //uzmemo input iz search bara
  filter = input.value.toUpperCase(); //ako je malo slovo, pravimo veliko
  table = document.getElementById("treninzi"); //uzimamo po ID treninge
  tr = table.getElementsByTagName("tr");

//prikazujemo samo treninge kojima se pocetni string tr slaze sa unetim tr
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[1]; // ovo je ustvari kolona po kojoj trazimo (prva je tip kod treninga)
    if (td) {
      txtValue = td.textContent || td.innerText;
      if (txtValue.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }
  }
}

function pretragaNaziva() {

  var input, filter, table, tr, td, i, txtValue;
  input = document.getElementById("pretragaNaziv");
  filter = input.value.toUpperCase();
  table = document.getElementById("treninzi");
  tr = table.getElementsByTagName("tr");


  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[0]; // ovo je ustvari kolona po kojoj trazimo (nulta je naziv)
    if (td) {
      txtValue = td.textContent || td.innerText;
      if (txtValue.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }
  }
}
