package tree;

import org.junit.Before;
import org.junit.Test;

public class BinaryTreeTest {

    private TreeNode root;
    private BinaryTree bt;

    @Before
    public void setup() {
        String[] values = {"A", "B", "C", "D", "E", "F", "G"};
        bt = new BinaryTree();
        root = bt.initBinTree(values);
    }

    @Test
    public void preOrder() {
        System.out.println("前序遍历：");
        bt.preOrder(root);
    }

    @Test
    public void inOrder() {
        System.out.println("中序遍历：");
        bt.inOrder(root);
    }

    @Test
    public void postOrder() {
        System.out.println("后序遍历：");
        bt.postOrder(root);
    }

    @Test
    public void levelOrder() {
        System.out.println("层次遍历：");
        bt.levelOrder(root);
    }
}
