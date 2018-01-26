package codes10101.SequenceStack;

import java.util.Arrays;

// 顺序栈的实现
public class SequenceStack<T> {
    // 初始化默认的底层数组的长度
    private int DEFAULT_SIZE = 10;

    // 数组的实际长度
    private int capacity;

    // 当底层的数组的长度不够时，每次增加的长度
    private int capacityIncrease = 0;

    // 用于保存顺序栈的数组
    private Object[] elementData;

    // 顺序栈中元素的个数
    private int size = 0;

    // 以默认数组的长度创建空的顺序栈
    public SequenceStack() {
        capacity = DEFAULT_SIZE;
        elementData = new Object[capacity];
    }

    // 以一个初始化元素来创建顺序栈
    public SequenceStack(T element) {
        this();
        elementData[0] = element;
        size++;
    }

    // 返回顺序栈的长度
    public int length() {
        return size;
    }

    /**
     * 确保底层的数组的长度够用
     *
     * @param minCapacity 底层数组最少需要的长度
     */
    private void ensureCapacity(int minCapacity) {
        // 如果数组的长度小于所需要的长度
        if (capacity < minCapacity) {
            // capacityIncrease可以通过构造函数指定，此处省略了一些构造器
            if (capacityIncrease > 0) {
                // 不断的将capacity的长度增加capacityIncrease
                // 直到capacity大于minCapacity为止
                while (capacity < minCapacity) {
                    capacity += capacityIncrease;
                }
            } else {
                // 将capacity长度扩充为之前的两倍
                while (capacity < minCapacity) {
                    capacity <<= 1;
                }
            }
            // 复制数组使得数组具备capacity长度，不足的用null补齐
            elementData = Arrays.copyOf(elementData, capacity);
        }
    }

    // 数据元素入栈
    public void push(T element) {
        ensureCapacity(size + 1);
        elementData[size] = element;
        size++;
    }

    // 数据元素出栈(弹栈,删除栈顶元素)
    public T pop() {
        T oldValue = (T) elementData[size - 1];
        elementData[size - 1] = null;
        size--;
        return oldValue;
    }

    // 返回栈顶元素，但不删除
    public T peek() {
        return (T) elementData[size - 1];
    }

    // 判断顺序栈是否为空
    public boolean empty() {
        return size == 0;
    }

    // 清空顺序栈
    public void clear() {
        Arrays.fill(elementData, null);
        size = 0;
    }

    @Override
    public String toString() {
        if (empty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        for (int i = size - 1; i >= 0; i--) {
            sb.append(elementData[i].toString() + ",");
        }
        int len = sb.length();
        return sb.delete(len - 1, len).append("]").toString();
    }
}
