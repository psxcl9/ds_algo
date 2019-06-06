package linkedlist;

import node.DoubleNode;
import node.ListNode;

/**
 * 双向循环链表
 */
public class DoubleCircleLinkedList {

    private DoubleNode head;
    private DoubleNode tail;

    public DoubleCircleLinkedList() {
        head = new DoubleNode(-1);
        head.next = head;
        head.prev = head;
        tail = head;
    }

    /**
     * 顺序插入, 链表尾部插入
     * @param val
     */
    public void insertTail(int val) {
        DoubleNode newNode = new DoubleNode(val);
        tail.next = newNode;
        newNode.prev = tail;
        newNode.next = head;
        head.prev = newNode;
        tail = newNode;
    }

    /**
     * 头插法, 输出顺序与插入顺序相反
     * @param val
     */
    public void insertHead(int val) {
        DoubleNode newNode = new DoubleNode(val);
        if (head.next == head) {
            head.next = newNode;
            newNode.prev = head;
            newNode.next = head;
            head.prev = newNode;
            tail = newNode;
            return;
        }
        DoubleNode first = head.next;
        newNode.next = first;
        first.prev = newNode;
        head.next = newNode;
        newNode.prev = head;
    }

    /**
     * 删除一个结点, 如不存在直接返回
     * @param delNode
     */
    public void delete(DoubleNode delNode) {
        DoubleNode p = head;
        DoubleNode q = null;
        if (delNode.data == tail.data) {
            //删除尾结点
            tail = tail.prev;
        }
        while (p.data != delNode.data) {
            if (p == head && q == tail) {
                break;
            }
            q = p;
            p = p.next;
        }
        //待删除值不存在
        if (p == head && q == tail) {
            return;
        }
        DoubleNode next = p.next;
        q.next = next;
        next.prev = q;
    }

    public void delete(int val) {
        DoubleNode delNode = new DoubleNode(val);
        delete(delNode);
    }
}
