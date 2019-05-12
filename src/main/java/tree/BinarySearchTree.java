package tree;

/**
 * 二叉查找树
 */
public class BinarySearchTree {

    private TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    /**
     * 二叉搜索树的插入
     * @param data
     */
    public void insert(int data) {
        if (root == null) {
            root = new TreeNode(data);
            return;
        }
        //定义一个指针用于遍历二叉搜索树
        TreeNode cur = this.root;
        while (cur != null) {
            //当前结点的值
            int goal = (int) cur.getValue();
            if (data < goal) {
                //遍历左子树
                if (cur.getLeft() == null) {
                    cur.setLeft(new TreeNode(data));
                    return;
                }
                cur = cur.getLeft();
            } else if (data > goal) {
                //遍历右子树
                if (cur.getRight() == null) {
                    cur.setRight(new TreeNode(data));
                    return;
                }
                cur = cur.getRight();
            }

        }
    }

    /**
     * 删除指定数据的结点
     * @param data
     * @return
     */
    public boolean delete(int data) {
        //使用p结点来遍历整个二叉树
        TreeNode p = this.root;
        //pf表示p结点的father结点
        TreeNode pf = null;
        //找到待删除data所在结点位置, 也有可能不存在
        while (p != null) {
            pf = p;
            int value = (int) p.getValue();
            if (data < value) {
                //递归左子树
                p = p.getLeft();
            } else if (data > value) {
                //递归右子树
                p = p.getRight();
            } else {
                //p.getValue() == data
                break;
            }
        }
        //二叉树没有对应的该结点
        if (p == null) {
            return false;
        }
        //先处理如果待删除结点有左右子树的情况, 将其转换成"删除一个没有左右子树或者只有一个右子树"的情况
        if (p.getLeft() != null && p.getRight() != null) {
            //在p的右子树中找到最小的那个结点minP
            TreeNode minP = p.getRight();
            //minP的父结点
            TreeNode minPf = null;
            //遍历minP的整个左子树, 找到最后一个左子树结点
            while (minP.getLeft() != null) {
                minPf = minP;
                minP = minP.getLeft();
            }
            //将p结点右子树中最小的值放入p结点中
            p.setValue(minP.getValue());
            //现在就变成删除minP这个结点, 已知minP至多只有一个右子树
            p = minP;
            pf = minPf;
        }
        //删除没有左右子树或者只有一个子树的情况, 程序走到这里也只有这三种情况
        TreeNode child;
        if (p.getLeft() != null) {
            child = p.getLeft();
        } else if (p.getRight() != null) {
            child = p.getRight();
        } else {
            //没有左右子树
            child = null;
        }
        //执行删除操作
        if (p == pf) {
            //因为在执行while循环寻找待删除的结点时, 至少会执行一次pf = p
            //也可以将TreeNode的value属性改为int, 这样while循环结束的条件就是(p != null && data ！= p.getValue()), 删除根结点的判断条件就是pf == null
            //删除根结点
            this.root = child;
        } else if (p == pf.getLeft()) {
            pf.setLeft(child);
        } else {
            pf.setRight(child);
        }
        return true;
    }

    /**
     * 构建一个二叉搜索树
     * @param values 默认传入数组(0-n)都有数
     */
    public void buildBST(int[] values) {
        int n = values.length;
        for (int i = 0; i < n; i++) {
            insert(values[i]);
        }
    }

    /**
     * 二叉查找树的查找操作
     * @param data
     * @return
     */
    public boolean find(int data) {
        TreeNode cur = this.root;
        while (cur != null) {
            //当前结点的值
            int goal = (int) cur.getValue();
            if (data < goal) {
                cur = cur.getLeft();
            } else if (data > goal) {
                cur = cur.getRight();
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * 查询二叉树最小结点
     * @return
     */
    public int minNum() {
        TreeNode cur = this.root;
        while (cur.getLeft() != null) {
            cur = cur.getLeft();
        }
        return (int) cur.getValue();
    }

    /**
     * 查询二叉树最大结点
     * @return
     */
    public int maxNum() {
        TreeNode cur = this.root;
        while (cur.getRight() != null) {
            cur = cur.getRight();
        }
        return (int) cur.getValue();
    }
}
