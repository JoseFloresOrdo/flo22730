import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;


public class JSONDataSource implements IExport {


    public File SaveNote(Map<String, Integer> diccionario, String nombreArchivo) {
        File archivoJSON = new File(nombreArchivo);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Escribir el diccionario como JSON en el archivo
            objectMapper.writeValue(archivoJSON, diccionario);
            System.out.println("Datos del diccionario guardados correctamente en el archivo " + nombreArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return archivoJSON;
    }


    public File SavePagos(Map<String, String> diccionario, String nombreArchivo) {
        File archivoJSON = new File(nombreArchivo);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Escribir el diccionario como JSON en el archivo
            objectMapper.writeValue(archivoJSON, diccionario);
            System.out.println("Datos del diccionario guardados correctamente en el archivo " + nombreArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return archivoJSON;
    }

    public File SaveStudDoc(Map<Estudiante, Docente> diccionario, String nombreArchivo) {
        File archivoJSON = new File(nombreArchivo);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Escribir el diccionario como JSON en el archivo
            objectMapper.writeValue(archivoJSON, diccionario);
            System.out.println("Datos del diccionario guardados correctamente en el archivo " + nombreArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return archivoJSON;
    }

    public File SaveStud(List<Estudiante> lista, String nombreArchivo) {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("[\n");

        for (int i = 0; i < lista.size(); i++) {
            jsonBuilder.append("  \"").append(lista.get(i)).append("\"");
            if (i < lista.size() - 1) {
                jsonBuilder.append(",");
            }
            jsonBuilder.append("\n");
        }

        jsonBuilder.append("]\n");

        File archivoJSON = new File(nombreArchivo);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoJSON))) {
            writer.write(jsonBuilder.toString());
            System.out.println("Lista guardada como archivo JSON exitosamente.");
            return archivoJSON;
        } catch (IOException e) {
            System.err.println("Error al guardar el archivo JSON: " + e.getMessage());
            return null;
        }
    }

    public File SaveDoc(List<Docente> lista, String nombreArchivo) {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("[\n");

        for (int i = 0; i < lista.size(); i++) {
            jsonBuilder.append("  \"").append(lista.get(i)).append("\"");
            if (i < lista.size() - 1) {
                jsonBuilder.append(",");
            }
            jsonBuilder.append("\n");
        }

        jsonBuilder.append("]\n");

        File archivoJSON = new File(nombreArchivo);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoJSON))) {
            writer.write(jsonBuilder.toString());
            System.out.println("Lista guardada como archivo JSON exitosamente.");
            return archivoJSON;
        } catch (IOException e) {
            System.err.println("Error al guardar el archivo JSON: " + e.getMessage());
            return null;
        }
    }
}