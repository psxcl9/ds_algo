package array;

import leetcode.Solution;
import org.junit.Assert;
import org.junit.Test;

public class ArrayListTest {

    @Test
    public void arrayList() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
        Assert.assertEquals(new Integer(3), list.remove(2));
        Assert.assertEquals(new Integer(4), list.get(2));
        Assert.assertEquals(8, list.find(10));
    }

    @Test
    public void merge() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        Solution.merge(nums1, 3, nums2, 3);
    }

}
