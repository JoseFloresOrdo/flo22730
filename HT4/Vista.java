/*
 * Autores: Allen Estuardo Ramírez De Paz, 22326.
 * José Javier Flores Ordoñez, 22730
 * Catedrático: Moisés Alonso
 * Auxiliar: Joaquín Puente
 * 
 * 
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Vista {
    
    /** 
     * Método main
     * @param args
     */
    public static void main(String[] args) {
        boolean opc= true;
        Scanner scanner= new Scanner(System.in);
        Factory factory= new Factory<>();
        System.out.println("Bienvenido ingrese la pila que desee usar: ");
        String eleccion= scanner.nextLine();
        String nombreArchivo = "Num.txt";
        Lectora lectora = new Lectora();
        ArrayList<String> lineas = lectora.readFile(nombreArchivo);
        Conversor conversor= new Conversor();
        CalculadoraPostFix calculadora= new CalculadoraPostFix(factory.createStack(eleccion));
        System.out.println("Ingrese el índice del archivo TXT que desea calcular (por ejemplo, 1, 2, etc.):");
        int indice = scanner.nextInt();
        int indiceAnterior = indice - 1;
        ArrayList<String> infix= conversor.validateExpression(lineas.get(indiceAnterior));
        String postfix= conversor.conversor(infix);
        try {
            ArrayList<String> expresionPostfix = conversor.validateExpression(postfix); 
            int resultado = calculadora.resolve(expresionPostfix);
            System.out.println("El resultado de la expresión es: " + resultado);
        } catch (Exception e) {
            System.out.println("Error al calcular la expresión: " + e.getMessage());
        }
        
        scanner.close();
       
        
       

       


    }}

