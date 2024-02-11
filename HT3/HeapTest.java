import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class HeapTest {
    @Test
    public void testHeapSortMin() {
        Heap Heap = new Heap();
        ArrayList<Integer> numeros1 = new ArrayList<>(Arrays.asList(9, 2, 7, 5, 3, 8, 6, 1));
        ArrayList<Integer> esperado1 = new ArrayList<>(Arrays.asList(9, 8, 7, 6, 5, 3, 2, 1));
        Heap.heapSortMin(numeros1);
        Assert.assertEquals(esperado1, numeros1);
    }

    @Test
    public void testHeapSort() {

        Heap Heap = new Heap();
        ArrayList<Integer> numeros1 = new ArrayList<>(Arrays.asList(9, 2, 7, 5, 3, 8, 6, 1));
        ArrayList<Integer> esperado1 = new ArrayList<>(Arrays.asList(1, 2, 3, 5, 6, 7, 8, 9));
        Heap.heapSort(numeros1);
        Assert.assertEquals(esperado1, numeros1);

    }

}
