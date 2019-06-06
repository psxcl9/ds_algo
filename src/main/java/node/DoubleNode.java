package node;

public class DoubleNode {
    public int data;
    public DoubleNode prev;
    public DoubleNode next;

    public DoubleNode(int val) {
        this.data = val;
        prev = null;
        next = null;
    }
}
