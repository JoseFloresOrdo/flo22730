import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;





public class Main {
    public static void main(String[] args) {
        String fileName = "Num.txt"; // Nombre del archivo a leer

        Stack<String> pila = new Stack<>(); // Pila para almacenar los elementos del archivo
        Stack<String> Clon = new Stack<>();
        Stack<Integer> P = new Stack<>();
        Stack<Character> po = new Stack<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String linea;
            // Leer cada línea del archivo y agregarla a la pila
            while ((linea = br.readLine()) != null) {
                pila.push(linea);
                Clon.push(linea);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        
//           while (!pila.isEmpty()){
//            String palabra = pila.pop();
//            for (int i = palabra.length() - 1; i >= 0; i--) {
//                 po.push(palabra.charAt(i));
//             }
//         }

        int size = pila.size();
        for (int i = 0; i < size; i++){
            String palabra = pila.pop();
            for (int q = palabra.length() - 1; q >= 0; q--) {
                po.push(palabra.charAt(q));
            }

            int Tama = po.size();
            for (int h = 0; h < Tama; h++){
                int Su1 = po.pop();
                String Su2 = Integer.pa
                int Su3 = po.pop();
                if (Su2 == "+"){

                }

            }


        }

        System.out.println("Letras de la palabra:");
        while (!po.isEmpty()) {
            System.out.println(po.pop());
        }

        //pila.push("2");
        //pila.push("+");

        // if(pila.pop() == "+"){
        //    int o = Integer.parseInt(pila.pop());
        //    int r = Integer.parseInt(pila.pop());
        //    int t = o+r;
        //    System.out.println(t);
        //} 

        

        

    }

    
}


