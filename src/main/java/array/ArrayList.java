package array;

public class ArrayList<T> {
    private T[] data;
    //动态数组中已有的元素个数
    private int size;

    public ArrayList() {
        this(8);
    }

    public ArrayList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        }
        data = (T[]) new Object[capacity];
        size = 0;
    }

    // 获取数组容量
    public int getCapacity() {
        return data.length;
    }

    // 获取当前元素个数
    public int count() {
        return size;
    }

    // 判断数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 修改 index 位置的元素
    public void set(int index, T e) {
        rangeCheck(index);
        data[index] = e;
    }

    // 获取对应 index 位置的元素
    public T get(int index) {
        rangeCheck(index);
        return data[index];
    }

    // 查看数组是否包含元素e
    public boolean contains(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    // 获取对应元素的下标, 未找到，返回 -1
    public int find(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    // 在 index 位置，插入元素e, 时间复杂度 O(m+n)
    public void add(int index, T e) {
        checkIndexAdd(index);
        if (size == data.length) {
            resize(data.length * 2);
        }
        int i = size - index;
        while (i > 0) {
            data[size] = data[size-1];
            i--;
        }
        data[index] = e;
        size++;
    }

    public void add(T e) {
        add(size, e);
    }

    // 向数组头插入元素
    public void addFirst(T e) {
        add(0, e);
    }

    // 向数组尾插入元素
    public void addLast(T e) {
        add(size, e);
    }

    // 删除 index 位置的元素，并返回
    public T remove(int index) {
        rangeCheck(index);
        T item = data[index];
        size--;
        int i = index;
        while (i < size) {
            data[i] = data[++i];
        }
        data[size] = null;
        // 缩容
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return item;
    }

    // 删除第一个元素
    public T removeFirst() {
        return remove(0);
    }

    // 删除末尾元素
    public T removeLast() {
        return remove(size - 1);
    }

    // 从数组中删除指定元素
    public void removeElement(T e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    // 扩容方法，时间复杂度 O(n)
    private void resize(int newCapacity) {
        T[] newData = (T[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    private void checkIndexAdd(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed! Require index >=0 and index <= size.");
        }
    }

    private void rangeCheck(int index) {
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("Illegal index! Require index >=0 and index < size.");
        }
    }

}
