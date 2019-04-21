package stack.linked;

public class LinkedListStack {

    private Node top = null;

    private static class Node {
        //定义链表栈的结点
        private int data;
        private Node next;

        private Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    //入栈 链式栈的top指针始终指向栈顶元素
    public boolean push(int item) {
        Node newNode = new Node(item, null);
        // 判断是否栈空
        if (top == null) {
            top = newNode;
            return true;
        } else {
            newNode.next = top;
            top = newNode;
            return true;
        }
    }

    //出栈 先进后出，后进先出
    public int pop() {
        if (top == null) {
            return -1;
        } else {
            int value = top.data;
            top = top.next;
            return value;
        }
    }

    public void printAll() {
        Node p = top;
        System.out.println("遍历栈：");
        while (p != null) {
            System.out.println(p.data + " ");
            p = p.next;
        }
    }
}
