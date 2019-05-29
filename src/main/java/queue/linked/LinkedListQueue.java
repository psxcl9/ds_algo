package queue.linked;

public class LinkedListQueue {

    private Node head = null;
    private Node tail = null;

    private static class Node {
        private int data;
        private Node next;

        public Node(int value, Node next) {
            this.data = value;
            this.next = next;
        }
    }

    public boolean enqueue(int value) {
        Node newNode = new Node(value, null);
        if (tail == null) {
            head = newNode;
            tail = newNode;
            return true;
        }
        tail.next = newNode;
        tail = tail.next;
        return true;
    }

    public int dequeue() {
        if (head == null) {
            //队列已经没有结点, 将队尾也置为null, 为下一次入队作准备
            tail = null;
            return -1;
        }
        int tmp = head.data;
        head = head.next;
        return tmp;
    }

    private void printAll() {
        Node p = head;
        System.out.println("遍历队列：");
        while (p != null) {
            System.out.println(p.data + "");
            p = p.next;
        }
    }
}
