package queue;

import org.junit.Assert;
import org.junit.Test;
import queue.array.ArrayQueue;

public class QueueTest {
    @Test
    public void queue() {
        ArrayQueue queue = new ArrayQueue();
        for (int i =1; i <10; i++) {
            queue.enqueue(i);
        }
        Assert.assertEquals(1, queue.dequeue());
        Assert.assertEquals(2, queue.dequeue());
        Assert.assertEquals(3, queue.dequeue());
    }
}
