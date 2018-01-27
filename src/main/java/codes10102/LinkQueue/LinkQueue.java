package codes10102.LinkQueue;

// 链队列的实现
public class LinkQueue<T> {
    //定义一个内部类Node，表示链队列的一个节点
    private class Node {
        // 节点中的数据
        private T data;
        // 指向下一个节点的引用
        private Node next;

        public Node() {
        }

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    // 链队列的头结点
    private Node front;
    // 链队列的尾结点
    private Node rear;
    // 链队列中的节点数
    private int size;

    // 创建空链队列
    public LinkQueue() {
        front = null;
        rear = null;
    }

    // 以指定元素创建链队列
    public LinkQueue(T element) {
        // 该链队列只有一个元素，rear和front都指向该节点
        rear = new Node(element, null);
        front = rear;
        size++;
    }

    // 返回该链队列的长度
    public int length() {
        return size;
    }

    // 向链队列添加数据元素
    public void add(T element) {
        // 当链队列为空时
        if (front == null) {
            rear = new Node(element, null);
            front = rear;
        } else {
            Node newNode = new Node(element, null);
            // 原rear的next指向新添加的节点
            rear.next = newNode;
            // 新添加的节点成为新的rear节点
            rear = newNode;
        }
        size++;
    }

    // 删除链队列中front节点
    public T remove() {
        // 保存要删除的front节点
        Node oldFront = front;
        // front的next节点成为新的front节点
        front = front.next;
        // 原front的next指向null
        oldFront.next = null;
        size--;
        return oldFront.data;
    }

    // 获取链队列中第一个元素，不删除
    public T element() {
        if (front == null) {
            throw new IndexOutOfBoundsException("空链队列异常");
        }
        return front.data;
    }

    // 判断链队列是否为空
    public boolean empty() {
        return size == 0;
    }

    // 清空链队列
    public void clear() {
        front = null;
        rear = null;
        size = 0;
    }

    @Override
    public String toString() {
        if (empty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        for (Node current = front; current != null; current = current.next) {
            sb.append(current.data.toString() + ",");
        }
        int len = sb.length();
        return sb.delete(len - 1, len).append("]").toString();
    }
}
