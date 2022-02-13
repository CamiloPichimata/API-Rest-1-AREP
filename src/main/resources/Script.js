var buttonCtoF = document.getElementById("CalcularTempCaF");

buttonCtoF.onclick = function() {
    console.log("Click Botón Calcular °F");
    var TempC = document.getElementById("GET-TempC");
    axios.get('/calcFC/C/' + TempC.value).then(response => {
            var rta = JSON.parse(response.data);
            var rtaFLabel = document.getElementById("rtaTempF");
            rtaFLabel.innerHTML = TempC.value + " °Celsius = " + rta + " °Fahrenheit";
        });
}

var buttonFtoC = document.getElementById("CalcularTempFaC");

buttonFtoC.onclick = function() {
    console.log("Click Botón Calcular °C");
    var TempF = document.getElementById("GET-TempF");
    axios.get('/calcFC/F/' + TempF.value).then(response => {
            var rta = JSON.parse(response.data);
            var rtaCLabel = document.getElementById("rtaTempC");
            rtaCLabel.innerHTML = TempF.value + " °Fahrenheit = " + rta + " °Celsius";
        });
}
