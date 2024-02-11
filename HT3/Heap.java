import java.util.ArrayList;
public class Heap {
    
    public void heapSort(ArrayList<Integer> numeros) {
        int n = numeros.size();

        // Construir un heap máximo
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(numeros, n, i);
        }

        // Extraer elementos del heap uno por uno
        for (int i = n - 1; i > 0; i--) {
            // Mover la raíz actual al final del array
            int temp = numeros.get(0);
            numeros.set(0, numeros.get(i));
            numeros.set(i, temp);

            // Llamar heapify en el heap reducido
            heapify(numeros, i, 0);
        }
    }

    public void heapify(ArrayList<Integer> numeros, int n, int indice) {
        int mayor = indice; // Inicializar el mayor como raíz
        int izquierda = 2 * indice + 1;
        int derecha = 2 * indice + 2;

        // Si el hijo izquierdo es mayor que la raíz
        if (izquierda < n && numeros.get(izquierda) > numeros.get(mayor)) {
            mayor = izquierda;
        }

        // Si el hijo derecho es mayor que el mayor hasta ahora
        if (derecha < n && numeros.get(derecha) > numeros.get(mayor)) {
            mayor = derecha;
        }

        // Si el mayor no es la raíz
        if (mayor != indice) {
            int temp = numeros.get(indice);
            numeros.set(indice, numeros.get(mayor));
            numeros.set(mayor, temp);

            // Recursivamente hacer heapify en el sub-árbol afectado
            heapify(numeros, n, mayor);
        }
    }

    public void heapSortMin(ArrayList<Integer> numeros) {
        int n = numeros.size();

        // Construir un heap máximo
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapifyMin(numeros, n, i);
        }

        // Extraer elementos del heap uno por uno
        for (int i = n - 1; i > 0; i--) {
            // Mover la raíz actual al final del array
            int temp = numeros.get(0);
            numeros.set(0, numeros.get(i));
            numeros.set(i, temp);

            // Llamar heapify en el heap reducido
            heapifyMin(numeros, i, 0);
        }
    }

    public void heapifyMin(ArrayList<Integer> numeros, int n, int indice) {
        int mayor = indice; // Inicializar el mayor como raíz
        int izquierda = 2 * indice + 1;
        int derecha = 2 * indice + 2;

        // Si el hijo izquierdo es mayor que la raíz
        if (izquierda < n && numeros.get(izquierda) < numeros.get(mayor)) {
            mayor = izquierda;
        }

        // Si el hijo derecho es mayor que el mayor hasta ahora
        if (derecha < n && numeros.get(derecha) < numeros.get(mayor)) {
            mayor = derecha;
        }

        // Si el mayor no es la raíz
        if (mayor != indice) {
            int temp = numeros.get(indice);
            numeros.set(indice, numeros.get(mayor));
            numeros.set(mayor, temp);

            // Recursivamente hacer heapify en el sub-árbol afectado
            heapifyMin(numeros, n, mayor);
        }
    }

}
