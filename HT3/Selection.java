import java.util.ArrayList;

public class Selection {
    
    public void selectionSort(ArrayList<Integer> numeros) {
        int n = numeros.size();
        for (int i = 0; i < n - 1; i++) {
            int indiceMaximo = i;
            for (int j = i + 1; j < n; j++) {
                if (numeros.get(j) > numeros.get(indiceMaximo)) {
                    indiceMaximo = j;
                }
            }
            // Intercambiar el elemento actual con el máximo encontrado
            int temp = numeros.get(indiceMaximo);
            numeros.set(indiceMaximo, numeros.get(i));
            numeros.set(i, temp);
        }
    }

    public void selectionSortMin(ArrayList<Integer> numeros) {
        int n = numeros.size();
        for (int i = 0; i < n - 1; i++) {
            int indiceMinimo = i;
            for (int j = i + 1; j < n; j++) {
                if (numeros.get(j) < numeros.get(indiceMinimo)) {
                    indiceMinimo = j;
                }
            }
            // Intercambiar el elemento actual con el mínimo encontrado
            int temp = numeros.get(indiceMinimo);
            numeros.set(indiceMinimo, numeros.get(i));
            numeros.set(i, temp);
        }
    }

}
