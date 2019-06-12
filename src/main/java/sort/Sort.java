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
                    swap(data, j, j+1);
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
     * 希尔排序, 插入排序的变种
     * @param data
     */
    public static void shellSort(int[] data) {
        int length = data.length;
        if (length <= 1) {
            return;
        }

        int h = 1;
        //h = 1、4、13、40、121
        while (h < length / 3) {
            h = 3 * h + 1;
        }
        //h == 1时就是插入排序, 只是现在的数组已经大部分有序了
        while (h >= 1) {
            //对i、i+h、i+2h、i+3h组成的一组数组进行排序
            for (int i = h; i < length; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (data[j] < data[j-h]) {
                        //交换
                        int tmp = data[j];
                        data[j] = data[j-h];
                        data[j-h] = tmp;
                    }
                }
            }
            h = h / 3;

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
            int min = i; //最小元素索引
            for (int j = i + 1; j < length; j++) {
                if (data[j] < data[min]) {
                    //k记下目前找到的最小值所在的位置
                    min = j;
                }
            }
            //内层循环结束，也就是找到本轮的最小的数以后，再进行交换
            if (i != min) {
                swap(data, i, min);
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
        int q = p + (r - p) / 2;
        //分治递归
        merge_sort(a, p, q);
        merge_sort(a, q + 1, r);
        //最终合并已排好序的p~q和q+1~r
        merge(a, p, q, r);
    }

    private static void merge(int[] a, int p, int q, int r) {
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
        int start = i;
        int end = q;
        if (j <= r) {
            start = j;
            end = r;
        }
        while (start <= end) {
            tmp[k++] = a[start++];
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
                if (i != j) {
                    swap(a, i, j);
                }
                i++;
            }
        }
        //将分区点与下标为i的值进行交换, 此时分区点的左边全是小于pivot的值, 右边全是大于pivot的值
        swap(a, i, r);
        //返回分区点位置下标
        return i;
    }

    /**
     * 计数排序
     * 计数排序只能用在数据范围不大的场景中, 如果数据范围k比要排序的数据个数n大很多, 就不适合计数排序了
     * 计数排序只能给非负整数排序, 其他情况需要转化为非负整数
     * @param a 待排序的数组 非负整数
     */
    public static void countingSort(int[] a) {
        int n = a.length;
        if (n <= 1) {
            return;
        }
        //找出数组a的数据范围
        int max = a[0];
        for (int i = 1; i < n; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        //新建一个计数数组c 下标[0~max] 大小为max+1
        int[] c = new int[max+1];
        //数组c的下标对应待排序a的数据范围, 遍历数组a 累加计算a中每个数据重复的总数
        for (int j = 0; j < n; j++) {
            c[a[j]]++;
        }
        //从0开始相邻累加, 最后的结果就是c[k]中存储的是a数组中小于等于k的总个数
        for (int k = 1; k <= max; k++) {
            c[k] = c[k-1] + c[k];
        }
        //申请临时数组r 存放排序的数
        int[] r = new int[n];
        for (int p = n-1; p >= 0; p--) {
            //重复的数据从右向左排
            int index = c[a[p]] - 1;
            r[index] = a[p];
            --c[a[p]];
        }
        //将临时数组拷贝到a中
        for (int q = 0; q < n; q++) {
            a[q] = r[q];
        }

    }

    public static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

}
