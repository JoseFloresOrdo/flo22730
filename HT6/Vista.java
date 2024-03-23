/*
 * Allen Estuardo Ramírez De Paz, 22326
 * José Javier Flores Ordoñez, 22730
 * Catedrático: Moisés Alonso
 * Auxiliar: Joaquín Puente
 * HDT6
 * 
 */
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Vista {
    
    /** 
     * Función principal
     * @param args
     */
    public static void main(String[] args) {
        Factory factoryCodificacion = new Factory();
        Scanner scanner = new Scanner(System.in);
        FactoryMapas<String, Estudiante> factoryMapasInd = new FactoryMapas<>();
        FactoryMapas<String, List<Estudiante>> factoryMapasNac = new FactoryMapas<>();
        String RESET = "\033[0m";
        String AMARILLO = "\033[0;33m";
        LectoraJson<String, Estudiante> lectora = new LectoraJson<>();
        System.out.println(RESET+"Ingrese el tipo de map que desea usar (Como número):\n (1) HASHMAP \n (2) TREEMAP \n (3) LINKEDHASHMAP");
        int opcionMap = scanner.nextInt();
        scanner.nextLine();
        AbstractMap<String, Estudiante> mapInd = factoryMapasInd.getMapInstance(opcionMap);
        AbstractMap<String, List<Estudiante>> mapNac = factoryMapasNac.getMapInstance(opcionMap);
        System.out.println("Ingrese el tipo de codificación que desea usar (Como texto): \n MD5 \n Organica  \n SHA-1");
        String code = scanner.nextLine();
        Hash codificador = factoryCodificacion.CreateStack(code);
        int valor = 5;
        int opc = 5;
        while (valor != 0) {
            System.out.println(RESET+"¿Qué desea hacer? \n (1) Cargar datos \n (2) Ver todos los estudiantes \n (3) Buscar por email \n(4) Buscar por nacionalidad\n (5) Salir");
            opc = scanner.nextInt();
            if (opc == 1) {
                mapInd = lectora.crearMapIndividual(mapInd, codificador);
                mapNac = lectora.crearMap(mapNac);
                System.out.println("Datos cargados con éxito");
            }
            else if(opc==2){
                for (Estudiante estudiante : mapInd.values()) {
                    System.out.println(estudiante.getName());
                }
            }
            else if(opc==3){
                scanner.nextLine();
                System.out.println("Ingrese el usuario que desea buscar: ");
                String user= scanner.nextLine();
                String usercodificado= codificador.Codificar(user);
                System.out.println(AMARILLO+"El usuario buscado es: ");
                System.out.println(mapInd.get(usercodificado).toString()+RESET);
            }
            
            else if(opc==4){
                scanner.nextLine();
                System.out.println("Ingrese el país que quiere buscar");
                String buscar = scanner.nextLine();
                System.out.println(AMARILLO+"Los estudiantes de "+buscar+" son: ");
                if(mapNac.containsKey(buscar)){
                    List<Estudiante> listaEstudiantes= mapNac.get(buscar);
                    for(Estudiante estud: listaEstudiantes){
                        System.out.println(estud.toString());
                        System.out.println("-------------------------");
                    }
                    System.out.println(RESET);
                }
                else{
                    System.out.println(AMARILLO+"No hay estudiantes de esa nacionalidad."+RESET);
                }
            }
            else if(opc==5){
                valor=0;
            }
        }
        System.out.println("Cerrando sesión.");
    }
}

