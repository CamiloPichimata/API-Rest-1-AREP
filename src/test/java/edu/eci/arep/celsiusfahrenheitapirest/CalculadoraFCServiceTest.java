package edu.eci.arep.celsiusfahrenheitapirest;
/**
 * @author Camilo Andrés Pichimata Cárdenas
 */
import org.junit.Assert;
import org.junit.Test;

public class CalculadoraFCServiceTest {
    private CalculadoraCFService calculadoraFC = new CalculadoraCFServiceImpl();

    @Test
    public void deberiaConvertirDeFahrenheitACelsius() {
        Double resultado = calculadoraFC.fahrenheitACelsius(59);
        Double rta = 15.0;
        Assert.assertEquals(rta, resultado);
    }
    
    @Test
    public void deberiaConvertirDeCelsiusAFahrenheit() {
        Double resultado = calculadoraFC.celsiusAFahrenheit(10);
        Double rta = 50.0;
        Assert.assertEquals(rta, resultado);	
    }
}
