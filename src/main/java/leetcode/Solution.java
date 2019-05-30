package leetcode;

import listnode.ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {

    /**
     * no.20 有效括号
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        if (s.isEmpty()) {
            return true;
        }
        //将三种括号存放在一个map中
        Map brackets = new HashMap(4);
        brackets.put(')', '(');
        brackets.put(']', '[');
        brackets.put('}', '{');
        //创建一个栈空间来存放左括号
        Stack stack = new Stack();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (!brackets.containsKey(c)) {
                //字符c是左括号 直接压栈
                stack.push(c);
            } else {
                //字符c是右括号 出栈进行比较
                //需要先判断栈中是否有左括号压栈
                if (stack.empty()) {
                    return false;
                }
                char leftBracket = (char) stack.pop();
                char goalBracket = (char) brackets.get(c);
                if (leftBracket != goalBracket) {
                    return false;
                }
            }
        }
        if (stack.empty()) {
            return true;
        }
        //字符串已遍历完, 但左括号的栈空间还有未匹配的
        return false;
    }

    /**
     * no.9 是否为回文数 算术解答
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        int y = x;
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        if (x >= 0 && x < 10) {
            return true;
        }
        //从右向左截取一位
        int newNum = 0;
        while (x != 0) {
            newNum = x % 10 + newNum * 10;
            x = x / 10;
        }
        if (y == newNum) {
            return true;
        }
        return false;
    }

    /**
     * no.1 两数之和
     * 1. 暴力解题
     * 2. hash
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum_1(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
    public static int[] twoSum_2(int[] nums, int target) {
        Map map = new HashMap(16);
        //将目标数组放在一个map中, key数组中的值, value为数组中的下标
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int j = 0; j < nums.length - 1; j++) {
            int potential = target - nums[j];
            if (map.containsKey(potential)) {
                int index = (int) map.get(potential);
                //不能重复利用这个数组中同样的元素, 但允许数组中不同下标有相同值的元素
                if (index != j) {
                    return new int[]{j, index};
                }
            }

        }
        return null;
    }


    /**
     * no.905 按奇偶排序数组
     * @param A
     * @return
     */
    public static int[] sortArrayByParity(int[] A) {
        int n = A.length;
        //定义两个指针, 偶数指针从0开始, 奇数指针从n-1开始
        int even = 0;
        int odd = n - 1;
        //用于交换
        int tmp;
        //循环结束条件两个指针相遇
        while (even < odd) {
            //左下标是奇数, 右下标是偶数, 交换
            if (A[even] % 2 == 1 && A[odd] % 2 == 0) {
                tmp = A[even];
                A[even++] = A[odd];
                A[odd--] = tmp;
            } else if (A[even] % 2 == 0) {
                //左边的是偶数继续遍历
                even++;
            } else if (A[odd] % 2 == 1) {
                //右边的是奇数继续遍历
                odd--;
            }
        }
        return A;
    }

    /**
     * no.189 旋转数组
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数
     * @param nums
     * @param k
     *
     * 1.双重循环
     * 时间复杂度：O(kn) 空间复杂度：O(1)
     */
    public static void rotate_1(int[] nums, int k) {
        int n = nums.length - 1;
        int tmp;
        while (k > 0) {
            tmp = nums[n];
            for (int i = n-1; i >= 0; i--) {
                nums[i+1] = nums[i];
            }
            nums[0] = tmp;
            k--;
        }
    }

    /**
     * 2.翻转
     * 时间复杂度：O(n) 空间复杂度：O(1)
     */
    public static void rotate_2(int[] nums, int k) {
        int n = nums.length;
        //防止k的值大于数组长度
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        int tmp;
        while (start < end) {
            tmp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = tmp;
        }
    }


    /**
     * no.26 删除排序数组中的重复项
     * @param nums
     * @return 返回不重复元素的个数
     */
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 1;
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int size = 1;
        while (j < n) {
            if (nums[i] == nums[j]) {
                j++;
            } else {
                nums[size++] = nums[j];
                i = j;
                j++;
            }
        }
        return size;
    }


    /**
     * no.240 搜索二维矩阵
     * 该矩阵具有以下特性：
     *    每行的元素从左到右升序排列。
     *    每列的元素从上到下升序排列。
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        //行数
        int row = matrix.length;
        //二维数组为空时直接返回false
        if (row == 0) {
            return false;
        }
        int row1 = 0;
        //列数
        int column = matrix[0].length;
        column--;
        while (row1 < row && column >= 0) {
            // 每次循环之前 取二维数组右上角的数作为基数
            int goal = matrix[row1][column];
            if (target < goal) {
                //删除这一列
                column--;
            } else if (target > goal) {
                //删除这一行
                row1++;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * no.7 整数翻转
     * @param x
     * @return
     */
    public static int reverse(int x) {
        int sign = (x > 0) ? 1 : -1;
        //作为正数处理
        x = (x > 0 ? x : -x);
        int newX = 0;
        while (x != 0) {
            //检测 反转后整数溢出那么就返回 0
            if (newX != (newX * 10) / 10) {
                return 0;
            }
            newX = x % 10 + newX * 10;
            x = x / 10;
        }
        return newX * sign;
    }


    /**
     * no.28 实现 strStr() 函数
     * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个
     * 位置 (从0开始)。如果不存在，则返回 -1。当 needle 是空字符串时应当返回 0
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        //haystack 字符串的长度
        int n1 = haystack.length();
        //needle 字符串的长度
        int n2 = needle.length();
        if (n2 > n1) {
            return -1;
        }
        if (n2 == 0) {
            return 0;
        }
        char[] haystackChar = haystack.toCharArray();
        char[] needleChar = needle.toCharArray();
        //定义两个指针分别指向上面两个char数组
        int i = 0;
        int j = 0;
        while (i < n1 && j < n2) {
            if (haystackChar[i] == needleChar[j]) {
                ++i;
                ++j;
            } else {
                //j归零, i始终向前移动
                i = i - j + 1;
                j = 0;
            }
        }
        if (j == n2) {
            return i - j;
        }
        return -1;

    }

    /**
     * 剑指offer no.5 从尾到头打印链表
     * @param listNode
     * @return
     */
    //使用栈的特性
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null) {
            return null;
        }
        ListNode p = listNode;
        Stack stack = new Stack();
        while (p != null) {
            stack.push(p.val);
            p = p.next;
        }
        ArrayList list = new ArrayList();
        while (!stack.empty()) {
            list.add(stack.pop());
        }
        return list;
    }
    //使用递归
    public static ArrayList<Integer> printListFromTailToHeadRecursive(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if (listNode != null) {
            if (listNode.next != null) {
                list = printListFromTailToHeadRecursive(listNode.next);

            }
            list.add(listNode.val);
        }
        return list;
    }
}
