import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        
        Association<String, String> Dato = new Association<String,String>(null, null);
        Factory factory = new Factory();
        Scanner teclado = new Scanner(System.in);
        Arbol Arbol1 = new Arbol();
        Arbol Arbol2 = new Arbol();
        Arbol Arbol3 = new Arbol();
        Arbol Arbol4 = new Arbol();
        Arbol Arbol5 = new Arbol();
        Arbol Arbol6 = new Arbol();

        try{
            BufferedReader Lectora = new BufferedReader(new FileReader("diccionario.txt"));
            String linea = Lectora.readLine();
            while(linea != null){
                Traduce Cambio = factory.getCambio(linea);
                Dato.setLlave(Cambio.getingles());
                Dato.setValor(Cambio.getfrances());
                Arbol1.empezar(Dato);
                Dato = new Association<String,String>(null, null);
                Dato.setLlave(Cambio.getingles());
                Dato.setValor(Cambio.getespanol());
                Arbol2.empezar(Dato);
                Dato = new Association<String,String>(null, null);
                Dato.setLlave(Cambio.getfrances());
                Dato.setValor(Cambio.getingles());
                Arbol3.empezar(Dato);
                Dato = new Association<String,String>(null, null);
                Dato.setLlave(Cambio.getfrances());
                Dato.setValor(Cambio.getespanol());
                Arbol4.empezar(Dato);
                Dato = new Association<String,String>(null, null);
                Dato.setLlave(Cambio.getespanol());
                Dato.setValor(Cambio.getingles());
                Arbol6.empezar(Dato);
                Dato = new Association<String,String>(null, null);
                Dato.setLlave(Cambio.getespanol());
                Dato.setValor(Cambio.getfrances());
                Arbol5.empezar(Dato);
                Dato = new Association<String,String>(null, null);

                linea = Lectora.readLine();
            }
        } catch (IOException e) {
            System.out.println("No se ha encontrado la direccion del archivo.");
        }

        String menu = "\n1. Traducir un archivo .txt\n2. Cerrar el programa";
        int opcion = 0;
        while(opcion < 1 || opcion > 2){
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();
            while(opcion >= 1 && opcion < 2){
                switch(opcion){
                    case 1:{
                        try{
                            System.out.println("\nNombre del archivo:");
                            String archivo = teclado.nextLine();
                            BufferedReader reader = new BufferedReader(new FileReader(archivo));
                            String linea = reader.readLine();
                            int esp = 0, ing = 0, fra = 0;
                            int idioma = 0;
                            while(linea != null){
                                String oracion = linea;
                                int i = oracion.lastIndexOf(".");
                                if(i+1 == oracion.length()){
                                    oracion = oracion.substring(0,i);
                                }
                                //Agregarle un espacio al final de la oracion para que funcione con el while
                                if(oracion.lastIndexOf(" ") != oracion.length()){
                                    oracion = oracion + " ";
                                }
                                while(oracion != ""){
                                    i = oracion.indexOf(" ");
                                    String p = oracion.substring(0, i);
                                    if(Arbol5.empezarb(p)!=""){
                                        esp++;
                                    }
                                    if(Arbol2.empezarb(p)!=""){
                                        ing++;
                                    }
                                    if(Arbol3.empezarb(p)!=""){
                                        fra++;
                                    }
                                    oracion = oracion.replaceFirst(oracion.substring(0, i+1), "");
                                }
                                if(esp == 0 && ing == 0 && fra == 0){
                                    System.out.println("No se han detectado Datos en ninguno de los 3 idiomas.");
                                    break;
                                }
                                if(esp >= ing && esp >= fra){
                                    System.out.println("Se traducira del Espanol");
                                    idioma = 0;
                                }
                                if(ing >= esp && ing >= fra){
                                    System.out.println("Se traducira del Ingles");
                                    idioma = 1;
                                }
                                if(fra >= ing && fra >= esp){
                                    System.out.println("Se traducira del Frances");
                                    idioma = 2;
                                }
                                switch(idioma){
                                    case 0:{
                                        System.out.println("Frase a traducir: " + linea);
                                        String menu5 = "A que idioma quiere traducir:\n1. Ingles\n2. Frances";
                                        int opcion5 = 0;
                                        while(opcion5 < 1 || opcion5 > 3){
                                            System.out.println(menu5);
                                            opcion5 = teclado.nextInt();
                                            teclado.nextLine();
                                        }
                                        switch(opcion5){
                                            case 1:{
                                                oracion = linea;
                                                String traduccion = "";
                                                i = oracion.lastIndexOf(".");
                                                //Quitar el punto al final de la oracion si lo tiene
                                                if(i+1 == oracion.length()){
                                                    oracion = oracion.substring(0,i);
                                                }
                                                //Agregarle un espacio al final de la oracion para que funcione con el while
                                                if(oracion.lastIndexOf(" ") != oracion.length()){
                                                    oracion = oracion + " ";
                                                }
                                                //El while va removiendo Dato por Dato de la oracion hasta que este quede vacio "" y termine.
                                                while(oracion != ""){
                                                    i = oracion.indexOf(" ");
                                                    String p = oracion.substring(0, i);
                                                    //Si la Dato no esta en el arbol devuelve "" y agrega la Dato entre ** a la traduccion.
                                                    if(Arbol6.empezarb(p) == ""){
                                                        traduccion = traduccion + "*" + p + "* ";
                                                    }
                                                    //Si la Dato si esta agrega el valor de la llave a la traduccion
                                                    else {
                                                        traduccion = traduccion + Arbol6.empezarb(p) + " ";
                                                    }
                                                    oracion = oracion.replaceFirst(oracion.substring(0, i+1), "");
                                                }
                                                //Mayuscula y punto
                                                traduccion = traduccion.substring(0,1).toUpperCase() + traduccion.substring(1);
                                                traduccion = traduccion.trim() + ".";
                                                System.out.println("Traduccion: " + traduccion);
                                                opcion = 0;
                                                break;
                                            }
                                            case 2:{
                                                oracion = linea;
                                                String traduccion = "";
                                                i = oracion.lastIndexOf(".");
                                                //Quitar el punto al final de la oracion si lo tiene
                                                if(i+1 == oracion.length()){
                                                    oracion = oracion.substring(0,i);
                                                }
                                                //Agregarle un espacio al final de la oracion para que funcione con el while
                                                if(oracion.lastIndexOf(" ") != oracion.length()){
                                                    oracion = oracion + " ";
                                                }
                                                //El while va removiendo Dato por Dato de la oracion hasta que este quede vacio "" y termine.
                                                while(oracion != ""){
                                                    i = oracion.indexOf(" ");
                                                    String p = oracion.substring(0, i);
                                                    //Si la Dato no esta en el arbol devuelve "" y agrega la Dato entre ** a la traduccion.
                                                    if(Arbol5.empezarb(p) == ""){
                                                        traduccion = traduccion + "*" + p + "* ";
                                                    }
                                                    //Si la Dato si esta agrega el valor de la llave a la traduccion
                                                    else {
                                                        traduccion = traduccion + Arbol5.empezarb(p) + " ";
                                                    }
                                                    oracion = oracion.replaceFirst(oracion.substring(0, i+1), "");
                                                }
                                                //Mayuscula y punto
                                                traduccion = traduccion.substring(0,1).toUpperCase() + traduccion.substring(1);
                                                traduccion = traduccion.trim() + ".";
                                                System.out.println("Traduccion: " + traduccion);
                                                opcion = 0;
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                    case 1:{
                                        System.out.println("Frase a traducir: " + linea);
                                        String menu5 = "A que idioma quiere traducir:\n1. Espanol\n2. Frances";
                                        int opcion5 = 0;
                                        while(opcion5 < 1 || opcion5 > 3){
                                            System.out.println(menu5);
                                            opcion5 = teclado.nextInt();
                                            teclado.nextLine();
                                        }
                                        switch(opcion5){
                                            case 1:{
                                                oracion = linea;
                                                String traduccion = "";
                                                i = oracion.lastIndexOf(".");
                                                //Quitar el punto al final de la oracion si lo tiene
                                                if(i+1 == oracion.length()){
                                                    oracion = oracion.substring(0,i);
                                                }
                                                //Agregarle un espacio al final de la oracion para que funcione con el while
                                                if(oracion.lastIndexOf(" ") != oracion.length()){
                                                    oracion = oracion + " ";
                                                }
                                                //El while va removiendo Dato por Dato de la oracion hasta que este quede vacio "" y termine.
                                                while(oracion != ""){
                                                    i = oracion.indexOf(" ");
                                                    String p = oracion.substring(0, i);
                                                    //Si la Dato no esta en el arbol devuelve "" y agrega la Dato entre ** a la traduccion.
                                                    if(Arbol2.empezarb(p) == ""){
                                                        traduccion = traduccion + "*" + p + "* ";
                                                    }
                                                    //Si la Dato si esta agrega el valor de la llave a la traduccion
                                                    else {
                                                        traduccion = traduccion + Arbol2.empezarb(p) + " ";
                                                    }
                                                    oracion = oracion.replaceFirst(oracion.substring(0, i+1), "");
                                                }
                                                //Mayuscula y punto
                                                traduccion = traduccion.substring(0,1).toUpperCase() + traduccion.substring(1);
                                                traduccion = traduccion.trim() + ".";
                                                System.out.println("Traduccion: " + traduccion);
                                                opcion = 0;
                                                break;
                                            }
                                            case 2:{
                                                oracion = linea;
                                                String traduccion = "";
                                                i = oracion.lastIndexOf(".");
                                                //Quitar el punto al final de la oracion si lo tiene
                                                if(i+1 == oracion.length()){
                                                    oracion = oracion.substring(0,i);
                                                }
                                                //Agregarle un espacio al final de la oracion para que funcione con el while
                                                if(oracion.lastIndexOf(" ") != oracion.length()){
                                                    oracion = oracion + " ";
                                                }
                                                //El while va removiendo Dato por Dato de la oracion hasta que este quede vacio "" y termine.
                                                while(oracion != ""){
                                                    i = oracion.indexOf(" ");
                                                    String p = oracion.substring(0, i);
                                                    //Si la Dato no esta en el arbol devuelve "" y agrega la Dato entre ** a la traduccion.
                                                    if(Arbol1.empezarb(p) == ""){
                                                        traduccion = traduccion + "*" + p + "* ";
                                                    }
                                                    //Si la Dato si esta agrega el valor de la llave a la traduccion
                                                    else {
                                                        traduccion = traduccion + Arbol1.empezarb(p) + " ";
                                                    }
                                                    oracion = oracion.replaceFirst(oracion.substring(0, i+1), "");
                                                }
                                                //Mayuscula y punto
                                                traduccion = traduccion.substring(0,1).toUpperCase() + traduccion.substring(1);
                                                traduccion = traduccion.trim() + ".";
                                                System.out.println("Traduccion: " + traduccion);
                                                opcion = 0;
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                    case 2:{
                                        System.out.println("\nFrase a traducir: " + linea);
                                        String menu5 = "A que idioma quiere traducir:\n1. Ingles\n2. Espanol";
                                        int opcion5 = 0;
                                        while(opcion5 < 1 || opcion5 > 3){
                                            System.out.println(menu5);
                                            opcion5 = teclado.nextInt();
                                            teclado.nextLine();
                                        }
                                        switch(opcion5){
                                            case 1:{
                                                oracion = linea;
                                                String traduccion = "";
                                                i = oracion.lastIndexOf(".");
                                                //Quitar el punto al final de la oracion si lo tiene
                                                if(i+1 == oracion.length()){
                                                    oracion = oracion.substring(0,i);
                                                }
                                                //Agregarle un espacio al final de la oracion para que funcione con el while
                                                if(oracion.lastIndexOf(" ") != oracion.length()){
                                                    oracion = oracion + " ";
                                                }
                                                //El while va removiendo Dato por Dato de la oracion hasta que este quede vacio "" y termine.
                                                while(oracion != ""){
                                                    i = oracion.indexOf(" ");
                                                    String p = oracion.substring(0, i);
                                                    //Si la Dato no esta en el arbol devuelve "" y agrega la Dato entre ** a la traduccion.
                                                    if(Arbol3.empezarb(p) == ""){
                                                        traduccion = traduccion + "*" + p + "* ";
                                                    }
                                                    //Si la Dato si esta agrega el valor de la llave a la traduccion
                                                    else {
                                                        traduccion = traduccion + Arbol3.empezarb(p) + " ";
                                                    }
                                                    oracion = oracion.replaceFirst(oracion.substring(0, i+1), "");
                                                }
                                                //Mayuscula y punto
                                                traduccion = traduccion.substring(0,1).toUpperCase() + traduccion.substring(1);
                                                traduccion = traduccion.trim() + ".";
                                                System.out.println("Traduccion: " + traduccion);
                                                opcion = 0;
                                                break;
                                            }
                                            case 2:{
                                                oracion = linea;
                                                String traduccion = "";
                                                i = oracion.lastIndexOf(".");
                                                //Quitar el punto al final de la oracion si lo tiene
                                                if(i+1 == oracion.length()){
                                                    oracion = oracion.substring(0,i);
                                                }
                                                //Agregarle un espacio al final de la oracion para que funcione con el while
                                                if(oracion.lastIndexOf(" ") != oracion.length()){
                                                    oracion = oracion + " ";
                                                }
                                                //El while va removiendo Dato por Dato de la oracion hasta que este quede vacio "" y termine.
                                                while(oracion != ""){
                                                    i = oracion.indexOf(" ");
                                                    String p = oracion.substring(0, i);
                                                    //Si la Dato no esta en el arbol devuelve "" y agrega la Dato entre ** a la traduccion.
                                                    if(Arbol4.empezarb(p) == ""){
                                                        traduccion = traduccion + "*" + p + "* ";
                                                    }
                                                    //Si la Dato si esta agrega el valor de la llave a la traduccion
                                                    else {
                                                        traduccion = traduccion + Arbol4.empezarb(p) + " ";
                                                    }
                                                    oracion = oracion.replaceFirst(oracion.substring(0, i+1), "");
                                                }
                                                //Mayuscula y punto
                                                traduccion = traduccion.substring(0,1).toUpperCase() + traduccion.substring(1);
                                                traduccion = traduccion.trim() + ".";
                                                System.out.println("Traduccion: " + traduccion);
                                                opcion = 0;
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                }
                                linea = reader.readLine();
                            }
                        } catch (IOException e) {
                            System.out.println("No se ha encontrado la direccion del archivo.");
                        }
                        break;
                    }
                }
            } 
        }   
    }
}

