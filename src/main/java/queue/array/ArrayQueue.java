package queue.array;

public class ArrayQueue {

    private int[] queue;
    //队列长度
    private int length;
    private int head;
    private int tail;

    public ArrayQueue(int n) {
        this.length = n;
        queue = new int[n];
        head = 0;
        tail = 0;
    }

    public ArrayQueue() {
        this(10);
    }

    //入队
    public boolean enqueue(int value) {
        if (tail == length) {
            //队尾指针已经走到尽头
            if (head == 0) {
                //队列已经满了, 不能入队
                return false;
            }
            //之前有出队的元素, 数组中有空余空间
            for (int i = head; i < tail; i++) {
                queue[i - head] = queue[i];
            }
            //运算之后tail指向队尾元素的下一个内存空间
            tail = tail - head;
            head = 0;
        }
        queue[tail++] = value;
        return true;
    }

    //出队
    public int dequeue() {
        //head == tail表示该队列为空
        if (head == tail) {
            return -1;
        }
        int tmp = queue[head];
        queue[head++] = 0;
        return tmp;
    }

}
