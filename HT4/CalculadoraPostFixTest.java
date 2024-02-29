/*
 * Autores: Allen Estuardo Ramírez De Paz, 22326.
 * José Javier Flores Ordoñez, 22730
 * Catedrático: Moisés Alonso
 * Auxiliar: Joaquín Puente
 * 
 * 
 */
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class CalculadoraPostFixTest {
    Lectora lectora = new Lectora();
   

    @Test
    public void testValidateExpression() {
        IStack<String> Factorio = new StackVector<String>(); 
        CalculadoraPostFix calc = new CalculadoraPostFix(Factorio);
        Conversor conversor= new Conversor();
        
        ArrayList<String>  prueba = new ArrayList<String>(Arrays.asList("(","8","/","8",")","*","2","+","1"));
        assertEquals(prueba, conversor.validateExpression(lectora.readFile("Num.txt").get(0)));
       
    }
    
 

  

}
