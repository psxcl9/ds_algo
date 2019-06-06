package linkedlist;

import node.ListNode;

public class SinglyLinkedList {

    private ListNode head;
    /**
     * 始终指向链表最后一个结点, 方便顺序插入等操作
     */
    private ListNode tail;

    public SinglyLinkedList() {
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
    }

    /**
     * 删除一个已知结点, 如果结点不存在直接返回
     * @param delNode
     */
    public void delete(ListNode delNode) {
        if (delNode == null || head == null) {
            return;
        }
        //删除头结点
        if (head.val == delNode.val && head.next != null) {
            //链表中还有其他结点
            head = head.next;
            return;
        } else if (head.next == null) {
            head = null;
            tail = null;
            return;
        }
        ListNode p = head;
        //记录前一个结点
        ListNode q = null;
        //找到待删除结点前一个结点的指针
        while (p != null && p.val != delNode.val) {
            q = p;
            p = p.next;
        }
        //没有找到该结点
        if (p == null) {
            return;
        }
        //删除的结点是尾结点, 需要改变tail指针的位置
        if (p == tail) {
            tail = q;
        }
        //删除
        q.next = q.next.next;
    }


    public void delete(int val) {
        ListNode node = new ListNode(val);
        delete(node);
    }


}
