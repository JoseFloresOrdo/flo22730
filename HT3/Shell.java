import java.util.ArrayList;

public class Shell {
    
    public void shellSort(ArrayList<Integer> numeros) {
        int n = numeros.size();
        // Comienza con un espacio entre elementos más grande que la longitud del array
        for (int espacio = n / 2; espacio > 0; espacio /= 2) {
            // Realiza un paso de inserción para cada espacio
            for (int i = espacio; i < n; i++) {
                // Guarda el valor a ser insertado más adelante
                int temp = numeros.get(i);
                // Mueve los elementos del sub-array más grande que temp
                int j;
                for (j = i; j >= espacio && numeros.get(j - espacio) > temp; j -= espacio) {
                    numeros.set(j, numeros.get(j - espacio));
                }
                // Inserta el elemento guardado en el lugar correcto
                numeros.set(j, temp);
            }
        }
    }

    public void shellSortMin(ArrayList<Integer> numeros) {
        int n = numeros.size();
        // Comienza con un espacio entre elementos más grande que la longitud del array
        for (int espacio = n / 2; espacio > 0; espacio /= 2) {
            // Realiza un paso de inserción para cada espacio
            for (int i = espacio; i < n; i++) {
                // Guarda el valor a ser insertado más adelante
                int temp = numeros.get(i);
                // Mueve los elementos del sub-array más grande que temp
                int j;
                for (j = i; j >= espacio && numeros.get(j - espacio) < temp; j -= espacio) {
                    numeros.set(j, numeros.get(j - espacio));
                }
                // Inserta el elemento guardado en el lugar correcto
                numeros.set(j, temp);
            }
        }
    }

}
