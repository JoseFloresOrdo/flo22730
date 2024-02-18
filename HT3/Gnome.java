import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Gnome {

    public void gnomeSort(ArrayList<Integer> numeros) {
        int index = 1;
        while (index < numeros.size()) {
            if (index == 0 || numeros.get(index) >= numeros.get(index - 1)) {
                index++;
            } else {
                // Intercambia los elementos y retrocede
                int temp = numeros.get(index);
                numeros.set(index, numeros.get(index - 1));
                numeros.set(index - 1, temp);
                index--;
            }
        }
    }

    public void gnomeSortDesc(ArrayList<Integer> numeros) {
        int index = 1;
        while (index < numeros.size()) {
            if (index == 0 || numeros.get(index) <= numeros.get(index - 1)) {
                index++;
            } else {
                // Intercambia los elementos y retrocede
                int temp = numeros.get(index);
                numeros.set(index, numeros.get(index - 1));
                numeros.set(index - 1, temp);
                index--;
            }
        }
    }
}
