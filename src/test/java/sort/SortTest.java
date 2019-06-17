package sort;

import org.junit.Assert;
import org.junit.Test;

public class SortTest {

    @Test
    public void bubbleSort() {
        int[] data = {2, 5, 1, 8, 5, 9, 11, 4, 20, 17, 7, 0};
        Sort.bubbleSort(data);
        Assert.assertEquals(0, data[0]);
        Assert.assertEquals(20, data[data.length-1]);
    }

    @Test
    public void insertSort() {
        int[] data = {2, 5, 1, 8, 5, 9, 11, 4, 20, 17, 7, 0};
        Sort.insertSort(data);
        Assert.assertEquals(0, data[0]);
        Assert.assertEquals(20, data[data.length-1]);
    }

    @Test
    public void shellSort() {
        int[] data = {2, 5, 1, 8, 5, 9, 11, 4, 20, 17, 7, 0};
        Sort.shellSort(data);
        Assert.assertEquals(0, data[0]);
        Assert.assertEquals(20, data[data.length-1]);
    }

    @Test
    public void selectSort() {
        int[] data = {2, 5, 1, 8, 5, 9, 11, 4, 20, 17, 7, 0};
        Sort.selectSort(data);
        Assert.assertEquals(0, data[0]);
        Assert.assertEquals(20, data[data.length-1]);
    }

    @Test
    public void mergeSort() {
        int[] data = {2, 5, 1, 8, 5, 9, 11, 4, 20, 17, 7, 0};
        Sort.mergeSort(data);
        Assert.assertEquals(0, data[0]);
        Assert.assertEquals(4, data[3]);
    }

    @Test
    public void quickSort() {
        int[] data = {2, 5, 1, 8, 5, 9, 11, 4, 20, 17, 7, 0};
        Sort.quickSort(data);
        Assert.assertEquals(0, data[0]);
        Assert.assertEquals(20, data[data.length-1]);
    }

    @Test
    public void countingSort() {
        int[] data = {2, 5, 1, 8, 5, 9, 11, 4, 20, 17, 7, 0};
        Sort.countingSort(data);
        Assert.assertEquals(0, data[0]);
        Assert.assertEquals(20, data[data.length-1]);
    }

    @Test
    public void findKthLargest() {
        int[] data = {2, 5, 1, 8, 5, 9, 11, 4, 20, 17, 7, 0};
        int k = SortApplication.findKthLargest(data, 3);
        Assert.assertEquals(11, k);
    }

    @Test
    public void moreThanHalfNum() {
        int[] data = {1, 1, 2, 2, 2, 2, 2};
        int n = SortApplication.MoreThanHalfNum_Solution(data);
        Assert.assertEquals(2, n);
    }
}
