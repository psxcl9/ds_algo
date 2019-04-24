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
                if (data[j] > value) {
                    //数据移动
                    data[j+1] = data[j];
                } else {
                    break;
                }
            }
            //给这一轮要插入的数据找到了合适的位置
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
                if (data[k] > data[j]) {
                    //k记下目前找到的最小值所在的位置
                    k = j;
                }
            }
            //内层循环结束，也就是找到本轮循环的最小的数以后，再进行交换
            if (i != k) {
                int tmp = data[i];
                data[i] = data[k];
                data[k] = tmp;
            }
        }
    }

}
