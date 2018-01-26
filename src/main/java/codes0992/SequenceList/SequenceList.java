package codes0992.SequenceList;

import java.util.Arrays;

public class SequenceList<T>
{
    // 线性表数组的默认长度
    private int DEFAULT_SIZE = 16;

    // 数组的实际长度
    private int capacity;

    // 定义一个数组用于保存顺序表中的元素
    private Object[] elementData;

    // 顺序表中当前元素的个数
    private int size = 0;

    // 以默认数组的长度创建空的顺序表
    public SequenceList()
    {
        capacity = DEFAULT_SIZE;
        elementData = new Object[capacity];
    }

    // 以一个初始化的元素创建顺序表
    public SequenceList(T element)
    {
        this();
        elementData[0] = element;
        size++;
    }

    /**
     * 指定顺序表数组的长度来创建顺序表
     *
     * @param element  顺序表中的第一个元素
     * @param initSize 顺序表底层数组的初始长度
     */
    public SequenceList(T element, int initSize)
    {
        capacity = 1;
        // 把capacity设置为大于initSize的最小的2的n次方
        while (capacity < initSize)
        {
            capacity <<= 1;
        }
        elementData = new Object[capacity];
        elementData[0] = element;
        size++;
    }

    // 获取顺序表中元素的个数
    public int length()
    {
        return size;
    }

    // 获取顺序表中索引为i的元素
    public T get(int i)
    {
        if (i < 0 || i > size - 1)
        {
            throw new IndexOutOfBoundsException("线性表索引越界");
        }
        return (T)elementData[i];
    }

    // 查找顺序表中元素第一次出现的位置，如果不存在返回-1
    public int locate(T element)
    {
        for (int i = 0; i < size; i++)
        {
            if (elementData[i].equals(element))
            {
                return i;
            }
        }
        return -1;
    }

    // 在指定位置处插入一个元素
    public void insert(T element, int index)
    {
        if (index < 0 || index > size)
        {
            throw new IndexOutOfBoundsException("线性表索引越界");
        }
        // 数组扩容
        ensureCapaticy(size + 1);
        // 将index处之后所有的元素向后移动一位
        // 复制数组: System.arraycopy(源数组,源数组中的起始位置,目标数组,目标数据中的起始位置,要复制的数组元素的数量)
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        // 在index处插入element
        elementData[index] = element;
        size++;
    }

    // 在顺序表的开始处添加一个元素
    public void add(T element)
    {
        insert(element, size);
    }

    // 如果当前的elementData数组已经存满了
    // 需要对elementData数组进行扩容
    private void ensureCapaticy(int minCapacity)
    {
        if (minCapacity > capacity)
        {
            while (capacity < minCapacity)
            {
                // 将当前的容量扩充两倍
                capacity <<= 1;
            }
            // 复制数组是的数组具备capacity长度，不足的用null补齐
            elementData = Arrays.copyOf(elementData, capacity);
        }
    }

    /**
     * 删除线性表中指定位置的元素
     *
     * @param index 指定要删除的元素的索引
     * @return 被删除的元素
     */
    public T delete(int index)
    {
        if (index < 0 || index > size - 1)
        {
            throw new IndexOutOfBoundsException("线性表索引越界");
        }
        // 记录要删除的元素
        T oldValue = (T)elementData[index];
        // 从index + 1 开始要向前移动的元素的个数
        int numMoved = size - index - 1;
        if (numMoved > 0) // 要删处的元素不是数组中最后一个元素
        {
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        }
        // 清空数组中最后一个元素并且将顺序表的长度 - 1
        elementData[--size] = null;
        // 返回删除的元素
        return oldValue;
    }

    // 删除线性表中最后一个元素
    public T delete()
    {
        return delete(size - 1);
    }

    // 判断线性表是否为空
    public boolean empty()
    {
        return size == 0;
    }

    // 清空线性表
    public void clear()
    {
        // Arrays.fill(Object[],object)将指定值object填充到Object[]的每一个元素
        Arrays.fill(elementData, null);
        size = 0;
    }
}
