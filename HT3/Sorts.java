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

        // Definir la cantidad inicial de datos aleatorios
        int initialSize = 10;
        int increment = 0; // Incremento en cada iteración
        int iterations = 3000; // Número de iteraciones
        
        

        System.out.println("1) Hacer un gnome sort");
                System.out.println("2) Hacer un merge sort");
                System.out.println("3) Hacer un quick sort");
                System.out.println("4) Hacer un radix sort");
                System.out.println("5) Hacer un selection sort");
                System.out.println("6) Hacer un shell sort");
                System.out.println("7) Hacer un heap sort");
                int opc = teclado.nextInt();
                teclado.nextLine();
                switch (opc) {
                    case 1:

                    System.out.println("1) Ascendente");
                    System.out.println("2) Descendente");
                    int list = teclado.nextInt();
                    teclado.nextLine();
                    if (list == 1){

                        for (int i = 0; i < iterations; i++) {
                            // Generar y agregar datos aleatorios
                            for (int j = 0; j < initialSize + i * increment; j++) {
                                numeros.add(random.nextInt(10000)); // Números aleatorios del 0 al 9999
                            }
                
                            nomo.gnomeSort(numeros);
                    
                            // Mostrar la cantidad de datos generados
                            System.out.println("Cantidad de datos generados en la iteración " + (i+1) + ": " + numeros.size());
                        }

                        Guarda.guardarNumerosOrdenados(numeros, "numeros_enteros.txt");

                    }else{

                        for (int i = 0; i < iterations; i++) {
                            // Generar y agregar datos aleatorios
                            for (int j = 0; j < initialSize + i * increment; j++) {
                                numeros.add(random.nextInt(10000)); // Números aleatorios del 0 al 9999
                            }
                
                            nomo.gnomeSortDesc(numeros);
                    
                            // Mostrar la cantidad de datos generados
                            System.out.println("Cantidad de datos generados en la iteración " + (i+1) + ": " + numeros.size());
                    }

                    Guarda.guardarNumerosOrdenados(numeros, "numeros_enteros.txt");
                }

                        
                    break;
                    case 2:

                    System.out.println("1) Ascendente");
                    System.out.println("2) Descendente");
                    int ord = teclado.nextInt();
                    teclado.nextLine();
                    if (ord == 1){

                        for (int i = 0; i < iterations; i++) {
                            // Generar y agregar datos aleatorios
                            for (int j = 0; j < initialSize + i * increment; j++) {
                                numeros.add(random.nextInt(10000)); // Números aleatorios del 0 al 9999
                            }
                
                            Merge.mergeSort(numeros, 0, numeros.size() - 1);
                    
                            // Mostrar la cantidad de datos generados
                            System.out.println("Cantidad de datos generados en la iteración " + (i+1) + ": " + numeros.size());
                        }

                        Guarda.guardarNumerosOrdenados(numeros, "numeros_enteros.txt");

                    }else{

                        for (int i = 0; i < iterations; i++) {
                            // Generar y agregar datos aleatorios
                            for (int j = 0; j < initialSize + i * increment; j++) {
                                numeros.add(random.nextInt(10000)); // Números aleatorios del 0 al 9999
                            }
                
                            Merge.mergeSortChik(numeros, 0, numeros.size() - 1);
                    
                            // Mostrar la cantidad de datos generados
                            System.out.println("Cantidad de datos generados en la iteración " + (i+1) + ": " + numeros.size());
                        }

                        Guarda.guardarNumerosOrdenados(numeros, "numeros_enteros.txt");

                    }

                    break;
                    case 3:
                        
                    System.out.println("1) Ascendente");
                    System.out.println("2) Descendente");
                    int Dip = teclado.nextInt();
                    teclado.nextLine();
                    if (Dip == 1){

                        for (int i = 0; i < iterations; i++) {
                            // Generar y agregar datos aleatorios
                            for (int j = 0; j < initialSize + i * increment; j++) {
                                numeros.add(random.nextInt(10000)); // Números aleatorios del 0 al 9999
                            }
                
                            Quick.quickSortPick(numeros, 0, numeros.size() - 1);
                    
                            // Mostrar la cantidad de datos generados
                            System.out.println("Cantidad de datos generados en la iteración " + (i+1) + ": " + numeros.size());
                        }

                        Guarda.guardarNumerosOrdenados(numeros, "numeros_enteros.txt");

                    }else{

                        for (int i = 0; i < iterations; i++) {
                            // Generar y agregar datos aleatorios
                            for (int j = 0; j < initialSize + i * increment; j++) {
                                numeros.add(random.nextInt(10000)); // Números aleatorios del 0 al 9999
                            }
                
                            Quick.quickSort(numeros, 0, numeros.size() - 1);
                    
                            // Mostrar la cantidad de datos generados
                            System.out.println("Cantidad de datos generados en la iteración " + (i+1) + ": " + numeros.size());
                        }

                        Guarda.guardarNumerosOrdenados(numeros, "numeros_enteros.txt");

                    }

                    break;
                    case 4:

                    System.out.println("1) Ascendente");
                    System.out.println("2) Descendente");
                    int Tok = teclado.nextInt();
                    teclado.nextLine();
                    if (Tok == 1){

                        for (int i = 0; i < iterations; i++) {
                            // Generar y agregar datos aleatorios
                            for (int j = 0; j < initialSize + i * increment; j++) {
                                numeros.add(random.nextInt(10000)); // Números aleatorios del 0 al 9999
                            }
                
                            Radix.radixSort(numeros);
                    
                            // Mostrar la cantidad de datos generados
                            System.out.println("Cantidad de datos generados en la iteración " + (i+1) + ": " + numeros.size());
                        }

                        Guarda.guardarNumerosOrdenados(numeros, "numeros_enteros.txt");

                    }else{

                        for (int i = 0; i < iterations; i++) {
                            // Generar y agregar datos aleatorios
                            for (int j = 0; j < initialSize + i * increment; j++) {
                                numeros.add(random.nextInt(10000)); // Números aleatorios del 0 al 9999
                            }
                
                            Radix.radixSortMin(numeros);
                    
                            // Mostrar la cantidad de datos generados
                            System.out.println("Cantidad de datos generados en la iteración " + (i+1) + ": " + numeros.size());
                        }

                        Guarda.guardarNumerosOrdenados(numeros, "numeros_enteros.txt");

                    }

                        break;
                    case 5:

                    System.out.println("1) Ascendente");
                    System.out.println("2) Descendente");
                    int Ko = teclado.nextInt();
                    teclado.nextLine();
                    if (Ko == 1){

                        for (int i = 0; i < iterations; i++) {
                            // Generar y agregar datos aleatorios
                            for (int j = 0; j < initialSize + i * increment; j++) {
                                numeros.add(random.nextInt(10000)); // Números aleatorios del 0 al 9999
                            }
                
                            Selection.selectionSortMin(numeros);
                    
                            // Mostrar la cantidad de datos generados
                            System.out.println("Cantidad de datos generados en la iteración " + (i+1) + ": " + numeros.size());
                        }

                        Guarda.guardarNumerosOrdenados(numeros, "numeros_enteros.txt");

                    }else{

                        for (int i = 0; i < iterations; i++) {
                            // Generar y agregar datos aleatorios
                            for (int j = 0; j < initialSize + i * increment; j++) {
                                numeros.add(random.nextInt(10000)); // Números aleatorios del 0 al 9999
                            }
                
                            Selection.selectionSort(numeros);
                    
                            // Mostrar la cantidad de datos generados
                            System.out.println("Cantidad de datos generados en la iteración " + (i+1) + ": " + numeros.size());
                        }

                        Guarda.guardarNumerosOrdenados(numeros, "numeros_enteros.txt");

                    }

                    break;
                    case 6:

                    System.out.println("1) Ascendente");
                    System.out.println("2) Descendente");
                    int Tu = teclado.nextInt();
                    teclado.nextLine();
                    if (Tu == 1){

                        for (int i = 0; i < iterations; i++) {
                            // Generar y agregar datos aleatorios
                            for (int j = 0; j < initialSize + i * increment; j++) {
                                numeros.add(random.nextInt(10000)); // Números aleatorios del 0 al 9999
                            }
                
                            Shell.shellSort(numeros);
                    
                            // Mostrar la cantidad de datos generados
                            System.out.println("Cantidad de datos generados en la iteración " + (i+1) + ": " + numeros.size());
                        }

                        Guarda.guardarNumerosOrdenados(numeros, "numeros_enteros.txt");

                    }else{

                        for (int i = 0; i < iterations; i++) {
                            // Generar y agregar datos aleatorios
                            for (int j = 0; j < initialSize + i * increment; j++) {
                                numeros.add(random.nextInt(10000)); // Números aleatorios del 0 al 9999
                            }
                
                            Shell.shellSortMin(numeros);
                    
                            // Mostrar la cantidad de datos generados
                            System.out.println("Cantidad de datos generados en la iteración " + (i+1) + ": " + numeros.size());
                        }

                        Guarda.guardarNumerosOrdenados(numeros, "numeros_enteros.txt");

                    }

                    break;
                    case 7:

                    System.out.println("1) Ascendente");
                    System.out.println("2) Descendente");
                    int Po = teclado.nextInt();
                    teclado.nextLine();
                    if (Po == 1){

                        for (int i = 0; i < iterations; i++) {
                            // Generar y agregar datos aleatorios
                            for (int j = 0; j < initialSize + i * increment; j++) {
                                numeros.add(random.nextInt(10000)); // Números aleatorios del 0 al 9999
                            }
                
                            Heap.heapSort(numeros);
                    
                            // Mostrar la cantidad de datos generados
                            System.out.println("Cantidad de datos generados en la iteración " + (i+1) + ": " + numeros.size());
                        }

                        Guarda.guardarNumerosOrdenados(numeros, "numeros_enteros.txt");

                    }else{

                        for (int i = 0; i < iterations; i++) {
                            // Generar y agregar datos aleatorios
                            for (int j = 0; j < initialSize + i * increment; j++) {
                                numeros.add(random.nextInt(10000)); // Números aleatorios del 0 al 9999
                            }
                
                            Heap.heapSortMin(numeros);
                    
                            // Mostrar la cantidad de datos generados
                            System.out.println("Cantidad de datos generados en la iteración " + (i+1) + ": " + numeros.size());
                        }

                        Guarda.guardarNumerosOrdenados(numeros, "numeros_enteros.txt");

                    }

                    break;
                    case 8:
                        break;
                }




    }
}
