package tree;

/**
 * 二叉树链式储存的结点数据结构
 */
public class TreeNode {

    private Object value;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
