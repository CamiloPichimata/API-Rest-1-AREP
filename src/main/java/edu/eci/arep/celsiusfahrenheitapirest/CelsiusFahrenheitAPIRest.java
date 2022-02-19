package edu.eci.arep.celsiusfahrenheitapirest;

import static spark.Spark.*;

import com.google.gson.Gson;

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
        get("/calcFC", (req, res) -> {
        	res.redirect("/index.html");
        	return null;
        });
        
        CalculadoraCFServiceImpl calculadoraCF = new CalculadoraCFServiceImpl();
        get("/calcFC/:UnidadTemp/:Grados", (req, res) -> {
        	res.type("application/json");
            String unidadTemp = req.params(":UnidadTemp");
            Double grados = null;
            try {
            	grados = Double.parseDouble(req.params(":Grados"));	
			} catch (Exception e) {
				res.status(400);
				return "<h1> 400 Bad Request: El número de grados ingresado no es válido </h1>";
			}
            
            Double rta;
            
            if (unidadTemp.equals("C") || unidadTemp.equals("Centigrados")) {
                rta = calculadoraCF.celsiusAFahrenheit(grados);
            	//rta = "<h1> " + grados + " °Celsius = " + calculadoraCF.celsiusAFahrenheit(grados) + " °Fahrenheit </h1>";
            } else if (unidadTemp.equals("F") || unidadTemp.equals("Fahrenheit")) {
                rta = calculadoraCF.fahrenheitACelsius(grados);
            	//rta = "<h1> " + grados + " °Fahrenheit = " + calculadoraCF.fahrenheitACelsius(grados) + " °Celsius </h1>";   
            } else {
            	res.status(400);
                return "<h1> 400 Bad Request: No se ha podido realizar el cálculo, por favor revise los datos ingresados </h1>";
            }
            res.status(200);
            return new Gson().toJson(rta);
            
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
