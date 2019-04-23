package queue.array;

public class ArrayQueue {
    private int[] queues;
    private int n;//队列的长度
    //head队头，tail队尾
    private int head = 0;
    private int tail = 0;

    public ArrayQueue(int capacity) {
        queues = new int[capacity];
        n = capacity;
    }

    //入队
    public boolean enqueue(int value) {
        //tail == n时tail的值是队尾下标+1
        if (tail == n) {
            if (head == 0) {
                //队列已满
                return false;
            }
            //队头部分还有空余位置 可以迁移数据再从队尾插入
            for (int i = head; i < tail; i++) {
                queues[i - head] = queues[i];
            }
            //运算之后tail指向队尾元素的下一个内存空间
            tail -= head;
            head = 0;
        }
        queues[tail++] = value;
        return true;
    }

    //出队
    public int dequeue() {
        //head == tail表示该队列为空
        if (head == tail) {
            return -1;
        }
        int tmp = queues[head++];
        return tmp;
    }

}
