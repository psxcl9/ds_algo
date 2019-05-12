package tree;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTreeTest {

    @Test
    public void find() {
        int[] values = {5, 7, 2, 4, 1, 9, 6};
        BinarySearchTree bst = new BinarySearchTree();
        bst.buildBST(values);
        Assert.assertTrue(bst.find(4));
        Assert.assertFalse(bst.find(3));
    }

    @Test
    public void delete() {
        int[] values = {5, 7, 2, 4, 1, 9, 6};
        BinarySearchTree bst = new BinarySearchTree();
        bst.buildBST(values);
        Assert.assertFalse(bst.delete(3));
        Assert.assertTrue(bst.delete(5));
    }

    @Test
    public void deleteRoot() {
        int[] values = {5, 7, 2, 4, 1, 9, 6};
        BinarySearchTree bst = new BinarySearchTree();
        bst.buildBST(values);
        Assert.assertTrue(bst.delete(5));
        Assert.assertEquals(6, bst.getRoot().getValue());
    }

    @Test
    public void deleteOnlyOne() {
        int[] values = {5};
        BinarySearchTree bst = new BinarySearchTree();
        bst.buildBST(values);
        Assert.assertTrue(bst.delete(5));
        Assert.assertEquals(null, bst.getRoot());
    }
}
