package sort;

import static sort.Sort.swap;

/**
 * 排序方法的具体应用
 */
public class SortApplication {

    /**
     * NO.1 利用快排的思想在O(n)内查找第K大的元素
     * @param data
     * @param k
     * @return
     */
    public static int findKthLargest(int[] data, int k) {
        int n = data.length;
        return find_kth(data, 0, n-1, k);
    }

    /**
     * @param data
     * @param f 数组开始下标
     * @param l 数组结束下标
     * @param k 第k大的数 参数
     * @return
     */
    private static int find_kth(int[] data, int f, int l, int k) {
        //以数组最后一个元素作为分区点, 使得下标p之前的数值都大于p
        int p = partition(data, f, l);
        //经过partition方法后, p前面会有n个值大于p(n>=0), p位置上的值即是当前数组第n+1大的数, 数值上 p == n(数组下标从0开始)
        while (p + 1 != k) {
            if (k < p + 1) {
                //在p的左边继续调用partition方法
                p = partition(data, 0, p - 1);
            } else {
                //在p的右边继续调用partition方法
                p = partition(data, p + 1, l);
            }
        }
        return data[p];
    }

    /**
     * 每次以数组最后一个元素作为分区点, 遍历f～l的所有数值, 使得大于分区点的数都在其左边,  小于分区点的数都在其右边
     * @param data
     * @param f
     * @param l
     * @return
     */
    private static int partition(int[] data, int f, int l) {
        //取数组最后一个元素作为分区点
        int pivot = data[l];
        //游标i控制已排序区间
        int i = f;
        //游标j遍历整个数组
        int j = f;
        for (; j < l; j++) {
            if (data[j] > pivot) {
                //将大于pivot的数放在pivot的左边 每次总与下标i的值交换
                if (i != j) {
                    swap(data, i, j);
                }
                i++;
            }
        }
        //最后将pivot与位置i的值进行交换
        swap(data, i, l);
        return i;
    }


}
