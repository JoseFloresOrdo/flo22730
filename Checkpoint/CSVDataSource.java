import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CSVDataSource implements IExport {
    
    
    public File SaveNote(Map<String, Integer> diccionario, String nombreArchivo) {
        File archivoCSV = new File(nombreArchivo);
        try (FileWriter writer = new FileWriter(archivoCSV)) {
            for (Map.Entry<String, Integer> entry : diccionario.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue() + "\n");
            }
            System.out.println("Datos del diccionario guardados correctamente en el archivo " + nombreArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return archivoCSV;
    }

    public File SavePagos(Map<String, String> pagos, String nombreArchivo) {
        File archivoCSV = new File(nombreArchivo);
        try (FileWriter writer = new FileWriter(archivoCSV)) {
            for (Map.Entry<String, String> entry : pagos.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue() + "\n");
            }
            System.out.println("Datos del diccionario guardados correctamente en el archivo " + nombreArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return archivoCSV;
    }
    public File SaveStudDoc(Map<Estudiante, Docente> pagos, String nombreArchivo) {
        File archivoCSV = new File(nombreArchivo);
        try (FileWriter writer = new FileWriter(archivoCSV)) {
            for (Map.Entry<Estudiante, Docente> entry : pagos.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue() + "\n");
            }
            System.out.println("Datos del diccionario guardados correctamente en el archivo " + nombreArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return archivoCSV;
    }
    public File SaveStud(List<Estudiante> arrayList, String nombreArchivo) {
        File archivoCSV = new File(nombreArchivo);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoCSV))) {
            for (Estudiante producto : arrayList) {
                // Escribir los atributos del producto en el archivo CSV
                writer.write(producto.getNombre());
                writer.write(",");
                writer.write(producto.getApellido());
                writer.write(",");
                writer.write(producto.getPagos());
                writer.write(",");
                writer.newLine();
            }
            System.out.println("ArrayList de productos guardada como archivo CSV exitosamente.");
            return archivoCSV;
        } catch (IOException e) {
            System.err.println("Error al guardar el archivo CSV: " + e.getMessage());
            return null;
        }
    }
    public File SaveDoc(List<Docente> arrayList, String nombreArchivo) {
        File archivoCSV = new File(nombreArchivo);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoCSV))) {
            for (Docente producto : arrayList) {
                // Escribir los atributos del producto en el archivo CSV
                writer.write(producto.getNombre());
                writer.write(",");
                writer.write(producto.getMateria());
                writer.write(",");
                writer.write(producto.getCobro());
                writer.write(",");
                writer.newLine();
            }
            System.out.println("ArrayList de productos guardada como archivo CSV exitosamente.");
            return archivoCSV;
        } catch (IOException e) {
            System.err.println("Error al guardar el archivo CSV: " + e.getMessage());
            return null;
        }
    }
}



