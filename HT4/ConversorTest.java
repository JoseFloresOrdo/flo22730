import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class ConversorTest {
    @Test
    public void testConvertir() {
        Conversor conversor= new Conversor();

        ArrayList<String> infix= conversor.validateExpression("( 2 + 1 ) * 9");
        assertEquals("2 1 + 9 *",conversor.conversor(infix) );
    }

    @Test
    public void testPuesto() {

    }

    @Test
    public void testValidateExpression() {

    }
}
