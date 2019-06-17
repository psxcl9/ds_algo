package leetcode;

import node.ListNode;
import org.junit.Assert;
import org.junit.Test;


public class LeetCodeTest {
    @Test
    public void isValid() {
        Assert.assertTrue(Solution.isValid(""));
        Assert.assertTrue(Solution.isValid("([]){}"));
        Assert.assertFalse(Solution.isValid("({}"));
        Assert.assertFalse(Solution.isValid("(]{}"));
    }

    @Test
    public void isPalindrome() {
        Assert.assertTrue(Solution.isPalindrome(9));
        Assert.assertTrue(Solution.isPalindrome(23432));
        Assert.assertFalse(Solution.isValid("12341"));
        Assert.assertFalse(Solution.isValid("-121"));
    }

    @Test
    public void rotate() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        Solution.rotate_1(nums, 3);
    }

    @Test
    public void reverse() {
        Assert.assertEquals(0, Solution.reverse(1534236469));
        Assert.assertEquals(-2143847412, Solution.reverse(-2147483412));
    }

    @Test
    public void strStr() {
        Solution.strStr("a", "a");
        Assert.assertEquals(0, Solution.strStr("a", "a"));
    }

    @Test
    public void removeNthFromEnd() {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        head.next = second;
        second.next = third;
        third.next = four;
        four.next = five;

        Solution.removeNthFromEnd(head, 2);
    }

    @Test
    public void findFirstCommonNode() {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        head.next = second;
        second.next = third;
        third.next = four;
        four.next = five;

        ListNode head2 = new ListNode(6);
        ListNode second2 = new ListNode(7);
        ListNode third2 = new ListNode(8);
        head2.next = second2;
        second2.next = third2;

        Solution.findFirstCommonNode(head, head2);
    }

    @Test
    public void validateStackSequences() {
        int[] pushed = {1,2,3,4,5};
        int[] poped = {4,5,3,2,1};
        Solution.validateStackSequences(pushed, poped);
    }

    @Test
    public void search() {
        int[] nums = {4,5,6,7,0,1,2};
        int p = Solution.search(nums, 2);
        System.out.println(p);
    }
}
