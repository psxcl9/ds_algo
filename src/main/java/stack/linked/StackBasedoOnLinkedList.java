package stack.linked;

import node.ListNode;

public class StackBasedoOnLinkedList {

    private ListNode top = null;

    /**
     * 入栈操作
     * @param item
     * @return
     */
    public int push(int item) {
        ListNode pNode = new ListNode(item);
        if (top == null) {
            //插入头结点
            top = pNode;
        } else {
            pNode.next = top;
            top = pNode;
        }
        return item;
    }

    /**
     * 获取栈顶元素
     * @return
     */
    public int peek() {
        if (top == null) {
            //空栈
            return -1;
        }
        int item = top.val;
        return item;
    }

    /**
     * 出栈
     * @return
     */
    public int pop() {
        int item = peek();
        top = top.next;
        return item;
    }

    /**
     * 打印栈
     */
    public void printAll() {
        ListNode p = top;
        while (p != null) {
            System.out.print(p.val + " --> ");
            p = p.next;
        }
    }
}
