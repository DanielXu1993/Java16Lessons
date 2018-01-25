package codes0993LinkList;

// 单链表的实现
public class LinkList<T>
{
    // 定义一个内部类Node,Node实例表式链表的一个节点
    private class Node
    {
        // 当前节点中存储的数据
        private T data;

        //指向下一个节点的引用
        private Node next;

        public Node()
        {
        }

        public Node(T data, Node next)
        {
            this.data = data;
            this.next = next;
        }
    }

    // 链表的第一个节点，头结点
    private Node header;

    // 链表的最后一个节点，尾结点
    private Node tail;

    // 当前链表中的节点数
    private int size;

    // 创建空链表
    public LinkList()
    {
        header = null;
        tail = null;
    }

    // 以指定元素来创建链表，该链表只有一个元素
    public LinkList(T element)
    {
        header = new Node(element, null);
        tail = header;
        size++;
    }

    // 返回链表的长度
    public int length()
    {
        return size;
    }

    /**
     * 根据索引index获取指定位置的节点
     *
     * @param index 指定的索引
     * @return 当前位置的节点
     */
    private Node getNodeByIndex(int index)
    {
        if (index < 0 || index > size - 1)
        {
            throw new IndexOutOfBoundsException("线性表索引越界");
        }
        // 从头节点开始往后搜索
        Node current = header;
        for (int i = 0; i < size; i++)
        {
            if (i == index)
            {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // 获取索引index处的元素
    public T get(int index)
    {
        return getNodeByIndex(index).data;
    }

    // 查找元素element在链表中第一次出现的位置
    public int locate(T element)
    {
        Node current = header;
        for (int i = 0; i < size; i++)
        {
            if (current.data.equals(element))
            {
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    // 在链表的结尾插入新节点
    public void add(T element)
    {
        // 该链表为空链表时
        if (header == null)
        {
            header = new Node(element, null);
            // header和tail节点都指向该节点
            tail = header;
        }
        else
        {
            // 创建新节点
            Node newNode = new Node(element, null);
            // 让为节点的next指向新增的节点
            tail.next = newNode;
            // 以新节点作为新的尾节点
            tail = newNode;
        }
        // 链表的长度增1
        size++;
    }

    // 在链表的开头添加新的节点
    public void addAtHeader(T element)
    {
        // 创建新的节点，并让新节点指向之前的header
        // 并将新节点作为新的header
        header = new Node(element, header);
        // 如果在插入新节点之前的链表为空链表时
        // header 和 tail 都指向null
        if (tail == null)
        {
            // 此时链表只有一个新的元素
            // header 和 tail 都指向这个元素
            tail = header;
        }
        size++;
    }

    // 向链表的指定位置添加一个元素
    public void insert(T element, int index)
    {
        if (index < 0 || index > size)
        {
            throw new IndexOutOfBoundsException("线性表索引越界");
        }
        // 如果当前链表是空链表
        if (header == null)
        {
            add(element);
        }
        else
        {
            // 在链表的开头添加新元素
            if (index == 0)
            {
                addAtHeader(element);
            }
            else
            {
                // 获取插入点位置之前的节点
                Node prev = getNodeByIndex(index - 1);
                // 前一个节点指向新的节点
                // 新的节点指向之前前一个节点指向的位置
                prev.next = new Node(element, prev.next);
                size++;
            }
        }
    }

    // 删除链表中指定位置的节点
    public T delete(int index)
    {
        if (index < 0 || index > size - 1)
        {
            throw new IndexOutOfBoundsException("线性表索引越界");
        }
        // 被删除的节点
        Node del = null;
        // 删除header节点
        if (index == 0)
        {
            del = header;
            // 将头结点的下一个节点设置为新的头结点
            header = header.next;
        }
        else
        {
            // 获取要删除的节点之前的那个节点
            Node pre = getNodeByIndex(index - 1);
            // 要删除的节点是前一个节点指向的节点
            del = pre.next;
            // 将要删除的节点之前的那个节点指向要删除的节点之后的那个节点
            pre.next = del.next;
            // 将要删除的节点的next指向null
            del.next = null;
        }
        size--;
        return del.data;
    }

    // 删除链表中最后一个节点
    public T remove()
    {
        return delete(size - 1);
    }

    // 判断链表是否为空
    public boolean empty()
    {
        return size == 0;
    }

    // 清空链表
    public void clear()
    {
        header = null;
        tail = null;
        size = 0;
    }

    @Override
    public String toString()
    {
        if (empty())
        {
            return "[]";
        }
        else
        {
            StringBuilder sb = new StringBuilder("[");
            for (Node current = header; current != null; current = current.next)
            {
                sb.append(current.data.toString() + ",");
            }
            int len = sb.length();
            return sb.delete(len - 1, len).append("]").toString();
        }
    }
}