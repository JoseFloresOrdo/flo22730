import java.util.ArrayList;

public class Merge {
    
    public void mergeSort(ArrayList<Integer> numeros, int inicio, int fin) {
        if (inicio < fin) {
            int medio = (inicio + fin) / 2;
            mergeSort(numeros, inicio, medio);
            mergeSort(numeros, medio + 1, fin);
            merge(numeros, inicio, medio, fin);
        }
    }


    public void merge(ArrayList<Integer> numeros, int inicio, int medio, int fin) {
        int n1 = medio - inicio + 1;
        int n2 = fin - medio;

        ArrayList<Integer> izquierda = new ArrayList<>(numeros.subList(inicio, medio + 1));
        ArrayList<Integer> derecha = new ArrayList<>(numeros.subList(medio + 1, fin + 1));

        int i = 0, j = 0, k = inicio;

        while (i < n1 && j < n2) {
            if (izquierda.get(i) <= derecha.get(j)) {
                numeros.set(k, izquierda.get(i));
                i++;
            } else {
                numeros.set(k, derecha.get(j));
                j++;
            }
            k++;
        }

        while (i < n1) {
            numeros.set(k, izquierda.get(i));
            i++;
            k++;
        }

        while (j < n2) {
            numeros.set(k, derecha.get(j));
            j++;
            k++;
        }
    }

    public void mergeChik(ArrayList<Integer> numeros, int inicio, int medio, int fin) {
        int n1 = medio - inicio + 1;
        int n2 = fin - medio;

        ArrayList<Integer> izquierda = new ArrayList<>(numeros.subList(inicio, medio + 1));
        ArrayList<Integer> derecha = new ArrayList<>(numeros.subList(medio + 1, fin + 1));

        int i = 0, j = 0, k = inicio;

        while (i < n1 && j < n2) {
            // Modificando la condición de comparación para ordenar de mayor a menor
            if (izquierda.get(i) >= derecha.get(j)) {
                numeros.set(k, izquierda.get(i));
                i++;
            } else {
                numeros.set(k, derecha.get(j));
                j++;
            }
            k++;
        }

        while (i < n1) {
            numeros.set(k, izquierda.get(i));
            i++;
            k++;
        }

        while (j < n2) {
            numeros.set(k, derecha.get(j));
            j++;
            k++;
        }
    }

    public void mergeSortChik(ArrayList<Integer> numeros, int inicio, int fin) {
        if (inicio < fin) {
            int medio = (inicio + fin) / 2;
            mergeSortChik(numeros, inicio, medio);
            mergeSortChik(numeros, medio + 1, fin);
            mergeChik(numeros, inicio, medio, fin);
        }
    }


}
