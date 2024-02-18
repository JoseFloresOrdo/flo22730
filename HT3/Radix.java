import java.util.ArrayList;
import java.util.LinkedList;

public class Radix {
    
    public void radixSort(ArrayList<Integer> numeros) {
        if (numeros.isEmpty()) {
            return;
        }

        // Encuentra el número máximo para determinar la cantidad de dígitos
        int maximo = numeros.get(0);
        for (int numero : numeros) {
            if (numero > maximo) {
                maximo = numero;
            }
        }

        // Realiza el Radix Sort en cada posición de los dígitos
        for (int exp = 1; maximo / exp > 0; exp *= 10) {
            countingSort(numeros, exp);
        }
    }

    public void countingSort(ArrayList<Integer> numeros, int exp) {
        int n = numeros.size();
        LinkedList<Integer>[] cubetas = new LinkedList[10];

        for (int i = 0; i < 10; i++) {
            cubetas[i] = new LinkedList<>();
        }

        // Coloca los elementos en las cubetas basándose en el dígito en la posición 'exp'
        for (int numero : numeros) {
            int indice = (numero / exp) % 10;
            cubetas[indice].add(numero);
        }

        // Reensambla los elementos en el ArrayList
        int indice = 0;
        for (LinkedList<Integer> cubeta : cubetas) {
            for (int elemento : cubeta) {
                numeros.set(indice++, elemento);
            }
        }
    }

    public void radixSortMin(ArrayList<Integer> numeros) {
        if (numeros.isEmpty()) {
            return;
        }

        // Encuentra el número máximo para determinar la cantidad de dígitos
        int maximo = numeros.get(0);
        for (int numero : numeros) {
            if (numero > maximo) {
                maximo = numero;
            }
        }

        // Realiza el Radix Sort en cada posición de los dígitos
        for (int exp = 1; maximo / exp > 0; exp *= 10) {
            countingSortMin(numeros, exp);
        }
    }

    public void countingSortMin(ArrayList<Integer> numeros, int exp) {
        int n = numeros.size();
        LinkedList<Integer>[] cubetas = new LinkedList[10];

        for (int i = 0; i < 10; i++) {
            cubetas[i] = new LinkedList<>();
        }

        // Coloca los elementos en las cubetas basándose en el dígito en la posición 'exp'
        for (int numero : numeros) {
            int indice = (numero / exp) % 10;
            cubetas[indice].add(numero);
        }

        // Reensambla los elementos en el ArrayList en orden inverso para ordenar de mayor a menor
        int indice = 0;
        for (int i = 9; i >= 0; i--) {
            for (int elemento : cubetas[i]) {
                numeros.set(indice++, elemento);
            }
        }
    }

}
