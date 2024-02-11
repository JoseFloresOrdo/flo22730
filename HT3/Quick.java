import java.util.ArrayList;

public class Quick {
    
    public void quickSort(ArrayList<Integer> numeros, int inicio, int fin) {
        if (inicio < fin) {
            int indiceParticion = particion(numeros, inicio, fin);
            quickSort(numeros, inicio, indiceParticion - 1);
            quickSort(numeros, indiceParticion + 1, fin);
        }
    }

    public int particion(ArrayList<Integer> numeros, int inicio, int fin) {
        int pivote = numeros.get(fin);
        int i = inicio - 1;
        for (int j = inicio; j < fin; j++) {
            if (numeros.get(j) >= pivote) {
                i++;
                // Intercambiar numeros[i] y numeros[j]
                int temp = numeros.get(i);
                numeros.set(i, numeros.get(j));
                numeros.set(j, temp);
            }
        }
        // Intercambiar numeros[i+1] y numeros[fin] (pivote)
        int temp = numeros.get(i + 1);
        numeros.set(i + 1, numeros.get(fin));
        numeros.set(fin, temp);
        return i + 1;
    }

    public void quickSortPick(ArrayList<Integer> numeros, int inicio, int fin) {
        if (inicio < fin) {
            int indiceParticion = particionPick(numeros, inicio, fin);
            quickSortPick(numeros, inicio, indiceParticion - 1);
            quickSortPick(numeros, indiceParticion + 1, fin);
        }
    }

    public int particionPick(ArrayList<Integer> numeros, int inicio, int fin) {
        int pivote = numeros.get(fin);
        int i = inicio - 1;
        for (int j = inicio; j < fin; j++) {
            if (numeros.get(j) <= pivote) {
                i++;
                // Intercambiar numeros[i] y numeros[j]
                int temp = numeros.get(i);
                numeros.set(i, numeros.get(j));
                numeros.set(j, temp);
            }
        }
        // Intercambiar numeros[i+1] y numeros[fin] (pivote)
        int temp = numeros.get(i + 1);
        numeros.set(i + 1, numeros.get(fin));
        numeros.set(fin, temp);
        return i + 1;
    }

}
