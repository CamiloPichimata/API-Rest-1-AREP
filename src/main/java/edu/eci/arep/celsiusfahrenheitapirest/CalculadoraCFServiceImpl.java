package edu.eci.arep.celsiusfahrenheitapirest;

/**
 * Implementa las operaciones de conversión entre grados Celsius y Fahrenheit
 * @author Camilo Pichimata 
 */
public class CalculadoraCFServiceImpl implements CalculadoraCFService {
    
    /**
     * Constructor para la clase CalculadoraCFService
     */
    public CalculadoraCFServiceImpl() {
    }
    
    /**
     * Convierte el valor dado de grados Celsius a grados Fahrenheit 
     * @param celsius - Temperatura en grados Celsius
     * @return - Temperatura en grados Fahrenheit
     */
    @Override
    public double celsiusAFahrenheit(double celsius) {
        double rta = (celsius * 1.8) + 32;
        return rta;
    }
    
    /**
     * Convierte el valor dado de grados Fahrenheit a grados Celsius
     * @param fahrenheit - Temperatura en grados Fahrenheit
     * @return - Temperatura en grados Celsius
     */
    @Override
    public double fahrenheitACelsius(double fahrenheit) {
        double rta = (fahrenheit - 32) / 1.8;
        return rta;
    }
    
    /*
    public static void main(String[] args) {
        System.out.println("Respuesta:" + celsiusAFahrenheit(30) + "°F");
        System.out.println("Respuesta:" + fahrenheitACelsius(22) + "°C");
    }*/
}
