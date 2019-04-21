package stack.array;

public class ArrayStack {
    private int[] stacks;
    private int count;
    private int length; //栈的长度

    public ArrayStack(int n) {
        stacks = new int[n];
        count = 0;
        length = n;
    }

    //入栈操作
    public boolean push(int data) {
        //数组空间不够
        if (count == length) {
            return false;
        }
        stacks[count] = data;
        count++;
        return true;
    }

    public int pop() {
        if (count == 0) {
            return -1;
        }
        //顺序栈的top指针在栈顶元素之上
        int tmp = stacks[count-1];
        count--;
        return tmp;
    }
}
