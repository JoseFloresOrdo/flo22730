import java.io.File;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

public class XMLDataSource implements IExport {

    private final XmlMapper xmlMapper;

    public XMLDataSource() {
        this.xmlMapper = new XmlMapper();
    }

    public File SaveNote(Map<String, Integer> diccionario, String nombreArchivo) {
        File archivoXML = new File(nombreArchivo);
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(DiccionarioWrapper.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            DiccionarioWrapper wrapper = new DiccionarioWrapper();
            wrapper.setDiccionario(diccionario);

            marshaller.marshal(wrapper, archivoXML);
            System.out.println("Datos del diccionario guardados correctamente en el archivo " + nombreArchivo);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return archivoXML;
    }

    public File SavePagos(Map<String, String> diccionario, String nombreArchivo) {
        File archivoXML = new File(nombreArchivo);
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(DiccionarioWrapper.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            DiccionarioWrapper wrapper = new DiccionarioWrapper();
            wrapper.setDic(diccionario);

            marshaller.marshal(wrapper, archivoXML);
            System.out.println("Datos del diccionario guardados correctamente en el archivo " + nombreArchivo);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return archivoXML;
    }

    public File SaveStudDoc(Map<Estudiante, Docente> diccionario, String nombreArchivo) {
        File archivoXML = new File(nombreArchivo);
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(DiccionarioWrapper.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            DiccionarioWrapper wrapper = new DiccionarioWrapper();
            wrapper.setstud(diccionario);

            marshaller.marshal(wrapper, archivoXML);
            System.out.println("Datos del diccionario guardados correctamente en el archivo " + nombreArchivo);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return archivoXML;
    }

    public File SaveStud(List<Estudiante> lista, String nombreArchivo) {
        try {
            // Crear una instancia de JAXBContext para la clase de marcador (wrapper)
            JAXBContext context = JAXBContext.newInstance(DiccionarioWrapper.class);

            // Obtener el Marshaller de la instancia de JAXBContext
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Crear una instancia del wrapper y establecer la lista
            DiccionarioWrapper wrapper = new DiccionarioWrapper();
            wrapper.setAlum(lista);

            // Marshalling (escribir los datos en el archivo XML)
            File archivoXML = new File(nombreArchivo);
            marshaller.marshal(wrapper, archivoXML);
            System.out.println("Lista guardada como archivo XML exitosamente.");
            return archivoXML;
        } catch (JAXBException e) {
            System.err.println("Error al guardar la lista como archivo XML: " + e.getMessage());
            return null;
        }
    }

    public File SaveDoc(List<Docente> lista, String nombreArchivo) {
        try {
            // Crear una instancia de JAXBContext para la clase de marcador (wrapper)
            JAXBContext context = JAXBContext.newInstance(DiccionarioWrapper.class);

            // Obtener el Marshaller de la instancia de JAXBContext
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Crear una instancia del wrapper y establecer la lista
            DiccionarioWrapper wrapper = new DiccionarioWrapper();
            wrapper.setAlum(lista);

            // Marshalling (escribir los datos en el archivo XML)
            File archivoXML = new File(nombreArchivo);
            marshaller.marshal(wrapper, archivoXML);
            System.out.println("Lista guardada como archivo XML exitosamente.");
            return archivoXML;
        } catch (JAXBException e) {
            System.err.println("Error al guardar la lista como archivo XML: " + e.getMessage());
            return null;
        }
    }
}


