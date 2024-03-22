import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

public class LectoraJson<K, V> {

    public AbstractMap<K, List<Estudiante>> crearMap(AbstractMap<K, List<Estudiante>> mapa) {
        List<Estudiante> estudiantes = leerEstudiantesDesdeJSON();
        for (Estudiante estudiante : estudiantes) {
            K key = (K) estudiante.getCountry();
            if (!mapa.containsKey(key)) {
                mapa.put(key, new ArrayList<>());
            }
            mapa.get(key).add(estudiante);
        }
        return mapa;
    }
    
    public AbstractMap<K, Estudiante> crearMapIndividual(AbstractMap<K, Estudiante> mapa, Hash codificacion) {
        List<Estudiante> estudiantes = leerEstudiantesDesdeJSON();
        for (Estudiante estudiante : estudiantes) {
            K key = (K) codificacion.Codificar(estudiante.getEmail());
            mapa.put(key, estudiante);
        }
        return mapa;
    }

    private List<Estudiante> leerEstudiantesDesdeJSON() {
        List<Estudiante> estudiantes = new ArrayList<>();
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("estudiantes.json"));
            JSONArray jsonArray = (JSONArray) obj;

            for (Object o : jsonArray) {
                JSONObject jsonObject = (JSONObject) o;
                Estudiante estudiante = new Estudiante();
                estudiante.setName((String) jsonObject.get("name"));
                estudiante.setPhone((String) jsonObject.get("phone"));
                estudiante.setEmail((String) jsonObject.get("email"));
                estudiante.setPostalZip((String) jsonObject.get("postalZip"));
                estudiante.setCountry((String) jsonObject.get("country"));

                estudiantes.add(estudiante);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return estudiantes;
    }
}