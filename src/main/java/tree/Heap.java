package tree;

public class Heap {

    //数组，从下标 1 开始存储数据
    private int[] heap;
    //堆可以存储的最大数据个数
    private int n;
    //堆中已经存储的数据个数
    private int count;

    public int[] getHeap() {
        return heap;
    }

    public Heap(int capacity) {
        heap = new int[capacity + 1];
        n = capacity;
        count = 0;
    }

    /**
     * 向堆中插入一个元素, 插入到数组末尾, 从下往上进行堆化
     * @param data
     */
    public void insert(int data) {
        if (count >= n) {
            //堆满了
            return;
        }
        ++count;
        heap[count] = data;
        int i = count;
        //自下而上堆化
        while (i / 2 > 0 && heap[i] > heap[i/2]) {
            swap(heap, i, i/2);
            i = i/2;
        }
    }

    /**
     * 删除堆顶元素, 返回被删除的值, 堆中没有值时则返回-1
     */
    public int removeMax() {
        if (count == 0) {
            return -1;
        }
        //tmp保存待删除的值
        int tmp = heap[1];
        heap[1] = heap[count];
        count--;
        heapify(heap, count, 1);
        return tmp;
    }

    /**
     * 堆排序
     * @param a
     * @param n n表示数据的个数
     */
    public void sort(int[] a, int n) {
        buildHeap(a, n);
        while (n > 1) {
            swap(a, 1, n);
            n--;
            heapify(a, n, 1);
        }
    }

    /**
     * 建堆
     * @param a
     * @param n 堆化数组最后一个值的下标
     */
    private void buildHeap(int[] a, int n) {
        for (int i = n/2; i >= 1; i--) {
            heapify(a, n, i);
        }
    }

    /**
     * 自上而下堆化
     * @param heap
     * @param n 堆中最后一个元素的下标
     * @param i 数组下标
     */
    private void heapify(int[] heap, int n, int i) {
        while (true) {
            int max = i;
            if (2 * i <= n && heap[2*i] > heap[max]) {
                max = 2 * i;
            }
            if (2 * i + 1 <= n && heap[2*i+1] > heap[max]) {
                max = 2 * i + 1;
            }
            if (max == i) {
                break;
            }
            swap(heap, max, i);
            i = max;
        }
    }

    /**
     * 交换
     * @param heap
     * @param a
     * @param b
     */
    private void swap(int[] heap, int a, int b) {
        int tmp = heap[a];
        heap[a] = heap[b];
        heap[b] = tmp;
    }

}
