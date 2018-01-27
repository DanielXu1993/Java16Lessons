package codes10102.SequenceQueue;

import java.util.Arrays;

// 顺序队列的实现
public class SequenceQueue<T> {
    // 数组的默认长度
    private int DEFAULT_SIZE = 10;
    // 数组的实际长度
    private int capacity;
    // 保存顺序队列中的元素
    private Object[] elementData;
    // 保存顺序队列中最先进入队列的元素的索引
    private int front = 0;
    // 保存顺序队列中下一个进入队列的元素的索引
    private int rear = 0;

    public SequenceQueue() {
        capacity = DEFAULT_SIZE;
        elementData = new Object[capacity];
    }

    // 以指定初始化元素来创建顺序队列
    public SequenceQueue(T element) {
        this();
        elementData[0] = element;
        // rear 指向下一个进入队列的元素的索引
        rear++;
    }

    // 获取队列中元素的个数
    public int length() {
        return rear - front;
    }

    // 判断顺序队列是否为空
    public boolean empty() {
        return length() == 0;
    }

    // 在rear处插入元素
    public void add(T element) {
        if (rear > capacity - 1) {
            throw new IndexOutOfBoundsException("队列已满的异常");
        }
        elementData[rear] = element;
        rear++;
    }

    // 移除front端的第一个元素
    public T remove() {
        if (empty()) {
            throw new IndexOutOfBoundsException("空队列异常");
        }
        T oldValue = (T) elementData[front];
        elementData[front] = null;
        front++;
        return oldValue;
    }

    // 返回队列顶端元素但不删除
    public T element() {
        if (empty()) {
            throw new IndexOutOfBoundsException("空队列异常");
        }
        return (T) elementData[front];
    }

    // 清空队列
    public void clear() {
        Arrays.fill(elementData, null);
        front = 0;
        rear = 0;
    }

    @Override
    public String toString() {
        if (empty()) {
            return "[]";
        } else {
            StringBuilder sb = new StringBuilder("[");
            for (int i = front; i < rear; i++) {
                sb.append(elementData[i] + ",");
            }
            int len = sb.length();
            return sb.delete(len - 1, len).append("]").toString();
        }

    }
}
