/*
 * Autores: Allen Estuardo Ramírez De Paz, 22326.
 * José Javier Flores Ordoñez, 22730
 * Catedrático: Moisés Alonso
 * Auxiliar: Joaquín Puente
 * 
 * 
 */
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class ConversorTest {
    @Test
    public void testConvertir() {
        Conversor conversor= new Conversor();

        ArrayList<String> infix= conversor.validateExpression("( 8 / 4 ) * 4");
        assertEquals("8 4 / 4 *",conversor.conversor(infix) );
    }

    @Test
    public void testPuesto() {

    }

    @Test
    public void testValidateExpression() {

    }
}
