package codes10101.LinkStack;

// 链栈的实现
public class LinkStack<T>
{
    // 定义内部类Node，代表一个链栈的节点
    private class Node
    {
        // 节点的数据
        private T data;

        // 指向下一个节点
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

    // 该链栈的栈顶元素
    private Node top;

    // 链栈中的Node的个数
    private int size;

    public LinkStack()
    {
        // 空链栈，top为空
        top = null;
    }

    // 以指定元素element来创建链栈
    public LinkStack(T element)
    {
        // 链栈中bottom元素的next指向null
        top = new Node(element, null);
        size++;
    }

    // 返回链栈的长度
    public int length()
    {
        return size;
    }

    // 进栈
    public void push(T element)
    {
        // 新的节点的next指向原来的top节点
        // 新的节点成为新的top节点
        top = new Node(element, top);
        size++;
    }

    // 弹栈
    public T pop()
    {
        Node oldTop = top;
        // 让原来的top节点的下一个节点成为新的top节点
        top = top.next;
        // 将原来的top节点的next引用置null
        oldTop.next = null;
        size--;
        return oldTop.data;
    }

    // 访问栈顶元素，但不删除
    public T peek()
    {
        return top.data;
    }

    // 判断链栈是否为空
    public boolean empty()
    {
        return size == 0;
    }

    // 清空链栈
    public void clear()
    {
        top = null;
        size = 0;
    }

    @Override
    public String toString()
    {
        if (empty())
        {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        for (Node current = top; current != null; current = current.next)
        {
            sb.append(current.data.toString() + ",");
        }
        int len = sb.length();

        return sb.delete(len - 1, len).append("]").toString();
    }
}
