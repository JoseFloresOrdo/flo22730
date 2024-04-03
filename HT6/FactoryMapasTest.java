import org.junit.Test;

import static org.junit.Assert.assertTrue;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;
public class FactoryMapasTest {
    @Test
    public void testGetMapInstanceHashMap() {
        HashMap<String, String> mapaEsperado = new HashMap<String, String>();
        FactoryMapas<String, String> factory= new FactoryMapas<String, String>();
        assertTrue(mapaEsperado.getClass().equals(factory.getMapInstance(1).getClass()));
    }
    @Test
    public void testGetMapInstanceTreeMap() {
        TreeMap<String, String> mapaEsperado = new TreeMap<>();
        FactoryMapas<String, String> factory= new FactoryMapas<String, String>();
        assertTrue(mapaEsperado.getClass().equals(factory.getMapInstance(2).getClass()));
    }
    @Test
    public void testGetMapInstanceLinked() {
        HashMap<String, String> mapaEsperado = new LinkedHashMap<>();
        FactoryMapas<String, String> factory= new FactoryMapas<String, String>();
        assertTrue(mapaEsperado.getClass().equals(factory.getMapInstance(3).getClass()));
    }
}
