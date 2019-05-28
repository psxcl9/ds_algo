package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {

    /**
     * 有效括号
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
     * 是否为回文数 算术解答
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

}
