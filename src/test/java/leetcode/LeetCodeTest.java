package leetcode;

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
}