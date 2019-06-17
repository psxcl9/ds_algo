package binarysearch;



public class BinarySearch {

    /**
     * 常规二分查找
     * @param a
     * @param value
     * @return
     */
    public static int binarySearch(int[] a, int value) {
        int n = a.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 变体一, 查找第一个值等于给定值的元素
     * @param a
     * @param value
     * @return
     */
    public static int binarySearch_01(int[] a, int value) {
        int n = a.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                if (mid == 0 || a[mid-1] != value) {
                    return mid;
                }
                high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 变体二, 查找最后一个值等于给定值的元素
     * @param a
     * @param value
     * @return
     */
    public static int binarySearch_02(int[] a, int value) {
        int n = a.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                if (mid == (n -1) || a[mid+1] != value) {
                    return mid;
                }
                low = mid + 1;
            }
        }
        return -1;
    }


    /**
     * 变体三, 查找第一个值大于等于给定值的元素
     * @param a
     * @param value
     * @return
     */
    public static int binarySearch_03(int[] a, int value) {
        int n = a.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] >= value) {
                if (mid == 0 || a[mid-1] < value) {
                    return mid;
                }
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 变体四, 查找最后一个小于等于给定值的元素
     * @param a
     * @param value
     * @return
     */
    public static int binarySearch_04(int[] a, int value) {
        int n = a.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] <= value) {
                if (mid == (n-1) || a[mid+1] > value) {
                    return mid;
                }
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

}
