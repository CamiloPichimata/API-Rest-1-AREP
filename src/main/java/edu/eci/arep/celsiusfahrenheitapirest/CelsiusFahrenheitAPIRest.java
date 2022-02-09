package edu.eci.arep.celsiusfahrenheitapirest;

import static spark.Spark.*;

/**
 * API Rest que permite hacer la conversión tanto de Celsius a Fahrenheit como
 * de Fahrenheit a Celsius
 *
 * @author Camilo Pichimata
 */
public class CelsiusFahrenheitAPIRest {

    /**
     * Método principal de la aplicación
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Inicializando Servidor...");
        port(getPort());
        
        staticFiles.location("/");
        get("/calcFC", (req, res) -> res.redirect(null, getPort()););
        
        
        get("/hello", (req, res) -> "Hello Heroku...");
        get("/hello/:num", (req, res) -> "Hello Heroku... " + req.params(":num"));
        
        CalculadoraCFServiceImpl calculadoraCF = new CalculadoraCFServiceImpl();
        get("/calcFC/:UnidadTemp/:Grados", (req, res) -> {
            String unidadTemp = req.params(":UnidadTemp");
            Double grados = Double.parseDouble(req.params(":Grados"));
            Double rta;
            if (unidadTemp.equals("C") || unidadTemp.equals("Centigrados")) {
                rta = calculadoraCF.celsiusAFahrenheit(grados);
            } else if (unidadTemp.equals("F") || unidadTemp.equals("Fahrenheit")) {
                rta = calculadoraCF.fahrenheitACelsius(grados);   
            } else {
                return "No se ha podido realizar el cálculo, por favor revise los datos ingresados";
            }
            System.out.println("rta " + rta);
            return rta;
        });
    }

    /**
     * Busca una de las variables de entorno del sistema operativo llamada PORT,
     * si no está definida, retorna el puerto por defecto
     *
     * @return - Entero con el número del puerto definido o uno por defecto
     * (4567) en caso de que no se haya definido
     */
    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}
