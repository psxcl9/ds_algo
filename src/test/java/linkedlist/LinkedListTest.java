package linkedlist;

import node.DoubleNode;
import node.ListNode;
import org.junit.Test;

public class LinkedListTest {

    @Test
    public void singlyLinkedList() {
        SinglyLinkedList sll = new SinglyLinkedList();
        for (int i = 1; i < 3; i++) {
            sll.insertTail(i);
        }
        sll.delete(2);
        sll.delete(1);
    }

    @Test
    public void circleLinkedList() {
        CircleLinkedList cll = new CircleLinkedList();
        for (int i = 1; i < 3; i++) {
            cll.insertHead(i);
        }
        cll.delete(new ListNode(2));
        cll.delete(new ListNode(1));
    }

    @Test
    public void doubleCircleLinkedList() {
        DoubleCircleLinkedList dcll = new DoubleCircleLinkedList();
        for (int i = 1; i < 5; i++) {
            dcll.insertHead(i);
        }
        dcll.delete(new DoubleNode(1));
    }
}
