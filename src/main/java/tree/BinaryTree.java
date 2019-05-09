package tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    /**
     * 构建一个简单的链式完全二叉树
     */
    public TreeNode initBinTree(String[] strs) {
        if (strs.length == 1) {
            return new TreeNode(strs[0]);
        }
        //将要初始化完全二叉树的数组放在一个新的数组, 下标从1开始
        String[] newStr = new String[strs.length + 1];
        int j = 1;
        for (int i = 0; i < strs.length;) {
            newStr[j++] = strs[i++];
        }
        return buildTree(null, newStr, 1);
    }

    private TreeNode buildTree(TreeNode root, String[] vals, int index) {
        if (index >= vals.length) {
            return null;
        }
        root = new TreeNode(vals[index]);
        root.setLeft(buildTree(root.getLeft(), vals, 2*index));
        root.setRight(buildTree(root.getRight(), vals, 2*index + 1));
        return root;
    }

    /**
     * 前序遍历递推公式:print root -> preOrder(root.left) -> preOrder(root.right)
     * @param root
     */
    public void preOrder(TreeNode root) {
        //递归的终止条件, 很关键
        if (root == null) {
            return;
        }
        //前序遍历是先访问这个节点, 再访问它的左子树, 最后访问它的右子树
        System.out.println("-->" + root.getValue());
        preOrder(root.getLeft());
        preOrder(root.getRight());

    }

    /**
     * 中序遍历递推公式: preOrder(root.left) -> print root -> preOrder(root.right)
     * @param root
     */
    public void inOrder(TreeNode root) {
        //递归的终止条件, 很关键
        if (root == null) {
            return;
        }
        //中序遍历是先访问这个节点的左子树, 再访问它本身, 最后访问它的右子树
        inOrder(root.getLeft());
        System.out.println("-->" + root.getValue());
        inOrder(root.getRight());

    }

    /**
     * 后序遍历递推公式: preOrder(root.left) -> preOrder(root.right) -> print root
     * @param root
     */
    public void postOrder(TreeNode root) {
        //递归的终止条件, 很关键
        if (root == null) {
            return;
        }
        //后序遍历是先访问这个节点的左子树, 再访问它的右子树, 最后访问它本身
        postOrder(root.getLeft());
        postOrder(root.getRight());
        System.out.println("-->" + root.getValue());

    }

    /**
     * 按层次遍历
     * @param root
     */
    public void levelOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList();
        //定义一个指针用于遍历整颗二叉树
        TreeNode cur = null;
        //将根结点放入队列中
        queue.offer(root);
        while (!queue.isEmpty()) {
            //打印当前从队列中取出的结点
            cur = queue.poll();
            System.out.println("-->" + cur.getValue());
            if (cur.getLeft() != null) {
                queue.offer(cur.getLeft());
            }
            if (cur.getRight() != null) {
                queue.offer(cur.getRight());
            }
        }
    }

}

