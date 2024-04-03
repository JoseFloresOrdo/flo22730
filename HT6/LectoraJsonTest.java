import static org.junit.Assert.assertEquals;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

public class LectoraJsonTest {
    @Test
    public void testCrearMap() {

    }

    @Test
    public void testLeerEstudiantesDesdeJSON() {
        ArrayList<String> lista= new ArrayList<>();
        LectoraJson<String, ArrayList<Estudiante>> lectora= new LectoraJson<>();
        HashMap<String, String> mapaEsperado = new HashMap<String, String>();
        assertEquals(lista, LectoraJson.leerEstudiantesDesdeJSON());
    }
}
