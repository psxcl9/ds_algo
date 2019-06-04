package queue.circular;

/**
 * 循环队列
 */
public class CircularQueue {

    private int[] queue;
    private int n;
    private int head;
    private int tail;

    public CircularQueue(int capacity) {
        queue = new int[capacity];
        n = capacity;
        head = 0;
        tail = 0;
    }

    public boolean enqueue(int value) {
        if ((tail + 1) % n == head) {
            //队列满了, 有个约定条件会导致此时tail指向的位置实际上是没有存储数据的, 所以循环队列会浪费一个数组的存储空间
            return false;
        }
        queue[tail] = value;
        // 此时不能使用简单的tail++, 因为是循环队列需要考虑边界情况. 当tail+1 == n时 模n等于0 其他情况都等于tail+1
        tail = (tail + 1) % n;
        return true;
    }

    //出队
    public int dequeue() {
        if (head == tail) {
            //队列为空
            return -1;
        }
        int item = queue[head];
        head = (head + 1) % n;
        return item;
    }
}
