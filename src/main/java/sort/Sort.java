package sort;

public class Sort {

    /**
     * 冒泡排序
     * tips: 为了保证冒泡排序是稳定的算法, 当前后两数相等时不做交换
     * @param data
     */
    public static void bubbleSort(int[] data) {
        int length = data.length;
        if (length <= 1) {
            return;
        }
        for (int i = 0; i < length; i++) {
            //提前退出冒泡排序的标志位
            boolean flag = false;
            for (int j = 0; j < length - i - 1; j++) {
                if (data[j] > data[j+1]) {
                    //交换
                    int tmp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = tmp;
                    //出现数据交换
                    flag = true;
                }
            }
            //经过内层循环排序没有出现数据交换, 即可提前退出
            if (!flag) {
                break;
            }
        }

    }

    /**
     * 插入排序
     * tips: 冒泡排序的数据交换要比插入排序的数据移动要复杂，冒泡排序需要3个赋值操作，而插入排序只需要1个，
     * 所以在对相同数组进行排序时，冒泡排序的运行时间理论上要长于插入排序。
     * @param data
     */
    public static void insertSort(int[] data) {
        int length = data.length;
        if (length <= 1) {
            return;
        }

        for (int i = 1; i < length; i++) {
            //排序过程中data[i]也就是data[j+1]这个内存块是可以占用的
            int value = data[i];
            int j = i - 1;

            for (; j >= 0; --j) {
                if (value < data[j]) {
                    //数据向后移动
                    data[j+1] = data[j];
                } else {
                    break;
                }

            }
            //给这一轮要插入的数据在已排序区间里找到了合适的位置
            data[j+1] = value;
        }

    }

    /**
     * 选择排序
     * 非稳定排序
     * @param data
     */
    public static void selectSort(int[] data) {
        int length = data.length;
        if (length <= 1) {
            return;
        }
        for (int i = 0; i < length - 1; i++) {
            int k = i;
            for (int j = i + 1; j < length; j++) {
                if (data[j] < data[k]) {
                    //k记下目前找到的最小值所在的位置
                    k = j;
                }
            }
            //内层循环结束，也就是找到本轮的最小的数以后，再进行交换
            if (i != k) {
                int tmp = data[i];
                data[i] = data[k];
                data[k] = tmp;
            }

        }
    }


    /**
     * 归并排序, 时间复杂度O(nlogn), 但归并排序并不是原地排序 故其空间复杂度O(n)
     * @param data
     */
    public static void mergeSort(int[] data) {
        //计算待排序数组的长度
        int length = data.length;
        if (length <= 1) {
            return;
        }
        //进行归并排序
        merge_sort(data, 0, length - 1);
    }

    private static void merge_sort(int[] a, int p, int r) {
        //归并排序终止条件
        if (p >= r) {
            return;
        }
        //求得p、r的中间位置q
        int q = (p + r) / 2;
        //分治递归
        merge_sort(a, p, q);
        merge_sort(a, q + 1, r);
        //最终合并已排好序的p~q和q+1~r
        merge(a, p, r, q);
    }

    private static void merge(int[] a, int p, int r, int q) {
        //i指向前半部分数组的第一个下标
        int i = p;
        //j指向后半部分数组的第一个下标
        int j = q + 1;
        //临时数组的长度, 需+1
        int n = r - p + 1;
        //申请一个临时数组
        int[] tmp = new int[n];
        //用于控制tmp的下标
        int k = 0;
        while (i <= q && j <= r) {
            if (a[i] < a[j]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
            }

        }
        //循环结束有一边的数组已经全部放入临时数组tmp, 只需将另一边数组依次放入tmp
        if (i > q) {
            //将剩余的j～r部分放入临时数组中
            while (j <= r) {
                tmp[k++] = a[j++];
            }
        } else {
            //将剩余的i~q部分放入临时数组中
            while (i <= q) {
                tmp[k++] = a[i++];
            }
        }
        k = 0;
        // 将tmp中的数组拷贝回a[p...r]
        for (; k < n; k++) {
            a[p++] = tmp[k];
        }
    }


    /**
     * 快速排序
     * @param data
     */
    public static void quickSort(int[] data) {
        //计算待排序数组的长度
        int length = data.length;
        if (length <= 1) {
            return;
        }
        //进行快速排序
        quick_sort(data, 0, length - 1);
    }

    private static void quick_sort(int[] a, int p, int r) {
        //快速排序的终止条件
        if (p >= r) {
            return;
        }
        //获取分区点
        int q = partition(a, p, r);
        //分治、递归直到区间缩小为1, 分区点的值已经置于整个数组应在的位置, 无需继续排序
        quick_sort(a, p, q-1);
        quick_sort(a, q+1, r);
    }

    private static int partition(int[] a, int p, int r) {
        //取数组中最后一个元素为分区点
        int pivot = a[r];
        //设置已处理间的游标
        int i = p;
        //设置整个待处理区间的游标
        int j = p;
        for (; j <= r - 1; j++) {
            if (a[j] < pivot) {
                //将小于pivot的数放在pivot的左边, 通过与下标为i的数进行交换
                int tmp = a[i];
                a[i++] = a[j];
                a[j] = tmp;
            }
        }
        //将分区点与下标为i的值进行交换, 此时分区点的左边全是小于pivot的值, 右边全是大于pivot的值
        int tmp = a[i];
        a[i] = pivot;
        a[r] = tmp;
        //返回分区点位置下标
        return i;
    }
    
}
