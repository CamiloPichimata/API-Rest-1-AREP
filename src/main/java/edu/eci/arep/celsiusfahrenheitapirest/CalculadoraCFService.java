package edu.eci.arep.celsiusfahrenheitapirest;

/**
 * Especifica las funciones que ejecuta la calculadora de convversión de 
 * temperatura
 * 
 * @author Camilo Pichimata
 */
public interface CalculadoraCFService {
    
    public double celsiusAFahrenheit(double celsius);
    
    public double fahrenheitACelsius(double fahrenheit);
    
}
