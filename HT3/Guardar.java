import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Guardar {
    
    public void guardarNumerosOrdenados(ArrayList<Integer> numeros, String nombreArchivo) {
        // Intentar escribir los números ordenados en el archivo
        try (FileWriter escritor = new FileWriter(nombreArchivo)) {
            // Escribir los números ordenados en el archivo
            for (int numero : numeros) {
                escritor.write(numero + "\n");
            }
            System.out.println("Se han guardado los números ordenados en el archivo '" + nombreArchivo + "'.");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al escribir en el archivo: " + e.getMessage());
        }
    }
}


