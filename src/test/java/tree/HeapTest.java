package tree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HeapTest {

    private Heap heap;

    @Before
    public void setup() {
        heap = new Heap(20);
    }

    @Test
    public void insert() {
        int[] data = {2, 1, 8, 7, 6, 5, 9, 15, 13, 16, 21, 17, 33};
        int n = data.length;
        for (int i = 0; i < n; i++) {
            heap.insert(data[i]);
        }
        for (int i = 0; i < n; i++) {
            System.out.println(heap.getHeap()[i]);
        }
    }

    @Test
    public void delete() {
        int[] data = {2, 1, 8, 7, 6, 5, 9, 15, 13, 16, 21, 17, 33};
        int n = data.length;
        for (int i = 0; i < n; i++) {
            heap.insert(data[i]);
        }
        Assert.assertEquals(33, heap.removeMax());
        Assert.assertEquals(21, heap.removeMax());
    }

    @Test
    public void heapSort() {
        int[] data = {0, 24, 21, 16, 33, 17};
        heap.sort(data, 5);
        for (int i = 1; i < data.length; i++) {
            System.out.println(data[i]);
        }
    }
}
