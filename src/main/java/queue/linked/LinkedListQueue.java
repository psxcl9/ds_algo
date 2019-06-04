package queue.linked;

import node.ListNode;

public class LinkedListQueue {

    private ListNode head;
    private ListNode tail;

    public LinkedListQueue() {
        head = null;
        tail = null;
    }

    public boolean enqueue(int value) {
        ListNode node = new ListNode(value);
        //空队列特殊处理
        if (tail == null) {
            head = node;
            tail = node;
            return true;
        }
        tail.next = node;
        tail = node;
        return true;
    }

    public int dequeue() {
        if (head == null) {
            tail = null;
            return -1;
        }
        int item = head.val;
        head = head.next;
        return item;
    }

    public void printAll() {
        ListNode p = head;
        while (p != null) {
            System.out.print(p.val + "-->");
            p = p.next;
        }
    }
}
