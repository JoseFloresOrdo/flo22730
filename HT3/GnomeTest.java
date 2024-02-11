import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class GnomeTest {
    @Test
    public void testGnomeSort() {

        Gnome Gnome = new Gnome();
        ArrayList<Integer> numeros1 = new ArrayList<>(Arrays.asList(9, 2, 7, 5, 3, 8, 6, 1));
        ArrayList<Integer> esperado1 = new ArrayList<>(Arrays.asList(1, 2, 3, 5, 6, 7, 8, 9));
        Gnome.gnomeSort(numeros1);
        Assert.assertEquals(esperado1, numeros1);

    }

    @Test
    public void testGnomeSortDesc() {

        Gnome Gnome = new Gnome();
        ArrayList<Integer> numeros1 = new ArrayList<>(Arrays.asList(9, 2, 7, 5, 3, 8, 6, 1));
        ArrayList<Integer> esperado1 = new ArrayList<>(Arrays.asList(9, 8, 7, 6, 5, 3, 2, 1));
        Gnome.gnomeSortDesc(numeros1);
        Assert.assertEquals(esperado1, numeros1);

    }
}
