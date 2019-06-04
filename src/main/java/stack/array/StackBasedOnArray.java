package stack.array;

import java.util.Stack;

/**
 * 基于数组的栈
 */
public class StackBasedOnArray {

    private int[] stacks;
    //栈中元素的数量
    private int count;
    //栈的容量
    private int capacity;

    public StackBasedOnArray(int capacity) {
        stacks = new int[capacity];
        this.capacity = capacity;
        count = 0;
    }

    public StackBasedOnArray() {
        this(8);
    }

    /**
     * 入栈操作
     * @param item
     * @return
     */
    public int push(int item) {
        if (this.count == this.capacity) {
            //栈满, 可支持动态扩容
            int newCapacity = this.capacity * 2;
            resize(newCapacity);
        }
        this.stacks[count++] = item;
        return item;
    }

    /**
     * 获取栈顶元素, 不弹出
     * @return
     */
    public int peek() {
        if (this.count == 0) {
            //栈空
            return -1;
        }
        return this.stacks[count-1];
    }

    /**
     * 出栈操作
     * @return
     */
    public int pop() {
        int item = peek();
        count--;
        if (count < capacity / 3 || count < capacity / 4) {
            int newCapacity = this.capacity / 2;
            resize(newCapacity);
        }
        return item;
    }

    private void resize(int newCapacity) {
        int[] newStacks = new int[newCapacity];
        for (int index = 0; index < count; index++) {
            newStacks[index] = stacks[index];
        }
        this.stacks = newStacks;
    }

}
