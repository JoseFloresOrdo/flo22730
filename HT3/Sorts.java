import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Sorts {
    public static void main(String[] args) {
        // Crear una instancia de la clase Random para generar números aleatorios
        Random random = new Random();

        // Nombre del archivo para guardar los números
        String nombreArchivo = "numeros_enteros.txt";
        Scanner teclado = new Scanner(System.in);
        ArrayList<Integer> numeros = new ArrayList<>();
        Gnome nomo = new Gnome();
        Guardar Guarda = new Guardar();
        Merge Merge = new Merge();
        Quick Quick = new Quick();
        Radix Radix = new Radix();
        Selection Selection = new Selection();
        Shell Shell = new Shell();
        Heap Heap = new Heap();

        // Intentar escribir los números en el archivo
        try (FileWriter escritor = new FileWriter(nombreArchivo)) {
            // Generar 3000 números enteros aleatorios y escribirlos en el archivo
            for (int i = 0; i < 3000; i++) {
                int numeroAleatorio = random.nextInt(10001); // Números aleatorios en el rango de 0 a 10000
                escritor.write(numeroAleatorio + "\n");
            }
            System.out.println("Se han generado y guardado 3000 números enteros aleatorios en el archivo '" + nombreArchivo + "'.");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al escribir en el archivo: " + e.getMessage());
        }

        try (BufferedReader lector = new BufferedReader(new FileReader("numeros_enteros.txt"))) {
            String linea;
            // Leer cada línea del archivo
            while ((linea = lector.readLine()) != null) {
                // Convertir la línea a un entero y agregarlo al ArrayList
                numeros.add(Integer.parseInt(linea));
            }
            System.out.println("Se han leído los números del archivo y se han almacenado en el ArrayList.");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el archivo: " + e.getMessage());
        }

        // Definir la cantidad inicial de datos aleatorios
        int initialSize = 500;
        int increment = 500; // Incremento en cada iteración
        int iterations = 5; // Número de iteraciones
        
        for (int i = 0; i < iterations; i++) {
            // Generar y agregar datos aleatorios
            for (int j = 0; j < initialSize + i * increment; j++) {
                numeros.add(random.nextInt(10000)); // Números aleatorios del 0 al 9999
            }

            nomo.gnomeSort(numeros);
    
            // Mostrar la cantidad de datos generados
            System.out.println("Cantidad de datos generados en la iteración " + (i+1) + ": " + numeros.size());
        }

    }
}
