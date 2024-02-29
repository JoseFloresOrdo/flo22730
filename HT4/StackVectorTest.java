/*
 * Autores: Allen Estuardo Ramírez De Paz, 22326.
 * José Javier Flores Ordoñez, 22730
 * Catedrático: Moisés Alonso
 * Auxiliar: Joaquín Puente
 * 
 * 
 */
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StackVectorTest {
    @Test
    public void testCount() {

    }

    @Test
    public void testIsEmpty() {

    }

    @Test
    public void testPeek() {

    }

    @SuppressWarnings("unchecked")
    @Test
    public void testPop() {
        StackVector stack= new StackVector<>();

        stack.push(1);
        assertEquals(1,stack.pop());
    }

    @Test
    public void testPull() {

    }

    @Test
    public void testPush() {

    }
}
