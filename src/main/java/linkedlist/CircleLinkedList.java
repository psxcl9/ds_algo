package linkedlist;

import node.ListNode;

public class CircleLinkedList {

    private ListNode head;
    private ListNode tail;

    public CircleLinkedList() {
        head = null;
        tail = null;
    }

    /**
     * 顺序插入, 链表尾部插入
     * @param val
     */
    public void insertTail(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        newNode.next = head;
        tail = newNode;
    }

    /**
     * 头插法, 输出顺序与插入顺序相反
     * @param val
     */
    public void insertHead(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        tail.next = head;
    }

    /**
     * 删除指定结点, 如果不存在直接返回
     * @param delNode
     */
    public void delete(ListNode delNode) {
        if (delNode == null || head == null) {
            return;
        }
        //待删除结点是头结点
        if (head.val == delNode.val && head.next != head) {
            //链表中还有其他结点
            head = head.next;
            tail.next = head;
            return;
        } else if (head.next == head) {
            //链表中只剩头结点
            head = null;
            tail = null;
            return;
        }
        ListNode p = head;
        ListNode q = null;
        while (p.val != delNode.val) {
            q = p;
            p = p.next;
        }
        if (p == tail) {
            q.next = head;
            tail = q;
        } else {
            q.next = q.next.next;
        }
    }

    public void delete(int val) {
        ListNode node = new ListNode(val);
        delete(node);
    }
}
