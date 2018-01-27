package codes10102.LoopQueue;

import java.util.Arrays;

// 循环队列的实现
public class LoopQueue<T> {
    // 数组的默认长度
    private int DEFAULT_SIZE = 10;
    // 数组的实际长度
    private int capacity;
    // 用于保存循环队列元素的数组
    private Object[] elementData;
    // 保存最先出队列的元素的索引
    private int front = 0;
    // 保存即将进队列的第一个元素的索引
    private int rear = 0;

    // 以默认长度创建空的循环队列
    public LoopQueue() {
        capacity = DEFAULT_SIZE;
        elementData = new Object[capacity];
    }

    // 以指定初始化元素创建循环队列
    public LoopQueue(T element) {
        this();
        elementData[0] = element;
        rear++;
    }

    /**
     * 以指定长度的数组来创建循环队列
     *
     * @param element  指定循环队列中第一个元素
     * @param initSize 指定循环队列中底层的数组的长度
     */
    public LoopQueue(T element, int initSize) {
        this.capacity = initSize;
        elementData = new Object[capacity];
        elementData[0] = element;
        rear++;
    }

    // 判断循环队列是否为空队列
    public boolean empty() {
        // 循环队列为空时，front和rear重合，且当前索引下无数据
        // 循环队列为满时，front和rear重合，且当前索引下有数据
        return (front == rear) && (elementData[front] == null);
    }

    // 返回循环队列中数据的个数
    public int length() {
        if (empty()) {
            return 0;
        }
        // rear < front 时是rear又跨过了索引0的位置,而front由于不断
        // 有元素从循环队列中出去而导致不断增大
        return rear > front ? rear - front : capacity - (front - rear);
    }

    // 向循环队列中插入元素
    public void add(T element) {
        if ((front == rear) && (elementData[front] != null)) {
            throw new IndexOutOfBoundsException("循环队列已满");
        }
        elementData[rear] = element;
        rear++;
        // rear的范围是[0,capacity-1]
        // 插入元素后如果rear指向了capacity，将其设置为0
        rear = rear == capacity ? 0 : rear;
    }

    // 从队列中移除元素
    public T remove() {
        if (empty()) {
            throw new IndexOutOfBoundsException("空队列异常");
        }
        // 保存要移除的元素的值
        T oldValue = (T) elementData[front];
        // 将要移除的位置设置为null
        elementData[front] = null;
        // front指向下一个元素
        front++;
        // front的范围是[0,capacity-1]
        // 移除元素后如果front指向了capacity，将其设置为0
        front = front == capacity ? 0 : front;
        return oldValue;
    }

    // 获取队列顶端的元素，但不删除
    public T element() {
        if (empty()) {
            throw new IndexOutOfBoundsException("空队列异常");
        }
        return (T) elementData[front];
    }

    // 清空循环队列
    public void clear() {
        Arrays.fill(elementData, null);
        front = 0;
        rear = 0;
    }
}
