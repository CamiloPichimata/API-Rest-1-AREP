var buttonCtoF = document.getElementById("CalcularTempCaF");

buttonCtoF.onclick = function(){
    var TempC = document.getElementById("TempC");
    axios.get('/calcFC/C/' + TempC).then(response => {
            var rta = JSON.parse(response.data);
            var rtaFLabel = document.getElementById("rtaTempF");
            $("#rtaTempF").text("<h2>" + TempC + " °Celsius = " + rta + " °Fahrenheit </h2>");
            //rtaFLabel.innerHTML = "<h2>" + TempC + " °Celsius = " + rta + " °Fahrenheit </h2>";
        });
}